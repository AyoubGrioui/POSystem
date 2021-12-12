package responsabilities;

import etablissment.Demande;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ServiceComptable implements Service {

    private static Logger log = LoggerFactory.getLogger(ServiceComptable.class);

    private Service nextService;

    public ServiceComptable() {
        //No Args Constructor
    }

    @Override
    public void handle(Demande demande) {
        log.info("== Traitement de Service Comptable ==");

        if (demande.getDepartement().getBudget() < demande.getMontant()) {
            log.error("Budget insuffisant!");
            log.info("==Fin de Traitement de Service Comptable==");

        } else {

            log.info("Bloquage de budget...");

            demande.getDepartement().setMontantBloquee(demande.getMontant());

            log.info("Le montant bloquee est : {}",demande.getMontant());
            log.info("==Fin de Traitement de Service Comptable==");

            this.nextService.handle(demande);

        }

    }

    @Override
    public void setNext(Service service) {
        this.nextService = service;
    }
}
