package com.bsu.project2.database;

import com.bsu.project2.data.BuzzTalkData;
import com.bsu.project2.data.OpenCalaisTag;
import com.bsu.project2.data.Publication;

import java.util.ArrayList;

/**
 * Created by werewolf on 2/26/14.
 */
public interface DataBase {
    public void save(BuzzTalkData data);

    public ArrayList<OpenCalaisTag> getAllTags();

    public ArrayList<Publication> getAllPublications();
}
