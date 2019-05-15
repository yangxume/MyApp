package com.xy.my_retrofit_rxjava2_task.network;

import com.okay.teachertasklib.utils.StringUtils;

import java.util.HashMap;

/**
 * desc:
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class TaskNetManager {
    private static TaskNetManager self = null;

    public static TaskNetManager get() {
        if (self == null) {
            self = new TaskNetManager();
        }
        return self;
    }

    private TaskNetManager() {
    }

    private HashMap<String, String> errorNet = new HashMap<>();

    public void addNetError(String key, String value) {
        errorNet.put(key, value);
    }

    public boolean containError(String key) {
        return errorNet.containsKey(key);
    }

    public String getError(String key) {
        String value = errorNet.get(key);
        if (StringUtils.isEmpty(value)) {
            return "";
        }
        return value;
    }

    public void removeError(String key) {
        errorNet.remove(key);
    }
}
