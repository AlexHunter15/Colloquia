import java.util.function.Function;

public class ArrayFiller {

    public static <T> void fill(T[] array, Function<Integer, T> function) {
        for (int i = 0; i < array.length; i++) {
            array[i] = function.apply(i);
        }
    }

    public static void main(String[] args) {
        Integer[] squares = new Integer[100];
        fill(squares, integer -> integer * integer);

        // Выводим первые несколько элементов массива для проверки
        for (int i = 0; i < 5; i++) {
            System.out.print(squares[i] + " ");
        }
        System.out.println(); // Новая строка
    }
}
