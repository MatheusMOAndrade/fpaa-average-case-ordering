import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class App {

    private static String path = "C:\\Codes\\FPAA\\ordenacao-e-caso-medio-parte2\\src\\MetricsFile.txt";

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new FileWriter(path));

        int n = 1000000;
        int count = 0;
        int sum = 0;
        int j = 0;

        int[] countGruops = new int[n/500];

        for (int i = 0; i < n; i++) {

            int[] newArray = createArray();
            int numb = numberDraft();
            LinearSearch ls = new LinearSearch();
            int numbPosition = ls.linearSearch(newArray, numb);

            count++;

            if (count < 500) {
                sum += numbPosition;
            } else {
                countGruops[j] = sum;
                j++;
                count = 0;
                sum = 0;
            }
        }

        for(int i = 0; i < countGruops.length; i++) {
            bw.write("" + countGruops[i]);
            bw.newLine();
        }

        bw.close();
    }

    /*
     * gerar um vetor contendo 10.000 valores
     * inteiros, iniciando em 1 e indo até 10.000 na ordem
     */
    private static int[] createArray() {

        int array[] = new int[10000];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        return array;
    }

    /**
     * Sortear um número aleatório entre 1 e 11000
     */
    private static int numberDraft() {

        Random rand = new Random();

        int numb = rand.nextInt(11000) + 1;

        return numb;
    }

}
