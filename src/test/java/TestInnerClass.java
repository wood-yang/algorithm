import java.util.ArrayList;
import java.util.List;

/**
 * 测试 Java 内部类
 */
public class TestInnerClass {
    public static void main(String[] args) {
        //1.普通内部类
        People xiaoming = new People("小明", 22);
        People.Dog dog = xiaoming.buyDog("小黄", "黑色");
        dog.bark();

        //2.静态内部类
        People.Teacher teacher = new People.Teacher();

        //3.局部内部类
        xiaoming.bookstore();

        //4.匿名内部类
        xiaoming.fruitShop();
    }
}

class People {
    private String name;
    private int age;
    public final static int NUMBER_OF_EYES = 2;

    //1.普通内部类
    class Dog {
        private String name;
        private String color;

        public Dog(String name, String color) {
            this.name = name;
            this.color = color;
        }

        public void bark() {
            System.out.println(People.this.name + "你在哪儿？我是" + this.name);
            System.out.println("我主人的年龄是：" + age);
        }
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog buyDog(String name, String color) {
       return this.new Dog(name, color);
    }

    //2.静态内部类
    static class Teacher {
        private String name;
        private String subject;

        public void ask() {
            System.out.println("人类的眼睛数为：" + NUMBER_OF_EYES);
        }
    }

    //方法内部类
    public void bookstore() {
        class Book {
            private double price;

            public Book(double price) {
                this.price = price;
            }

            public void onSale() {
                System.out.println("打八折啦!只要$" + price * 0.8);
            }
        }
        new Book(22).onSale();

    }

    public void fruitShop() {
        new Fruit() {
            @Override
            public Fruit sayItsName() {
                System.out.println("我是西瓜");
                return this;
            }

            @Override
            public void tempt() {
                System.out.println("我很好吃哦");
            }
        }.sayItsName().tempt();
    }
}

interface Fruit {
    Fruit sayItsName();
    void tempt();
}