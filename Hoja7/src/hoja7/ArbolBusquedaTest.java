/*-----------------------------------------------------------------------
Marlon Josue Castillo Martinez              14427
Carlos Javier Lima Cordon                   14373
Fernando Sebastian Castillo Echeverria      14102

Algoritmos y estructura de datos
Seccion 30
************************Hoja de trabajo 7********************************
-------------------------------------------------------------------------*/
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
/**
 *
 * @author Marlon
 */
public class ArbolBusquedaTest {
  
    @Test
    public void insertar(){
        Map arreglo[] = new TreeMap[2];
        ArbolBusqueda<Map>[] hojaArbol; 
        hojaArbol = new ArbolBusqueda[2];
        arreglo[0] = new TreeMap();
        arreglo[0].put("hola", "hi");
        arreglo[1] = new TreeMap();
        arreglo[1].put("la", "the");
        ArbolBusqueda<Map> root = new ArbolBusqueda<>(arreglo[0]);
        hojaArbol[1] = new ArbolBusqueda(arreglo[1]);
        root.insertar(root,hojaArbol[1]);
    }
    
    @Test
    public void buscar(){
        Map arreglo[] = new TreeMap[3];
        ArbolBusqueda<Map>[] hojaArbol; 
        hojaArbol = new ArbolBusqueda[3];
        arreglo[0] = new TreeMap();
        arreglo[1] = new TreeMap();
        arreglo[2] = new TreeMap();
        arreglo[0].put("hola", "hi");
        arreglo[1].put("pueblo", "town");
        arreglo[2].put("mujer", "woman");
        ArbolBusqueda<Map> root = new ArbolBusqueda<>(arreglo[0]);
        hojaArbol[1] = new ArbolBusqueda(arreglo[1]);
        hojaArbol[2] = new ArbolBusqueda(arreglo[2]);
        root.insertar(root,hojaArbol[1]);
        root.insertar(root,hojaArbol[2]);
        String palabra = root.buscar(root, "hi");
        assertEquals("hola",palabra);
    }
}
