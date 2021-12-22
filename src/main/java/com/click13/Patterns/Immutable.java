package Patterns;

public final class Immutable {
    private final int monat;
    private final int[] werte;

    public Immutable(int monat, int[] werte){
        this.monat = monat;
        this.werte = (int[]) werte.clone();
    }

    public final int getMonat(){
        return monat;
    }

    public final int getWert(int index){
        return werte[index];
    }

    public final int getMengeWerte(){
        return werte.length;
    }
}
