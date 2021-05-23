package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 有三个线程ID分别是A、B、C,请用多线编程实现，在屏幕上循环打印10次ABCABC
 *
 * @author drone
 * @date 2021/5/14
 */
public class TestPrint {
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
        private List<Character> charList = new ArrayList<>();
        private int cuurentIndex = 0;
        private int countLimit = 10;
        private int currentCount = 0;

        public Character currentChar() {
            int i = cuurentIndex % charList.size();
            int c = cuurentIndex / charList.size();
            if (i == 0 && c != 0) {
                currentCount++;
                cuurentIndex = 0;
                if (currentCount >= countLimit) {
                    currentCount = -1;
                    return null;
                }
                System.out.println();
            }
            return charList.get(i);
        }

        public void addChar(char character) {
            charList.add(character);
        }

    }

    static class Thread_ABC implements Runnable {

        private MajusculeABC maj;
        private char c;

        public Thread_ABC(MajusculeABC maj, char c) {
            maj.addChar(c);
            this.maj = maj;
            this.c = c;
        }


        @Override
        public void run() {
            while (true) {
                synchronized (maj) {
                    if (maj.currentCount < 0) {
                        maj.notifyAll();
                        System.out.println();
                        break;
                    }
                    if (Objects.equals(maj.currentChar(), this.c)) {
                        System.out.print(c);
                        maj.cuurentIndex++;
                    }
                    try {
                        maj.notifyAll();
                        maj.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
