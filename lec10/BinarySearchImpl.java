public class BinarySearchImpl {
    public static int binarySearch(int[] data, int target, int low, int high) {
        if (low > high) return -1;
        //1. calculate mid value

        int mid = (low + high) / 2;
        //2. handle 3 cases: equal to, lesser than, greater than
        if (data[mid] == target) {
            return mid;
        } else if (target < data[mid]) {
            return binarySearch(data, target, low, mid-1);
        } else {
            return binarySearch(data, target, mid+1, high);
        }

        //3. did we handle the case where target is not in data?
        
    }

    public static int binarySearch(int[] data, int target) {
        return binarySearch(data, target, 0, data.length);
    }

}
