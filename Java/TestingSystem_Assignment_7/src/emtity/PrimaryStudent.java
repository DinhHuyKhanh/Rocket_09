package emtity;

public class PrimaryStudent extends  Student{
    private static int count;

    public PrimaryStudent(int id, String name) {
        super(id, name);
        count++;
    }

    public PrimaryStudent() {
    }

    public static int getCount() {
        return count;
    }
}
