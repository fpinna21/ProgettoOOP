import java.io.Serializable;
import java.util.Date;

public class Appuntamento implements  Comparable < Appuntamento >{

    private String ora_inizio;
    private String ora_fine;
    private Paziente cliente;
    private Dottore medico;
    private Date data;
    private String descrizione;
    public Appuntamento(String descrizione, String ora_inizio, String ora_fine, Paziente paziente, Dottore dottore) {
        this.medico = dottore;
        this.descrizione = descrizione;
        this.ora_inizio = ora_inizio;
        this.ora_fine = ora_fine;
        this.cliente = paziente;

    }




    public String getOra_inizio() {
        return ora_inizio;
    }
    public void setOra_inizio(String ora_inizio) {
        this.ora_inizio = ora_inizio;
    }

    public String getOra_fine() {
        return ora_fine;
    }
    public void setOra_fine(String ora_fine) {
        this.ora_fine = ora_fine;
    }
    public Paziente getCliente() {
        return cliente;
    }

    public void setCliente(Paziente cliente) {
        this.cliente = cliente;
    }

    public Dottore getMedico() {
        return medico;
    }

    public void setMedico(Dottore medico) {
        this.medico = medico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }


    @Override
    public int compareTo(Appuntamento o) {
        return 0;
    }
}


