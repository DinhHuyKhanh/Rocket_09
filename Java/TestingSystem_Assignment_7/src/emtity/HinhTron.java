package emtity;

import java.util.Scanner;

public class HinhTron extends hinhhoc{
    Scanner scanner = new Scanner(System.in);
    private static final float pi = (float) 3.14159265;
    private float bankinh;

    public HinhTron(float bankinh) {
        this.bankinh = bankinh;
    }

    @Override
    public void chuvi() {
        System.out.println("Nhập bán kính: ");
        bankinh = scanner.nextFloat();
        System.out.println("Chu vi hình tròn bán kính bằng "+bankinh+" là: "+(float)(2*bankinh*pi));
    }

    @Override
    public void dientich() {
        System.out.println("Nhập bán kính: ");
        bankinh = scanner.nextFloat();
        System.out.println(" Diện tích hình tròn bán kính bằng "+bankinh+" là: "+(float)(bankinh*bankinh*pi));
    }
}
