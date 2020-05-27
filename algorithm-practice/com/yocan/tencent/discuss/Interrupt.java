package com.yocan.tencent.discuss;

/**
 * @author liuyongkang
 * interrupt是一个线程中断位
 * isInterrupted底层调用的isInterrupted(false);
 * Thread.interrupted();底层调用的是isInterrupted(true);
 * 一个不清除中断位
 * 一个清除中断位
 */
public class Interrupt {

    private Thread thread =new Thread("yocan-thread"){
        @Override
        public void run(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("catch"+Thread.currentThread().isInterrupted());

            }
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println(1);
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().isInterrupted());
            Thread.interrupted();
            System.out.println(Thread.currentThread().isInterrupted());

        }
    };

    public static void main(String[] args) {
        Interrupt interrupt =new Interrupt();
        interrupt.thread.start();
        interrupt.thread.interrupt();
    }
}
