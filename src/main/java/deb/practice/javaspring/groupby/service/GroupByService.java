package deb.practice.javaspring.groupby.service;

import deb.practice.javaspring.groupby.model.Movie;
import deb.practice.javaspring.groupby.model.Genre;
import deb.practice.javaspring.groupby.model.Tuple;

import java.util.List;
import java.util.Map;

public interface GroupByService {

    Map<Genre, List<Movie>> simpleGroupBy();
    Map<Tuple, List<Movie>> pairGroupBy();

    Map<Movie.MovieTypeRating, List<Movie>> recordGroupBy();

    Map<Genre, Integer> sumGroupBy();
}
