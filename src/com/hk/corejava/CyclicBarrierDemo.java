package com.hk.corejava;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
public class CyclicBarrierDemo
{
    public static void main(String args[])
    {
//creating a constructor of the CyclicBarrier class
        CyclicBarrier cb = new CyclicBarrier(6, new AfterAction());
//initializing three threads to read 3 different files
        Thread t1 = new Thread(new TxtReader("thread-1", "file-1", cb));
        Thread t2 = new Thread(new TxtReader("thread-2", "file-2", cb));
        Thread t3 = new Thread(new TxtReader("thread-3", "file-3", cb));
        Thread t6 = new Thread(new TxtReader("thread-6", "file-6", cb));
        Thread t4 = new Thread(new TxtReader("thread-4", "file-4", cb));
        Thread t5 = new Thread(new TxtReader("thread-5", "file-5", cb));
//start begin execution of threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        System.out.println("Done ");
    }
}
class TxtReader implements Runnable
{
    private String threadName;
    private String fileName;
    private CyclicBarrier cb;
    TxtReader(String threadName, String fileName, CyclicBarrier cb)
    {
        this.threadName = threadName;
        this.fileName = fileName;
        this.cb = cb;
    }
    @Override
    public void run()
    {
        System.out.println("Reading file " + fileName + " thread " + threadName);
        try
        {
//calling await() so the current thread may suspends
            cb.await();
        }
        catch (InterruptedException e)
        {
            System.out.println(e);
        }
        catch (BrokenBarrierException e)
        {
            System.out.println(e);
        }
    }
}
class AfterAction implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("In after action class, start further processing as all files are read");
    }
}