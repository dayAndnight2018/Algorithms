//小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的
//和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,
//你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
import java.util.ArrayList;
public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer> > FindSequence(int sum) {
      
       ArrayList<ArrayList<Integer> >result = new ArrayList<ArrayList<Integer> >();
       
       //找到和的一半就可以啦,因为至少两个数。
       int ex = sum/2;
        
        for( int i=1;i<=ex;i++)
        {
            int temp = i;
            int flag = i;
            //累计值大于sum就移动到下一个位置
            while(temp<sum)
            {
                flag++;
                temp += flag;
                
                if(temp == sum)
                {
                     ArrayList<Integer> list = new ArrayList<Integer>();
                     for(int k = i;k<= flag;k++)
                     {
                         list.add(k);
                     }
                    result.add(list);
                }                
            }
        }
        return result;
    }
}
