package backend;

public class SystemOutPrintf {
    public void question1()
    {
        int a=5;
        System.out.printf("%d",a);
    }

    public void question2()
    {
        int a=100000000;
        System.out.printf("%,d",a);
    }
    public void question3(){
        float a = (float) 5.567098;
        System.out.printf("%,4f",a);
    }
    public void question4(){
        String name= "Nguyễn Văn A";
        String tinhtrang = "độc thân";
        System.out.printf("Họ và tên: %s %nTôi đang %s",name,tinhtrang);
    }
    public void question5(){
        String s="24/04/2020 11h:16p:20s";
        System.out.printf("%s",s);
    }
    public void question6(){
        String s;
        System.out.println("Vì khác project nên không hỗ trợ !!! ");
    }
}

