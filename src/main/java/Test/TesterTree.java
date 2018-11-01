package Test;


import java.util.Comparator;

/**
 * Класс для тестирования класса SearchTree
 */

public class TesterTree implements Comparable<TesterTree> {

    private Integer num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public TesterTree(int num){
        this.num = num;
    }

    public String toString(){
        return  num.toString();
    }
    //компаратор анонимного класса
    public static final Comparator<TesterTree> comp = new Comparator<>() {
        @Override
        public int compare(TesterTree o1, TesterTree o2) {
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
    public int compareTo(TesterTree o){
        if(this.num > o.num){
            return 1;
        }
        if(this.num < o.num){
            return  -1;
        }
        return 0;
    }

}
