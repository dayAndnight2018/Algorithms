//字符流中第一个不重复的字符
public class FirstNotRepeatedCharInDataFlow {
    private static final int SIZE = 256;
    private int[] hashTable = new int[SIZE];
    private int index = 0;
    public Solution()
    {
        for(int i = 0;i<SIZE;i++)
        {
            hashTable[i] = -1;
        }
    }
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        //从未出现，标记位置
        if(hashTable[ch] == -1)
        {
            hashTable[ch] = index;
        }else{
            //出现过了，标记为-2
            hashTable[ch] = -2;
        }
        index++;
    }
   //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char c = '#';
        int minIndex = Integer.MAX_VALUE;
        for(int i = 0; i<SIZE; i++)
        {
            //对于出现一次的，并且位置最靠前的，输出
            if(hashTable[i] >= 0 && hashTable[i]<minIndex)
            {
                c = (char) i;
                minIndex = hashTable[i];
            }
        }
        
        return c;
    }
}
