package responsabilities;

import etablissment.Demande;
import etablissment.Departement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceGestionPatrimoine implements Service{
    private static Logger log = LoggerFactory.getLogger(ServiceGestionPatrimoine.class);

    private Service nextService;
    
    @Override
    public void handle(Demande demande) {
        log.info("==Traitement Service de gestion de patrimoine==");

        Departement department = demande.getDepartement();

        log.info("Soustraction de montant de la demande de budget de departement...");
        log.info("Budget de departement avant l'achat : {} UM" , department.getBudget() );
        log.info("Le montant de la demande : {} UM",demande.getMontant());

        department.setBudget(department.getBudget()-demande.getMontant());

        log.info("Budget de departement apres l'achat : {} UM" , department.getBudget());
        log.info("Debloguage...");

        department.setMontantBloquee(0);

        log.info("==Fin de Traitement de Service de Patrimione ==");

    }

    @Override
    public void setNext(Service serice) {
        this.nextService = serice;
    }
}
