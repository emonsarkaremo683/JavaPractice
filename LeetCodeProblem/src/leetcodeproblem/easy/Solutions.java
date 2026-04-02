package leetcodeproblem.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solutions {

    public void converter(String s) {

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

    public boolean isPalindrome(int x) {
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

    public void longestCommonPrefix(String[] strs) {

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

    public int lengthOfLastIndex(String s) {
        String a = s.trim();
        String[] arr = a.split(" ");

        return arr[arr.length - 1].length();
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int removeElement(int[] nums, int val) {
        int count = 0;

        for (int a : nums) {
            if (a != val) {
                nums[count] = a;
                count++;

            }
        }

        return count;
    }

    public int excelColumnToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            result = (result * 26) + c - 'A' + 1;

        }
        return result;
    }

    // 1 = A = 65 = 
    public String convertToTitle(int columnNumber) {
        int n = columnNumber;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            int curr = n % 26;
            n /= 26;
            System.out.println(n);
            sb.append((char) (curr + 'A'));
        }
        return sb.reverse().toString();

    }

    public int singleNumber(int[] nums) {

        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;

    }

    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10;
            result = result * 10 + digit;
            x /= 10;
        }

        return result;
    }
}
