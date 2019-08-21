package Parser;

import java.util.Arrays;
import java.util.List;

public class Parser {
    int tokenIndex = 0;

    public String parse(List<List<String>> tokens) {

        for (int i = 0; i < tokens.size(); i++) {

            String tokenType = tokens.get(i).get(0);
            String tokenValue = tokens.get(i).get(1);

            // This will run when a Var declarion is found
            if (tokenType.equals("VAR_DECLARATION") && tokenValue.equals("var")) {
                List<List<String>> subList = tokens.subList(0, tokens.size());
                parseVarDeclarations(subList);
//                System.out.println("tokenIndex = " + tokenIndex + "\t|\t" + "tokenType = " + tokenType + "\t|\t" + "tokenValue = " + tokenValue);
            }

            tokenIndex++;
        }
        return "";
    }

    private void parseVarDeclarations(List<List<String>> tokenStream) {

        String[] tokenTypesList = {"INTEGER", "IDENTIFIER", "STRING"};

        int tokensChecked = 0;

        int bound = tokenStream.size();
        for (int token = 0; token < bound; token++) {
            String tokenType = tokenStream.get(tokensChecked).get(0);
            String tokenValue = tokenStream.get(tokensChecked).get(1);


            // breaks if ';' is found as var is parsed.
            if (tokenType == "STATEMENT_END") {
                System.exit(0);
            } else if (token == 1 && tokenType == "IDENTIFIER") {
                System.out.println("Variable name: " + tokenValue);
            } else if (token == 1 && tokenType != "IDENTIFIER") {
                System.out.println("ERROR: Invalid variable name \"" + tokenValue + "\"");
                System.exit(0);
            }
            // Gets var assignment operator (=) and also does error validation
            else if (token == 2 && tokenType == "OPERATOR") {
                System.out.println("Assignment Operator: " + tokenValue);
            } else if (token == 2 && tokenType != "OPERATOR") {
                System.out.println("ERROR: Invalid operator is missing or invalid");
                System.exit(0);
            }
            //gets var assigned and does some error validation
            else if (token == 3 && Arrays.asList(tokenTypesList).contains(tokenType)) {
                System.out.println("Variable Value " + tokenValue);
            } else if (token == 3 && !Arrays.asList(tokenTypesList).contains(tokenType)) {
                System.out.println("ERROR: Invalid variable assignment value \"" + tokenValue + "\"");
                System.exit(0);
            }

            tokensChecked++;

            tokenIndex += tokensChecked;
        }


    }

}
