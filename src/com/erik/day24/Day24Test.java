package com.erik.day24;

import com.erik.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day24Test {
    @Test
    void part1() {
        String[] input = new String[] {
                "sesenwnenenewseeswwswswwnenewsewsw",
                "neeenesenwnwwswnenewnwwsewnenwseswesw",
                "seswneswswsenwwnwse",
                "nwnwneseeswswnenewneswwnewseswneseene",
                "swweswneswnenwsewnwneneseenw",
                "eesenwseswswnenwswnwnwsewwnwsene",
                "sewnenenenesenwsewnenwwwse",
                "wenwwweseeeweswwwnwwe",
                "wsweesenenewnwwnwsenewsenwwsesesenwne",
                "neeswseenwwswnwswswnw",
                "nenwswwsewswnenenewsenwsenwnesesenew",
                "enewnwewneswsewnwswenweswnenwsenwsw",
                "sweneswneswneneenwnewenewwneswswnese",
                "swwesenesewenwneswnwwneseswwne",
                "enesenwswwswneneswsenwnewswseenwsese",
                "wnwnesenesenenwwnenwsewesewsesesew",
                "nenewswnwewswnenesenwnesewesw",
                "eneswnwswnwsenenwnwnwwseeswneewsenese",
                "neswnwewnwnwseenwseesewsenwsweewe",
                "wseweeenwnesenwwwswnew"
        };
        Day24 cut = new Day24(input);
        Assertions.assertEquals(10L, cut.part1());
    }

    @Test
    void part1WithRealInput() {
        Day24 cut = new Day24(new InputProvider().get("inputDay24.txt"));
        Assertions.assertEquals(400L,cut.part1());
    }

    @Test
    void part2() {
        String[] input = new String[] {
                "sesenwnenenewseeswwswswwnenewsewsw",
                "neeenesenwnwwswnenewnwwsewnenwseswesw",
                "seswneswswsenwwnwse",
                "nwnwneseeswswnenewneswwnewseswneseene",
                "swweswneswnenwsewnwneneseenw",
                "eesenwseswswnenwswnwnwsewwnwsene",
                "sewnenenenesenwsewnenwwwse",
                "wenwwweseeeweswwwnwwe",
                "wsweesenenewnwwnwsenewsenwwsesesenwne",
                "neeswseenwwswnwswswnw",
                "nenwswwsewswnenenewsenwsenwnesesenew",
                "enewnwewneswsewnwswenweswnenwsenwsw",
                "sweneswneswneneenwnewenewwneswswnese",
                "swwesenesewenwneswnwwneseswwne",
                "enesenwswwswneneswsenwnewswseenwsese",
                "wnwnesenesenenwwnenwsewesewsesesew",
                "nenewswnwewswnenesenwnesewesw",
                "eneswnwswnwsenenwnwnwwseeswneewsenese",
                "neswnwewnwnwseenwseesewsenwsweewe",
                "wseweeenwnesenwwwswnew"
        };
        Day24 cut = new Day24(input);
        Assertions.assertEquals(2208L, cut.part2());
    }

    @Test
    void part2WithRealInput() {
        Day24 cut = new Day24(new InputProvider().get("inputDay24.txt"));
        Assertions.assertEquals(3768L,cut.part2());
    }

    @Test
    void parseInput() {
        String[] input = new String[] {
                "eee",
                "neese",
                "nesw",
                "senw"
        };
        Day24 cut = new Day24(input);
        Vector3[] parsed = cut.getInstructions();
        Assertions.assertEquals(new Vector3(3,0,0), parsed[0]);
        Assertions.assertEquals(new Vector3(1,1,1), parsed[1]);
        Assertions.assertEquals(new Vector3(0,0,0), parsed[2]);
        Assertions.assertEquals(new Vector3(0,0,0), parsed[3]);
    }
}
