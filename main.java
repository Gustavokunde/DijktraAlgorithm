import java.util.Scanner;

public class main {
    private static final int Porto_Alegre = 1;
    private static final int Erechim = 2;
    private static final int Passo_Fundo = 3;
    private static final int Vacaria = 4;
    private static final int Cassino = 5;
    private static final int Santana_Livramento = 6;
    private static final int UNDEFINED = -1;
    public static int vertices[][] = new int[8][8];

    private static int LeEntradaUsuario(String type, Scanner in) {
        while (true) {
            System.out.println(type + ":");
            String linha = in.nextLine().trim();
            if (linha.isEmpty()) {
                System.out.println("Até mais!");
                System.exit(0);
            }
            try {
                int parada = Integer.parseInt(linha);
                if (parada <=7 ) return parada-1;
            } catch (NumberFormatException e) {
            }
            System.out.println(" Valor inválido, tente novamente");
        }
    }


    public static void main(String[] args) {
       
        // //PRIMEIRA LINHA
        constroiMatriz(Porto_Alegre, Porto_Alegre, 0);
        constroiMatriz(Porto_Alegre, Erechim, 370);
        constroiMatriz(Porto_Alegre, Passo_Fundo, 280);
        constroiMatriz(Porto_Alegre, Vacaria, 240);
        constroiMatriz(Porto_Alegre, Cassino, 320);
        constroiMatriz(Porto_Alegre, Santana_Livramento, 490);

        //SEGUNDA LINHA
        constroiMatriz(Erechim, Porto_Alegre, 370);
        constroiMatriz(Erechim, Erechim, 0);
        constroiMatriz(Erechim, Passo_Fundo, 80);
        constroiMatriz(Erechim, Vacaria, 210);
        constroiMatriz(Erechim, Cassino, 635);
        constroiMatriz(Erechim, Santana_Livramento, 600);

        //TERCEIRA LINHA
        constroiMatriz(Passo_Fundo, Porto_Alegre, 280);
        constroiMatriz(Passo_Fundo, Erechim, 80);
        constroiMatriz(Passo_Fundo, Passo_Fundo, 0);
        constroiMatriz(Passo_Fundo, Vacaria, 175);
        constroiMatriz(Passo_Fundo, Cassino, 550);
        constroiMatriz(Passo_Fundo, Santana_Livramento, 700);

        //QUARTA LINHA
        constroiMatriz(Vacaria, Porto_Alegre, 240);
        constroiMatriz(Vacaria, Erechim, 210);
        constroiMatriz(Vacaria, Passo_Fundo, 175);
        constroiMatriz(Vacaria, Vacaria, 0);
        constroiMatriz(Vacaria, Cassino, 550);
        constroiMatriz(Vacaria, Santana_Livramento, 700);

        //QUINTA LINHA
        constroiMatriz(Cassino, Porto_Alegre, 320);
        constroiMatriz(Cassino, Erechim, 635);
        constroiMatriz(Cassino, Passo_Fundo, 550);
        constroiMatriz(Cassino, Vacaria, 550);
        constroiMatriz(Cassino, Cassino, 0);
        constroiMatriz(Cassino, Santana_Livramento, 405);

        //SEXTA LINHA
        constroiMatriz(Santana_Livramento, Porto_Alegre, 490);
        constroiMatriz(Santana_Livramento, Erechim, 600);
        constroiMatriz(Santana_Livramento, Passo_Fundo, 520);
        constroiMatriz(Santana_Livramento, Vacaria, 700);
        constroiMatriz(Santana_Livramento, Cassino, 404);
        constroiMatriz(Santana_Livramento, Santana_Livramento, 0);

        //-------------------------
        Scanner in = new Scanner(System.in);


        while (true) {
            System.out.println("Por favor, digite os campos solicitados. Deixe em branco para sair");
            int origem = LeEntradaUsuario("Origem", in);
            int destino = LeEntradaUsuario("Destino", in);

            System.out.println("percurso mais rapido :");
            int data[] = caminho(origem+1, destino+1);
            for (int i=0; i < data.length; i++) {
              int parada =  data[i];
              String caminho= "";
              if(parada != -1){

                switch(parada){
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
            }
            System.out.println("Chegada");
        }
    }


   
  public static void constroiMatriz(int vertex1, int vertex2, int time) {
      vertices[vertex1][vertex2] = time;
      vertices[vertex2][vertex1] = time;
  }

  public static int[] pegaVizinhos(int vertex) {
      int vizinhos[]={0,0,0,0,0};
      int posicao = 0;
      for (int i = 0; i < vertices[vertex].length; i++)
          if (vertices[vertex][i] > 0) {
              vizinhos[posicao] = i;
              posicao ++;
          }

      return vizinhos;
  }

    public static int[] caminho(int origem, int destino) {
      
      int custo[] = new int[vertices.length];
      int anterior[] = new int[vertices.length];
      int naoVisitados[] = new int[vertices.length];
      int posicaoNaoVisitados = 0;
      custo[origem] = 0;

      for (int v = 0; v < vertices.length; v++) {
          if (v != origem) {
              custo[v] = Integer.MAX_VALUE;
          }
          anterior[v] = UNDEFINED;

          naoVisitados[posicaoNaoVisitados]=v;
          posicaoNaoVisitados++;
      }

      
      while (!arrayEstaLimpo(naoVisitados)) {
          int proximo = maisProximo(custo, naoVisitados);

          for(int i = 0; i< naoVisitados.length; i++){
            if(naoVisitados[i]==proximo)
            naoVisitados[i] = 0;
          }

          for (Integer vizinho : pegaVizinhos(proximo)) {
              int custoTotal = custo[proximo] + vertices[proximo][vizinho];
              if (custoTotal < custo[vizinho]) {
                  custo[vizinho] = custoTotal;
                  anterior[vizinho] = proximo;
              }
          }
          if (proximo == destino) {
              return constroiCaminho(anterior, proximo);
          }
      }

      return null;
  }


    private static int maisProximo(int[] dist, int[] naoVisitados) {
      double minDist = Integer.MAX_VALUE;
      int minIndex = 0;
      for (Integer i : naoVisitados) {
          if (dist[i] < minDist) {
              minDist = dist[i];
              minIndex = i;
          }
      }
      return minIndex;
  }

    private static int[] constroiCaminho(int[] anterior, int u) {
      int[] caminho={-1,-1,-1,-1,-1,-1,-1};
      int posicao = 0;
      caminho[posicao]= u;
      posicao++;
      while (anterior[u] != UNDEFINED) {
          caminho[posicao]= anterior[u];
          posicao++;
          u = anterior[u];
      }

      //inverte array 

        int aux = 0;
        for ( int i = 0; i < (caminho.length) / 2; i++) {
            aux = caminho[ caminho.length - i - 1 ];
            caminho[ caminho.length - i - 1 ] = caminho[ i ];
            caminho[ i ] = aux;
        }
      return caminho;
    }

    private static boolean arrayEstaLimpo(int[] array){
      for(int i = 0; i < array.length; i++){
        if(array[i]!=0) return false;
      }
      return true;
    }
}