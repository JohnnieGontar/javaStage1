package homework07;

public class Cat {

    private final String name;
    private final int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void getSatiety() {
        System.out.println("Кот " + name + ": сытость: " + satiety);
    }

    public void eat(Plate plate) {
        satiety = plate.decreaseFood(appetite);
    }

}
