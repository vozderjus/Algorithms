import java.util.Arrays;

public class Task1 {
    static void CountingSort(int[] grades) {
        int[] count = new int[101];

        for (int grade : grades) {
            count[grade]++;
        }

        int position = 0;

        for (int grade = 0; grade < count.length; grade++) {
            for (int repeat = 0; repeat < count[grade]; repeat++) {
                grades[position] = grade;
                position++;
            }
        }
    }

    public static void main(String[] args) {
        int[] grades = {4, 2, 4, 1, 0};

        CountingSort(grades);

        System.out.println(Arrays.toString(grades));
    }
}
