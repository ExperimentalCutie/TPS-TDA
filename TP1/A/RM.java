import java.io.*;
import java.util.*;     

public class RM {
    public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        PrintWriter printer = new PrintWriter(bw);
        int cantidadNodos = scanner.nextInt();
        scanner.nextLine();  
        ArrayList<Boolean> visitados = new ArrayList<>();
        ArrayList<ArrayList<Integer>> aristas = new ArrayList<>();
        
        for (int i = 0; i <= cantidadNodos; i++) {   ///creo la lista de madres vacia
            aristas.add(new ArrayList<>());
        }   
        for (int i=1; i<cantidadNodos; i++) {         /// agrego las aristas
            String linea = scanner.nextLine();
            String[] partes = linea.split(" ");
            int nodo1 = Integer.parseInt(partes[0]);
            int nodo2 = Integer.parseInt(partes[1]);
            aristas.get(nodo1).add(nodo2);
            aristas.get(nodo2).add(nodo1);      // se agregan a si mismos porque no tienen direccion, es decir, son bidireccionales

        } /// hasta aca, construi el arbol a partir de las aristas del buffer
        for (int i = 0; i <= cantidadNodos; i++) {  /// defino visitados en su fase inicial (todo false)
            visitados.add(false);
        }

        String secuenciaString = scanner.nextLine();
        String[] secuenciaPartes = secuenciaString.split(" ");
        Queue<Integer> secuencia = new LinkedList<>();
        for (int i = 0; i < secuenciaPartes.length; i++) {
            secuencia.add(Integer.parseInt(secuenciaPartes[i]));
        }

         
        // idea, entrar desde el vertice 1 (por consigna) y recorrer en formato bfs segun la secuencia, si no coincide con la estructura de arbol, da NO, contrario Yes
       Queue<Integer> cola = new LinkedList<>();
       boolean[] vecinos = new boolean[cantidadNodos + 1];
        cola.add(1);
        secuencia.poll(); //porque el primer nodo siempr es 1
        visitados.set(1, true);
        while (!cola.isEmpty()){
            int nodo = cola.poll();   ///me paro en el nodo
            int cantidadVecinosNoVisitados = 0; //uso esta variable para verificar la cantidad de elementos que son hijos del primer nodo, en la secuencia
                                                // ejemplo, en el primer ejemplo si [1,3,2,4], sabre que como tengo 2 hijos del nodo 1, entonces
                                                // en esa lista 3,2 seran hijos, asi sera mas facil iterar con la cola secuencia
            for (int i = 0; i < aristas.get(nodo).size(); i++) {
                if (!visitados.get(aristas.get(nodo).get(i))) {
                    vecinos[aristas.get(nodo).get(i)] = true;   // marco los vecinos reales de nodo (para verificar despues que sean los de la secuencia)
                    cantidadVecinosNoVisitados++;               // cuento la cantidad de vecinos no visitados
                }
            }

            for (int i = 0; i < cantidadVecinosNoVisitados; i++) {
                if (secuencia.isEmpty()) {  //// si entre al ciclo es porque el nodo tiene hijos, entonces no tendria sentido que la secuencia sea vacia
                    printer.println("NO");
                        printer.flush();
                        printer.close();
                        return;
                }

                if (vecinos[secuencia.peek()]) {  //voy chequeando si coinciden la secuencia con los vecinos del nodo
                    visitados.set(secuencia.peek(), true);
                    cola.add(secuencia.poll());

                }
                else {
                    printer.println("NO");
                        printer.flush();
                        printer.close();
                        return;
                }
            }

            for (int j= 0; j < aristas.get(nodo).size(); j++) {     ///limpio los vecinos del nodo
                vecinos[aristas.get(nodo).get(j)] = false;
                }


        }
            









/*
            for (int i = 0; i < aristas.get(nodo).size(); i++) {  // marco los vecinos del nodo actual
                vecinos[aristas.get(nodo).get(i)] = true;
            }

/* 
            for (int j = 0; j < aristas.get(nodo).size(); j++) { /// para todos los vecinos del vertice
                
                if (!visitados.get(aristas.get(nodo).get(j))) { // para no volver a un vecino ya visitado
                                                
                    if (vecinos[secuencia.peek()]) {  // para verificar que el arbol siga la continuidad, veo si el siguiente en la secuencia es vecino del nodo
                        visitados.set(secuencia.peek(), true);  // marco como visitado el nodo que se va a agregar a la cola (e)
                        cola.add(secuencia.poll());  //// error= secuencia peek, no es necesariamente el vecido en el que estoy en el arbol
                                                        /// por lo tanto, si pongo ese como viitado en vecinos, va a haber errores
                            }
                    else {                                  // en el caso de cumplirse, el 
                        printer.println("NO");
                        printer.flush();
                        printer.close();
                        return;
                            }
                        }
                    }
            for (int i = 0; i < aristas.get(nodo).size(); i++) {     ///limpio los vecinos del nodo
                vecinos[aristas.get(nodo).get(i)] = false;
                }
            visitados.set(nodo, true);
                    
                }
            //}
        //}
            
          */

        




       


        

        
        printer.println("YES");
        printer.flush();
        printer.close();
    }
}