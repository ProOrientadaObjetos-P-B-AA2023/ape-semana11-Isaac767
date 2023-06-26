package TestJuego;

public class Arquero extends Personaje {
    private int fuerza;
    private int agilidad;
    private int magia;
    private int precision;
    private int defensa;
    private int defensaMagica;
    private int velocidad;

    public Arquero(int fuerza, int agilidad, int magia, int precision, int defensa, int defensaMagica, int velocidad, String nombre, int nivel, int puntosVida, int experiencia) {
        super(nombre, nivel, puntosVida, experiencia);
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.magia = magia;
        this.precision = precision;
        this.defensa = defensa;
        this.defensaMagica = defensaMagica;
        this.velocidad = velocidad;
      
    }
   

    public void atacar(Personaje objetivo) {
        int danio = precision * nivel;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " dispara una flecha a " + objetivo.nombre + " causando " + danio + " puntos de daño.");
    }

    public void defender() {
        System.out.println(nombre + " se prepara para defenderse.");
    }

    // Habilidades por rango de niveles

    // Nivel 1 a 5
    public void flechaPrecisa(Personaje objetivo) {
        int danio = 40;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " dispara una flecha precisa a " + objetivo.nombre + " causando " + danio + " puntos de daño.");
    }

    // Nivel 5 a 10
    public void flechaBomba(Personaje objetivo) {
        int danioInicial = 60;
        int danioExplosion = 80;
        objetivo.puntosVida -= danioInicial;
        System.out.println(nombre + " lanza una flecha bomba a " + objetivo.nombre + " causando " + danioInicial + " puntos de daño inicial.");
        System.out.println("La flecha explota, infligiendo un daño adicional de " + danioExplosion + " puntos.");
    }

    // Nivel 10 a 20
    public void flechaDeHielo(Personaje objetivo) {
        int danio = 60;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " dispara una flecha de hielo a " + objetivo.nombre + " causando " + danio + " puntos de daño.");
        System.out.println("Los enemigos quedan ralentizados en un 50% durante 3 turnos.");
    }

    // Nivel 20 a 30
    public void flechaIgnea(Personaje objetivo) {
        int danio = 80;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " lanza una flecha ígnea a " + objetivo.nombre + " infligiendo " + danio + " puntos de daño.");
        System.out.println("Los enemigos quedan quemados durante 2 turnos.");
    }

    // Nivel 30 a 40
    public void lluviaDeFlechas(Personaje objetivo) {
        int danio = 60;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " apunta hacia el cielo y lanza un millar de flechas que caen sobre " + objetivo.nombre + " infligiendo " + danio + " puntos de daño.");
    }

    // Nivel 40 a 50
    public void flechaDivina(Personaje objetivo) {
        int danio = 100;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " dispara una flecha cargada con energía divina a " + objetivo.nombre + " infligiendo " + danio + " puntos de daño.");
        System.out.println("A los no muertos les inflige daño masivo y los destruye instantáneamente.");
    }

    // Nivel 50 a 60
    public void lluviaDeMuerte(Personaje objetivo) {
        int danioRafaga = 30;
        int numRafagas = 3;
        int danioTotal = danioRafaga * numRafagas;
        objetivo.puntosVida -= danioTotal;
        System.out.println(nombre + " dispara una ráfaga de flechas muy veloces e imposibles de esquivar a " + objetivo.nombre + ".");
        System.out.println("Cada ráfaga inflige " + danioRafaga + " puntos de daño.");
    }

    // Nivel 60 a 70
    public void unArcoYUnaFlechaEsTodoLoQueTengo(Personaje objetivo) {
        int danio = 120;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " utiliza su última flecha y la potencia al máximo, infligiendo " + danio + " puntos de daño.");
        System.out.println("Ignora todo tipo de protección y defensas.");
        System.out.println("El arquero no podrá luchar por un turno después de este ataque.");
    }

    // Nivel 70 a 80
    public void ojosEnElCielo() {
        System.out.println(nombre + " usa a su mejor amigo, el halcón, para detectar todos los puntos débiles del enemigo.");
        System.out.println("Todos los ataques y habilidades infligen un 150% más de daño.");
    }

    // Nivel 80 a 90
    public void nadieEscapaDeMisFlechas(Personaje objetivo) {
        int danioFlechas = 200;
        int danioExplosion = 40;
        objetivo.puntosVida -= danioFlechas;
        System.out.println(nombre + " usa todas las flechas de su carcaj infligiendo " + danioFlechas + " puntos de daño.");
        System.out.println("Deja el campo lleno de flechas bombas que explotarán durante 3 turnos, infligiendo " + danioExplosion + " puntos de daño.");
    }

    // Nivel 90 a 100
    public void subestimameBajoTuPropioRiesgo(Personaje objetivo) {
        int danio = 300;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " libera su forma demoníaca y dispara una flecha que inflige " + danio + " puntos de daño.");
        System.out.println("Mientras está en esta forma, todas sus estadísticas se incrementan en un 50%.");
        System.out.println("Esta forma dura 2 turnos.");
    }
}
