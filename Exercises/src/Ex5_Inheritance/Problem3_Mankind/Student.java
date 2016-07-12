package Ex5_Inheritance.Problem3_Mankind;

/**
 * Created by Niki on 29.6.2016 г..
 */
public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10){
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        for (int i = 0; i < facultyNumber.length(); i++) {
            if (!Character.isDigit(facultyNumber.charAt(i)) &&
                    !Character.isLetter(facultyNumber.charAt(i))){
                throw new IllegalArgumentException("Invalid faculty number!");
            }
        }


        this.facultyNumber = facultyNumber;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }
}
