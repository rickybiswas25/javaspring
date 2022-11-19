package deb.practice.javaspring.groupby.model;

public class Movie {
    private String title;
    private Genre type;
    private int rating;
    public record MovieTypeRating(Genre type, int rating) {}

    public Movie(String title, Genre type, int rating) {
        this.title = title;
        this.type = type;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getType() {
        return type;
    }

    public void setType(Genre type) {
        this.type = type;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
