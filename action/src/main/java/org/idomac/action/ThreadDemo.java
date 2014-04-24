package org.idomac.action;

/**
 * @author : lihaoquan
 */
public class ThreadDemo {

    private int j;

    private synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName()+"-inc:"+j);
    }

    private synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName()+"-dec:"+j);
    }


    public static void main(String[] args) {

        ThreadDemo threadDemo = new ThreadDemo();
        Inc inc = threadDemo.new Inc();
        Dec dec = threadDemo.new Dec();

        for(int i = 0;i<2;i++) {
            Thread thread = new Thread(inc);
            thread.start();
            thread = new Thread(dec);
            thread.start();
        }
    }

    class Inc implements Runnable {

        @Override
        public void run() {
            for(int i = 0; i<100;i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable {

        @Override
        public void run() {
            for(int i = 0; i< 100;i++) {
                dec();
            }
        }
    }
}
