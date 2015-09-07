/*-------------------------------------------------------------------
Autores:
Marlon Josue Castillo martinez              14427
Carlos Javier Lima Cordon                   14373
Fernando Sebastian Castillo Echeverria      14102

Algoritmos y estructura de datos
Sección 30
Hoja de trabajo 7
-------------------------------------------------------------------*/

public class Main{

  public static void main(String args[]){
    //indicamos la direccion y el nombre del archivo a leer
    //FileReader lector = new FileReader("C:\\Users\\MARLON\\Desktop\\comparator\\diccionario.txt"); 
    //El contenido de lector se guarda en un BufferedReader
    //BufferedReader contenido = new BufferedReader(lector); 
    //contenido.readLine()

    Diccionario palabra[] = new Diccionario[6];

     
    palabra[0] = new Diccionario();
    palabra[0].setEspanol("casa");
    palabra[0].setIngles("house");
    palabra[1] = new Diccionario();
    palabra[1].setEspanol("perro");
    palabra[1].setIngles("dog");
    palabra[2] = new Diccionario();
    palabra[2].setEspanol("tarea");
    palabra[2].setIngles("homework");
    palabra[3] = new Diccionario();
    palabra[3].setEspanol("mujer");
    palabra[3].setIngles("woman");
    palabra[4] = new Diccionario();
    palabra[4].setEspanol("pueblo");
    palabra[4].setIngles("town");
    palabra[5] = new Diccionario();
    palabra[5].setEspanol("si");
    palabra[5].setIngles("yes");
 
    ArbolBusqueda arbol = new ArbolBusqueda();
    arbol.insertar(palabra[0].getIngles());
    arbol.insertar(palabra[1].getIngles());
    arbol.insertar(palabra[2].getIngles());
    arbol.insertar(palabra[3].getIngles());
    arbol.insertar(palabra[4].getIngles());
    arbol.insertar(palabra[5].getIngles());
    arbol.inOrder();  //izquierdo, raiz, derecho
    System.out.println("\n");
    arbol.buscar("yes");
  }

}

