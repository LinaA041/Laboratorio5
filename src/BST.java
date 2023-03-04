import java.util.ArrayList;
import java.util.List;

public class BST {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public BST(){
        this.root = null;
    }

    public void addNode(String key) {
        root = addNode(root, key);
    }

    private Node addNode(Node node, String key) {

        if (node == null) {
            node = new Node(key);
            return node;
        }

        if (key.compareTo(node.getValue()) < 0) {
            //Meter a la izquierda
            node.setLeft(addNode(node.getLeft(), key));

        } else if (key.compareTo(node.getValue()) > 0) {
            //Meter a la derech
            node.setRight(addNode(node.getRight(), key));
        }
        return node;
    }

    public void balancingTree(String[] array, int start, int end) {  //parametros recibidos desde main

        if (start > end) { //es nuestro caso base, star hace referancia a la primera posicion (o) y end hace referencia a la ultima posicion
            return;
        }

        int half; //se crea una variable para determinar la mitad

        if(array.length%2==0) {  //comprobamos si el tamañano del arreglo es par

            half = ((start + end) / 2)-1;

        }else  { //o impar

            half =(start + end)/2;
        }

        addNode(array[half]);  //agregamos la  raiz del nuevo subarbol al principal

        balancingTree(array, start, half-1); /*llamado recursivo hasta cumplir con el caso base, en este caso
        se crea el sub arbol izquierdo, con los elementos que estan a la izquierda de la raiz */

        balancingTree(array, half+1, end); /*llamado recursivo hasta cumplir con el caso base, pero en este caso
       con los elementos de la derecha, para crear el subarbol derecho */

    }

    public void inOrder(Node current){

        if(current==null){
            return;
        }
        inOrder(current.getRight());
        System.out.println(current.getValue()+"");
        inOrder(current.getLeft());
    }

}
