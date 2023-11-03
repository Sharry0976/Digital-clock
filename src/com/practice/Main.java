package com.practice;

public class Main {
    public static void main(String[] args) {
        Thread thr=new Thread()
        {
            public void run()
            {
                try{
                System.out.println("Hello World");
                Thread.currentThread().sleep(1000);
                }
                catch( Exception e)
                {
                    e.printStackTrace();
                }
            }
        };

        thr.start();

        MyWindow w=new MyWindow();
    }
}
