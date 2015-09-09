/*-----------------------------------------------------------------------
Marlon Josue Castillo Martinez              14427
Carlos Javier Lima Cordon                   14373
Fernando Sebastian Castillo Echeverria      14102

Algoritmos y estructura de datos
Seccion 30
************************Hoja de trabajo 6********************************
-------------------------------------------------------------------------*/


package hoja7;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.*;
import java.util.logging.Logger;
import java.io.*;

public class main {
    public static void main(String[] args) {
         int palabra = 0;
         int cont = 0;        
         System.out.print("\n BINEVENIDO TRADUCTOR INGLES-ESPAÑOL: \n ");
         File texto = new File("C:\\Users\\SebasCas\\Documents\\NetBeansProjects\\Hoja7\\src\\hoja7//diccionario.txt");
         

         try {
             palabra = 0;
             BufferedReader m1 = new BufferedReader(new FileReader(texto));
             while (m1.readLine() != null) palabra++;
             m1.close();
             System.out.println("\n NUMERO DE PALABRAS (En/Es)EN DICCIONARIO.TXT: " + palabra + "\n");
             }
                    catch (IOException e){ }
                    String palabras[][] = new String[palabra][2];
         //se verifica si la palabra esta en ingles(true) o en español(falce).
         try{
            BufferedReader br = new BufferedReader(new FileReader(texto));
         try{
            for(String line; (line = br.readLine()) != null; ){
            StringBuilder Bpalabrain = new StringBuilder();
            StringBuilder Bpalabraes = new StringBuilder();
            boolean InEs = true; 
            //comensamos en 1 y termina en -1 ya que se cuentan los parentesis inicial y final.
            for (int y = 1; y<line.length()-1; y++){ 
                if (line.charAt(y) != 44){
                //iniciamos la formacion de palabra. 
                if (InEs==true){ 
                    char c = line.charAt(y);
                    Bpalabrain.append(c);}
                if (InEs==false){
                char c = line.charAt(y);
                    Bpalabraes.append(c);}}                        
                if (line.charAt(y) == 44){
                            //se cambia de palabra a español si es coma ya que despues es la palabra a español
                    InEs = false;}                  
                        else {
                            //si es algo mas o un espacio no se agrega.
                        }
                    }
                    String palabrain = Bpalabrain.toString();
                    String palabraes = Bpalabraes.toString();          
                    palabras[cont][1] = palabrain; //agregan palabras en array que contiene en espaniol e ingles
                    palabras[cont][0] = palabraes;
                    cont++;
                }
            }
            catch(IOException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	catch(FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Se hace un Map con cada una de las palabras. 
        Map arreglo[] = new TreeMap[cont]; 
        
        //agregamos las palabras al Map 
        for(int y=0; y<cont; y++){
            arreglo[y] = new TreeMap();
            arreglo[y].put(palabras[y][0], palabras[y][1]);
        }
        
        // la raiz, se crean hojas com palabras restantes. 
        ArbolBusqueda<Map>[] hojaArbol; 
        hojaArbol = new ArbolBusqueda[cont];
        ArbolBusqueda<Map> root = new ArbolBusqueda<>(arreglo[0]);
        
        for(int t=1;t<cont;t++){
            hojaArbol[t] = new ArbolBusqueda(arreglo[t]);
            root.insertar(root,hojaArbol[t]);
        } 
        
        System.out.println("Palabras en Orden :");
        System.out.println("*Ingles / Español*");
        root.inOrder(root);
        
        //************************************************************************************************************
        //Lectura y traduccion de oracion en ingles 
        int cont2 = 0;
        System.out.println("\n ***TRADUCCIÓN INGLES A ESPAÑOL: \n");
        File oracionI = new File("C:\\Users\\SebasCas\\Documents\\NetBeansProjects\\Hoja7\\src\\hoja7//oracionIngles.txt");
        StringBuilder Bpalabra = new StringBuilder();
        try{
            BufferedReader br2 = new BufferedReader(new FileReader(oracionI));
        try {
            for(String line; (line = br2.readLine()) != null; ){
            for (int y = 0; y<line.length(); y++){
                if (line.charAt(y)!= 32){
                   char d = line.charAt(y);
                    Bpalabra.append(d);
                    cont2++;}                                          
                if ((line.charAt(y) == 32) && cont2>0){
                    
                    String NoTraducida = Bpalabra.toString();
                    String español = root.buscar(root, NoTraducida);
                    if (español == null){
                        //Imprimimos la palabra no encontrada y colocamos los *
                        System.out.print(" *" + NoTraducida + "* ");}                     
                            else {
                                //Imprimimos la palabra en español. 
                                System.out.print(español);}
                            Bpalabra = new StringBuilder(); //Reseteamos el StringBuilder
                            cont2 = 0;
                        }
                       
                     if( (y == (line.length()-1)) && (line.charAt(line.length()-1) != 32)){
                        String NoTraducida = Bpalabra.toString();
                        String español = root.buscar(root, NoTraducida);
                        if (español == null){
                            //Imprimimos la palabra no encontrada y colocamos los *
                             System.out.print(" *" + NoTraducida + "* ");}                         
                        else {
                            //Imprimimos la palabra en español. 
                             System.out.print(español + "\n");
                             System.out.println("-------------------------------------------------------------------------------------------");
                        System.out.println("\n ***********************Fin de la Traduccion :)***************** \n"); }}}                                                            
                            
            }               
            }
                catch(IOException ex) {
                     Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);}}
                catch(FileNotFoundException ex) {
                     Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);}}  
}
