import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Baby {
    void play();

    void eat();

    void wc();
    //...more
}

class MyBaby implements Baby {

    @Override
    public void play() {
        System.out.println("我要玩");
    }

    @Override
    public void eat() {
        System.out.println("我要吃");
    }

    @Override
    public void wc() {
        System.out.println("我要上厕所");
    }
}

class BabyProxy implements Baby {
    Baby baby;

    public BabyProxy(Baby baby) {
        this.baby = baby;
    }

    @Override
    public void play() {
        ready();
        baby.play();
    }

    @Override
    public void eat() {
        ready();
        baby.eat();
    }

    @Override
    public void wc() {
        ready();
        baby.wc();
    }

    private void ready() {
        System.out.println("---准备处理---");
    }
}

/**
 * 静态代理模式
 */
class ProxyPattern {
    public static void main(String[] args) {
        BabyProxy proxy = new BabyProxy(new MyBaby());
        proxy.eat();
    }
}

class DynamicBaby implements InvocationHandler {
    private Baby baby;

    public DynamicBaby(Baby baby) {
        this.baby = baby;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        ready();
        return method.invoke(baby, objects);
    }

    private void ready() {
        System.out.println("---准备处理---");
    }
}

/**
 * 动态代理
 */
class DynamicProxyPattern {
    public static void main(String[] args) {
        Baby baby= (Baby) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Baby.class},new DynamicBaby(new MyBaby()));
        baby.eat();
    }
}
