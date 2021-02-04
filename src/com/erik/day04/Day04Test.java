package com.erik.day04;

import com.erik.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day04Test {
    @Test
    void testPart1() throws InputProvider.FileError {
        String[] input = {"ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
        "byr:1937 iyr:2017 cid:147 hgt:183cm",
        "",
        "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
        "hcl:#cfa07d byr:1929",
        "",
        "hcl:#ae17e1 iyr:2013",
        "eyr:2024",
        "ecl:brn pid:760753108 byr:1931",
        "hgt:179cm",
        "",
        "hcl:#cfa07d eyr:2025 pid:166559648",
        "iyr:2011 ecl:brn hgt:59in"};

        Day04 day04 = new Day04(input);
        Assertions.assertEquals(2,day04.part1());

        day04 = new Day04(new InputProvider().getAsString("InputFiles/inputDay04.txt"));
        Assertions.assertEquals(210, day04.part1());
    }

    @Test
    void part2AcceptsValidInputWithCid() {
        String[] input = {"byr:1980 iyr:2012 eyr:2030 hgt:74in hcl:#623a2f ecl:grn pid:087499704 cid:88"};
        Assertions.assertEquals(1,new Day04(input).part2());
    }

    @Test
    void part2AcceptsValidInputWithoutCid() {
        String[] input = {"byr:1980 iyr:2012 eyr:2030 hgt:74in hcl:#623a2f ecl:grn pid:087499704"};
        Assertions.assertEquals(1,new Day04(input).part2());
    }

    @Test
    void part2DetectsInvalidBirthYear() {
        String[] input = {"byr:1900 iyr:2012 eyr:2030 hgt:74in hcl:#623a2f ecl:grn pid:087499704",
                "byr:2900 iyr:2012 eyr:2030 hgt:74in hcl:#623a2f ecl:grn pid:087499704"};
        Assertions.assertEquals(0, new Day04(input).part2());
    }

    @Test
    void part2DetectsInvalidIssuingYear() {
        String[] input = {"byr:1980 iyr:2030 eyr:2030 hgt:74in hcl:#623a2f ecl:grn pid:087499704",
                "byr:1980 iyr:1900 eyr:2030 hgt:74in hcl:#623a2f ecl:grn pid:087499704"};
        Assertions.assertEquals(0, new Day04(input).part2());
    }

    @Test
    void part2DetectsInvalidExpirationYear() {
        String[] input = {"byr:1980 iyr:2012 eyr:2031 hgt:74in hcl:#623a2f ecl:grn pid:087499704 cid:88",
                "byr:1980 iyr:2012 eyr:1900 hgt:74in hcl:#623a2f ecl:grn pid:087499704 cid:88"};
        Assertions.assertEquals(0,new Day04(input).part2());
    }

    @Test
    void part2DetectsInvalidHeight() {
        String[] input =
                {"byr:1980 iyr:2012 eyr:2030 hgt:190in hcl:#623a2f ecl:grn pid:087499704 cid:88",
                "byr:1980 iyr:2012 eyr:2030 hgt:5in hcl:#623a2f ecl:grn pid:087499704 cid:88",
                "byr:1980 iyr:2012 eyr:2030 hgt:5cm hcl:#623a2f ecl:grn pid:087499704 cid:88",
                "byr:1980 iyr:2012 eyr:2030 hgt:190 hcl:#623a2f ecl:grn pid:087499704 cid:88",
                "byr:1980 iyr:2012 eyr:2030 hgt:200cm hcl:#623a2f ecl:grn pid:087499704 cid:88"};
        Assertions.assertEquals(0,new Day04(input).part2());
    }

    @Test
    void part2DetectsInvalidHairColor() {
        String[] input = {"byr:1980 iyr:2012 eyr:2031 hgt:74in hcl:#623a2z ecl:grn pid:087499704 cid:88", //"z"
                "byr:1980 iyr:2012 eyr:2031 hgt:74in hcl:#623a2 ecl:grn pid:087499704 cid:88", // code one character short
                "byr:1980 iyr:2012 eyr:2031 hgt:74in hcl:623a2f ecl:grn pid:087499704 cid:88" // missing "#" in the beginning
        };
        Assertions.assertEquals(0,new Day04(input).part2());
    }

    @Test
    void part2DetectsInvalidEyeColor() {
        String[] input = {"byr:1980 iyr:2012 eyr:2031 hgt:74in hcl:#623a2f ecl:zzz pid:087499704 cid:88",
                "byr:1980 iyr:2012 eyr:2031 hgt:74in hcl:#623a2f ecl:grn2 pid:087499704 cid:88", // one char too long
                "byr:1980 iyr:2012 eyr:2031 hgt:74in hcl:#623a2f ecl:grngrn pid:087499704 cid:88"}; // grn twice
        Assertions.assertEquals(0,new Day04(input).part2());
    }

    @Test
    void part2DetectsInvalidPid() {
        String[] input = {"byr:1980 iyr:2012 eyr:2031 hgt:74in hcl:#623a2f ecl:grn pid:0874997040 cid:88", // one char too long
                "byr:1980 iyr:2012 eyr:2031 hgt:74in hcl:#623a2f ecl:grn pid:08749970 cid:88", // one char too short
                "byr:1980 iyr:2012 eyr:2031 hgt:74in hcl:#623a2f ecl:grn pid:0874997040a cid:88" // contains a letter
        };
        Assertions.assertEquals(0,new Day04(input).part2());
    }

    @Test
    void part2DetectsIncompleteData() {
        String[] input = {"iyr:2012 eyr:2031 hgt:74in hcl:#623a2f ecl:grn pid:087499704 cid:88"}; // birth year missing
        Assertions.assertEquals(0,new Day04(input).part2());
    }
}
