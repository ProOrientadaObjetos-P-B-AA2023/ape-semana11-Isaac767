package paquete01;
public class Ejecutor01 {
    public static void main(String[] args) {
        MenuDia menuDia = new MenuDia("Niños 01", 2.00, 1.00, 1.50);
        MenuCarta menuCarta = new MenuCarta("Carta 001", 6.0, 1.5, 2.0, 10.0);
        MenuEconomico menuEconomico = new MenuEconomico("Econo 001", 4.0, 25.0);
        MenuNinos menuNinos = new MenuNinos("Niños 02", 3.0, 1.0, 1.5);
        
        System.out.println(menuDia.getInformacion());
        System.out.println(menuCarta.getInformacion());
        System.out.println(menuEconomico.getInformacion());
        System.out.println(menuNinos.getInformacion());
    }
}