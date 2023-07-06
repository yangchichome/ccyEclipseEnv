package leetcode;

public class leet303 {

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
    private int[] array;

    public NumArray(int[] nums) {
        int n = nums.length;
        array = new int[n]; 
        bit = new BinaryIndexedTree(n+1);
        for (int i=0; i<n; i++){
            bit.update(i+1, nums[i]);
            array[i] = nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return bit.query(right+1) - bit.query(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */