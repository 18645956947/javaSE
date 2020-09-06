package lock;

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MyThread implements Runnable{

    MyLock myLock = new MyLock();
    Date date = new Date();
    public int i = 0;
    @Override
    public void run() {
        try {
            myLock.lock();
            //TimeUnit.SECONDS.sleep(3);
            i++;
            System.out.println(Thread.currentThread().getName() + "\t" + "i的值为:" + i);
        } finally {
            myLock.unlock();
        }
    }
}
