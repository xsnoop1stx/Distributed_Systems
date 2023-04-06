import java.io.*;
import java.util.*;

public class Main {

    // Call the readGPX method
    public static void main(String[] args) throws Exception {

        String filePath;
        File file;
        Scanner scanner = new Scanner(System.in);

        // Loop until the user inputs a valid file path
        do {

            // Ask the user for the file path
            System.out.print("Enter the path to the file: ");
            filePath = scanner.nextLine();

            // Check if the file exists
            file = new File(filePath);
            if(!file.exists()) {

                // Print an error message and search for the file in the Downloads folder
                System.out.println("File not found in this directory:" + filePath + "\nPress enter to search in default directories.");
                if (filePath.isEmpty()) {
                    System.out.println("Noob mode activated searching your Downloads :-)");

                    // Get the username of the current user
                    String username = System.getProperty("user.name");

                    // Set the directory path based on the operating system
                    String osName = System.getProperty("os.name").toLowerCase();
                    String directoryPath = "";
                    if (osName.contains("win"))
                        directoryPath = "C:\\Users\\" + username + "\\Downloads\\";
                    else
                        directoryPath = "/home/" + username + "/Downloads/";

                    // Set the file path
                    filePath = directoryPath + "route1.gpx";
                    file = new File(filePath);
                }
            }

        } while (!file.exists());

        Map<String, Waypoint> map;
        GPXParser parser = new GPXParser(filePath);
        map = parser.getWaypoints();

        // Loop through the map and print each entry
        for (Map.Entry<String, Waypoint> entry : map.entrySet()) {
            // Print the word and the number
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // Start the server
        new Master().openServer();
    }
}
