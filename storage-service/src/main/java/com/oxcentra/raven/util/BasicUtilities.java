package com.oxcentra.raven.util;

import com.oxcentra.raven.entity.Contacts;
import com.oxcentra.raven.entity.SmsCampaign;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicUtilities<T> {

    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void sleep(long waitTimeInMillis) {
        try {
            Thread.sleep(waitTimeInMillis);
        } catch (Exception e) {

        }
    }

    public static boolean ifExists(int size) {
        if (size > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String generateContentbyTemplate(String contentTemplate) {
        String[] msgTemplate;
        String responceSMS = "";
        String responceSMSOutBox = "";
//       Dear {name}, Please visit this https://www.w3schools.com/  to get unbeliverable offer now!
        if (contentTemplate != null && contentTemplate != "") {
            msgTemplate = contentTemplate.split("\\|");
            for (int i = 0; i < msgTemplate.length; i++) {
                if(i%2 == 0){
                    responceSMS = responceSMS + msgTemplate[i];
                    responceSMSOutBox = responceSMSOutBox + msgTemplate[i];
                }
                if(i%2 == 1) {

                }
            }
        }
        return "";
    }

    public static String generateContentbyTemplate_( Contacts contacts, SmsCampaign smsCampaign) {
        String generatedContent = null;
        generatedContent = smsCampaign.getContentTemplate().replace("{name}",contacts.getName());
        generatedContent = generatedContent.replace("{url}","");
        return generatedContent;
    }

    public static String maskContent(String line) {
//      "Hey Jayana, your Vpay PIN is [12345678] for Tx done by ACC 780[111100]"
        String regex = "(?<=\\[)(.*?)(?=\\])";
        Pattern pattern = Pattern.compile(regex);
        String maskChar = "";
        Matcher m = pattern.matcher(line);
        int round = 0;
        while (m.find()) {
            for (int i = 0; i < m.group(round).length(); i++) {
                maskChar = maskChar + "*";
            }
            line = line.replace("[" + m.group(round) + "]", maskChar);
            maskChar = "";
            round++;
        }
        return line;
    }
}
