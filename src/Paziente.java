import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Paziente extends Persona implements Serializable {

    private String code_prenotazione;
    private String num_telefono;

    public Paziente() {
        this.nome = String.valueOf(nome);
        this.cognome = String.valueOf(cognome);
        this.code_prenotazione = String.valueOf(code_prenotazione);
        this.num_telefono = String.valueOf(num_telefono);
        this.indirizzo = String.valueOf(indirizzo);


    }

    public Paziente(String nome, String cognome, String codice, String numero, String indirizzo) {
        this.nome=nome;
        this.cognome=cognome;
        this.codice_fiscale=codice;
        this.num_telefono=numero;
        this.indirizzo=indirizzo;
    }


    void setCode_prenotazione(String codice) {
        this.code_prenotazione = codice;
    }

    String getCode_prenotazione() {
        return code_prenotazione;
    }

    String getNum_telefono() {
        return num_telefono;
    }

    void setNum_telefono(String numero) {
        this.num_telefono = numero;
    }

    void aggiungiPaziente() {

            Scanner scanner = new Scanner(System.in);
            ArrayList<Paziente> elencoPazienti = new ArrayList<>();
            int i = 0;

            System.out.println("Inserire le informazioni del paziente nel seguente ordine intervallate da una virgola: nome, cognome, codice fiscale, numero di telefono, indirizzo");
            System.out.println("Quando hai terminato inserisci 'stop' per uscire");
            while (true) {

                String s = scanner.nextLine();
                if (s.equals("stop")) {
                    break;
                }
                String[] arr = s.split(",");
                String nome = arr[0];
                String cognome = arr[1];
                String codice = arr[2];
                String numero = arr[3];
                String indirizzo = arr[4];

                Paziente p = new Paziente(nome, cognome, codice, numero, indirizzo);
                elencoPazienti.add(p);
                for (i = 0; i < elencoPazienti.size(); i++) {
                    System.out.print(elencoPazienti.toString());
                }
            }

            try{
                File file = new File("bin.bin");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream = new ObjectOutputStream(fileOutputStream);

                String nome;
                String cognome;
                String codice_fiscale;
                String numero_telefono;
                String indirizzo;
                
            }catch (){

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
}
