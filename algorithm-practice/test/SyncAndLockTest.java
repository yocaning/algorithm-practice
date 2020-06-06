package test;

import com.yocan.tencent.discuss.SyncAndLock;
import org.junit.Test;

public class SyncAndLockTest {

    private SyncAndLock syncAndLock =new SyncAndLock();


    /**
     * 6142
     * @throws InterruptedException
     */
    @Test
    public void SyncTest() throws InterruptedException {
        long start1 =System.currentTimeMillis();
        syncAndLock.threadsExecute(2000,true);
        long end1 =System.currentTimeMillis();
        System.out.println("sync耗时-"+(end1-start1) +"->"+System.currentTimeMillis());
    }

    /**
     * 6005
     * @throws InterruptedException
     */
    @Test
    public void SyncTest1() throws InterruptedException {
        long start1 =System.currentTimeMillis();
        syncAndLock.threadsExecute(2000,true);
        long end1 =System.currentTimeMillis();
        System.out.println("sync耗时-"+(end1-start1) +"->"+System.currentTimeMillis());
    }

    /**
     * 5974
     * @throws InterruptedException
     */
    @Test
    public void SyncTest2() throws InterruptedException {
        long start1 =System.currentTimeMillis();
        syncAndLock.threadsExecute(2000,true);
        long end1 =System.currentTimeMillis();
        System.out.println("sync耗时-"+(end1-start1) +"->"+System.currentTimeMillis());
    }

    /**
     * 6025
     * @throws InterruptedException
     */
    @Test
    public void SyncTest3() throws InterruptedException {
        long start1 =System.currentTimeMillis();
        syncAndLock.threadsExecute(2000,true);
        long end1 =System.currentTimeMillis();
        System.out.println("sync耗时-"+(end1-start1) +"->"+System.currentTimeMillis());
    }

    /**
     * 去掉打印语句
     * 5359
     */
    @Test
    public void SyncTest4() throws InterruptedException {
        long start1 =System.currentTimeMillis();
        syncAndLock.threadsExecute(2000,true);
        long end1 =System.currentTimeMillis();
        System.out.println("sync耗时-"+(end1-start1) +"->"+System.currentTimeMillis());
    }

    /**
     * 去掉打印语句
     * 2000线程-5941
     * @throws InterruptedException
     */
    @Test
    public void SyncTest5() throws InterruptedException {
        long start5 =System.currentTimeMillis();
        syncAndLock.threadsExecute(2000,true);
        long end5 =System.currentTimeMillis();
        System.out.println("sync耗时-"+(end5-start5) +"->"+System.currentTimeMillis());
    }

    /**
     * 2000线程-5427
     * @throws InterruptedException
     */
    @Test
    public void LockTest2000() throws InterruptedException {
        long start2 =System.currentTimeMillis();
        syncAndLock.threadsExecute(2000,false);
        long end2 =System.currentTimeMillis();
        System.out.println("Lock耗时-"+(end2-start2) +"->"+System.currentTimeMillis());
    }

    /**
     * 4000线程-10502
     * @throws InterruptedException
     */
    @Test
    public void LockTest4000() throws InterruptedException {
        long start2 =System.currentTimeMillis();
        syncAndLock.threadsExecute(4000,false);
        long end2 =System.currentTimeMillis();
        System.out.println("Lock耗时-"+(end2-start2) +"->"+System.currentTimeMillis());
    }


    /**
     * 4000线程-11350
     * @throws InterruptedException
     */
    @Test
    public void SyncTest4000() throws InterruptedException {
        long start2 =System.currentTimeMillis();
        syncAndLock.threadsExecute(4000,true);
        long end2 =System.currentTimeMillis();
        System.out.println("sync耗时-"+(end2-start2) +"->"+System.currentTimeMillis());
    }


}
