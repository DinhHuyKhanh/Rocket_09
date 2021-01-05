package emtity;

public class Student {
    private int id;
    private String name;
    private static String college ="Đại học bách khoa";
    private static int moneyGroup;
    private static int count;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.moneyGroup += 100;
        count+=1;
    }

    public Student(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getCollege() {
        return college;
    }

    public static void setCollege(String college) {
        Student.college = college;
    }

    public static int getMoneyGroup() {
        return moneyGroup;
    }

    public static void setMoneyGroup(int moneyGroup) {
        Student.moneyGroup = moneyGroup;
    }

    public static int getCount() {
        return count;
    }
}
