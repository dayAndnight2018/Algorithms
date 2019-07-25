public class LeftRotateString {
    public String LeftRotate(String str,int n) {
        if (str == null || str.length() <= 0 || n < 0 || n > str.length()) {
            return "";
        }

        char[] chars = str.toCharArray();
        //先翻转0-指定位置的元素
        reverse(chars, 0, n-1);
        //再翻转指定元素后面的部分
        reverse(chars, n, chars.length-1);
        //再整体反转
        reverse(chars, 0, chars.length-1);

        return String.valueOf(chars);
    }
    
    //交换元素的顺序[123456] => [654321]
    private void reverse(char[] chars, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
}
