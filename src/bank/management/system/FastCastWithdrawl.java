package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import static bank.management.system.Withdrawl.ID;


public class FastCastWithdrawl extends JFrame implements ActionListener {
    String pin;
    JButton button100, buttonBack, button1000, button5000, button500, button2000, button10000;
    JTextField withdrawl;

    FastCastWithdrawl(String pin) {
        this.pin = pin;
        ImageIcon bank1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image bank2 = bank1.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon bank3 = new ImageIcon(bank2);
        JLabel bank = new JLabel(bank3);
        bank.setBounds(0, 0, 1500, 800);
        add(bank);

        JLabel label1 = new JLabel("SELECT WITHDRAWL AMOUNT ");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setBounds(450, 180, 500, 35);
        bank.add(label1);//bank.... because we want to add text above the images which is stored in bank variable

        button100 = new JButton(" 100 ");
        button100.setFont(new Font("Arial", Font.BOLD, 20));
        button100.setBackground(new Color(112, 222, 197));
        button100.setForeground(Color.WHITE);
        button100.setBounds(400, 260, 165, 35);
        button100.addActionListener(this);
        bank.add(button100);

        button500 = new JButton(" 500 ");
        button500.setFont(new Font("Arial", Font.BOLD, 20));
        button500.setBackground(new Color(112, 222, 197));
        button500.setForeground(Color.WHITE);
        button500.setBounds(653, 260, 165, 35);
        button500.addActionListener(this);
        bank.add(button500);

        button1000 = new JButton(" 1,000 ");
        button1000.setFont(new Font("Arial", Font.BOLD, 20));
        button1000.setBackground(new Color(112, 222, 197));
        button1000.setForeground(Color.WHITE);
        button1000.setBounds(400, 305, 165, 35);
        button1000.addActionListener(this);
        bank.add(button1000);//bank.... because we want to add text above the images which is stored in bank variable

        button2000 = new JButton(" 2,000 ");
        button2000.setFont(new Font("Arial", Font.BOLD, 20));
        button2000.setBackground(new Color(112, 222, 197));
        button2000.setForeground(Color.WHITE);
        button2000.setBounds(653, 305, 165, 35);
        button2000.addActionListener(this);
        bank.add(button2000);

        button5000 = new JButton(" 5,000 ");
        button5000.setFont(new Font("Arial", Font.BOLD, 20));
        button5000.setBackground(new Color(112, 222, 197));
        button5000.setForeground(Color.WHITE);
        button5000.setBounds(400, 350, 165, 35);
        button5000.addActionListener(this);
        bank.add(button5000);//bank.... because we want to add text above the images which is stored in bank variable

        button10000 = new JButton(" 10,000");
        button10000.setFont(new Font("Arial", Font.BOLD, 20));
        button10000.setBackground(new Color(112, 222, 197));
        button10000.setForeground(Color.WHITE);
        button10000.setBounds(653, 350, 165, 35);
        button10000.addActionListener(this);
        bank.add(button10000);

        buttonBack = new JButton(" BACK ");
        buttonBack.setFont(new Font("Arial", Font.BOLD, 20));
        buttonBack.setBackground(new Color(112, 222, 197));
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setBounds(653, 395, 165, 35);
        buttonBack.addActionListener(this);
        this.add(buttonBack);
        bank.add(buttonBack);//bank.... because we want to add text above the images which is stored in bank variable

        //getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(1600, 1000);
        setLocation(0, 0);
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    buttonBack.doClick();  // Simulate a button click
                }
                
            }
        });

        this.setFocusable(true); // Ensure frame can listen to key events

    }

    public static void main(String[] args) {
        new FastCastWithdrawl(""); // Launch the Deposit window
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            connect_wit_database con = new connect_wit_database(); // Assuming your database connection class is already defined

            //ResultSet resultSet = con.connections.executeQuery("SELECT Ammount FROM balance WHERE Pin = '" + pin + "' ");

            String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); // Current timestamp
            String query = "INSERT INTO balance (ID , Pin, date , Type, Ammount) VALUES (? , ?, ?, ?, ?)";
            PreparedStatement pstmt = con.connections.prepareStatement(query);
            pstmt.setInt(1, ID);
            pstmt.setString(2, pin);
            pstmt.setString(3, formattedDate); // Store as a string
            pstmt.setString(4, "Credit");


            if (e.getSource().equals(button100)) {
                pstmt.setDouble(5, 100);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Your transaction of ₹ 100 is successfull ");
            } else if (e.getSource().equals(button500)) {

                pstmt.setDouble(5, 500);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Your transaction of ₹ 500 is successfull ");
            } else if (e.getSource().equals(button1000)) {

                pstmt.setDouble(5, 1000);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Your transaction of ₹ 1,000 is successfull ");
            } else if (e.getSource().equals(button2000)) {

                pstmt.setDouble(5, 2000);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Your transaction of ₹ 2,000 is successfull ");
            } else if (e.getSource().equals(button5000)) {

                pstmt.setDouble(5, 5000);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Your transaction of ₹ 5,000 is successfull ");
            } else if (e.getSource().equals(button10000)) {

                pstmt.setDouble(5, 10000);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Your transaction of ₹ 10,000 is successfull ");
            } else if (e.getSource().equals(buttonBack)) {
                setVisible(false);
                new Main_class(pin);
            }

        } catch (Exception E) {
            E.printStackTrace();

        }
    }
}
