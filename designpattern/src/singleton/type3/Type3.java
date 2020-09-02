package singleton.type3;

/**
 * 枚举类
 */
public class Type3 {

    public static void main(String[] args) {
        Singleton singleton = Singleton.SINGLETON;
        Singleton singleton2 = Singleton.SINGLETON;
        System.out.println(singleton == singleton2);
    }

}

enum  Singleton {
    SINGLETON;
}


