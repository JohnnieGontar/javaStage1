package homework06.animals;

import homework06.Animal;

public class Dog extends Animal {

    protected int runningLength = 500;
    protected double jumpHeight = 0.5;
    protected int swimmingLength = 10;

    @Override
    public void run(int length) {
        if(length > runningLength) {
            System.out.println("Собака не может пробежать более " + runningLength + "м");
        } else {
            System.out.println("Собака бежит " + length + "м");
        }
    }

    @Override
    public void sail(int length) {
        if(length > swimmingLength) {
            System.out.println("Собака не может проплыть дальше " + swimmingLength + "м");
        } else {
            System.out.println("Собака плывёт " + length + "м");
        }
    }

    @Override
    public void jump(double height) {
        if(height > jumpHeight) {
            System.out.println("Собака не может прыгнуть выше " + jumpHeight + "м");
        } else {
            System.out.println("Собака прыгает на высоту " + height + "м");
        }
    }
}
