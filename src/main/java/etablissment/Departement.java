package etablissment;

public class Departement {
    private String name;
    private double budget;
    private double montantBloquee;

    public Departement(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    public Departement() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getMontantBloquee() {
        return montantBloquee;
    }

    public void setMontantBloquee(double montantBloquee) {
        this.montantBloquee = montantBloquee;
    }
}
