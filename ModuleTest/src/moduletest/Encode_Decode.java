/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduletest;

import java.util.Base64;

/**
 *
 * @author smitj
 */
public class Encode_Decode {

    public static void main(String[] args) {
        Base64.Encoder encoder = Base64.getEncoder();
        String password="admin";
        String str = encoder.encodeToString(password.getBytes());
        System.out.println("Encoded string: " + str);
        System.out.println("Length_pwd: "+password.length());
        System.out.println("Length_enc: "+str.length());
        // Getting decoder  
        Base64.Decoder decoder = Base64.getDecoder();
        // Decoding string  
        String dStr = new String(decoder.decode(str));
        System.out.println("Decoded string: " + dStr);
    }

}
