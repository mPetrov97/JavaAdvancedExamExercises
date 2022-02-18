package cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return this.employees.remove(employee);
            }
        }

        return false;
    }

    public Employee getOldestEmployee() {
        Employee result = new Employee("", 0, "");

        for (Employee employee : this.employees) {
            if (employee.getAge() > result.getAge()) {
                result = employee;
            }
        }

        return result;
    }

    public Employee getEmployee(String name) {

        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }

        return null;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        return String.format("Employees working at Cafe %s:%n%s", this.name, this.employees
                .stream()
                .map(Employee::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
