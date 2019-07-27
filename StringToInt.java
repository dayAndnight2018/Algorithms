//字符串转数字
public class StringToInt {
    public int StrToInt(String str) {
        if(str == null || str.length()<1)
        {
            return 0;
        }
        
        boolean isMinus = false;
        int counter = 0;
        char[] array = str.toCharArray();
        int[] numbers = new int[array.length];
        
        if(array[0] == '-')
        {
            isMinus = true;
            counter++;
        }
        else if(array[0] == '+')
        {
            counter++;
        }
        
        int flag = 0;
        for(int i = 0;i < numbers.length;i++)
        {
            numbers[i] = -1;
        }
        
        for(int j = counter;j < array.length;j++)
        {
            if(array[j] > 57 || array[j]<48)
            {
                return 0;
            }
            else
            {
                numbers[flag++] = array[j] - 48;
            }
        }
        
        int bei = 1;
        int result = 0;
        for(int k = numbers.length - 1; k >= 0; k--)
        {
            if(numbers[k]!= -1)
            {
                result += bei * numbers[k];
                bei *= 10;
            }
        }
        
        if(isMinus)
        {
            return 0 - result;
        }
        else
        {
            return result;
        }
        
        
    }
}
