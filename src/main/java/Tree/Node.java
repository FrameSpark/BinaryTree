package Tree;

/**
 * Узел
 * @param <K> тип ключа
 * @param <V> тип значения
 */
public class Node<K extends Comparable,V> {
    private K key;
    private V value;
    Node<K,V> left;
    Node <K,V> right;
    Node<K,V> previous;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }


    Node(K key,V value,Node previous){
        this.key = key;
        this.value = value;
        this.previous = previous;
    }





}
