
package TestJuego;
class Guerrero extends Personaje {
    private int fuerza;
    private int defensa;
    private int defensaMagica;
    private int velocidad;

    public Guerrero(int fuerza, int agilidad, int defensa, int defensaMagica, int velocidad, int magia, int precision, String nombre, int nivel, int puntosVida, int experiencia) {
    super(nombre, nivel, puntosVida, experiencia);
    this.fuerza = fuerza;
    this.agilidad = agilidad;
    this.defensa = defensa;
    this.defensaMagica = defensaMagica;
    this.velocidad = velocidad;
    this.magia = magia;
    this.precision = precision;
}

    public void setDefensaMagica(int defensaMagica) {
        this.defensaMagica = defensaMagica;
    }

    @Override
    public int getFuerza() {
        return fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getDefensaMagica() {
        return defensaMagica;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public int getExperiencia() {
        return experiencia;
    }

   

    public int getAgilidad() {
        return agilidad;
    }

    public int getMagia() {
        return magia;
    }


    

   
    public void atacar(Personaje objetivo) {
        int danio = fuerza * nivel;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " ataca a " + objetivo.nombre + " causando " + danio + " puntos de daño.");
    }

    public void tajoFuria(Personaje objetivo) {
        int danio = 100;
        if (Math.random() < 0.1) {
            danio *= 2; // Daño crítico
            System.out.println("¡Golpe crítico!");
        }
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " utiliza Tajo Furia contra " + objetivo.nombre + " causando " + danio + " puntos de daño.");
    }

    public void dobleTajo(Personaje objetivo) {
        int danio = 120;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " realiza un Doble Tajo contra " + objetivo.nombre + " causando " + danio + " puntos de daño.");
    }

    public void corteVeloz(Personaje objetivo) {
        int danio = 80;
        int armaduraPerdida = defensa / 2;
        velocidad += armaduraPerdida;
        defensa -= armaduraPerdida;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " se deshace de su armadura, perdiendo " + armaduraPerdida + " de defensa, para realizar un Corte Veloz contra " + objetivo.nombre + " causando " + danio + " puntos de daño.");
    }

    public void golpeDemoniaco(Personaje objetivo) {
        int danio = 60;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " realiza un Golpe Demoníaco contra " + objetivo.nombre + " causando " + danio + " puntos de daño.");
    }

    public void todosContraMiSolo() {
        int aumentoVida = (int) (puntosVida * 0.5);
        int aumentoFuerza = (int) (fuerza * 0.5);
        int aumentoDefensas = (int) (defensa * 0.5);
        int aumentoDefensaMagica = (int) (defensaMagica * 0.5);
        int disminucionStats = (int) (nivel * 0.25);
        puntosVida += aumentoVida;
        fuerza += aumentoFuerza;
        defensa += aumentoDefensas;
        defensaMagica += aumentoDefensaMagica;
        fuerza -= disminucionStats;
        defensa -= disminucionStats;
        defensaMagica -= disminucionStats;
        velocidad -= disminucionStats;
        System.out.println(nombre + " activa Todos Ustedes Contra Mí Solo, aumentando su vida, fuerza y defensas, pero disminuyendo sus otras estadísticas.");
    }

    public void acabemosConEsto() {
        int aumentoFuerza = fuerza;
        int aumentoVelocidad = (int) (velocidad * 0.5);
        int disminucionStats = (int) (nivel * 0.25);
        fuerza += aumentoFuerza;
        velocidad += aumentoVelocidad;
        fuerza -= disminucionStats;
        defensa -= disminucionStats;
        defensaMagica -= disminucionStats;
        puntosVida -= disminucionStats;
        System.out.println(nombre + " activa Acabemos con Esto, aumentando su fuerza y velocidad, pero disminuyendo sus otras estadísticas.");
    }

    public void miArmaSeInterponeEnTuCamino() {
        System.out.println(nombre + " activa Mi Arma se Interpone en tu Camino, aumentando el daño de sus ataques básicos y la probabilidad de golpe crítico.");
    }

    public void justicia(Personaje objetivo) {
        int danio = 400;
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " invoca Justicia, causando " + danio + " puntos de daño a " + objetivo.nombre + ".");
    }

    public void ascensionDivina() {
        System.out.println(nombre + " asciende a los cielos, obteniendo poder divino.");
    }
}