package paquete01;
import java.util.ArrayList;

public class Ejecutor02 {

    public static void main(String[] args) {

        String[][] datos001 = {{"Niños 01", "2.00", "1", "1.5"},
                {"Niños 02", "3.00", "1", "1.5"},
                {"Niños 03", "2.00", "2", "0.5"},
        };

        String[][] datos002 = {{"Econo 001", "4", "25"},
                {"Econo 002", "4", "15"},
                {"Econo 003", "4", "35"}
        };

        String[][] datos003 = {{"Dia 001", "5", "1", "1"},
                {"Dia 002", "6", "2", "2"},
                {"Dia 003", "5.5", "3", "1"},
        };

        String[][] datos004 = {{"Carta 001", "6", "1.5", "2", "10"},
                {"Carta 002", "7", "1.7", "2.1", "5"},
                {"Carta 003", "8", "1.9", "2.2", "5"},
                {"Carta 004", "9", "2.5", "2.9", "5"},
        };

        // Lista de Menus
        ArrayList<Menu> lista = new ArrayList<>();

        /* Agregar un proceso para generar objetos de tipo Menu Carta, Día,
        Económico y Niño*. Cada arreglo datos, se corresponde a un tipo de Menú.
        Iterar y crear los objetos según corresponda. Cada objeto generado,
        agregar al ArrayList lista*/
        // Inicio de solución
        for (String[] datos : datos001) {
            String nombrePlato = datos[0];
            double valorInicial = Double.parseDouble(datos[1]);
            double valorHelado = Double.parseDouble(datos[2]);
            double valorPastel = Double.parseDouble(datos[3]);

            MenuNinos menuNinos = new MenuNinos(nombrePlato, valorInicial, valorHelado, valorPastel);
            menuNinos.establecerValorMenu();
            lista.add(menuNinos);
        }

        for (String[] datos : datos002) {
            String nombrePlato = datos[0];
            double valorInicial = Double.parseDouble(datos[1]);
            double porcentajeDescuento = Double.parseDouble(datos[2]);

            MenuEconomico menuEconomico = new MenuEconomico(nombrePlato, valorInicial, porcentajeDescuento);
            menuEconomico.establecerValorMenu();
            lista.add(menuEconomico);
        }

        for (String[] datos : datos003) {
            String nombrePlato = datos[0];
            double valorInicial = Double.parseDouble(datos[1]);
            double valorBebida = Double.parseDouble(datos[2]);
            double valorPostre = Double.parseDouble(datos[3]);

            MenuDia menuDia = new MenuDia(nombrePlato, valorInicial, valorBebida, valorPostre);
            menuDia.establecerValorMenu();
            lista.add(menuDia);
        }

        for (String[] datos : datos004) {
            String nombrePlato = datos[0];
            double valorInicial = Double.parseDouble(datos[1]);
            double valorGuarnicion = Double.parseDouble(datos[2]);
            double valorBebida = Double.parseDouble(datos[3]);
            double porcentajeAdicional = Double.parseDouble(datos[4]);

            MenuCarta menuCarta = new MenuCarta(nombrePlato, valorInicial, valorGuarnicion, valorBebida, porcentajeAdicional);
            menuCarta.establecerValorMenu();
            lista.add(menuCarta);
        }
        // Fin de solución

        for (Menu menu : lista) {
            menu.establecerValorMenu();
        }

        // Un objeto de tipo Cuenta
        Cuenta miCuenta = new Cuenta("Luis Andrade", lista, 10);
        miCuenta.establecerSubtotal();
        miCuenta.establecerValorCancelar();
        System.out.printf("%s\n", miCuenta);
    }
}
