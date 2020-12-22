package com.erik.day20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImageTest {
    @Test
    void uuidFitsWithInput() {
        Image i1 = new Image(new String[] {
                "Tile 1951:",
                "#.##...##.",
                "#.####...#",
                ".....#..##",
                "#...######",
                ".##.#....#",
                ".###.#####",
                "###.##.##.",
                ".###....#.",
                "..#.#..#.#",
                "#...##.#.."});
        Assertions.assertEquals(1951L, i1.getUuid());
    }

    @Test
    void edgesFitWithInput() {
        Image i1 = new Image(new String[] {
                "Tile 1951:",
                "#.##...##.",
                "#.####...#",
                ".....#..##",
                "#...######",
                ".##.#....#",
                ".###.#####",
                "###.##.##.",
                ".###....#.",
                "..#.#..#.#",
                "#...##.#.."});
        Assertions.assertEquals("#.##...##.", i1.getTop());
        Assertions.assertEquals("#...##.#..", i1.getBottom());
        Assertions.assertEquals("##.#..#..#", i1.getLeft());
        Assertions.assertEquals(".#####..#.", i1.getRight());

    }

    @Test
    void recognizesSharedEdges() {
        Image i1 = new Image(new String[] {
                "Tile 1951:",
                "#.##...##.",
                "#.####...#",
                ".....#..##",
                "#...######",
                ".##.#....#",
                ".###.#####",
                "###.##.##.",
                ".###....#.",
                "..#.#..#.#",
                "#...##.#.."});

        Image i2 = new Image(new String[] {
                "Tile 2311:",
                "..##.#..#.",
                "##..#.....",
                "#...##..#.",
                "####.#...#",
                "##.##.###.",
                "##...#.###",
                ".#.#.#..##",
                "..#....#..",
                "###...#.#.",
                "..###..###"
        });
        // 2311.left == 1951.right
        Assertions.assertTrue(i1.sharesEdgeWith(i2));
    }

    @Test
    void equalReturnsTrueForIdenticalImagesWithIdenticalEdges() {
        Image i1 = new Image(new String[] {
                "Tile 1:",
                "#.#",
                "..#",
                "#.."
        });
        Image i2 = new Image(new String[] {
                "Tile 2:",
                "#.#",
                ".##",
                "#.."
        });
        Assertions.assertTrue(i1.equals(i2));
    }

    @Test
    void rotateOnce() {
        Image i1 = new Image(new String[] {
                "Tile 1:",
                "..#",
                "..#",
                "#.."
        });
        Image i2 = new Image(new String[] {
                "Tile 2:",
                "##.",
                "...",
                "..#"
        });
        i1.rotateLeft();
        Assertions.assertTrue(i1.equals(i2));
    }
}
