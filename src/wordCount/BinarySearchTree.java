/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordCount;

/**
 *
 * @author Sakemi
 */
public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(String element) {
        Node parent = null;
        Node temp = root;
        Node newNode = new Node(element, null, null);

        while (temp != null) {
            parent = temp;

            temp = element.compareToIgnoreCase(temp.getElement()) < 0 ? temp.getLeft() : temp.getRight();
        }

        if (parent == null) {
            root = newNode;
        } else if (element.compareToIgnoreCase(parent.getElement()) < 0) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node temp) {
        if (temp != null) {
            inOrder(temp.getLeft());
            System.out.println(temp);
            inOrder(temp.getRight());
        }
    }

    public Node binSearch(String element) {
        Node temp = root;

        while (temp != null) {
            if (element.equals(temp.getElement())) {
                return temp;
            }

            temp = element.compareToIgnoreCase(temp.getElement()) < 0 ? temp.getLeft() : temp.getRight();
        }
        return null;
    }

    @Override
    public String toString() {
        return "ABB{" + "root=" + root + "}";
    }

}
