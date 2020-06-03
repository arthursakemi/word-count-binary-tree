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
public class Node {

    private String element;
    private int count;
    private Node left;
    private Node right;

    public Node(String element, Node left, Node right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.count = 1;
    }

    public void increment() {
        this.count++;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return String.format("%s = %d", this.element, this.count);
    }

}
