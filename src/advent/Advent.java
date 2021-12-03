package advent;

import advent.day.Day01;
import advent.day.Day02;
import advent.day.Day03;

import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Advent {

    public static void main(String[] args) {
        var day = -1;
        if (0 < args.length) {
            try {
                day = Integer.parseInt(args[0]);
            } catch (NumberFormatException ignored) {}
        }
        if (day < 1 || day > 25){
            System.err.println("A day must be provided as integer 1 - 25");
            return;
        }
        File input;
        if (1 < args.length) {
            input = new File(args[1]);
        } else {
            System.err.println("No input provided!");
            return;
        }

        try (FileReader fileReader = new FileReader(input)) {
            try (BufferedReader br = new BufferedReader(fileReader)) {
                switch (day) {
                    case 1 -> new Day01().executePartsOfTheDay(br.lines());
                    case 2 -> new Day02().executePartsOfTheDay(br.lines());
                    case 3 -> new Day03().executePartsOfTheDay(br.lines());
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Input file not found!");
        } catch (IOException e) {
            System.err.println(MessageFormat.format("Error loading input file: {0}", e.getMessage()));
        }
    }
}
