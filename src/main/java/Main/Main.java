package Main;

import Test.TesterTrees;
import Tree.SearchTree;


public class Main {
    public static void main(String[] args) {
        SearchTree<TesterTrees,String> tree = new SearchTree<>(TesterTrees.comp);

        TesterTrees test = new TesterTrees(5);
        tree.insertNode(test,"five");

        test = new TesterTrees(1);
        tree.insertNode(test,"one");

        test = new TesterTrees(3);
        tree.insertNode(test,"three");

        test = new TesterTrees(10);
        tree.insertNode(test,"ten");

        test = new TesterTrees(8);
        tree.insertNode(test,"eight ");


        tree.print();

        System.out.println("Удаление ключа 5");
        test = new TesterTrees(5);
        tree.removeNode(test);
        tree.print();
    }
}
