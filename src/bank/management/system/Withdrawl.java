package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    public static int ID;
    String pin;
    JButton withdrawlButton, backButton;
    JTextField withdrawl;

    Withdrawl(String pin) {
        this.pin = pin;

        ImageIcon bank1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image bank2 = bank1.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon bank3 = new ImageIcon(bank2);
        JLabel bank = new JLabel(bank3);
        bank.setBounds(0, 0, 1500, 800);
        add(bank);

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWL LIMIT IS 10,000");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setBounds(400, 150, 500, 35);
        bank.add(label1);

        JLabel label2 = new JLabel("SELECT BETWEEN 100 - 10,000");
        label2.setFont(new Font("Arial", Font.BOLD, 20));
        label2.setForeground(Color.WHITE);
        label2.setBounds(400, 175, 500, 35);
        bank.add(label2);

        withdrawl = new JTextField(20);
        withdrawl.setBounds(400, 220, 400, 30);
        withdrawl.setFont(new Font("Arial", Font.PLAIN, 20));
        withdrawl.setForeground(Color.BLACK);
        withdrawl.setBackground(new Color(112, 222, 197));
        bank.add(withdrawl);

        withdrawlButton = new JButton("WITHDRAWL");
        withdrawlButton.setFont(new Font("Arial", Font.BOLD, 16));
        withdrawlButton.setBackground(new Color(112, 222, 197));
        withdrawlButton.setForeground(Color.WHITE);
        withdrawlButton.setBounds(670, 350, 150, 35);
        withdrawlButton.addActionListener(this);
        this.add(withdrawlButton);
        bank.add(withdrawlButton);

        backButton = new JButton("BACK");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(112, 222, 197));
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(670, 400, 150, 35);
        backButton.addActionListener(this);
        bank.add(backButton);

        setLayout(null);
        setSize(1600, 1000);
        setLocation(0, 0);
        setVisible(true);

        // Add KeyListener to allow Enter key press
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    withdrawlButton.doClick();  // Simulate a button click
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    backButton.doClick();  // Simulate a button click
                }
            }
        });
        this.setFocusable(true); // Ensure frame can listen to key events
    }

    public static void main(String[] args) {
        new Withdrawl(""); // Launch the Withdrawl window
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double balance = 0;
            String Amount = withdrawl.getText(); // Get withdrawal amount
            if (e.getSource().equals(backButton)) {
                setVisible(false);
                new Main_class(pin); // Go back to main class
            }

            if (e.getSource().equals(withdrawlButton) && !Amount.isEmpty()) {
                // Fetch and calculate balance
                try {
                    connect_wit_database con = new connect_wit_database();
                    ResultSet resultSet = con.statement.executeQuery("SELECT * FROM balance WHERE Pin= '" + pin + "' ");
                    while (resultSet.next()) {
                        if (resultSet.getString("Type").equals("Credit")) {
                            balance += Double.parseDouble(resultSet.getString("Ammount"));
                        } else if (resultSet.getString("Type").equals("Debit")) {
                            balance -= Double.parseDouble(resultSet.getString("Ammount"));
                        }
                    }

                    // Check if balance is sufficient
                    if (balance >= Double.parseDouble(Amount)) {
                        // Perform the withdrawal
                        String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); // Current timestamp
                        String query = "INSERT INTO balance (ID , Pin, date , Type, Ammount) VALUES (? , ?, ?, ?, ?)";
                        PreparedStatement pstmt = con.connections.prepareStatement(query);
                        pstmt.setInt(1, ID);
                        pstmt.setString(2, pin);
                        pstmt.setString(3, formattedDate); // Store as a string
                        pstmt.setString(4, "Debit"); // Set transaction type to Debit
                        pstmt.setString(5, Amount);
                        pstmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Your withdrawal of ₹ " + Amount + " is successful.");
                        withdrawl.setText(""); // Clear input field
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient Fund");
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong");
        }
    }
}
