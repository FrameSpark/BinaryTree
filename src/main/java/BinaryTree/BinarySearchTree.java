package BinaryTree;

public class BinarySearchTree {
    Node root;

    Node search(int key){
        return search(root,key);
    }

    Node search(Node t, int key){
        if(t == null || t.getKey() == key)
            return t;
        if(key < t.getKey())
            return search(t.l,key);
        else
            return search(t.r,key);
    }

    Node insert(Node t, Node p, int key, int value) {
        if (t == null) {
            t = new Node(key, value, p);
        } else {
            if (key < t.getKey())
                t.l = insert(t.l, t, key, value);
            else
                t.r = insert(t.r, t, key, value);
        }
        return t;
    }

    public void insert(int key, int value) {
        root = insert(root, null, key, value);
    }

    void replace(Node a, Node b) {
        if (a.p == null)
            root = b;
        else if (a == a.p.l)
            a.p.l = b;
        else
            a.p.r = b;
        if (b != null)
            b.p = a.p;
    }
    void remove(Node t, int key) {
        if (t == null)
            return;
        if (key < t.getKey())
            remove(t.l, key);
        else if (key > t.getKey())
            remove(t.r, key);
        else if (t.l != null && t.r != null) {
            Node m = t.r;
            while (m.l != null)
                m = m.l;
            t.setKey(m.getKey());
            t.setValue(m.getKey());
            replace(m, m.r);
        } else if (t.l != null) {
            replace(t, t.l);
        } else if (t.r != null) {
            replace(t, t.r);
        } else {
            replace(t, null);
        }
    }
    public void remove(int key) {
        remove(root, key);
    }
    void print(Node t) {
        if (t != null) {
            print(t.l);
            System.out.print(t.getKey() + ":" + t.getValue() + " ");
            print(t.r);
        }
    }
    public void print() {
        print(root);
        System.out.println();
    }
}
