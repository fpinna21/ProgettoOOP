import java.io.*;
import java.util.ArrayList;

public class Paziente
        extends Persona implements Serializable {
    public String nome;
    public String cognome;
    public String codice_fiscale;
    public String indirizzo;
    public int code_prenotazione;
    public String num_telefono;
    public String password;
    public Paziente(String nome, String cognome, String codice, String numero, String indirizzo, int i) {
        this.nome = nome;
        this.cognome = cognome;
        this.codice_fiscale = codice;
        this.num_telefono = numero;
        this.indirizzo = indirizzo;
        this.code_prenotazione = i;
        this.password = "0000";

    }

    public Paziente() {
        this.nome = nome;
        this.cognome = cognome;
        this.codice_fiscale = codice_fiscale;
        this.num_telefono = num_telefono;
        this.indirizzo = indirizzo;
        this.code_prenotazione = code_prenotazione;
        this.password = "0000";

    }

    public int getCode_prenotazione() {
        return code_prenotazione;
    }

    public void setCode_prenotazione(int code_prenotazione) {
        this.code_prenotazione = code_prenotazione;
    }

    public String getNum_telefono() {
        return num_telefono;
    }

    public void setNum_telefono(String num_telefono) {
        this.num_telefono = num_telefono;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getCognome() {
        return cognome;
    }

    @Override
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String getCodice_fiscale() {
        return codice_fiscale;
    }

    @Override
    public void setCodice_fiscale(String codice_fiscale) {
        this.codice_fiscale = codice_fiscale;
    }

    @Override
    public String getIndirizzo() {
        return indirizzo;
    }

    @Override
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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




