package com.bsu.project2.data;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Alexzander
 * Date: 13.02.14
 * Time: 12:05
 * To change this template use File | Settings | File Templates.
 */
public class BuzzTalkData {

    private ArrayList<OpenCalaisTag> tags;
    private ArrayList<Publication> publications;

    public BuzzTalkData() {
        tags = new ArrayList<>();
        publications = new ArrayList<>();
    }

    public ArrayList<OpenCalaisTag> getTags() {
        return tags;
    }

    public void addTag(OpenCalaisTag tag){
        tags.add(tag);
    }

    public ArrayList<Publication> getPublications() {
        return publications;
    }
    public void addPublication(Publication publication){
        publications.add(publication);
    }
}
