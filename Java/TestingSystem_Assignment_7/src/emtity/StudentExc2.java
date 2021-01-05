package emtity;

public class StudentExc2 {
        private final  static  int id = 1;
        private String name;

        public StudentExc2(String name) {
            this.name = name;
        }
        public StudentExc2() {

        }


        public int getId() {
            return id;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public final void study()
        {
        System.out.println("Đang học bài ....!");
        }

}
