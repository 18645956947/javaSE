package thread.producer_consumer_01;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{

    private BlockingQueue<String> bq;
    public Producer(BlockingQueue<String> bq){
        this.bq = bq;
    }
    @Override
    public void run(){
        String[] strArr = new String[]{
                "java",
                "Struts",
                "Spring"
        };
        for (int i = 0; i < 99999999; i++) {
            System.out.println(getName()+"生产者准备生产集合元素");
            try{
                Thread.sleep(200);
                bq.put(strArr[i % 3]);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(getName()+"生产完成"+bq);
        }
    }
}
class Consumer extends Thread{
    private BlockingQueue<String> bq;
    public Consumer(){}
    public Consumer(BlockingQueue<String> bq){
        this.bq = bq;
    }
    @Override
    public void run(){
        System.out.println(getName()+"消费者开始消费集合元素"+bq);
        try {
            Thread.sleep(200);
            bq.take();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(getName()+"消费完成"+bq);
    }

}
