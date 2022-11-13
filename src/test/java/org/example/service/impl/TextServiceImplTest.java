package org.example.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.example.service.TextService;
import org.junit.jupiter.api.Test;

class TextServiceImplTest {
    private final TextService textService = new TextServiceImpl();

    @Test
    void findMostPopularHashtags_validInputData_positive() {
        List<String> list = List.of("#minecraft #brawlstars #clashroyal #java #youtube",
                "#minecraft#minecraft#minecraft #brawlstars#brawlstars #clashroyal #java#java ",
                "#minecraft#minecraft #brawlstars#brawlstars #clashroyal#clashroyal#clashroyal",
                "#minecraft#minecraft#minecraft #brawlstars#brawlstars#brawlstars",
                "#minecraft#minecraft#minecraft#minecraft#minecraft minecraft");

        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("#minecraft", 5);
        expected.put("#brawlstars", 4);
        expected.put("#clashroyal", 3);
        expected.put("#java", 2);
        expected.put("#youtube", 1);

        assertEquals(expected.toString(),
                textService.findMostPopularHashtags(list, 5).toString());
    }

    @Test
    void findMostPopularHashtag_oneHashtag_ok() {
        List<String> list = List.of("#minecraft mincraaaaaaft!! ITS MY LIVE");

        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("#minecraft", 1);

        assertEquals(expected.toString(),
                textService.findMostPopularHashtags(list, 5).toString());
    }

    @Test
    void findMostPopularHashtag_hashtagWithoutLetters_ok() {
        List<String> list = List.of("#");

        Map<String, Integer> expected = Collections.EMPTY_MAP;

        assertEquals(expected.toString(),
                textService.findMostPopularHashtags(list, 5).toString());
    }

    @Test
    void findMostPopularHashtag_lessThenFiveHashtag_ok() {
        List<String> list = List.of("#java #python #pascal",
                "#java",
                "#python#python#java");

        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("#java", 3);
        expected.put("#python", 2);
        expected.put("#pascal", 1);

        assertEquals(expected.toString(),
                textService.findMostPopularHashtags(list, 5).toString());
    }

    @Test
    void findMostPopularHashtag_emptyList_ok() {
        List<String> list = Collections.EMPTY_LIST;
        Map<String, Integer> expected = Collections.EMPTY_MAP;
        assertEquals(expected.toString(),
                textService.findMostPopularHashtags(list, 5).toString());
    }

    @Test
    void findMostPopularHashtag_withoutHashtag_ok() {
        List<String> list = List.of("Java Pascal C++",
                "Java Java",
                "C++ C++");

        Map<String, Integer> expected = Collections.EMPTY_MAP;
        assertEquals(expected.toString(),
                textService.findMostPopularHashtags(list, 5).toString());
    }
}
