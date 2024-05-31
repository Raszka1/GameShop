package com.mycompany.mavenproject4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author Zuzanna Raszka
 */
public class  Mavenproject4 {
    private static List<Gra> bazaDanych = new ArrayList<>();   
    
    
    public static void initializeData() {
        // Tutaj dodajemy gry do bazy danych
        bazaDanych.add(new Gra("The Witcher 3", "PC", 2015, 89.99, "CD Projekt Red", 9.5));
        bazaDanych.add(new Gra("Cyberpunk 2077", "PC", 2020, 199.99, "CD Projekt Red", 8.0));
        bazaDanych.add(new Gra("Red Dead Redemption 2", "PS4", 2018, 249.99, "Rockstar Games", 9.8));
        bazaDanych.add(new Gra("God of War", "PS4", 2018, 199.99, "Santa Monica Studio", 9.7));
        bazaDanych.add(new Gra("Minecraft", "PC", 2011, 99.99, "Mojang", 9.0));
        bazaDanych.add(new Gra("Fortnite", "PC", 2017, 0.00, "Epic Games", 8.5));
        bazaDanych.add(new Gra("The Legend of Zelda: Breath of the Wild", "Switch", 2017, 249.99, "Nintendo", 9.6));
        bazaDanych.add(new Gra("Hades", "PC", 2020, 99.99, "Supergiant Games", 9.2));
        bazaDanych.add(new Gra("Among Us", "PC", 2018, 19.99, "InnerSloth", 8.0));
        bazaDanych.add(new Gra("Dark Souls III", "PC", 2016, 199.99, "FromSoftware", 9.1));
        bazaDanych.add(new Gra("Sekiro: Shadows Die Twice", "PC", 2019, 199.99, "FromSoftware", 9.3));
        bazaDanych.add(new Gra("Horizon Zero Dawn", "PS4", 2017, 199.99, "Guerrilla Games", 9.0));
        bazaDanych.add(new Gra("Persona 5", "PS4", 2016, 199.99, "Atlus", 9.4));
        bazaDanych.add(new Gra("Super Mario Odyssey", "Switch", 2017, 249.99, "Nintendo", 9.7));
        bazaDanych.add(new Gra("Doom Eternal", "PC", 2020, 199.99, "id Software", 9.0));
        bazaDanych.add(new Gra("Resident Evil Village", "PC", 2021, 249.99, "Capcom", 8.5));
        bazaDanych.add(new Gra("Ghost of Tsushima", "PS4", 2020, 249.99, "Sucker Punch Productions", 9.3));
        bazaDanych.add(new Gra("Assassin's Creed Valhalla", "PC", 2020, 249.99, "Ubisoft", 8.2));
        bazaDanych.add(new Gra("Death Stranding", "PS4", 2019, 199.99, "Kojima Productions", 8.6));
        bazaDanych.add(new Gra("Final Fantasy VII Remake", "PS4", 2020, 249.99, "Square Enix", 9.0));
        bazaDanych.add(new Gra("The Last of Us Part II", "PS4", 2020, 249.99, "Naughty Dog", 9.3));
        bazaDanych.add(new Gra("Bloodborne", "PS4", 2015, 199.99, "FromSoftware", 9.1));
        bazaDanych.add(new Gra("Animal Crossing: New Horizons", "Switch", 2020, 249.99, "Nintendo", 8.9));
        bazaDanych.add(new Gra("Control", "PC", 2019, 199.99, "Remedy Entertainment", 8.7));
        bazaDanych.add(new Gra("Ori and the Will of the Wisps", "PC", 2020, 99.99, "Moon Studios", 9.2));

        

    }
    
    public static void dodajDoBazy(Gra nowaGra) {
        bazaDanych.add(nowaGra);
        // Tutaj możesz dodać więcej logiki, np. zapis do bazy danych jeśli używasz bazy danych
    }
    
    //getter
    public static List<Gra> getBazaDanych() {
        return bazaDanych;
    }
    
     public static void usunZBazy(String gameTitle) {
        bazaDanych.removeIf(gra -> gra.getTytul().equals(gameTitle));
    }
     
    
    
    public static void main(String[] args) {
        initializeData();
        System.out.println("Witaj w aplikacji GameShop");

        //inicjujemy listę 📑 z naszymi grami 👾
        java.awt.EventQueue.invokeLater(() -> {
            new NewJFrame().setVisible(true);
        });

        // Tworzenie obiektu gry
        Collections.sort(bazaDanych, Comparator.comparingDouble(Gra::getOcena).reversed());
        
        System.out.println("Sortowanie po ocenie:");
        bazaDanych.forEach(gra -> System.out.println(gra.getTytul() + " - " + gra.getOcena()));

        // Wyświetlanie informacji o grach za pomocą pętli
        for (Gra gra : bazaDanych) {
            gra.wyswietlInfo();
        }

        // Dodawanie gry do bazy danych
        //Gra.dodajDoBazy(bazaDanych, );
    }
    
}
