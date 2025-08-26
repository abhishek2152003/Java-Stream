import java.util.List;
import java.util.function.Predicate;

public class Java8 {

    public static void main(String[] args) {
        //Predicate:  a predicate is a function that takes an argument and returns a boolean value

        //Basic Lambda Predicate
        Predicate<String> startswithA = x->x.startsWith("A");
        //Method Reference Predicate
        Predicate<String>isEmpty = String::isEmpty;
        //Logical Operator AND, OR, NOT
        Predicate<String> lengthGreaterThan5 = x->x.length()>5;
        System.out.println(isEmpty.test(""));
        System.out.println(startswithA.or(lengthGreaterThan5).test("Apples"));
        System.out.println(startswithA.and(lengthGreaterThan5).test("Super"));
        System.out.println(startswithA.negate().test("Banana"));






    }
}
