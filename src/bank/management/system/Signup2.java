package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Signup2 extends JFrame implements ActionListener {
    String formNumber;  // Declare formNumber to hold the form number passed from the previous screen
    JComboBox religionCombo, categoryCombo, incomeCombo, educationCombo, occupationCombo;
    JTextField panField, aadharField, mobileField;
    JButton nextButton;
    JRadioButton seniorcitizenyes, seniorcitizenno, Accountyes, Accountno;

    Signup2(String formNumber) {  // Corrected the constructor parameter to pass formNumber
        super("APPLICATION FORM");
        this.formNumber = formNumber;  // Assign the passed form number

        // Set up frame and components
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);

        // Bank logo
        ImageIcon bank1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bank2 = bank1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bank3 = new ImageIcon(bank2);
        JLabel bank = new JLabel(bank3);
        bank.setBounds(25, 10, 100, 100);
        add(bank);

        JLabel formNumberLabel = new JLabel("Form Number : " + formNumber);
        formNumberLabel.setBounds(600, 20, 150, 40);
        formNumberLabel.setFont(new Font("Arial", Font.BOLD, 15));
        add(formNumberLabel);

        JLabel pageNumber = new JLabel("PAGE 2");
        pageNumber.setBounds(420, 50, 80, 40);
        pageNumber.setFont(new Font("Arial", Font.BOLD, 20));
        add(pageNumber);

        JLabel presonaldetails = new JLabel("Additional details");
        presonaldetails.setBounds(380, 80, 180, 40);
        presonaldetails.setFont(new Font("Arial", Font.BOLD, 20));
        add(presonaldetails);

        // Religion ComboBox
        JLabel religion = new JLabel("Religion :");
        religion.setBounds(70, 150, 150, 25);
        religion.setFont(new Font("Arial", Font.BOLD, 18));
        add(religion);

        String[] Religion = {"Hindu", "Muslim", "Sikh", "Christian"};

        religionCombo = new JComboBox(Religion);
        religionCombo.setBackground(new Color(252, 208, 76));
        religionCombo.setFont(new Font("Arial", Font.BOLD, 15));
        religionCombo.setBounds(270, 150, 300, 30);
        add(religionCombo);

        // Category ComboBox
        JLabel category = new JLabel("Category :");
        category.setBounds(70, 190, 150, 25);
        category.setFont(new Font("Arial", Font.BOLD, 18));
        add(category);

        String[] Category = {"General", "EBC", "SC/ST", "OBC"};
        categoryCombo = new JComboBox(Category);
        categoryCombo.setBackground(new Color(252, 208, 76));
        categoryCombo.setFont(new Font("Arial", Font.BOLD, 15));
        categoryCombo.setBounds(270, 190, 300, 30);
        add(categoryCombo);

        // Income ComboBox
        JLabel income = new JLabel("Income :");
        income.setBounds(70, 230, 150, 25);
        income.setFont(new Font("Arial", Font.BOLD, 18));
        add(income);

        String[] Income = {"0.00", "< 1,00,000", "1,00,001-3,00,000", "3,00,001-5,00,000", "5,00,001-10,00,000", "> 10,00,000"};
        incomeCombo = new JComboBox(Income);
        incomeCombo.setBackground(new Color(252, 208, 76));
        incomeCombo.setFont(new Font("Arial", Font.BOLD, 15));
        incomeCombo.setBounds(270, 230, 300, 30);
        add(incomeCombo);

        // Educational Qualification ComboBox
        JLabel education = new JLabel("Educational Qualification :");
        education.setBounds(70, 270, 150, 25);
        education.setFont(new Font("Arial", Font.BOLD, 18));
        add(education);

        String[] Education = {"No Schooling", "Up to 10th", "Up to 12th", "Graduate in B.tech", "Graduate in BCA", "Graduate in BBA", "Post Graduate", "Masters Degree"};
        educationCombo = new JComboBox(Education);
        educationCombo.setBackground(new Color(252, 208, 76));
        educationCombo.setFont(new Font("Arial", Font.BOLD, 15));
        educationCombo.setBounds(270, 270, 300, 30);
        add(educationCombo);

        // Occupation ComboBox
        JLabel occupation = new JLabel("Occupation :");
        occupation.setBounds(70, 310, 150, 25);
        occupation.setFont(new Font("Arial", Font.BOLD, 18));
        add(occupation);

        String[] Occupation = {"Salaried", "Self Employed", "Student", "Retired as a Ex-Military Men"};
        occupationCombo = new JComboBox(Occupation);
        occupationCombo.setBackground(new Color(252, 208, 76));
        occupationCombo.setFont(new Font("Arial", Font.BOLD, 15));
        occupationCombo.setBounds(270, 310, 300, 30);
        add(occupationCombo);

        // Mobile Number Field
        JLabel mobile = new JLabel("Mobile number :");
        mobile.setBounds(70, 350, 150, 30);
        mobile.setFont(new Font("Arial", Font.BOLD, 18));
        add(mobile);

        mobileField = new JTextField(15);
        mobileField.setBounds(270, 350, 380, 30);
        mobileField.setFont(new Font("Arial", Font.BOLD, 18));
        add(mobileField);

        // Aadhar Number Field
        JLabel aadhar = new JLabel("Aadhar No. :");
        aadhar.setBounds(70, 390, 150, 30);
        aadhar.setFont(new Font("Arial", Font.BOLD, 18));
        add(aadhar);

        aadharField = new JTextField(15);
        aadharField.setBounds(270, 390, 380, 30);
        aadharField.setFont(new Font("Arial", Font.BOLD, 18));
        add(aadharField);

        // PAN Number Field
        JLabel pan = new JLabel("PAN NO. :");
        pan.setBounds(70, 430, 150, 30);
        pan.setFont(new Font("Arial", Font.BOLD, 18));
        add(pan);

        panField = new JTextField(15);
        panField.setBounds(270, 430, 380, 30);
        panField.setFont(new Font("Arial", Font.BOLD, 18));
        add(panField);

        // Comment Field
        JLabel comment = new JLabel("Senior Citizen :");
        comment.setBounds(70, 480, 150, 30);
        comment.setFont(new Font("Arial", Font.BOLD, 18));
        add(comment);

        seniorcitizenyes = new JRadioButton("Yes");
        seniorcitizenyes.setBounds(270, 480, 80, 30);
        add(seniorcitizenyes);

        seniorcitizenno = new JRadioButton("No");
        seniorcitizenno.setBounds(400, 480, 80, 30);
        add(seniorcitizenno);
        ButtonGroup SeniorCitizen = new ButtonGroup();
        SeniorCitizen.add(seniorcitizenyes);
        SeniorCitizen.add(seniorcitizenno);

        JLabel account = new JLabel("Existing Account:");
        account.setBounds(70, 520, 150, 30);
        account.setFont(new Font("Arial", Font.BOLD, 18));
        add(account);

        Accountyes = new JRadioButton("Yes");
        Accountyes.setBounds(270, 520, 80, 30);
        add(Accountyes);

        Accountno = new JRadioButton("No");
        Accountno.setBounds(400, 520, 80, 30);
        add(Accountno);

        ButtonGroup Account = new ButtonGroup();
        Account.add(Accountyes);
        Account.add(Accountno);

        // Next Button
        nextButton = new JButton("Next");
        nextButton.setBounds(650, 650, 150, 35);
        nextButton.setFont(new Font("Arial", Font.BOLD, 18));
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(this);
        this.add(nextButton);

        // Set window background color
        getContentPane().setBackground(new Color(252, 208, 76));
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    nextButton.doClick();  // Simulate a button click
                }
            }
        });

        this.setFocusable(true); // Ensure frame can listen to key events


    }

    public static void main(String[] args) {
        new Signup2("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) religionCombo.getSelectedItem();
        String cat = (String) categoryCombo.getSelectedItem();
        String edu = (String) educationCombo.getSelectedItem();
        String occ = (String) occupationCombo.getSelectedItem();
        String inc = (String) incomeCombo.getSelectedItem();
        String pan = panField.getText();
        String adhar = aadharField.getText();
        String mobile = mobileField.getText();
        String sc = "";
        if (seniorcitizenyes.isSelected())
            sc = "Yes";
        else if (seniorcitizenno.isSelected())
            sc = "No";
        String account = "";
        if (Accountyes.isSelected())
            account = "Yes";
        else if (Accountno.isSelected())
            account = "No";
        try {
            if (panField.getText().equals("") || mobileField.getText().equals("") || aadharField.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Fill all the fields");

                // Validate Mobile Number (10 digits)
            else if (!mobile.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(null, "Mobile Number Must be 10 Digit Long.");
            }
            // Validate Aadhar Number (12 digits)
            else if (!adhar.matches("\\d{12}")) {
                JOptionPane.showMessageDialog(null, "Aadhar number must be 12 digit Long");
            }

            // Validate PAN Number (5 alphabets followed by 4 digits and last 1 letter is alphabet)
            else if (!pan.matches("[A-Za-z]{5}\\d{4}[A-Za-z]{1}")) {
                JOptionPane.showMessageDialog(null, "PAN number must be in 5 alphabets + 4 digits + 1 Alphabet format.");
            } else {
                connect_wit_database con2 = new connect_wit_database();
                String data2 = "insert into signup2 values ('" + formNumber + "','" + rel + "','" + cat + "','" + inc + "','" + edu + "','" + occ + "','" + pan + "','" + adhar + "','" + mobile + "','" + sc + "','" + account + "')";
                con2.statement.executeUpdate(data2);
                new Signup3(formNumber);
                setVisible(false);
            }

        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Error occurred: " + E.getMessage());
            E.printStackTrace();
        }
    }
}