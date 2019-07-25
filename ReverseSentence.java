//反转单词序列,例如，“student. a am I”, 正确的句子应该是“I am a student.”
public class ReverseSentence{
    //遍历每个字符，是空格就把单词加到list中
    public String ReverseSentence(String str) {
        StringBuffer buffer = new StringBuffer();
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0;i<str.length();i++)
        {
            if(str.charAt(i) == ' ' && buffer.length()>0)
            {
                list.add(buffer.toString());
                list.add(" ");
                buffer.setLength(0);
            }
            else
            {
                buffer.append(str.charAt(i));
            }
        }
        if(buffer.length()>0)
            {
                list.add(buffer.toString());
            }
        String result = "";
        for(int j = list.size()-1;j>=0;j--)
        {
            result += list.get(j);
        }
        return result;
    }
    
    //交换元素的位置例如【12345】变成【54321】
    private void reverse(char[] chars, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
    
    public String ReverseSentence2(String str) {

        if (str == null || str.length() <= 0) {
            return "";
        }

        char[] chars = str.toCharArray();
        
        //先交换字符的顺序“student. a am I” => “I ma a .tneduts”
        reverse(chars, 0, chars.length-1);

        int start = 0; 
        
        //找到第一个不是空的字符
        while (start < chars.length && chars[start] == ' ') {
            start++; 
        }

        //如果全部都是空，直接返回
        if (start == chars.length) {
            return str;
        }
        
        // 对单词进行排列“I ma a .tneduts” => “I am a student.”
        for (int end = start; end < chars.length; end++) {
            if (chars[end] == ' ') {
                reverse(chars, start, --end);
                end += 2;
                start = end;
            }
        }

        reverse(chars, start, chars.length-1);

        return String.valueOf(chars);
    }

}
