package com.bsu.project2.database;

import com.bsu.project2.data.BuzzTalkData;
import com.bsu.project2.data.OpenCalaisTag;
import com.bsu.project2.data.Publication;

import java.util.ArrayList;

/**
 * Created by werewolf on 2/26/14.
 */
public class ArrayDataBase implements DataBase {

    private BuzzTalkData data;

    @Override
    public void save(BuzzTalkData data) {
        this.data = data;
    }

    @Override
    public ArrayList<OpenCalaisTag> getAllTags() {
        return data.getTags();
    }

    @Override
    public ArrayList<Publication> getAllPublications() {
        return data.getPublications();
    }
}
