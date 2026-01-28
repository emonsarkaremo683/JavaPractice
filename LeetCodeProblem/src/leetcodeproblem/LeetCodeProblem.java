package leetcodeproblem;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class LeetCodeProblem {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        converter(scanner.nextLine());
//        String[] strs = {"ab", "a"};
//        longestCommonPrefix(strs);

        long ac = Long.parseLong("111", 2);
        long ab = Long.parseLong("11", 2);

        int ad = (int)(ac + ab);
        
        System.out.println(Integer.toBinaryString(ad));
        
        
    }

    // convert roman number to number
    static void converter(String s) {
        String[] arrays = {"I", "V", "X", "L", "C", "D", "M"};
        int[] intArray = {1, 5, 10, 50, 100, 500, 1000};

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));

            if (i + 1 < s.length() && value < map.get(s.charAt(i + 1))) {
                sum -= value;
            } else {
                sum += value;
            }

        }

    }

    // isPalindrome
    public static boolean isPalindrome(int x) {
        int rem;
        int a = x;
        int rev = 0;
        while (x > 0) {
            rem = x % 10;
            rev = (rev * 10) + rem;
            x /= 10;
        }

        boolean e;
        e = rev == a;
        return e;
    }

    public static void longestCommonPrefix(String[] strs) {

        String st = "";

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].startsWith(st)) {

            } else {
                st = "";
                break;
            }

        }
        System.out.println(st);

    }

}
