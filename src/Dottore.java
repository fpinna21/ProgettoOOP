public class Dottore
        extends Persona {
    public String nome;
    public String cognome;
    public String codice_fiscale;
    public String indirizzo;
    private String specializzazione;

    public Dottore(String specializzazione) {

        this.specializzazione = specializzazione;
    }

    public Dottore() {

    }

    String getSpecializzazione() {

        return specializzazione;
    }
}



// radiologo,fisioterapista,chirurgo,ortopedico//