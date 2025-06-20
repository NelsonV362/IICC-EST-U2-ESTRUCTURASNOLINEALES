package materia.controllers;

import materia.models.Node;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int valor) {
        if (padre == null) {
            return new Node(valor);
        }

        if (valor < padre.getValor()) {
             padre.setIzquierdo(insertRec(padre.getIzquierdo(), valor));} else if (valor > padre.getValor()) {
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

    public void printInOrderWithAltura() {
        System.out.print("InOrder con alturas: ");
    inOrderWithAlturaRec(root);
        System.out.println();
    }

    private void inOrderWithAlturaRec(Node node) {
     if (node != null) {
            inOrderWithAlturaRec(node.getIzquierdo());
          System.out.print("" + node.getValor() + ", h=" + altura(node) + " ");
            inOrderWithAlturaRec(node.getDerecho());
        }
    }

    public void printPosOrder() {
        System.out.print("PostOrder: ");
          postOrderRec(root);
        System.out.println();
    }
    private void postOrderRec(Node node) {
        if (node != null) {
             postOrderRec(node.getIzquierdo());
            postOrderRec(node.getDerecho());
                 System.out.print(node.getValor() + " ");
        }
    }

    public void printInOrderWithBalanceFactor() {
 System.out.print("InOrder con factor de equilibrio: ");
      inOrderWithBalanceFactorRec(root);
               System.out.println();
    }

    private void inOrderWithBalanceFactorRec(Node node) {
        if (node != null) {
            inOrderWithBalanceFactorRec(node.getIzquierdo());
            int balanceFactor = altura(node.getIzquierdo()) - altura(node.getDerecho());
            System.out.print(node.getValor() + "FactorE=" + balanceFactor + " ");
         inOrderWithBalanceFactorRec(node.getDerecho()); }
    }
    private int altura(Node node) {
        if (node == null) return -1;
     int izqAltura = altura(node.getIzquierdo());
                int derAltura = altura(node.getDerecho());
         return 1 + Math.max(izqAltura, derAltura);
    }
    public int peso() {
return pesoRec(root);
    }
    private int pesoRec(Node node) {
        if (node == null) return 0;
        return 1 + pesoRec(node.getIzquierdo()) + pesoRec(node.getDerecho());
    }
    public int altura() {
        return altura(root);
    }
    private int factorEquilibrio(Node node) {
        if (node == null) return 0;
        return altura(node.getIzquierdo()) - altura(node.getDerecho());
    }
    public boolean estaEquilibrado() {
     return estaEquilibradoRec(root);
    }
  private boolean estaEquilibradoRec(Node node) {
     if (node == null) return true;
int fe = factorEquilibrio(node);
             if (fe < -1 || fe > 1) return false;
         return estaEquilibradoRec(node.getIzquierdo()) && estaEquilibradoRec(node.getDerecho());
    }
    public boolean existe(int valor) {
        return existeRec(root, valor);
    }
    private boolean existeRec(Node node, int valor) {
        if (node == null) return false;
      if (node.getValor() == valor) return true;
       if (valor < node.getValor()) {
            return existeRec(node.getIzquierdo(), valor);
     } else {
              return existeRec(node.getDerecho(), valor);
        }
    }

    public void resumenDelArbol() {
      System.out.println("Peso del árbol: " + peso());
          System.out.println("Altura total del árbol: " + altura());
      System.out.println("¿Está equilibrado?: " + estaEquilibrado());
             System.out.println("¿Existe el nodo 15?: " + existe(15));
    }

    public void insertarYVerificar(int valor) {
    System.out.println("Insertando valor: " + valor);
 insert(valor);
        System.out.println("¿Está equilibrado después de insertar " + valor + "? " + estaEquilibrado());
    }
}
