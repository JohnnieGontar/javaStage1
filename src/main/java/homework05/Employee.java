package homework05;

public class Employee {

    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;


    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    Employee() {
        this.name = "test";
        this.position = "test";
        this.email = "test";
        this.phone = "test";
        this.salary = 35000;
        this.age = 30;
    }

    public void getInfo() {
        System.out.printf("\nФИО: %s;\n" +
                         "Должность: %s;\n" +
                         "email: %s;\n" +
                         "телефон: %s;\n" +
                         "зарплата: %d;\n" +
                         "возраст: %d;\n",
                this.name, this.position, this.email, this.phone, this.salary, this.age);
    }

}
