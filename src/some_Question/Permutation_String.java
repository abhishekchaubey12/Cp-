/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 15/03/2022
 *   Time: 19:27
 *   File: Permutation_String.java
 */

package some_Question;

public class Permutation_String {
    public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public static boolean per(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    public static void main(String[] args) {
        System.out.println(per("god", "dog"));
    }
}