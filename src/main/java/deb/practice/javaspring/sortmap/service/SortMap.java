package deb.practice.javaspring.sortmap.service;

import java.util.Map;

public interface SortMap {
    Map<String, Integer> sort(Map<String, String> data);
}
