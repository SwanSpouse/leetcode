package sort_and_search;

class  ElementAppearingMoreThan25InSortedArray {
    public int findSpecialInteger(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        int count = 1;
        for(int i =1; i < arr.length; i ++) {
            if(arr[i] == arr[i-1]) {
                count += 1;
                if(count > arr.length / 4) {
                    return arr[i];
                }
            } else {
                count = 1;
            }
        }
        return arr[arr.length-1];
    }
}