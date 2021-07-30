package t6_select;

public class Offer21 {
	int[] arr;
	
	// 空间O(n),另辟空间
	public int[] exchange(int[] nums) {
		arr = new int[nums.length];
		int i = 0;
		for(int k : nums) {
			if(k % 2 == 1) {
				arr[i++] = k;
			}
		}
		
		for(int k : nums) {
			if(k % 2 == 0) {
				arr[i++] = k;
			}
		}
		return arr;
    }
	
	// 原地查找
	public int[] exchange2(int[] nums) {
		int left = 0, right = nums.length -1;
		
		while(left < right) {
			if(nums[left] % 2 == 1) {
				left ++;
			} else if(nums[left] % 2 == 0) {
				if(nums[right] % 2 == 1) {
					int t = nums[left];
					nums[left] = nums[right];
					nums[right] = t;
					left ++;
					right --;
				} else if(nums[right] % 2 == 0) {
					right --;
				}
			}
		}
		
		return nums;
    }
		
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] arr = new Offer21().exchange2(nums);
		for(int i = 0; i < arr.length; i ++) {
			System.out.println(arr[i]);
		}
		
	}	
}