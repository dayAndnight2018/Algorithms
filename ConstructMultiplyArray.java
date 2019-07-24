//构建乘积数组
import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        
        if(A == null || A.length <= 1){
            return new int[0];
        }
        
        int len = A.length;
        //构建前向累乘数组
        int [] front = new int[len];
        //构建后向累乘数组
        int [] back = new int[len];
        
        front[0] = 1;
        back[len-1] = 1;
        for(int i = 1;i<= len - 1; i++){
            front[i] = front[i-1]*A[i-1];
        }
        for(int j = len -2;j >= 0; j--){
            back[j] = back[j+1]*A[j+1];
        }
        
        int[] result = new int[len];
        for(int k = 0; k< len;k++){
            result[k] = front[k] * back[k];
        }
        
        return result;
    }
}
