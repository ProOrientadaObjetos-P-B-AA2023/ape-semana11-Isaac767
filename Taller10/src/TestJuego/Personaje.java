
package TestJuego;

import java.util.Random;
import java.util.Scanner;

class Personaje {
    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected int experiencia;
    protected int fuerza;
    protected int agilidad;
    protected int magia;
    protected int precision;
    protected int defensa;
    protected int defensaMagica;
    protected int velocidad;

    public Personaje(String nombre, int nivel, int puntosVida, int experiencia) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.experiencia = experiencia;
        asignarPuntosAtributos();
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

    public int getFuerza() {
        return fuerza;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public int getMagia() {
        return magia;
    }

    public int getPrecision() {
        return precision;
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
     public static Personaje seleccionarPersonaje() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        Personaje personaje = null;

        System.out.println("----- Selección de Personaje -----");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("3. Arquero");
        System.out.print("Seleccione un rol para su personaje: ");
        opcion = scanner.nextInt();
        System.out.println();

        switch (opcion) {
            case 1:
                personaje = new Guerrero(200, 80, 300, 300,80,50,50, "Guerrero", 1, 1500, 0);
                break;
            case 2:
                personaje = new Mago(10, 30, 500, 60, 50, 30, 30, "Mago", 1, 750, 0);
                break;
            case 3:
                personaje = new Arquero(10, 500, 30, 1000, 50, 30, 750, "Arquero", 1, 750, 0);
                break;
            default:
                System.out.println("Opción inválida. Seleccionando rol por defecto: Guerrero");
                personaje = new Guerrero(200, 80, 300, 300,80,50,50, "Guerrero", 1, 1500, 0);
                break;
        }

        System.out.println("¡Ha seleccionado el rol de " + personaje.getNombre() + "!");
        personaje.mostrarInformacion();
        System.out.println();

        // Devuelve el personaje seleccionado
        return personaje;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Nivel: " + this.nivel);
        System.out.println("Puntos de Vida: " + this.puntosVida);
        System.out.println("Experiencia: " + this.experiencia);
        System.out.println("Atributos:");
        System.out.println("Fuerza: " + this.fuerza);
        System.out.println("Agilidad: " + agilidad);
        System.out.println("Magia: " + magia);
        System.out.println("Precisión: " + precision);
        System.out.println("Defensa: " + defensa);
        System.out.println("Defensa Mágica: " + defensaMagica);
        System.out.println("Velocidad: " + velocidad);
    }

    public void subirNivel() {
        nivel++;
        System.out.println(nombre + " ha subido al nivel " + nivel + "!");

        int expRequerida;
        if (nivel >= 1 && nivel <= 10) {
            expRequerida = 250;
        } else if (nivel <= 20) {
            expRequerida = 1250;
        } else if (nivel <= 30) {
            expRequerida = 2000;
        } else if (nivel <= 40) {
            expRequerida = 3000;
        } else if (nivel <= 50) {
            expRequerida = 4000;
        } else if (nivel <= 80) {
            expRequerida = 5000;
        } else {
            expRequerida = 6000;
        }

        experiencia = 0; // Reinicia la experiencia
        asignarPuntosAtributos();
    } 
  
    public void ganarExperiencia(int puntos) {
        puntos = 500;
        experiencia += puntos + 500;
        System.out.println(nombre + " ha ganado " + puntos + " puntos de experiencia.");
    }
public void atacar(Personaje objetivo, int danio) {
    String mensaje = "";

    // Determina el tipo de ataque según el tipo de personaje
    if (this instanceof Mago) {
        danio = ((Mago) this).getMagia() * nivel;
        mensaje = "lanza un hechizo a";
    } else if (this instanceof Guerrero) {
        danio = ((Guerrero) this).getFuerza() * nivel;
        mensaje = "ataca a";
    } else if (this instanceof Arquero) {
        danio = ((Arquero) this).getPrecision() * nivel;
        mensaje = "dispara una flecha a";
    }

    if (objetivo != null) {
        objetivo.puntosVida -= danio;
        System.out.println(nombre + " " + mensaje + " " + objetivo.nombre + " causando " + danio + " puntos de daño.");
    } else {
        System.out.println("El objetivo del ataque es nulo. No se puede realizar el ataque.");
    }
}
    private void asignarPuntosAtributos() {
        // Asigna automáticamente los puntos de experiencia a los valores más altos de cada atributo
        fuerza = nivel / 10;
        agilidad = nivel / 10;
        magia = nivel / 10;
        precision = nivel / 10;
        defensa = nivel / 10;
        defensaMagica = nivel / 10;
        velocidad = nivel / 10;
    }
     
    public void recibirDanio(int danio) {
        puntosVida -= danio;
        if (puntosVida < 0) {
            puntosVida = 0;
        }
        System.out.println(nombre + " recibe " + danio + " puntos de daño. Puntos de vida restantes: " + puntosVida);
    }
    public static class Enemigo extends Personaje {
    private int fuerza;
    private int agilidad;
    private int defensa;
    private int defensaMagica;
    private int velocidad;

        public Enemigo(int fuerza, int agilidad, int defensa, int defensaMagica, int velocidad, String nombre, int nivel, int puntosVida, int experiencia) {
    super(nombre, nivel, puntosVida, experiencia);
    this.fuerza = fuerza;
    this.agilidad = agilidad;
    this.defensa = defensa;
    this.defensaMagica = defensaMagica;
    this.velocidad = velocidad;
    generarEnemigoBasico();
}
    

     
    private void generarEnemigoBasico() {
        // Generar un enemigo básico en función del nivel del jugador
        Random random = new Random();

        // Determinar el tipo de enemigo
        int tipoEnemigo = random.nextInt(3); // 0: Humanos, 1: No muertos, 2: Monstruos

        // Asignar nombre y estadísticas base según el tipo de enemigo
        switch (tipoEnemigo) {
            case 0: // Humanos
                nombre = "Guerrero";
                puntosVida = 100 + nivel * 10;
                fuerza = 10 + nivel;
                agilidad = 10 + nivel;
                defensa = 10 + nivel;
                defensaMagica = 10 + nivel;
                velocidad = 10 + nivel;
                break;
            case 1: // No muertos
                nombre = "Mago";
                puntosVida = 80 + nivel * 8;
                fuerza = 8 + nivel;
                agilidad = 8 + nivel;
                defensa = 8 + nivel;
                defensaMagica = 8 + nivel;
                velocidad = 8 + nivel;
                break;
            case 2: // Monstruos
                nombre = "Arquero";
                puntosVida = 120 + nivel * 12;
                fuerza = 12 + nivel;
                agilidad = 12 + nivel;
                defensa = 12 + nivel;
                defensaMagica = 12 + nivel;
                velocidad = 12 + nivel;
                break;
        }
    }
    
    @Override
    public void mostrarInformacion() {
    System.out.println("Nombre: " + nombre);
    System.out.println("Nivel: " + nivel);
    System.out.println("Puntos de Vida: " + puntosVida);
    System.out.println("Fuerza: " + fuerza);
    System.out.println("Agilidad: " + agilidad);
    System.out.println("Defensa: " + defensa);
    System.out.println("Defensa Mágica: " + defensaMagica);
    System.out.println("Velocidad: " + velocidad);
}
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getPuntosVida() {
        return puntosVida;
    }

    @Override
    public void recibirDanio(int cantidad) {
        puntosVida -= cantidad;
    }

    public boolean estaMuerto() {
        return puntosVida <= 0;
    }

    @Override
    public void atacar(Personaje objetivo,int danio) {
           if (objetivo != null) {
        Random random = new Random();
        int habilidadIndex = random.nextInt(2); // Índice aleatorio para seleccionar habilidad
        
        switch (nombre) {
            case "Guerrero":
                switch (habilidadIndex) {
                    case 0:
                        habilidadGolpeConEspada(objetivo);
                        break;
                    case 1:
                        habilidadDisparoDePistola(objetivo);
                        break;
                }
                break;
            case "Mago":
                switch (habilidadIndex) {
                    case 0:
                        habilidadGolpePodrido(objetivo);
                        break;
                    case 1:
                        habilidadVomitoAcido(objetivo);
                        break;
                    case 2:
                        habilidadLlamaEmbrujada(objetivo);
                        break;
                }
                break;
            case "Arquero":
                switch (habilidadIndex) {
                    case 0:
                        habilidadMordidaFeroz(objetivo);
                        break;
                    case 1:
                        habilidadGarraInfectada(objetivo);
                        break;
                    case 2:
                        habilidadDobleHachazo(objetivo);
                        break;
                }
                break;
        }
           }else{
               System.out.println("NINGUN ENEMIGO ENCONTRADO");
           }
    }
     
    // Habilidades de los Humanos
    private void habilidadGolpeConEspada(Personaje objetivo) {
    int danio = 100;
    System.out.println(getNombre() + " usa Golpe con espada y causa " + danio + " de daño.");
    objetivo.recibirDanio(danio);
}

private void habilidadDisparoDePistola(Personaje objetivo) {
    int danio = 150;
    System.out.println(getNombre() + " usa Disparo de pistola y causa " + danio + " de daño.");
    objetivo.recibirDanio(danio);
}

// Habilidades de los No Muertos
private void habilidadGolpePodrido(Personaje objetivo) {
    int danio = 100;
    System.out.println(getNombre() + " usa Golpe podrido y causa " + danio + " de daño.");
    objetivo.recibirDanio(danio);
}

private void habilidadVomitoAcido(Personaje objetivo) {
    int danio = 80;
    System.out.println(getNombre() + " usa Vómito ácido y causa " + danio + " de daño. " + objetivo.getNombre() + " ha sido quemado.");
    objetivo.recibirDanio(danio);
   
}

private void habilidadLlamaEmbrujada(Personaje objetivo) {
    int danio = 120;
    System.out.println(getNombre() + " usa Llama embrujada y causa " + danio + " de daño.");
    objetivo.recibirDanio(danio);
}

// Habilidades de los Monstruos
private void habilidadMordidaFeroz(Personaje objetivo) {
    int danio = 120;
    System.out.println(getNombre() + " usa Mordida feroz y causa " + danio + " de daño.");
    objetivo.recibirDanio(danio);
}

private void habilidadGarraInfectada(Personaje objetivo) {
    int danio = 80;
    System.out.println(getNombre() + " usa Garra infectada y causa " + danio + " de daño.");
    objetivo.recibirDanio(danio);
}

private void habilidadDobleHachazo(Personaje objetivo) {
    int danio = 200;
    System.out.println(getNombre() + " usa Doble hachazo y causa " + danio + " de daño.");
    objetivo.recibirDanio(danio);
}
public static class JefeUnico extends Enemigo {
    private String nombre;
    private int nivel;
    private int puntosVida;
    private int fuerza;
    private int agilidad;
    private int defensa;
    private int defensaMagica;
    private int velocidad;
    private int experiencia;

   public JefeUnico(int fuerza, int agilidad, int defensa, int defensaMagica, int velocidad, String nombre, int nivel, int puntosVida, int experiencia, String clase) {
        super(fuerza, agilidad, defensa, defensaMagica, velocidad, nombre, nivel, puntosVida, experiencia);
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.defensa = defensa;
        this.defensaMagica = defensaMagica;
        this.velocidad = velocidad;
        this.experiencia = experiencia;
        generarJefeUnico(clase);
    }

          

    

    private void generarJefeUnico(String clase) {
        Random random = new Random();
        switch (clase) {
            case "guerrero":
                nombre = "Radhan";
                puntosVida = 1000 + nivel * 100;
                fuerza = 100 + nivel;
                agilidad = 10 + nivel;
                defensa = 100 + nivel;
                defensaMagica = 10 + nivel;
                velocidad = 10 + nivel;
                break;
            case "mago":
                nombre = "Draugnir, //EL DIOS CAIDO";
                puntosVida = 800 + nivel * 80;
                fuerza = 10 + nivel;
                agilidad = 10 + nivel;
                defensa = 10 + nivel;
                defensaMagica = 100 + nivel;
                velocidad = 10 + nivel;
                break;
            case "arquero":
                nombre = "Legolas";
                puntosVida = 900 + nivel * 90;
                fuerza = 10 + nivel;
                agilidad = 100 + nivel;
                defensa = 10 + nivel;
                defensaMagica = 10 + nivel;
                velocidad = 100 + nivel;
                break;
            
                  case "thor":
                nombre = "Thor";
                // Asignar los valores correspondientes a Thor
                puntosVida = 1200 + nivel * 120;
                fuerza = 150 + nivel;
                agilidad = 80 + nivel;
                defensa = 120 + nivel;
                defensaMagica = 80 + nivel;
                velocidad = 90 + nivel;
                break;
            case "gandalf":
                nombre = "Gandalf";
                // Asignar los valores correspondientes a Gandalf
                puntosVida = 1100 + nivel * 110;
                fuerza = 80 + nivel;
                agilidad = 80 + nivel;
                defensa = 80 + nivel;
                defensaMagica = 150 + nivel;
                velocidad = 100 + nivel;
                break;
            default:
                nombre = "Jefe";
                puntosVida = 1000 + nivel * 100;
                fuerza = 100 + nivel;
                agilidad = 100 + nivel;
                defensa = 100 + nivel;
                defensaMagica = 100 + nivel;
                velocidad = 100 + nivel;
                break;
        }
        
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getPuntosVida() {
        return puntosVida;
    }

    @Override
    public void recibirDanio(int cantidad) {
        puntosVida -= cantidad;
    }

    @Override
    public boolean estaMuerto() {
        return puntosVida <= 0;
    }

    @Override
    public void atacar(Personaje objetivo,int danio) {
        Random random = new Random();
        int habilidadIndex;

        switch (nombre) {
            case "Radhan":
                habilidadIndex = random.nextInt(4); // Índice aleatorio para seleccionar habilidad
                switch (habilidadIndex) {
                    case 0:
                        habilidadMaldicionDelNoMuerto(objetivo);
                        break;
                    case 1:
                        habilidadGolpeFuria(objetivo);
                        break;
                    case 2:
                        habilidadIraDivina(objetivo);
                        break;
                    case 3:
                        habilidadUltimoSuspiro();
                        break;
                    case 4:
                        habilidadElInfiernoEnLaTierra(objetivo);
                        break;
                }
                break;
            case "Draugnir, //EL DIOS CAIDO":
                habilidadIndex = random.nextInt(3);
                switch (habilidadIndex) {
                    case 0:
                        habilidadRayoDivino(objetivo);
                        break;
                    case 1:
                        habilidadFuegoInfernal();
                        break;
                    case 2:
                        habilidadMiMagiaMiPoder(objetivo);
                        break;
                }
                break;
            case "Thor":
                habilidadIndex = random.nextInt(5);
                switch (habilidadIndex) {
                    case 0:
                        habilidadGolpeDelDiosThor(objetivo);
                        break;
                    case 1:
                        habilidadVeZMiMartilloCometelo(objetivo);
                        break;
                    case 2:
                        habilidadSienteElPoderDeThor(objetivo);
                        break;
                    case 3:
                        habilidadSienteElTrueno(objetivo);
                        break;
                    case 4:
                        habilidadElTruenoTeDestruye(objetivo);
                        break;
                }
                break;
            case "Gandalf":
                habilidadIndex = random.nextInt(2);
                switch (habilidadIndex) {
                    case 0:
                        habilidadMiMagiaEsSuperior(objetivo);
                        break;
                    case 1:
                        habilidadYoSoyElVerdaderoMagoAqui(objetivo);
                        break;
                }
                break;
            case "Legolas":
                habilidadIndex = random.nextInt(3);
                switch (habilidadIndex) {
                    case 0:
                        habilidadFlechaPrecisa(objetivo);
                        break;
                    case 1:
                        habilidadDisparoMultiple(objetivo);
                        break;
                    case 2:
                        habilidadOjoDeHalcon(objetivo);
                        break;
                }
                break;
        }
    }
    public int calcularDanio(Personaje jugador, Personaje enemigo) {
    int diferenciaNivel = jugador.getNivel() - enemigo.getNivel();
    double multiplicadorNivel = obtenerMultiplicadorNivel(diferenciaNivel);
    int danioFinal;

    if (jugador instanceof Guerrero) {
        Guerrero guerrero = (Guerrero) jugador;
        int danioBase = guerrero.getFuerza() - enemigo.getDefensa();
        danioFinal = (int) (danioBase * multiplicadorNivel);
    } else if (jugador instanceof Mago) {
        Mago mago = (Mago) jugador;
        int danioBase = mago.getMagia() - enemigo.getDefensaMagica();
        danioFinal = (int) (danioBase * multiplicadorNivel);
    } else if (jugador instanceof Arquero) {
        Arquero arquero = (Arquero) jugador;
        int danioBase = arquero.getVelocidad() + arquero.getAgilidad() + arquero.getPrecision();
        danioFinal = (int) (danioBase * multiplicadorNivel);
    } else {
        danioFinal = 0; // Clase no reconocida, daño igual a cero
    }

    return danioFinal;
} 
    private double obtenerMultiplicadorNivel(int diferenciaNivel) {
    double multiplicador;

    if (diferenciaNivel >= 5) {
        multiplicador = 1.5; // Multiplicador de daño aumentado en un 50%
    } else if (diferenciaNivel >= 3) {
        multiplicador = 1.2; // Multiplicador de daño aumentado en un 20%
    } else if (diferenciaNivel >= -2) {
        multiplicador = 1.0; // Sin multiplicador de daño
    } else if (diferenciaNivel >= -4) {
        multiplicador = 0.8; // Multiplicador de daño reducido en un 20%
    } else {
        multiplicador = 0.5; // Multiplicador de daño reducido en un 50%
    }

    return Math.round(multiplicador * 100.0) / 100.0; // Redondear a dos decimales
}
    // Habilidades del jefe único Radhan
    private void habilidadMaldicionDelNoMuerto(Personaje objetivo) {
        int danio = 300;
        System.out.println(nombre + " usa Maldición del no muerto y causa " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }

    private void habilidadGolpeFuria(Personaje objetivo) {
        int danioBase = 50;
        double multiplicador = 1.2;
        int danio = (int) (danioBase * multiplicador);
        System.out.println(nombre + " usa Golpe furia y causa " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }

    private void habilidadIraDivina(Personaje objetivo) {
        int danioBase = 100;
        double multiplicadorCritico = 0.25;
        int danio = danioBase + (int) (danioBase * multiplicadorCritico);
        System.out.println(nombre + " usa Ira divina y causa " + danio + " de daño crítico.");
        objetivo.recibirDanio(danio);
    }

    private void habilidadUltimoSuspiro() {
        double porcentajeDisminucion = 0.1;
        fuerza -= (int) (fuerza * porcentajeDisminucion);
        agilidad -= (int) (agilidad * porcentajeDisminucion);
        defensa -= (int) (defensa * porcentajeDisminucion);
        defensaMagica -= (int) (defensaMagica * porcentajeDisminucion);
        velocidad -= (int) (velocidad * porcentajeDisminucion);
        puntosVida -= (int) (puntosVida * porcentajeDisminucion);
        System.out.println(nombre + " activa Último suspiro. Sus atributos se debilitan.");
    }

    private void habilidadElInfiernoEnLaTierra(Personaje objetivo) {
        int danio = 720;
        System.out.println(nombre + " usa El infierno en la tierra y causa " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }

    // Habilidades del jefe único Draugnir
    private void habilidadRayoDivino(Personaje objetivo) {
        int danio = 300;
        System.out.println(nombre + " usa Rayo divino y causa " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }

    private void habilidadFuegoInfernal() {
        int danio = 320;
        System.out.println(nombre + " usa Fuego infernal y causa " + danio + " de daño a todos los enemigos.");
    }

    private void habilidadMiMagiaMiPoder(Personaje objetivo) {
        int danio = 450;
        System.out.println(nombre + " usa Mi magia, mi poder y causa " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }

    // Habilidades del jefe único Thor
    private void habilidadGolpeDelDiosThor(Personaje objetivo) {
        int danio = 500;
        System.out.println(nombre + " usa Golpe del dios Thor y causa " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }

    private void habilidadVeZMiMartilloCometelo(Personaje objetivo) {
        int danio = 350;
        System.out.println(nombre + " usa ¿Vez mi martillo? ¡Cómetelo! y causa " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }

    private void habilidadSienteElPoderDeThor(Personaje objetivo) {
        int danio = 550;
        System.out.println(nombre + " usa Siente el poder de Thor y causa " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }

    private void habilidadSienteElTrueno(Personaje objetivo) {
        int danio = 300;
        System.out.println(nombre + " usa Siente el trueno y causa " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }

    private void habilidadElTruenoTeDestruye(Personaje objetivo) {
        int danio = 550;
        System.out.println(nombre + " usa El trueno te destruye y causa " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }

    // Habilidades del jefe único Gandalf
    private void habilidadMiMagiaEsSuperior(Personaje objetivo) {
    int danio = 300;
    System.out.println(nombre + " usa Mi magia es superior y causa " + danio + " de daño.");
    objetivo.recibirDanio(danio);
}



    private void habilidadYoSoyElVerdaderoMagoAqui(Personaje objetivo) {
        int danio = 400;
        System.out.println(nombre + " usa Yo soy el verdadero mago aquí y causa " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }

    // Habilidades del jefe único Legolas
    private void habilidadFlechaPrecisa(Personaje objetivo) {
        int danio = 300;
        System.out.println(nombre + " usa Flecha precisa y causa " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }

    private void habilidadDisparoMultiple(Personaje objetivo) {
        int danio = 250;
        System.out.println(nombre + " usa Disparo múltiple y causa " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }

    private void habilidadOjoDeHalcon(Personaje objetivo) {
        int danio = 400;
        System.out.println(nombre + " usa Ojo de halcón y causa " + danio + " de daño.");
        objetivo.recibirDanio(danio);
    }
        }
    }

}


