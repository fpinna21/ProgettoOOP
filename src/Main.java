import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Main {

    public static Scanner in = new Scanner(System.in);


    public static void main(String[] args) throws IOException {


        System.out.println("Menu : " +
                "\n 1)paziente" +
                "\n 2)medico");

        int scelta = in.nextInt();
        switch (scelta) {
            case 1:

                Paziente paziente = new Paziente("0", "0", "0", "0", "0");
                paziente.aggiungiPaziente();

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


                }


                break;
        }


    }

    public static void Aggiungi_Cliente() {
        System.out.println("Inserire le informazioni del paziente nel seguente ordine intervallate da una virgola: nome, cognome, codice fiscale, numero di telefono, indirizzo");
        System.out.println("Quando hai terminato inserisci 'stop' per uscire");
        while (true) {

            String s = in.nextLine();
            if (s.equals("stop")) {
                break;
            }
            String[] arr = s.split(",");
            String nome = arr[0];
            String cognome = arr[1];
            String codice = arr[2];
            String numero = arr[3];
            String indirizzo = arr[4];

            Paziente p = new Paziente(nome, cognome, codice, numero, indirizzo);

        }

    }
}