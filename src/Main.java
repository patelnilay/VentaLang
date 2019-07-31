import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Lexer.Lexer;

public class Main {
    public static void main(String[] args) {
        String line = "";
        String data = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test.venta"));
            while (line != null) {
                data += line;
                line = bufferedReader.readLine();

            }
            System.out.println(data);
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Unable to read the file.");
        }

        Lexer fileLexer = new Lexer();
        fileLexer.tokenise();
    }
}