package org.example.service.impl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.example.service.TextService;

public class TextServiceImpl implements TextService {
    private static final String PATTERN_CONSTANT = "(#+[a-zA-Z0-9(_)]{1,})";

    @Override
    public Map<String, Long> findMostPopularHashtags(List<String> lines, Integer number) {
        return findAllHashtags(lines)
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(number)
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    private Map<String, Long> findAllHashtags(List<String> lines) {
        return lines.stream()
                .flatMap(l -> Pattern.compile(PATTERN_CONSTANT)
                        .matcher(l)
                        .results()
                        .map(MatchResult::group)
                        .distinct())
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
    }
}
