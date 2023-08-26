import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class Main
{
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>();

        for (int i = 15; i > 1; i--)
        {
            list.add(i);
        }
        List<String> listt = list.stream()
                .map(element -> String.valueOf(element + 10))
                .filter(element -> Integer.parseInt(element) > 10)
                .map(element -> element + "a")
                .map(element -> "b" + element)
                .collect(toList());

        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> result = numberList
                .stream()
                .filter(element -> element % 2 == 0)
                .map(element -> element * 5)
                .collect(Collectors.toList());

        Stream stream = Stream.of(1, 2, 3, 4, 5);

        boolean notEqualToZero = numberList
                .stream()
                .allMatch(element -> element != 0);

        System.out.println(notEqualToZero); // true since each element is not equal to zero


    }
}