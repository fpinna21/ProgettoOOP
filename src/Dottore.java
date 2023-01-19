import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Dottore
        extends Persona implements Serializable {
    public String nome;
    public String cognome;
    public String codice_fiscale;
    public String indirizzo;
    public String specializzazione;
    public String password;
    public String numero_telefono;

    public Dottore(String codice_fiscale, String nome, String cognome, String indirizzo, String specializzazione, String numero_telefono) {
        super(codice_fiscale, nome, cognome, indirizzo);
        this.nome = nome;
        this.cognome = cognome;
        this.codice_fiscale = codice_fiscale;
        this.indirizzo = indirizzo;
        this.numero_telefono = numero_telefono;
        this.specializzazione = specializzazione;
        this.password = password;
    }
    public Dottore() {
        super();
        this.nome = nome;
        this.cognome = cognome;
        this.codice_fiscale = codice_fiscale;
        this.indirizzo = indirizzo;
        this.specializzazione = specializzazione;
        this.password = password;
    }

    String getSpecializzazione() {

        return specializzazione;
    }
static int i=0;
    static void aggiungiPaziente(ArrayList<Paziente> elenco) {

        Paziente p = new Paziente("0","0","0","0","0",0);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserire le informazioni del paziente nel seguente ordine intervallate da una virgola: nome, cognome, codice fiscale, numero di telefono, indirizzo");
        System.out.println("Quando hai terminato inserisci 'stop' per uscire");
        while (true) {

            String s = scanner.nextLine();
            if (s.equals("stop")) {
                break;
            }
            String[] arr = s.split(",");
            p.nome = arr[0];
            p.cognome = arr[1];
            p.codice_fiscale = arr[2];
            p.num_telefono = arr[3];
            p.indirizzo = arr[4];
            int utente =  i++ ;

            elenco.add(p);
            System.out.println(elenco + "\n");
        }
    }
}



// radiologo,fisioterapista,chirurgo,ortopedico//