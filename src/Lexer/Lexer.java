package Lexer;

import java.util.Arrays;
import java.util.HashMap;


public class Lexer {

    public HashMap tokenise(String sourceCode) {
        HashMap<String, String> tokens = new HashMap<>();
        String[] SplitSourceCode;
        SplitSourceCode = sourceCode.split(" ");
        String[] operatorsArray = {"=", "/", "*", "=", "-", "+"};
        int sourceIndex = 0;


        for (int i = 0; i < SplitSourceCode.length; i++) {
            String currentWord = SplitSourceCode[sourceIndex];
            String lastChar = String.valueOf((currentWord.charAt(currentWord.length() - 1)));
            String currentWordWithoutSemiColon = currentWord.substring(0, (currentWord.length() - 1));

            // checks is currentWord is "var" and create a "VAR DECLARATION" token for it
            if (currentWord.equals("var")) {
                tokens.put("VAR DECLARATION", currentWord);
                // Using regex, this will recognise a word and create an IDENTIFIER token for it.
            } else if (currentWord.matches("[a-zA-Z]+")) {
                tokens.put("IDENTIFIER", currentWord);
            } else if (currentWord.matches("[0-9]+")) {
                tokens.put("INTEGER", currentWord);
            } else if (Arrays.asList(operatorsArray).contains(currentWord)) {
                tokens.put("OPERATOR", currentWord);
                // This will recognise an a semicolon [;] and create an SYMBOL token for it.
            } else if (currentWord.contains(";")) {
                tokens.put("SYMBOL", lastChar);
                if (currentWordWithoutSemiColon.matches("[a-zA-Z]+")) {
                    tokens.put("IDENTIFIER", currentWordWithoutSemiColon);
                    // Using regex, this will recognise an integer and create a INTEGER token for it.
                }
                if (currentWordWithoutSemiColon.matches("[0-9]+")) {
                    tokens.put("INTEGER", currentWordWithoutSemiColon);
                    // This will recognise an operator and create a OPERATOR token for it.
                }
            }
            sourceIndex++;
        } // end for loop
        System.out.println(tokens.values());
        return tokens;
    }
}

