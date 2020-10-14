package homework07;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void addFood(int food) {
        this.food += food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public boolean decreaseFood(int appetite) {
        boolean satiety;
        satiety = (appetite > food) ? false : true;
        if(satiety) {
            food -= appetite;
        }
        return satiety;
    }
}
