package com.hhx.exception;

/**
 * @author huhaixaing
 * @date 2020/7/29 14:18
 * @Description: com.hhx.exception
 */
public class WisonicWrittenExaminationQuestions {



}

class Annoyance extends Exception{}

class Sneeze extends Annoyance{}

class Human{
    public static void main(String[] args) throws Exception{
        try{
            try {
                throw new Sneeze();
            }catch (Annoyance a){
                //关键是:Annoyance a = new Sneeze(); 多态,
                System.out.println("Caught Annoyance");
                System.out.println(a.hashCode()+a.toString());
                throw a;
                //即其实a只是一个子类的引用,所以Sneeze 是能够捕获的
            }
        }catch (Sneeze s){
            System.out.println(s.hashCode()+s.toString());
            System.out.println("Caught Sneeze");
            return ;
        }finally {
            System.out.println("Hello World!");
        }
    }
}