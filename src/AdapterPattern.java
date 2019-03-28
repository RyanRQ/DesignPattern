
abstract class View {
    abstract void refreshView();
}
interface BaseAdapter {
    String onView();
}
class ListView extends View {
    private BaseAdapter adapter;

    public void setAdapter(BaseAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    void refreshView() {
        System.out.println(adapter.onView());
    }
}


class SingleAdapter implements BaseAdapter {
    @Override
    public String onView() {
        return "SingleAdapter";
    }
}

/**
 * 适配者模式
 */
public class AdapterPattern {
    public static void main(String[] args) {
        ListView listView = new ListView();
        listView.setAdapter(new SingleAdapter());
        listView.refreshView();
    }
}
