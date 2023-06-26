package TestJuego;

import TestJuego.Personaje.Enemigo;
import TestJuego.Personaje.Enemigo.JefeUnico;
import java.util.Random;
import java.util.Scanner;

public class MenuJuego {
    private Personaje personaje;
    private Enemigo enemigo;

    public MenuJuego() {
    }

    public MenuJuego(Personaje personaje){
        this.personaje = personaje;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----- Menú del Juego -----");
            System.out.println("1. Subir de nivel");
            System.out.println("2. Enfrentar a otros personajes");
            System.out.println("3. Explorar mazmorras");
            System.out.println("4. Salir del juego");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    subirNivel();
                    break;
                case 2:
                    crearEnemigoAleatorio();
                    combatirPersonaje();
                    enemigo.mostrarInformacion();
                    break;
                case 3:
                    explorarMazmorras();
                    break;
                case 4:
                    System.out.println("Gracias por jugar. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }

            System.out.println();
        } while (opcion != 4);
    }

    

    private void subirNivel() {
        personaje.subirNivel();
        personaje.mostrarInformacion();
    }


  private void crearEnemigoAleatorio() {
    Random random = new Random();
    int nivelEnemigo = personaje.getNivel() + random.nextInt(5);

    // Determinar el tipo de enemigo aleatoriamente
    int tipoEnemigo = random.nextInt(3);

    // Asignar valores según el tipo de enemigo
    switch (tipoEnemigo) {
        case 0: // Humanos
            enemigo = new Enemigo(10 + nivelEnemigo, 10 + nivelEnemigo, 10 + nivelEnemigo, 10 + nivelEnemigo, 10 + nivelEnemigo, "Guerrero", nivelEnemigo, 100 + nivelEnemigo * 10, 0);
            break;
        case 1: // No muertos
            enemigo = new Enemigo(8 + nivelEnemigo, 8 + nivelEnemigo, 8 + nivelEnemigo, 8 + nivelEnemigo, 8 + nivelEnemigo, "Mago", nivelEnemigo, 80 + nivelEnemigo * 8, 0);
            break;
        case 2: // Monstruos
            enemigo= new Enemigo(12 + nivelEnemigo, 12 + nivelEnemigo, 12 + nivelEnemigo, 12 + nivelEnemigo, 12 + nivelEnemigo, "Arquero", nivelEnemigo, 120 + nivelEnemigo * 12, 0);
            break;
        default:
            // En caso de un tipo de enemigo no válido, generamos un enemigo genérico
            enemigo= new Enemigo(10 + nivelEnemigo, 10 + nivelEnemigo, 10 + nivelEnemigo, 10 + nivelEnemigo, 10 + nivelEnemigo, "Enemigo Genérico", nivelEnemigo, 100 + nivelEnemigo * 10, 0);
            break;
    }

    System.out.println("¡Apareció un enemigo! Nivel: " + nivelEnemigo);
    enemigo.mostrarInformacion();
}

    private void explorarMazmorras() {
        System.out.println("Explorando mazmorras...");

    Random random = new Random();
    int encuentro = random.nextInt(10); // Genera un número aleatorio del 0 al 9

    if (encuentro < 7) {
        crearEnemigoAleatorio();
        combatirPersonaje();
    } else {
        crearJefeUnicoAleatorio();
        combatirConJefeUnico();
    }
}
 private void crearJefeUnicoAleatorio() {
    Random random = new Random();
    int nivelJefe = personaje.getNivel() + random.nextInt(3);
    int tipoJefe = random.nextInt(6);

    switch (tipoJefe) {
        case 0:
            enemigo = new JefeUnico(100 + nivelJefe, 10 + nivelJefe, 10 + nivelJefe, 10 + nivelJefe, 10 + nivelJefe, "Radhan", nivelJefe, 1000 + nivelJefe * 100, 5000, "guerrero");
            break;
        case 1:
            enemigo = new JefeUnico(10 + nivelJefe, 10 + nivelJefe, 10 + nivelJefe, 100 + nivelJefe, 10 + nivelJefe, "Draugnir, //EL DIOS CAIDO", nivelJefe, 800 + nivelJefe * 80, 5000, "mago");
            break;
        case 2:
            enemigo = new JefeUnico(10 + nivelJefe, 100 + nivelJefe, 10 + nivelJefe, 10 + nivelJefe, 100 + nivelJefe, "Legolas", nivelJefe, 900 + nivelJefe * 90, 5000, "arquero");
            break;
        case 3:
            enemigo = new JefeUnico(150 + nivelJefe, 80 + nivelJefe, 120 + nivelJefe, 80 + nivelJefe, 90 + nivelJefe, "Thor", nivelJefe, 1200 + nivelJefe * 120, 5000, "thor");
            break;
        case 4:
            enemigo = new JefeUnico(80 + nivelJefe, 80 + nivelJefe, 80 + nivelJefe, 150 + nivelJefe, 100 + nivelJefe, "Gandalf", nivelJefe, 1100 + nivelJefe * 110, 5000, "gandalf");
            break;
        default:
            enemigo = new JefeUnico(100 + nivelJefe, 100 + nivelJefe, 100 + nivelJefe, 100 + nivelJefe, 100 + nivelJefe, "Jefe", nivelJefe, 1000 + nivelJefe * 100, 5000, "default");
            break;
    }
}

private void combatirConJefeUnico() {
    System.out.println("¡Comienza el combate contra el Jefe Único!");

    Scanner scanner = new Scanner(System.in);
    boolean enCombate = true;

    // Obtener el daño del jugador
    int danioJugador = personaje.getNivel() * 10;
     int danioEnemigo = enemigo.getNivel() * 12;
    while (enCombate) {
        System.out.println("----- Turno del Jugador -----");
        System.out.println("1. Atacar");
        System.out.println("2. Huir");
        System.out.print("Ingrese una opción: ");
        int opcion = scanner.nextInt();
        System.out.println();

        switch (opcion) {
            case 1:
                enemigo.atacar(personaje,danioEnemigo);

                if (personaje.getPuntosVida() <= 0) {
                    System.out.println("¡Has sido derrotado por el Jefe Único!");
                    enCombate = false;
                } else {
                    // Usar el daño del jugador en el ataque
                    personaje.atacar(enemigo, danioJugador);

                    if (enemigo.getPuntosVida() <= 0) {
                        System.out.println("¡Has derrotado al Jefe Único!");
                        enCombate = false;
                    }
                }
                break;
            case 2:
                System.out.println("Has decidido huir del combate. ¡Buena elección!");
                enCombate = false;
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                break;
        }

        System.out.println();
    }
}

   private void combatir() {
    System.out.println("¡Comienza el combate!");

    Scanner scanner = new Scanner(System.in);
    boolean enCombate = true;

    // Obtener el daño del jugador
    int danioJugador = personaje.getNivel() * 10;
    int danioEnemigo = personaje.getNivel() * 8;

    while (enCombate) {
        System.out.println("----- Turno del Jugador -----");
        System.out.println("1. Atacar");
        System.out.println("2. Huir");
        System.out.print("Ingrese una opción: ");
        int opcion = scanner.nextInt();
        System.out.println();

        switch (opcion) {
            case 1:
                personaje.atacar(enemigo, danioJugador);

                if (enemigo.getPuntosVida() <= 0) {
                    System.out.println("¡Has derrotado al enemigo!");
                    enCombate = false;
                } else {
                    enemigo.atacar(personaje, danioEnemigo);

                    if (personaje.getPuntosVida() <= 0) {
                        System.out.println("¡Has sido derrotado!");
                        enCombate = false;
                    }else {
                        int experienciaGanada = enemigo.getExperiencia();
                        personaje.ganarExperiencia(experienciaGanada);
                        System.out.println("¡Has derrotado a " + enemigo.getNombre() + " y ganado " + 500 + " puntos de experiencia!");
    }
                }
                break;
            case 2:
                System.out.println("Has decidido huir del combate. ¡Buena elección!");
                enCombate = false;
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                break;
        }

        System.out.println();
    }
   }
   private void combatirPersonaje() {
    System.out.println("¡Comienza el combate!");

    Scanner scanner = new Scanner(System.in);
    boolean enCombate = true;
    int danioEnemigo = personaje.getNivel() * 10;

    while (enCombate) {
        System.out.println("----- Turno del Jugador -----");
        System.out.println("1. Atacar");
        System.out.println("2. Huir");
        System.out.print("Ingrese una opción: ");
        int opcion = scanner.nextInt();
        System.out.println();

        switch (opcion) {
            case 1:
                if (personaje instanceof Arquero) {
                    Arquero arquero = (Arquero) personaje;
                    System.out.println("Habilidades del Arquero:");
                    System.out.println("1. Flecha Precisa");
                    System.out.println("2. Flecha Bomba");
                    System.out.println("3. Flecha de Hielo");
                    System.out.println("4. Flecha Ígnea");
                    System.out.println("5. Lluvia de Flechas");
                    System.out.println("6. Flecha Divina");
                    System.out.println("7. Lluvia de Muerte");
                    System.out.println("8. Un Arco y Una Flecha es Todo lo que Tengo");
                    System.out.println("9. Ojos en el Cielo");
                    System.out.println("10. Nadie Escapa de Mis Flechas");
                    System.out.println("11. Subestímame Bajo Tu Propio Riesgo");

                    int habilidadIndex = scanner.nextInt();
                    System.out.println();

                    Personaje objetivo = enemigo;

                    switch (habilidadIndex) {
                        case 1:
                            arquero.flechaPrecisa(objetivo);
                            break;
                        case 2:
                            arquero.flechaBomba(objetivo);
                            break;
                        case 3:
                            arquero.flechaDeHielo(objetivo);
                            break;
                        case 4:
                            arquero.flechaIgnea(objetivo);
                            break;
                        case 5:
                            arquero.lluviaDeFlechas(objetivo);
                            break;
                        case 6:
                            arquero.flechaDivina(objetivo);
                            break;
                        case 7:
                            arquero.lluviaDeMuerte(objetivo);
                            break;
                        case 8:
                            arquero.unArcoYUnaFlechaEsTodoLoQueTengo(objetivo);
                            break;
                        case 9:
                            arquero.ojosEnElCielo();
                            break;
                        case 10:
                            arquero.nadieEscapaDeMisFlechas(objetivo);
                            break;
                        case 11:
                            arquero.subestimameBajoTuPropioRiesgo(objetivo);
                            break;
                        default:
                            System.out.println("Habilidad no reconocida.");
                            break;
                    }
                } else if (personaje instanceof Guerrero) {
                    Guerrero guerrero = (Guerrero) personaje;
                    System.out.println("Habilidades del Guerrero:");
                    System.out.println("1. Tajo de Furia");
                    System.out.println("2. Doble Tajo");
                    System.out.println("3. Corte Veloz");
                    System.out.println("4. Golpe Demoníaco");
                    System.out.println("5. Todos Contra Mí Solo");
                    System.out.println("6. Mi Arma se Interpone en tu Camino");
                    System.out.println("7. Ascensión Divina");

                    int habilidadIndex = scanner.nextInt();
                    System.out.println();

                    Personaje objetivo = guerrero;

                    switch (habilidadIndex) {
                        case 1:
                            guerrero.tajoFuria(objetivo);
                            break;
                        case 2:
                            guerrero.dobleTajo(objetivo);
                            break;
                        case 3:
                            guerrero.corteVeloz(objetivo);
                            break;
                        case 4:
                            guerrero.golpeDemoniaco(objetivo);
                            break;
                        case 5:
                            guerrero.todosContraMiSolo();
                            break;
                        case 6:
                            guerrero.miArmaSeInterponeEnTuCamino();
                            break;
                        case 7:
                            guerrero.ascensionDivina();
                            break;
                        default:
                            System.out.println("Habilidad no reconocida.");
                            break;
                    }
                } else if (personaje instanceof Mago) {
                    Mago mago = (Mago) personaje;
                    System.out.println("Habilidades del Mago:");
                    System.out.println("1. Bola de Fuego");
                    System.out.println("2. Impactrueno");
                    System.out.println("3. Tormenta de Nieve");
                    System.out.println("4. Invocación de Criatura");
                    System.out.println("5. Luz Divina");
                    System.out.println("6. Protección");
                    System.out.println("7. Luz Lunar");
                    System.out.println("8. Poder del Sol");
                    System.out.println("9. Meteorito");
                    System.out.println("10. Destrucción Total");
                    System.out.println("11. Supremacía Arcana");

                    int habilidadIndex = scanner.nextInt();
                    System.out.println();

                    Personaje objetivo = enemigo;

                    switch (habilidadIndex) {
                        case 1:
                            mago.bolaDeFuego(objetivo);
                            break;
                        case 2:
                            mago.impactrueno(objetivo);
                            break;
                        case 3:
                            mago.tormentaDeNieve();
                            break;
                        case 4:
                            mago.invocacionDeCriatura();
                            break;
                        case 5:
                            mago.luzDivina(objetivo);
                            break;
                        case 6:
                            mago.proteccion();
                            break;
                        case 7:
                            mago.luzLunar();
                            break;
                        case 8:
                            mago.poderDelSol(objetivo);
                            break;
                        case 9:
                            mago.meteorito(objetivo);
                            break;
                        case 10:
                            mago.destruccionTotal();
                            break;
                        case 11:
                            mago.supremaciaArcana(objetivo);
                            break;
                        default:
                            System.out.println("Habilidad no reconocida.");
                            break;
                    }
                } else {
                    System.out.println("Personaje no reconocido.");
                }

                // Realizar ataques del enemigo y verificar condiciones de fin de combate
                if (enemigo.getPuntosVida() <= 0) {
                    System.out.println("¡Has derrotado al enemigo!");
                    enCombate = false;
                } else {
                    enemigo.atacar(personaje, danioEnemigo);

                    if (personaje.getPuntosVida() <= 0) {
                        System.out.println("¡Has sido derrotado!");
                        enCombate = false;
                    } else {
                        int experienciaGanada = enemigo.getExperiencia();
                        personaje.ganarExperiencia(experienciaGanada);
                        System.out.println("¡Has derrotado a " + enemigo.getNombre() + " y ganado " + 500 + " puntos de experiencia!");
                        enCombate=false;
                    }
                }
                break;
            case 2:
                System.out.println("Has decidido huir del combate. ¡Buena elección!");
                enCombate = false;
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                break;
        }

        System.out.println();
    }
} 
    
}