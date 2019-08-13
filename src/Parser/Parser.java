package Parser;

import java.util.List;

public class Parser {

    public String parse(List<List<String>> tokens) {
        int tokenIndex = 0;

        for (int i = 0; i < tokens.size(); i++) {

            String tokenType = tokens.get(i).get(0);
            String tokenValue = tokens.get(i).get(1);

            System.out.println("tokenIndex = " + tokenIndex + "\t|\t" + "tokenType = " + tokenType + "\t|\t" + "tokenValue = " + tokenValue);

            tokenIndex++;
        }
        return "";
    }

}
