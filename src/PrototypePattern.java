
class Page implements Cloneable{
    private String color;
    private String material;
    public Page(String color,String material) {
        this.color = color;
        this.material=material;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Page{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
/**
 * 原型模式
 */
public class PrototypePattern {
    public static void main(String[] args){
        Page page1=new Page("黄色","塑料");
        try {
            Page page2= (Page) page1.clone();
            page2.setColor("绿色");
            System.out.println(page1.toString());
            System.out.println(page2.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
