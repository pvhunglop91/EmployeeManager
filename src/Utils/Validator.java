package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    public static String getString (BufferedReader br, String prompt){
        String st = "";
        try {
            System.out.print(prompt);
            st = br.readLine().trim();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return st;
    }

    public static int getInt (BufferedReader br, String prompt){
        int value = 0;
        boolean isCheck = false;
        do {
            try{
                System.out.print(prompt);
                value = Integer.parseInt(br.readLine().trim());
                isCheck = true;
            }catch (NumberFormatException e){
                System.out.println("Error! Invalid number, Try again! ");
            }catch (IOException f){
                System.out.println(f.getMessage());
            }
        }while (!isCheck);
        return value;
    }

    public static float getFloat (BufferedReader br, String prompt){
        float value = 0.0f;
        boolean isCheck = false;
        do {
            try{
                System.out.print(prompt);
                value = Float.parseFloat(br.readLine().trim());
                isCheck = true;
            }catch (NumberFormatException e){
                System.out.println("Error! Invalid number, Try again! ");
            }catch (IOException f){
                System.out.println(f.getMessage());
            }
        }while (!isCheck);
        return value;
    }

    public static double getDouble (BufferedReader br, String prompt){
        double value = 0.0;
        boolean isCheck = false;
        do {
            try{
                System.out.print(prompt);
                value = Double.parseDouble(br.readLine().trim());
                isCheck = true;
            }catch (NumberFormatException e){
                System.out.println("Error! Invalid number, Try again! ");
            }catch (IOException f){
                System.out.println(f.getMessage());
            }
        }while (!isCheck);
        return value;
    }

    public static boolean validPhone(String phone){
        String phonePattern = "^0\\d{9}$";
        return Pattern.matches(phonePattern,phone);
    }

    public static boolean validEmail(String email){
        String emailPattern =
                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        return email.matches(emailPattern);
    }
}
