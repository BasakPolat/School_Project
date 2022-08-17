package day12_practice_OkulProje_Advance_oop;

//import day33_Encapsulation.Ogretmen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Actions {

    //2
    static List<Person> tchrList = new ArrayList<>();//static tanımlıyorum her yerden ulasmak icin
    static List<Person> stdntList = new ArrayList<>();//person da tutuyorum cunku genel bilgilerim kisi classında, kisi tipindekileri alıyor childen dan da alıyor hepsini kiside dönderiyor.
    static Scanner scan = new Scanner(System.in);//her methodda obje üretmemek icin burada static bir obje ürettik.
    static String persontype;
    //static yazmamizin sebebi tum methodlardan ulasmak icin, gokteki ay gibi her yerden ulasilabilsin
    //neden kisi listinde tutuyoruz, cunku benim genel class ım kisi classı, tepede bunları ben kisi tipinde tutuyorum,
    //kisi tipindeki fieldleri alıyor, childenda fieldleri alıyor ve bana list dönüyor.

    //1
    public static void loginPanel() {//1- giris methodu
        System.out.println("-----WELCOME-----");
        System.out.println("STUDENT AND TEACHER PANEL");
        System.out.println("====================================");
        System.out.println("1- STUDENT TRANSACTIONS");
        System.out.println("2- TEACHER OPERATIONS");
        System.out.println("Q-OUT");

        String choice = scan.next().toUpperCase();//kullanici kucuk harf girse bile buyuk harfe cevirdik,
        //cunku kontrolu buyuk harf ile yapacagız.
        switch (choice) {
            case "1":
                persontype = "STUDENT";
               operationMenu();

                break;
            case "2":

                persontype = "TEACHER";
                operationMenu();

                break;
            case "Q":
                break;

            default:
                System.out.println("incorrect entry");
                loginPanel();//giris panelini burada call ettik.
                break;
        }


    }

    private static void operationMenu() {
        System.out.println("person type you selected " + persontype + " please select the following actions");


        System.out.println("=====OPERATIONS=====\n" +
                " 1-ADD\n" +
                " 2_SEARCH\n" +
                " 3-LISTING\n" +
                " 4-DELETE\n" +
                " 5_MAIN MENU\n" +
                " 0-OUT");


        System.out.println("Enter the transaction preference");
        int selectedTransactions = scan.nextInt();
        switch (selectedTransactions) {


            case 1:
                add(); //eklemethodu bittikten sonra tekrar bir method daha calıssın //asagıda yaptık
                operationMenu();//islem methodu calissin //method call ile islem menusune tekrar gidiyor
                break;
                //yapıldı
            case 2:
                search();
                operationMenu();
                break;
                //yapıldı
            case 3:
                listing();
                operationMenu();
                break;
                //yapıldı
            case 4:
                delete();
                operationMenu();
                break;
                //yapildi
            case 5:
                //main menu
                loginPanel();
                break;

            case 0:
                out();
                break;
            default:
                System.out.println("enter the correct selection");
                operationMenu();
                break;
        }

    }

    private static void out() {
        System.out.println("We are waiting for you again\n***Goodbye***");

    }

    private static void delete() {
        System.out.println("*****" + persontype + "*****" + "\nwelcome to the listing page");
        boolean flag=true;//bayrak havada aksiyon basla

        if (persontype.equalsIgnoreCase("STUDENT")){
            System.out.println("Enter the ID number you want to delete.");

            String deletedIDNo=scan.next().replaceAll(" ","");
            for (Person each: stdntList) {
                if (each.getIdentificationNo().equals(deletedIDNo)){
                    System.out.println("deleted student " +each.getNameLastName());
                    stdntList.remove(each); //o ogrenciyi siler
                    flag=false;
                    break;
                }

            }if (flag) {//flag true ise hala bu if body si calisir. yani aranan tc ile öğrenci yok demektir.
                System.out.println("The student registered in the ID number searched could not be found.");
            }
        }else {//ogretmen islemleri icin kontrol.
            System.out.println("Enter the ID number of the teacher to be deleted.");
            String deletedIDNo = scan.next().replaceAll(" ", "");

            for (Person each:tchrList) {
                if (each.getIdentificationNo().equalsIgnoreCase(deletedIDNo)){
                    System.out.println("deleted teacher " +each.getNameLastName());
                    tchrList.remove(each);
                    flag = false;
                    break;
                }

            }if (flag){//kullanicinin girdigi T.C kimlik no hic bir ogretmene eslesmedi demek.
                System.out.println("The teacher registered with this ID number could not be found.");

            }

        }



    }

    private static void listing() {
        System.out.println("*****" + persontype + "*****" + "\nwelcome to the listing page");
        if (persontype.equalsIgnoreCase("STUDENT")) {
            System.out.println("stdntList "+stdntList);

        }else{
            for(Person each:tchrList){
                System.out.println("each.toString()= "+each.toString());
            }
        }



    }

    private static void search() {
        System.out.println("*****" + persontype + "*****" + "\nwelcome to the search page");
        boolean flag = true; //bayrak yukarıda true olan her sart devam eder.
        if (persontype.equalsIgnoreCase("STUDENT")) {//bu satırda ogrenci arıyorsa calisir.
            //dummy
            System.out.println("Enter ID no");
            String callingIDNo = scan.next().replaceAll(" ", "");

            for (Person s : stdntList) {
                if (s.getIdentificationNo().equals(callingIDNo)) {//kullanicinin girdigi T.C ile ogrenci listindeki TC lerden eslesen var mi
                    System.out.println("the student you are looking for " + s.getNameLastName());
                    flag = false; //buradan cikmak icin bayragı yere indirdik.
                    break;

                }

            }
            if (flag) {//flag true ise hala bu if body si calisir. yani aranan tc ile öğrenci yok demektir.
                System.out.println("The student registered in the ID number searched could not be found.");

            }//114 ten 122 ye kadar öğrenci islemleri.

        } else {//ogretmen icin calisacak.

            System.out.println("enter ID no");
            String callingIDNo = scan.next().replaceAll(" ", "");
            for (Person t : tchrList) {
                if (t.getIdentificationNo().equals(callingIDNo)) {//kullanicinin girdigi T.C ile ogrenci listindeki TC lerden eslesen var mi
                    System.out.println("the student you are looking for " + t.getNameLastName());
                    flag = false; //buradan cikmak icin bayragı yere indirdik.
                    break;

                }

            }
            if (flag) {
                System.out.println("The student registered in the ID number searched could not be found.");
            }//else bodysi komple ögretmen icin tasarlandi.


        }
    }


        private static void add () {//bu method hem ogrenci hem de ogretmen eklemek icin tasarlandi


            System.out.println("*****" + persontype + "*****" + "\nwelcome to the add page");

            System.out.println("enter  name and lastname");
            String nameLastName = scan.nextLine();
            scan.nextLine();

            System.out.println("enter IDNo");
            String identificationNo = scan.nextLine();

            System.out.println("enter age ");
            int age = scan.nextInt();

            if (persontype.equals(("STUDENT"))) { //TODO Sonra doldur
                System.out.println("Enter Student number");
                String studentNo=scan.next().replaceAll(" ", "");

                System.out.println("enter class");
                String stClass=scan.next().replaceAll(" ", "");

                Student student=new Student(nameLastName,identificationNo, age,studentNo,stClass);
                stdntList.add(student);




            } else {//Burasi öğretmen icin, tekrar öğretmen dememize gerek yok cunku zaten iki secenegi var.
                scan.nextLine();//dummy kod hata almamak icin
                System.out.println("enter depertment ");
                String depertment = scan.nextLine();
                System.out.println("enter registration no");
                String registrationNo = scan.nextLine();

                Teacher teacher = new Teacher(nameLastName, identificationNo, age, depertment, registrationNo);
                tchrList.add(teacher);
                System.out.println(tchrList);


            }


        }

    }




