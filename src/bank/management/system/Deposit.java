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

public class Deposit extends JFrame implements ActionListener {

    String pin;
    JButton depositButton, backButton;
    JTextField deposit;

    Deposit(String pin) {
        this.pin = pin;

        ImageIcon bank1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image bank2 = bank1.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon bank3 = new ImageIcon(bank2);
        JLabel bank = new JLabel(bank3);
        bank.setBounds(0, 0, 1500, 800);
        add(bank);

        JLabel label1 = new JLabel("Enter Amount to Deposit ");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setBounds(400, 180, 500, 35);
        bank.add(label1);//bank.... because we want to add text above the images which is stored in bank variable

        deposit = new JTextField(20);
        deposit.setBounds(400, 220, 400, 30);
        deposit.setFont(new Font("Arial", Font.PLAIN, 20));
        deposit.setForeground(Color.BLACK);
        deposit.setBackground(new Color(112, 222, 197));
        bank.add(deposit);

        depositButton = new JButton("DEPOSIT");
        depositButton.setFont(new Font("Arial", Font.BOLD, 20));
        depositButton.setBackground(new Color(112, 222, 197));
        depositButton.setForeground(Color.WHITE);
        depositButton.setBounds(670, 350, 150, 35);
        depositButton.addActionListener(this);
        bank.add(depositButton);//bank.... because we want to add text above the images which is stored in bank variable

        backButton = new JButton("BACK");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setBackground(new Color(112, 222, 197));
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(670, 400, 150, 35);
        backButton.addActionListener(this);
        bank.add(backButton);//bank.... because we want to add text above the images which is stored in bank variable

        //getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(1600, 1000);
        setLocation(0, 0);
        setVisible(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    depositButton.doClick();  // Simulate a button click
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    backButton.doClick();  // Simulate a button click
                }
            }
        });
        this.setFocusable(true); // Ensure frame can listen to key events
    }

    public static void main(String[] args) {
        new Deposit(""); // Launch the Deposit window
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String Amount = deposit.getText();
            if (e.getSource().equals(backButton)) {
                dispose();
                new Main_class(pin);
            } else if (e.getSource().equals(depositButton) && !Amount.equals("")) {
                connect_wit_database con = new connect_wit_database();
                String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); // Current timestamp
                String query = "INSERT INTO balance (ID , Pin, date , Type, Ammount) VALUES (? , ?, ?, ?, ?)";
                PreparedStatement pstmt = con.connections.prepareStatement(query);
                pstmt.setInt(1, ID);
                pstmt.setString(2, pin);
                pstmt.setString(3, formattedDate); // Store as a string
                pstmt.setString(4, "Credit");
                pstmt.setString(5, Amount);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Your ₹ " + Amount + " is Creditted Successfully");
                deposit.setText("");
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
}