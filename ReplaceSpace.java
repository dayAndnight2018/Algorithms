/*
 *  问题描述：给定一个字符串，使用%20替换掉空格？
 * 
 */
public class ReplaceSpace {

	/*
	 * 解题思路：先统计空格的数量，根据空格的数量对str进行空间扩展，设置两个指针
	 * 一个指向原来的字符串末尾，一个指向新的空间的末尾，一旦发现有空格，依次填入
	 * 0,2,% 否则填入原来的字符，指针递减，直至前一个指针指向字符串首地址。
	 */
	public String replace(StringBuffer str){
		//验证合法性
		if(str == null) {
			return null;
		}
		
		int num = 0;
		//统计空格的数量
		for(int i =0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				num++;
			}
		}
		
		//扩展数组
		int len = str.length() + 2*num;
		//两个指针
		int pointer1 = str.length() - 1;
		int pointer2 = len -1;
		//重置str的长度
		str.setLength(len);
		while(pointer1 >= 0) {
			if(str.charAt(pointer1) == ' ') {
				str.setCharAt(pointer2--,'0');
				str.setCharAt(pointer2--,'2');
				str.setCharAt(pointer2--,'%');				
			}else {
				str.setCharAt(pointer2--,str.charAt(pointer1));
			}
			
			pointer1--;
		}
		
		return str.toString();
	}
}
