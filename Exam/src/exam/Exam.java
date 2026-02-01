package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] single = {8350, 33950, 82250, 171550, 372950, 372951};

        int[] married = {19700, 67900, 137050, 208850, 372950, 372951};

        int[] seperate = {8350, 33950, 68525, 104425, 186475, 186476};

        int[] headOfHouseHold = {11950, 45500, 117450, 190200, 372950, 372951};

        int[] tax = {10, 15, 25, 28, 33, 35};
        Map<String, Integer> map = new HashMap<>();

        map.put("single", 0);
        map.put("married", 1);
        map.put("seperate", 2);
        map.put("Head Of HouseHold", 3);

        System.out.println("Enter your position, please use number, look at the below for ref");
        System.out.println(map.toString());

        int a = sc.nextInt();

        System.out.println("Enter your Salary");
        int sal = sc.nextInt();

        switch (a) {
            case 0:
                calculation(sal, single, tax);
                break;
            case 1:
                calculation(sal, married, tax);
                break;
            case 2:
                calculation(sal, seperate, tax);
                break;
            case 3:
                calculation(sal, headOfHouseHold, tax);
                break;
            default:
                System.out.println("Inavlid");
        }

    }

    static void calculation(int salary, int[] value, int[] taxRate) {
        System.out.println(valueCal(salary, value, taxRate));
    }

    static double valueCal(int salary, int[] values, int[] tax) {
        double a = 0.0;

        if (salary <= 0) {
            return 0;
        }

        for (int i = 0; i < values.length; i++) {
    if (salary > values[i]) {
        a += values[i] * tax[i] / 100.0;
        salary -= values[i];
    } else {
        a += salary * tax[i] / 100.0;
        break;
    }
}
        return a;
    }

}
