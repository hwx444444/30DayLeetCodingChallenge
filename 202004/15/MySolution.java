import java.util.Arrays;

public class MySolution{
    public static void main(final String[] args) {
        final int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(nums));
        final int[] products = productExceptSelf(nums);
        System.out.println(Arrays.toString(products));
    }

    public static int[] productExceptSelf(final int[] nums) {
        final int[] products = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int product = 1;
            for(int j = 0; j < nums.length; j++){
                if(i != j){
                    product = product * nums[j];
                }
            }
            products[i] = product;
        }
        return products;
    }
}