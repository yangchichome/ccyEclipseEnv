package leetcode;

public class leet307_BIT {

}
class BinaryIndexedTree {
    private int[] bit;

    public BinaryIndexedTree(int size) {
        bit = new int[size + 1];
    }

    public void update(int index, int value) {
        while (index < bit.length) {
            bit[index] += value;
            index += index & -index;
        }
    }

    public int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }
        return sum;
    }
}

class NumArray {
    private BinaryIndexedTree bit;
    private int[] nums2;

    public NumArray(int[] nums) {
        int n = nums.length;
        bit = new BinaryIndexedTree(n);
        nums2 = new int[n];
        for(int i=0; i<n; i++){
            bit.update(i+1, nums[i]);
            nums2[i] = nums[i];
        }
    }
    
    public void update(int i, int val) {
        bit.update(i+1, val - nums2[i]);
        nums2[i] = val;
    }
    
    public int sumRange(int left, int right) {
        return bit.query(right+1) - bit.query(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */