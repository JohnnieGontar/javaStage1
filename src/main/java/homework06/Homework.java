package homework06;

import homework06.animals.Cat;
import homework06.animals.Dog;
import homework06.dogs.Corgi;
import homework06.dogs.Doberman;

public class Homework {

    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();
        Animal doberman = new Doberman();
        Animal corgi = new Corgi();

        cat.run(150);
        cat.sail(5);
        cat.jump(1.5);

        dog.run(450);
        dog.sail(5);
        dog.jump(1.5);

        doberman.run(550);
        corgi.run(450);
    }

}
