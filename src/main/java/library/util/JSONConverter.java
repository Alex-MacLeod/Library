package library.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JSONConverter {

    private static ObjectMapper mapper = new ObjectMapper()
            .configure(SerializationFeature.INDENT_OUTPUT, true);

    public <T> T readJson(String jsonPath, Class<T> clazz) {
        T json = null;
        try (InputStream in = JSONConverter.class.getResourceAsStream(jsonPath)){
            json = mapper.readValue(in, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static <T> List<T> readJsonList(String jsonPath, Class<T> clazz){
        CollectionType listType = mapper.getTypeFactory()
                .constructCollectionType(ArrayList.class, clazz);
        List<T> jsonList = null;
        try (InputStream in = JSONConverter.class.getResourceAsStream(jsonPath)){
            jsonList = mapper.readValue(in, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonList;
    }

    public static void outputJson(Object obj) {
        byte[] json = new byte[]{};
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            mapper.writeValue(out, obj);
            json = out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(json, StandardCharsets.UTF_8));
    }

    public static void writeJson(Object obj, String jsonPath) throws IOException {
        mapper.writeValue(new File(jsonPath), obj);
    }

    private JSONConverter() {}

}
