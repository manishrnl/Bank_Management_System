package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton backButton;
    JTextField balancepanel;
    String pin;
    JPasswordField field2;
    JTextField withdrawl, balanceField;

    BalanceEnquiry(String pin) {
        this.pin = pin;

        ImageIcon bank1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image bank2 = bank1.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon bank3 = new ImageIcon(bank2);
        JLabel bank = new JLabel(bank3);
        bank.setBounds(0, 0, 1500, 800);
        add(bank);

        JLabel label1 = new JLabel("BALANCE ENQUIRY ");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setBounds(450, 180, 500, 35);
        bank.add(label1);//bank.... because we want to add text above the images which is stored in bank variable

        balancepanel = new JTextField();
        balancepanel.setFont(new Font("Arial", Font.BOLD, 20));
        balancepanel.setForeground(Color.BLACK);
        balancepanel.setBounds(400, 220, 400, 35);
        bank.add(balancepanel);//bank.... because we want to add text above the images which is stored in bank variable


        backButton = new JButton("BACK");
        backButton.setFont(new Font("Arial", Font.BOLD, 13));
        backButton.setBackground(new Color(112, 222, 197));
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(653, 395, 165, 35);
        backButton.addActionListener(this);
        bank.add(backButton);//bank.... because we want to add text above the images which is stored in bank variable

        //getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(1600, 1000);
        setLocation(0, 0);
        setVisible(true);

        showBalance();
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }


    public void showBalance() {
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
            balancepanel.setText("Your Balance is ₹ : " + balance);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(backButton)) {
            new Main_class(pin); // Pass the correct pin value
            setVisible(false);
            dispose();
        }
    }
}