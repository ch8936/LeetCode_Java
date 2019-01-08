
/*饿汉式单例模式    在初始化静态实例时就创建实例     随后调用函数直接返回该实例*/
public class Singleton {
	private static Singleton s=new Singleton();		 
	private Singleton() {}              		 
	public static Singleton getInstance() {
		return s;
	}
}

package day402offer;
/**
 * 单例模式的几种变体
 * 原始版  ----上锁版---双重判断版（均是懒汉式单例模式）
 *
 */
/*原始版    只能在单线程中使用*/
public class Singleton {
	private static Singleton s=null;     		 //static！定义静态实例， 后面在static方法中使用
	private Singleton() {}              		 //构造函数私有化，禁止他人创建
	public static Singleton getInstance() {         //公开类的静态函数  创建唯一的实例
		if(s==null)
			s=new Singleton();
		return s;
	}
}
原始版  ----上锁版---双重判断版（均是懒汉式单例模式）
 *
 */
/*原始版    只能在单线程中使用*/
public class Singleton {
	private static Singleton s=null;     		 //static！定义静态实例， 后面在static方法中使用
	private Singleton() {}              		 //构造函数私有化，禁止他人创建
	public static Singleton getInstance() {         //公开类的静态函数  创建唯一的实例
		if(s==null)
			s=new Singleton();
		return s;
	}
}

/*上锁版   可以在多线程中使用 但每次（包括实例已经创建完毕后）均上锁   加锁性能不好*/
public class Singleton {
	private static Object obj=new Object();          //创建上锁的对象
	private static Singleton s=null;     		 
	private Singleton() {}              		 
	public static Singleton getInstance() {     
		synchronized(obj) {                      //上锁同步   
			if(s==null)
				s=new Singleton();
		}
		return s;
	}
}


/*双重判断版   加入两次判断  实例创建完毕就无需加锁了 直接判断 返回结果即可*/
public class Singleton {
	private static Object obj=new Object();          //创建上锁的对象
	private static Singleton s=null;     		 
	private Singleton() {}              		 
	public static Singleton getInstance() {
		if(s==null) {
			synchronized(obj) {              //上锁同步   
				if(s==null)
					s=new Singleton();
			}
		}
		return s;
	}
}               //  “双重判断机制”    实现延迟加载---解决了线程并发问题----提高了效率---很好用的方法

/*采用内部类的方法   第一次用到时会调用内部类的 静态构造函数创建实例   */
public class Singleton {	 
	private Singleton() {}              		 
	public static Singleton getInstance() {
		return InnerSingle.instance;
	}
	//静态内部类
	private static class  InnerSingle{
		static Singleton instance=new Singleton();   //创建实例
	}
}
