
import java.util.Scanner;

public class main {
    private static final int Porto_Alegre = 0;
    private static final int Erechim = 1;
    private static final int Passo_Fundo = 2;
    private static final int Vacaria = 3;
    private static final int Cassino = 4;
    private static final int Santana_Livramento = 5;

    private static int LeEntradaUsuario(String type, Scanner in) {
        while (true) {
            System.out.println(type + ":");
            String linha = in.nextLine().trim();
            if (linha.isEmpty()) {
                System.out.println("Bye bye!");
                System.exit(0);
            }
            try {
                int parada = Integer.parseInt(linha);
                if (parada >= 1 && parada <= 20) return parada-1;
            } catch (NumberFormatException e) {
            }
            System.out.println(" Valor inválido, tente novamente");
        }
    }


    public static void main(String[] args) {
        // Create the Graphland Subway System
        // (see subwaySystem.pdf file in extra folder)
        //--------------------------------------------
        Graph percurso = new Graph(20);

        //PRIMEIRA LINHA
        percurso.constroiMatriz(Porto_Alegre, Porto_Alegre, 0);
        percurso.constroiMatriz(Porto_Alegre, Erechim, 370);
        percurso.constroiMatriz(Porto_Alegre, Passo_Fundo, 280);
        percurso.constroiMatriz(Porto_Alegre, Vacaria, 240);
        percurso.constroiMatriz(Porto_Alegre, Cassino, 320);
        percurso.constroiMatriz(Porto_Alegre, Santana_Livramento, 490);

        //SEGUNDA LINHA
        percurso.constroiMatriz(Erechim, Porto_Alegre, 370);
        percurso.constroiMatriz(Erechim, Erechim, 0);
        percurso.constroiMatriz(Erechim, Passo_Fundo, 80);
        percurso.constroiMatriz(Erechim, Vacaria, 210);
        percurso.constroiMatriz(Erechim, Cassino, 635);
        percurso.constroiMatriz(Erechim, Santana_Livramento, 600);

        //TERCEIRA LINHA
        percurso.constroiMatriz(Passo_Fundo, Porto_Alegre, 280);
        percurso.constroiMatriz(Passo_Fundo, Erechim, 80);
        percurso.constroiMatriz(Passo_Fundo, Passo_Fundo, 0);
        percurso.constroiMatriz(Passo_Fundo, Vacaria, 175);
        percurso.constroiMatriz(Passo_Fundo, Cassino, 550);
        percurso.constroiMatriz(Passo_Fundo, Santana_Livramento, 700);

        //QUARTA LINHA
        percurso.constroiMatriz(Vacaria, Porto_Alegre, 240);
        percurso.constroiMatriz(Vacaria, Erechim, 210);
        percurso.constroiMatriz(Vacaria, Passo_Fundo, 175);
        percurso.constroiMatriz(Vacaria, Vacaria, 0);
        percurso.constroiMatriz(Vacaria, Cassino, 550);
        percurso.constroiMatriz(Vacaria, Santana_Livramento, 700);

        //QUINTA LINHA
        percurso.constroiMatriz(Cassino, Porto_Alegre, 320);
        percurso.constroiMatriz(Cassino, Erechim, 635);
        percurso.constroiMatriz(Cassino, Passo_Fundo, 550);
        percurso.constroiMatriz(Cassino, Vacaria, 550);
        percurso.constroiMatriz(Cassino, Cassino, 0);
        percurso.constroiMatriz(Cassino, Santana_Livramento, 405);

        //SEXTA LINHA
        percurso.constroiMatriz(Santana_Livramento, Porto_Alegre, 490);
        percurso.constroiMatriz(Santana_Livramento, Erechim, 600);
        percurso.constroiMatriz(Santana_Livramento, Passo_Fundo, 520);
        percurso.constroiMatriz(Santana_Livramento, Vacaria, 700);
        percurso.constroiMatriz(Santana_Livramento, Cassino, 404);
        percurso.constroiMatriz(Santana_Livramento, Santana_Livramento, 0);

        //-------------------------
        Scanner in = new Scanner(System.in);


        while (true) {
            System.out.println("Por favor, digite os campos solicitados. Deixe em branco para sair");
            int origem = LeEntradaUsuario("Origem", in);
            int destino = LeEntradaUsuario("Destino", in);

            System.out.println("percurso mais rapido :");
            for (Integer parada : percurso.caminho(origem, destino)) {
              String caminho= "";
              switch(parada+1){
                case 1:
                  caminho = "Porto Alegre";
                break;
                case 2:
                  caminho = "Erechim";
                break;
                case 3:
                  caminho = "Passo_Fundo";
                break;
                case 4:
                  caminho = "Vacaria";
                break;
                case 5:
                  caminho = "Cassino";
                break;
                case 6:
                  caminho = "Santana do Livramento";
                break;

              }
                System.out.print((caminho) + " -> ");
            }
            System.out.println("EXIT");
        }
    }
}