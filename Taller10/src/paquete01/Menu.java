package paquete01;

import java.util.ArrayList;

public abstract class Menu {
    private String nombrePlato;
    private double valorInicial;
    private double valorMenu;

    public Menu(String nombrePlato, double valorInicial) {
        this.nombrePlato = nombrePlato;
        this.valorInicial = valorInicial;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public double getValorMenu() {
        return valorMenu;
    }

    public void setValorMenu(double valorMenu) {
        this.valorMenu = valorMenu;
    }

    public abstract void establecerValorMenu();

    public String getInformacion() {
        String informacion = "";
        informacion += "\tPlato: " + nombrePlato + "\n";
        informacion += "\tValor Inicial: " + valorInicial + "\n";
        informacion += "\tValor del Menú: " + valorMenu + "\n";
        return informacion;
    }
}
    class MenuCarta extends Menu {
    private double valorGuarnicion;
    private double valorBebida;
    private double porcentajeAdicional;

    public MenuCarta(String nombrePlato, double valorInicial, double valorGuarnicion,
                     double valorBebida, double porcentajeAdicional) {
        super(nombrePlato, valorInicial);
        this.valorGuarnicion = valorGuarnicion;
        this.valorBebida = valorBebida;
        this.porcentajeAdicional = porcentajeAdicional;
    }

    public double getValorGuarnicion() {
        return valorGuarnicion;
    }

    public double getValorBebida() {
        return valorBebida;
    }

    public double getPorcentajeAdicional() {
        return porcentajeAdicional;
    }

    @Override
    public void establecerValorMenu() {
        double valorMenu = getValorInicial() + valorGuarnicion + valorBebida;
        valorMenu += (valorMenu * porcentajeAdicional) / 100;
        setValorMenu(valorMenu);
    }

    @Override
    public String getInformacion() {
        String informacion = "Menu a la Carta:\n";
        informacion += super.getInformacion();
        informacion += "Valor guarnición: " + valorGuarnicion + "\n";
        informacion += "Valor bebida: " + valorBebida + "\n";
        informacion += "Porcentaje adicional: " + porcentajeAdicional + "%\n";
        return informacion;
    }
}

    class MenuNinos extends Menu {
    private double valorHelado;
    private double valorPastel;

    public MenuNinos(String nombrePlato, double valorInicial, double valorHelado, double valorPastel) {
        super(nombrePlato, valorInicial);
        this.valorHelado = valorHelado;
        this.valorPastel = valorPastel;
    }

    public double getValorHelado() {
        return valorHelado;
    }

    public double getValorPastel() {
        return valorPastel;
    }

    @Override
    public void establecerValorMenu() {
        double valorMenu = getValorInicial() + valorHelado + valorPastel;
        setValorMenu(valorMenu);
    }

    @Override
    public String getInformacion() {
        String informacion = "Menu del Niño:\n";
        informacion += super.getInformacion();
        informacion += "Valor helado: " + valorHelado + "\n";
        informacion += "Valor pastel: " + valorPastel + "\n";
        return informacion;
    }
}

    class MenuEconomico extends Menu {
    private double porcentajeDescuento;

    public MenuEconomico(String nombrePlato, double valorInicial, double porcentajeDescuento) {
        super(nombrePlato, valorInicial);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    @Override
    public void establecerValorMenu() {
        double valorMenu = getValorInicial() - (getValorInicial() * porcentajeDescuento) / 100;
        setValorMenu(valorMenu);
    }

    @Override
    public String getInformacion() {
        String informacion = "Menu Económico:\n";
        informacion += super.getInformacion();
        informacion += "Porcentaje descuento: " + porcentajeDescuento + "%\n";
        return informacion;
    }
  }
    class MenuDia extends Menu {
    private double valorBebida;
    private double valorPostre;

    public MenuDia(String nombrePlato, double valorInicial, double valorBebida, double valorPostre) {
        super(nombrePlato, valorInicial);
        this.valorBebida = valorBebida;
        this.valorPostre = valorPostre;
    }

    public double getValorBebida() {
        return valorBebida;
    }

    public double getValorPostre() {
        return valorPostre;
    }

    @Override
    public void establecerValorMenu() {
        double valorMenu = getValorInicial() + valorBebida + valorPostre;
        setValorMenu(valorMenu);
    }

    @Override
    public String getInformacion() {
        return "Menu del Día:\n" +
                "Plato: " + getNombrePlato() + "\n" +
                "Valor Inicial: " + getValorInicial() + "\n" +
                "Valor bebida: " + valorBebida + "\n" +
                "Valor postre: " + valorPostre + "\n" +
                "Valor del Menú: " + getValorMenu() + "\n";
    }
}

    class Cuenta {
    private String nombreCliente;
    private ArrayList<Menu> listaMenus;
    private double iva;
    private double subtotal;
    private double valorCancelar;

    public Cuenta(String nombreCliente, ArrayList<Menu> listaMenus, double iva) {
        this.nombreCliente = nombreCliente;
        this.listaMenus = listaMenus;
        this.iva = iva;
    }

    public void establecerSubtotal() {
        subtotal = 0;
        for (Menu menu : listaMenus) {
            subtotal += menu.getValorMenu();
        }
    }

    public void establecerValorCancelar() {
        valorCancelar = subtotal + (subtotal * iva) / 100;
    }

    @Override
    public String toString() {
        String informacion = "Factura\n";
        informacion += "Cliente: " + nombreCliente + "\n";
        for (Menu menu : listaMenus) {
            informacion += menu.getInformacion() + "\n";
        }
        informacion += "Subtotal: " + subtotal + "\n";
        informacion += "IVA: " + iva + "%\n";
        informacion += "Total a pagar: " + valorCancelar + "\n";
        return informacion;
    }
}  

