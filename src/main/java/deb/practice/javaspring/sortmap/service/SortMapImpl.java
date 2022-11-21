package deb.practice.javaspring.sortmap.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service("sortMapService")
public class SortMapImpl implements SortMap {

    @Override
    public Map<String, Integer> sort(Map<String, String> data) {
        Map<String, Integer> integeredMap = data.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, item -> Integer.parseInt(item.getValue()), (e1, e2) -> e1, HashMap::new));
        System.out.println("Before sorting " + integeredMap);

        return integeredMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
