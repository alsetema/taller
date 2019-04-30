package fileFunctions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileFunctions {

    public static String toString(String filePath) throws FileNotFoundException, IOException, Exception {

            BufferedReader reader = new BufferedReader((new FileReader(filePath)));
            StringBuilder sb = new StringBuilder();
            String currentLine = reader.readLine();
            while (currentLine != null) {
                sb.append(currentLine);
                sb.append('\n'); //we append the linebreak to the thing too
                currentLine = reader.readLine();
            }
            reader.close();
            return sb.toString();

    }
}
