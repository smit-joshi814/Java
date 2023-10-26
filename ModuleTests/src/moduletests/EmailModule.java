/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moduletests;

import java.util.Properties;

/**
 *
 * @author smitj
 */
public class EmailModule {
    public static void main(String[] args){
        EmailModule m=new EmailModule();
        String to="smitjoshi814@gmail.com";
        String from="yeshoopmailservice@gmail.com";
        String subject="sending Email From Java mail";
        String text="Sample Text";
        
        boolean b=m.sendEmail(to,from, subject, text);
        if(b){
            System.out.println("mail Sent Success");
        }else{
            System.out.println("can't send Mail");
        }
    }
    
    public boolean sendEmail(String to,String from,String subject,String text){
        boolean flag=false;
        
        Properties properties=new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.host","smtp.gmail.com");
        
       //Session session=
        return false;
    }
}
