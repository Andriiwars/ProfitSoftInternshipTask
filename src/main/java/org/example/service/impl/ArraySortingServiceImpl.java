package org.example.service.impl;

import java.util.Arrays;
import java.util.Collections;
import org.example.service.ArraySortingService;

public class ArraySortingServiceImpl implements ArraySortingService {
    @Override
    public Integer[] sortPositiveNumbersByDesc(Integer[] array) {
        return Arrays.stream(array)
                .filter(n -> n >= 0)
                .sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);
    }
}
