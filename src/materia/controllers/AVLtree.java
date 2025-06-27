package materia.controllers;
import materia.models.*;

public class AVLtree {
    private Node root;

    public AVLtree() {}

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
                newNode.setHeight(1);
            System.out.println("Nodo insertado-> " + value + " con balance " + getBalance(newNode));
            return newNode;
          }

    if (value <= node.getValor()) {
            node.setIzquierdo(insertRec(node.getIzquierdo(), value));
        } else if (value > node.getValor()) {
        node.setDerecho(insertRec(node.getDerecho(), value));
         } else {
            return node; 
         }
        int alturaIzq = height(node.getIzquierdo());
        int alturaDer = height(node.getDerecho());
        node.setHeight(1 + Math.max(alturaIzq, alturaDer));

      int balance = getBalance(node);
      System.out.println("Nodo actual-> " + node.getValor() + ", altura-> " + node.getHeight() + ", balance-> " + balance);
        if (balance > 1 && value < node.getIzquierdo().getValor()) {
            System.out.println("Rotacion simple derecha");
                return rightRotation(node);
        }
    if (balance < -1 && value > node.getDerecho().getValor()) {
          System.out.println("Rotacion simple izquierda");
            return leftRotation(node);
        }
        if (balance > 1 && value > node.getIzquierdo().getValor()) {
            System.out.println("Cambio.");
            System.out.println("Rotacion DER en nodo: " + node.getIzquierdo().getValor() + ", con balance = " + getBalance(node.getIzquierdo()) + ".");
            node.setIzquierdo(leftRotation(node.getIzquierdo()));
            System.out.println("Nueva raiz despues de la rotacion " + node.getIzquierdo().getValor() + ".");
            System.out.println("Rotacion simple izquierda.");
            return rightRotation(node);
        }

        if (balance < -1 && value < node.getDerecho().getValor()) {
            System.out.println("Cambio.");
            System.out.println("Rotacion IZQ en nodo: " + node.getDerecho().getValor() + ", con balance=" + getBalance(node.getDerecho()) + ".");
            node.setDerecho(rightRotation(node.getDerecho()));
            System.out.println("Nueva raiz despues de la rotacion " + node.getDerecho().getValor() + ".");
            return leftRotation(node);
        }return node;
    }
    private int height(Node node) {
        return (node == null) ? 0 : node.getHeight();
    }

    private int getBalance(Node node) {
        if (node == null) return 0;
        return height(node.getIzquierdo()) - height(node.getDerecho());
    }

    private Node leftRotation(Node x) {
        Node y = x.getDerecho();
        Node temp = y.getIzquierdo();

        y.setIzquierdo(x);
        x.setDerecho(temp);

        x.setHeight(1 + Math.max(height(x.getIzquierdo()), height(x.getDerecho())));
        y.setHeight(1 + Math.max(height(y.getIzquierdo()), height(y.getDerecho())));

        System.out.println("Rotacion IZQ en nodo: " + x.getValor() + ", con balance= " + getBalance(x));
        System.out.println("Nueva raiz despues de la rotacion " + y.getValor());

        return y;
    }

    private Node rightRotation(Node y) {
        Node x = y.getIzquierdo();
        Node temp = x.getDerecho();

        x.setDerecho(y);
        y.setIzquierdo(temp);

        y.setHeight(1 + Math.max(height(y.getIzquierdo()), height(y.getDerecho())));
        x.setHeight(1 + Math.max(height(x.getIzquierdo()), height(x.getDerecho())));

        System.out.println("Rotacion DER en nodo: " + y.getValor() + ", con balance= " + getBalance(y));
        System.out.println("Nueva raiz despues de la rotacion " + x.getValor());

        return x;
    }
}
