package thread;

import sun.awt.windows.ThemeReader;

/**
 * 测试线程yield 的方法
 * yield() 与sleep()方法类似， 但是不会让线程进入阻塞状态
 */
public class YieldTest extends Thread {
    public YieldTest(String name){
        super(name);
    }
    @Override
    public void run(){
        for (int i = 0; i < 50; i++) {
            System.out.println(getName()+" "+i);
            if (i == 20){
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        YieldTest y2 = new YieldTest("低级");
        y2.setPriority(MIN_PRIORITY);
        y2.start();
        YieldTest y1 = new YieldTest("高级");
        y1.setPriority(MAX_PRIORITY);
        y1.start();


    }
}
