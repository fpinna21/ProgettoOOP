public class Appuntamento {
    private String descrizione;
    private String ora_inizio;
    private String ora_fine;
    private String cliente;
    private String medico;

    public Appuntamento(String descrizione, String ora_inizio, String ora_fine, String cliente, String medico){
        this.descrizione = descrizione;
        this.ora_inizio = ora_inizio;
        this.ora_fine = ora_fine;
        this.cliente = cliente;
        this.medico = medico;
    }

    public String getDescrizione() {

        return descrizione;
    }

    public String getOra_inizio() {

        return ora_inizio;
    }

    public String getOra_fine() {

        return ora_fine;
    }

    public String getCliente() {

        return cliente;
    }

    public String getMedico(){

        return medico;
    }
}

