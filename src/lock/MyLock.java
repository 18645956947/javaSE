package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;



public class MyLock implements Lock {
    private MySync mySync = new MySync();

    @Override
    public void lock() {
        mySync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return mySync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return mySync.tryAcquireNanos(1, time);
    }

    @Override
    public void unlock() {
        mySync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    private static class MySync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg){
            if(arg != 1){
                throw new RuntimeException("args 不为1");
            }
            if(compareAndSetState(0, 1)){
                return true;
            }
            return false;
        }
        @Override
        public boolean tryRelease(int args){
            if(getState() == 0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        public boolean isHeldExclusively(){
            return getState() == 1;
        }

    }

}
