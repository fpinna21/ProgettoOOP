
import java.util.Scanner;
import java.io.*;
public class Main implements Serializable {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ContoDati Registro;
        Registro = new ContoDati();
        Registro.leggiAppuntamenti();
        Registro.leggiPazienti();
        Registro.leggiDottori();
        Registro.stampaElencoPazienti();
        Registro.stampaElencoMedici();
        int indice;

        Dottore dottore;
        Paziente paziente;
        Registro.leggiPazienti();
        Registro.leggiDottori();
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
                        indice = Registro.cercaPaziente( codiceF);
                         paziente = Registro.getElencoPaz().get(indice);
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
                                            int c = 0;
                                            for (i = 0; i < Registro.elencoDott.size(); i++) {
                                                Dottore prova =Registro.getElencoDott().get(i);
                                                if (prova.getSpecializzazione().equals("fisioterapista") ){
                                                    System.out.println(Registro.getElencoDott().get(i));
                                                    System.out.print("inserire numero: ");
                                                    System.out.println(i);
                                                    c++;
                                                }
                                            }
                                            if (c < 1) {
                                                System.out.println("non abbiamo professionisti in questo ambito");
                                            } else {
                                                System.out.println("scegli il tuo professionista");
                                                int f = in.nextInt();
                                                Registro.aggiungiAppuntamento(paziente, Registro.getElencoDott().get(f));
                                                Registro.caricaAppuntamenti();
                                            }
                                            break;
                                    }break;
                                case 2:
                                    System.out.println("Menu :" +
                                            "\n inserire ora e giorno dell'appuntamento:");

                                case 3:
                                    Registro.aggiungiPaziente();
                                    break;

                                case 4:
                                    System.out.println("inserire nuova password");
                                    paziente.password = in.next();
                                    Registro.cambiaPassword(paziente,password);
                                    Registro.caricaFileBinario();
                                    System.out.println("password cambiata correttamente");
                                    break;
                            }
                        }break;
            case 2:
                Registro.aggiungiPaziente();
                Registro.stampaElencoPazienti();
                Registro.caricaFileBinario();

                System.out.println("inserire la password");
                String password1 = in.next();
                if (password1.equals(Registro.getElencoPaz().get(Registro.getElencoPaz().size() - 1).password)) {
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
                            Registro.aggiungiPaziente();
                            break;

                        case 4:
                            System.out.println("inserire nuova password");
                            String password2 = in.next();
                            Registro.cambiaPassword((Registro.getElencoPaz().get(Registro.getElencoPaz().size() - 1)), password2);
                            Registro.caricaFileBinario();
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
                        indice = Registro.cercaMedico(codiceF);
                        dottore = Registro.getElencoDott().get(indice);
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
                        Registro.stampaElencoMedici();
                        Registro.aggiungiDottore();
                        Registro.caricaFileBinario();
                        break;
                }
        }
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
