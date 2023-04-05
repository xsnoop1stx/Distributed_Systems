import java.io.*;
import java.util.*;
import java.time.*;
import java.lang.*;

public class Master {

    public static Map<String, Double> readXML(String filename) throws Exception {
        //create a map of words and their numbers
        Map<String, Double> map = new HashMap<>();
        //create a file object
        File file = new File(filename);
        //create a scanner object
        Scanner scanner = new Scanner(file);
        //loop through the file
        while (scanner.hasNextLine()) {
            //read the line
            String line = scanner.nextLine();
            //remove all the special characters
            line = line.replace("<", "")
                    .replace(">", "")
                    .replace("/", "")
                    .replace("=", "")
                    .replace("\"", "");
            //split the line into words
            String[] words = line.split(" ");
            //loop through the words
            for (String word : words) {
                //check if the word is lat, lon, time, ele
                if (word.contains("lat") ) {
                    word=word.replace("lat", "");
                    word.trim();
                    double num=Double.parseDouble(word);
                    map.put("lat", num);
                } else if (word.contains("lon") ) {
                    word=word.replace("lon", "");
                    word.trim();
                    double num=Double.parseDouble(word);
                    map.put("lon", num);
                } else if (word.contains("time") ) {
                    word=word.replace("time", "");
                    word.trim();
                    Instant instant = Instant.parse(word);
                    double num=instant.toEpochMilli();
                    map.put("time", num);
                } else if (word.contains("ele") ) {
                    word=word.replace("ele", "");
                    word.trim();
                    double num=Double.parseDouble(word);
                    map.put("ele", num);

                }
            }
        }

        //close the scanner
        scanner.close();
        //return the map
        return map;
    }
}






