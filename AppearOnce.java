//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class AppearOnce {
    public void FindNums(int [] array,int num1[] , int num2[]) {
        
        num1[0] = -1;
        num2[0] = -1;
        if(array == null || array.length <= 0){
            return;
        }
        
        for(int i =0;i<array.length -1;i++)
        {
            boolean flag = false;
            for(int j = 0;j<array.length-1-i;j++)
            {
                if(array[j]>array[j+1])
                {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    flag = true;
                }               
            }
            if(!flag)
            {
               break;
            }
        }
        
        if(array[0] != array[1]){
            num1[0] = array[0];
        }
        if(array[array.length -2] != array[array.length -1])
        {
                if(num1[0] == -1)
                {
                    num1[0] = array[array.length -1];
                }
                else
                {
                    num2[0] = array[array.length -1];
                }
        }
        
        for(int i =1;i<array.length -1;i++)
        {
            if(array[i-1] != array[i] && array[i+1] != array[i]){
                if(num1[0] == -1)
                {
                    num1[0] = array[i];
                }
                else
                {
                    num2[0] = array[i];
                    break;
                }
            }
        }
        
    }
    
    
    public void FindNums2(int [] array,int num1[] , int num2[]) {

        if(array == null || array.length <= 0){
            return;
        }
        
        int xor = 0;
        for(int i = 0;i<array.length;i++){
            xor ^= array[i];
        }
        
        int indexOf1 = findFirst1_Bit(xor);
        
        for (int i = 0; i < array.length; i++) {
            if (is1_Bit(array[i], indexOf1)) {
                num1[0] = num1[0] ^ array[i];
            } else {
                num2[0] = num2[0] ^ array[i];
            }
        }
        
    }
    //找到为1的位置，a ^ a = 0,所以，xor的结果是x ^ y
    private int findFirst1_Bit(int num) {
        int index = 0;
        //int类型
        int len = 8 * 4;
        while (index < len && (num & 1) == 0) {
            num = num >> 1;
            index++;
        }
        return index;
    }
    
    // 判断从右到左第index位是不是1
    private boolean is1_Bit(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }
}
