package model.objects;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*1.MAKE SINGELTON
* 2.FOR GENERAL USE, WHAT DESTINATIONS WE SHOW IN OUR ENGINE!*/
public class Destination implements Serializable {

    final public static String fileName = "SababaFlights\\src\\data\\destinations.txt";
    public static List<String> listOfDestinations;

    public Destination() {
        listOfDestinations =new ArrayList<>();
       }

    public List<String> readDestination() throws IOException, ClassNotFoundException {
             try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
                 listOfDestinations= (List<String>) objectInputStream.readObject();
                 return listOfDestinations;
        }
    }


   /* private static void appendToFile(String filePath, String text) {
        File file = new File(filePath);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
            fw.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

}
