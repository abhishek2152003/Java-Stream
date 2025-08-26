import java.util.*;
import java.util.stream.Collectors;

public class CollectorsExample {
    public static void main(String[] args) {
        //Reduction Operation: Return a single value by combining stream elements
        // Collectors is a utility class
        // provides a set of methods to create common collectors
        //collect(): it takes Collectors as input

        //1. Collect to List
        List<String> pirateCrew  =  Arrays.asList("Luffy","Zoro","Chopper","Robin","Brook","Franky","Jimbe","Luffy","Zoro");
        List<String> upperCase = pirateCrew .stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperCase);

        //2. Collect to Set
        Set<String> noDuploicate = pirateCrew .stream()
                .sorted()
                .collect(Collectors.toSet());
        System.out.println(noDuploicate);

        //3. Collect to Map
        Map<String,Integer> map = pirateCrew .stream()
                .distinct()
                .collect(Collectors.toMap(x->x, String::length));
        System.out.println(map);

        //4. Collect to Collection (Specific Implementation)
        List <Integer> nums = Arrays.asList(1,3,2,4,5,6,7,8);
        LinkedList<Integer> linkedList = nums.stream()
                .map(x->x*x)
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(linkedList);

        //5. Joining Strings
        String joining = pirateCrew .stream()
                .collect(Collectors.joining(", "));
        System.out.println(joining);

        //6. Grouping By
        // grouping elements of a stream based on a classification function.
        Map<Character,List<String>> groupingby = pirateCrew .stream()
                .collect(Collectors.groupingBy(x-> x.charAt(0)));
        System.out.println(groupingby);

        //7. Partitioning (Boolean grouping)
        //grouping that divides elements into two groups based on a predicate. It always returns a Map with exactly two boolean keys
        // Map<Boolean, List<T>> with exactly two entries.
        Map<Boolean, List<Integer>> isEven = nums.stream()
                .distinct()
                .collect(Collectors.partitioningBy(x-> x%2 ==0));
        System.out.println(isEven);

        //8. Summarizing Statistics
        IntSummaryStatistics stat = nums.stream()
                .collect(Collectors.summarizingInt(x -> x));
        System.out.println(stat);

        // 9. Collect to Unmodifiable List
        List<String> unmodifiableUpperCase = pirateCrew.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toUnmodifiableList());
        System.out.println(unmodifiableUpperCase);
        // unmodifiableUpperCase.add("Nami"); // This would throw UnsupportedOperationException

        // 10. Collect to Unmodifiable Set
        Set<String> unmodifiableSet = pirateCrew.stream()
                .sorted()
                .collect(Collectors.toUnmodifiableSet());
        System.out.println(unmodifiableSet);



    }
}
