import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AdvancedLevel {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,11,12,13,14,15);
        List <String> strawHats = Arrays.asList("Luffy","Zoro","Chopper","Robin","Brook","Franky","Jimbe","Luffy");
        List <String> otherPirates = Arrays.asList("Law","WhiteBeard","Roger","Rayleigh","Gaban");

        //1. How do you implement a custom collector?
        //2. How do you sort a list of objects based on multiple fields using streams?
        //3. How do you parallelize a stream for better performance?
        //4. How do you handle exceptions inside stream operations?
        //5. How do you implement a sliding window over a stream?
        //6. How do you perform batch processing on a stream?
        //7. How do you implement pagination using streams?
        //8. How do you dynamically apply filters to a stream based on runtime conditions?
        //
        //9. How do you compute the frequency of characters in a string using streams?

        //10. How do you find the most frequently occurring element in a list using streams?


        //11. How do you implement a custom comparator for sorting using streams?
        List <String> sorted = strawHats.stream()
                .sorted((x,y)->x.length()-y.length())
                .toList();
        System.out.println(sorted);

        //12. How do you collect results of a stream into an immutable collection?
        List <String> lowerCase =strawHats.stream()
                .map(x->x.toLowerCase())
                .collect(Collectors.toUnmodifiableList());
        System.out.println(lowerCase);
        //13. How do you convert a nested object structure into a flat list using streams?
        List<List<Integer>> nested = Arrays.asList(Arrays.asList(1,2,3,4,5),Arrays.asList(5,6,7,8,9),Arrays.asList(10,11,12,13,14,15));
        List<Integer> nums= nested.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println(nums);

        //14. How do you convert an Iterator into a Stream?

        //15. How do you create a summary report (e.g., count, sum, min, max, average) for a dataset using streams?
        IntSummaryStatistics summary = numbers.stream()
                .collect(Collectors.summarizingInt(x->x));
        System.out.println(summary);




    }
}
