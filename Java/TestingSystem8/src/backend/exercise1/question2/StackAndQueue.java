package backend.exercise1.question2;

import entity.Student;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StackAndQueue {


    Deque<Student> studentQueue = new LinkedList<Student>();
    Stack<Student> studentStack =  new Stack<Student>();

    public void insert(){
        studentStack.push(new Student("Nguyễn Văn Nam"));
        studentStack.push(new Student("Nguyễn Văn Huyên"));
        studentStack.push(new Student("Trần Văn Nam"));
        studentStack.push(new Student("Nguyễn Văn A"));

        studentQueue.addFirst(new Student("Nguyễn Văn Nam"));
        studentQueue.addFirst(new Student("Nguyễn Văn Huyên"));
        studentQueue.addFirst(new Student("Trần Văn Nam"));
        studentQueue.addFirst(new Student("Nguyễn Văn A"));
    }

    public void sentenceA(){
        System.out.println(" Thứ tự tới sớm nhất đến muộn nhất! ");
        for(Student x: studentStack)
        {
            System.out.println(x.getName());
        }
    }
    public void sentenceB() {
        System.out.println("Thứ tự tới từ muộn nhất đến sớm nhất");
        for (Student x: studentQueue ) {
            System.out.println(x.getName());
        }
    }

}
