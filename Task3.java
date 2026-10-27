import java.util.Arrays;

public class Task3 {
    public static void radixSort(int[] numbers) {
        if (numbers.length < 2) {
            return;
        }

        // Находим максимум, чтобы определить число разрядов.
        int max = 0;
        for (int number : numbers) {
            max = Math.max(max, number);
        }

        int[] output = new int[numbers.length];

        // place: 1 — единицы, 10 — десятки, 100 — сотни...
        for (int place = 1; max / place > 0; place *= 10) {
            countingSortByDigit(numbers, output, place);
        }
    }

    private static void countingSortByDigit(int[] numbers, int[] output, int place) {

        int[] count = new int[10];

        // 1. Подсчитываем цифры выбранного разряда.
        for (int number : numbers) {
            int digit = (number / place) % 10;
            count[digit]++;
        }

        // 2. Вычисляем накопленные суммы.
        for (int digit = 1; digit < 10; digit++) {
            count[digit] += count[digit - 1];
        }

        // 3. Расставляем числа, сохраняя порядок при равных цифрах.
        for (int i = numbers.length - 1; i >= 0; i--) {
            int digit = (numbers[i] / place) % 10;

            count[digit]--;
            output[count[digit]] = numbers[i];
        }

        // 4. Копируем результат прохода обратно.
        System.arraycopy(output, 0, numbers, 0, numbers.length);
    }

    public static void main(String[] args) {
        int[] first = {100000001, 7, 900000000};
        int[] second = {42, 420, 402};

        radixSort(first);
        radixSort(second);

        System.out.println(Arrays.toString(first));
        System.out.println(Arrays.toString(second));
    }
}
