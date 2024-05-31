package com.mycompany.mavenproject4;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Zuzanna Raszka
 */
public class Gra {
    //#1
    //Zmienne
    private String tytul;
    private String platforma;
    private int rokWydania;
    private double cena;
    private String producent;
    private double ocena;

    //Konstruktor
    public Gra(String tytul, String platforma, int rokWydania, double cena, String producent, double ocena) {
        this.tytul = tytul;
        this.platforma = platforma;
        this.rokWydania = rokWydania;
        this.cena = cena;
        this.producent = producent;
        this.ocena = ocena;
    }
    
    //Metoda do wyświetlania informacji
    public void wyswietlInfo() {
        System.out.println("Tytuł: " + tytul + ", Platforma: " + platforma + ", Rok wydania: " + rokWydania + ", Cena: " + cena + " zł, Producent: " + producent + ", Ocena: " + ocena);
    }

    //Metoda dodania do bazy danych
    public static void dodajDoBazy(List<Gra> baza, Gra gra) {
        baza.add(gra);
        System.out.println("Gra została dodana do bazy danych.");
    }

    
    // Gettery
    public String getTytul() {
        return tytul;
    }
    public String getPlatforma() {
        return platforma;
    }
    
    public int getRokWydania() {
        return rokWydania;
    }
    
    public double getCena() {
        return cena;
    }
    
    public String getProducent() {
        return producent;
    }
    
    public double getOcena() {
        return ocena;
    }
    
    // Settery
    public void setCena(double cena) {
        this.cena = cena;
    }
    
}
