package thread;

/**
 * 创建线程的第二种方式：先用实现Runnable接口的实现类的对象，
 * 作为new Thread 的构造函数的变量，第二个参数是线程的名字
 */
public class SecondThread implements Runnable{
    private int i;
    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() +" "+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i == 10){
                SecondThread st = new SecondThread();
                new Thread(st, "新线程1").start();
                new Thread(st, "新线程2").start();
            }
        }
    }
}
