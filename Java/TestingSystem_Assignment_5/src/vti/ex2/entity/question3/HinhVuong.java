package vti.ex2.entity.question3;

public class HinhVuong extends  hinhchunhat {
    public void  tinhchuvi(float dai, float rong){
        if(dai==rong)
        {
        System.out.println("Tính chu vi theo hình vuông");
        super.tinhchuvi(dai,rong);
        }
        else{
            System.out.println("Tính chu vi theo hình chữ nhật");
            super.tinhchuvi(dai,rong);
        }
    }

    public void tinhdientich(float dai, float rong){
        if(dai==rong)
        {
            System.out.println("Tính dientich theo hình vuông");
            super.tinhdientich(dai,rong);
        }
        else{
            System.out.println("Tính diện tích theo hình chữ nhật");
            super.tinhdientich(dai,rong);
        }

    }



}
