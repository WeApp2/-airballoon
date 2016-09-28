package pojo;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Juncal on 2016-09-27.
 */

public class MainMenu {
    private String name;
    private int type;
    private int id;
    public MainMenu(){

    }
    private String url;
    private List<MenuItem> menuItems;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

