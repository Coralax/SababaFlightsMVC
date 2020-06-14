package model;

import java.io.*;
import java.util.Set;

public class FileManager<T> {

    private String fileName;
    public FileManager(String fileName) {
        this.fileName = fileName;
    }
    public void write(Set<T> object){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.fileName))) {
            objectOutputStream.writeObject(object);
        }
        catch(IOException e)
        {
            System.out.println("Cannot write to the file");
        }
   }
}
