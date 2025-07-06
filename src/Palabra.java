import java.util.Random;

public class Palabra {
    private String palabraSecreta;
    private char[] progreso;

    public Palabra() {
        String[] palabras = {"Lenguaje", "Zona", "Panda", "Orden", "Verano", "Apostador", "Cordero", "Pez", "Completo", "Hora", "Actor", "Contar"};
        Random rand = new Random();
        palabraSecreta = palabras[rand.nextInt(palabras.length)].toUpperCase();
        progreso = new char[palabraSecreta.length()];
        for (int i = 0; i < progreso.length; i++) {
            progreso[i] = '_';
        }
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    public char[] getProgreso() {
        return progreso;
    }

    public boolean validarLetra(char letra) {
        boolean acierto = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                progreso[i] = letra;
                acierto = true;
            }
        }
        return acierto;
    }

    public boolean estaCompleta() {
        return new String(progreso).equals(palabraSecreta);
    }

    public int getLongitud() {
        return palabraSecreta.length();
    }
}
