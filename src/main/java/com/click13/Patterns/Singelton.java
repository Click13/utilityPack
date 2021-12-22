package com.click13.Patterns;

public class Singelton {
    private static Singelton instanz = null;

    private Singelton(){}

    public static synchronized Singelton getInstanz(){
        if (instanz == null){
            instanz = new Singelton();
            return instanz;
        }
        else{
            return instanz;
        }
    }
    
}
