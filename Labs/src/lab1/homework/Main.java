package lab1.homework;

import java.util.*; // pt ex 2 la array
public class Main {
    public static void main(String[] args) {

//////////////EX1////////////////////
//    public class Test {
//
//        public static void main(String args[]) {
//            int x = Integer.parseInt("9");
//            double c = Double.parseDouble("5");
//            int b = Integer.parseInt("444", 16); fara baza ia automat baza 10
//
//            System.out.println(x); -> 9
//            System.out.println(c); -> 5.0
//            System.out.println(b); -> 1092
//        } -> can do parsing with this method, used in the mandatory exercises



        String input = "1"; // numar de verificat,  String arg = args[0];
        boolean isInt = true; // bool pt verificare

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                isInt = false; // daca avem orice simbol (virgula,)
                break;
            }
        }

        if (isInt) {
            int n = Integer.parseInt(input); // daca e valid parsare ca int
            System.out.println(input + " e valid");
        } else {
            System.out.println(input + " nu e valid");
        }

/////////////EX2/////////////////

        int n = Integer.parseInt(args[0]); // dimensiunea matricei
        int[][] matrice= new int[n][n]; // initierea matricei ->  (j + i) % n + 1 sa nu aveam numere care se repeta pe rand/coloana
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrice[i][j] = (j + i) % n + 1;
            }
        }

        // print the Latin Square matrix
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrice[i])); //Arrays.toString -> metoda ce converteste array-ul intr-un sir cu toate elementele matricei intre paranteze patrate si cu virgula intre, apoi printeaza rand cu rand pana se termina iteratia
        }


////////////EX3////////////

// concat pe randuri
        for (int i = 0; i < n; i++) {
            String rowString = "";
            for (int j = 0; j < n; j++) {
                rowString += matrice[i][j] + " ";
            }
            System.out.println("Rand " + (i+1) + ": " + rowString);
        }

// concatenare pe coloane
        for (int j = 0; j < n; j++) {
            String columnString = "";
            for (int i = 0; i < n; i++) {
                columnString += matrice[i][j] + " ";
            }
            System.out.println("Coloana " + (j+1) + ": " + columnString);
        }

////////////EX4///////////////

        int x = 50000; // specify the size of the Latin Square
        int[][] matrix = new int[x][x]; // create an n x n matrix

        long startTime = System.nanoTime(); // start the timer

        // initialize the matrix with values 1 to n
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (j + i) % x + 1;
            }
        }

        long endTime = System.nanoTime(); // stop the timer
        long durationInNanos = endTime - startTime;
        long durationInMillis = durationInNanos / 1000000;

        System.out.println("Timp pentru creat " + x + ": " + durationInNanos + " nanosecunde (" + durationInMillis + " millisecunde)");

//////////EX5//////////////
//javac then java Main whatever arg you want
    }
}