package singleton.type2;

/**
 * 单例模式（静态内部类） 懒加载 线程安全
 */
public class Type2 {
}

class Singleton {

    private Singleton () {}

    private static class SingletonInstance {
        private static final Singleton SINGLETON = new Singleton();
    }

    public static Singleton getInstance() {
     return SingletonInstance.SINGLETON;
    }

}


