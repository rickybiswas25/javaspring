package deb.practice.javaspring.sortmap.controller;

import deb.practice.javaspring.groupby.model.Genre;
import deb.practice.javaspring.groupby.model.Movie;
import deb.practice.javaspring.groupby.model.Tuple;
import deb.practice.javaspring.groupby.service.GroupByService;
import deb.practice.javaspring.sortmap.service.SortMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sortmap")
public class SortMapController {

    private final SortMap service;

    @Autowired
    public SortMapController(@Qualifier("sortMapService") SortMap service) {
        this.service = service;
    }

    @GetMapping("/sort")
    public Map<String, Integer> sort(@RequestParam Map<String, String> data) {
        return this.service.sort(data);
    }
}
