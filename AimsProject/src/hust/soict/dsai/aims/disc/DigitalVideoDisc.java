package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0;
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public String getTitle() {
        return title;
    }
    
    public String getCategory() {
        return category;
    }
   
    public String getDirector() {
        return director;
    }
    
    public int getLength() {
        return length;
    }
   
    public float getCost() {
        return cost;
    }

    // Constructor with only title
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
        nbDigitalVideoDiscs++;  
        this.id = getNbDigitalVideoDiscs();
    }

    // Constructor with category, title, and cost
    public DigitalVideoDisc(String title, String category,  float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;  
        this.id = getNbDigitalVideoDiscs();
    }

    // Constructor with director, category, title, and cost
    public DigitalVideoDisc(String title, String category,String director, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;  
        this.id = getNbDigitalVideoDiscs();
    }

    // Constructor with director, category, title, length, and cost
    public DigitalVideoDisc(String title, String category ,String director, int length, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.length = length;
        nbDigitalVideoDiscs++;  
        this.id = getNbDigitalVideoDiscs();
    }
    
    
    // vì nbDigitalVideoDiscs và là private nên để có thể trích xuất giá trị thì phải tạo một getter cho nó
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
    public int getId() {
        return id;  // Trả về id của DVD
    }    
}