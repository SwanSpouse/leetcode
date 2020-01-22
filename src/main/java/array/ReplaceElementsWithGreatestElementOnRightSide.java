package array;

class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int rightMax = -1;
        for(int i = arr.length-1; i >= 0; i --)  {
            if(i == arr.length -1) {
                rightMax = Math.max(rightMax, arr[i]);
                arr[i] = -1;
                continue ;
            } 
            int temp = Math.max(rightMax, arr[i]);
            arr[i] = rightMax;
            rightMax = temp;
        }
        return arr;
    }
}