package thread.producer_consumer_02;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;

public class BlockingQueueTest3 {

    class Producer extends Thread{

        public BlockingQueue<String> bq;
        public Producer(BlockingQueue<String> queue){
            this.bq = queue;
        }

        @Override
        public void run(){
            String product_name = Thread.currentThread().getName();
            System.out.println("我已经生产了"+Thread.currentThread().getName());
            try {
                bq.put(product_name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Consumer extends Thread{
        BlockingQueue<String> bq;

        public Consumer(BlockingQueue<String> bq){
            this.bq = bq;
        }
        @Override
        public void run(){
            try {
                String product_name = bq.take();
                System.out.println("消费了："+product_name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<String> bq = new LinkedBlockingDeque<>(1);
        BlockingQueueTest3 bb = new BlockingQueueTest3();
        for (int i = 0; i < 5; i++) {
            bb.new Producer(bq).start();
            bb.new Consumer(bq).start();
        }
    }
}
