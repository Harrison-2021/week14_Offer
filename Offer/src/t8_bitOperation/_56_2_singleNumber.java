package t8_bitOperation;

/**
 * @author ls2690069470
 *	Offer 56 - II. 数组中数字出现的次数 II
 */
public class _56_2_singleNumber {
	// 同样用位运算，根据出现三次的规律，三次中的每位数整除3都为零，只出现一次的非零位整除三不为零
	// 找到区别后，需要将所有数的所有位的数都累加，单个区分不好处理，就先整体拿下
	// 记录好每位累加的结果整除三的结果，要么是1，要么是0，组成的数就是要找的数
	public int singleNumber(int[] nums) {
		int[] sumBits = new int[32];
		for(int i = 0; i < nums.length; i ++) {
//			int bitMask = 1;
			for(int j = 0; j < 32; j ++) {
				sumBits[j] += nums[i] & 1;
//				if(bit != 0) {
//					sumBits[j] += 1;
//				}
//				bitMask <<= 1;
				nums[i] >>>= 1;
			}
		}
		int res = 0; // 要恢复原数，要左移多出0，在0上面处理是1或是零，用或，加都行
		for(int i = 0; i < 32; i ++) {
			res <<= 1;
			res += sumBits[31 - i] % 3; // 每次处理的都是高位，低位下次位运算空出零再处理
			//res <<= 1;  	 顺序不能错了，要先位运算，再处理空位0的问题，否则返回的值多了一位
		}
		return res;
	}
}
