package com.xy.my_retrofit_rxjava2_task.common;

import android.text.TextUtils;

import com.xy.my_retrofit_rxjava2_task.utils.LogUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author hesongchao
 *         Created on 2017/3/14 11:18
 */

public class JsonUtil {
    private static final String TAG = "JsonUtil";

    public static JSONObject getJSONObject(String json) {
        JSONObject jsonObject = null;
        if (!TextUtils.isEmpty(json)) {
            try {
                jsonObject = new JSONObject(json);
            } catch (JSONException e) {
                LogUtils.e(TAG, "getJSONObject\t" + e.getMessage());
            }
        }
        return jsonObject;
    }

    public static String getString(JSONObject object, String path) throws Exception {
        String[] components = path.split("/");
        DataWrapper dataWrapper = DataWrapper.create(object);
        for (String oneComponent : components) {
            dataWrapper = get(dataWrapper, oneComponent);
        }
        if (dataWrapper.type == 5) {
            return (String) dataWrapper.value;
        } else {
            throw new Exception("final data type err");
        }
    }

    public static int getInt(JSONObject object, String path) throws Exception {
        String[] components = path.split("/");
        DataWrapper dataWrapper = DataWrapper.create(object);
        for (String oneComponent : components) {
            dataWrapper = get(dataWrapper, oneComponent);
        }
        if (dataWrapper.type == 3) {
            return ((Number) dataWrapper.value).intValue();
        } else {
            throw new Exception("final data type err");
        }
    }

    public static Float getFloat(JSONObject object, String path) throws Exception {
        String[] components = path.split("/");
        DataWrapper dataWrapper = DataWrapper.create(object);
        for (String oneComponent : components) {
            dataWrapper = get(dataWrapper, oneComponent);
        }
        if (dataWrapper.type == 3) {
            return ((Number) dataWrapper.value).floatValue();
        } else {
            throw new Exception("final data type err");
        }
    }

    public static boolean getBoolean(JSONObject object, String path) throws Exception {
        String[] components = path.split("/");
        DataWrapper dataWrapper = DataWrapper.create(object);
        for (String oneComponent : components) {
            dataWrapper = get(dataWrapper, oneComponent);
        }
        if (dataWrapper.type == 4) {
            return ((Boolean) dataWrapper.value).booleanValue();
        } else {
            throw new Exception("final data type err");
        }
    }

    public static JSONObject getObject(JSONObject object, String path) throws Exception {
        String[] components = path.split("/");
        DataWrapper dataWrapper = DataWrapper.create(object);
        for (String oneComponent : components) {
            dataWrapper = get(dataWrapper, oneComponent);
        }
        if (dataWrapper.type == 1) {
            return (JSONObject) dataWrapper.value;
        } else {
            throw new Exception("final data type err");
        }
    }

    public static JSONArray getArray(JSONObject object, String path) throws Exception {
        String[] components = path.split("/");
        DataWrapper dataWrapper = DataWrapper.create(object);
        for (String oneComponent : components) {
            dataWrapper = get(dataWrapper, oneComponent);
        }
        if (dataWrapper.type == 2) {
            return (JSONArray) dataWrapper.value;
        } else {
            throw new Exception("final data type err");
        }
    }

    private static class DataWrapper {
        public int type; //1-obj,2-array,3-number,4-boolean,5-string
        public Object value;

        public static DataWrapper create(Object valueInJson) {
            if (valueInJson instanceof String) {
                return new DataWrapper(5, valueInJson);
            } else if (valueInJson instanceof Number) {
                return new DataWrapper(3, valueInJson);
            } else if (valueInJson instanceof Boolean) {
                return new DataWrapper(4, valueInJson);
            } else if (valueInJson instanceof JSONObject) {
                return new DataWrapper(1, valueInJson);
            } else if (valueInJson instanceof JSONArray) {
                return new DataWrapper(2, valueInJson);
            } else {
                throw new IllegalArgumentException("value in json get error");
            }
        }

        public DataWrapper(int t, Object v) {
            type = t;
            value = v;
        }
    }

    private static DataWrapper get(DataWrapper src, String path) throws Exception {
        if (src == null) {
            throw new NullPointerException();
        }
        switch (src.type) {
            case 1: {
                JSONObject obj = (JSONObject) src.value;
                Object valueInJson = obj.get(path);
                return DataWrapper.create(valueInJson);
            }
            case 2: {
                JSONArray array = (JSONArray) src.value;
                int index = Integer.parseInt(path);
                if (index < 0 || index >= array.length()) {
                    throw new Exception("index out of bounds");
                }
                Object valueInJson = array.get(index);
                return DataWrapper.create(valueInJson);
            }
            default: {
                throw new IllegalArgumentException("data type err");
            }
        }
    }
}
