/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 24/08/2022
 *   Time: 00:40
 *   File: StringContainsDigitOnly.java
 */

package some_Question;

public class StringContainsDigitOnly {
    public static boolean containsOnlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(containsOnlyDigits("1234"));
        //output:- true
    }
}