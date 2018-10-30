package BinaryTree;

public class Node {
    private int key;
    private int value;
    Node l;
    Node r;
    Node p;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    Node(int key,int value,Node p){
        this.key = key;
        this.value = value;
        this.p = p;
    }





}
