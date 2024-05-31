# GameShop
## Nazwa Projektu: Zarządzanie książkami

- [Opis Projektu](##Opis-Projektu)
- [Spis Funkcjonalności](##Spis-Funkcjonalności)
    - [Zaimplementowane Funkcjonalności](##Zaimplementowane-Funkcjonalności)
- [Instrukcje Obsługi](#Instrukcje-Obsługi)
- [Uruchomienie Aplikacji](#Uruchomienie-Aplikacji)

## Opis-Projektu
Projekt GameShop to aplikacja desktopowa stworzona w Apache NetBeans, umożliwiająca zarządzanie zbiorem gier. Aplikacja jest zaprojektowana tak, aby ułatwić użytkownikom przeglądanie, dodawanie, edytowanie oraz usuwanie danych związanych z grami.

## Spis-Funkcjonalności
- Przeglądanie Zasobów: Użytkownicy mogą przeglądać listę dostępnych gier.
- Dodawanie Nowych Pozycji: Możliwość dodawania nowych gier do bazy danych.
- Edycja Istniejących Pozycji: Użytkownicy mogą aktualizować informacje o grach.
- Usuwanie Pozycji: Funkcja umożliwiająca usuwanie gier z bazy danych.
- Sortowanie: Możliwość sortowania gier na podstawie różnych kryteriów (Ocena, Rok wydania itp).

## Zaimplementowane-Funkcjonalności
1. Interfejs graficzny aplikacji (NewJFrame.java):

    - Aplikacja posiada graficzny interfejs użytkownika (GUI) z przyciskami do dodawania i usuwania gier,<br> a także do sortowania gier według oceny. Przyciski te obsługują zdarzenia kliknięcia myszką.
    - Interfejs zawiera etykiety i panele zdefiniowane za pomocą biblioteki javax.swing.

2. Dialog gry (GameDialog.java):

    - Okno dialogowe, które umożliwia dodawanie nowej gry do systemu, z możliwością wprowadzenia takich informacji jak<br> tytuł, platforma, rok wydania, cena, producent i ocena gry.<br>
Przyciski w dialogu obsługują zdarzenia kliknięcia, umożliwiając dodawanie gier do bazy danych aplikacji.
3. Logika aplikacji (Gra.java):

    - Klasa Gra reprezentuje pojedynczą grę z atrybutami takimi jak tytuł, platforma, rok wydania, cena, producent i ocena.
    - Istnieje lista gier, która służy jako baza danych przechowująca wszystkie gry.
    - Możliwość dodawania gier do bazy danych oraz ich usuwania na podstawie tytułu.
    - Funkcje sortujące gry na podstawie oceny, roku produkcji.

4. Projekt Maven (Mavenproject4.java):

    - Plik, który prawdopodobnie zawiera dodatkową konfigurację dla projektu Maven, lecz treść tego pliku nie była dostępna z powodu ograniczeń długości odpowiedzi.



## Instrukcje-Obsługi
Aplikacja została zaprojektowana w środowisku Apache NetBeans i korzysta z Mavena jako systemu zarządzania projektami i zależnościami.

## Uruchomienie-Aplikacji
1. Ściągnij i zainstaluj Apache NetBeans (jeżeli jeszcze nie posiadasz).

2. Klonuj repozytorium: <br>
``` git clone https://github.com/Raszka1/GameShop.git```

3. Otwórz projekt w NetBeans:

&nbsp; &nbsp; Wybierz `File > Open Project` projekt i znajdź pobrany projekt.

4. Uruchom projekt:

&nbsp; &nbsp; W NetBeans kliknij prawym przyciskiem myszy na projekt w `Projects` i wybierz `Run`



