package com.example.educationsystemwebabb;

public class Parametr {

    public static String get(String value) {
        if (value!=null)  return value;
        return "";
    }

    public static Integer parseInt(String value) {
        if (value!=null&& value.trim().length()>0 )
            return Integer.parseInt(value.trim());
        return null;
    }

    public static Double parseDouble(String value) {
        if (value!=null&& value.trim().length()>0 )
            return Double.parseDouble(value.trim());
        return null;
    }
}
