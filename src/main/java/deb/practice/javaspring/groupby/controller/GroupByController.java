package deb.practice.javaspring.groupby.controller;

import deb.practice.javaspring.groupby.model.Movie;
import deb.practice.javaspring.groupby.model.Genre;
import deb.practice.javaspring.groupby.service.GroupByService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/groupBy")
public class GroupByController {

    private final GroupByService service;

    public GroupByController(@Qualifier("groupBy") GroupByService service) {
        this.service = service;
    }

    @GetMapping("/simpleGrouping")
    public Map<Genre, List<Movie>> simpleGrouping() {
        return this.service.simpleGroupBy();
    }
}
