/**
 *A class providing a particular string validator.
 *
 * @author Samir Dzhavid
 * @version 09/11/2020
 */
public class Validate {
    
    /**
     *Validate the string following these rules:
     * First character must be Upper case.
     * Last character must be lower case and match the first character.
     * @param stringToBeTested The string which is tested in the function.
     * @return boolean
     */

    public static boolean isValidExpression2(String stringToBeTested){
        char firstChar = stringToBeTested.charAt(0);
        char lastChar = stringToBeTested.charAt(stringToBeTested.length() - 1);

        if (Character.toLowerCase(firstChar) == lastChar) {
            return stringToBeTested.matches("[ABC][ABCabc]*[abc]");
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("AaBb - " + isValidExpression2("AaBb"));
        System.out.println("BCAacb - " + isValidExpression2("BCAacb"));
        System.out.println("BCcAab - " + isValidExpression2("BCcAaAAb"));
        System.out.println("ACABbBbaca - " + isValidExpression2("ACABbBbaca"));
        System.out.println("AabB - " + isValidExpression2("AabB"));
        System.out.println("BCAcaB - " + isValidExpression2("BCAcaB"));

    }
}
