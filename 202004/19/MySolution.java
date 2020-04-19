import java.util.Arrays;

public class MySolution {
    public static String string;
    public static void main(String[] args) {
        // int[] nums = {4,5,6,7,0,1,2};
        // int[] nums = {1,3};
        int[] nums = {9,0,2,7,8};
        // int[] nums = {3,1};
        System.out.println("Min: " + min(nums, 0, nums.length - 1));
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            if(target == nums[0]){
                return 0;
            }else{
                return -1;
            }
        }
        int min = min(nums, 0, nums.length - 1);
        if (nums[min] == target) {
            return min;
        }else if (target < nums[min]) {
            return -1;
        }else if (target <= nums[nums.length - 1]) {
            return match(nums, min, nums.length - 1, target);
        }else if (target >= nums[0]) {
            return match(nums, 0, min, target);
        }else{
            return -1;
        }
    }

    public static int min(int[] nums, int lower, int upper) {
        if(nums.length == 1){
            return 0;
        }
        // System.out.println("min");
        // System.out.println(Arrays.toString(nums));
        // System.out.println(lower + " " + upper);

        if (nums[lower] < nums[upper]) {
            return lower;
        } else if(lower == upper) {
            return lower;
        } else if (nums[(lower + upper) / 2] >= nums[lower]) {
            return min(nums, (lower + upper) / 2 + 1, upper);
        } else if (nums[(lower + upper) / 2] < nums[lower]) {
            return min(nums, lower, (lower + upper) / 2);
        }
        return -1;
    }

    public static int match(int[] nums, int lower, int upper, int target) {
        System.out.println("match");
        System.out.println(Arrays.toString(nums));
        System.out.println(lower + " " + upper);

        if(nums[(lower + upper)/2] == target){
            return (lower + upper)/2;
        }else if(lower == upper){
            return nums[lower] == target ? lower : -1;
        }else if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }else if(nums.length == 0){
            return -1;
        }else if(nums[(lower + upper)/2] > target){
            return match(nums, lower, (lower + upper)/2, target);
        }else if(nums[(lower + upper)/2] < target){
            return match(nums, (lower + upper)/2 + 1, upper, target);
        }
        return -1;
    }
}