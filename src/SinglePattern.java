/**
 * 单例模式-懒汉式
 */
class SingleSlacker {
    private static SingleSlacker slacker;

    private SingleSlacker() { }

    /**
     * 懒汉式线程安全
     *
     * @return
     */
    public synchronized static SingleSlacker getInstance() {
        if (slacker == null) {
            slacker = new SingleSlacker();
        }
        return slacker;
    }

    /**
     * 懒汉式线程安全另一种方式，相较于上一种效率更高
     *
     * @return
     */
    public static SingleSlacker getIns() {
        if (slacker == null) {
            synchronized (SingleSlacker.class) {
                if (slacker == null) {
                    slacker = new SingleSlacker();
                }
            }
        }
        return slacker;
    }

    public void test() {
    }
}

/**
 * 饿汉式 与懒汉式不同的地方在于直接实例化，天生具有线程安全的属性，单相对浪费资源
 */
class SingleHungry {
    private static SingleHungry hungry = new SingleHungry();

    private SingleHungry() {
    }

    public static SingleHungry getInstance() {
        return hungry;
    }

    public void test() {
    }
}

/**
 * 枚举单例模式写法简便,但会占用更多的内存资源，故在Android中不推荐使用
 */
enum SingleEnum {
    INSTANCE;

    public void test() {
    }
}

public class SinglePattern {
    public static void main(String[] args) {
        SingleSlacker.getInstance().test();
        SingleHungry.getInstance().test();
        SingleEnum.INSTANCE.test();
    }
}
