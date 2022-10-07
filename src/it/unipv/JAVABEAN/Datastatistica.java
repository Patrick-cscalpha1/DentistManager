
package it.unipv.JAVABEAN;

public class Datastatistica {
private int numeropaziente,numerotrattamenti,numeroprescrizioni; 

    public Datastatistica(int numeropaziente, int numerotrattamenti, int numeroprescrizioni) {
        this.numeropaziente = numeropaziente;
        this.numerotrattamenti = numerotrattamenti;
        this.numeroprescrizioni = numeroprescrizioni;
    }

    public int getNumeropaziente() {
        return numeropaziente;
    }

    public int getNumerotrattamenti() {
        return numerotrattamenti;
    }

    public int getNumeroprescrizioni() {
        return numeroprescrizioni;
    }
    
}
