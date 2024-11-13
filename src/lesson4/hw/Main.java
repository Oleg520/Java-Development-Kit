package lesson4.hw;

public class Main {
    public static void main(String[] args) {
        EmployeesList workers = new EmployeesList();
        workers.add(1, "89112342212", "Oleg", 12);
        workers.add(2, "89236445322", "Egor", 2);
        workers.add(3, "89055556121", "Kostya", 10);
        workers.add(4, "89031234567", "Nastya", 5);
        workers.add(5, "89553254341", "Egor", 2);
//        System.out.println(workers);
        System.out.println(workers.getWorkerByExp(2));
        System.out.println(workers.getByPersonalNumber(3));
        System.out.println(workers.getPhoneByName("Egor"));
    }
}
