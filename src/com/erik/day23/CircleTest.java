package com.erik.day23;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CircleTest {
    private Circle cut;
    @BeforeEach
    void setup() {
        String input = "1234";
        this.cut = new Circle(input);
    }

    @Test
    void sizeOf4ElementCircle_Is4() {
        Assertions.assertEquals(4, cut.size());
    }

    @Test
    void sizeOf3ElementCircle_Is3() {
        String input = "123";
        Circle cut = new Circle(input);
        Assertions.assertEquals(3, cut.size());
    }

    @Test
    void indexAccessToIntegerElement() {
        Assertions.assertEquals(2, cut.get(1));
    }

    @Test
    void indexAccessToElementOutsideOfRange() {
        Assertions.assertEquals(2, cut.get(5));
    }

    @Test
    void stashElementsFromTheCircle() throws Exception {
        cut.stash(1,3);
        Assertions.assertEquals(2, cut.size());
        Assertions.assertEquals("14", cut.getElements());
    }

    @Test
    void stashLastElement() throws Exception {
        cut.stash(3,4);
        Assertions.assertEquals(3,cut.size());
        Assertions.assertEquals("123",cut.getElements());

    }

    @Test
    void stashElementsWithIndexesLargerSize_Throws() throws Exception {
        Assertions.assertThrows(Exception.class,() -> cut.stash(5));
    }

    @Test
    void retrieveStashedElements() throws Exception {
        cut.stash(1,3);
        cut.retrieveStash();
        Assertions.assertEquals(4,cut.size());
        Assertions.assertEquals("1234", cut.getElements());
    }

    @Test
    void insertStashAtIndex() throws Exception {
        cut.stash(1,3);
        cut.insertStash(0);
        Assertions.assertEquals(4,cut.size());
        Assertions.assertEquals("2314", cut.getElements());
    }

    @Test
    void throwsException_WhenStashEmptyAtRetrieval() {
        Assertions.assertThrows(Exception.class, () -> { cut.retrieveStash(); });
        Assertions.assertThrows(Exception.class, () -> { cut.insertStash(1); });
    }

    @Test
    void makeElementAtIndexFirstElement() {
        cut.makeCurrent(3);
        Assertions.assertEquals("4123", cut.getElements());
    }

    @Test
    void contains_ReturnsTrueIfContained() {
        Assertions.assertTrue(cut.contains("3"));
    }

    @Test
    void contains_DoesNotConsiderStash() throws Exception {
        cut.stash(2,3);
        Assertions.assertFalse(cut.contains("3"));
    }

    @Test
    void indexOf() {
        Assertions.assertEquals(2, cut.indexOf("3"));
    }

    @Test
    void max() {
        Assertions.assertEquals("4", cut.max());
    }

    @Test
    void max_IgnoresStash() throws Exception {
        cut.stash(3);
        Assertions.assertEquals("3", cut.max());
    }
}
