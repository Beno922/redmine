# Redmine beadandó

## Futtatáshoz szükséges

- Java 17+ és Maven 3.5+ a PATH-ban

## Telepítés és futtatás

A projekt főkönyvtárában futtatni a következő parancsot:

```bash
mvn clean install
```
Ezután futtatható az alkalmazás.

## 1. mérföldkő:
- API-k létrehozva, a dokumentáció indítást követően elérhető a "http://localhost:8080/swagger-ui/index.html#/" oldalon. 
- Tesztelésnél a "projects" és a "tasks" végpont statikus HTML-oldalakat ad vissza, beégetett adatokkal."


## 2. mérföldkő:
- Adatbázisszerverrel összekötve, adatok a konfigurációs fájlban.
- Lekérdezések működnek.

