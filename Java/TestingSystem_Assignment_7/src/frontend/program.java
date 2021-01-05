package frontend;

import backend.BackendHinhHoc;
import  backend.backendStudent;
import emtity.Exceptionhinhhoc;
import emtity.Student;
import utils.FileManager;

public class program {
    public static void main(String[] args) throws Exceptionhinhhoc {
//        backendStudent a = new backendStudent();
//        a.insert();
//        a.showinf();
//        a.dh();
//        a.showinf();
//        a.question2();
//        System.out.println("Max 5 - 7: " + myMax(5,7));
//        System.out.println("Min 5-7: " + myMin(5,7));
//        System.out.println("Sum 5-7: " + sum(5,7));
//        System.out.println(Student.getCount());
//        a.question6(); // question6 da them dieu kien question7
//        BackendHinhHoc bkhh = new BackendHinhHoc();
//        bkhh.nhapHinhHoc();
//        bkhh.tinhChuViHinhChuNhat();
//        bkhh.tinhDienTichHinhChuNhat();
//        bkhh.tinhChuViHinhTron();
//        bkhh.tinhDienTichHinhTron();
        FileManager fileManager = new FileManager();
//        fileManager.checkfile();
//        fileManager.createNewFile("C:\\Users\\DINH HUY KHANH\\Desktop\\Test.txt");
//        fileManager.deleteFile("C:\\Users\\DINH HUY KHANH\\Desktop\\Test.txt");
//        System.out.println((fileManager.isFolder("E:\\data mySQL\\thuc hanh\\sales.sql")==true)?"is Folder":"is File");

    }

        static int myMax(int a, int b) {
            return (a > b) ? a : b;
        }


        static int myMin(int a, int b){
        return (a>b)?b:a;
        }


        static int sum(int a, int b)
        {
            return a+b;
        }

}
