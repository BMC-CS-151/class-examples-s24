import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); //note the ADT
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        System.out.println(list); //what will this print? what if we were using a raw array?

        for (int i=0; i < 10000; i++) {
            if (i == 100) {
                list.add("kiwi");
            }

            list.add("fruit " + i);
        }
        //TODO: add 10,000 more fruits (expandable!)
        //make one of them "kiwi"

        //TODO: loop over and check if any are a kiwi. If so, print "FOUND IT"


        for (int i=0; i < list.size(); i++) {
            if(list.get(i).equals("kiwi")) {
                System.out.println("found it!");
            }

         }
        
    }
}

