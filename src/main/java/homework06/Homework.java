package homework06;

import homework06.animals.Cat;
import homework06.animals.Dog;

public class Homework {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();

        cat.run(100);
        cat.sail(5);
        cat.jump(1.5);

        dog.run(450);
        dog.sail(5);
        dog.jump(1.5);
    }
}
