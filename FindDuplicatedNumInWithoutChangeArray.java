
/*
 * 問題描述：給定數組，數字範圍是0~n-1,不修改原數組前提下，找出重複的數字。
 * 特性：若数组中没有重复元素，则[x,y]范围内的数字个数为y-x+1,若超出这个个数,则说明有重复的数字。
 * （本解題思路帶有局限性）
 */
public class FindDuplicatedNumInWithoutChangeArray {

	/*
	 * 方法说明：对于范围在1~n-1范围的数字，统计1-n-1的数字个数，超过n-1-1+1就说明有重复
	 * 分半，继续查找，直到start = end
	 */
	public int duplicate(int[] array) {

		// 判断数组的输入合法性
		if (array == null || array.length <= 0) {
			return -1;
		}
		//数字范围
		int start = 1;
		int end = array.length - 1;
		
		while(start <= end) {
			//更新中间数字，使用>>2防止溢出
			int mid = start + ((end - start)>>2);
			int count = countRange(array, start, end);
			
			if(start == end) {
				if(count>1)
				{
					return start;
				}else {
					break;
				}
				
			}
			
			if(count > (mid - start+1)) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}						
		return -1;
	}
	
	/*
	 * 对指定范围内的数字进行统计
	 */
	public int countRange(int[] array, int start, int end) {
		
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i]<=end && array[i] >= start) {
				count++;
			}
		}
		
		return count;
	}
}
