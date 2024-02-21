public class ContainsLetter {

    public static boolean containsLetter(String letter, String word) {
        if (word.length() == 0) {
            return false;
        }

        String curChar = word.substring(0,1);
        if (curChar.equals(letter)) {
            return true;
        }

        return containsLetter(letter, word.substring(1)); //each recursive call moves closer to the base case
    }
}
