/*-------------------------------------------------------------------
Autores:
Marlon Josue Castillo martinez              14427
Carlos Javier Lima Cordon                   14373
Fernando Sebastian Castillo Echeverria      14102

Algoritmos y estructura de datos
Sección 30
Hoja de trabajo 7
-------------------------------------------------------------------*/

import java.util.*;

class Comparador implements Comparator{

    public int compare(Object ingles, Object espanol){
    	//hace una comparacion entre las palabras de ingles para ordenarlas alfabeticamente
        String ingles1 = ( (Employee) ingles).getIngles();
        String ingles2 = ( (Employee) ingless).getIngles();
		return ingles1.compareTo(ingles2);
         
    }

}

