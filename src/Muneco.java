public class Muneco {
    private boolean cabeza;
    private boolean torso;
    private boolean brazoDerecho;
    private boolean brazoIzquierdo;
    private boolean piernaDerecha;
    private boolean piernaIzquierda;

    public Muneco() {
        cabeza = false;
        torso = false;
        brazoDerecho = false;
        brazoIzquierdo = false;
        piernaDerecha = false;
        piernaIzquierda = false;
    }

    public void agregarPartesAlMuneco() {
        if (!cabeza) {
            cabeza = true;
        } else if (!torso) {
            torso = true;
        } else if (!brazoIzquierdo) {
            brazoIzquierdo = true;
        } else if (!brazoDerecho) {
            brazoDerecho = true;
        } else if (!piernaIzquierda) {
            piernaIzquierda = true;
        } else if (!piernaDerecha) {
            piernaDerecha = true;
        }
    }

    public void mostrarMuneco() {
        System.out.println(" -------");
        System.out.print  ("  |   ");
        if (cabeza) System.out.println(" O");
        else System.out.println();

        System.out.print("  |   ");
        if (brazoIzquierdo && brazoDerecho && torso) {
            System.out.println("/|\\");
        } else if (brazoIzquierdo && torso) {
            System.out.println("/|");
        } else if (brazoDerecho && torso) {
            System.out.println("|\\");
        } else if (torso) {
            System.out.println(" |");
        } else {
            System.out.println();
        }

        System.out.print("  |   ");
        if (piernaIzquierda && piernaDerecha) {
            System.out.println("/ \\");
        } else if (piernaIzquierda) {
            System.out.println("/");
        } else if (piernaDerecha) {
            System.out.println(" \\");
        } else {
            System.out.println();
        }

        System.out.println("  |");
    }

    public boolean munecoEstaCompleto() {
        return cabeza && torso && brazoIzquierdo && brazoDerecho && piernaIzquierda && piernaDerecha;
    }
}
