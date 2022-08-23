/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 24/08/2022
 *   Time: 00:27
 *   File: ReverseWord.java
 */

package some_Question;

public class ReverseWord {
    private static final String WHITESPACE = " ";

    public static String reverseWords(String str) {
        String[] words = str.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();
        for (String word : words) {
            StringBuilder reverseWord = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord.append(word.charAt(i));
            }
            reversedString.append(reverseWord).append(WHITESPACE);
        }
        return reversedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("My name is Abhishek"));
    }

}