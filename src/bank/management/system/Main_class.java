package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main_class extends JFrame implements ActionListener {
    String pin;
    JButton depositButton, exitButton, fastCashButton, pinChangeButton, cashWithdrawlButton, miniStatementButton, balanceEnquiryButton;


    Main_class(String pin) {
        this.pin = pin;

        ImageIcon bank1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image bank2 = bank1.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon bank3 = new ImageIcon(bank2);
        JLabel bank = new JLabel(bank3);
        bank.setBounds(0, 0, 1500, 800);
        add(bank);

        JLabel label1 = new JLabel("PLEASE SELECT YOUR TRANSACTION TYPE");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setBounds(390, 180, 500, 35);
        bank.add(label1);//bank.... because we want to add text above the images which is stored in bank variable


        depositButton = new JButton("DEPOSIT");
        depositButton.setFont(new Font("Arial", Font.BOLD, 15));
        depositButton.setBackground(new Color(112, 222, 197));
        depositButton.setForeground(Color.WHITE);
        depositButton.setBounds(400, 260, 165, 35);
        depositButton.addActionListener(this);
        bank.add(depositButton);

        cashWithdrawlButton = new JButton("CASH WITHDRAWL");
        cashWithdrawlButton.setFont(new Font("Arial", Font.BOLD, 13));
        cashWithdrawlButton.setBackground(new Color(112, 222, 197));
        cashWithdrawlButton.setForeground(Color.WHITE);
        cashWithdrawlButton.setBounds(653, 260, 165, 35);
        cashWithdrawlButton.addActionListener(this);
        bank.add(cashWithdrawlButton);

        fastCashButton = new JButton("FAST CASH");
        fastCashButton.setFont(new Font("Arial", Font.BOLD, 13));
        fastCashButton.setBackground(new Color(112, 222, 197));
        fastCashButton.setForeground(Color.WHITE);
        fastCashButton.setBounds(400, 305, 165, 35);
        fastCashButton.addActionListener(this);
        bank.add(fastCashButton);//bank.... because we want to add text above the images which is stored in bank variable

        miniStatementButton = new JButton("MINI STATEMENT");
        miniStatementButton.setFont(new Font("Arial", Font.BOLD, 13));
        miniStatementButton.setBackground(new Color(112, 222, 197));
        miniStatementButton.setForeground(Color.WHITE);
        miniStatementButton.setBounds(653, 305, 165, 35);
        miniStatementButton.addActionListener(this);
        bank.add(miniStatementButton);

        pinChangeButton = new JButton("PIN CHANGE");
        pinChangeButton.setFont(new Font("Arial", Font.BOLD, 13));
        pinChangeButton.setBackground(new Color(112, 222, 197));
        pinChangeButton.setForeground(Color.WHITE);
        pinChangeButton.setBounds(400, 350, 165, 35);
        pinChangeButton.addActionListener(this);
        bank.add(pinChangeButton);//bank.... because we want to add text above the images which is stored in bank variable

        balanceEnquiryButton = new JButton("BALANCE ENQUIRY");
        balanceEnquiryButton.setFont(new Font("Arial", Font.BOLD, 13));
        balanceEnquiryButton.setBackground(new Color(112, 222, 197));
        balanceEnquiryButton.setForeground(Color.WHITE);
        balanceEnquiryButton.setBounds(653, 350, 165, 35);
        balanceEnquiryButton.addActionListener(this);
        bank.add(balanceEnquiryButton);

        exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Arial", Font.BOLD, 13));
        exitButton.setBackground(new Color(112, 222, 197));
        exitButton.setForeground(Color.WHITE);
        exitButton.setBounds(653, 395, 165, 35);
        exitButton.addActionListener(this);
        this.add(exitButton);
        bank.add(exitButton);//bank.... because we want to add text above the images which is stored in bank variable

        //getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(1600, 1000);
        setLocation(0, 0);
        setVisible(true);


        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    exitButton.doClick();  // Simulate a button click
                }
            }
        });

        this.setFocusable(true); // Ensure frame can listen to key events

    }

    public static void main(String[] args) {
        new Main_class(""); // Launch the Deposit window
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource().equals(exitButton))
                System.exit(0);
            else if (e.getSource().equals(depositButton)) {
                setVisible(false);
                dispose();
                new Deposit(pin);
            } else if (e.getSource().equals(fastCashButton)) {
                setVisible(false);
                dispose();
                new FastCastWithdrawl(pin);
            } else if (e.getSource().equals(miniStatementButton)) {

                new MiniStatement(pin);
            } else if (e.getSource().equals(balanceEnquiryButton)) {
                setVisible(false);
                dispose();
                new BalanceEnquiry(pin);
            } else if (e.getSource().equals(pinChangeButton)) {
                setVisible(false);
                dispose();
                new pinChange(pin);
            } else if (e.getSource().equals(cashWithdrawlButton)) {
                setVisible(false);
                dispose();
                new Withdrawl(pin);
            }

        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong");

        }
    }
}
