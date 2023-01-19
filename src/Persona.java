public class Persona  {

    public String nome;
    public String cognome;
    public String codice_fiscale;
    public String indirizzo;

    public Persona(String codice_fiscale, String nome, String cognome, String indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.codice_fiscale = codice_fiscale;
        this.indirizzo = indirizzo;

    }

    public Persona() {
    }

    public String getNome(){

        return nome;
    }

    void setNome(String nome1){
        this.nome = nome1;
    }


    public String getCognome(){
        return cognome;
    }

    void setCognome(String cognome1){
        this.cognome = cognome1;
    }

    public String getCodice_fiscale(){
        return codice_fiscale;
    }

    void setCodice_fiscale(String codice_fiscale1){
        this.codice_fiscale = codice_fiscale1;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    void setIndirizzo(String indirizzo1){
        this.indirizzo = indirizzo1;
    }

}