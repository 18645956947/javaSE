package thread.面试题;

/**
 * 建立三个线程A、B、C，
 * A线程打印10次字母A，B线程打印10次字母B,C线程打印10次字母C，
 * 但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印。
 * @author zhx
 */
public class ABC_Synch_01 {
    public static class ThreadPrinter implements Runnable{

        private String name;
        private Object prev;
        private Object self;

        public ThreadPrinter(String name, Object prev, Object self){
            this.name = name;
            this.prev = prev;
            this.self = self;
        }
        @Override
        public void run() {
            int count = 10;
            while (count > 0){
                synchronized (prev){
                    synchronized(self){
                        System.out.print(name);
                        count--;

                        self.notifyAll();
                    }
                    try {
                        if(count == 0){
                            prev.notifyAll();
                        }else
                            prev.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPrinter pa = new ThreadPrinter("A", c, a);
        ThreadPrinter pb = new ThreadPrinter("B", a, b);
        ThreadPrinter pc = new ThreadPrinter("C", b, c);
        new Thread(pa).start();
        Thread.sleep(10);
        new Thread(pb).start();
        Thread.sleep(10);
        new Thread(pc).start();
        Thread.sleep(10);

    }
}
