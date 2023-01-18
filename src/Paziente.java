import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Paziente extends Persona implements Serializable {

    private int code_prenotazione;
    private String num_telefono;

    public Paziente() {
        this.nome = String.valueOf(nome);
        this.cognome = String.valueOf(cognome);
        this.num_telefono = String.valueOf(num_telefono);
        this.indirizzo = String.valueOf(indirizzo);
        this.code_prenotazione = code_prenotazione;

    }

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



    public void scriviFileBin(ArrayList<Paziente> elencoPazienti) {
        FileOutputStream fileOut;

        try {
            fileOut = new FileOutputStream("bin.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(elencoPazienti);
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException." + ex.getMessage());
        }
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

    void stampaElencoPazienti(ArrayList<Paziente> elenco) throws IOException, ClassNotFoundException {
        int i = 0;

        leggiFile(elenco);

        for (i = 0; i < elenco.size(); i++) {
            System.out.print(elenco.toString());
        }

    }
    public void leggiFile(ArrayList<Paziente>elencoP) throws IOException, ClassNotFoundException {// alunno in un FILE BIANARIO tramite la serializzazione
        ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("bin.bin"));
        fbinarioOut.writeObject(elencoP);
        fbinarioOut.flush();
        fbinarioOut.close();

        ObjectInputStream fin = new ObjectInputStream(new FileInputStream("bin.bin"));
        elencoP = (ArrayList<Paziente>) fin.readObject();

        System.out.println(elencoP);


        PrintWriter ftestoOut = new PrintWriter(new FileWriter("bin.txt"));
        ftestoOut.println(elencoP);
        ftestoOut.close();


    }

}




