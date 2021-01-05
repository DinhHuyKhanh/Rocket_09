package emtity;

import java.util.Scanner;

public class HinhChuNhat extends hinhhoc {
    private float dai;
    private float rong;
    Scanner  scanner = new Scanner(System.in);

    public HinhChuNhat(float dai, float rong) {
        this.dai = dai;
        this.rong = rong;
    }

    @Override
    public void chuvi() {

        System.out.println("Nhập chiều dài , chiều rộng:  ");
        dai = scanner.nextFloat();
        rong= scanner.nextFloat();
        System.out.println("Chu vi hình chữ nhật có dài = "+dai+" và rộng =" +rong +" là: "+(float)((dai+rong)*2));
    }

    @Override
    public void dientich() {
        System.out.println("Nhập chiều dài , chiều rộng:  ");
        dai = scanner.nextFloat();
        rong= scanner.nextFloat();
        System.out.println("Diện tích hình chữ nhật có dài = "+dai+" và rộng =" +rong +" là: "+(float)(dai*rong));
    }

    public float getDai() {
        return dai;
    }

    public void setDai(float dai) {
        this.dai = dai;
    }

    public float getRong() {
        return rong;
    }

    public void setRong(float rong) {
        this.rong = rong;
    }
}
