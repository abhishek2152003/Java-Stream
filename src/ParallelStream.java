import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStream {

    public static void main(String[] args) {

        //Parallel streams in Java allow you to process collections and other data sources using multiple threads,
        // potentially improving performance for computationally intensive operations on large datasets.

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream stream1 = numbers.parallelStream(); // Using parallelStream()
        Stream stream2 = numbers.stream().parallel(); // Using stream().parallel()

        int []array = {12,3,4,5,6,7};
        System.out.println(Arrays.stream(array).parallel());

        //Example
        List <Integer> list = Stream.iterate(0,x->x+1)
                .limit(100000)
                .toList();
        long startTime = System.currentTimeMillis();
        List<Long> factorial = list.stream()
                .map(ParallelStream::factorial)
                .toList();
        long sequentialTime = System.currentTimeMillis() -startTime;

        startTime = System.currentTimeMillis();
        List<Long> parallelFactorial = list.stream()
                .parallel()
                .map(ParallelStream::factorial)
                .toList();
        long parallelTime = System.currentTimeMillis() -startTime;


        System.out.println(" Sequential Time: "+sequentialTime);
        System.out.println(" Parallel Time: "+parallelTime);


    }

    private static long factorial(int num) {
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
}
