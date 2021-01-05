package emtity;

public class SecondaryStudent  extends  Student{
    private static int count;

    public SecondaryStudent() {
    }

    public SecondaryStudent(int id, String name) {
        super(id, name);
        count++;
    }

    public static int getCount() {
        return count;
    }
}

