package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception6 {
    Scanner scanner = new Scanner(System.in);

    public void question1() {
        try {
            float result = divide(7, 0);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Cannot divide 0");
        }

    }

    public float divide(int a, int b) {
        return a / b;
    }

    public void question2() {
        try {
            float result = divide(7, 1);
            System.out.println(result);
            System.out.println("divide completed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("divide completed");
        }
    }

    public void question3() {
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

    }

    public void question4() {
        int[] numbers = {1, 3, 2, 4};
        try {
            System.out.println(getIndex(5, numbers));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Cannot find department.");
        }
    }

    public int getIndex(int i, int[] a) {
        return a[i];
    }

    public int inputAge(int age){
        System.out.println("Nhap age: ");
        try {
            age = scanner.nextInt();
            try{
               checkAge(age);
            }catch (ExceptionAge exceptionAge){
                System.out.println(exceptionAge.getMessage());
            }
        }catch (InputMismatchException e)
        {
            System.out.println(e.getMessage());
            System.out.println("wrong inputing! Please input an age as int, input again");
        }
        return age;
    }

    public void checkAge(int age) throws  ExceptionAge{
        if(age<0)
        {
            throw new ExceptionAge("Wrong inputing! The age must be greater than 0, please input again.");
        }
    }

    public int question6(int age){
        while(true){
            System.out.println("Nhap age: ");

            try {
                age = scanner.nextInt();
                try {
                    checkAge(age);
                }catch (ExceptionAge exceptionAge)
                {
                    System.out.println(exceptionAge.getMessage());
                }            }catch (InputMismatchException a)
            {
                System.out.println(a.getMessage());
                System.out.println("wrong inputing! Please input an age as int, input again");
            }
            return  age;
        }
    }


}
