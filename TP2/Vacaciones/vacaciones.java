
import java.io.*;
import java.util.*;     

public class vacaciones {
    
    static ArrayList<ArrayList<Integer>> memoria = new ArrayList<>(); // creo la estructura de memoria para guardar los resultados
    public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        PrintWriter printer = new PrintWriter(bw);
        int dias = scanner.nextInt();
        scanner.nextLine();
        String iesimoDiaString = scanner.nextLine();  
        ArrayList<Integer> iesimoDia = new ArrayList<>();

        for (String s : iesimoDiaString.trim().split("\\s+")) {
            iesimoDia.add(Integer.parseInt(s));
        }

        for (int j = 0; j <= dias; j++) { // lleno la matriz de memoria con -1
            ArrayList<Integer> fila = new ArrayList<>();
            for (int k = 0; k < 4; k++) {
                fila.add(-1);
            }
            memoria.add(fila);
        }
        int resultado = descansoMinimo(0, iesimoDia, 0, dias);
        System.out.println(resultado);    
        
    }
    
    public static int descansoMinimo (int ultimaActividad,  ArrayList<Integer> iesimoDia, int i, int dias) {
            if (i == dias) {
                return 0;
            }
            
            if (memoria.get(i).get(ultimaActividad) != -1) {   /// evito hacer recursion si ya lo he hecho antes
                return memoria.get(i).get(ultimaActividad);
            }

            int descansa = 1 + descansoMinimo( 0, iesimoDia, i + 1, dias);
            int deporte = Integer.MAX_VALUE; // infito para java
            int competencia = Integer.MAX_VALUE; // infito para java
            
            int diaActual = iesimoDia.get(i);
            if (ultimaActividad !=1 && (diaActual == 2 || diaActual == 3)) {
                deporte = descansoMinimo( 1, iesimoDia, i + 1, dias);
            }

            if (ultimaActividad !=2 && (diaActual == 1 || diaActual == 3)) {
                competencia = descansoMinimo(2, iesimoDia, i + 1, dias);
            }

            int resultado = minimo(descansa, deporte, competencia);
            memoria.get(i).set(ultimaActividad, resultado);  ///guardo el minimo de dias de descanso en el iesimo dia i, para la ultima actividad realizada (ayer)

            return resultado;
        }
        

    public static int minimo(int x1, int x2, int x3) {
            return Math.min(x1, Math.min(x2, x3));
        }
    




    }


        
