import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<Paziente> elencopazienti = new ArrayList<>();
        ArrayList<Dottore> elencomedici = new ArrayList<>();
        int indice;
        Paziente paziente;

        elencopazienti = leggiFile(elencopazienti, elencomedici);

        stampaElencoPazienti(elencopazienti);

        System.out.println("""
                Menu :\s
                 1)paziente
                 2)medico""");
        int scelta = in.nextInt();
        switch (scelta) {
            case 1:
                System.out.println("""
                        Menu:\s
                        1)cliente esistente
                        2)nuovo cliente""");
                scelta = in.nextInt();
                switch (scelta) {
                    case 1:

                        System.out.println("Scrivere il proprio codice fiscale");
                        String codiceF = in.next();
                        indice = cercaPaziente(elencopazienti, codiceF);
                        paziente = elencopazienti.get(indice);
                        System.out.println("inserire la password");
                        String password = in.next();
                        if (paziente.password.equals(password)) {
                            System.out.println("""
                                    Menu :\s
                                     1)prendere appuntamento
                                     2)cancellare appuntamento
                                     3)contattare segreteria
                                     4)cambiare password
                                     5)indietro""");


                            scelta = in.nextInt();
                            switch (scelta) {
                                case 1:

                                case 2:

                                case 3:

                                case 4:
                                    System.out.println("inserire nuova password");
                                    paziente.password = in.next();
                                    elencopazienti.set(indice, paziente);
                                    caricaFileBinario(elencopazienti, elencomedici);
                                    System.out.println("password cambiata correttamente");
                            }
                            break;
                        } else {
                            System.out.println("password errata");
                            break;
                        }
                        case 2:
                        aggiungiPaziente(elencopazienti);
                        caricaFileBinario(elencopazienti, elencomedici);
                        System.out.println("""
                                Menu :\s
                                 1)prendere appuntamento
                                 2)cancellare appuntamento
                                 3)contattare segreteria
                                 4)indietro""");
                        scelta = in.nextInt();
                        switch (scelta) {
                            case 1:
                        }
                }
            case 2:
                System.out.println("""
                        Menu :\s
                         1)modificare appuntamento
                         2)spostare appuntamento
                         3)aggiungere clienti
                         4)indietro""");

                scelta = in.nextInt();
                switch (scelta) {
                    case 1:
                        System.out.println("""
                                Menu :\s
                                 1)fisioterapista
                                 2)ortopedico
                                 3)chirurgo
                                 4)radiologo""");

                    case 2:
                        System.out.println("Menu :" +
                                "\n inserire ora e giorno dell'appuntamento:");

                    case 3:
                        aggiungiPaziente(elencopazienti);
                        break;

                    case 4:
                        break;
                }
        }
    }
    static ArrayList<Paziente>leggiFile(ArrayList<Paziente> elencopazienti, ArrayList<Dottore> elencomedici) throws IOException, ClassNotFoundException {
       try {
           FileInputStream cin = new FileInputStream("ElencoPazienti");
            ObjectInputStream fin = new ObjectInputStream(cin);
            elencopazienti = (ArrayList<Paziente>) fin.readObject();
            System.out.println("Caricare file binary");

            ObjectInputStream ffin = new ObjectInputStream(new FileInputStream("ElencoMedici"));
            elencomedici = (ArrayList<Dottore>) ffin.readObject();
            System.out.println("Caricare file binary");

        } catch (IOException | ClassNotFoundException e) {

            caricaFileBinario(elencopazienti, elencomedici);
        }
       return elencopazienti;


    }
    static void aggiungiPaziente(ArrayList<Paziente>elenco) {

        Paziente p = new Paziente("0","0","0","0","0",0);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserire le informazioni del paziente nel seguente ordine intervallate da una virgola: nome, cognome, codice fiscale, numero di telefono, indirizzo");
        System.out.println("Quando hai terminato inserisci 'stop' per uscire");

        String s = scanner.nextLine();

        String[] arr = s.split(",");
        p.nome = arr[0];
        p.cognome = arr[1];
        p.codice_fiscale = arr[2];
        p.num_telefono = arr[3];
        p.indirizzo = arr[4];
        p.code_prenotazione = 0 ;
        p.password = "0000";

        elenco.add(p);

        System.out.println(elenco + "\n");

    }
    static void stampaElencoPazienti(ArrayList<Paziente> elenco) {
        int i =0;
        for (i = 0; i < elenco.size(); i++) {
            System.out.print(elenco.get(i) + "\n");
        }
    }
    public static void caricaFileBinario(ArrayList<Paziente> elencoP, ArrayList<Dottore>elencoM) throws IOException, ClassNotFoundException {

        ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("ElencoPazienti"));
        fbinarioOut.writeObject(elencoP);
        fbinarioOut.flush();
        fbinarioOut.close();
        PrintWriter ftestoOut = new PrintWriter(new FileWriter("ElencoPazienti.txt"));
        ftestoOut.println(elencoP);
        ftestoOut.close();

        ObjectOutputStream filebinarioOut = new ObjectOutputStream(new FileOutputStream("ElencoMedici"));
        filebinarioOut.writeObject(elencoM);
        filebinarioOut.flush();
        fbinarioOut.close();
        PrintWriter filetestoOut = new PrintWriter(new FileWriter("ElencoMedici.txt"));
        filetestoOut.println(elencoM);
        filetestoOut.close();
    }
    public static int cercaPaziente(ArrayList<Paziente>elencoP,String codice_fiscale){
        int i=0;
        for(Paziente paziente: elencoP){
            if(paziente.codice_fiscale.equals(codice_fiscale) ){
                i=elencoP.indexOf(paziente);
            }
        }
        return i;
    }

    HashMap<Dottore , ArrayList<Paziente>> h = new HashMap<Dottore, ArrayList<Paziente>>();
}
