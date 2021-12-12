package etablissment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import responsabilities.ServiceComptable;
import responsabilities.ServiceGestionPatrimoine;

import java.util.ArrayList;
import java.util.List;

public class Etablissement implements Observer {
    private static Logger log = LoggerFactory.getLogger(Etablissement.class);

    private List<Departement> departments;
    private ServiceComptable serviceComptable;
    private ServiceGestionPatrimoine serviceGestionPatrimoine;

    public Etablissement() {
        this.departments = new ArrayList<>();
        this.serviceComptable = new ServiceComptable();
        this.serviceGestionPatrimoine = new ServiceGestionPatrimoine();
        this.serviceComptable.setNext(this.serviceGestionPatrimoine);
    }

    public void ajouterDepartement(Departement departement) {
        this.departments.add(departement);
    }

    public List<Departement> getDepartments() {
        return departments;
    }

    @Override
    public void update(Demande demande) {
        log.info("==Traitemet de nouvelle demande ==");
        serviceComptable.handle(demande);
        log.info("==Fin Traitemet ==");
    }
}
