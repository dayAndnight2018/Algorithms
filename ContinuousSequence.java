//LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)......
//他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
//“红心A,黑桃3,小王,大王,方片5”,不是顺子..他决定大小王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),
//现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
public class ContinuousSequence {
    public boolean isContinuous(int [] numbers) {
       if(numbers == null || numbers.length<=0)
       {
           return false;
       }
        
        for(int i =0;i<numbers.length -1;i++)
        {
            boolean flag = false;
            for(int j = 0;j<numbers.length-1-i;j++)
            {
                if(numbers[j]>numbers[j+1])
                {
                    int temp = numbers[j+1];
                    numbers[j+1] = numbers[j];
                    numbers[j] = temp;
                    flag = true;
                }               
            }
            if(!flag)
            {
               break;
            }
        }
        
        int zeros = 0;
        for(int i=0;i<numbers.length;i++)
        {
            if(numbers[i] == 0)
            {
                zeros ++;
            }
        } 
        boolean just = true;
        for(int i=0;i<numbers.length-1;i++)
        {
            if(numbers[i]!=0) 
            {
                if(numbers[i] == numbers[i+1])
                {
                    return false;
                }
                else if(numbers[i+1] - numbers[i] > 1)
                {
                    zeros -= numbers[i+1] - numbers[i] -1;
                }
                
            }
        } 
        if(zeros>=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
