package frontend;

import entity.Exercise3.Employee;
import entity.Exercise3.MyArr;


public class programEx3 {
    public static void main(String[] args) {
        String[] name= new String[]{"Khanh", "Lan","Hương"};
    MyArr<String> a = new MyArr<String>(name);

   Double[] doubles = new Double[]{1.0,2.0,3.0,4.0};
    MyArr<Double> b = new MyArr<Double>(doubles);

    //...
        Integer[] ints = new Integer[3];
        ints[0]=4;
        ints[1]=3;
        ints[2]=4;
        Employee employee = new Employee(1,"khanh",ints);

        Float[] floats = new Float[3];
        for(int i=0;i<3;i++)
        {
            floats[i]=(float)i+1;
        }
        Employee employee1 = new Employee(2,"Khang",floats);

        Double[] doubles1 = new Double[3];
        doubles1= new Double[]{1.0, 2.0, 3.0};

        Employee employee2 = new Employee(3,"huy",doubles1);
    }
}
