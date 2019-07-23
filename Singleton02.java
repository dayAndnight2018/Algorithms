public final class Singleton02 {
	//防止外部调用
	private Singleton02() {}
	
	//暴露获取对象的方法
	public static Singleton02 getInstance() {
		return Nested.instance;
	}
	
	//内部静态类
	private static class Nested{
	    
		private static final Singleton02 instance = new Singleton02();
	
	}
}
