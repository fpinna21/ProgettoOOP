import java.io.*;

public class Paziente
        extends Persona implements Serializable {
    public String nome;
    public String cognome;
    public String codice_fiscale;
    public String indirizzo;
    public int code_prenotazione;
    public String num_telefono;
    public Paziente(String nome, String cognome, String codice, String numero, String indirizzo, int i) {
        this.nome = nome;
        this.cognome = cognome;
        this.codice_fiscale = codice;
        this.num_telefono = numero;
        this.indirizzo = indirizzo;
        this.code_prenotazione = i;
    }
    public Paziente(Paziente paziente) {
        this.nome = paziente.nome;
        this.cognome = paziente.cognome;
        this.codice_fiscale = paziente.codice_fiscale;
        this.indirizzo = paziente.indirizzo;
        this.num_telefono = paziente.num_telefono;
        this.code_prenotazione = paziente.code_prenotazione;
    }

    public Paziente() {

    }

    void setCode_prenotazione(int codice) {
        this.code_prenotazione = codice;
    }

    int getCode_prenotazione() {
        return code_prenotazione;
    }

    String getNum_telefono() {
        return num_telefono;
    }

    void setNum_telefono(String numero) {
        this.num_telefono = numero;
    }

    @Override
    public String toString() {
        return "Paziente{" +
                "code_prenotazione='" + code_prenotazione + '\'' +
                ", num_telefono='" + num_telefono + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", codice_fiscale='" + codice_fiscale + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }

}




