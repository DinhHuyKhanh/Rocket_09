package vti.ex2.frontend;
import vti.ex2.entity.question5.*;


public class program5 {
    public static void main(String[] args) {
        smartphone smp = new smartphone();
        classic cls = new classic();
        System.out.println("-------------------------------------------");
        System.out.println(" tinh nang smartphone" );
        smp.nghe();
        smp.goidienthoai();
        smp.guitinnhan();
        smp.nhantinnhan();
        smp.chuphinh();
        smp.sudung3G();
        smp.tancongkexau();
        System.out.println("-------------------------------------------");

        System.out.println(" Classic");
        cls.nghe();
        cls.goidienthoai();
        cls.guitinnhan();
        cls.nhantinnhan();
        cls.ngheradio();
        cls.tancongkexau();
        System.out.println("-------------------------------------------");

    }
}
