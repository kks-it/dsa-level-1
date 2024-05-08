
// Question Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

public class _16FirstAndLastIndexLCGQ {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8; 

        searchRange(nums, target);
    }

    

    public static void searchRange(int[] nums, int target) {
        int low = 0, first = -1, last = -1;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] == target){
                first = mid;
                high = mid - 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        low = 0; high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] == target){
                last = mid;
                low = mid + 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        System.out.println(first);
        System.out.println(last);
    }
}
