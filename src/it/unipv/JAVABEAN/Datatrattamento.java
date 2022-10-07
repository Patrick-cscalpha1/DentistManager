
package it.unipv.JAVABEAN;


public class Datatrattamento {
        private String IDtrattamento,nometrattamento,costo,nomeutentedentista;

    public Datatrattamento( String nometrattamento, String costo, String nomeutentedentista) {
       // this.IDtrattamento = IDtrattamento;
        this.nometrattamento = nometrattamento;
        this.costo = costo;
        this.nomeutentedentista = nomeutentedentista;
    }

    


    public String getNometrattamento() {
        return nometrattamento;
    }

    public String getCosto() {
        return costo;
    }

    public String getNomeutentedentista() {
        return nomeutentedentista;
    }
    
}
