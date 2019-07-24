//给定一个数组表示股票的价格，计算最大利润。

public class MaxProfit{
    public int calc(int[] array){
        if (array == null || array.length < 2) {
            return -1;
        }
        //最低价格
        int min = array[0];
        //最大利润
        int profit = array[1] - array[0];
        for(int i = 2; i < array.length; i++){
            //更新最低价格
            if(array[i-1]<min){
                min = array[i-1];
            }
            //更新最大利润
            if(array[i] - min > profit){
                profit = array[i] - min;
            }
        }
        
        return profit;
    }

}
