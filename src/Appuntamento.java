
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Appuntamento {
    HashMap<String, ArrayList<Paziente>> h = new HashMap<String, ArrayList<Paziente>>();
    private String ora_inizio;
    private String ora_fine;
    private Paziente cliente;
    private Dottore medico;

    private Date data;
    private String descrizione;

    public Appuntamento(String descrizione, String ora_inizio, String ora_fine, Paziente cliente) {
        this.descrizione = descrizione;
        this.ora_inizio = ora_inizio;
        this.ora_fine = ora_fine;
        this.cliente = cliente;
    }

    public String getDescrizione() {

        return descrizione;
    }

    public String getOra_inizio() {

        return ora_inizio;
    }

    public String getOra_fine() {

        return ora_fine;
    }

    public Paziente getCliente() {

        return cliente;
    }

    public Dottore getMedico(){

        return medico;
    }

    void aggiungiAppuntamento(ArrayList<Paziente>lista) {

        int i = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Appuntamento> elencoAppuntamenti = new ArrayList<>();
        System.out.println("Inserire le informazioni del paziente nel seguente ordine intervallate da una virgola: nome, cognome, codice fiscale, numero di telefono, indirizzo");
        System.out.println("Quando hai terminato inserisci 'stop' per uscire");
        while (true) {

            String s = scanner.nextLine();
            if (s.equals("stop")) {
                break;
            }
            String[] arr = s.split(",");
            String descrizione = arr[0];
            String ora_inizio = arr[1];
            String ora_fine = arr[2];
            Paziente cliente = new Paziente(lista.get(i));


            Appuntamento p = new Appuntamento(descrizione, ora_inizio, ora_fine, cliente);
            elencoAppuntamenti.add(p);

        }
    }




}


