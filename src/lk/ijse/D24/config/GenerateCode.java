package lk.ijse.D24.config;

import java.util.Random;

public class GenerateCode {
    public static int verifyCode(){
        Random rand = new Random();
        int verify = rand.nextInt(10000);
        return verify;
    }
}
