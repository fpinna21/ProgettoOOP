import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Appuntamento implements Serializable {
    public Paziente cliente;
    public Dottore medico;
    public LocalDateTime data;
    public String descrizione;
    public LocalTime oraFine;

    public Appuntamento(Paziente cliente, Dottore medico, LocalDateTime data, String descrizione) {
        this.cliente = cliente;
        this.medico = medico;
        this.data = data;
        this.descrizione = descrizione;
        this.oraFine = LocalTime.from(this.data.plus(1, ChronoUnit.HOURS));
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

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalTime getOraFine() {
        return oraFine;
    }

    public void setOraFine(LocalTime oraFine) {
        this.oraFine = oraFine;
    }

    @Override
    public String toString() {
        return "Appuntamento{" +
                "cliente=" + cliente +
                ", medico=" + medico +
                ", data=" + data +
                ", descrizione='" + descrizione + '\'' +
                ", oraFine=" + oraFine +
                "} \n";
    }
}


