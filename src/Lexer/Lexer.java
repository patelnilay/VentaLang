package Lexer;


import java.util.ArrayList;

public class Lexer{

    public ArrayList tokenise(String sourceCode){
        ArrayList tokens = new ArrayList();
        String[] SplitSourceCode;
        SplitSourceCode = sourceCode.split(" ");
        int sourceIndex = 0;

        while (sourceIndex < SplitSourceCode.length){
            System.out.println(SplitSourceCode[sourceIndex]);
            sourceIndex ++;
        }
        return tokens;
    }

}
