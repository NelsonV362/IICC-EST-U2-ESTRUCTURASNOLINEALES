package materia.controllers;

import materia.models.Node;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
           root = insertRec(root, value);
     }private Node insertRec(Node padre, int valor) {
        if (padre == null) {
                return new Node(valor);
        }

        if (valor < padre.getValor()) {
            padre.setIzquierdo(insertRec(padre.getIzquierdo(), valor));
        } else if (valor > padre.getValor()) {
                         padre.setDerecho(insertRec(padre.getDerecho(), valor));
        }
       return padre;
        }
    public void printPreOrder() {
        System.out.print("PreOrder: ");
    preOrderRec(root);
        System.out.println();
  }
    private void preOrderRec(Node node) {
       if (node != null) {
            System.out.print(node.getValor() + " ");
            preOrderRec(node.getIzquierdo());
            preOrderRec(node.getDerecho());
        }
    }
    public void printInOrder() {
    System.out.print("InOrder: ");
    inOrderRec(root);
        System.out.println();
    }
    private void inOrderRec(Node node) {
if (node != null) {
                inOrderRec(node.getIzquierdo());
         System.out.print(node.getValor() + " ");
        inOrderRec(node.getDerecho());
        }
    }
    public void printPosOrder() {System.out.print("PostOrder: ");
        postOrderRec(root);
        System.out.println();
    }
   private void postOrderRec(Node node) {
        if (node != null) {
        postOrderRec(node.getIzquierdo());
         postOrderRec(node.getDerecho());
            system.out.print(node.getValor() + " ");
        }
    }
}
