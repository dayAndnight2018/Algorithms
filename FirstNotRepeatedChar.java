//在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
public class FirstNotRepeatedCharInDataFlow {
    public int FirstNotRepeatingChar(String str) {
        int len = str.length();
        
        //大写字母65-90 小写字母97-122
        int[] list = new int[123];
        for(int c: list)
        {
            c = 0;
        }
        //统计字符个数
        for(int i = 0;i< len;i++)
        {
            list[str.charAt(i)]++;
        }
        
        int index  = -1;
        //遍历
        for(int k = 0;k < len;k++)
        {
            if(list[str.charAt(k)] == 1)
            {
                index = k;
                break;
            }
        }
        return index;
    }
    
}
