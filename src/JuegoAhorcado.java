import java.util.Scanner;

public class JuegoAhorcado {
    private Palabra palabra;
    private Muneco muneco;
    private char[] letrasUsadas;
    private int letrasContadas;
    private Scanner entrada;
    private int vidas;

    public JuegoAhorcado() {
        palabra = new Palabra();
        muneco = new Muneco();
        letrasUsadas = new char[30];
        letrasContadas = 0;
        entrada = new Scanner(System.in);
        vidas = 6;
    }

    public void iniciarElJuego() {
        System.out.println("\n=== AHORCADO ===");
        System.out.println("LA PALABRA SECRETA TIENE " + palabra.mostrarLongitudPalabraSecreta() + " LETRAS");
        System.out.println("EMPIEZAS CON 6 VIDAS");
        System.out.println("BUENA SUERTE!");

        while (!muneco.munecoEstaCompleto() && !palabra.laPalabraEstaCompleta()) {
            System.out.println("\nPALABRA: " + String.valueOf(palabra.getProgreso()));
            System.out.print("LETRAS USADAS: ");
            mostrarLetrasUsadas();
            muneco.mostrarMuneco();

            System.out.print("INGRESE UNA LETRA: ");
            String input = entrada.nextLine().toUpperCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.err.println("ENTRADA INVALIDA. INGRESE UNA LETRA");
                System.out.println();
                continue;
            }

            char letra = input.charAt(0);

            if (letraYaUsada(letra)) {
                System.out.println("YA USASTE ESTA LETRA. INTENTA DE NUEVO");
                continue;
            }

            letrasUsadas[letrasContadas] = letra;
            letrasContadas++;

            if (!palabra.validarLetra(letra)) {
                System.out.println("LETRA INCORRECTA");
                muneco.agregarPartesAlMuneco();
                vidas--;
                System.out.println("Vidas = " + vidas);
                System.out.println("----------------------------");
            } else {
                System.out.println("¡BIEN! LETRA CORRRECTA");
                System.out.println("Vidas = " + vidas);
                System.out.println("----------------------------");
            }
        }

        if (palabra.laPalabraEstaCompleta()) {
            System.out.println("\n¡FELICIDADES! ADIVINASTE LA PALABRA. ERA: " + palabra.getPalabraSecreta());
        } else {
            System.out.println();
            muneco.mostrarMuneco();
            System.out.println("\n¡PERDISTE! LA PALABRA ERA: " + palabra.getPalabraSecreta());
        }

        entrada.close();
    }

    private boolean letraYaUsada(char letra) {
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