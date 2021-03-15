package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class LambdaExample1 {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product(12,"lt",25000f));
        list.add(new Product(10,"sad",22400f));
        list.add(new Product(13,"sqt",30000f));
        list.add(new Product(9,"daw",35000f));

        Collections.sort(list,(p1,p2)->{
            return (int)(p1.price - p2.price) ;
        });
        list.forEach(product -> {
            System.out.println(product.name+" "+product.price);
        });
        Stream<Product> filtered_data = list.stream().filter(product -> product.price > 25000f);
        filtered_data.forEach(product -> {
            System.out.println(product.name+" "+product.price);
        });
    }
}
