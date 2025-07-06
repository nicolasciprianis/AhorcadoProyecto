import java.util.Scanner;

public class JuegoAhorcado {
    private Palabra palabra;
    private Muneco muneco;
    private char[] letrasUsadas;
    private int letrasContadas;
    private Scanner entrada;

    public JuegoAhorcado() {
        palabra = new Palabra();
        muneco = new Muneco();
        letrasUsadas = new char[30];
        letrasContadas = 0;
        entrada = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("\n=== Ahorcado ===");
        System.out.println("La palabra secreta tiene " + palabra.getLongitud() + " letras.");

        while (!muneco.estaCompleto() && !palabra.estaCompleta()) {
            System.out.println("\n\nPalabra: " + String.valueOf(palabra.getProgreso()));
            System.out.print("Letras usadas: ");
            mostrarLetrasUsadas();
            muneco.mostrar();

            System.out.print("Ingresa una letra: ");
            String input = entrada.nextLine().toUpperCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Entrada inválida. Ingresa una sola letra.");
                continue;
            }

            char letra = input.charAt(0);

            if (yaUsada(letra)) {
                System.out.println("Ya usaste esa letra.");
                continue;
            }

            letrasUsadas[letrasContadas] = letra;
            letrasContadas++;

            if (!palabra.validarLetra(letra)) {
                System.out.println("Letra incorrecta.");
                muneco.agregarParte();
            } else {
                System.out.println("¡Bien! Letra correcta.");
            }
        }

        if (palabra.estaCompleta()) {
            System.out.println("\n¡Felicidades! Adivinaste la palabra: " + palabra.getPalabraSecreta());
        } else {
            System.out.println();
            muneco.mostrar();
            System.out.println("\n¡Perdiste! La palabra era: " + palabra.getPalabraSecreta());
        }

        entrada.close();
    }

    private boolean yaUsada(char letra) {
        for (int i = 0; i < letrasContadas; i++) {
            if (letrasUsadas[i] == letra) {
                return true;
            }
        }
        return false;
    }

    private void mostrarLetrasUsadas() {
        for (int i = 0; i < letrasContadas; i++) {
            System.out.print(letrasUsadas[i] + " ");
        }
        System.out.println();
    }
}