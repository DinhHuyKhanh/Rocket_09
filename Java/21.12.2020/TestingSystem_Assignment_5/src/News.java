public class News implements INews{
//    ID (int), Title (String), PublishDate (String), Author (String),
//    Content (String) và AverageRate (float).
    private  int ID;
    private String Title;
    private String PublishDate,Author,Content;
    private float AverageRate;


    public News(int ID, String Title, String PublishDate,String Author,String Content){
        this.ID = ID;
        this.Title = Title;
        this.PublishDate = PublishDate;
        this.Author = Author;
        this.Content = Content;
    }
    public int getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public String getPublishDate() {
        return PublishDate;
    }

    public String getAuthor() {
        return Author;
    }

    public String getContent() {
        return Content;
    }

    public float getAverageRate() {
        return AverageRate;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setPublishDate(String publishDate) {
        PublishDate = publishDate;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", PublishDate='" + PublishDate + '\'' +
                ", Author='" + Author + '\'' +
                ", Content='" + Content + '\'' +
                ", AverageRate=" + AverageRate +
                '}';
    }

    @Override
    public void Display() {
        System.out.println(getTitle()+"\n"+getPublishDate()+"\n"+getAuthor()+"\n"+getContent()+"\n"+getAverageRate());
    }

    @Override
    public float Calculate(int arr[]) {
        int[] Rates = new int[3];
        return (Rates[0]+Rates[1]+Rates[2])/3;
    }


}
