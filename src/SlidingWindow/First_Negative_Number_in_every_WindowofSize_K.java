/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 20/03/2022
 *   Time: 18:29
 *   File: First_Negative_Number_in_every_WindowofSize_K.java
 */

package SlidingWindow;

import java.util.ArrayList;
import java.util.Scanner;

public class First_Negative_Number_in_every_WindowofSize_K {
    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        int T = s1.nextInt();
        while (T > 0) {
            int N = s1.nextInt();
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = s1.nextInt();

            list.clear();
            int K = s1.nextInt();
            firstNegative(arr, K, list);
            System.out.println();
            T--;
        }
    }


    public static void firstNegative(int arr[], int K, ArrayList<Integer> list) {
        int i = 0, j = 0;
        while (j < arr.length) {
            if (arr[j] < 0) {
                list.add(arr[j]);
            }

            if (j - i + 1 < K)
                j++;

            else {
                if (list.size() == 0)
                    System.out.print(0 + " ");
                else {
                    System.out.print(list.get(0) + " ");
                    if (arr[i] == list.get(0)) {
                        list.remove(0);
                    }
                }
                i++;
                j++;
            }

        }
    }
}