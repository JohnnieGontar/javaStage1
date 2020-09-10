package homework07;

public class MainClass {

    public static void main(String[] args) {

        Plate plate = new Plate(35);

        Cat[] cats = {
            new Cat("Barsik", 5),
            new Cat("Timoha", 8),
            new Cat("Vasiliy", 12),
            new Cat("Thomas", 15),
        };

        for (Cat cat : cats) {
            cat.eat(plate);
            cat.getSatiety();
        }

        plate.addFood(5);

        Cat lastCat = cats[cats.length - 1];
        lastCat.eat(plate);
        lastCat.getSatiety();
    }

}
