import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicLevel {
    public static void main(String[] args) {

        //1. How do you create a stream from a list of integers?
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
        Stream<Integer> s1 = list1.stream();

        //2. How do you convert a stream back to a list?
        List<Integer> list2 = s1.toList();
        System.out.println(list2);

        //3. How do you find the count of elements in a stream?
        long count = list2.stream().count();
        System.out.println(count);

        //4. How do you filter even numbers from a list using streams?
        System.out.println(list2.stream().filter(x->x%2==0).toList());

        //5. How do you transform a list of strings to uppercase using streams?
        List<String> string1 = Arrays.asList("Hello","This","Java","Stream");
        System.out.println(string1.stream().map(String::toUpperCase).toList());

        //6. How do you sort a list of numbers using streams?
        list1 = Arrays.asList(8,7,4,3,2,1,2,3,4);
        //ascending order
        System.out.println(list1.stream().sorted().toList());
        //reverse order
        System.out.println(list1.stream().sorted((x,y)-> y-x).toList());

        //7. How do you limit a stream to the first 5 elements?
        System.out.println(Stream.iterate(1,x->x+1).limit(5).toList());

        //8. How do you skip the first 3 elements in a stream?
        System.out.println(Stream.iterate(1,x->x+1).skip(3).limit(10).toList());

        //9. How do you find the first element of a stream?
        System.out.println(list1.stream().findFirst().get().intValue());

        //10. How do you check if all elements in a stream match a given condition?
        List <Integer> even =  Arrays.asList(2,4,6,8,10);
        System.out.println(even.stream().allMatch(x->x%2 == 0));

        //11. How do you check if any element in a stream matches a given condition?
        System.out.println(even.stream().anyMatch(x->x%2!=0));

        //12. How do you remove duplicate elements from a list using streams?
        System.out.println(list1.stream().distinct().toList());

        //13. How do you collect elements from a stream into a Set?
        System.out.println(list1.stream().filter(x->x%2==0).collect(Collectors.toSet()));

        //14. How do you generate an infinite stream of random numbers?
        Random random = new Random();
        Stream<Integer> stream1 = Stream.generate(random::nextInt).limit(10);
        System.out.println(stream1.toList());

        //15. How do you create a stream from an array?
        int[] arr = {1,2,3,4,5,6,7};
        Stream<Integer> stream = Arrays.stream(arr).boxed();
        System.out.println(stream.toList());
    }
}
