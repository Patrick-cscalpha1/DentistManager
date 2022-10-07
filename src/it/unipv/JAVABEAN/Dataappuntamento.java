
package it.unipv.JAVABEAN;


public class Dataappuntamento {
    private String IDappuntamento,dataappuntamento,cfpaziente,trattamento,orario,nomeutentedentista;

    public Dataappuntamento( String dataappuntamento, String cfpaziente, String trattamento, String orario, String nomeutentedentista) {
        //this.IDappuntamento = IDappuntamento;
        this.dataappuntamento = dataappuntamento;
        this.cfpaziente = cfpaziente;
        this.trattamento = trattamento;
        this.orario = orario;
        this.nomeutentedentista = nomeutentedentista;
    }

    

    public String getDataappuntamento() {
        return dataappuntamento;
    }

    public String getCfpaziente() {
        return cfpaziente;
    }

    public String getTrattamento() {
        return trattamento;
    }

    public String getOrario() {
        return orario;
    }

    public String getNomeutentedentista() {
        return nomeutentedentista;
    }

   
    
    
}
