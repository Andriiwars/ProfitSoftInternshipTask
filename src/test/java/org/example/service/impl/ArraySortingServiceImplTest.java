package org.example.service.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.example.service.ArraySortingService;
import org.junit.jupiter.api.Test;

class ArraySortingServiceImplTest {
    private final ArraySortingService arraySortingService = new ArraySortingServiceImpl();

    @Test
    void sortPositiveNumbersByDesc_negativeArray_ok() {
        Integer array[] = {-1, -2, -3, -4, -5, -6};
        Integer expected[] = {};
        assertArrayEquals(expected, arraySortingService.sortPositiveNumbersByDesc(array));
    }

    @Test
    void sortPositiveNumbersByDesc_positiveArray_ok() {
        Integer array[] = {5, 4, 3, 3, 3};
        Integer expected[] = {5, 4, 3, 3, 3};
        assertArrayEquals(expected, arraySortingService.sortPositiveNumbersByDesc(array));
    }

    @Test
    void sortPositiveNumbersByDesc_validInputData_ok() {
        Integer array[] = {1, 2, -3, 4, -6, 6, 6};
        Integer expected[] = {6, 6, 4, 2, 1};
        assertArrayEquals(expected, arraySortingService.sortPositiveNumbersByDesc(array));
    }

    @Test
    void sortPositiveNumbersByDesc_emptyArray_ok() {
        Integer array[] = {};
        Integer expected[] = {};
        assertArrayEquals(expected, arraySortingService.sortPositiveNumbersByDesc(array));
    }
}
