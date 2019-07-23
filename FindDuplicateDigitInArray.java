import java.util.HashMap;

/*
  * 问题描述：在一个长度为n的数组中所有的数字范围均是0~n-1，但是存在重复的数字
  *  不知道重复的是哪几个数字，也不知重复了几次。请找出其中一个重复的数字
 *
  * 样例：
 * 
  * 输入{2,3,1,0,2,5,3}，期望输出是2或3 
 *  
 */
public class FindDuplicateDigitInArray {

	// 第一种方法，利用HashMap，不存在的数字存储进去，否则就是出现重复了
	// 时间复杂度O(n),空间复杂度O(n)
	public int findNumber(int[] array) {

		// 判断数组的输入合法性
		if (array == null || array.length <= 0) {
			return -1;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {
			// 如果不存在，添加到map中，否则就已经重复了
			if (!map.containsKey(array[i])) {
				map.put(array[i], 1);
			} else {
				return array[i];
			}
		}

		return -1;
	}

	// 第二种方法，利用额外的空间进行计数，统计不同数字的个数，大于1就是重复的
	// 时间复杂度O(n),空间复杂度O(n)
	public int findNumber2(int[] array) {

		// 判断数组的输入合法性
		if (array == null || array.length <= 0) {
			return -1;
		}

		int[] book = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			book[array[i]]++;
		}

		for (int j = 0; j < book.length; j++) {
			if (array[j] > 1) {
				return j;
			}
		}

		return -1;
	}

	// 第三种方法，如果對1~n-1的數字進行排序，正確的順序是第i個位置上元素就是i，否則就是出現了重複
	// 时间复杂度O(n),空间复杂度O(1)
	public int findNumber3(int[] array) {

		// 判断数组的输入合法性
		if (array == null || array.length <= 0) {
			return -1;
		}

		for(int i = 0; i < array.length; i++) {
			while(array[i] != i) {
				if(array[i] == array[array[i]]) {
					return array[i];
				}
				
				int temp = array[i];
				array[i] = array[temp];
				array[temp] = temp;
			}
		}
		
		return -1;
	}

}
