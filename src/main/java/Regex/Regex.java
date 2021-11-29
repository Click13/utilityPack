package Regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {

    public static String[] search(String regexPattern,String text){
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(text);
        String[] out = new String[matcher.groupCount()+1];
        while(matcher.find()){
            for(int i = 0; i <= matcher.groupCount(); i++){
                out[i] = matcher.group(i);
            }
        }
        return out;
    }

    public static String delete(String regexPattern, String text){
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(text);
        String out = matcher.replaceAll("");
        return out;
    }

    public static String replace(String regexPattern, String text, String replacement){
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(text);
        String out = matcher.replaceAll(replacement);
        return out;
    }
}
