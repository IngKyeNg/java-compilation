package methodreference;

interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

public class CustomMethodReference {
    
    Integer doSum(String s1, String s2) {
        return Integer.parseInt(s1) + Integer.parseInt(s1);
    }
    
    public static void main(String[] args) {
        TriFunction<CustomMethodReference, String, String, Integer> anon
            = new TriFunction<CustomMethodReference, String, String, Integer>() {
            public Integer apply(CustomMethodReference s, String arg1, String arg2) {
                return s.doSum(arg1, arg2);
            }
        };
    System.out.println(anon.apply(new CustomMethodReference(), "1","4"));

    //using Lambda Expression
    TriFunction<CustomMethodReference, String, String, Integer> lambda
        = (CustomMethodReference s, String arg1, String arg2)
            -> s.doSum(arg1, arg2);
    
    System.out.println(lambda.apply(new CustomMethodReference(), "1","4"));
    
    //using method reference
    TriFunction<CustomMethodReference, String, String, Integer> mRef
        = CustomMethodReference::doSum;
    System.out.println(mRef.apply(new CustomMethodReference(), "1","4"));
    }
}
