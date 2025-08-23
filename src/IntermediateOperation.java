import java.util.*;
import java.util.stream.Collectors;

public class IntermediateOperation {
    public static void main(String[] args) {

        //filter: filter elements based on condition
        //filter(Predicate<T> predicate): It takes Predicate as input
        List <String> list = Arrays.asList("Luffy","Zoro","Chopper","Robin","Brook","Franky","Jimbe");
        List<String> filterlist = list.stream()
                .filter(x->x.startsWith("L"))
                .toList();
        System.out.println(filterlist);

        //map : Transform each element to another type
        //map(Function<T,R> function) : It takes Function as input
        List <String> list2 = Arrays.asList("Law","WhiteBeard","Roger","Rayleigh","Gaban");
        List<Integer> maplist = list2.stream()
                .map(x->x.length())
                .toList();
        System.out.println(maplist);

        //flatmap : Flatten nested structure into single stream
        //flatMap(Function<T, Stream<R>> mapper): It takes Function as input
        List<List<String>> list3 = Arrays.asList(Arrays.asList("Luffy","Zoro","Chopper","Robin","Brook","Franky","Jimbe")
                ,Arrays.asList("Law","WhiteBeard","Roger","Rayleigh","Gaban"));
        List<Integer> map = list3.stream()
                .flatMap(Collection::stream)
                .map(String::length)
                .toList();
        System.out.println(map);

        //distinct: Removes duplicate elements.
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5,6,7,8,9,9);
        List<Integer> distinct = numbers.stream()
                .distinct()
                .toList();
        System.out.println(distinct);

        //sorted() : Sort Elements
        //sorted(Comparator<T> comparator): sort elements as per comparator
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        List<String> sorted = names.stream()
                .sorted()
                .toList();
        System.out.println(sorted);

        //Reverse order can also use Comparator.reverseOrder()
        List<String> reverseSorted = names.stream()
                .sorted((x,y)->y.compareTo(x))
                .toList();
        System.out.println(reverseSorted);

        //peek:Performs action on each element without modifying the stream (mainly for debugging).
        //peek(Consumer<T> action): It takes consumer as input
        List <String> crew = Arrays.asList("Luffy","Zoro","Chopper","Robin","Brook","Franky","Jimbe");
        List <String> crew1 = crew.stream()
                .peek(str-> System.out.println("Before UpperCase "+str))
                .map(x->x.toUpperCase())
                .peek(str-> System.out.println("After UpperCase "+str))
                .toList();
        System.out.println(crew1);

        //limit: Truncates the stream to be no longer than maxSize.
        //limit(long maxSize): It takes long as input
        List<Integer> numbers1 = numbers.stream()
                .distinct()
                .limit(5)
                .toList();
        System.out.println(numbers1);

        //skip : Skips the first n elements.
        //skip(long n): It takes long as input
        List<Integer> numbers2 = numbers.stream()
                .distinct()
                .skip(3)
                .toList();
        System.out.println(numbers2);

        //takeWhile: Takes elements while predicate is true, then stops.
        //takeWhile(Predicate<T> predicate)
        List<Integer> nums = Arrays.asList(1,2,5,11,89,4,3,34,74,88);
        List<Integer> twoDigit = nums.stream()
                .sorted(Comparator.reverseOrder()) //
                .takeWhile(x-> x > 10)
                .toList();
        System.out.println(twoDigit);

        //dropWhile: Drops elements while predicate is true, then takes the rest.
        //dropWhile(Predicate<T> predicate): It takes Predicate as input
        List<Integer> singleDigit = nums.stream()
                .sorted(Comparator.reverseOrder())
                .dropWhile(x->x > 10)
                .toList();
        System.out.println(singleDigit);

        //boxed: Converts primitive streams to object streams
        int []primativearray = {10,20,30,40,50};
        List<Integer> boxedlist = Arrays.stream(primativearray)
                .boxed()
                .toList();
        System.out.println(boxedlist);

        //unordered(): Indicates that order doesn't matter (can improve performance)
        List <Integer> unorder = nums.stream()
                .unordered()
                .filter(x->x>10)
                .toList();
        System.out.println(unorder);

    }
}
