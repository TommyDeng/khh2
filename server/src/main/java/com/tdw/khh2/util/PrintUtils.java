package com.tdw.khh2.util;

public class PrintUtils {
    public static void printCurrentMethod() {
        System.out.println
                ("The method name is: " + new Exception().getStackTrace()[0].getMethodName());
    }
}
