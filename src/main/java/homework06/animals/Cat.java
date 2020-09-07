package homework06.animals;

import homework06.Animal;

public class Cat extends Animal {

    protected int runningLength = 200;
    protected double jumpHeight = 2;
    protected int swimmingLength = 0;

    @Override
    public void run(int length) {
        if(length > runningLength) {
            System.out.println("Кот не может пробежать более " + runningLength + "м");
        } else {
            System.out.println("Кот бежит " + length + "м");
        }
    }

    @Override
    public void sail(int length) {
        System.out.println("Кот не умеет плавать");
    }

    @Override
    public void jump(double height) {
        if(height > jumpHeight) {
            System.out.println("Кот не может прыгнуть выше " + jumpHeight + "м");
        } else {
            System.out.println("Кот прыгает на высоту " + height + "м");
        }
    }
}
