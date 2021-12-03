package advent.day;

import advent.Day;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day03 implements Day {

    private void part1(Stream<char[]> values, int length, int inputBits) {
        var ones = getOnesOfPosition(values, inputBits);
        System.out.println(
        Integer.parseInt(Arrays.stream(ones).mapToObj(x -> getMostOrLeastCommonBit(x, length, true)).collect(Collectors.joining("")), 2) *
        Integer.parseInt(Arrays.stream(ones).mapToObj(x -> getMostOrLeastCommonBit(x, length, false)).collect(Collectors.joining("")), 2));


    }

    private void part2(List<char[]> values, int inputBits) {
        var oxygenRating = getRating(values,0, inputBits, true);
        var co2ScrubberRating = getRating(values,0, inputBits, false);

        System.out.println(
                Integer.parseInt(String.valueOf(oxygenRating), 2) * Integer.parseInt(String.valueOf(co2ScrubberRating), 2)
        );


    }

    private char[] getRating(List<char[]> values, int index, int inputBits, boolean considerOneBitCriteria) {
        if (index == inputBits || values.size() == 1) {
            return values.get(0);
        }
        var ones = getOnesOfPosition(values.stream(), inputBits);
        var selector = getMostOrLeastCommonBit(ones[index], values.size(), considerOneBitCriteria);
        return getRating(values.stream().filter(x -> x[index] == selector.charAt(0)).collect(Collectors.toList()), index + 1, inputBits, considerOneBitCriteria);
    }

    private int[] getOnesOfPosition(Stream<char[]> values, int inputBits){
        var ones = new int[inputBits];
        values.forEach(bitArray -> {
            for (int i = 0; i < inputBits; i++) {
                ones[i] += (bitArray[i] - '0');
            }
        });
        return ones;
    }

    private String getMostOrLeastCommonBit(int oneCount, int totalCount, boolean most) {
        if (totalCount - oneCount > oneCount) {
            return most ? "0" : "1";
        } else {
            return most ? "1" : "0";
        }
    }

    @Override
    public void executePartsOfTheDay(Stream<String> inputStream) {
        var list = inputStream.map(String::toCharArray).collect(Collectors.toList());
        var inputBits = list.get(0).length;
        System.out.println("Part 1");
        part1(list.stream(), list.size(), inputBits); //4103154
        System.out.println("Part 2");
        part2(list, inputBits); // 4245351

    }
}
