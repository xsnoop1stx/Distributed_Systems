import java.io.*;
import java.util.*;
public class Main {
    //call the readGPX method
    public static void main(String[] args) throws Exception {
        //create a map of words and their numbers
        Map<String, Double> map = Master.readXML("C:\\Users\\user\\Desktop\\route1.gpx");
        //loop through the map
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            //print the word and the number
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}