package deb.practice.javaspring.groupby.service;

import deb.practice.javaspring.groupby.model.Movie;
import deb.practice.javaspring.groupby.model.Genre;
import deb.practice.javaspring.groupby.model.Tuple;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("groupBy")
public class GroupByServiceImpl implements GroupByService {
    private static final List<Movie> ALL_MOVIES = List.of(
            new Movie("365 Days", Genre.DRAMA, 3),
            new Movie("After", Genre.DRAMA, 2),
            new Movie("2 Hearts", Genre.DRAMA, 2),
            new Movie("The lost city", Genre.ADVENTURE, 4),
            new Movie("Moon fall", Genre.ADVENTURE, 4),
            new Movie("Don't worry darling", Genre.MYSTERY, 3),
            new Movie("The little things", Genre.MYSTERY, 5)
    );

    @Override
    public Map<Genre, List<Movie>> simpleGroupBy() {
        return ALL_MOVIES.stream()
                .collect(Collectors.groupingBy(Movie::getType));
    }

    @Override
    public Map<Tuple, List<Movie>> pairGroupBy() {
        return ALL_MOVIES.stream()
                .collect(Collectors.groupingBy(movie -> new Tuple(movie.getType(), movie.getRating())));
    }

    @Override
    public Map<Movie.MovieTypeRating, List<Movie>> recordGroupBy() {
        return ALL_MOVIES.stream()
                .collect(Collectors.groupingBy(movie -> new Movie.MovieTypeRating(movie.getType(), movie.getRating())));
    }

    @Override
    public Map<Genre, Integer> sumGroupBy() {
        return ALL_MOVIES.stream()
                .collect(Collectors.groupingBy(Movie::getType, Collectors.summingInt(Movie::getRating)));
    }

    @Override
    public Map<Genre, IntSummaryStatistics> summarizeGroupBy() {
        return ALL_MOVIES.stream()
                .collect(Collectors.groupingBy(Movie::getType, Collectors.summarizingInt(Movie::getRating)));
    }
}
