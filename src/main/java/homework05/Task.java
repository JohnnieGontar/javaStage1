package homework05;

public class Task {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Оболенский Сократ Ипполитович", "Картограф", "njmcho078@namyn.com", "79057571475", 30000, 25);
        employees[1] = new Employee("Коромыслов Степан Евграфович", "Плотник", "tracy40@gmail.com", "79657453489", 35000, 30);
        employees[2] = new Employee("Кураев Иосиф Егорович", "Кровельщик", "ywarner@gmail.com", "79036217362", 40000, 35);
        employees[3] = new Employee("Сиянин Михаил Самуилович", "Техник по эксплуатации", "bblack@yahoo.com", "79633985711", 45000, 45);
        employees[4] = new Employee("Борхес Адам Григориевич", "Изобретатель", "kathryn66@gmail.com", "79618774273", 50000, 50);

        for (Employee employee : employees) {
            if(employee.getAge() > 40) {
                employee.getInfo();
                System.out.println("=========================\n");
            }
        }
    }

}
