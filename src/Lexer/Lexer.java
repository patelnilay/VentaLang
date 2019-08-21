package Lexer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Lexer {
    private static List<List<String>> tokens = new ArrayList<>();

    public List<List<String>> tokenise(String sourceCode) {
        String[] addToTokens;
        String[] SplitSourceCode;
        SplitSourceCode = sourceCode.split(" ");
        String[] operatorsArray = {"=", "/", "*", "%", "-", "+"};
        int sourceIndex = 0;


        for (int i = 0; i < SplitSourceCode.length; i++) {
            String currentWord = SplitSourceCode[sourceIndex];
            String lastChar = String.valueOf((currentWord.charAt(currentWord.length() - 1)));
            String currentWordWithoutSemiColon = currentWord.substring(0, (currentWord.length() - 1));

            // checks is currentWord is "var" and create a "VAR DECLARATION" token for it
            if (currentWord.equals("var")) {
                addToTokens = new String[]{"VAR_DECLARATION", currentWord};
                tokens.add(Arrays.asList(addToTokens));
                // Using regex, this will recognise a word and create an IDENTIFIER token for it.
            } else if (currentWord.matches("[a-zA-Z]+")) {
                addToTokens = new String[]{"IDENTIFIER", currentWord};
                tokens.add(Arrays.asList(addToTokens));
            } else if (currentWord.matches("[0-9]+")) {
                addToTokens = new String[]{"INTEGER", currentWord};
                tokens.add(Arrays.asList(addToTokens));
            } else if (Arrays.asList(operatorsArray).contains(currentWord)) {
                addToTokens = new String[]{"OPERATOR", currentWord};
                tokens.add(Arrays.asList(addToTokens));
                // This will recognise an a semicolon [;] and create an SYMBOL token for it.
            } else if (currentWord.contains(";")) {
                if (currentWordWithoutSemiColon.matches("[a-zA-Z]+")) {
                    addToTokens = new String[]{"IDENTIFIER", currentWordWithoutSemiColon};
                    tokens.add(Arrays.asList(addToTokens));
                    addToTokens = new String[]{"SYMBOL", lastChar};
                    tokens.add(Arrays.asList(addToTokens));
                    // Using regex, this will recognise an integer and create a INTEGER token for it.
                }
                if (currentWordWithoutSemiColon.matches("[0-9]+")) {
                    addToTokens = new String[]{"INTEGER", currentWordWithoutSemiColon};
                    tokens.add(Arrays.asList(addToTokens));
                    addToTokens = new String[]{"SYMBOL", lastChar};
                    tokens.add(Arrays.asList(addToTokens));
                    // This will recognise an operator and create a OPERATOR token for it.
                }
            }
            sourceIndex++;
        } // end for loop
        return tokens;
    }
}

