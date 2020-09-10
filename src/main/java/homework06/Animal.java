package homework06;

public abstract class Animal {

    protected String nameAnimal;
    protected int runningLength;
    protected double jumpHeight;
    protected int swimmingLength;

    public Animal() {
        this.nameAnimal = "";
        this.runningLength = 0;
        this.jumpHeight = 0;
        this.swimmingLength = 0;
    }

    public void run(int length) {
        if(length > runningLength) {
            System.out.println(nameAnimal + " не может пробежать более " + runningLength + "м");
        } else {
            System.out.println(nameAnimal + " бежит " + length + "м");
        }
    }

    public void jump(double height) {
        if(height > jumpHeight) {
            System.out.println(nameAnimal + " не может прыгнуть выше " + jumpHeight + "м");
        } else {
            System.out.println(nameAnimal + " прыгает на высоту " + height + "м");
        }
    }

    public void sail(int length) {
        if(length > swimmingLength) {
            System.out.println(nameAnimal + " не может проплыть дальше " + swimmingLength + "м");
        } else {
            System.out.println(nameAnimal + " плывёт " + length + "м");
        }
    }

}
