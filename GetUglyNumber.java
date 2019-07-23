import java.util.ArrayList;
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0){
            return 0;
        }
        int[] uglys = new int[index];
        uglys[0] = 1;
        int next = 1;
        int index2 = 0,index3 = 0, index5 = 0;
        
        while(next<index){
            //取前一个丑数的2倍，3倍，5倍，取最小的。
            int temp = Min(uglys[index2]*2, uglys[index3]*3, uglys[index5]*5);
            uglys[next] = temp;
            
            while(uglys[index2]*2 <= temp){
                index2++;
            }
            
            while(uglys[index3]*3 <= temp){
                index3++;
            }
            
            while(uglys[index5]*5 <= temp){
                index5++;
            }
            
            next++;
        }
        
        return uglys[--next];
    }
    
    public int Min(int x, int y, int z){
        int min = x < y ? x : y;
        return min < z ? min :z;
    }
}
