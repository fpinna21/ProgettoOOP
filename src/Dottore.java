import java.util.ArrayList;
import java.util.HashMap;

public class Dottore extends Persona {


    private String specializzazione;

    public Dottore(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    String getSpecializzazione() {
        return specializzazione;
    }
}



// radiologo,fisioterapista,chirurgo,ortopedico//