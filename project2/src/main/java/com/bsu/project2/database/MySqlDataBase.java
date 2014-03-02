package com.bsu.project2.database;

import com.bsu.project2.data.BuzzTalkData;
import com.bsu.project2.data.OpenCalaisTag;
import com.bsu.project2.data.Publication;

import java.util.ArrayList;

/**
 * Created by werewolf on 2/26/14.
 */

/**
 *
 * Specially for Kuratnik.
 * Put your implementation here.
 *
 */
public class MySqlDataBase implements DataBase {
    @Override
    public void save(BuzzTalkData data) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public ArrayList<OpenCalaisTag> getAllTags() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public ArrayList<Publication> getAllPublications() {
        throw new UnsupportedOperationException("not implemented");
    }
}
