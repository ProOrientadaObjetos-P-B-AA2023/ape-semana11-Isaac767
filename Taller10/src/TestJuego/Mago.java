package TestJuego;


    public class Mago extends Personaje {
    private int fuerza;
    private int agilidad;
    private int magia;
    private int precision;
    private int defensa;
    private int defensaMagica;
    private int velocidad;

    public Mago(int fuerza, int agilidad, int magia, int precision, int defensa, int defensaMagica, int velocidad, String nombre, int nivel, int puntosVida, int experiencia) {
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
        int danio = magia * nivel;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " lanza un hechizo a " + objetivo.nombre + " causando " + danio + " puntos de daño.");
    }

    public void defender() {
        System.out.println(nombre + " invoca un escudo mágico para protegerse.");
    }

    private void asignarPuntosAtributos() {
        // Asigna los puntos de atributos del mago
        fuerza = nivel / 10;
        agilidad = nivel / 10;
        magia = nivel / 10;
        precision = nivel / 10;
        defensa = nivel / 10;
        defensaMagica = nivel / 10;
        velocidad = nivel / 10;
    }

    // Habilidades por rango de niveles

    // Nivel 1 a 5
    public void bolaDeFuego(Personaje objetivo) {
        int danio = 40;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " lanza una bola de fuego a " + objetivo.nombre + " causando " + danio + " puntos de daño.");
    }

    // Nivel 5 a 10
    public void impactrueno(Personaje objetivo) {
        int danio = 80;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " invoca un rayo que golpea a " + objetivo.nombre + " causando " + danio + " puntos de daño.");
        if (Math.random() < 0.2) {
            // Probabilidad del 20% de paralizar al enemigo
            System.out.println(objetivo.nombre + " ha sido paralizado.");
        }
    }

    // Nivel 10 a 20
    public void tormentaDeNieve() {
        System.out.println(nombre + " conjura una tormenta de nieve que reduce la precisión y velocidad de los enemigos en un 20% durante 2 turnos.");
    }

    // Nivel 20 a 30
    public void invocacionDeCriatura() {
        System.out.println(nombre + " invoca una criatura mágica que inflige 60 de daño y asiste al mago en combate durante 3 turnos.");
    }

    // Nivel 30 a 40
    public void luzDivina(Personaje objetivo) {
        int danio = 120;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " concentra una luz divina y la lanza como un rayo a " + objetivo.nombre + " causando " + danio + " puntos de daño crítico.");
    }

    // Nivel 40 a 50
    public void proteccion() {
        System.out.println(nombre + " crea una barrera mágica que reduce el daño recibido en un 30% durante 2 turnos.");
    }

    // Nivel 50 a 60
    public void luzLunar() {
        System.out.println(nombre + " invoca la luz de la luna, que inflige 80 de daño y aumenta la estadística de magia del mago en un 20% durante 3 turnos.");
    }

    // Nivel 60 a 70
    public void poderDelSol(Personaje objetivo) {
        int danio = 150;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " concentra la energía del sol en una poderosa bola de fuego que quema a " + objetivo.nombre + " infligiendo " + danio + " puntos de daño.");
    }

    // Nivel 70 a 80
    public void meteorito(Personaje objetivo) {
        int danio = 100;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " invoca tres meteoritos que caen del cielo e infligen " + danio + " puntos de daño a " + objetivo.nombre + ".");
    }

    // Nivel 80 a 90
    public void destruccionTotal() {
        System.out.println(nombre + " canaliza todos los poderes elementales para lanzar una explosión que inflige 300 de daño masivo a los enemigos.");
        System.out.println("El mago no puede hacer ningún ataque el siguiente turno.");
    }

    // Nivel 90 a 100
    public void supremaciaArcana(Personaje objetivo) {
        int danio = 400;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " alcanza su máximo poder arcano y lanza un rayo que inflige " + danio + " puntos de daño a " + objetivo.nombre + ".");
        System.out.println("Todas las estadísticas del mago aumentan en un 30% durante 2 turnos.");
    }
}
