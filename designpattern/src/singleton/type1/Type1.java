package singleton.type1;

/**
 * 单例模式（双重检查）
 */
public class Type1 {
}

class Singleton {

    private static volatile Singleton singleton;

    private Singleton () {}

    public static Singleton getInstance() {

        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }

}


