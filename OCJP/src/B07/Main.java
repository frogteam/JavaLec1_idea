package B07;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public void takeList(List<? extends String> list){
        //list.add("foo");
        Object o = list;
        String s = list.get(0);
        list = new ArrayList<String>();
        //list = new ArrayList<Object>();
    }
}
