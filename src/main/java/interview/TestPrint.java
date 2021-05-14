package interview;

import java.util.LinkedList;
import java.util.Objects;

/**
 * 有三个线程ID分别是A、B、C,请用多线编程实现，在屏幕上循环打印10次ABCABC
 *
 * @author drone
 * @date 2021/5/14
 */
public class TestPrint {
    private static final int limit = 10;

    public static void main(String[] args) {
        MajusculeABC maj = new MajusculeABC();
        //Thread(Runnable target)
        Thread threadA = new Thread(new Thread_ABC(maj, 'A'));
        Thread threadB = new Thread(new Thread_ABC(maj, 'B'));
        Thread threadC = new Thread(new Thread_ABC(maj, 'C'));
        threadA.start();
        threadB.start();
        threadC.start();
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

        public Thread_ABC(MajusculeABC maj, char c) {
            maj.add(c);
            this.maj = maj;
            this.c = c;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (maj) {
                    if (maj.currentLoop < 0) {
                        maj.notifyAll();
                        break;
                    } else {
                        if (Objects.equals(maj.currentChar(), this.c)) {
                            System.out.print(c);
                            maj.idx++;
                        }
                        try {
                            //maj.wait();
                            maj.notifyAll();
                            maj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
