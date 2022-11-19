package deb.practice.javaspring.groupby.model;

public class Movie {
    private String title;
    private Genre type;

    public Movie(String title, Genre type) {
        this.title = title;
        this.type = type;
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
}
