package leetcode;

public class leet658 {

}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int[] temp = new int[k];

        int firstIndex = getFirstIndex(arr, x);
        getKClose(arr, k, firstIndex, x, temp);

        Arrays.sort(temp);
        for(int i=0; i<k; i++){
            result.add(temp[i]);
        }

        return result;
    }

    private int getFirstIndex(int[] arr, int x){
        int l = 0;
        int r = arr.length-1;
        while(l+1 < r){
            int mid = l + (r-l)/2;
            if (arr[mid] > x){
                r = mid;
            }else{
                l = mid;
            }
        }
        int delta1 = Math.abs(arr[l] - x);
        int delta2 = Math.abs(arr[r] - x);
        if (delta1 == delta2){
            return l;
        }else if (delta1 < delta2){
            return l;
        }
        return r;
    }

    private void getKClose(int[] arr, int k, int index, int target, int[] temp){
        int l = index;
        int r = index;
        int count = 0;
        while(count < k){
            if (l == r){
                temp[count++] = arr[l];
                l--;
                r++;
                continue;
            }
            if (l < 0){
                temp[count++] = arr[r];
                r++;
                continue;
            }
            if (r >= arr.length){
                temp[count++] = arr[l];
                l--;
                continue;
            }

            int abs1 = Math.abs(arr[l] - target);
            int abs2 = Math.abs(arr[r] - target);

            if (abs1 == abs2 || abs1 < abs2){
                temp[count++] = arr[l];
                l--;
            }else{
                temp[count++] = arr[r];
                r++;
            }
        }
    }
}