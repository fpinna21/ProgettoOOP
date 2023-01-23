import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Appuntamento implements  Comparable < Appuntamento >{
    public String ora_inizio;
    public String ora_fine;
    public Paziente cliente;
    public Dottore medico;
    public Date data;
    public String descrizione;

    public HashMap<Dottore, ArrayList<Appuntamento>> h = new HashMap<>();

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

    public Appuntamento() {
        this.ora_inizio = null;
        this.ora_fine = null;
        this.cliente = null;
        this.medico = null;
        this.data = null;
        this.descrizione = null;

    }

    public Appuntamento(String ora_inizio, String ora_fine, String descrizione, Paziente cliente, Dottore medico) {
        this.ora_inizio = ora_inizio;
        this.ora_fine = ora_fine;
        this.cliente = cliente;
        this.medico = medico;
        this.descrizione = descrizione;
    }

    @Override
    public int compareTo(Appuntamento o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Appuntamento{" +
                "ora_inizio='" + ora_inizio + '\'' +
                ", ora_fine='" + ora_fine + '\'' +
                ", cliente=" + cliente +
                ", medico=" + medico +
                ", data=" + data +
                ", descrizione='" + descrizione + '\'' +
                ", h=" + h +
                '}';
    }
}


