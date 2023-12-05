import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayFilterTest {

    @Test
    void testStringFilter() {
        String[] stringArray = {"apple", "banana", "grape", "orange"};
        Filter<String> stringFilter = new Filter<String>() {
            @Override
            public boolean apply(String s) {
                return s.startsWith("a");
            }
        };

        String[] expected = {"apple", "banana"};
        String[] filteredStrings = GenericArrayFilter.filter(stringArray, stringFilter);

        assertArrayEquals(expected, filteredStrings);
    }
}
