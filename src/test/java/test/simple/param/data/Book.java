package test.simple.param.data;

public class Book {
    private String title;
    // standard getter setters

    public Book(String t) {
        this.title = t;
    }

    @Override
    public String toString() {
        return title;
    }

    public String getTitle() {
        return title;
    }
}