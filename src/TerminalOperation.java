import java.util.*;
import java.util.stream.Collectors;

public class TerminalOperation {

    public static void main(String[] args) {
        //Terminal operations are the final operations in a stream pipeline that produce a result or side effect.
        // They trigger the processing of the stream and after execution,
        // the stream is considered consumed and cannot be used again.

        //1. collect
        List<String> name =  Arrays.asList("Luffy","Zoro","Chopper","Robin","Brook","Franky","Jimbe","Luffy","Zoro");
        List<String> upperCase = name.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperCase);

        //2. reduce
        //Combines elements using a BinaryOperator to produce a single result. Return Optional object
        List<Integer> nums = Arrays.asList(1,2,34,5,5,7,9,8,8);

        Integer sum = nums.stream()
                .reduce(0, Integer::sum); // Using identity value avoids Optional
        System.out.println("2. Sum with identity: " + sum);

        Optional<Integer> sumOptional = nums.stream()
                .reduce(Integer::sum);
        sumOptional.ifPresent(s -> System.out.println("2a. Sum with Optional: " + s));

        //3. min and max
        Optional<Integer>min = nums.stream().min(Comparator.naturalOrder());
        System.out.println(min);
        Optional<Integer>max = nums.stream().max(Comparator.naturalOrder());
        System.out.println(max);

        //4. count
        long cnt = nums.stream()
                .distinct()
                .count();
        System.out.println(cnt);

        //5. findFirst()
        //Returns the first element of the stream (respects encounter order).
        Optional<Integer>first = nums.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .findFirst();
        System.out.println(first);

        //6. findAny()
        //Returns any element from the stream (better for parallel streams).
        Optional<Integer>any = nums.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .findAny();
        System.out.println(any);

        // Parallel stream example for findAny()
        Optional<Integer> anyParallel = nums.parallelStream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .findAny();
        anyParallel.ifPresent(a -> System.out.println("6a. Any element from parallel stream: " + a));

        any.ifPresent(a -> System.out.println("6. Any element (could be different in parallel): " + a));
        //Optional handling: Use .ifPresent() instead of .get() to avoid NoSuchElementException

        //7. anyMatch()
        //Check if elements match certain conditions. Returns true if any element matches the predicate.
        Boolean checkOdd = nums.stream()
                .anyMatch(x->x%2 != 0);
        System.out.println(checkOdd);

        //8. allMatch()
        //Returns true if all elements match the predicate.
        Boolean checkAllOdd = nums.stream()
                .anyMatch(x->x%2 != 0);
        System.out.println(checkAllOdd);

        //9. noneMatch()
        //Returns true if no elements match the predicate.
        Boolean greaterThan100 = nums.stream()
                .noneMatch(x->x>100);
        System.out.println(greaterThan100);

        //10. forEach()
        //Performs an action for each element (order not guaranteed in parallel).
        name.stream().forEach(System.out::println);

        //11. forEachOrdered()
        //Performs action in encounter order, even with parallel streams.
        name.stream().forEachOrdered(System.out::println);

        //12. toArray()
        //Converts stream to an array.
        Object[] arr = nums.stream()
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr));

        // 13. Additional: iterator() - though not commonly used directly
        Iterator<String> iterator = name.stream()
                .iterator();
        System.out.print("13. Iterator: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();



    }
}
