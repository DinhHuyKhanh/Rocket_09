package frontend.ex2;

import entity.ex2.Students;

public class program {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Students students = new Students("Nguyen Van A");
        System.out.println(students.getId());
        System.out.println(students.getID() +"\n"+ students.getName() );
    }
}
