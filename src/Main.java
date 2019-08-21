import java.io.*;
import java.util.Arrays;
import java.util.List;

import Lexer.Lexer;
import Parser.Parser;

public class Main {
    private static List<List<String>> tokens;
    public static void main(String[] args) {
        Lexer fileLexer = new Lexer();
        Parser fileParser = new Parser();
        String content;
        try {
            FileReader fileReader = new FileReader("src/test.venta");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //process the line
                content = line;

                tokens = fileLexer.tokenise(content);
            }

            fileParser.parse(tokens);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Unable to read the file.");
        }
    }
}
