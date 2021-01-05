package frontend.ex3;

import entity.ex3.CPU;

public class program1 {
    public static void main(String[] args) {
        CPU cpu = new CPU();

        CPU.Processor a = cpu.new Processor();
        System.out.println(a.getCache());

        CPU.Ram b = cpu.new Ram();
        System.out.println(b.getClockSpeed());
    }
}
