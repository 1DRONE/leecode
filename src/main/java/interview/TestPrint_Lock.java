package interview;

import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有三个线程ID分别是A、B、C,请用多线编程实现，在屏幕上循环打印10次ABCABC
 * <p>
 * ReentryLock+Condition
 *
 * @author drone
 * @date 2021/5/14
 */
public class TestPrint_Lock {
    private static final int limit = 10;

    public static void main(String[] args) throws InterruptedException {
        MajusculeABC maj = new MajusculeABC();
        Lock lock = new ReentrantLock();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,
                3,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        executor.submit(new Thread_ABC(maj, 'A',lock, lock.newCondition()));
        executor.submit(new Thread_ABC(maj, 'B',lock, lock.newCondition()));
        executor.submit(new Thread_ABC(maj, 'C',lock, lock.newCondition()));

        executor.shutdown();
    }

    static class MajusculeABC {
        LinkedList<Character> list = new LinkedList<>();
        int idx = 0;
        //打印最大次数
        int loopCountMax = 10;
        //当前打印次数
        int currentLoop = 0;

        public Character currentChar() {
            int i = idx % list.size();
            int c = idx / list.size();
            if (i == 0 && idx != 0) {
                currentLoop += c;
                idx = 0;
                if (currentLoop >= loopCountMax) {
                    currentLoop = -1;
                    System.out.println();
                    return null;
                }
                System.out.println();
            }
            return list.get(i);
        }

        public void add(Character character) {
            list.add(character);
        }
    }

    static class Thread_ABC implements Runnable {
        MajusculeABC maj;
        Character c;
        Lock lock;
        Condition condition;

        public Thread_ABC(MajusculeABC maj, char c,Lock lock,Condition condition) {
            maj.add(c);
            this.maj = maj;
            this.c = c;
            this.lock=lock;
            this.condition=condition;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (maj.currentLoop < 0) {
                        condition.signalAll();
                        break;
                    } else {
                        if (Objects.equals(maj.currentChar(), this.c)) {
                            System.out.print(c);
                            maj.idx++;
                        }
                        condition.signalAll();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
