package com.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWindow extends JFrame
{

    private JLabel clockLabel;

    private final Font font=new Font("",Font.ITALIC,30);

    MyWindow()
    {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               dispose();
               System.exit(0);
//                super.windowClosing(e);
            }
        });
        super.setTitle("My clock");
        super.setSize(250, 200);
        super.setLocation(300,50);
        this.createGUI();
        super.setVisible(true);
    }

    public void createGUI()
    {
        JLabel heading = new JLabel("My clock");
        clockLabel=new JLabel("clock");


        heading.setFont(font);
        clockLabel.setFont(font);

        startClock();


        this.setLayout(new GridLayout(2,1));

        this.add(heading);

        this.add(clockLabel);
    }

    public void startClock()
    {
//        Timer timer=new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                String dateTime=new Date().toString(); to get date formatted as string
//
////                String dateTime=new Date().toLocaleString(); to get date formatted as string according to local time(not customizable)
//
//                Date d=new Date();
//
//                SimpleDateFormat sfd=new SimpleDateFormat("hh : mm : ss a");
//
//                String dateTime=sfd.format(d);
//
//                clockLabel.setText(dateTime);
//            }
//        });
//
//        timer.start();

//        same thing but using threads

        Thread thread=new Thread(){
            public void run()
            {
                try{
                    while(true)
                    {
                        Date d=new Date();

                        SimpleDateFormat sfd=new SimpleDateFormat("hh : mm : ss a");

                        String clockTime=sfd.format(d);

                        clockLabel.setText(clockTime);

//                        Thread.sleep(1000);
//                        or we can write
                        Thread.currentThread().sleep(1000);
                    }
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
        };

        thread.start();
    }
}
