package Test;


import java.util.Comparator;

/**
 * Класс для тестирования класса SearchTree
 */

public class TesterTrees implements Comparable<TesterTrees> {

    private Integer num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public TesterTrees(int num){
        this.num = num;
    }

    public String toString(){
        return  num.toString();
    }
    //компаратор анонимного класса
    public static final Comparator<TesterTrees> comp = new Comparator<>() {
        @Override
        public int compare(TesterTrees o1, TesterTrees o2) {
            if(o1.num > o2.num){
                return 1;
            }
            if(o1.num <o2.num){
                return -1;
            }
            return 0;
        }
    };


    @Override
    public int compareTo(TesterTrees o){
        if(this.num > o.num){
            return 1;
        }
        if(this.num < o.num){
            return  -1;
        }
        return 0;
    }

}
