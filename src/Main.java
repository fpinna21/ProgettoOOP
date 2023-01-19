import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Paziente> elencopazienti;
        try{
            ObjectInputStream fin = new ObjectInputStream(new FileInputStream("ElencoPazienti"));
            elencopazienti = (ArrayList<Paziente>) fin.readObject();
            System.out.println("Caricare file binary");
        } catch (IOException|ClassNotFoundException e){
            elencopazienti = new ArrayList<>();
            caricaFileBinario(elencopazienti);
        }
        stampaElencoPazienti(elencopazienti);

        System.out.println("""
                Menu :\s
                 1)paziente
                 2)medico""");
        int scelta = in.nextInt();
        switch (scelta) {
            case 1:
                aggiungiPaziente(elencopazienti);
                System.out.println("""
                        Menu :\s
                         1)prendere appuntamento
                         2)cancellare appuntamento
                         3)contattare segreteria
                         4)indietro""");
            case 2:
                System.out.println("""
                        Menu :\s
                         1)modificare appuntamento
                         2)spostare appuntamento
                         3)aggiungere cliente
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


                    case 4:
                        break;
                }
                break;
        }
        caricaFileBinario(elencopazienti);
    }
    static int i = 100000;
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
            int utente =  i++ ;

            elenco.add(p);
            System.out.println(elenco + "\n");

     }
    static void stampaElencoPazienti(ArrayList<Paziente> elenco) {

        for (i = 0; i < elenco.size(); i++) {
            System.out.print(elenco.get(i) + "\n");
        }
     }
    public static void caricaFileBinario(ArrayList<Paziente> elencoP) throws IOException, ClassNotFoundException {// alunno in un FILE BIANARIO tramite la serializzazione

        ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("ElencoPazienti"));
        fbinarioOut.writeObject(elencoP);
        fbinarioOut.flush();
        fbinarioOut.close();
        PrintWriter ftestoOut = new PrintWriter(new FileWriter("ElencoPazienti.txt"));
        ftestoOut.println(elencoP);
        ftestoOut.close();
     }



}
