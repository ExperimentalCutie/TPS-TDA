import java.io.*;
import java.util.*;     

public class EP {
    public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        PrintWriter printer = new PrintWriter(bw);
        int n = scanner.nextInt();
        long mesas = 0;
        ArrayList<Integer> raices = new ArrayList<>();
        ArrayList<Boolean> visitados = new ArrayList<>();
        ArrayList<ArrayList<Integer>> aristas = new ArrayList<>();
        for (int i = 0; i <= n; i++) {   ///creo la lista de madres
            aristas.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {    ///creo la lista de hijos
            int madre = scanner.nextInt();
            if (madre >= 1) {
                aristas.get(madre).add(i); // desfase(?)
            }
            else {   
                raices.add(i);  ///ubico las raices para empezar el bfs
            }           
            //// se crea la estructura completa
        }
        for (int i = 0; i < raices.size(); i++) {
            int altura = 0;
            Queue<Integer> cola = new LinkedList<>();
            cola.add(raices.get(i));
            while (!cola.isEmpty()) {
                int CantidadHijosNivel = cola.size();  //cantidad de hijos por nivel  
                for (int k = 0; k < CantidadHijosNivel; k++) {
                    int nodo = cola.poll();  
                    for (int j = 0; j < aristas.get(nodo).size(); j++) {
                         cola.add(aristas.get(nodo).get(j));
                   
                    }
                } 
                altura ++;     //la altura se repite por cada hijo - deberia ser por nivel
            }
            if (altura > mesas) {
                mesas = altura;
            }
        }

        
        printer.println(mesas);
        printer.flush();
        printer.close();
    }
}