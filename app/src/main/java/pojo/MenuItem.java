package pojo;

/**
 * Created by Juncal on 2016-09-27.
 */

public class MenuItem {
    private String name;
    public MenuItem() {
        super();
        // TODO Auto-generated constructor stub
    }

    public MenuItem(String url, String id, String name, int sort) {
        super();
        this.url = url;
        this.id = id;
        this.name = name;
        this.sort = sort;
    }

    private String url;
    private String id;
    private int sort;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
