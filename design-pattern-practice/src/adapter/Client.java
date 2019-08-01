package adapter;

import java.util.Iterator;
import java.util.StringTokenizer;

/*
Purpose:
The main use of this pattern is when a class that you need to use doesn't meet the requirements of an interface.
 */

public class Client {

    public static void run() {
        System.out.println("---------------------");
        System.out.println("Adapter pattern\n---------------------");
        AdapterClient("Hello world! My Friendly World");
    }

    private static void AdapterClient(String input) {
        StringTokenizer stringTokenizer = new StringTokenizer(input);

        Iterator<String> iterator = new TokenizerToIteratorAdapter(stringTokenizer);

        String output = CollectionLibrary.elementsToString(iterator);

        System.out.println(output);
    }
}
