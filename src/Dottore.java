import java.io.*;
import java.util.Objects;

public class Dottore
        extends Persona implements Serializable {
    public String nome;
    public String cognome;
    public String codice_fiscale;
    public String indirizzo;
    public String specializzazione;
    public String password;
    public String numero_telefono;
    public Dottore(String s, String s1, String s2, String s3, String s4, String s5) {
        this.nome = s;
        this.cognome = s1;
        this.codice_fiscale = s2;
        this.indirizzo = s3;
        this.numero_telefono = s4;
        this.specializzazione = s5;
        this.password = "0000";

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

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o instanceof Dottore dottore)) return ((Dottore) o).getCodice_fiscale().equals(this.getCodice_fiscale());
        if((o instanceof Dottore)) return ((Dottore) o).codice_fiscale.equals(this.codice_fiscale);
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getCognome(), getCodice_fiscale(), getIndirizzo(), getSpecializzazione(), getPassword(), getNumero_telefono());
    }

    @Override
    public String toString() {
        return "Dottore{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", codice_fiscale='" + codice_fiscale + '\'' +
                ", specializzazione='" + specializzazione + '\'' +
                ", numero_telefono='" + numero_telefono + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }
}



