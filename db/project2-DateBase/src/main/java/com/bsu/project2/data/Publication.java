package com.bsu.project2.data;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Alexzander
 * Date: 13.02.14
 * Time: 12:06
 * To change this template use File | Settings | File Templates.
 */
public class Publication {

    private String pk;
    private String publishDate;
    private String contentType;
    private String title;
    private String url;
    private String reach;
    private ArrayList<String> openCalaisTagIds;

    public Publication() {
        openCalaisTagIds = new ArrayList<String>();
    }

    public Publication(String pk, String publishDate, String contentType, String title, String url, String reach,
            ArrayList<String> openCalaisTagIds) {
        this.pk = pk;
        this.publishDate = publishDate;
        this.contentType = contentType;
        this.title = title;
        this.url = url;
        this.reach = reach;
        this.openCalaisTagIds = openCalaisTagIds;
    }

    public Publication(String pk, String publishDate, String contentType, String title, String url, String reach) {
        this.pk = pk;
        this.publishDate = publishDate;
        this.contentType = contentType;
        this.title = title;
        this.url = url;
        this.reach = reach;
    }


    public String getPk() {
        return pk;
    }
    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getReach() {
        return reach;
    }
    public void setReach(String reach) {
        this.reach = reach;
    }

    public ArrayList<String> getOpenCalaisTagIds() {
        return openCalaisTagIds;
    }
    public void setOpenCalaisTagIds(ArrayList<String> openCalaisTagIds) {
        this.openCalaisTagIds = openCalaisTagIds;
    }
    public void addToOpenCalaisTagIds(String tagId) {
        this.openCalaisTagIds.add(tagId);
    }
}
