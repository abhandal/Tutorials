package adapter;

import java.util.Iterator;

public class CollectionLibrary {

public static <E> String elementsToString(Iterator<E> iterator) {
    StringBuilder stringBuilder = new StringBuilder();
    while(iterator.hasNext()) {
        E e = iterator.next();
        stringBuilder.append(e.toString()).append("\n");
    }
    return stringBuilder.toString();
}
}
