package responsabilities;


import etablissment.Demande;

public interface Service {
    void handle(Demande demande);

    void setNext(Service serice);
}
