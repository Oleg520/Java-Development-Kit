package lesson4.hw;
/*
    Табельный номер
    Номер телефона
    Имя
    Стаж
 */
public class Employee {
    private int personalNumber;
    private String phoneNumber;
    private String name;
    private int exp;

    public Employee(int personalNumber, String phoneNumber, String name, int exp) {
        this.personalNumber = personalNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.exp = exp;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExp() {
        return exp;
    }

    @Override
    public String toString() {
        return name + "{" +
                "id: " + personalNumber +
                ", phone: " + phoneNumber +
                ", exp: " + exp + "}";
    }
}
