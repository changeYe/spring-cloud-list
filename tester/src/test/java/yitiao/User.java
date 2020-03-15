package yitiao;

import java.util.List;


/**
 * @author yuantongqin
 * 2019/6/16
 */
public class User {

    private int id ;

    private List<Item> item;

    public User(int id, List<Item> item) {
        this.id = id;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", item=" + item +
               '}';
    }
}
