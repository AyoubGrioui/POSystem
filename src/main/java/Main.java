import etablissment.Demande;
import etablissment.Departement;
import etablissment.Etablissement;

public class Main {
    public static void main(String[] args) {
        Etablissement etablissment = new Etablissement();
        Departement departement = new Departement("IT",50000);
        etablissment.ajouterDepartement(departement);
        Demande demande = new Demande(departement,20000);
        demande.addObserver(etablissment);
        demande.notifyEtablissement();
        Demande newDemande = new Demande(departement,40000);
        newDemande.addObserver(etablissment);
        newDemande.notifyEtablissement();
    }
}
