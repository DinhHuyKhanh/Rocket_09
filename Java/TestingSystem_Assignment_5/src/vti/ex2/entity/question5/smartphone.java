package vti.ex2.entity.question5;

public class smartphone extends  dienthoai implements  ITuve {

    @Override
    public void tancongkexau() {
        System.out.println(" Cuộc gọi khẩn cấp đến 113 từ smartphone!!! ");
    }
    public void sudung3G(){
        System.out.println("Sử dụng 3G xem youtube đã quá !!! ");
    }
    public void chuphinh(){
        System.out.println("Chụp hình nét quá !!!");
    }

    @Override
    public  void nghe() {
        super.nghe();
    }

    @Override
    public void goidienthoai() {
        super.goidienthoai();
    }

    @Override
    public void guitinnhan() {
        super.guitinnhan();
    }

    @Override
    public void nhantinnhan() {
        super.nhantinnhan();
    }
}
