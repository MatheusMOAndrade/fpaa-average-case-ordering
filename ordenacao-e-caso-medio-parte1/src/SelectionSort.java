public class SelectionSort {

    private double countSwaps, countComparisons = 0;

    public int[] selectionSort(int[] arrayCopy) {

        int n = arrayCopy.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (arrayCopy[j] < arrayCopy[minIndex]) {
                    minIndex = j;
                }
                countComparisons++;
            }

            int aux = arrayCopy[i];
            arrayCopy[i] = arrayCopy[minIndex];
            arrayCopy[minIndex] = aux;
            countSwaps++;
        }

        return arrayCopy;

    }

    public double getCountSwaps() {
        return countSwaps;
    }

    public double getCountComparisons() {
        return countComparisons;
    }
 
}
