package assistant;

import java.util.Random;

public class Arithmetic {


    Random valueGenerator = new Random();

    public int randomValueCheckBox() {

        int randomValueForCheckBox = valueGenerator.nextInt(2);

        return randomValueForCheckBox;
    }


    public int randomStategenerator(int k) {

        int randomState = valueGenerator.nextInt(k);

        return randomState;
    }


    public int dodawanie(int k, int m) {


        int suma = k + m;
        return suma;
    }


    public int liczbowanie(int m) {

        int liczba = 23;
        int licznik = 0;
        int liczba1;

        do {
            licznik++;
            //   System.out.println("Dzialanie nr " + licznik);
            liczba1 = liczba;
            liczba = liczba1 / 2;
            //   System.out.println("po działaniu " + liczba);

        } while (liczba != 0);
        // System.out.println("ilość działań: " + licznik);
        return licznik;
    }


    // Metoda zwracająca tablice:
    int checkBoxesNumber = 4;
    int checkingNumber = 2 ^ checkBoxesNumber;
    int randomFromCheckingNumber;


    public int[] checkedCheckBoxesArray(int randomFromCheckingNumber) {


        int actionCounter = 0;
        int randomFromCheckingNumber1 = randomFromCheckingNumber;
        int randomFromCheckingNumber2;
        int randomFromCheckingNumber3 = randomFromCheckingNumber;
        int randomFromCheckingNumber4;

        do {
            actionCounter++;
            randomFromCheckingNumber2 = randomFromCheckingNumber1;
            randomFromCheckingNumber1 = randomFromCheckingNumber2 / 2;


        } while (randomFromCheckingNumber1 != 0);
// wyznaczmy rozmiar tablicy:
        int[] checkBoxesArray = new int[actionCounter];

        int checkValueAfterDivision;
        for (int ee = 0; ee < actionCounter; ee++) {
            System.out.println("ee = " + ee);
            checkValueAfterDivision = randomFromCheckingNumber3 % 2;
            randomFromCheckingNumber4 = randomFromCheckingNumber3;
            randomFromCheckingNumber3 = randomFromCheckingNumber4 / 2;
            System.out.println((actionCounter - 1) - ee);
            checkBoxesArray[((actionCounter - 1) - ee)] = checkValueAfterDivision;


        }

        return checkBoxesArray;

    }


    public int[] tablicowanie() {

        int[] tablica = new int[7];
        for (int t = 0; t < 7; t++)
            tablica[t] = 3 * t;


        return tablica;

    }


}
