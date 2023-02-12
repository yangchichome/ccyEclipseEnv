package leetcode;

public class SearchinaBigSortedArray {

    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int start = 0;
        int end = 1;
        while (reader.get(end) < target){
            end <<= 1;
        }
        System.out.println("end: "+end);
        while (start+1 < end) {
            int mid = start + (end-start)/2;
            System.out.println("mid: "+mid);
            if (reader.get(mid) > target) {
                end = mid;
            }else if (reader.get(mid) == target){
                end = mid;
            }else{
                start = mid;
            }
        }

        if (reader.get(start)==target){
            return start;
        }else if(reader.get(end)==target){
            return end;
        }else{
            return -1;
        }
    }
}