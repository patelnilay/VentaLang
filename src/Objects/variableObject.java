package Objects;

public class variableObject {

    String execString = "";

    public String transpile(String name, String operator, String value){
        execString += name + " " + operator + " " + value;
        System.out.println(execString);
        return execString;
    }


}
