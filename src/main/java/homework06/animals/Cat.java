package homework06.animals;

import homework06.Animal;

public class Cat extends Animal {

    public Cat() {
        this.nameAnimal = "Кот";
        this.runningLength = 200;
        this.jumpHeight = 2;
        this.swimmingLength = 0;
    }

    @Override
    public void sail(int length) {
        System.out.println("Кот не умеет плавать");
    }
}
