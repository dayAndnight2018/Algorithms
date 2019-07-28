//对输入数组找到最大的子数组
public class MaxSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length <=0)
        {
            return -1;    
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0;i<array.length;i++)
        {
            if(sum <= 0)
                sum = array[i];
            else
                sum += array[i];
            if(sum > max)
                max = sum;
                
        }
        
        return max;
    }
}
