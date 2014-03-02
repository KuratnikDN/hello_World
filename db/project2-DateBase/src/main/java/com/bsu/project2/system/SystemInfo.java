package com.bsu.project2.system;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vildhet on 23.02.14.
 */
public class SystemInfo {

    private static SystemInfo instance;

    static {
        instance = new SystemInfo();
    }

    private OsType osType;
    private String tempFolder;

    public SystemInfo() {
        switch (System.getProperty("os.name").toLowerCase()) {
            case "linux":
                osType = OsType.LINUX;
                tempFolder = "/tmp/project2/";
                break;
            case "windows":
                osType = OsType.WINDOWS;
                tempFolder = "";
            default:
                osType = OsType.OTHER;
                tempFolder = "";
        }
    }

    public static OsType GetOsType() {
        return instance.osType;
    }

    public static String getTempFolder() {
        return instance.tempFolder;
    }

    public static Map<String, String> getInfoMap() {
        Map<String, String> map = new HashMap<>();
        map.put("OS", instance.osType.toString());
        map.put("temp dir", instance.tempFolder);
        return map;
    }
}
