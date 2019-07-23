/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {
	
	/**
	 *解题思路：使用二分法对范围进行缩小。
	 *一个指针指向首元素，一个指针指向尾元素。
	 *当前后的位置相差1，说明后面的这个数就是最小的。
	 *当首位置，末位置，中间位置元素一样，需要挨个查找
	 *当中间位置元素比首位置元素大，移动第一个指针
	 *当中间位置元素比末位置元素小，移动第二个指针 
	 *
	 * @param array
	 * @return
	 */
	public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length<=0)
        {
            return 0;
        }
        
        int low = 0;
        int high = array.length -1;
        int mid = 0;
        while(array[low] >= array[high]){
            if(high - low == 1){
                mid = high;
                break;
            }
            
            mid = (low + high)/2;
            
            if(array[low] == array[high] && array[low] == array[mid]){
                return Min(array,low,high);
            }
            
            if(array[low]<= array[mid]){
                low = mid;
            }
            
            if(array[high]>= array[mid]){
                high = mid;
            }
        }
        
        return array[mid];
    }
    
    public int Min(int[] array, int start, int end){
        
        int min = array[start];
        for(int i =start +1; i<= end; i++){
            if(array[i]<min){
                min = array[i];
            }
        }
        
        return min;
    }
}
