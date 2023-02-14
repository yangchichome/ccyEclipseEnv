package leetcode;

public class SortIntegersII {

    /**
     * @param a: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] a) {
        // write your code here
        quickSort(a,0,a.length-1);
    }

    private void quickSort(int[] a,int start,int end){
        if (start >= end){
            return;
        }

        int left = start, right = end;
        int pivot = a[(start+end)/2];

        while(left <= right){
            while(left <= right && a[left] < pivot){
                left++;
            }
            while(left <= right && a[right] > pivot){
                right--;
            }
            if (left <= right){
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;

                left++;
                right--;
            }
        }
        quickSort(a,start,right);
        quickSort(a,left,end);
    }
}