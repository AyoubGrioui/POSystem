package etablissment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class Demande {

    private static Logger logger = LoggerFactory.getLogger(Demande.class);
    public List<Observer> obs;
    private Departement departement;
    private double montant;

    public Demande(Departement departement, double montant) {
        logger.info("Demande cree");
        this.departement = departement;
        this.montant = montant;
        obs = new ArrayList<>();
    }

    public void addObserver(Observer o) {
        if (o == null)
            throw new NullPointerException();
        else if (!obs.contains(o)) {
            obs.add(o);
        }
    }

    public void notifyEtablissement() {
        for (Observer o : obs)
            o.update(this);
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
