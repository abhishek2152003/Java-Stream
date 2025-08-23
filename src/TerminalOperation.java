import java.util.*;
import java.util.stream.Collectors;

public class TerminalOperation {

    public static void main(String[] args) {
        //Reduction Operation: Return a single value by combining stream elements
        // Collectors is a utility class
        // provides a set of methods to create common collectors
        //collect(): it takes Collectors as input

        //1. Collect to List
        List<String> name =  Arrays.asList("Luffy","Zoro","Chopper","Robin","Brook","Franky","Jimbe","Luffy","Zoro");
        List<String> upperCase = name.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperCase);

        //2. Collect to Set
        Set<String> noDuploicate = name.stream()
                .sorted()
                .collect(Collectors.toSet());
        System.out.println(noDuploicate);

        //3. Collect to Map
        Map<String,Integer> map = name.stream()
                .distinct()
                .collect(Collectors.toMap(x->x, String::length));
        System.out.println(map);

        // Collect to Collection (Specific Implementation)


        List <Integer> nums = Arrays.asList(1,3,2,4,5,6,7,8);
        LinkedList<Integer> linkedList = nums.stream()
                .map(x->x*x)
                .sorted()
                .collect(Collectors.toCollection(()->new LinkedList<Integer>()));
        System.out.println(linkedList);

    }
}
