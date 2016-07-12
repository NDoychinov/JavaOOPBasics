package Models;

/**
 * Created by Niki on 9.7.2016 г..
 */
public abstract class Man {
    private double salary;

    protected Man(double salary) {
        this.setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }
}
