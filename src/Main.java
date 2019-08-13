import java.io.*;
import java.util.Arrays;
import java.util.List;

import Lexer.Lexer;
import Parser.Parser;

public class Main {
    private static List<List<String>> tokens;
    public static void main(String[] args) {
        String content;
        try {
            FileReader fileReader = new FileReader("src/test.venta");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //process the line
                content = line;

                Lexer fileLexer = new Lexer();
                tokens = fileLexer.tokenise(content);
            }

            Parser fileParser = new Parser();
            fileParser.parse(tokens);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Unable to read the file.");
        }
    }
}
