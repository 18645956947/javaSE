package thread.面试题;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 面试题：写一个固定容量同步容器，拥有Put和get方法，以及getCount方法，
 * 能够支持两个生产者线程以及10个消费者线程的阻塞调用
 *
 * 使用wait和notify/notifyAll来实现
 * @author zhx
 *
 */
public class MyContainer1<T> {
    private final LinkedList<T> list = new LinkedList<>();
    private final int MAX = 10;//最多10个元素
    private int count = 0;//记录元素个数

    public synchronized void put(T t){
        while (list.size() == MAX){  //想想为什么用while而不是用if
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        count++;
        this.notifyAll();
    }
    public synchronized T get(){

        while (list.size() <= 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = list.removeFirst();
        count--;
        notifyAll();
        return t;
    }

    public synchronized int getCount(){
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer1<String> c = new MyContainer1<>();
        //启动消费者线程
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    System.out.println(c.get());
                }
            }, "c"+i).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //启动生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 25; j++) {
                    c.put(Thread.currentThread().getName()+""+j);
                }
            }, "p" + i).start();
        }
    }
}
