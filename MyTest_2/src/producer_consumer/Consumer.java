package producer_consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2018/03/15 0015.
 */
public class Consumer implements Runnable {

    private BlockingQueue<PCData> queue;
    private volatile boolean isRunning = true;
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    public void run(){
        PCData data = null;
        Random r = new Random();
        try {
            while (isRunning) {
                data = queue.take();
                if (data != null){
                    System.out.println(" get Data is " + data);
                    Thread.sleep(r.nextInt(SLEEPTIME));
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
