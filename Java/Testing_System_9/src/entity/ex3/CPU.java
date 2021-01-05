package entity.ex3;

public class CPU {
    private int price;
    private Processor processor;
    private Ram ram;


    public class Processor{
        private Float coreAmount;
        private String menufacturer;

        public float getCache(){
            return (float)4.3;
        }

    }

    public class Ram {
        private float memory;
        private String menufacturer;

        public float getClockSpeed()
        {
            return (float)5.5;
        }
    }
}
