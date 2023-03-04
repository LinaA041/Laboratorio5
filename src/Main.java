import java.util.Arrays;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            BST tree = new BST();

            System.out.println("Ingrese los nombres que desea incluir en el arreglo: ");
            String names = scanner.nextLine();
            String[] array = names.split(" ");


            tree.balancingTree(array, 0, array.length-1); //Parametros que va a recibir el metodo
            //"balancing tree" ubicado en Bts

            System.out.println("A continuación, podrá observar el arbol con los nombres en orden inverso: ");
            tree.inOrder(tree.getRoot());
        }
    }