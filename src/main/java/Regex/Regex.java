package Regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {
    public static String[] match(String regexPattern,String text){
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
}
