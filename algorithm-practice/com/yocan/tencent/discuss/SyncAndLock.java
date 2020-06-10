package com.yocan.tencent.discuss;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuyongkang
 * 测试synchronized和lock的性能对比
 * 先抛出自己的假设：我觉得应该性能相差无几
 * 1.在1000个线程时
 *  Lock耗时-23295
 *  sync耗时-23413
 * 2.在2000个线程时
 *  sync耗时-46983
 *  Lock耗时-47116
 * 3.在4000线程时
 * （一）
 *  sync耗时-95317
 *  Lock耗时-92975
 * （二）
 *  sync耗时-95022
 *  Lock耗时-93960
 * 有一个小细节
 *    1.sync的线程是倒序的，也就是后创建的会先执行，而lock则是按照创建顺序，也就是进入堵塞等待的顺序
 *      原因猜测应该是由于先创建的线程已经进入挂起状态，jvm优化暂时不去唤醒其他线程，先优先没有挂起的线程处理了，
 *      所以通过这个又猜测，在竞争激烈的时候，线程有些许间隔先后创建的时候，应该sync性能要提高一些
 * 4.4000线程时sync与公平锁对比
 *  sync耗时-95298
 *  Lock耗时-93389
 * 4.4000线程时sync与公平锁对比（线程间隔创建）猜测结论：间隔创建时，能避免一些sync唤醒的操作（内核态）所以sync时间减少了
 *  sync耗时-94422
 *  Lock耗时-94260
 * 5.交换执行顺序，先执行lock后执行sync
 *  Lock耗时-93607
 *  sync耗时-95091
 * 6.final对象
 *  sync耗时-94146
 *  Lock耗时-93851
 * 7.加大执行间隔为40ms
 *  sync耗时-175692
 *  Lock耗时-174273
 *
 *  由于单机能创建线程有限，所以无法继续测试
 *
 *  切换jdk5 sync耗时-83164->1590249194393
 *  Lock耗时-82935->1590249277328
 *
 * sync耗时-95375->1590374807323
 * Lock耗时-92946->1590374900269
 *
 *  感觉有问题
 *
 */
public class SyncAndLock {

    static {
        System.out.println(System.currentTimeMillis());
        final CountDownLatch endCountDownLatch =new CountDownLatch(1);
    }

    private static ReentrantLock reentrantLock =new ReentrantLock(true);

    private void addMethodBySync() throws InterruptedException {
        synchronized(this){
            //模拟耗时
            Thread.sleep(2);
        }
    }

    private void addMethodByLock(){
        reentrantLock.lock();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * 创造多个线程=线程并发
     */
    public  void threadsExecuteCurrent(int threadNum, final boolean method) throws InterruptedException {
        final CountDownLatch endCountDownLatch =new CountDownLatch(threadNum);
        final CountDownLatch countDownLatch =new CountDownLatch(1);
        for (int i=0;i<threadNum;i++){
            new Thread(){
                @Override
                public void run(){
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    exeMethod(method);
                    endCountDownLatch.countDown();
                }
            }.start();
        }

        System.out.println("执行"+method);
        countDownLatch.countDown();
        endCountDownLatch.await();
    }

    /**
     * 创造多个线程,不一起
     */
    public  void threadsExecute(int threadNum, final boolean method) throws InterruptedException {
        final CountDownLatch endCountDownLatch =new CountDownLatch(threadNum);
        for (int i=0;i<threadNum;i++){
            new Thread(){
                @Override
                public void run(){
                    exeMethod(method);
                    endCountDownLatch.countDown();
                }
            }.start();
        }

        System.out.println("执行"+method);
        endCountDownLatch.await();
    }

    private void exeMethod(boolean method){
        if (method){
            try {
                addMethodBySync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            addMethodByLock();
        }
    }
}
