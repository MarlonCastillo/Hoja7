/*-------------------------------------------------------------------
Autores:
Marlon Josue Castillo martinez              14427
Carlos Javier Lima Cordon                   14373
Fernando Sebastian Castillo Echeverria      14102

Algoritmos y estructura de datos
Sección 30
Hoja de trabajo 7
-------------------------------------------------------------------*/

//este codigo fue tomado del siguiente enlace:
//http://www.lawebdelprogramador.com/codigo/Java/2257-Arboles-binarios-de-busqueda.html

//clase que permite implementar un arbol binario de busqueda
import java.util.*;
public class ArbolBusqueda {

//clase para crear los nodos del arbol 
    private class nodoArbol {
        private ArbolBusqueda hd;
        private ArbolBusqueda hi;
        private String dato;
 
        private void nodoArbol(){
            hd = null;
            hi = null;
            dato = "";
        }
    }
    public nodoArbol raiz;
//creamos la raiz del arbol
    public void ArbolBusqueda(){
        nodoArbol raiz = new nodoArbol();
    }
 //verificamos si el arbol esta vacio o no
    public boolean esVacio(){
        return (raiz == null);
    }
//insertamos un nuevo elemento en el arbol
    public void insertar(String a){
        //si el arbol esta vacio entonces el elemento ingresado se convierte en la raiz
        if (esVacio()) {
            nodoArbol nuevo = new nodoArbol();
            nuevo.dato = a;
            nuevo.hd = new ArbolBusqueda();
            nuevo.hi = new ArbolBusqueda();
            raiz = nuevo;
        }
        else {
            //si no esta vacio el arbol se verifica si se coloca al lado derecho o izquierdo segun sea mayor o menor respectivamente
            //compareTo regresa un 0 si son iguales, un positivo si el primero es mayor al segundo y un negativo si el primero es menor al segundo
            int b = a.compareTo(raiz.dato);
            if (b>0) {
                (raiz.hd).insertar(a);
            }
            if (b<0){
                (raiz.hi).insertar(a);
            }
        }
    }

//permite hacer un recorrido preOrder (raiz, izquierdo, derecho)
    public void preOrder(){
        if (!esVacio()) {
            System.out.print( raiz.dato + ", "  );
            raiz.hi.preOrder();
            raiz.hd.preOrder();
        }
    }

//permite hacer un recorrido preOrder (izquierdo, raiz, derecho)
    public void inOrder(){
        if (!esVacio()) {
            raiz.hi.inOrder();
            System.out.print( raiz.dato + ", "  );
            raiz.hd.inOrder();
        }
    }

//permite hacer un recorrido preOrder (izquierdo, derecho, raiz)
    public void posOrder(){
        if (!esVacio()) {
            raiz.hd.posOrder();
            raiz.hi.posOrder();
            System.out.print( raiz.dato + ", "  );
 
        }
    }

//busca un elemento especifico en el arbol
    public ArbolBusqueda buscar(String a){
        ArbolBusqueda arbolito = null;
        int b = a.compareTo(raiz.dato);
        //si el arbol no esta vacio comienza la busqueda, de lo contrario retorna null
        if (!esVacio()) {
            //si el valor que se desea buscar es igual a la raiz
            if (b==0) {
            System.out.println(a);
            return this;
            }
            else {
                //si no es igual a la raiz verifica si es mayor o menor a la misma, cambia la raiz y vuelve a llamar de nuevo al metodo
                if (b<0) {
                    arbolito = raiz.hi.buscar(a);
                }
                else {
                    arbolito = raiz.hd.buscar(a);
                }
            }
        }
        return arbolito;
    }
 /*
    public boolean existe(int a){
    if (!esVacio()) {
            if (a == raiz.dato) {
            return true;
            }
            else {
                if (a < raiz.dato) {
                    raiz.hi.existe(a);
                }
                else {
                    raiz.hd.existe(a);
                }
            }
        }
        return false;
    }
 
    public int cantidad(){
        if (esVacio()) {
            return 0;
        }
        else {
            return (1 + raiz.hd.cantidad() + raiz.hi.cantidad());
        }
    }
 
    public int altura() {
        if (esVacio()) {
            return 0;
        }
        else {
            return (1 + Math.max(((raiz.hi).altura()), ((raiz.hd).altura())));
        }
    }
 
    public int buscarMin() {
        ArbolBusqueda arbolActual = this;
        while( !arbolActual.raiz.hi.esVacio() ) {
            arbolActual = arbolActual.raiz.hi;
        }
        int devuelvo= arbolActual.raiz.dato;
        arbolActual.raiz=null;
        return devuelvo;
    }
 
    public int buscarMan() {
        ArbolBusqueda arbolActual = this;
        while( !arbolActual.raiz.hd.esVacio() ) {
            arbolActual = arbolActual.raiz.hd;
        }
        int devuelvo= arbolActual.raiz.dato;
            arbolActual.raiz=null;
        return devuelvo;
    }
 
    public boolean esHoja() {
        boolean hoja = false;
        if( (raiz.hi).esVacio() && (raiz.hd).esVacio() ) {
            hoja = true;
        }
        return hoja;
    }
 
    public void eliminar(int a) {
        ArbolBusqueda paraEliminar = buscar(a);
        if (!paraEliminar.esVacio()) {
            if (paraEliminar.esHoja()) {
                paraEliminar.raiz = null;
            }
            else {
                if (!paraEliminar.raiz.hi.esVacio() && !paraEliminar.raiz.hd.esVacio()) {
                    paraEliminar.raiz.dato = paraEliminar.raiz.hd.buscarMin();
                }
                else {
                    if (paraEliminar.raiz.hi.esVacio()) {
                        paraEliminar.raiz = paraEliminar.raiz.hd.raiz;
                    }else{
                        paraEliminar.raiz = paraEliminar.raiz.hi.raiz;
                    }
                }
            }
        }
    }*/
}
