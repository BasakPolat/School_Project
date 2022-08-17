package day12_practice_OkulProje_Advance_oop;

public class Teacher extends Person{


    private String department;
    private String registrationNo;//sicil no

    public Teacher() {

    }

    public Teacher(String nameLastName, String identificationNo, int age, String department, String registrationNo) {
        super(nameLastName, identificationNo, age);
        this.department = department;
        this.registrationNo = registrationNo;
    }

    public String getDepartment() {

        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String  registrationNo) {
        this.registrationNo = registrationNo;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "department='" + department + '\'' +
                ", registrationNo=" + registrationNo +
                '}'+super.toString();
    }
}

