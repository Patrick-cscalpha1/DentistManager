
package it.unipv.JAVABEAN;


public class Datadentista {

    private String nome,cognome,nomeutente,password,emaildentista,cellularedentista;

    public Datadentista(String nome, String cognome, String nomeutente, String password, String emaildentista, String cellularedentista) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomeutente = nomeutente;
        this.password = password;
        this.emaildentista = emaildentista;
        this.cellularedentista = cellularedentista;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNomeutente() {
        return nomeutente;
    }

    public String getPassword() {
        return password;
    }

    public String getEmaildentista() {
        return emaildentista;
    }

    public String getCellularedentista() {
        return cellularedentista;
    }

  
    
}
