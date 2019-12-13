package lock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;

/**
 * 乐观锁
 */
public class OptimisticLock {
    public int data = 123;
    boolean flag = true;
    public void setData(int newData){
        while (flag){
            int oldDate = data;
            newData = newData + 1;

            //下面的就是CAS操作
            if(data == oldDate){
                data = newData;
                flag = false;
            }else{
                //啥也不干，再次循环  直到满足
            }
        }
    }

    List a = new LinkedList<>();
    List b = new ArrayList();
}
