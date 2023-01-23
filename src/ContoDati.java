import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ContoDati implements Serializable{

    public static HashMap<Dottore, ArrayList<Appuntamento>> h;
    public static ArrayList<Dottore> elencoDott;
    public static ArrayList<Paziente> elencoPaz;


    static HashMap<Dottore, ArrayList<Appuntamento>> leggiAppuntamenti() throws IOException {
        try {
            FileInputStream cin = new FileInputStream("ElencoAppuntamenti");
            ObjectInputStream fin = new ObjectInputStream(cin);
            ContoDati.h = (HashMap<Dottore, ArrayList<Appuntamento>>) fin.readObject();

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
    static HashMap<Dottore,ArrayList<Appuntamento>> aggiungiAppuntamento(Paziente p, Dottore d) throws IOException {

        h=leggiAppuntamenti();
        ArrayList<Appuntamento> ai = null;

        if(h.containsKey(d)) {
            ai = h.get(d);
        }else{
            ai = new ArrayList();
        }
        System.out.println("inserire la data della visita: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(";");
        ai.add(new Appuntamento(arr[0],arr[1],arr[2],p,d));
        h.put(d,ai);
        System.out.println(h);
        return  h;
    }
    static HashMap<Dottore, ArrayList<Appuntamento>> caricaAppuntamenti() throws IOException{

        ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("ElencoAppuntamenti"));
        fbinarioOut.writeObject(h);
        fbinarioOut.flush();
        fbinarioOut.close();
        PrintWriter ftestoOut = new PrintWriter(new FileWriter("ElencoAppuntamenti.txt"));
        ftestoOut.println(h);
        ftestoOut.close();

        return h;
    }

    public HashMap<Dottore, ArrayList<Appuntamento>> getH() {
        return h;
    }

    public void setH(HashMap<Dottore, ArrayList<Appuntamento>> h) {
        this.h = h;
    }


    ArrayList<Paziente>leggiPazienti() throws IOException {
        try {
            FileInputStream cin = new FileInputStream("ElencoPazienti");
            ObjectInputStream fin = new ObjectInputStream(cin);
            elencoPaz = (ArrayList<Paziente>) fin.readObject();

        } catch (IOException | ClassNotFoundException e) {

            ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("ElencoPazienti"));
            fbinarioOut.writeObject(elencoPaz);
            fbinarioOut.flush();
            fbinarioOut.close();
            PrintWriter ftestoOut = new PrintWriter(new FileWriter("ElencoPazienti.txt"));
            ftestoOut.println(elencoPaz);
            ftestoOut.close();
        }
        return elencoPaz;

    }
    static void stampaElencoMedici() {
        int i;
        for (i = 0; i < elencoDott.size(); i++) {
            System.out.print(elencoDott.get(i) + "\n");
        }
    }
    static void stampaElencoPazienti(ArrayList<Paziente> elenco) {
        int i;
        for (i = 0; i < elenco.size(); i++) {
            System.out.print(elenco.get(i) + "\n");
        }
    }
    public HashMap<Dottore, ArrayList<Appuntamento>> caricaFileBinario() throws IOException, ClassNotFoundException {

        ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("ElencoPazienti"));
        fbinarioOut.writeObject(elencoPaz);
        fbinarioOut.flush();
        fbinarioOut.close();
        PrintWriter ftestoOut = new PrintWriter(new FileWriter("ElencoPazienti.txt"));
        ftestoOut.println(elencoPaz);
        ftestoOut.close();

        ObjectOutputStream filebinarioOut = new ObjectOutputStream(new FileOutputStream("ElencoMedici"));
        filebinarioOut.writeObject(elencoDott);
        filebinarioOut.flush();
        filebinarioOut.close();

        PrintWriter filetestoOut = new PrintWriter(new FileWriter("ElencoMedici.txt"));
        filetestoOut.println(elencoDott);
        filetestoOut.close();

        FileInputStream mis = new FileInputStream("ElencoAppuntamenti");
        ObjectInputStream omis = new ObjectInputStream(mis);
        h = (HashMap) omis.readObject();
        omis.close();

        PrintWriter ftOut = new PrintWriter(new FileWriter("ElencoAppuntamenti.txt"));
        ftOut.println(h);
        ftOut.close();

        return h;
    }
    static ArrayList<Dottore>leggiDottori() throws IOException {
        try {
            FileInputStream cin = new FileInputStream("ElencoMedici");
            ObjectInputStream fin = new ObjectInputStream(cin);
            elencoDott = (ArrayList<Dottore>) fin.readObject();

        } catch (IOException | ClassNotFoundException e) {
            ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("ElencoMedici"));
            fbinarioOut.writeObject(elencoDott);
            fbinarioOut.flush();
            fbinarioOut.close();
            PrintWriter ftestoOut = new PrintWriter(new FileWriter("ElencoMedici.txt"));
            ftestoOut.println(elencoDott);
            ftestoOut.close();
        }
        return elencoDott;
    }
    public int cercaPaziente(String codice_fiscale){
        int i=0;
        for(Paziente paziente: elencoPaz){
            if(paziente.codice_fiscale.equals(codice_fiscale) ){
                i=elencoPaz.indexOf(paziente);
            }
        }
        return i;
    }
    public static int cercaMedico(String specializz){
        int i=0;
        for(Dottore dottore: elencoDott){
            if(dottore.specializzazione.equals(specializz) ){
                i=elencoDott.indexOf(dottore);
                System.out.println(elencoDott.get(i));
            }
        }
        return i;
    }
    void aggiungiPaziente() throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire le informazioni del paziente nel seguente ordine intervallate da una virgola: nome, cognome, codice fiscale, numero di telefono, indirizzo");
        System.out.println("La password viene preimpostata a '0000', si consiglia cambiarla al primo accesso");

        String s;
        s = scanner.nextLine();
        String[] arr = s.split(",");

        elencoPaz.add(new Paziente(arr[0],arr[1],arr[2],arr[3],arr[4],0));
        System.out.println(elencoPaz + "\n");

    }
    static ArrayList<Dottore> aggiungiDottore() throws IOException  {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire le informazioni del professionista nel seguente ordine intervallate da una virgola: nome, cognome, codice fiscale, numero di telefono, indirizzo,specializzazione");
        System.out.println("La password viene preimpostata a '0000', si consiglia cambiarla al primo accesso");

        String s = scanner.nextLine();
        String[] arr = s.split(",");
        Dottore d = new Dottore(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5] );
        elencoDott.add(d);
        h.put(d,new ArrayList<Appuntamento>());
        System.out.println(elencoDott + "\n");
        return elencoDott;
    }

    static void cambiaPassword (Paziente paziente, String passw){

        int i = elencoPaz.indexOf(paziente);
        paziente.password = passw;
        elencoPaz.set(i, paziente);
    }

    public static ArrayList<Dottore> getElencoDott() {
        return elencoDott;
    }

    public static void setElencoDott(ArrayList<Dottore> elencoDott) {
        ContoDati.elencoDott = elencoDott;
    }

    public ArrayList<Paziente> getElencoPaz() {
        return elencoPaz;
    }

    public void setElencoPaz(ArrayList<Paziente> elencoPaz) {
        this.elencoPaz = elencoPaz;
    }

    public ContoDati() {
        this.elencoPaz = new ArrayList<>();
        this.elencoDott = new ArrayList<>();
        this.h = new HashMap<>();
    }
}
