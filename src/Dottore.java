import javax.management.StringValueExp;
import java.io.*;
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
    public Dottore() {
        super();
        this.nome = nome;
        this.cognome = cognome;
        this.codice_fiscale = codice_fiscale;
        this.indirizzo = indirizzo;
        this.specializzazione = specializzazione;
        this.password = password;
        this.numero_telefono = numero_telefono;
    }
    String getSpecializzazione() {
        return specializzazione;
    }
    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    void setNome(String nome1) {
        super.setNome(nome1);
    }

    @Override
    public String getCognome() {
        return super.getCognome();
    }

    @Override
    void setCognome(String cognome1) {
        super.setCognome(cognome1);
    }

    @Override
    public String getCodice_fiscale() {
        return super.getCodice_fiscale();
    }

    @Override
    void setCodice_fiscale(String codice_fiscale1) {
        super.setCodice_fiscale(codice_fiscale1);
    }

    @Override
    public String getIndirizzo() {
        return super.getIndirizzo();
    }

    @Override
    void setIndirizzo(String indirizzo1) {
        super.setIndirizzo(indirizzo1);
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
}



