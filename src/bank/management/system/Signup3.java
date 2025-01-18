package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JButton submitButton, cancelButton, toggleButton;
    String formNumber;
    JLabel accountType, accountdetails, pageNumber, formNumberLabel, cardNumber, cardNumber2,
            cardNumber3, cardNumber4, cardNumber5, cardNumber6, services;

    ButtonGroup acc;
    JRadioButton recurring, fixed, saving, current;
    JCheckBox serviceATM, serviceInternet, serviceMobile, serviceEmail, serviceCheque, serviceEstatement, terms;
    boolean areAllSelected = false; // Tracks whether all checkboxes are selected

    Signup3(String formNumber) {
        super("Account Details Page 3"); // Title Bar
        this.formNumber = formNumber; // Assign the parameter value to the instance variable

        ImageIcon bank1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bank2 = bank1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bank3 = new ImageIcon(bank2);
        JLabel bank = new JLabel(bank3);
        bank.setBounds(50, 10, 100, 100);
        add(bank);

        formNumberLabel = new JLabel("Form Number : " + formNumber);
        formNumberLabel.setBounds(600, 20, 150, 40);
        formNumberLabel.setFont(new Font("Arial", Font.BOLD, 15));
        add(formNumberLabel);

        pageNumber = new JLabel("Page 3");
        pageNumber.setBounds(250, 40, 80, 40);
        pageNumber.setFont(new Font("Arial", Font.BOLD, 20));
        add(pageNumber);

        accountdetails = new JLabel("Account details");
        accountdetails.setBounds(250, 70, 180, 40);
        accountdetails.setFont(new Font("Arial", Font.BOLD, 20));
        add(accountdetails);

        accountType = new JLabel("Account Type :");
        accountType.setBounds(70, 140, 180, 40);
        accountType.setFont(new Font("Arial", Font.BOLD, 20));
        add(accountType);

        saving = new JRadioButton("Saving Account");
        saving.setBackground(new Color(224, 255, 255));
        saving.setBounds(70, 190, 250, 40);
        add(saving);

        current = new JRadioButton("Current Account");
        current.setBackground(new Color(224, 255, 255));
        current.setBounds(350, 190, 250, 40);
        add(current);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setBackground(new Color(224, 255, 255));
        fixed.setBounds(70, 240, 250, 40);
        add(fixed);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setBounds(350, 240, 250, 40);
        recurring.setBackground(new Color(224, 255, 255));
        add(recurring);

        acc = new ButtonGroup();
        acc.add(saving);
        acc.add(fixed);
        acc.add(recurring);
        acc.add(current);

        cardNumber = new JLabel("Card Number :");
        cardNumber.setBounds(70, 320, 150, 30);
        cardNumber.setFont(new Font("Arial", Font.PLAIN, 20));
        add(cardNumber);

        cardNumber2 = new JLabel("XXXX-XXXX-XXXX-6895");
        cardNumber2.setBounds(270, 320, 250, 30);
        cardNumber2.setFont(new Font("Arial", Font.PLAIN, 20));
        add(cardNumber2);

        cardNumber3 = new JLabel("(Your 16 digit Card Number)");
        cardNumber3.setBounds(70, 350, 150, 20);
        cardNumber3.setFont(new Font("Arial", Font.PLAIN, 11));
        add(cardNumber3);

        cardNumber4 = new JLabel("( It would appear on ATM Card/Cheque Book and Statement )");
        cardNumber4.setBounds(270, 350, 350, 20);
        cardNumber4.setFont(new Font("Arial", Font.PLAIN, 11));
        add(cardNumber4);

        cardNumber5 = new JLabel("PIN :");
        cardNumber5.setBounds(70, 390, 150, 20);
        cardNumber5.setFont(new Font("Arial", Font.PLAIN, 20));
        add(cardNumber5);

        cardNumber6 = new JLabel("XXXX");
        cardNumber6.setBounds(270, 390, 350, 20);
        cardNumber6.setFont(new Font("Arial", Font.PLAIN, 20));
        add(cardNumber6);

        services = new JLabel("Services Required :");
        services.setBounds(70, 420, 350, 30);
        services.setFont(new Font("Arial", Font.PLAIN, 20));
        add(services);

        serviceATM = new JCheckBox("ATM CARD");
        serviceATM.setBounds(70, 460, 250, 30);
        serviceATM.setBackground(new Color(224, 255, 255));
        add(serviceATM);

        serviceInternet = new JCheckBox("Internet Banking");
        serviceInternet.setBounds(370, 460, 250, 30);
        serviceInternet.setBackground(new Color(224, 255, 255));
        add(serviceInternet);

        serviceMobile = new JCheckBox("Mobile Banking");
        serviceMobile.setBounds(70, 500, 250, 30);
        serviceMobile.setBackground(new Color(224, 255, 255));
        add(serviceMobile);

        serviceEmail = new JCheckBox("Email Alerts");
        serviceEmail.setBounds(370, 500, 250, 30);
        serviceEmail.setBackground(new Color(224, 255, 255));
        add(serviceEmail);

        serviceCheque = new JCheckBox("Cheque Book");
        serviceCheque.setBounds(70, 540, 250, 30);
        serviceCheque.setBackground(new Color(224, 255, 255));
        add(serviceCheque);

        serviceEstatement = new JCheckBox("E-Statement");
        serviceEstatement.setBounds(370, 540, 250, 30);
        serviceEstatement.setBackground(new Color(224, 255, 255));
        add(serviceEstatement);

        toggleButton = new JButton("Select All");
        toggleButton.setBounds(150, 590, 150, 35);
        toggleButton.setFont(new Font("Arial", Font.PLAIN, 15));
        toggleButton.setBackground(Color.BLACK);
        toggleButton.setForeground(Color.WHITE);
        toggleButton.addActionListener(this);
        add(toggleButton);

        terms = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        terms.setBounds(70, 640, 550, 30);
        terms.setBackground(new Color(224, 255, 255));
        add(terms);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 700, 150, 35);
        cancelButton.setFont(new Font("Arial", Font.BOLD, 18));
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        add(cancelButton);

        submitButton = new JButton("Submit");
        submitButton.setBounds(450, 700, 150, 35);
        submitButton.setFont(new Font("Arial", Font.BOLD, 18));
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        this.add(submitButton);


        getContentPane().setBackground(new Color(224, 255, 255));
        setSize(850, 800);
        setLocation(360, 40);
        setLayout(null);
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submitButton.doClick();  // Simulate a button click
                }
            }
        });

        this.setFocusable(true); // Ensure frame can listen to key events


    }

    public static void main(String[] args) {
        new Signup3("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random ran = new Random();
        long first7 = (ran.nextLong() % 100000000L);
        String cardno = "14032000" + String.format("%08d", Math.abs(first7));// String.format("%08d", Math.abs(first7)) force to generate 8 digit number always hence we get 16 digit number always

        long first3 = (ran.nextLong() % 10000L);  // This ensures the number is always between 0 and 9999
        String pin = String.format("%04d", Math.abs(first3));  // This formats the pin to always be 4 digits

        StringBuilder srvcrq = new StringBuilder();
        if (serviceATM.isSelected())
            srvcrq.append("  ATM CARD  ");
        if (serviceMobile.isSelected())
            srvcrq.append("  Mobile Banking  ");
        if (serviceEmail.isSelected())
            srvcrq.append("  Email Alert  ");
        if (serviceInternet.isSelected())
            srvcrq.append("  Internet Banking  ");
        if (serviceCheque.isSelected())
            srvcrq.append("  Cheque Book  ");
        if (serviceEstatement.isSelected())
            srvcrq.append("  E-Statement  ");

        try {
            if (e.getSource() == toggleButton) {
                // Toggle the state of the checkbox either select all or select none
                areAllSelected = !areAllSelected;
                serviceATM.setSelected(areAllSelected);
                serviceEstatement.setSelected(areAllSelected);
                serviceCheque.setSelected(areAllSelected);
                serviceInternet.setSelected(areAllSelected);
                serviceMobile.setSelected(areAllSelected);
                serviceEmail.setSelected(areAllSelected);
                toggleButton.setText(areAllSelected ? "Deselect All" : "Select All");
            }
            if (e.getSource() == submitButton) {
                String atype = "";
                if (saving.isSelected())
                    atype = "Saving Account";
                else if (fixed.isSelected())
                    atype = "Fixed Deposit Account";
                else if (recurring.isSelected())
                    atype = "Recurring Deposit Account";
                else if (current.isSelected())
                    atype = "Current Account";

                if (atype.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select an account type!");
                    return; // Stop further execution if account type is not choosen
                }

                if (!terms.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please agree to the terms and conditions!");
                    return; // Stop further execution if Terms is not choosen
                }

                connect_wit_database con3 = new connect_wit_database();
                String data3 = "INSERT INTO signup3 VALUES ('" + formNumber + "', '" + atype + "', '" + srvcrq + "', '" + cardno + "', '" + pin + "')";
                String data4 = "INSERT INTO login VALUES ('" + formNumber + "', '" + cardno + "', '" + pin + "')";
                con3.statement.executeUpdate(data3);
                con3.statement.executeUpdate(data4);
                JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\nPIN: " + pin);
                new Login();
                setVisible(false);
            } else if (e.getSource() == cancelButton) {
                System.exit(0);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong");
        }
    }
}
