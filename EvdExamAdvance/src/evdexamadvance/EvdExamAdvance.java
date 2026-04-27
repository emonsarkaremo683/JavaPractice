package evdexamadvance;

import evdexamadvance.utils.Services;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvdExamAdvance {

    public static void main(String[] args) {

//        Services s = new Services();
//
//        s.saveData("Badrul Amin", "CEO", Date.valueOf("2025-06-30"), 50000.00);
//        s.saveData("Md Tanvir", "COO", Date.valueOf("2025-08-30"), 45000.00);
//        s.showAll();
//
//        s.updateData(2, "Md Tanvir Ahmed", "COO", Date.valueOf("2025-08-30"), 45000.00);
//        s.showAll();
//
//        s.deleteData(2);
//        s.showAll();
        List<String> names = Arrays.asList("Emon", "Elite", "Tech", "Emon");

        List<String> result = names.stream()
                .distinct() // duplicate বাদ
                .filter(n -> n.length() > 3) // শর্ত
                .sorted() // sort
                .collect(Collectors.toList()); // List এ ফেরত

        System.out.println(result);

    }

}
