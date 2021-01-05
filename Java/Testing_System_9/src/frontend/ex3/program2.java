package frontend.ex3;

import entity.ex3.Car;

public class program2 {
    public static void main(String[] args) {
            Car car = new Car("Mazda","8WD");
            Car.Engine engine = car.new Engine("Crysler");
        System.out.println(car.getName());
        System.out.println(car.getType());
        System.out.println(engine);


    }
}
