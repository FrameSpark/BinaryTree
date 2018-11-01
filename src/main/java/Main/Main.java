package Main;

import Test.TesterTree;
import Tree.SearchTree;


public class Main {
    public static void main(String[] args) {
        SearchTree<TesterTree,String> tree = new SearchTree<>(TesterTree.comp);

        TesterTree test = new TesterTree(5);
        tree.insertNode(test,"five");

        test = new TesterTree(1);
        tree.insertNode(test,"one");

        test = new TesterTree(3);
        tree.insertNode(test,"three");

        test = new TesterTree(10);
        tree.insertNode(test,"ten");

        test = new TesterTree(8);
        tree.insertNode(test,"eight ");


        tree.print();

        System.out.println("Удаление ключа 5");
        test = new TesterTree(5);
        tree.removeNode(test);
        tree.print();
    }
}
