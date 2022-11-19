package deb.practice.javaspring.groupby.service;

import deb.practice.javaspring.groupby.model.Movie;
import deb.practice.javaspring.groupby.model.Genre;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("groupBy")
public class GroupByServiceImpl implements GroupByService {
    private static final List<Movie> ALL_MOVIES = List.of(
            new Movie("365 Days", Genre.DRAMA),
            new Movie("After", Genre.DRAMA),
            new Movie("2 Hearts", Genre.DRAMA),
            new Movie("The lost city", Genre.ADVENTURE),
            new Movie("Moon fall", Genre.ADVENTURE),
            new Movie("Don't worry darling", Genre.MYSTERY),
            new Movie("The little things", Genre.MYSTERY)
    );

    @Override
    public Map<Genre, List<Movie>> simpleGroupBy() {
        return ALL_MOVIES.stream()
                .collect(Collectors.groupingBy(Movie::getType));
    }
}
