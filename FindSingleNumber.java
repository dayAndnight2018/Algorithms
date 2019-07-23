//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        
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
}
