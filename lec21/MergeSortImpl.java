public class MergeSortImpl {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        //create A and B and fill them 
        int[] A = new int[n1];
        int[] B = new int[n2];

        for (int i = 0; i < n1; ++i) {
            A[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            B[j] = array[mid + 1 + j];
        }

        int i = 0; //use i as the marker in A 
        int j = 0; //use j as the marker in B

        //instead of using S, we update array directly
        int k = left; 
        while (i < A.length && j < B.length) {
            if (A[i] <= B[j]) {
                array[k] = A[i];
                i++;
            } else {
                array[k] = B[j];
                j++;
            }
            k++;
        }

        while (i < A.length) {
            array[k] = A[i];
            i++;
            k++;
        }

        while (j < B.length) {
            array[k] = B[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Unsorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();


        mergeSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

}
