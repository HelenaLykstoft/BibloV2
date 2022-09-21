package Util;

import java.util.Scanner;

public class UserInput {

    public static String getString(String s){
        Scanner scanner = new Scanner(System.in);
        System.out.println(s + " : ");
        return scanner.nextLine();

    }

    public static int getInt(String s){
        while (true) {
            try {
                int i = Integer.parseInt(getString(s));
                return i;
            } catch (NumberFormatException e) {
                System.out.println("Remember it needs to be a number");
            }
        }
    }
}
