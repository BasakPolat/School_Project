package day12_practice_OkulProje_Advance_oop;

public class Student extends Person{//const control edilecek

    private String studentNumber;
    private String class1;

    public Student(String nameLastName, String identificationNo, int age, String studentNumber, String class1) {

        super(nameLastName, identificationNo, age);
        this.studentNumber = studentNumber;
        this.class1 = class1;
    }


    public Student() {


    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }


    @Override
    public String toString() {
        return "Ogrenci{" +
                "studentNumber='" + studentNumber + '\'' +
                ", class1='" + class1 + '\'' +
                '}'+ super.toString();
    }
}
