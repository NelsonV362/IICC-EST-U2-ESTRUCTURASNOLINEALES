package materia.models;

public class Node {
    private int valor;
    private Node izquierdo;
    private Node derecho;
    private int height; 

    public Node(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
        this.height = 1;
    }

    public int getValor() {
        return valor;
    }

    public Node getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Node izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Node getDerecho() {
        return derecho;
    }

    public void setDerecho(Node derecho) {
        this.derecho = derecho;
    }

    public int getHeight() { 
        return height;
    }

    public void setHeight(int height) { 
        this.height = height;
    }
}
