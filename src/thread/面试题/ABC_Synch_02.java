package thread.面试题;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 建立三个线程A、B、C，
 * A线程打印10次字母A，B线程打印10次字母B,C线程打印10次字母C，
 * 但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印。
 * @author zhx
 */
public class ABC_Synch_02 {
    private static Lock lock = new ReentrantLock();
    private static int state = 0;

    static class ThreadA extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10;) {
                try{
                    lock.lock();
                    while (state % 3 == 0){
                        System.out.print("A");
                        state++;
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    static class ThreadB extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10;) {
                try{
                    lock.lock();
                    while (state % 3 == 1){
                        System.out.print("B");
                        state++;
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadC extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10;) {
                try{
                    lock.lock();
                    while (state % 3 == 2){
                        System.out.print("C");
                        state++;
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
