package com.mycompany.mavenproject4;

import com.mycompany.mavenproject4.Gra;
import com.mycompany.mavenproject4.Mavenproject4;
import java.awt.GridLayout;
import javax.swing.*;

public class GameDialog extends JDialog {
    private JTextField titleField, platformField, yearField, priceField, producerField, ratingField;
    private JButton saveButton, cancelButton;

    public GameDialog(JFrame parent) {
        super(parent, "Dodaj Grę", true);
        setSize(300, 400);
        setLayout(new GridLayout(7, 2));

        add(new JLabel("Tytuł:"));
        titleField = new JTextField(10);
        add(titleField);

        add(new JLabel("Platforma:"));
        platformField = new JTextField(10);
        add(platformField);

        add(new JLabel("Rok Wydania:"));
        yearField = new JTextField(10);
        add(yearField);

        add(new JLabel("Cena:"));
        priceField = new JTextField(10);
        add(priceField);

        add(new JLabel("Producent:"));
        producerField = new JTextField(10);
        add(producerField);

        add(new JLabel("Ocena:"));
        ratingField = new JTextField(10);
        add(ratingField);

        saveButton = new JButton("Zapisz");
        saveButton.addActionListener(e -> saveGame());
        add(saveButton);

        cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(e -> setVisible(false));
        add(cancelButton);

        setLocationRelativeTo(parent);
    }

    private void saveGame() {
        // Tutaj logika do zapisania danych gry
        // Możesz zrobić coś takiego:
        String title = titleField.getText();
        String platform = platformField.getText();
        int year = Integer.parseInt(yearField.getText());
        double price = Double.parseDouble(priceField.getText());
        String producer = producerField.getText();
        double ocena = Double.parseDouble(ratingField.getText());

        Gra newGame = new Gra(title, platform, year, price, producer, ocena);
        Mavenproject4.dodajDoBazy(newGame);  // Zakładając, że ta metoda istnieje

        // Odświeżenie tabeli w głównym oknie
        ((NewJFrame) getParent()).refreshTable();
        
        setVisible(false);  // Zamknij dialog po zapisie
    }
}
