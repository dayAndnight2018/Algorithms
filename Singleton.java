//final防止继承
public final class Singleton {
	
	//配置静态构造函数，防止外部创建对象
	private Singleton() {}
	
	//饿汉式创建单例对象
	private static final Singleton instance = new Singleton();

	//创建公开的静态方法，用于外部获取对象
	public static Singleton getInstance() {		
		return instance;
	}
}
