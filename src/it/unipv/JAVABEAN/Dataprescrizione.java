
package it.unipv.JAVABEAN;


public class Dataprescrizione {
//vedere come gestire id
    private String IDprescrizione,nomeprescrizione,quantita,dataprescrizione,nometrattamento,cfpaziente,nomeutentedentista;

    public Dataprescrizione( String nomeprescrizione, String quantita, String dataprescrizione, String nometrattamento, String cfpaziente, String nomeutentedentista) {
       // this.IDprescrizione = IDprescrizione;
        this.nomeprescrizione = nomeprescrizione;
        this.quantita = quantita;
        this.dataprescrizione = dataprescrizione;
        this.nometrattamento = nometrattamento;
        this.cfpaziente = cfpaziente;
        this.nomeutentedentista = nomeutentedentista;
    }

   

    public String getNomeprescrizione() {
        return nomeprescrizione;
    }

    public String getQuantita() {
        return quantita;
    }

    public String getDataprescrizione() {
        return dataprescrizione;
    }

    public String getNometrattamento() {
        return nometrattamento;
    }

    public String getCfpaziente() {
        return cfpaziente;
    }

    public String getNomeutentedentista() {
        return nomeutentedentista;
    }
    
    
    
}
