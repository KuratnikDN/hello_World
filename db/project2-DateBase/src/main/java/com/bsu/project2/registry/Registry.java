package com.bsu.project2.registry;

import com.bsu.project2.database.ArrayDataBase;
import com.bsu.project2.database.DataBase;

/**
 * Created by werewolf on 2/26/14.
 */
public class Registry {
    private static Registry instance;

    static {
        instance = new Registry();
    }

    private DataBase db;

    public Registry() {
        db = new ArrayDataBase();
    }

    public static DataBase getBase() {
        return instance.db;
    }
}
