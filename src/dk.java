import java.util.*;

public class dk {
    public static void main(String[] args) {
        String[] palabras = {"Lenguaje", "Zona", "Panda", "Orden", "Verano", "Apostador", "Cordero", "Pez", "Completo", "Hora", "Actor", "Contar"};
        Random rand = new Random();
        String palabraAdivinar = palabras[rand.nextInt(palabras.length)].toUpperCase();

        System.out.println("La palabra a adivinar tiene " + palabraAdivinar.length() + " letras.");

        Scanner entrada = new Scanner(System.in);
        Muneco muneco = new Muneco ();

        char[] progreso = new char[palabraAdivinar.length()];
        Arrays.fill(progreso, '_');

        String letrasUsadas = "";

        while (!muneco.estaCompleto() && new String(progreso).contains("_")) {
            System.out.println("\nPalabra: " + String.valueOf(progreso));
            System.out.println("Letras usadas: " + letrasUsadas);
            muneco.mostrar();

            System.out.print("Ingresa una letra: ");
            String input = entrada.nextLine().toUpperCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Ingresa solo una letra válida.");
                continue;
            }

            char letra = input.charAt(0);

            if (letrasUsadas.indexOf(letra) != -1) {
                System.out.println("Ya usaste esa letra.");
                continue;
            }

            letrasUsadas += letra;

            boolean acierto = false;
            for (int i = 0; i < palabraAdivinar.length(); i++) {
                if (palabraAdivinar.charAt(i) == letra) {
                    progreso[i] = letra;
                    acierto = true;
                }
            }

            if (!acierto) {
                System.out.println("Letra incorrecta.");
                muneco.agregarParte();
            } else {
                System.out.println("¡Bien! Letra correcta.");
            }
        }

        if (new String(progreso).equals(palabraAdivinar)) {
            System.out.println("\n¡Felicidades! Adivinaste la palabra: " + palabraAdivinar);
        } else {
            muneco.mostrar();
            System.out.println("\n¡Perdiste! La palabra era: " + palabraAdivinar);
        }

        entrada.close();
    }
}
