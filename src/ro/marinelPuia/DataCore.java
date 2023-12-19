package ro.marinelPuia;

public class DataCore {
    public double salariuBrut;

    // ------ The employee pays the state ------
    private double asigurariSociale = 25d; // 25% din salariu brut
    private double asigurariSocialeDeSanatate = 10d; // 10% din salariu brut
    private double deducerePersonala = 0d;
    private double impozitPeVenit= 10d; // 10% salariuImpozabil
    //Angajatorul plateste statului
    private double contributieAsiguratoriePentruMunca = 2.25d; // 2.25% din salariuBrut

    // ------ Default constructor ------
    DataCore() {}

    public DataCore(double asigurariSociale, double asigurariSocialeDeSanatate, double deducerePersonala,
                    double impozitPeVenit, double contributieAsiguratoriePentruMunca) {
        this.asigurariSociale = asigurariSociale;
        this.asigurariSocialeDeSanatate = asigurariSocialeDeSanatate;
        this.deducerePersonala = deducerePersonala;
        this.impozitPeVenit = impozitPeVenit;
        this.contributieAsiguratoriePentruMunca = contributieAsiguratoriePentruMunca;
    }

    public double getAsigurariSociale() {
        return asigurariSociale;
    }

    public double getAsigurariSocialeDeSanatate() {
        return asigurariSocialeDeSanatate;
    }

    public double getPersonalDeduction() {
        return deducerePersonala;
    }

    public double getImpozitPeVenit() {
        return impozitPeVenit;
    }

    public double getContributionInsuranceForWork() {
        return contributieAsiguratoriePentruMunca;
    }

    // ------ Methods to calculate ------

    public double asigurareSociala() {
        return (asigurariSociale / 100) * salariuBrut;
    }

    public double asigurariSocialeDeSanatate() {
        return (asigurariSocialeDeSanatate / 100) * salariuBrut;
    }

    public double cuantumImpozit() {
        double cuantumAsigurari = asigurareSociala() + asigurariSocialeDeSanatate();
        double salariuImpozabil = salariuBrut - cuantumAsigurari;
        return (impozitPeVenit / 100)  * salariuImpozabil;
    }

    public double cuantumAsigurari() {
        return asigurareSociala() + asigurariSocialeDeSanatate();
    }

    public double netSalary() {
        return salariuBrut - (cuantumAsigurari() + cuantumImpozit());
    }
    public double cuantumCam() {
        return ((contributieAsiguratoriePentruMunca / 100) * salariuBrut);
    }

    public double cuantumCompletSalary() {
        return salariuBrut + cuantumCam();
    }

    public double childAngajatLabel() {
       return cuantumAsigurari()+ cuantumImpozit();
    }

    public double childStatLabel() {
        return cuantumCam() + childAngajatLabel();
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
