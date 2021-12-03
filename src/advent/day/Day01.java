package advent.day;

import advent.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day01 implements Day {

    private void part1(List<Integer> values) {
        var tempMax = new Integer[]{Integer.MIN_VALUE};
        System.out.println((values.stream().filter(x -> {
            if (x > tempMax[0]) {
                tempMax[0] = x;
                return true;
            }
            tempMax[0] = x;
            return false;
        }).count() - 1));
    }

    private void part2(List<Integer> values) {
            var resultList = new ArrayList<Integer>();
            for (int i = 0; i < values.size() - 2; i++) {
                    resultList.add(values.get(i) + values.get(i+1) +values.get(i+2));
            }
            part1(resultList);
    }

    @Override
    public void executePartsOfTheDay(Stream<String> inputStream) {
        var inputIntList = inputStream.map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("Part 1");
        // 1167
        part1(inputIntList);
        System.out.println("Part 2");
        // 1130
        part2(inputIntList);
    }
}
