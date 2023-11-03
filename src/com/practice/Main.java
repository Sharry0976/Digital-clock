package com.practice;

public class Main {
    public static void main(String[] args) {
        Thread thr= new Thread(() -> {
            try{
            System.out.println("Hello World");
            Thread.sleep(1000);
            }
            catch( Exception e)
            {
                e.printStackTrace();
            }
        });

        thr.start();

        MyWindow w=new MyWindow();
    }
}
