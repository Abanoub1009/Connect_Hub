
package connect_hub;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class FileManager<T> {
    private String filePath;
    private Map<String , T> dataMap;

    public FileManager(String filePath) {
        this.filePath = filePath;
        this.dataMap = new HashMap<>();
        loadFromFile();
    }

    private void loadFromFile() {
        try
        {
            File file = new File(filePath);
            if (!file.exists())
            {
                Files.write(Paths.get(filePath), "[]".getBytes());
            }
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jasonArray = new JSONArray(content);
            for (int i = 0; i < jasonArray.length(); i++)
            {
                JSONObject jsonObject = jasonArray.getJSONObject(i);
                String key = jsonObject.getString("id");
                @SuppressWarnings("unchecked")
                T value = (T) jsonObject.toMap();
                dataMap.put(key, value);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    private void saveToFile() 
    {
        try
        {
            FileWriter writer = new FileWriter(filePath);
            JSONArray jsonArray = new JSONArray();
            for (Map.Entry<String, T> entry: dataMap.entrySet())
            {
                JSONObject jsonObject = new JSONObject((Map<?,?>) entry.getValue());
                jsonObject.put(entry.getKey(), entry.getKey());
                jsonArray.put(jsonObject);
            }
            writer.write(jsonArray.toString(4));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    private Map<String, T> getDataMap()
    {
        return dataMap;
    }
    private void addOrUpdate(String id, T value)
    {
        dataMap.put(id, value);
        saveToFile();
    }
    private void remove(String id)
    {
        dataMap.remove(id);
        saveToFile();
    }
    private T getById(String id)
    {
        return dataMap.get(id);
    }
    private String getKeyFieldName()
    {
        if(filePath.contains("users")){
            return "userId";
        }else if(filePath.contains("posts") || filePath.contains("stories")){
            return "contentId";
        }
        return "id";
    }
    private String getIdField(JSONObject jsonObject)
    {
        String keyName = getKeyFieldName();
        return jsonObject.optString(keyName, null);
    }
}
