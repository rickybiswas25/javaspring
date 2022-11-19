package deb.practice.javaspring.groupby.service;

import deb.practice.javaspring.groupby.model.Movie;
import deb.practice.javaspring.groupby.model.Genre;

import java.util.List;
import java.util.Map;

public interface GroupByService {

    Map<Genre, List<Movie>> simpleGroupBy();
}