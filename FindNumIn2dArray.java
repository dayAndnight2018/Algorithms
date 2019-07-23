/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindNumIn2dArray {

	public boolean findNumber(int[][] array, int target) {
		
		//判断数组的合法性
		if (array == null || array.length <= 0) {
            return false;
        }
		
		//将指针放置在右上角的位置
		int row = 0;
		int col = array[0].length -1;
		//一旦元素比目标小，指针下移，比目标大，指针左移
		while(row<array.length && col >= 0) {
			if(array[row][col] == target) {
				return true;
			}else if(array[row][col] < target) {
				row++;
			}else {
				col--;
			}
		}
		
		return false;
	}
}
