
package it.unipv.JAVABEAN;


public class Datapaziente {
        private String IDpaziente,nome,cognome,cf,indirizzo,emailpaziente,cellularepaziente,nomeutentedentista;

    public Datapaziente( String nome, String cognome, String cf, String indirizzo, String emailpaziente, String cellularepaziente, String nomeutentedentista) {
        //this.IDpaziente = IDpaziente;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.indirizzo = indirizzo;
        this.emailpaziente = emailpaziente;
        this.cellularepaziente = cellularepaziente;
        this.nomeutentedentista = nomeutentedentista;
    }


   

   

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCf() {
        return cf;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getEmailpaziente() {
        return emailpaziente;
    }

    public String getCellularepaziente() {
        return cellularepaziente;
    }

    public String getNomeutentedentista() {
        return nomeutentedentista;
    }

    
    
}
