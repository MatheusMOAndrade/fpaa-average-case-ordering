public class LinearSearch {

    public int linearSearch(int[] array, int inputNumb) {

        int position = 11001;

        for(int i = 0; i<array.length; i++) {
            if (array[i] == inputNumb) {
                position = i;
                break;
            }
        }

        return position;
    }



}
