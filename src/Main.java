import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
public class Main implements Serializable {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HashMap<Dottore, ArrayList<Appuntamento>> h = new HashMap();

        h = leggiAppuntamenti(h);
        ArrayList<Paziente> elencopazienti = new ArrayList<>();
        ArrayList<Dottore> elencomedici = new ArrayList<>();
        int indice;

        Dottore dottore;
        Paziente paziente;
        elencopazienti = leggiPazienti(elencopazienti);
        elencomedici = leggiDottori(elencomedici);
        // stampaElencoPazienti(elencopazienti);
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
                                    System.out.println("""
                                            Menu :\s
                                             1)fisioterapista
                                             2)ortopedico
                                             3)chirurgo
                                             4)radiologo""");
                                    scelta = in.nextInt();
                                    switch (scelta) {
                                        case 1:
                                            int i;
                                            int p = 0;
                                            for (i = 0; i < elencomedici.size(); i++) {
                                                if (elencomedici.get(i).specializzazione.equals("fisioterapista")){
                                                    System.out.println(elencomedici.get(i));
                                                    System.out.print("inserire numero: ");
                                                    System.out.println(i);
                                                    p++;
                                                }
                                            }
                                            if (p < 1) {
                                                System.out.println("non abbiamo professionisti in questo ambito");
                                                break;
                                            } else {
                                                System.out.println("scegli il tuo professionista");
                                                int f = in.nextInt();
                                                aggiungiAppuntamento(h, paziente, elencomedici.get(f));
                                                caricaAppuntamenti(h);
                                                break;
                                            }
                                    }break;
                                case 2:
                                    System.out.println("Menu :" +
                                            "\n inserire ora e giorno dell'appuntamento:");

                                case 3:
                                    aggiungiPaziente(elencopazienti);
                                    break;

                                case 4:
                                    System.out.println("inserire nuova password");
                                    paziente.password = in.next();
                                    elencopazienti.set(elencopazienti.indexOf(paziente), paziente);
                                    caricaFileBinario(elencopazienti, elencomedici);
                                    System.out.println("password cambiata correttamente");
                                    break;
                            }
                        }break;
            case 2:
                aggiungiPaziente(elencopazienti);
                caricaFileBinario(elencopazienti, elencomedici);
                paziente = elencopazienti.get(elencopazienti.size() - 1);
                System.out.println("inserire la password");
                String password1 = in.next();
                if (password1 == paziente.password) {
                    System.out.println("password corretta");
                    System.out.println("""
                            Menu :\s
                             1)prendere appuntamento
                             2)cancellare appuntamento
                             3)contattare segreteria
                             4)cambio password
                             5)indietro""");
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
                            aggiungiPaziente(elencopazienti);
                            break;

                        case 4:
                            System.out.println("inserire nuova password");
                            paziente.password = in.next();
                            elencopazienti.set(elencopazienti.indexOf(paziente), paziente);
                            caricaFileBinario(elencopazienti, elencomedici);
                            System.out.println("password cambiata correttamente");
                            break;
                    }
                } else {
                    System.out.println("password errata");
                }

    }case 2:
                System.out.println("""
                        Menu:\s
                        1)medico esistente
                        2)nuovo medico""");
                scelta = in.nextInt();
                switch (scelta) {
                    case 1:
                        System.out.println("Scrivere il proprio codice fiscale");
                        String codiceF = in.next();
                        indice = cercaMedico(elencomedici, codiceF);
                        dottore = elencomedici.get(indice);
                        System.out.println("inserire la password");
                        String password = in.next();
                        if (dottore.password.equals(password)) {
                            System.out.println("""
                                    Menu :\s
                                     1)modificare appuntamento
                                     2)spostare appuntamento
                                     3)aggiungere clienti
                                     4)indietro""");
                        }else {
                            System.out.println("password errata");
                            break;
                        }
                    case 2:
                        elencomedici=aggiungiDottore(elencomedici,h);
                        caricaMedici(elencomedici);
                        stampaElencoMedici(elencomedici);
                        break;
                }
        }
    }
    static ArrayList<Paziente>leggiPazienti(ArrayList<Paziente> elencopazienti) throws IOException, ClassNotFoundException {
       try {
           FileInputStream cin = new FileInputStream("ElencoPazienti");
            ObjectInputStream fin = new ObjectInputStream(cin);
            elencopazienti = (ArrayList<Paziente>) fin.readObject();

       } catch (IOException | ClassNotFoundException e) {

           ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("ElencoPazienti"));
           fbinarioOut.writeObject(elencopazienti);
           fbinarioOut.flush();
           fbinarioOut.close();
           PrintWriter ftestoOut = new PrintWriter(new FileWriter("ElencoPazienti.txt"));
           ftestoOut.println(elencopazienti);
           ftestoOut.close();
        }
       return elencopazienti;

    }
    static void stampaElencoMedici(ArrayList<Dottore> elenco) {
        int i =0;
        for (i = 0; i < elenco.size(); i++) {
            System.out.print(elenco.get(i) + "\n");
        }
    }
    static void stampaElencoPazienti(ArrayList<Paziente> elenco) {
        int i =0;
        for (i = 0; i < elenco.size(); i++) {
            System.out.print(elenco.get(i) + "\n");
        }
    }
    public static void caricaFileBinario(ArrayList<Paziente> elencoP, ArrayList<Dottore>elencoM) throws IOException {

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
        filebinarioOut.close();
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
    public static int cercaMedico(ArrayList<Dottore>elencoM, String specializz){
        int i=0;
        for(Dottore dottore: elencoM){
            if(dottore.specializzazione.equals(specializz) ){
                i=elencoM.indexOf(dottore);
                System.out.println(elencoM.get(i));
            }
        }
        return i;
    }
    static void aggiungiPaziente(ArrayList<Paziente>elenco) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire le informazioni del paziente nel seguente ordine intervallate da una virgola: nome, cognome, codice fiscale, numero di telefono, indirizzo");
        System.out.println("La password viene preimpostata a '0000', si consiglia cambiarla al primo accesso");

        String s = scanner.nextLine();
        String[] arr = s.split(",");
        Paziente p = new Paziente(arr[0],arr[1],arr[2],arr[3],arr[4],0 );
        elenco.add(p);
        System.out.println(elenco + "\n");

    }
    static ArrayList<Dottore> aggiungiDottore(ArrayList<Dottore>elenco, HashMap<Dottore ,ArrayList<Appuntamento>>h ) throws IOException  {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire le informazioni del medico nel seguente ordine intervallate da una virgola: nome, cognome, codice fiscale, numero di telefono, indirizzo,specializzazione");
        System.out.println("La password viene preimpostata a '0000', si consiglia cambiarla al primo accesso");

        String s = scanner.nextLine();
        String[] arr = s.split(",");
        Dottore d = new Dottore();

        d.setNome(arr[0]);
        d.setCognome(arr[1]);
        d.setCodice_fiscale(arr[2]);
        d.setNumero_telefono(arr[3]);
        d.setIndirizzo(arr[4]);
        d.setSpecializzazione(arr[5]);
        d.password = "0000";
        elenco.add(d);

        ArrayList<Appuntamento>a= new ArrayList<>();
        h.put(d,a);
        caricaAppuntamenti(h);
        stampaElencoMedici(elenco);
        return elenco;
    }
    static void caricaMedici(ArrayList<Dottore>elencoM) throws IOException {

        ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("ElencoMedici"));
        fbinarioOut.writeObject(elencoM);
        fbinarioOut.flush();
        fbinarioOut.close();
        PrintWriter ftestoOut = new PrintWriter(new FileWriter("ElencoMedici.txt"));
        ftestoOut.println(elencoM);
        ftestoOut.close();
    }
    static ArrayList<Dottore>leggiDottori( ArrayList<Dottore> elencomedici) throws IOException, ClassNotFoundException {
        try {
            FileInputStream cin = new FileInputStream("ElencoMedici");
            ObjectInputStream fin = new ObjectInputStream(cin);
            elencomedici = (ArrayList<Dottore>) fin.readObject();

        } catch (IOException | ClassNotFoundException e) {
            ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("ElencoMedici"));
            fbinarioOut.writeObject(elencomedici);
            fbinarioOut.flush();
            fbinarioOut.close();
            PrintWriter ftestoOut = new PrintWriter(new FileWriter("ElencoMedici.txt"));
            ftestoOut.println(elencomedici);
            ftestoOut.close();
        }
        return elencomedici;
    }
    static void aggiungiAppuntamento(HashMap<Dottore ,ArrayList<Appuntamento>>h,Paziente p, Dottore d) {

         //ai = h.get(d);
        ArrayList<Appuntamento>ai = new ArrayList<>();
        System.out.println("inserire ora dell'inizio, della fine dell'appuntamento e la descrizione della visita: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(";");
        Appuntamento a = new Appuntamento(arr[0],arr[1],arr[2],p,d);
        ai.add(a);
        h.put(d,ai);
        System.out.println(h);
        }
    static HashMap leggiAppuntamenti(HashMap<Dottore ,ArrayList<Appuntamento>>h) throws IOException, ClassNotFoundException {
        try {
            FileInputStream cin = new FileInputStream("ElencoAppuntamento");
            ObjectInputStream fin = new ObjectInputStream(cin);
            h = (HashMap<Dottore, ArrayList<Appuntamento>>) fin.readObject();

        } catch (IOException | ClassNotFoundException e) {

            ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("ElencoAppuntamenti"));
            fbinarioOut.writeObject(h);
            fbinarioOut.flush();
            fbinarioOut.close();
            PrintWriter ftestoOut = new PrintWriter(new FileWriter("ElencoAppuntamenti.txt"));
            ftestoOut.println(h);
            ftestoOut.close();
        }
        return h;
    }
    static void caricaAppuntamenti(HashMap<Dottore ,ArrayList<Appuntamento>>h) throws IOException{

        ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("ElencoAppuntamenti"));
        fbinarioOut.writeObject(h);
        fbinarioOut.flush();
        fbinarioOut.close();
        PrintWriter ftestoOut = new PrintWriter(new FileWriter("ElencoAppuntamenti.txt"));
        ftestoOut.println(h);
        ftestoOut.close();
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public String toString() {
        return super.toString();
    }

}
