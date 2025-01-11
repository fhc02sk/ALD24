package A07_Sorting;

public class BubbleSortDemo {
    public static void main(String[] args) {

        int max = 31_250;
        int[] array = new int[max];

        for (int i = 0; i < max; i++){
            array[i] = max - i;
        }

        for (int i = 0; i < 100; i++)
            System.out.println(array[i]);

        System.out.println("START");

        sort(array);
        System.out.println("fertig");

        for (int i = 0; i < 100; i++)
            System.out.println(array[i]);
    }

    public static void sort(int[] numbers) {

        boolean hasSwapped = false;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {

                hasSwapped = true;
                int tmp = numbers[i];
                numbers[i] = numbers[i + 1];
                numbers[i + 1] = tmp;
            }
        }

        if (hasSwapped)
            sort(numbers);
    }
}
