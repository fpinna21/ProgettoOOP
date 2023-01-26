import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ContoDati implements Serializable{

    public  ArrayList<Dottore>elencoDott;
    public  ArrayList<Paziente> elencoPaz;
    public ArrayList<Appuntamento> elencoApp;



    void caricaAppuntamenti() throws IOException{

        ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("ElencoAppuntamenti"));
        fbinarioOut.writeObject(elencoApp);
        fbinarioOut.flush();
        fbinarioOut.close();
        PrintWriter ftestoOut = new PrintWriter(new FileWriter("ElencoAppuntamenti.txt"));
        ftestoOut.println(elencoApp);
        ftestoOut.close();

    }
    void leggiPazienti() throws IOException {
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

    }
    void leggiAppuntamenti()  throws IOException {
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
    void leggiDottori() throws IOException {
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
            if(dottore.specializzazione.equals(specializz)){
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
    void aggiungiDottore() throws IOException  {

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
    }
    void aggiungiAppuntamento(Paziente p, Dottore d) throws ParseException, IOException {
        ArrayList<Appuntamento> prova = new ArrayList<>(1);

        if(elencoApp == null){
            Scanner scanner = new Scanner(System.in);
            System.out.println("inserire la descrizione della visita: ");
            String s = scanner.nextLine();

            prova.add(new Appuntamento( p, d, provaCalendario(d), s));
            setElencoApp(prova);
        }else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("inserire la descrizione della visita: ");
            String s = scanner.nextLine();


            prova = getElencoApp();
            prova.add(new Appuntamento( p, d, provaCalendario(d), s));
            setElencoApp(prova);
        }
        System.out.println(elencoApp);
    }
    void cambiaPassword(Paziente paziente, String passw){

        int i = elencoPaz.indexOf(paziente);
        paziente.password = passw;
        elencoPaz.set(i, paziente);
    }

    public ArrayList<Dottore> getElencoDott() {
        return elencoDott;
    }

    public void setElencoDott(ArrayList<Dottore> elencoDott) {
        this.elencoDott = elencoDott;
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
        this.elencoApp = new ArrayList<>();
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

    public LocalDateTime provaCalendario(Dottore d) throws ParseException, IOException {

        int i;
        int c =0;
        int j;

        System.out.println("Scrivere data calendario in formato [dd/mm/yyyy]");

        Scanner tastiera = new Scanner(System.in);

        String testo;

        boolean trovato = false;
        boolean libero = false;

        testo = tastiera.next();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date miaData = sdf.parse(testo);

        Calendar calendario = Calendar.getInstance();

        calendario.setTime(miaData);

        int anno = calendario.get(Calendar.YEAR);
        int mese = calendario.get(Calendar.MONTH) + 1;
        int giorno = calendario.get(Calendar.DAY_OF_MONTH);
        int ora = tastiera.nextInt();
        int minuto = 0;
        int secondo =0;
        LocalDateTime day = LocalDateTime.of(anno,mese,giorno,ora,minuto,secondo);

        LocalDateTime[] orariPoss = new LocalDateTime[9];
        orariPoss[0] = LocalDateTime.of(day.getYear(),day.getMonth(), day.getDayOfMonth(), 8, 0,0);
        orariPoss[1] = LocalDateTime.of(day.getYear(),day.getMonth(), day.getDayOfMonth(), 9, 0,0);
        orariPoss[2] = LocalDateTime.of(day.getYear(),day.getMonth(), day.getDayOfMonth(), 10, 0,0);
        orariPoss[3] = LocalDateTime.of(day.getYear(),day.getMonth(), day.getDayOfMonth(), 11, 0,0);
        orariPoss[4] = LocalDateTime.of(day.getYear(),day.getMonth(), day.getDayOfMonth(), 12, 0,0);
        orariPoss[5] = LocalDateTime.of(day.getYear(),day.getMonth(), day.getDayOfMonth(), 15, 0,0);
        orariPoss[6] = LocalDateTime.of(day.getYear(),day.getMonth(), day.getDayOfMonth(), 16, 0,0);
        orariPoss[7] = LocalDateTime.of(day.getYear(),day.getMonth(), day.getDayOfMonth(), 17, 0,0);
        orariPoss[8] = LocalDateTime.of(day.getYear(),day.getMonth(), day.getDayOfMonth(), 18, 0,0);
        while (!trovato) {
            for (i = 0; i < elencoApp.size(); i++) {

                if (elencoApp.get(i).getMedico().equals(d) && elencoApp.get(i).getData().equals(day)) {
                    System.out.println("Appuntamento non disponibile");
                    //libero = false;
                } else {
                    libero = true;
                    trovato = true;
                }
            }

            if (!libero) {

                for (i = 0; i < elencoApp.size(); i++) {

                    for (j = 0; j < 9; j++)
                        if (elencoApp.get(i).getMedico().equals(d) && orariPoss[j].equals(day)) {
                            //System.out.println("Appuntamento non disponibile");
                            c++;
                        } else {
                            Scanner orario = new Scanner(System.in);
                            System.out.println("Scegliere tra quelli disponibili");
                            System.out.print(orariPoss[j] + "       ");
                            if (j == 8) {
                                int ore = orario.nextInt();
                                day = LocalDateTime.of(day.getYear(), day.getMonth(), day.getDayOfMonth(), ore, 0, 0);
                                trovato = true;
                            }
                        }
                }
                if (c == 9) {
                    // System.out.println("");
                    day = LocalDateTime.from(day).plus(1, ChronoUnit.DAYS);

                }
            }
        }
        boolean bisestile = anno % 400 == 0 || anno % 4 == 0 && anno % 100 != 0;

        if (giorno <= 28 && mese == 2 && anno > 0) {
            System.out.println(testo + " Data valida");

        } else if (giorno == 29 && mese == 2 && bisestile) {
            System.out.println(testo + " Anno bisestile");

        } else if (giorno <= 30 && anno > 0 && mese == 4 || mese == 6 || mese == 9 || mese == 11) {
            System.out.println(testo + " Data valida");

        } else if ( anno > 0 && mese == 1 || mese == 3 || mese == 5 || mese == 7 || mese == 8 || mese == 10 || mese == 12) {
            System.out.println(testo + " Data valida");


        } else{

            System.out.println("Data non valida");
    }
        return day;
    }

    }





