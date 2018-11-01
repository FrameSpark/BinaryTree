package Tree;

import java.util.Comparator;

/**
 * Класс реализующий дерево поиска.
 * Доступные функции:
 * 1)Добавление узла insertNode(key,value)
 * 2)Удаление узла по ключу remove(key)
 * 3)Поиск узла по ключу searchNode(key)
 * @param <K> ключ
 * @param <V> значение
 */

public class SearchTree<K extends  Comparable, V> {
    private Comparator comparator;
    private Node root=null;

    /**
     * Конструктор класса SearchTree. При условии, если не передается comparator.
     */

    public SearchTree(){
        comparator = null;
    }

    public SearchTree(Comparator<K> comparator){
        this.comparator = comparator;
    }

    /**
     * Поиск в дереве по ключу
     * @param key искомый ключ
     * @return ссылка на узел с искомым ключем
     */
    private Node searchNode(K key){
        return search(root,key);
    }

    private Node search(Node cureent, K key){
        if(cureent == null || compare(key,(K)cureent.getKey()) == 0)
            return cureent;
        if(compare(key,(K)cureent.getKey()) == -1)
            return search(cureent.left,key);
        else
            return search(cureent.right,key);
    }

    /**
     * Функция вставки узла в дерево. Все ключи должны быть уникальным.
     * @param key вставляемый ключ
     * @param value вставляемое значение
     */
    public void insertNode(K key, V value) {
        root = insert(root, null, key, value);
    }

    /**
     * Приватная функция вставки узла в дерево.
     * @param current Текущий узел
     * @param previous Предыдущий
     * @param key Ключ
     * @param value Значение
     * @return
     */

    private Node insert(Node current, Node previous, K key, V value) {
        if (current == null) {
            current = new Node(key, value, previous);
        } else {
            if (compare(key,(K)current.getKey()) == -1)
                current.left = insert(current.left, current, key, value);
            else
                if(compare(key, (K)current.getKey()) == 1)
                 current.right = insert(current.right, current, key, value);
        }
        return current;
    }


    /**
     * Функция удаления узла по ключу.
     * @param key
     */
    public void removeNode(K key) {
        remove(root, key);
    }
    /**
     * Функция удаления узла по ключу.
     * @param current
     * @param key
     */

    void remove(Node current, K key) {
        if (current == null)
            return;
        if (compare(key,(K)current.getKey()) == -1)
            remove(current.left, key);
        else if (compare(key,(K)current.getKey()) == 1)
            remove(current.right, key);
        else if (current.left != null && current.right != null) {
            Node temp = current.right;
            while (temp.left != null)
                temp = temp.left;
            current.setKey(temp.getKey());
            current.setValue(temp.getKey());
            replace(temp, temp.right);
        } else if (current.left != null) {
            replace(current, current.left);
        } else if (current.right != null) {
            replace(current, current.right);
        } else {
            replace(current, null);
        }
    }

    private void replace(Node a, Node b) {
        if (a.previous == null)
            root = b;
        else
        if (a == a.previous.left)
            a.previous.left = b;
        else
            a.previous.right = b;
        if (b != null)
            b.previous = a.previous;
    }

    /**
     * Функция вывода
     */
    public void print() {
        print(root);
        System.out.println();
    }

    void print(Node current) {
        if (current != null) {
            print(current.left);
            System.out.println("Key : " + current.getKey().toString() + " Value :" + current.getValue().toString() + " ");
            print(current.right);
        }
    }


    /**
     * Функция сравнения ключей
     * @param key1 первый ключ
     * @param key2 второй ключ
     * @return
     *  key1 == key2  Return 0
     *  key1 > key2 Return 1
     *  key1 < key2 Return -1
     */
    private int compare(K key1, K key2) {
        if(comparator != null){
            return comparator.compare(key1, key2);
        }
        else{
            return ((Comparable)key1).compareTo(key2);
        }

    }
}
