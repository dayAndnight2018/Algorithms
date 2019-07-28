//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
//由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length<=0)return 0;
        
        int most = array[0];
        int num = 1;
        //逐个遍历一下，与前面相同+1，不同-1，等于0就重置1，看最后那个置为1的那个数就是超过一半的数，检验一下即可
        for(int i = 1;i<array.length;i++)
        {
            if(num == 0)
            {
                most = array[i];
                num = 1;
            }
            else if(array[i] == most)
            {
                num++;
            }
            else
            {
                num--;
            }
        }
        
        //检验
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == most) {
                times++;
            }
        }
        if(times <= array.length / 2)
            return 0;
        return most;
    }
}
