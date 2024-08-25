import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * asList()是浅拷贝
 * toArray()是深拷贝
 */
public class TestAsList {
    @Test
    public void testAsList() {
        Integer[] a = new Integer[3];
        List<Integer> list = Arrays.asList(a);
        System.out.println(list);
        a[0] = 1;
        System.out.println(list);
    }

    @Test
    public void testToArray() {
        ArrayList<Dog> list = new ArrayList<>();
        Dog dog1 = new Dog("小黄");
        Dog dog2 = new Dog("小白");
        Dog dog3 = new Dog("小绿");
        list.add(dog1);
        list.add(dog2);
        list.add(dog3);
        Object[] array = list.toArray(new Object[0]);
        System.out.println(Arrays.toString(array));
        list.set(0, new Dog("卢本伟"));
        System.out.println(Arrays.toString(array));
    }
}
class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}

