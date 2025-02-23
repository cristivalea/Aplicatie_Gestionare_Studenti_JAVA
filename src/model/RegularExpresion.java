package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpresion {
    public static boolean RegularExpresionData(String linie){
        linie = linie.trim();
        Pattern pattern = Pattern.compile("[123]?\\d\\/[1]?\\d\\/\\d{4}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(linie);
        boolean matchFound = matcher.find();
        return matchFound;
    }

    public static boolean RegularExpresionNrMatricol(String linie){
        linie = linie.trim();
        Pattern pattern = Pattern.compile("CTI\\d{3}[1-9]\\d{2}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(linie);
        boolean matchFound = matcher.find();
        return matchFound;
    }

    public static boolean RegularExpresionNumePrenume(String linie){
        linie = linie.trim();
        Pattern pattern = Pattern.compile("^[A-ZĂÂÎȘȚ][a-zăâîșț]*$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(linie);
        boolean matchFound = matcher.find();
        return matchFound;
    }

    public static boolean RegularExpresionStudent(String linie){
        linie = linie.trim();
        Pattern pattern = Pattern.compile("CTI\\d{3}[1-9]\\d{2}\\;[A-Z]\\w*\\;([A-Z]\\w*\\s?)+\\;[123]?\\d\\/[1]?\\d\\/\\d{4}\\;[123]?\\d\\/[1]?\\d\\/\\d{4}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(linie);
        boolean matchFound = matcher.find();
        return matchFound;
    }

    public static boolean RegularExpresionLinieNotaCalificativ(String linie){
        linie = linie.trim();
        Pattern pattern = Pattern.compile("[C]\\;[A-Z]{3}\\d{3}[1-9]\\d{2}\\;[1-9]\\d{2};([A-Z]+\\s?)*\\;[1-3]?\\d\\/[1]?\\d\\/\\d{4}");
        Matcher matcher = pattern.matcher(linie);
        boolean matcherFound = matcher.find();
        return matcherFound;
    }

    public static boolean RegularExpresionLinieNotaAR(String linie){
        linie = linie.trim();
        Pattern pattern = Pattern.compile("[A]\\;[A-Z]{3}\\d{3}[1-9]\\d{2}\\;[1-9]\\d{2};([A-Z]+\\s?)*\\;[1-3]?\\d\\/[1]?\\d\\/\\d{4}");
        Matcher matcher = pattern.matcher(linie);
        boolean matcherFound = matcher.find();
        return matcherFound;
    }

    public static boolean RegularExpresionLinieNotaNumerica(String linie){
        linie = linie.trim();
        Pattern pattern = Pattern.compile("[N]\\;[A-Z]{3}\\d{3}[1-9]\\d{2}\\;[1-9]\\d{2}\\;([1-9][0]?\\;){4}([0](\\,\\d)\\;?){4}[1-3]?\\d\\/[1-9]?[1-2]?\\/\\d{4}");
        Matcher matcher = pattern.matcher(linie);
        boolean matcherFound = matcher.find();
        return matcherFound;
    }
}
