import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ContoDati implements Serializable{

    public  ArrayList<Dottore>elencoDott;
    public  ArrayList<Paziente> elencoPaz;
    public ArrayList<Appuntamento> elencoApp;



    ArrayList<Appuntamento>caricaAppuntamenti() throws IOException{

        ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("ElencoAppuntamenti"));
        fbinarioOut.writeObject(elencoApp);
        fbinarioOut.flush();
        fbinarioOut.close();
        PrintWriter ftestoOut = new PrintWriter(new FileWriter("ElencoAppuntamenti.txt"));
        ftestoOut.println(elencoApp);
        ftestoOut.close();

        return elencoApp;
    }
    ArrayList<Paziente>leggiPazienti() throws IOException {
        try {
            FileInputStream cin = new FileInputStream("ElencoPazienti");
            ObjectInputStream fin = new ObjectInputStream(cin);
            this.elencoPaz = (ArrayList<Paziente>) fin.readObject();

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
    ArrayList<Appuntamento> leggiAppuntamenti()  throws IOException {
        try {
            FileInputStream cin = new FileInputStream("ElencoAppuntamenti");
            ObjectInputStream fin = new ObjectInputStream(cin);
            elencoApp = (ArrayList<Appuntamento>) fin.readObject();

        } catch (IOException | ClassNotFoundException e) {

            ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("ElencoAppuntamenti"));
            fbinarioOut.writeObject(elencoApp);
            fbinarioOut.flush();
            fbinarioOut.close();
            PrintWriter ftestoOut = new PrintWriter(new FileWriter("ElencoAppuntamenti.txt"));
            ftestoOut.println(elencoApp);
            ftestoOut.close();
        }
        return elencoApp;
    }

    void stampaElencoMedici() {
        int i;
        for (i = 0; i < elencoDott.size(); i++) {
            System.out.print(elencoDott.get(i) + "\n");
        }
    }
    void stampaElencoPazienti() {
        int i;
        for (i = 0; i < elencoPaz.size(); i++) {
            System.out.print(elencoPaz.get(i) + "\n");
        }
    }
    public void caricaFileBinario() throws IOException {

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

        ObjectOutputStream fOut = new ObjectOutputStream(new FileOutputStream("ElencoAppuntamenti"));
        fOut.writeObject(elencoApp);
        fOut.flush();
        fOut.close();
        PrintWriter ftOut = new PrintWriter(new FileWriter("ElencoAppuntamenti.txt"));
        ftOut.println(elencoApp);
        ftOut.close();
    }
    ArrayList<Dottore>leggiDottori() throws IOException {
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
    public int cercaMedico(String specializz){
        int i=0;
        for(Dottore dottore: elencoDott){
            if(dottore.specializzazione == specializz ){
                i=elencoDott.indexOf(dottore);
                System.out.println(elencoDott.get(i));
            }
        }
        return i;
    }
    void aggiungiPaziente() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire le informazioni del paziente nel seguente ordine intervallate da una virgola: nome, cognome, codice fiscale, numero di telefono, indirizzo");
        System.out.println("La password viene preimpostata a '0000', si consiglia cambiarla al primo accesso");
        ArrayList<Paziente>prova = new ArrayList<>(1);
        prova= getElencoPaz();
        String s = scanner.nextLine();
        String[] arr = s.split(",");
        prova.add(new Paziente(arr[0],arr[1],arr[2],arr[3],arr[4],0));
        setElencoPaz(prova);
        System.out.println(elencoPaz + "\n");

    }
    ArrayList<Dottore> aggiungiDottore() throws IOException  {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire le informazioni del professionista nel seguente ordine intervallate da una virgola: nome, cognome, codice fiscale, numero di telefono, indirizzo,specializzazione");
        System.out.println("La password viene preimpostata a '0000', si consiglia cambiarla al primo accesso");
        ArrayList<Dottore>prova ;
        prova= new ArrayList<>(1);
        String s = scanner.nextLine();
        String[] arr = s.split(",");
        prova = getElencoDott();
        prova.add(new Dottore(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5] ));
        setElencoDott(prova);


        System.out.println(elencoDott + "\n");
        return elencoDott;
    }
    ArrayList<Appuntamento> aggiungiAppuntamento(Paziente p, Dottore d) {
        ArrayList<Appuntamento> prova = new ArrayList<>(1);
        if(elencoApp == null){
            Scanner scanner = new Scanner(System.in);
            System.out.println("inserire la data della visita: ");
            String s = scanner.nextLine();
            String[] arr = s.split(";");

            prova.add(new Appuntamento(arr[0], arr[1], arr[2], p, d));
            setElencoApp(prova);
        }else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("inserire la data della visita: ");
            String s = scanner.nextLine();
            String[] arr = s.split(";");
            prova = getElencoApp();
            prova.add(new Appuntamento(arr[0], arr[1], arr[2], p, d));
            setElencoApp(prova);
        }
        System.out.println(elencoApp);
        return  elencoApp;
    }
    void cambiaPassword(Paziente paziente, String passw){

        int i = elencoPaz.indexOf(paziente);
        paziente.password = passw;
        elencoPaz.set(i, paziente);
    }

    public ArrayList<Dottore> getElencoDott() {
        return elencoDott;
    }

    public static void setElencoDott(ArrayList<Dottore> elencoDott) {
        elencoDott = elencoDott;
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
        this.elencoDott = new ArrayList<>();
    }

    public ArrayList<Appuntamento> getElencoApp() {
        return elencoApp;
    }

    public void setElencoApp(ArrayList<Appuntamento> elencoApp) {
        this.elencoApp = elencoApp;
    }

    public ContoDati(ArrayList<Dottore> elencoDott, ArrayList<Paziente> elencoPaz, ArrayList<Appuntamento> elencoApp) {
        this.elencoDott = elencoDott;
        this.elencoPaz = elencoPaz;
        this.elencoApp = elencoApp;
    }

    @Override
    public String toString() {
        return "ContoDati{" +
                "elencoDott=" + elencoDott +
                ", elencoPaz=" + elencoPaz +
                ", elencoApp=" + elencoApp +
                '}';
    }
}
