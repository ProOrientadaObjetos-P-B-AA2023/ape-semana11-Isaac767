package TestJuego;

public class TestJuego {
    public static void main(String[] args) {
        System.out.println("¡Bienvenido al juego!");

        Personaje personaje = Personaje.seleccionarPersonaje();

        if (personaje != null) {
            System.out.println("¡Has creado a tu personaje!");
            personaje.mostrarInformacion();

            MenuJuego menuJuego = new MenuJuego(personaje);
            menuJuego.mostrarMenu();
        } else {
            System.out.println("No se ha seleccionado ningún personaje. El juego ha terminado.");
        }
    }
}