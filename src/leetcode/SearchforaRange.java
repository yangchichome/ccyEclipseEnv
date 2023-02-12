package leetcode;

public class SearchforaRange {

    /**
     * @param a: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] a, int target) {
        // write your code here
        
        if (a==null ||a.length==0){
            
            return new int[]{-1,-1};
        }

        int starting = getStartIndex(a,target,true);
        int ending = getStartIndex(a,target,false);

        return new int[]{starting,ending};
    }

    public int getStartIndex(int[] a,int target,boolean getStart){
        int start = 0;
        int end = a.length-1;
        while(start+1 < end){
            int mid = start + (end-start)/2;
            if (a[mid] == target){
                if (getStart){
                    end = mid;
                }else{
                    start = mid;
                }
            }else if (a[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }

        if (a[start] != target && a[end] != target){
            return -1;
        }

        if (getStart){
            if (a[start] == target) return start;
            else return end;
        }else{
            if (a[end] == target) return end;
            else return start;
        }
    }
}