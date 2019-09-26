package thread.面试题;

import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 *
 * 使用wait和notify/notifyAll来实现
 *
 * 使用Lock和Condition来实现
 * 对比两种方式，Condition的方式可以更加精确的指定哪些线程被唤醒
 * @author zhx
 *
 */
public class MyContainer2<T> {
    private final LinkedList<T> list = new LinkedList<>();
    private final int MAX = 10;//最多10个元素
    private int count = 0;//记录元素个数

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t){
        lock.lock();
        while (list.size() == MAX){
            try {
                producer.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        count++;
        consumer.signal();
    }
    public T get(){
        T t = null;
        while (list.size() <= 0){
            try {
                consumer.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count--;
        consumer.signalAll();
        return t;
    }

    public static void main(String[] args) {

    }

}
