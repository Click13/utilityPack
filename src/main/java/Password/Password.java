package Password;

public class Password {
    
    public static boolean isPasswordComplex(String password){
        if (password.length() < 6){
            return false;
        }
        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasLowerCase = false;
        for (int i = 0; i < password.length(); i++){
            if(Character.isDigit(password.charAt(i))){
                hasNumber = true;
            }
            if(Character.isUpperCase(password.charAt(i))){
                hasUpperCase = true;
            }
            if(Character.isLowerCase(password.charAt(i))){
                hasLowerCase = true;
            }
        }
        return hasLowerCase && hasNumber && hasUpperCase;
    }
}
