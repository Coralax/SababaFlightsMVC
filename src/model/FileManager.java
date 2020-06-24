package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;
import java.util.Set;

public class FileManager<T> {

    private final String fileName;

    final ObjectMapper mapper = new ObjectMapper();

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    /*
     * Converts object to json format.
     * Returns an empty string if failed.
     */
    private String objToJson(Set<T> obj) {
        String jsonSting;
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            jsonSting = ow.writeValueAsString(obj);
            return jsonSting;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    /*
    * Saves a list of type T to file `fileName`
    *
    * Params:
    * 1. List of objects to insert to the json file.
    * 2. Name of the file the data should be inserted to.
    */
    public boolean saveObj(Set<T> obj) {
       try {
           /* Opens the file for writing */
           FileWriter myWriter = new FileWriter(this.fileName);

           /*
            * Sends the object to objToJson which convert the object to json.
            * Writes to file.
            * Return true if successful.
            */
           myWriter.write(this.objToJson(obj));
           myWriter.close();
           System.out.println("Successfully wrote to the file.");
           return true;
       /* Error handling. Returns false if could not write to file. */
       } catch (IOException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
           return false;
       }
    }

    /*
    * T - the type of class trying to read
    * e.g: Agent
    *
    * Constructs a list of all objects of type T in the corresponding file name.
    */
    public Set<T> read(Class<T> classType) {
        try {

            JavaType type = mapper.getTypeFactory().constructCollectionType(Set.class, classType);
            return new ObjectMapper().readValue(new File(this.fileName), type);

        /* Errors handling */
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Return List<T> */
        return null;
    }
}
