import materia.controllers.AVLtree;
//import materia.controllers.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
        //BinaryTree ab = new BinaryTree();
        AVLtree avl= new AVLtree();
        //ab.insert(50);
        //ab.insert(17);
        //ab.insert(76);
        //ab.insert(9);
        //ab.insert(23);
        //ab.insert(54);
        //ab.insert(14);
        //ab.insert(19);
        //ab.printPreOrder();
        //ab.printPosOrder();
        //ab.printInOrder();
        //ab.printInOrderWithAltura();
        //ab.printInOrderWithBalanceFactor();
        //ab.resumenDelArbol();
        //ab.insertarYVerificar(15);
        avl.insert(5);
        avl.insert(20);
        avl.insert(15);
    }
}
