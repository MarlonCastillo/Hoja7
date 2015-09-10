/*-------------------------------------------------------------------
Autores:
Marlon Josue Castillo martinez              14427
Carlos Javier Lima Cordon                   14373
Fernando Sebastian Castillo Echeverria      14102

Algoritmos y estructura de datos
Sección 30
Hoja de trabajo 7
-------------------------------------------------------------------*/

/*
 //este codigo fue tomado del siguiente enlace:
 * http://www.cis.upenn.edu/~matuszek/cit594-2008/Examples/BinaryTrees/src/BinaryTree.java
 */



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.*;

public class ArbolBusqueda<V> {
    /**
     * The value (data) in this node of the binary tree; may be of
     * any object type.
     */
    public V value;
    private ArbolBusqueda<V> leftChild;
    private ArbolBusqueda<V> rightChild;
    private boolean comparacion;
    private boolean funcionamiento = true;
    String retorno;

    /**
     * Constructor for BinaryTree.
     * 
     * @param value The value to be placed in the root.
     * @param leftChild The left child of the root (may be null).
     * @param rightChild The right child of the root (may be null).
     */
    public ArbolBusqueda(V value, ArbolBusqueda<V> leftChild, ArbolBusqueda<V> rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    /**
     * @param value The value to be placed in the root.
     */
    public ArbolBusqueda(V value) {
        this(value, null, null);
    }
    /**
     * @return The value in this node.
     */
    public V getValue() {
        return value;
    }
    /**
     * @return The left child (<code>null</code> if no left child).
     */
    public ArbolBusqueda<V> getLeftChild() {
        return leftChild;
    } 
    /**
     * @return The right child (<code>null</code> if no right child).
     */
    public ArbolBusqueda<V> getRightChild() {
        return rightChild;
    }
    /**
     * @param subtree The node to be added as the new left child.
     * @throws IllegalArgumentException If the operation would cause
     *         a loop in the binary tree.
     */
    public void setLeftChild(ArbolBusqueda<V> subtree) throws IllegalArgumentException {
        if (contains(subtree, this)) {
            throw new IllegalArgumentException(
                "Subtree " + this +" already contains " + subtree);
        }
        leftChild = subtree;
    }
    /**
     * @param subtree The node to be added as the new right child.
     * @throws IllegalArgumentException If the operation would cause
     *         a loop in the binary tree.
     */
    public void setRightChild(ArbolBusqueda<V> subtree) throws IllegalArgumentException {
        if (contains(subtree, this)) {
            throw new IllegalArgumentException(
                    "Subtree " + this +" already contains " + subtree);
        }
        rightChild = subtree;
    }
    /**
     * Sets the value in this BinaryTree node.
     * 
     * @param value The new value.
     */
    public void setValue(V value) {
        this.value = value;
    }
    /**
     * Tests whether this node is a leaf node.
     * 
     * @return <code>true</code> if this BinaryTree node has no children.
     */
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }
    
    /**
     * @return <code>true</code> if the binary trees are equal.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        if (o == null || !(o instanceof ArbolBusqueda)) {
            return false;
        }
        ArbolBusqueda<?> otherTree = (ArbolBusqueda<?>) o;
        return equals(value, otherTree.value)
            && equals(leftChild, otherTree.getLeftChild())
            && equals(rightChild, otherTree.getRightChild());
    }
    
    /**
     * @param x The first object to be tested.
     * @param y The second object to be tested.
     * @return <code>true</code> if the two objects are equal.
     */
    private boolean equals(Object x, Object y) {
        if (x == null) return y == null;
        return x.equals(y);
    }

    /**
     * @param tree The root of the binary tree to search.
     * @param targetNode The node to be searched for.
     * @return <code>true</code> if the <code>targetNode</code> argument can
     *        be found within the binary tree rooted at <code>tree</code>.
     */
    protected static boolean contains(ArbolBusqueda tree,
                                      ArbolBusqueda targetNode) {
        if (tree == null)
            return false;
        if (tree == targetNode)
            return true;
        return contains(tree.getLeftChild(), targetNode)
            || contains(tree.getRightChild(), targetNode);
    }
    public void print() {
        print(this, 0);
    }
    
    private void print(ArbolBusqueda<V> root, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("   ");
        }
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.println(root.value);
        if (root.isLeaf()) return;
        print(root.leftChild, indent + 1);
        print(root.rightChild, indent + 1);
    }


    /**
     * @return An exact copy of this BinaryTree; the values in the new BinaryTree
     *         are == to the values in this BinaryTree.
     */
    public ArbolBusqueda<V> copy() {
        ArbolBusqueda<V> left =  null, right = null;
        if (this.leftChild != null) {
            left = this.leftChild.copy();
        }
        if (this.rightChild != null) {
            right = this.rightChild.copy();
        }
        return new ArbolBusqueda(this.value, left, right);
    }

    /*
     * @return A mirror image copy of this BinaryTree; values in the new BinaryTree
     *         are == to the values in this BinaryTree.
     */
    public ArbolBusqueda<V> reverse() {
        ArbolBusqueda<V> left =  null, right = null;
        if (this.leftChild != null) {
            left = this.leftChild.reverse();
        }
        if (this.rightChild != null) {
            right = this.rightChild.reverse();
        }
        return new ArbolBusqueda(this.value, right, left);
    }

    /**
     * Rearranges the binary tree rooted at this binary tree to be the mirror image
     * of its original structure. No new BinaryTree nodes are created in this
     * process.
     */
    public void reverseInPlace() {
        if (this.leftChild != null) {
            leftChild.reverseInPlace();
        }
        if (this.rightChild != null) {
            rightChild.reverseInPlace();
        }
        ArbolBusqueda<V> temp = this.leftChild;
        this.setLeftChild(this.rightChild);
        this.setRightChild(temp);
    }
    
    public void insertar(ArbolBusqueda<V> papa, ArbolBusqueda<V> subarbol){
        boolean mayor = papa.compareTo(papa, subarbol);
        if(mayor==true){ //si papa es mayor que el subarbol, se agrega del lado izquierdo
            if(papa.getLeftChild()==null){
                papa.setLeftChild(subarbol);
                
            }
            else{
                ArbolBusqueda<V> temp = papa.getLeftChild(); //Guardamos el nuevo papa 
                papa = temp;
                insertar(papa,subarbol);
            }
        }
        
        else if(mayor==false){ //si papa es menor que el subarbol, se agrega del lado derecho
            if(papa.getRightChild()==null){
                papa.setRightChild(subarbol);
                
            }
            else{
                ArbolBusqueda<V> temp = papa.getRightChild(); //Guardamos el nuevo papa 
                papa = temp;
                insertar(papa,subarbol);
            }
        }
    }
        
    public boolean compareTo(ArbolBusqueda<V> padre, ArbolBusqueda<V> hijo){
        //boolean comparacion = true;
        if((hijo.getValue()==null) || (padre.getValue()==null))
        {
            
        }
        
        else{
            TreeMap palabrapadre = (TreeMap) padre.getValue();
            TreeMap palabrahijo = (TreeMap) hijo.getValue();
            
            Object  algohijo = palabrahijo.firstKey();
            String nombrehijo = (String) palabrahijo.get(algohijo);

            Object  algopadre = palabrapadre.firstKey();
            String nombrepadre = (String) palabrapadre.get(algopadre);
            
            //Para evitar OutofBounds en el for, solo recorreremos hasta el largo de la palabra mas corta.
            int largofor=0;
            if (nombrehijo.length()>=nombrepadre.length()){
                largofor = nombrepadre.length();
            }
            else if (nombrehijo.length()<nombrepadre.length()){
                largofor = nombrehijo.length();
            }

            for (int x = 0; x<largofor; x++){
                String chijo = Character.toString(nombrehijo.charAt(x)).toUpperCase();
                String cpadre = Character.toString(nombrepadre.charAt(x)).toUpperCase();

                if (chijo.compareTo(cpadre)>0){
                    comparacion = false;
                    break;
                }
                else if (chijo.compareTo(cpadre)<0){
                    comparacion = true;
                    break;
                }
                else {
                    //Si son iguales, pasamos a la siguiente letra
                }
            }
        }
        return comparacion;
    }
    
    public void inOrder(ArbolBusqueda<V> raiz){
        if (raiz != null){
            inOrder(raiz.getLeftChild());
            
            TreeMap palabraImprimir = (TreeMap) raiz.getValue();
            Object  objPalabra = palabraImprimir.firstKey();
            String nombre = (String) palabraImprimir.get(objPalabra);
            System.out.println("("+nombre+","+palabraImprimir.firstKey()+")");
            
            inOrder(raiz.getRightChild());
        }
    }
    
    public String buscar(ArbolBusqueda<V> raiz, String palabra){
        funcionamiento = true;
        if (funcionamiento==true){
            if (raiz != null){

                if (funcionamiento == true){
                    buscar(raiz.getLeftChild(), palabra);
                }
                TreeMap palabracomp = (TreeMap) raiz.getValue();
                Object  algohijo = palabracomp.firstKey();
                String nombrehijo = (String) palabracomp.get(algohijo);

                String nombrehijoMay = nombrehijo.toUpperCase();
                String palabraMay = palabra.toUpperCase();
                
                if (nombrehijoMay.equals(palabraMay)){
                    Object algoespanol = palabracomp.firstKey();
                    retorno = (String) algoespanol;
                    funcionamiento = false;
                    
                }
                if (funcionamiento == true){
                    buscar(raiz.getRightChild(), palabra);
                }

            }
            if ((raiz == null) && (funcionamiento == true)){
                retorno = null;
            }
        }
        return retorno;
    }
}


