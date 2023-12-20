package ro.marinelPuia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CalculatorInterface {

    DataCore dataCore = new DataCore(25d, 10d, 0d, 10d, 2.25d);
    CalculateBrutSalary calculateBrutSalary = new CalculateBrutSalary(0d, 25d, 10d, 2.25d);

    private final JFrame mainWindow;

    JLabel brutLabel = new JLabel();
    JLabel casLabel = new JLabel();
    JLabel cassLabel = new JLabel();
    JLabel dpLabel = new JLabel();
    JLabel inpozitLabel = new JLabel();
    JLabel netSalaryLabel = new JLabel();
    JLabel camLabel = new JLabel();
    JLabel completSalaryLabel = new JLabel();
    JLabel childAngajatLabel = new JLabel();
    JLabel childAngajatorLabel = new JLabel();
    JLabel childStatLabel = new JLabel();
    JLabel childCheltuieliAngajat = new JLabel();
    JLabel procentAngajatLabel = new JLabel();
    JLabel procentStatLabel = new JLabel();
    private final JButton calculateNetButton;
    private final JButton calculateBrutButton;
    private final JButton resetButton;
    public static JTextField userInputBrutSalary;
    public static JTextField userInputNetSalary;
    private Font titleFont = new Font("Time New Roman", Font.PLAIN, 30);
    private final Font mainFont = new Font("Time New Roman", Font.PLAIN, 18);
    private final Font smallFont = new Font("Time New Roman", Font.PLAIN, (int) 14.5);

    // ------ SHOW TODAY DATE ------
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDateTime now = LocalDateTime.now();


    CalculatorInterface() {

        // ------ CREATE THE MAIN WINDOW ------
        mainWindow = new JFrame("Today Date: " + dtf.format(now));
        mainWindow.setLayout(null);
        mainWindow.setVisible(true);
        mainWindow.setFont(mainFont);
        mainWindow.setSize(1200, 765);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.getContentPane().setBackground(Color.DARK_GRAY);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        Container container = mainWindow.getContentPane();
        mainWindow.revalidate();

        // ------ TITLE PANEL ------
        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(100, 50, 1000, 50);
        titlePanel.setBackground(Color.GRAY);
        container.add(titlePanel);

        // ------ TITLE LABEL ------
        JLabel title = new JLabel();
        title.setForeground(Color.LIGHT_GRAY);
        title.setText("SALARY CALCULATOR");
        title.setFont(titleFont);
        titlePanel.add(title);

        // ------ INTRODUCTION JLabel PANEL ------
        JPanel introductionJLabelPanel = new JPanel();
        introductionJLabelPanel.setBounds(100, 101, 1000, 35);
        introductionJLabelPanel.setBackground(Color.GRAY);
        container.add(introductionJLabelPanel);


        // ------ INTRODUCTION JLabel ------
        JLabel introductionJLabel = new JLabel();
        introductionJLabel.setBackground(Color.GRAY);
        introductionJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        introductionJLabel.setVerticalAlignment(SwingConstants.CENTER);
        introductionJLabel.setText("GROSS TO NET - OR - NET TO GROSS");
        introductionJLabel.setFont(mainFont);
        introductionJLabel.setForeground(Color.LIGHT_GRAY);
        introductionJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        introductionJLabelPanel.add(introductionJLabel);
        introductionJLabelPanel.revalidate();

        // ------ USER NET AND BRUT SALARY PANEL ------
        JPanel introNetAndBrutSalaryPanel = new JPanel();
        introNetAndBrutSalaryPanel.setBounds(100, 136, 1000, 50);
        introNetAndBrutSalaryPanel.setLayout(new GridLayout(2, 2));
        introNetAndBrutSalaryPanel.setBackground(Color.GRAY);
        container.add(introNetAndBrutSalaryPanel);
        introNetAndBrutSalaryPanel.revalidate();

        // ------ BRUT SALARY LABEL ------
        JLabel userInputBrutSalaryLabel = new JLabel();
        userInputBrutSalaryLabel.setBackground(Color.GRAY);
        userInputBrutSalaryLabel.setText("ENTER YOUR GROSS SALARY");
        userInputBrutSalaryLabel.setForeground(Color.LIGHT_GRAY);
        userInputBrutSalaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userInputBrutSalaryLabel.setVerticalAlignment(SwingConstants.CENTER);
        introNetAndBrutSalaryPanel.add(userInputBrutSalaryLabel);
        userInputBrutSalaryLabel.revalidate();

        // ------ NET SALARY LABEL ------
        JLabel userInputNetSalaryLabel = new JLabel();
        userInputNetSalaryLabel.setBackground(Color.GRAY);
        userInputNetSalaryLabel.setText("ENTER YOUR NET SALARY");
        userInputNetSalaryLabel.setForeground(Color.LIGHT_GRAY);
        userInputNetSalaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userInputNetSalaryLabel.setVerticalAlignment(SwingConstants.CENTER);
        introNetAndBrutSalaryPanel.add(userInputNetSalaryLabel);
        userInputNetSalaryLabel.revalidate();

        // ------ USER INPUT BRUT SALARY ------
        userInputBrutSalary = new JTextField();
        userInputBrutSalary.setPreferredSize(new Dimension(230, 22));
        userInputBrutSalary.setText("Enter Your Gross");
        userInputBrutSalary.setBackground(Color.LIGHT_GRAY);
        userInputBrutSalary.setForeground(Color.BLUE);
        userInputBrutSalary.setCaretColor(Color.BLUE);
        introNetAndBrutSalaryPanel.add(userInputBrutSalary);
        userInputBrutSalary.revalidate();

        // ------ USER INPUT NET SALARY ------
        userInputNetSalary = new JTextField();
        userInputNetSalary.setPreferredSize(new Dimension(230, 22));
        userInputNetSalary.setText("Enter Your Net");
        userInputNetSalary.setBackground(Color.LIGHT_GRAY);
        userInputNetSalary.setForeground(Color.RED);
        userInputNetSalary.setCaretColor(Color.RED);
        introNetAndBrutSalaryPanel.add(userInputNetSalary);
        userInputNetSalary.revalidate();

        // ------ EMPLOYEE PANEL ------
        JPanel employeePanel = new JPanel();
        employeePanel.setBounds(100, 205, 1000, 25);
        employeePanel.setBackground(Color.GRAY);
        container.add(employeePanel);
        employeePanel.revalidate();

        // ------ EMPLOYEE LABEL ------
        JLabel employee = new JLabel();
        employee.setForeground(Color.WHITE);
        employee.setHorizontalAlignment(SwingConstants.CENTER);
        employee.setVerticalAlignment(SwingConstants.CENTER);
        employee.setText("EMPLOYEE");
        employeePanel.add(employee);
        employeePanel.repaint();
        employee.revalidate();

        // ------ RESULT BRUT SALARY AND CAS PANEL ------
        JPanel brutAndCasPanel = new JPanel();
        brutAndCasPanel.setBounds(100, 230, 1000, 50);
        brutAndCasPanel.setLayout(new GridLayout(2, 2));
        brutAndCasPanel.setBackground(Color.BLACK);
        container.add(brutAndCasPanel);
        brutAndCasPanel.revalidate();

        // ------ RESULT BRUT SALARY JLabel ------
        brutLabel.setForeground(Color.WHITE);
        brutLabel.setFont(smallFont);
        brutLabel.setHorizontalAlignment(SwingConstants.CENTER);
        brutLabel.setVerticalAlignment(SwingConstants.CENTER);
        brutAndCasPanel.add(brutLabel);
        brutLabel.revalidate();

        // ------ RESULT CAS JLabel ------
        casLabel.setForeground(Color.WHITE);
        casLabel.setFont(smallFont);
        casLabel.setHorizontalAlignment(SwingConstants.CENTER);
        casLabel.setVerticalAlignment(SwingConstants.CENTER);
        brutAndCasPanel.add(casLabel);
        casLabel.revalidate();

        // ------ RESULT CASS AND DP (DEDUCERE PERSONALA) PANEL ------
        JPanel cassAndDpPanel = new JPanel();
        cassAndDpPanel.setBounds(100, 280, 1000, 50);
        cassAndDpPanel.setLayout(new GridLayout(2, 2));
        cassAndDpPanel.setBackground(Color.BLACK);
        container.add(cassAndDpPanel);
        cassAndDpPanel.revalidate();

        // ------ RESULT CASS JLabel ------
        cassLabel.setForeground(Color.WHITE);
        cassLabel.setFont(smallFont);
        cassLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cassLabel.setVerticalAlignment(SwingConstants.CENTER);
        cassAndDpPanel.add(cassLabel);
        cassLabel.revalidate();

        // ------ RESULT DP JLabel ------
        dpLabel.setForeground(Color.WHITE);
        dpLabel.setFont(smallFont);
        dpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dpLabel.setVerticalAlignment(SwingConstants.CENTER);
        cassAndDpPanel.add(dpLabel);
        dpLabel.revalidate();

        // ------ RESULT IMPOZIT PE VENT AND NET SALARY PANEL ------
        JPanel inpozitAndNetSalaryPanel = new JPanel();
        inpozitAndNetSalaryPanel.setBounds(100, 330, 1000, 50);
        inpozitAndNetSalaryPanel.setLayout(new GridLayout(2, 2));
        inpozitAndNetSalaryPanel.setBackground(Color.BLACK);
        container.add(inpozitAndNetSalaryPanel);
        inpozitAndNetSalaryPanel.revalidate();

        // ------ RESULT INPOZIT JLabel ------
        inpozitLabel.setForeground(Color.WHITE);
        inpozitLabel.setFont(smallFont);
        inpozitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inpozitLabel.setVerticalAlignment(SwingConstants.CENTER);
        inpozitAndNetSalaryPanel.add(inpozitLabel);
        inpozitLabel.revalidate();

        // ------ RESULT NET SALARY JLabel ------
        netSalaryLabel.setForeground(Color.GREEN);
        netSalaryLabel.setFont(smallFont);
        netSalaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        netSalaryLabel.setVerticalAlignment(SwingConstants.CENTER);
        inpozitAndNetSalaryPanel.add(netSalaryLabel);
        netSalaryLabel.revalidate();

        // ------ ANGAJATOR PANEL ------
        JPanel angajatorPanel = new JPanel();
        angajatorPanel.setBounds(100, 382, 1000, 25);
        angajatorPanel.setBackground(Color.GRAY);
        container.add(angajatorPanel);
        angajatorPanel.repaint();
        angajatorPanel.revalidate();

        // ------ ANGAJATOR LABEL ------
        JLabel angajatorLabel = new JLabel();
        angajatorLabel.setText("EMPLOYER");
        angajatorLabel.setForeground(Color.WHITE);
        angajatorLabel.setVerticalAlignment(SwingConstants.CENTER);
        angajatorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        angajatorPanel.add(angajatorLabel);
        angajatorLabel.repaint();
        angajatorLabel.revalidate();

        // ------ RESULT CAM AND NET COMPLET SALARY PANEL ------
        JPanel casAndCompletSalaryPanel = new JPanel();
        casAndCompletSalaryPanel.setBounds(100, 407, 1000, 50);
        casAndCompletSalaryPanel.setLayout(new GridLayout(2, 2));
        casAndCompletSalaryPanel.setBackground(Color.BLACK);
        container.add(casAndCompletSalaryPanel);
        casAndCompletSalaryPanel.revalidate();

        // ------ RESULT CAM JLabel ------
        camLabel.setForeground(Color.WHITE);
        camLabel.setFont(smallFont);
        camLabel.setHorizontalAlignment(SwingConstants.CENTER);
        camLabel.setVerticalAlignment(SwingConstants.CENTER);
        casAndCompletSalaryPanel.add(camLabel);
        camLabel.revalidate();

        // ------ RESULT COMPLET SALARY JLabel ------
        completSalaryLabel.setForeground(Color.YELLOW);
        completSalaryLabel.setFont(smallFont);
        completSalaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        completSalaryLabel.setVerticalAlignment(SwingConstants.CENTER);
        casAndCompletSalaryPanel.add(completSalaryLabel);
        completSalaryLabel.revalidate();

        // ------ RESULT TOTAL TAXE PANEL ------
        JPanel totalTaxePanel = new JPanel();
        totalTaxePanel.setBounds(100, 457, 1000, 25);
        totalTaxePanel.setBackground(Color.GRAY);
        container.add(totalTaxePanel);
        totalTaxePanel.repaint();
        totalTaxePanel.revalidate();

        // ------ RESULT TOTAL TAXE LABEL ------
        JLabel totalTaxeLabel = new JLabel();
        totalTaxeLabel.setText("TOTAL TAXES");
        totalTaxeLabel.setForeground(Color.WHITE);
        totalTaxeLabel.setVerticalAlignment(SwingConstants.CENTER);
        totalTaxeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        totalTaxePanel.add(totalTaxeLabel);
        totalTaxeLabel.repaint();
        totalTaxeLabel.revalidate();

        // ------ RESULT TOTAL TAXE CHILDREN PANEL ------
        JPanel totalTaxeChildrenPanel = new JPanel();
        totalTaxeChildrenPanel.setBounds(100, 482, 1000, 100);
        totalTaxeChildrenPanel.setLayout(new GridLayout(4, 2));
        totalTaxeChildrenPanel.setBackground(Color.BLACK);
        container.add(totalTaxeChildrenPanel);
        totalTaxeChildrenPanel.revalidate();

        // ------ RESULT CHILD ANGAJAT JLabel ------
        childAngajatLabel.setForeground(Color.WHITE);
        childAngajatLabel.setFont(smallFont);
        childAngajatLabel.setHorizontalAlignment(SwingConstants.CENTER);
        childAngajatLabel.setVerticalAlignment(SwingConstants.CENTER);
        totalTaxeChildrenPanel.add(childAngajatLabel);
        childAngajatLabel.revalidate();

        // ------ RESULT CHILD ANGAJATOR JLabel ------
        childAngajatorLabel.setForeground(Color.WHITE);
        childAngajatorLabel.setFont(smallFont);
        childAngajatorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        childAngajatorLabel.setVerticalAlignment(SwingConstants.CENTER);
        totalTaxeChildrenPanel.add(childAngajatorLabel);
        childAngajatorLabel.revalidate();

        // ------ RESULT CHILD STAT JLabel ------
        childStatLabel.setForeground(Color.RED);
        childStatLabel.setFont(smallFont);
        childStatLabel.setHorizontalAlignment(SwingConstants.CENTER);
        childStatLabel.setVerticalAlignment(SwingConstants.CENTER);
        totalTaxeChildrenPanel.add(childStatLabel);
        childStatLabel.revalidate();

        // ------ RESULT CHILD CHELTUIELI ANGAJAT CATRE STAT Label ------
        childCheltuieliAngajat.setForeground(Color.YELLOW);
        childCheltuieliAngajat.setFont(smallFont);
        childCheltuieliAngajat.setHorizontalAlignment(SwingConstants.CENTER);
        childCheltuieliAngajat.setVerticalAlignment(SwingConstants.CENTER);
        totalTaxeChildrenPanel.add(childCheltuieliAngajat);
        childCheltuieliAngajat.revalidate();

        // ------ RESULT PROCENT ANGAJAT STAT PANEL ------
        JPanel procentAngajatStatPanel = new JPanel();
        procentAngajatStatPanel.setBounds(100, 583, 1000, 50);
        procentAngajatStatPanel.setLayout(new GridLayout(1, 2));
        procentAngajatStatPanel.setBackground(Color.BLACK);
        container.add(procentAngajatStatPanel);
        procentAngajatStatPanel.revalidate();

        // ------ PROCENT ANGAJAT LABEL ------
        procentAngajatStatPanel.setPreferredSize(new Dimension(500, 25));
        procentAngajatLabel.setBackground(Color.GRAY);
        procentAngajatLabel.setFont(smallFont);
        procentAngajatLabel.setForeground(Color.GREEN);
        procentAngajatLabel.setHorizontalAlignment(SwingConstants.CENTER);
        procentAngajatLabel.setVerticalAlignment(SwingConstants.CENTER);
        procentAngajatStatPanel.add(procentAngajatLabel);
        procentAngajatLabel.revalidate();

        // ------ PROCENT STAT LABEL ------
        procentStatLabel.setPreferredSize(new Dimension(500, 25));
        procentStatLabel.setBackground(Color.BLACK);
        procentStatLabel.setFont(smallFont);
        procentStatLabel.setForeground(Color.RED);
        procentStatLabel.setHorizontalAlignment(SwingConstants.CENTER);
        procentStatLabel.setVerticalAlignment(SwingConstants.CENTER);
        procentAngajatStatPanel.add(procentStatLabel);
        procentStatLabel.revalidate();

        // ------ CALCULATE NET BUTTON PANEL ------
        JPanel calculateButtonPanel = new JPanel();
        calculateButtonPanel.setBounds(100, 645, 1000, 45);
        calculateButtonPanel.setLayout(new GridLayout(1, 3));
        calculateButtonPanel.setBackground(Color.BLACK);
        container.add(calculateButtonPanel);
        calculateButtonPanel.repaint();
        calculateButtonPanel.revalidate();

        // ------ CALCULATE NET BUTTON ------
        calculateNetButton = new JButton();
        calculateNetButton.setBounds(500, 500, 420, 25);
        calculateNetButton.setText("CALCULATE NET");
        calculateNetButton.setBackground(Color.LIGHT_GRAY);
        calculateNetButton.setFont(mainFont);
        calculateNetButton.setForeground(Color.GRAY);
        calculateNetButton.setFocusPainted(false);
        calculateNetButton.setFocusable(false);
        calculateNetButton.setBorderPainted(false);
        calculateNetButton.setContentAreaFilled(true);
        calculateNetButton.setVisible(false);
        userInputNetSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                calculateBrutButton.setVisible(true);
                userInputNetSalary.setBackground(Color.WHITE);
                userInputNetSalary.setText("");
                resetButton.setVisible(true);
            }
        });

        // BORDER AND PADDING ON THE BUTTON
        calculateNetButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.CYAN, 3),
                BorderFactory.createLineBorder(Color.BLACK, 3)));

        // CHANGE BUTTON BACKGROUND ON HOVER
        calculateNetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                calculateNetButton.setBackground(Color.WHITE);
                calculateNetButton.setForeground(Color.DARK_GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                calculateNetButton.setBackground(Color.LIGHT_GRAY);
                calculateNetButton.setForeground(Color.DARK_GRAY);
            }
        });
        calculateNetButton.addActionListener(new CalculateButtonNetSalary());
        calculateButtonPanel.add(calculateNetButton);
        calculateNetButton.revalidate();

        // ------ CALCULATE BRUT BUTTON ------
        calculateBrutButton = new JButton();
        calculateBrutButton.setBounds(500, 500, 420, 25);
        calculateBrutButton.setText("CALCULATE GROSS");
        calculateBrutButton.setBackground(Color.LIGHT_GRAY);
        calculateBrutButton.setFont(mainFont);
        calculateBrutButton.setForeground(Color.GRAY);
        calculateBrutButton.setFocusPainted(false);
        calculateBrutButton.setFocusable(false);
        calculateBrutButton.setBorderPainted(false);
        calculateBrutButton.setContentAreaFilled(true);
        calculateBrutButton.setVisible(false);
        userInputBrutSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                calculateNetButton.setVisible(true);
                userInputBrutSalary.setBackground(Color.WHITE);
                userInputBrutSalary.setText("");
                resetButton.setVisible(true);
            }
        });

        // BORDER AND PADDING ON THE BUTTON
        calculateBrutButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.CYAN, 3),
                BorderFactory.createLineBorder(Color.BLACK, 3)));

        // CHANGE BUTTON BACKGROUND ON HOVER
        calculateBrutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                calculateBrutButton.setBackground(Color.WHITE);
                calculateBrutButton.setForeground(Color.DARK_GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                calculateBrutButton.setBackground(Color.LIGHT_GRAY);
                calculateBrutButton.setForeground(Color.DARK_GRAY);
            }
        });
        calculateBrutButton.addActionListener(new CalculateButtonBrutSalary());
        calculateButtonPanel.add(calculateBrutButton);
        calculateBrutButton.revalidate();

        // ------ RESET BUTTON ------
        resetButton = new JButton();
        resetButton.setBounds(500, 500, 420, 25);
        resetButton.setText("RESET");
        resetButton.setBackground(Color.LIGHT_GRAY);
        resetButton.setFont(mainFont);
        resetButton.setForeground(Color.GRAY);
        resetButton.setFocusPainted(false);
        resetButton.setFocusable(false);
        resetButton.setBorderPainted(false);
        resetButton.setContentAreaFilled(true);
        resetButton.setVisible(false);

        // BORDER AND PADDING ON THE BUTTON
        resetButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.CYAN, 3),
                BorderFactory.createLineBorder(Color.BLACK, 3)));

        // CHANGE BUTTON BACKGROUND ON HOVER
        resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resetButton.setBackground(Color.WHITE);
                resetButton.setForeground(Color.DARK_GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetButton.setBackground(Color.LIGHT_GRAY);
                resetButton.setForeground(Color.DARK_GRAY);
            }
        });
        resetButton.addActionListener(new ResetButton());
        calculateButtonPanel.add(resetButton);
        resetButton.repaint();
        resetButton.revalidate();
    }


    /*
     * ------ Handler the CalculateButtonNetSalary ------
     */
    private class CalculateButtonNetSalary implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String currency = " Lei";
            dataCore.salariuBrut = Double.parseDouble(userInputBrutSalary.getText());

            brutLabel.setText("Gross salary = " + Math.round(dataCore.salariuBrut) + currency);
            casLabel.setText("Social insurance (CAS) " + dataCore.getAsigurariSociale() + "% = " + Math.round(dataCore.asigurareSociala()) + currency);
            cassLabel.setText("Social health insurance (CASS) " + dataCore.getAsigurariSocialeDeSanatate() + "% = " +
                    Math.round(dataCore.asigurariSocialeDeSanatate()) + currency);
            dpLabel.setText("Personal deduction (PD) = " + dataCore.getPersonalDeduction() + currency);
            inpozitLabel.setText("Income tax (IV) " + dataCore.getImpozitPeVenit() + "% = " + Math.round(dataCore.cuantumImpozit()) + currency);
            netSalaryLabel.setText("Net salary = " + Math.round(dataCore.netSalary()) + currency);
            camLabel.setText("Work insurance contribution (CAM) = " + Math.round(dataCore.cuantumCam()) + currency);
            completSalaryLabel.setText("Full salary = " + Math.round(dataCore.cuantumCompletSalary()) + currency);
            childAngajatLabel.setText("The employee pays the state = " + Math.round(dataCore.childAngajatLabel()) + currency);
            childAngajatorLabel.setText("The employer pays the state = " + Math.round(dataCore.cuantumCam()) + currency);
            childStatLabel.setText("Total taxes collected by the state = " + Math.round(dataCore.childStatLabel()) + currency);
            childCheltuieliAngajat.setText("To pay a net salary of (" + Math.round(dataCore.netSalary()) + currency + "), the employer spends (" +
                    Math.round(dataCore.cuantumCompletSalary()) + currency + ")");
            procentAngajatLabel.setText(dataCore.laSutaCatreAngajat() + "% Employee");
            procentStatLabel.setText(dataCore.laSutaCatreStat() + "% State");
        }
    }

    /*
     * ------ Handler the CalculateButtonBrutSalary ------
     */

    private class CalculateButtonBrutSalary implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String currency = " Lei";

            calculateBrutSalary.net = Double.parseDouble(userInputNetSalary.getText());

            brutLabel.setText("Gross salary = " + Math.round(calculateBrutSalary.brutSalary()) + currency);
            brutLabel.setForeground(Color.GREEN);
            casLabel.setText("Social insurance (CAS) " + calculateBrutSalary.getCas() + "% = " + Math.round(calculateBrutSalary.asigurareSociala()) + currency);
            cassLabel.setText("Social health insurance (CASS) " + calculateBrutSalary.getCass() + "% = " +
                    Math.round(calculateBrutSalary.asigurareSocialaDeSanatate()) + currency);
            dpLabel.setText("Personal deduction (PD) = " + calculateBrutSalary.getDeducereaPersonala() + currency);
            inpozitLabel.setText("Income tax (IV) " + calculateBrutSalary.getTax() + "% = " + Math.round(calculateBrutSalary.getTaxCalculated()) +
                    currency);
            netSalaryLabel.setText("Net salary = " + Math.round(calculateBrutSalary.net) + currency);
            netSalaryLabel.setForeground(Color.GREEN);
            camLabel.setText("Insurance contribution for work (CAM) = " + Math.round(calculateBrutSalary.cuantumCam()) + currency);
            completSalaryLabel.setText("Full salary = " + Math.round(calculateBrutSalary.cuantumCompletSalary()) + currency);

            childAngajatLabel.setText("The employee pays the state = " + Math.round(calculateBrutSalary.childAngajatLabel()) + currency);

            childAngajatorLabel.setText("The employer pays the state = " + Math.round(calculateBrutSalary.cuantumCam()) + currency);
            childStatLabel.setText("Total taxes collected by the state = " + Math.round(calculateBrutSalary.childStatLabel()) + currency);
            childCheltuieliAngajat.setText("To pay a net salary of (" + Math.round(calculateBrutSalary.childNetLabel_4()) + currency + ")," +
                    " the employer spends (" + Math.round(calculateBrutSalary.childCompletSalaryLabel_4()) + currency + ")");
            procentAngajatLabel.setText(calculateBrutSalary.laSutaCatreAngajat() + "% Employee");
            procentStatLabel.setText(calculateBrutSalary.laSutaCatreStat() + "% State");
        }
    }

    /*
     * ------ Handler the ResetButton ------
     */
    private class ResetButton implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            //JOptionPane.showMessageDialog(null , "The last amount calculated was " + userInputBrutSalary.getText());
            userInputBrutSalary.setText("0");
            userInputNetSalary.setText("0");
            brutLabel.setText("");
            casLabel.setText("");
            cassLabel.setText("");
            dpLabel.setText("");
            inpozitLabel.setText("");
            netSalaryLabel.setText("");
            camLabel.setText("");
            completSalaryLabel.setText("");
            childAngajatLabel.setText("");
            childAngajatorLabel.setText("");
            childStatLabel.setText("");
            childCheltuieliAngajat.setText("");
            procentAngajatLabel.setText("");
            procentStatLabel.setText("");
        }
    }
}


