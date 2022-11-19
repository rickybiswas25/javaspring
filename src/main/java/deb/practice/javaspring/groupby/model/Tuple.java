package deb.practice.javaspring.groupby.model;

import java.util.Objects;

public class Tuple {
    private Genre genre;
    private int rating;

    public Tuple(Genre genre, int rating) {
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return rating == tuple.rating && genre == tuple.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(genre, rating);
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
