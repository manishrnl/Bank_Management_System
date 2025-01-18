package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.Locale;

public class MiniStatement extends JFrame implements ActionListener {
    String pin;
    JButton exitbutton;
    JLabel showResult;
    JLabel[] transactionLabels = new JLabel[10]; // Array to store transaction labels

    MiniStatement(String pin) {
        super("Mini Statement Screen");
        this.pin = pin;

        // Display balance
        showResult = new JLabel();
        showResult.setBounds(50, 410, 400, 40);
        showResult.setFont(new Font("Arial", Font.BOLD, 20));
        showResult.setForeground(Color.BLACK);
        add(showResult);

        // Exit button
        exitbutton = new JButton("BACK");
        exitbutton.setBounds(320, 490, 100, 40);
        exitbutton.setFont(new Font("Arial", Font.BOLD, 20));
        exitbutton.setBackground(new Color(124, 30, 225));
        exitbutton.setForeground(Color.WHITE);
        exitbutton.addActionListener(this);
        this.add(exitbutton);
        add(exitbutton);

        // Header
        JLabel label = new JLabel("Mini Statement (Last 10 Transactions)");
        label.setBounds(100, 50, 500, 25);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.BLACK);
        add(label);

        // Initialize transaction labels
        for (int i = 0; i < 10; i++) {
            transactionLabels[i] = new JLabel("");
            transactionLabels[i].setBounds(10, 100 + (i * 30), 500, 25);
            transactionLabels[i].setFont(new Font("Arial", Font.PLAIN, 15));
            transactionLabels[i].setForeground(Color.BLACK);
            add(transactionLabels[i]);
        }

        // Set JFrame properties
        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(500, 650);
        setLocation(500, 60);
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    exitbutton.doClick();  // Simulate a button click
                }
            }
        });
        this.setFocusable(true); // Ensure frame can listen to key events

        // Fetch and display balance and transactions
        fetchBalance();
        showTransaction();

    }

    public static void main(String[] args) {
        new MiniStatement("");
    }

    // Fetch balance based on transactions
    public void fetchBalance() {
        double balance = 0; // Reset balance calculation
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
            NumberFormat indianFormat = NumberFormat.getNumberInstance(new Locale("hindi", "IN"));
            String formattedNumber = indianFormat.format(balance);
            showResult.setText("Balance : ₹ " + formattedNumber); // Display the balance directly
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong");
        }
    }

    // Fetch and display the last 10 transactions
    public void showTransaction() {
        try {
            connect_wit_database con = new connect_wit_database();
            ResultSet resultSet = con.statement.executeQuery("SELECT * FROM balance WHERE Pin= '" + pin + "' ORDER BY ID DESC LIMIT 10");
            int index = 0; // To track labels
            while (resultSet.next() && index < 10) {

                String type = resultSet.getString("Type");
                String amount = resultSet.getString("Ammount");
                String date = resultSet.getString("date");
                String transactionType = type.equalsIgnoreCase("Credit") ? "Credited" : "Debited";
                NumberFormat indianFormat = NumberFormat.getNumberInstance(new Locale("hindi", "IN"));
                String formattedNumber = indianFormat.format(Double.parseDouble(amount));
                String formattedText = String.format("Amount of ₹ : %-20s is  %-10s ON : %-20s", formattedNumber, transactionType, date);

                transactionLabels[index].setText(formattedText);
                index++;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error fetching transactions: " + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(exitbutton)) {
            setVisible(false);
            dispose();
            new Main_class(pin); // Pass the correct pin value
        }
    }
}
