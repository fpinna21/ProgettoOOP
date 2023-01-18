import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Main {

    public static Scanner in = new Scanner(System.in);


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Paziente> elencopazienti;
        try{
            ObjectInputStream fin = new ObjectInputStream(new FileInputStream("bin"));
            elencopazienti = (ArrayList<Paziente>) fin.readObject();
            System.out.println("Caricare file binary");

        } catch (IOException|ClassNotFoundException e){
            elencopazienti = new ArrayList<>();
            caricaFileBinario(elencopazienti);
            System.out.println("Carico file di testo da binario");
        }
        stampaElencoPazienti(elencopazienti);


        System.out.println("Menu : " +
                "\n 1)paziente" +
                "\n 2)medico");

        int scelta = in.nextInt();
        switch (scelta) {
            case 1:


              aggiungiPaziente(elencopazienti);



                System.out.println("Menu : " +
                        "\n 1)prendere appuntamento" +
                        "\n 2)cancellare appuntamento" +
                        "\n 3)contattare segreteria" +
                        "\n 4)indietro");
                scelta = in.nextInt();
                switch (scelta) {
                    case 1:
                        System.out.println("Menu : " +
                                "\n 1)fisioterapista" +
                                "\n 2)ortopedico" +
                                "\n 3)chirurgo" +
                                "\n 4)radiologo");
                        scelta = in.nextInt();
                    case 2:
                        System.out.println("Menu :" +
                                "\n inserire ora e giorno dell'appuntamento:");

                    case 3:

                        break;


                    case 4:
                        break;
                }


                break;
        }

        caricaFileBinario(elencopazienti);
    }
    static int i = 100000;
     static ArrayList<Paziente> aggiungiPaziente(ArrayList<Paziente>elenco) throws IOException, ClassNotFoundException {

         Paziente p;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserire le informazioni del paziente nel seguente ordine intervallate da una virgola: nome, cognome, codice fiscale, numero di telefono, indirizzo");
        System.out.println("Quando hai terminato inserisci 'stop' per uscire");
        while (true) {



            String s = scanner.nextLine();
            if (s.equals("stop")) {
                break;
            }
            String[] arr = s.split(".");
            String nome = arr[0];
            String cognome = arr[1];
            String codice = arr[2];
            String numero = arr[3];
            String indirizzo = arr[4];
            int utente =  i++ ;

            p = new Paziente(nome, cognome, codice, numero, indirizzo, utente);

            elenco.add(p);
            System.out.print(elenco.toString()+ "\n");
        }
         return elenco;

    }

    static void stampaElencoPazienti(ArrayList<Paziente> elenco) throws IOException, ClassNotFoundException {

       // for (i = 0; i < elenco.size(); i++) {
            System.out.print(elenco.toString()+ "\n");
        //}

    }
    public static void caricaFileBinario(ArrayList<Paziente> elencoP) throws IOException, ClassNotFoundException {// alunno in un FILE BIANARIO tramite la serializzazione

        ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("bin"));
        fbinarioOut.writeObject(elencoP);
        fbinarioOut.flush();
        fbinarioOut.close();

        PrintWriter ftestoOut = new PrintWriter(new FileWriter("bin.txt"));
        ftestoOut.println(elencoP);
        ftestoOut.close();


    }

    public ArrayList<Paziente> caricaFile(ArrayList<Paziente> elenco) throws IOException, ClassNotFoundException {


        String fileName = "bin.bin";
        FileInputStream fis = new FileInputStream(fileName);

        ObjectInputStream ois = new ObjectInputStream(fis);

        Object obj = ois.readObject();

        elenco = (ArrayList<Paziente>) obj;

        ois.close();
        return elenco;
    }
}
