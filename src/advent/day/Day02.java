package advent.day;

import advent.Day;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day02 implements Day {

    private void part1(Stream<String> values) {
        int[] h = new int[]{0};
        int[] v = new int[]{0};

        var opMap = new HashMap<String, Consumer<Integer>>() {{
            put("up", x -> v[0] = v[0] - x);
            put("down", x -> v[0] = v[0] + x);
            put("forward", x -> h[0] = h[0] + x);
        }};
        values.map(x -> x.split(" ")).forEach(x -> opMap.get(x[0]).accept(Integer.parseInt(x[1])));
        System.out.println(h[0]*v[0]);
    }

    private void part2(Stream<String> values) {
        int[] aim = new int[]{0};
        int[] h = new int[]{0};
        int[] v = new int[]{0};

        var opMap = new HashMap<String, Consumer<Integer>>() {{
            put("up", x -> aim[0] = aim[0] - x);
            put("down", x -> aim[0] = aim[0] + x);
            put("forward", x -> {
                h[0] = h[0] + x;
                v[0] = v[0] + x * aim[0];
            });
        }};
        values.map(x -> x.split(" ")).forEach(x -> opMap.get(x[0]).accept(Integer.parseInt(x[1])));
        System.out.println(h[0]*v[0]);
    }


    @Override
    public void executePartsOfTheDay(Stream<String> inputStream) {
        var list = inputStream.collect(Collectors.toList());
        System.out.println("Part 1");
        part1(list.stream());
        System.out.println("Part 2");
        part2(list.stream());

    }
}
