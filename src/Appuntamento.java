import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Appuntamento {

    private String ora_inizio;
    private String ora_fine;
    private Paziente cliente;
    private Dottore medico;
    private Date data;
    private String descrizione;
    public Appuntamento(String descrizione, String ora_inizio, String ora_fine, Paziente paziente, Dottore dottore) {
        this.cliente.nome = paziente.nome;
        this.cliente.cognome = paziente.cognome;
        this.cliente.indirizzo = paziente.indirizzo;
        this.cliente.num_telefono = paziente.num_telefono;
        this.cliente.code_prenotazione = paziente.code_prenotazione;
        this.cliente.codice_fiscale = paziente.codice_fiscale;
        this.medico.nome = dottore.nome;
        this.medico.cognome = dottore.cognome;
        this.medico.codice_fiscale = dottore.codice_fiscale;
        this.medico.indirizzo = dottore.indirizzo;
        this.descrizione = descrizione;
        this.ora_inizio = ora_inizio;
        this.ora_fine = ora_fine;
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
    void aggiungiAppuntamento(ArrayList<Appuntamento>lista) {

        Appuntamento a = null;

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
            String ora_inizio = arr[1];
            String ora_fine = arr[2];
            Paziente cliente = new Paziente();
            Dottore dottore = new Dottore();
            Appuntamento p = new Appuntamento(descrizione, ora_inizio, ora_fine, cliente, dottore);
            elencoAppuntamenti.add(p);
        }
    }
}


