import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

public class App {

    private static String path = "C:\\Codes\\FPAA\\ordenacao-e-caso-medio-parte1\\src\\MetricsFile.txt";

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new FileWriter(path));

        int n = 50;

        double[] bubbleComparisons = new double[n];
        double[] bubbleSwaps = new double[n];
        double[] selectionComparisons = new double[n];
        double[] selectionSwaps = new double[n];

        /**
         * Repitição das operações 50 vezes
         */
        for (int i = 0; i < n; i++) {

            BubbleSort bubble = new BubbleSort();
            SelectionSort selection = new SelectionSort();

            int[] arrayOriginal = createRandomArray(i);
            int[] arrayCopy = arrayOriginal.clone();

            bubble.bubbleSort(arrayOriginal);
            bubbleComparisons[i] = bubble.getCountComparisons();
            bubbleSwaps[i] = bubble.getCountSwaps();

            selection.selectionSort(arrayCopy);
            selectionComparisons[i] = selection.getCountComparisons();
            selectionSwaps[i] = selection.getCountSwaps();
        }

        /** Bubble sort metrics streams - START */
        double maxBubbleComparisons = Arrays.stream(bubbleComparisons).max().getAsDouble();
        double minBubbleComparisons = Arrays.stream(bubbleComparisons).min().getAsDouble();
        double avgBubbleComparisons = Arrays.stream(bubbleComparisons).average().orElse(Double.NaN);
        double maxBubbleSwaps = Arrays.stream(bubbleSwaps).max().getAsDouble();
        double minBubbleSwaps = Arrays.stream(bubbleSwaps).min().getAsDouble();
        double avgBubbleSwaps = Arrays.stream(bubbleSwaps).average().orElse(Double.NaN);
        /** Bubble sort metrics - START */

        /** Selection sort metrics streams - START */
        double maxSelectionComparisons = Arrays.stream(selectionComparisons).max().getAsDouble();
        double minSelectionComparisons = Arrays.stream(selectionComparisons).min().getAsDouble();
        double avgSelectionComparisons = Arrays.stream(selectionComparisons).average().orElse(Double.NaN);
        double maxSelectionSwaps = Arrays.stream(selectionSwaps).max().getAsDouble();
        double minSelectionSwaps = Arrays.stream(selectionSwaps).min().getAsDouble();
        double avgSelectionSwaps = Arrays.stream(selectionSwaps).average().orElse(Double.NaN);
        /** Selection sort metrics - END */

        StringBuilder metrics = new StringBuilder("\n--> METRICS");
        metrics.append("\n----------------------------------");
        metrics.append(
                "\nBubble sort metrics:"
                        + "\n"
                        + "\nBubble Sort - Max Comparisons: " + maxBubbleComparisons
                        + "\nBubble Sort - Min Comparisons: " + minBubbleComparisons
                        + "\nBubble Sort - Average Comparisons: " + avgBubbleComparisons
                        + "\nBubble Sort - Max Swaps: " + maxBubbleSwaps
                        + "\nBubble Sort - Min Swaps: " + minBubbleSwaps
                        + "\nBubble Sort - Average Swaps: " + avgBubbleSwaps
                        + "\n"
                        + "\n----------------------------------"
                        + "\nSelection sort metrics:"
                        + "\n"
                        + "\nSelection Sort - Max Comparisons: " + maxSelectionComparisons
                        + "\nSelection Sort - Min Comparisons: " + minSelectionComparisons
                        + "\nSelection Sort - Average Comparisons: " + avgSelectionComparisons
                        + "\nSelection Sort - Max Swaps: " + maxSelectionSwaps
                        + "\nSelection Sort - Min Swaps: " + minSelectionSwaps
                        + "\nSelection Sort - Average Swaps: " + avgSelectionSwaps);

        bw.write(metrics.toString());
        bw.newLine();
        bw.close();

    }

    /*
     * método para gerar um vetor contendo 100.000 valores inteiros aleatórios, sem
     * repetição
     */
    private static int[] createRandomArray(int n) {

        Random rand = new Random();
        int randArray[] = new int[100000];
        int i = 0;

        while (i < randArray.length) {
            int numb = rand.nextInt();

            boolean containsVerify = Arrays.asList(randArray).contains(numb);

            if (!containsVerify) {
                randArray[i] = numb;
                i++;
            }
        }

        return randArray;
    }

}
