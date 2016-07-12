package Ex5_Inheritance.Problem3_Mankind;

/**
 * Created by Niki on 29.6.2016 г..
 */
public class Worker extends Human {
    private double weekSalary;
    private double workHoursDaily;

    public Worker(String firstName, String lastName, Double weekSalary, Double workHoursDaily) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursDaily(workHoursDaily);
    }

    public double earnByHour(){
        return (weekSalary / 7)  / workHoursDaily;
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary > 10){
            this.weekSalary = weekSalary;
        } else {
            throw new IllegalArgumentException("Expected value mismatch! Argument: weekSalary");
        }
    }

    private void setWorkHoursDaily(double workHoursDaily) {
        if (workHoursDaily < 1 || workHoursDaily > 12){
            throw new IllegalArgumentException("Expected value mismatch! Argument: workHoursPerDay");
        }

        this.workHoursDaily = workHoursDaily;
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public double getWorkHoursDaily() {
        return workHoursDaily;
    }

    @Override
    public void setLastName(String lastName) {
        if (lastName.length() < 4){
            throw new IllegalArgumentException("Expected length more than 3 symbols! Argument: lastName");
        }

        super.setLastName(lastName);
    }
}
