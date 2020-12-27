package backend;

public class BoxingAndUnboxing {
    public void question1(){
        Integer a = 5000;
        float x = a.floatValue();
        System.out.printf("%.2f",x);
    }
    public  void question2(){
        String s= "1234567";
        int a =  Integer.parseInt(s);
        System.out.println("\n"+a);
    }
    public void question3(){
        Integer a = 1234567;
        int x = a.intValue();
        System.out.println(x);
    }

}
