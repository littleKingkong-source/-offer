package referoffer;

import sun.management.Agent;

import java.util.Scanner;

/**
 * @author crazy邹
 * @create 2021/3/25 20:44
 */
class Person{
    private int age;
    Person(){
        super();
    }
    Person(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int i){


            if (i > 0 && i < 130) {
                age = i;

            }else {
                System.out.println("请重新输入age:");

            }

    }
}


public class Text {
    public static void main(String[] args) {
        System.out.println("请输入age：");
        Person p = new Person(20);
        p.setAge(new Scanner(System.in).nextInt());
        System.out.println("age is " + p.getAge());
    }
}
