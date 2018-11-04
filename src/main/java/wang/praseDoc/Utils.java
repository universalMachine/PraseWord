package wang.praseDoc;

import java.util.ArrayList;

public class Utils {

    public static <T> ArrayList<T> createArrayList(T ... elements) {
        ArrayList<T> list = new ArrayList<T>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }
}
