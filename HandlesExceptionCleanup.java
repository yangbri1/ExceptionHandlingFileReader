// import BufferedReader, FileReader class w/ methods .readLine() from java.io class to read file content
import java.io.*;

// Note: java.lang library is implicitly imported -- includes 'Throwable' -> 'Exception' class

public class HandlesExceptionCleanup {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("demo.txt"));
            String line = reader.readLine();
            System.out.println("Read from file: " + line);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing reader: " + e.getMessage());
            }
        }
    }
}