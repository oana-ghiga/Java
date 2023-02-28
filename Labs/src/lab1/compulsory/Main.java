package lab1.compulsory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World"); //1
        System.out.println("salut");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}; //2

        int n = (int) (Math.random() * 1_000_000); //3

        int x = n * 3;//4a
        x += Integer.parseInt("10101", 2);//4b
        x += Integer.parseInt("+FF", 16); //4c
        x *=6; //4d
        System.out.println(x);
        int suma = 0;
        while (x >0 || suma>9) {
            if (x == 0) {
                x = suma;
                suma = 0;
            }
            suma += x % 10;
            x /= 10;
        }
        int rezultat = suma;//5


        System.out.println("Willy-nilly, this semester I will learn " + languages[rezultat]); //6
        System.out.println(rezultat);
    }
}