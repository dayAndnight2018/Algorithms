import java.util.ArrayList;
import java.util.Collections;
public class StringPermutation {
    
    //字符串的排列组合
    public ArrayList<String> Permutation(String str) {
       ArrayList<String> list = new ArrayList<String>();
        if(str == null || str.length() <= 0)
        {
            return list;
        }
        
        char[] array = str.toCharArray();      
        GetList(array,0, list);
        Collections.sort(list);
        
        return list;
    }
    
    public void GetList(char[] str, int index, ArrayList<String> list)
    {
        //只剩下一个元素，直接返回
        if(index == str.length - 1)
        {
            String s = String.valueOf(str);
            if(!list.contains(s))
                list.add(s);
        }
        else
        {   
            //依次交换位置，组合剩余的字符串
            for(int i = index; i < str.length;i++)
            {
                char c = str[index];
                    str[index] = str[i];
                    str[i] = c;
                GetList(str,index+1,list);
                    c = str[index];
                    str[index] = str[i];
                    str[i] = c;
                }
            }
      }
}
