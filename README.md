# BookStore
BookStore (Spring Framework)
student: Anhelina Piatrovich


#Uruchamianie aplikacji.
W pliku SQL znajduje się skrypt do stworzenia wszystkich tabel oraz skrypt 
do uzupełnienia tabel (z wyjątkiem tabel users i authorities). 
Aby przetestować aplikację, należy stworzyć użytkownika poprzez endpoint /register oraz administratora poprzez endpoint /adminregister.

#Funkcjonalność. 
Aplikacja posiada CRUD dla książek, wyświetlanie i dodawanie autorów oraz wyświetlanie i dodawanie kategorii.
Stworzony jest koszyk, który przechowuje książki. Użytkownik może dodawać i usuwać książki w koszyku,
a także wyświetlać książki, autorów oraz kategorie.

Inne funkcjonalności, takie jak dodawanie autorów, kategorii oraz dodawanie, usuwanie i edytowanie książek,
są dostępne tylko dla administratora.
