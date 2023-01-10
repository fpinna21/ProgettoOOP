import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Clienti {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     int i=0;
     public ArrayList<Paziente> clienti;

     public Clienti() {
          this.clienti = clienti;
     }


     void aggiungiPaziente(){
          Scanner scanner = new Scanner(System.in);
          ArrayList<Paziente>elencoPazienti = new ArrayList<>();

          System.out.println("Inserire le informazioni del paziente nel seguente ordine: nome, cognome, codice fiscale, numero di telefono, indirizzo");
          System.out.println("Quando hai terminato inserisci 'stop' per uscire");
          while (true) {
               String s = scanner.nextLine();
               if (s.equals("stop")) {
                    break;
               }
               String[] arr = s.split(" ");
               String nome = arr[0];
               String cognome = arr[1];
               String codice = arr[2];
               String numero = arr[3];
               String indirizzo = arr[4];

               Paziente p = new Paziente();
               elencoPazienti.add(p);
               System.out.println(elencoPazienti);
          }

     }
}
