import java.util.*;
public class Main {
    public static void main(String[] args) {
        String [] palabras = {"Lenguaje" , "Zona", "Panda" , "Orden" , "Verano" , "Apostador" , "Cordero" , "Pez" , "Completo" , "Hora" , "Actor" , "Contar"};
        Random rand = new Random();
        String palabraAdivinar = palabras[rand.nextInt(palabras.length)].toUpperCase();

    }
}