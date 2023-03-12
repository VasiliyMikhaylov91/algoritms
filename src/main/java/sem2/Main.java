package sem2;

public class Main {
    public static void mergeSort(int[] numbers, int left, int right) {
        if (left == right)
            return;
        int mid = (left + right) / 2;
        mergeSort(numbers, left, mid);
        mergeSort(numbers, mid + 1, right);

        int[] buff = new int[numbers.length];

        int i = left, j = mid + 1, pos = left;
        while (i < mid + 1 && j < right + 1) {
            if (numbers[i] < numbers[j]) {
                buff[pos] = numbers[i];
                i++;
            } else {
                buff[pos] = numbers[j];
                j++;
            }
            pos++;
        }
        while (i < mid + 1) {
            buff[pos] = numbers[i];
            i++;
            pos++;
        }
        while (j < right + 1) {
            buff[pos] = numbers[j];
            j++;
            pos++;
        }
        for (int k = left; k <= right; k++)
            numbers[k] = buff[k];
    }

    public static int[] mergeSort(int[] numbers) { //O(N^2)
        mergeSort(numbers, 0, numbers.length - 1);
        return numbers;
    }

    public static void main(String[] args) {
        int N = 5;
        int numbers[] = new int [N];

    }
}
