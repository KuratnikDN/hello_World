package com.bsu.project2.data;

/**
 * Created with IntelliJ IDEA.
 * User: Alexzander
 * Date: 13.02.14
 * Time: 12:06
 * To change this template use File | Settings | File Templates.
 */
public class OpenCalaisTag {

    private Integer id;
    private String name;
    private String category;

    public OpenCalaisTag() {
    }

    public OpenCalaisTag(Integer id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
