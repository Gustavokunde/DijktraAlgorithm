
import java.util.Scanner;

public class main {
    private static final int Porto_Alegre = 0;
    private static final int Erechim = 1;
    private static final int Passo_Fundo = 2;
    private static final int Vacaria = 3;
    private static final int Cassino = 4;
    private static final int Santana_Livramento = 5;

    private static int readStation(String type, Scanner in) {
        while (true) {
            System.out.println(type + ":");
            String line = in.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Bye bye!");
                System.exit(0);
            }
            try {
                int station = Integer.parseInt(line);
                if (station >= 1 && station <= 20) return station-1;
            } catch (NumberFormatException e) {
            }
            System.out.println("Invalid station! Try again.");
        }
    }


    public static void main(String[] args) {
        // Create the Graphland Subway System
        // (see subwaySystem.pdf file in extra folder)
        //--------------------------------------------
        Graph subway = new Graph(20);

        //PRIMEIRA LINHA
        subway.makeEdge(Porto_Alegre, Porto_Alegre, 0);
        subway.makeEdge(Porto_Alegre, Erechim, 370);
        subway.makeEdge(Porto_Alegre, Passo_Fundo, 280);
        subway.makeEdge(Porto_Alegre, Vacaria, 240);
        subway.makeEdge(Porto_Alegre, Cassino, 320);
        subway.makeEdge(Porto_Alegre, Santana_Livramento, 490);

        //SEGUNDA LINHA
        subway.makeEdge(Erechim, Porto_Alegre, 370);
        subway.makeEdge(Erechim, Erechim, 0);
        subway.makeEdge(Erechim, Passo_Fundo, 80);
        subway.makeEdge(Erechim, Vacaria, 210);
        subway.makeEdge(Erechim, Cassino, 635);
        subway.makeEdge(Erechim, Santana_Livramento, 600);

        //TERCEIRA LINHA
        subway.makeEdge(Passo_Fundo, Porto_Alegre, 280);
        subway.makeEdge(Passo_Fundo, Erechim, 80);
        subway.makeEdge(Passo_Fundo, Passo_Fundo, 0);
        subway.makeEdge(Passo_Fundo, Vacaria, 175);
        subway.makeEdge(Passo_Fundo, Cassino, 550);
        subway.makeEdge(Passo_Fundo, Santana_Livramento, 700);

        //QUARTA LINHA
        subway.makeEdge(Vacaria, Porto_Alegre, 240);
        subway.makeEdge(Vacaria, Erechim, 210);
        subway.makeEdge(Vacaria, Passo_Fundo, 175);
        subway.makeEdge(Vacaria, Vacaria, 0);
        subway.makeEdge(Vacaria, Cassino, 550);
        subway.makeEdge(Vacaria, Santana_Livramento, 700);

        //QUINTA LINHA
        subway.makeEdge(Cassino, Porto_Alegre, 320);
        subway.makeEdge(Cassino, Erechim, 635);
        subway.makeEdge(Cassino, Passo_Fundo, 550);
        subway.makeEdge(Cassino, Vacaria, 550);
        subway.makeEdge(Cassino, Cassino, 0);
        subway.makeEdge(Cassino, Santana_Livramento, 405);

        //SEXTA LINHA
        subway.makeEdge(Santana_Livramento, Porto_Alegre, 490);
        subway.makeEdge(Santana_Livramento, Erechim, 600);
        subway.makeEdge(Santana_Livramento, Passo_Fundo, 520);
        subway.makeEdge(Santana_Livramento, Vacaria, 700);
        subway.makeEdge(Santana_Livramento, Cassino, 404);
        subway.makeEdge(Santana_Livramento, Santana_Livramento, 0);

        //Graphland Subway Terminal
        //-------------------------
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Graphland Subway System!");
        System.out.println("   built by Mayor Vinicius Godoy de Mendonca");
        System.out.println("   responsible engineer Henri Frederico Eberspacher");
        System.out.println("-------------------------------------------------------");

        while (true) {
            System.out.println("Please, enter your desired route. Leave the field blank to exit.");
            int source = readStation("Source", in);
            int destination = readStation("Destination", in);

            System.out.println("Fastest route:");
            for (Integer station : subway.path(source, destination)) {
                System.out.print((station+1) + " -> ");
            }
            System.out.println("EXIT");
        }
    }
}