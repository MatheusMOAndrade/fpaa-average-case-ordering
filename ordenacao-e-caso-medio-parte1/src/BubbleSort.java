public class BubbleSort {

    private double countSwaps, countComparisons = 0;

    public int[] bubbleSort(int[] arrayOriginal) {

        int n = arrayOriginal.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arrayOriginal[j] > arrayOriginal[j + 1]) {
                    int aux = arrayOriginal[j];
                    arrayOriginal[j] = arrayOriginal[j + 1];
                    arrayOriginal[j + 1] = aux;
                    countSwaps++;
                }
                countComparisons++;
            }
        }

        return arrayOriginal;

    }

    public double getCountSwaps() {
        return countSwaps;
    }

    public double getCountComparisons() {
        return countComparisons;
    }
}
