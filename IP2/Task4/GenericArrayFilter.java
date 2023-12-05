import java.util.ArrayList;
import java.util.List;

interface Filter<T> {
    boolean apply(T t);
}

public class GenericArrayFilter {

    public static <T> T[] filter(T[] array, Filter<T> filter) {
        List<T> filteredList = new ArrayList<>();

        for (T item : array) {
            if (filter.apply(item)) {
                filteredList.add(item);
            }
        }

        //noinspection unchecked
        return (T[]) filteredList.toArray(new Object[0]);
    }

    public static void main(String[] args) {
        // Пример использования на строках
        String[] stringArray = {"apple", "banana", "grape", "orange"};
        Filter<String> stringFilter = new Filter<String>() {
            @Override
            public boolean apply(String s) {
                return s.startsWith("a");
            }
        };

        String[] filteredStrings = filter(stringArray, stringFilter);
        System.out.println("Filtered Strings:");
        for (String str : filteredStrings) {
            System.out.println(str);
        }
    }
}
