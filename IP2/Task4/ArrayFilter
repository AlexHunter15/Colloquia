import java.util.ArrayList;
import java.util.List;

interface Filter {
    boolean apply(Object o);
}

public class ArrayFilter {

    public static Object[] filter(Object[] array, Filter filter) {
        List<Object> filteredList = new ArrayList<>();

        for (Object item : array) {
            if (filter.apply(item)) {
                filteredList.add(item);
            }
        }

        return filteredList.toArray();
    }

    public static void main(String[] args) {
        // Пример использования на строках
        String[] stringArray = {"apple", "banana", "grape", "orange"};
        Filter stringFilter = new Filter() {
            @Override
            public boolean apply(Object o) {
                return ((String) o).startsWith("a");
            }
        };

        Object[] filteredStrings = filter(stringArray, stringFilter);
        System.out.println("Filtered Strings:");
        for (Object str : filteredStrings) {
            System.out.println(str);
        }
    }
}
