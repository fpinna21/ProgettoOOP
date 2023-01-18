import java.util.ArrayList;
import java.util.HashMap;

public class Dottore extends Persona {
    public Dottore(String codice_fiscale, String nome, String cognome, String indirizzo) {
        super(codice_fiscale, nome, cognome, indirizzo);
    }

    private String specializzazione;

    public Dottore(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    String getSpecializzazione() {
        return specializzazione;
    }
}



// radiologo,fisioterapista,chirurgo,ortopedico//