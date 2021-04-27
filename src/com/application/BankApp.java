package com.application;

import javax.swing.*;
import java.awt.*;

public class BankApp{

    JFrame frame = new JFrame("Banking Application");


    public BankApp() throws InterruptedException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(61, 61, 61));
        frame.setSize(400, 700);
        frame.setResizable(false);
        loginpage login = new loginpage();
        frame.getContentPane().add(login.page_login);
        frame.setVisible(true);
        boolean registerpath = false;
        String registername = "jamees";
        int registerPIN = 0;
//        while(!login.isAuthorized){
//            if (login.toregister){
//                frame.getContentPane().removeAll();
//                registerpage register = new registerpage();
//                frame.getContentPane().add(register.page_register);
//                frame.getContentPane().revalidate();
//                while (!register.register_complete){
//                    Thread.sleep(1000);
//                }
//                login.isAuthorized=true;
//                registername = register.registeraccountname;
//                registerPIN = register.registerPINname;
//                registerpath = true;
//            }
//            Thread.sleep(1000);
//        }
//        if(!registerpath)
//        {
//            registername = login.preaccountname;
//            registerPIN = login.prePIN;
//        }
        account actualaccount = new account(registername, registerPIN);

        JOptionPane.showMessageDialog(null, "Welcome " + actualaccount.customer_name);
        frame.getContentPane().removeAll();
        CardLayout cardLayout = new CardLayout();
        JPanel panelchange = new JPanel();
        panelchange.setLayout(cardLayout);
        panelchange.add(actualaccount.homepage,"1");
        panelchange.add(actualaccount.deposit,"2");
        panelchange.add(actualaccount.withdraw,"3");
        panelchange.add(actualaccount.transaction,"4");
        panelchange.add(actualaccount.statistic,"5");
        frame.add(panelchange);
        frame.getContentPane().revalidate();
        while (true) {
            if (actualaccount.athomepage) {
                System.out.println(" i am here");
                System.out.println(actualaccount.balance);
                JLabel actualbalance = new JLabel("$"+actualaccount.balance);
                actualbalance.setBounds(160, 230,160,80);
                actualbalance.setFont(new Font("Open Sans",Font.BOLD,25));
                actualbalance.setForeground(Color.white);
                actualaccount.homepage.add(actualbalance);
                cardLayout.show(panelchange,"1");
                while (true) {
                    Thread.sleep(2000);
                    if (!actualaccount.athomepage) {
                        break;
                    }
                }
            }
                if (actualaccount.atdepositpage) {
                    cardLayout.show(panelchange,"2");
                    while (true) {
                        Thread.sleep(2000);
                        if (!actualaccount.atdepositpage) {
                            break;
                        }
                    }

                }
                if (actualaccount.atwithdrawpage) {
                    cardLayout.show(panelchange,"3");
                    frame.add(panelchange);
                    while (true) {
                        Thread.sleep(2000);
                        if (!actualaccount.atwithdrawpage) {
                            break;
                        }
                    }
                }
                if (actualaccount.attransactionpage) {
                    cardLayout.show(panelchange,"4");
                    frame.add(panelchange);
                    while (true) {
                        Thread.sleep(2000);
                        if (!actualaccount.attransactionpage) {
                            break;
                        }
                    }
                }
                if (actualaccount.atstatisticpage) {
                    cardLayout.show(panelchange,"5");
                    frame.add(panelchange);
                    while (true) {
                        Thread.sleep(2000);
                        if (!actualaccount.atstatisticpage) {
                            break;
                        }
                    }

                }
            Thread.sleep(1000);
            }
        }

    void createUIComponents(){

    }
    public static void main (String[] args) throws InterruptedException
    {

        new BankApp();
    }
}






