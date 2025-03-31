public class Book {
    private int id;
    private String idBook, title, author;
    private double price;
    private int qty;

    public Book(int id, String idBook, String title, String author, double price, int qty) {
        this.id = id;
        this.idBook = idBook;
        this.title = title;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public int getId() { return id; }
    public String getIdBook() { return idBook; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public int getQty() { return qty; }

    public void setId(int id) { this.id = id; }
    public void setIdBook(String idBook) { this.idBook = idBook; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPrice(double price) { this.price = price; }
    public void setQty(int qty) { this.qty = qty; }
}

