
/**
 *A class providing a particular string validator.
 *
 * @author Samir Dzhavid
 * @version 10/11/2020
 */

public class Validate {

    /**
     * Validate the expression following these rules:
     * First character of a phrase must be Upper case.
     * Last character of a phrase must be lower case.
     * Characters that can be used - {A, B, C, a, b, c}
     * Expression can be valid only if the phrase/phrases are.
     *
     * @param expression The string which is tested in the function.
     * @return boolean
     */

    public static boolean isValidExpression(String expression) {
        int length = expression.length();
        int firstLetter;
        int lastLetter;
        int currentLetter;
        int startingNum = 0;

        while (true) {
            firstLetter = expression.charAt(startingNum);
            lastLetter = expression.charAt(length - 1);
            //if first letter is lower case, expression must be invalid
            if (firstLetter > 96 && firstLetter < 100) return false;
            //if last letter is not lower case, expression must be invalid
            if (!(lastLetter > 96 && lastLetter < 100)) return false;
            /* if last letter is the lower case version of the first letter,
                the expression is automatically valid */
            if (lastLetter == firstLetter + 32) return true;
            //check if the expression has multiple phrases
            for (int i = 1; i < length - startingNum; i++) {
                currentLetter = expression.charAt(i);
                /* if a lower case letter matches the first letter,
                    we have found a complete valid phrase and should move on to
                    the next phrase */
                if (currentLetter == firstLetter + 32) {
                    /* one letter phrases don't exist, so if the matching
                        letter is the second to last letter, the expression is invalid */
                    if (i == length - 2) return false;

                    startingNum = i + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("AaBb - " + isValidExpression("AaBb"));
        System.out.println("BCAacb - " + isValidExpression("BCAacb"));
        System.out.println("BCcAab - " + isValidExpression("BCcAaAAb"));
        System.out.println("ACABbBbaca - " + isValidExpression("ACABbBbaca"));
        System.out.println("AabB - " + isValidExpression("AabB"));
        System.out.println("BCAcaB - " + isValidExpression("BCAcaB"));


    }
}
