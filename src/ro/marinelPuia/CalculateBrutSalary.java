package ro.marinelPuia;

import static ro.marinelPuia.CalculatorInterface.userInputNetSalary;

public class CalculateBrutSalary extends DataCore {

    private static final double oneHundredPercent = 100d; // 100%
    public double net; // net salary
    private double tax = 10d;
    private double taxCalculated = (net * tax) / 90d;
    private double taxableIncome = net + tax;
    private double personalDeduction = 0;
    private double netIncome =  net + tax;
    private double cas = 10; // 10% from salariuBrut
    private double cass = 25; // 25% from salariuBrut

    private double contributionInsuranceForWork; // 2.25% din salariuBrut

    private double totalContributions = cas + cass;
    private double leftFrom100Percent = oneHundredPercent - totalContributions;

    private double totalEmployerExpenses = (netIncome * totalContributions) / leftFrom100Percent;
    private double grossIncome = netIncome + totalEmployerExpenses;

    private double grossTotal = ((2.25 / 100) * grossIncome);

    public CalculateBrutSalary(double personalDeduction, double cas, double cass, double contributionInsuranceForWork) {
        this.personalDeduction = personalDeduction;
        this.cas = cas;
        this.cass = cass;
        this.contributionInsuranceForWork = contributionInsuranceForWork;
    }

    public double getTax() {
        return tax;
    }

    public double getTaxCalculated() {
        return (net * tax) / 90;
    }


    public double getPersonalDeduction() {
        return this.personalDeduction;
    }

    public double getCas() {
        return this.cas;
    }

    public double getCass() {
        return this.cass;
    }

    public double getContributionInsuranceForWork() {
        return this.contributionInsuranceForWork;
    }

    public double getDeducereaPersonala() {
        return personalDeduction;
    }

    public double asigurareSociala() {
        double net = Double.parseDouble(userInputNetSalary.getText());
        double impozit = (net *10) / 90;
        double venitNet =  net + impozit;
        double totalCheltuieliAngajator = (venitNet * totalContributions) / leftFrom100Percent;
        double venitBrut = venitNet + totalCheltuieliAngajator;

        return (cas / 100) * venitBrut;
    }

    public double asigurareSocialaDeSanatate() {
        double net = Double.parseDouble(userInputNetSalary.getText());
        double impozit = (net *10) / 90;
        double venitNet =  net + impozit;
        double totalCheltuieliAngajator = (venitNet * totalContributions) / leftFrom100Percent;
        double venitBrut = venitNet + totalCheltuieliAngajator;

        return (cass / 100) * venitBrut;
    }

    public double brutSalary() {
        double net = Double.parseDouble(userInputNetSalary.getText());
        double impozit = (net *10) / 90;
        double venitNet =  net + impozit;
        double totalCheltuieliAngajator = (venitNet * totalContributions) / leftFrom100Percent;

        return venitNet + totalCheltuieliAngajator;
    }

    public double cuantumCam() {
        return ((contributionInsuranceForWork / 100) * brutSalary());
    }

    public double cuantumCompletSalary() {
        return brutSalary() + cuantumCam();
    }

    public double childAngajatLabel() {
        double net = Double.parseDouble(userInputNetSalary.getText());
        double impozit = (net *10) / 90;
        double venitNet =  net + impozit;
        double totalCheltuieliAngajator = (venitNet * totalContributions) / leftFrom100Percent;
        double venitBrut = venitNet + totalCheltuieliAngajator;
        double cuantumCas = (cas / 100) * venitBrut;
        double cuantumCass = (cass / 100) * venitBrut;
        return cuantumCas + cuantumCass + impozit;
    }

    public double childStatLabel() {
        return cuantumCam() + childAngajatLabel();
    }

    public double childNetLabel_4() {
        return net = Double.parseDouble(userInputNetSalary.getText());
    }

    public double childCompletSalaryLabel_4() {
         return cuantumCompletSalary();
    }

    public double laSutaCatreStat() {
        double totalTaxeCatreStat =  childStatLabel();
        double cheltuieleTotaleAngajator = cuantumCompletSalary();
        return Double.parseDouble(String.format("%,.2f", (totalTaxeCatreStat * 100) / cheltuieleTotaleAngajator));
    }

    public double laSutaCatreAngajat() {
        return Double.parseDouble(String.format("%,.2f",100 - laSutaCatreStat()));
    }
}
