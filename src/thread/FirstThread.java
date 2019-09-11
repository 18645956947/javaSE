package thread;

/**
 * 创建线程的第一种方式，直接继承Thread  重写run方法 new继承类的对象，调用start方法
 */
public class FirstThread extends Thread{
    private int i;
    @Override
    public void run(){
        for (; i < 100; i++) {
            System.out.println(getName() + " "+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());
            if(i == 20){
                new FirstThread().start();
                new FirstThread().start();
            }
        }
    }
}
