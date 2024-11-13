package lesson4.hw;

import java.util.ArrayList;
import java.util.List;

/**
 * Добавить метод, который ищет сотрудника по стажу (может быть список)
 *  Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
 *  Добавить метод, который ищет сотрудника по табельному номеру
 *  Добавить метод добавления нового сотрудника в справочник
 */
public class EmployeesList {
    List<Employee> workers;

    public EmployeesList(){
        workers = new ArrayList<>();
    }

    public List<Employee> getWorkerByExp(int exp){
        List<Employee> workers = new ArrayList<>();
        for (Employee worker : this.workers) {
            if (worker.getExp() == exp){
                workers.add(worker);
            }
        }
        if (workers.isEmpty()) {
            System.out.println("Not found");
            return null;
        }
        return workers;
    }

    public List<String> getPhoneByName(String name){
        List<String> phones = new ArrayList<>();
        for (Employee worker : workers) {
            if (worker.getName().equals(name)){
                phones.add(worker.getPhoneNumber());
            }
        }
        if (phones.isEmpty()) {
            System.out.println("Not found");
            return null;
        }
        return phones;
    }

    public Employee getByPersonalNumber(int number){
        Employee employee = null;
        for (Employee worker : workers) {
            if (worker.getPersonalNumber() == number){
                employee = worker;
            }
        }
        if (employee==null) {
            System.out.println("Not found");
            return null;
        }
        return employee;
    }

    public boolean add(int personalNumber, String phoneNumber, String name, int exp){
        try {
            workers.add(new Employee(personalNumber,phoneNumber, name, exp));
            return true;
        } catch (Exception e) {
            System.out.println("Invalid data");
            return false;
        }
    }

    @Override
    public String toString() {
        return workers.toString();
    }
}
