package day12_practice_OkulProje_Advance_oop;

public class Person {


    private String nameLastName;
    private String identificationNo;
    private int age; //herkesin ortak özellikleri
    //getter setter icin önce private yapıyorduk


    public Person(String nameLastName, String identificationNo, int age) {
        this.nameLastName = nameLastName;
        this.identificationNo = identificationNo;
        this.age = age;
    }

    public Person(){

}

    public void setNameLastName(String nameLastName) {
        this.nameLastName = nameLastName;
    }

    public void setIdentificationNo(String identificationNo) {
        this.identificationNo = identificationNo;
    }

    public void setAge(int age) {//yas kontrolu yapiniz
        this.age = age;
    }

    public String getNameLastName() {
        return nameLastName;
    }

    public String getIdentificationNo() {
        return identificationNo;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nameLastName='" + nameLastName + '\'' +
                ", identificationNo='" + identificationNo + '\'' +
                ", age=" + age +
                '}';
    }
}
