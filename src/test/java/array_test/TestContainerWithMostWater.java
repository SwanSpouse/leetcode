package array_test;

import org.junit.Test;

import static array.ContainerWithMostWater.maxArea;
import static org.junit.Assert.assertEquals;

public class TestContainerWithMostWater {

    @Test
    public void testMaxArea() {
        assertEquals(9, maxArea(new int[]{3, 5, 1, 4, 2}));
    }
}
