import java.io.*;
import java.util.*;     

class hola {
    public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        PrintWriter printer = new PrintWriter(bw);
        int n = scanner.nextInt();
        long mesas = 0;
        ArrayList<ArrayList<Integer>> aristas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            aristas.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int madre = scanner.nextInt();
            madre = madre - 1;  
            aristas.get(madre).add(i+1);
        }
        printer.println(aristas);
        printer.flush();
        printer.close();
    }
}