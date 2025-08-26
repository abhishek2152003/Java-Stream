import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateLevel {
    public static void main(String[] args) {
        List<Integer>numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,11,12,13,14,15);
        List <String> strawHats = Arrays.asList("Luffy","Zoro","Chopper","Robin","Brook","Franky","Jimbe");
        List <String> otherPirates = Arrays.asList("Law","WhiteBeard","Roger","Rayleigh","Gaban");
        List<List<String>> nestednames = Arrays.asList(strawHats,otherPirates);
        //1. How do you find the sum of a list of integers using streams?
        int sum = numbers.stream()
                .filter(Objects::nonNull) //x->x!=null
                .reduce(0, Integer::sum);
        System.out.println(sum);

        //2. How do you find the maximum and minimum values in a stream?
        Optional<Integer> min = numbers.stream()
                .min(Comparator.naturalOrder());
        min.ifPresent(x-> System.out.println("Minimum: "+x));

        Optional<Integer> max = numbers.stream()
                .max(Comparator.naturalOrder());
        max.ifPresent(x-> System.out.println("Maximum: "+x));

        //3. How do you find the average of numbers in a list using streams?
        double average =numbers.stream()
                .collect(Collectors.averagingInt(x->x));
        System.out.println(average);

        //4. How do you concatenate multiple lists into a single stream?
        List<String>concat = Stream.concat(strawHats.stream(),otherPirates.stream())
                .toList();
        System.out.println(concat);

        //5. How do you group a list of numbers into even and odd using streams?
        Map<Boolean,List<Integer>> evenAndOdd = numbers.stream()
                .collect(Collectors.partitioningBy(x->x%2 ==0));
        System.out.println(evenAndOdd);

        //6. How do you group a list of employees by department using streams?

        //7. How do you find the second-highest number in a list using streams?
        Integer secondHighest =numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0);
        System.out.println(secondHighest);

        //8. How do you partition a list of numbers into two groups: greater than 10 and less than 10?
        Map<Boolean,List<Integer>>greaterthan10 = numbers.stream()
                .collect(Collectors.partitioningBy(x->x>10));
        System.out.println(greaterthan10);

        //9. How do you count occurrences of each word in a list using streams?
        Map<String,Long> occurance =strawHats.stream()
                .collect(Collectors.groupingBy(x-> x,Collectors.counting()));
        System.out.println(occurance);

        //10. How do you remove null values from a list using streams?
        List<Integer>notNull=numbers.stream()
                .filter(Objects::nonNull) //x->x!=null
                .toList();
        System.out.println(notNull);

        //11. How do you concatenate all strings in a list into a single string using streams?
        String concatenate = strawHats.stream()
                .collect(Collectors.joining(", "));
        System.out.println(concatenate);

        //12. How do you flatten a list of lists into a single list using streams?
        List<String> pirates =nestednames.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println(pirates);

        //13. How do you find duplicate elements in a list using streams?
        List<String>duplicate = pirates.stream()
                .filter(x->Collections.frequency(pirates,x)>1)
                .distinct()
                .toList();
        System.out.println(duplicate);


        //14. How do you get the top 3 highest numbers from a list using streams?
        Optional<Integer> thirdHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst();
        thirdHighest.ifPresent(x-> System.out.println(x));

        //15. How do you convert a list of strings into a map of string-length pairs?
        System.out.println(pirates.stream()
                .collect(Collectors.groupingBy(String::length)));

        //16. How do you find the longest word in a list using streams?
        Optional<String>longest = pirates.stream()
                .sorted((x,y)-> y.length()-x.length()).findFirst();
        longest.ifPresent(x-> System.out.println(x));

        //17. How do you get distinct characters from a list of strings?
        System.out.println(pirates.stream()
                .map(x->x.toLowerCase())
                .flatMapToInt(String::chars)
                .mapToObj(x -> (char) x)
                .distinct()
                .toList());

        //18. How do you merge two maps using streams?
        Map<String,Integer> map1 = Map.of("Hello",2 ,"World",3);
        Map<String,Integer> map2 = Map.of("Java",1,"Hello",2);
        Map<String,Integer> merged = Stream.concat(
                map1.entrySet().stream(),
                map2.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue ,(v1,v2)->v2));
        System.out.println(merged);

        //19. How do you extract a sublist based on a condition using streams?
        List<String>sublist = pirates.stream()
                .filter(x->x.length()>5)
                .toList();
        System.out.println(sublist);
        //20. How do you shuffle elements in a list using streams?
        List <String>shuffle = strawHats.stream()
                        .sorted((x,y)->new Random().nextInt(3)-1)
                .toList();
        System.out.println(shuffle);


    }
}
