interface Price {
    double money();
}

class Milk implements Price {
    @Override
    public double money() {
        return 1;
    }
}

class PriceDecotor implements Price {
    Price price;
    public PriceDecotor(Price price) {
        this.price = price;
    }

    @Override
    public double money() {
        return price.money();
    }
}

class Apple extends PriceDecotor {

    public Apple(Price price) {
        super(price);
    }

    public double money() {
        return super.money() + 1;
    }
}

class Orange extends PriceDecotor {

    public Orange(Price price) {
        super(price);
    }

    public double money() {
        return super.money() + 1.5;
    }
}
/**
 * 装饰者模式
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        Price milk = new Milk();
        Price appleMilk = new Apple(new Milk());
        Price appleOrangeMilk = new Orange(appleMilk);
        System.out.println("牛奶的价格:" + milk.money());
        System.out.println("苹果牛奶的价格:" + appleMilk.money());
        System.out.println("苹果橘子牛奶的价格:" + appleOrangeMilk.money());
    }
}
