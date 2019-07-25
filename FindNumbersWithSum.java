//输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
import java.util.ArrayList;
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbers(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (array == null || array.length <= 1) return result;
        //一个指针指向最小数位置，一个指针指向最大的数位置，和大了第二个指针左移，和小了，第一个指针右移
        int low = 0;
        int high = array.length -1;
        int tempSum = 0;
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        
        boolean flag = false;
        
        while(low < high){
            tempSum = array[low]+array[high];
            if(tempSum == sum){
                leftList.add(array[low]);
                rightList.add(array[high]);
                high--;
                low++;
                flag = true;
            }else if(tempSum<sum){
                low++;
            }
            else{
                high--;
            }
        }
        
        if(!flag){
            return result;
        }
        
        //计算积最小的那对数
        int min = Integer.MAX_VALUE;
        int minLeft = -1;
        int minRight = -1;
        for (int i = 0; i < leftList.size(); i++) {
            int tmp = leftList.get(i) * rightList.get(i);
            if (tmp < min) {
                min = tmp;
                minLeft = leftList.get(i);
                minRight = rightList.get(i);
            }
        }
        
        result.add(minLeft);
        result.add(minRight);
        
        return result;
    }
}
