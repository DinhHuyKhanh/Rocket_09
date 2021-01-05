package entity.ex2;

public class Students {
    private int id;
    private static int count;
    private String name;


    public Students(String name){
        this.name = name;
        id =++count;
    }
    /**
     * @deprecated replaced by {@link #getID()}
     */
    public int getId() {
        return id;
    }

    public String getID(){
        return "MSV:" +id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Students.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
