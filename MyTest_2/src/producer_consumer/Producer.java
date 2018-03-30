package producer_consumer;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/03/15 0015.
 */
public class Producer implements Runnable {
    BlockingQueue<PCData> queue ;
    private volatile boolean isRunning = true;
    private final  static int SLEEPTIME = 1000;

    public Producer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    public void run(){
        PCData data = null;
        Random r = new Random();
        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(SLEEPTIME));
                AtomicInteger count = new AtomicInteger();
                data = new PCData(count.incrementAndGet());
                if (queue.offer(data, 2, TimeUnit.SECONDS)){
                    System.out.println("fail to add elements");
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop(){
        isRunning = false;
    }
}
