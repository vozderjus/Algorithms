import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void bucketSort(double[] values) {
        if (values.length < 2) {
            return;
        }

        int bucketCount = values.length;
        List<List<Double>> buckets = new ArrayList<>();

        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (double value : values) {
            int index = (int) (value * bucketCount);
            buckets.get(index).add(value);
        }

        for (List<Double> bucket : buckets) {
            insertionSort(bucket);
        }

        int position = 0;
        for (List<Double> bucket : buckets) {
            for (double value : bucket) {
                values[position++] = value;
            }
        }
    }

    private static void insertionSort(List<Double> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            double current = bucket.get(i);
            int j = i - 1;

            while (j >= 0 && bucket.get(j) > current) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }

            bucket.set(j + 1, current);
        }
    }

    public static void main(String[] args) {
        double[] first = {0.15, 0.75, 0.40, 0.05};
        double[] second = {0.60, 0.01, 0.61};

        bucketSort(first);
        bucketSort(second);

        System.out.println(Arrays.toString(first));
        System.out.println(Arrays.toString(second));
    }
}
