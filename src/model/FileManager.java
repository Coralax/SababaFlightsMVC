package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import model.objects.Agent;

import java.io.*;
import java.util.List;
import java.util.Scanner;
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
    private String objToJson(List<T> obj) {
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
    public boolean saveObj(List<T> obj, String fileName) {
       try {
           /* Opens the file for writing */
           FileWriter myWriter = new FileWriter(fileName);

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
    public Set<T> read() {
        try {
            /* Required stuff to read from a file */
            Scanner myReader = new Scanner(new File(this.fileName));
            StringBuilder data = new StringBuilder();

            /* Get all lines in the file */
            while (myReader.hasNextLine()) {
                data.append(myReader.nextLine());
            }
            String jsonString = data.toString();

            return new ObjectMapper().readValue(jsonString, new TypeReference<Set<Agent>>(){});

        /* Errors handling */
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Return List<T> */
        return null;
    }

//    public void write(Set<T> object){
//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.fileName))) {
//            objectOutputStream.writeObject(object);
//        }
//        catch(IOException e)
//        {
//            System.out.println("Cannot write to the file");
//        }
//   }
}
