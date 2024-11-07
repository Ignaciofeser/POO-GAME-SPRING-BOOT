package org.example;

import org.example.Personajes.Personajes;
import org.example.Personajes.Enemigos;


import java.util.Scanner;

import static org.example.Combate.combate;
import static org.example.Personajes.Personajes.*;


public class Game {
    private Scanner scanner;
    private GameState estado;
    private int monedas;

    public Game() {
        scanner = new Scanner(System.in);
        estado = new GameState();
        monedas = 0;
    }

    public void iniciarJuego() {
        System.out.println("Bienvenido a las tierras olvidadas, un mundo sumido en caos y oscuridad...");
        System.out.println("Hace siglos, los reinos florecían bajo la luz de un gran imperio, pero la traición de un ser mistico cambió todo.");
        System.out.println("El cielo se oscureció y las criaturas malignas comenzaron a emerger de las profundidades.");
        System.out.println("Solo los más valientes, o los más desesperados, se atreven a empuñar las armas para restaurar la paz.");
        System.out.println();
        System.out.println("Te encuentras al borde de una gran aventura. Tu destino aún no está escrito...");
        System.out.println("Antes de que tu viaje comience, debes elegir tu clase:");

        System.out.println("------------");
        System.out.println(ConsoleColors.YELLOW_UNDERLINED + "Elige:" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "1. Guerrero:" + ConsoleColors.RESET);
        System.out.println("Habilidad especial: Golpe Devastador");
        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "2. Mago" + ConsoleColors.RESET);
        System.out.println("Habilidad especial: Bola de Fuego");
        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "3. Paladín" + ConsoleColors.RESET);
        System.out.println("Habilidad especial: Bendición (Curación)");
        int claseElegida = scanner.nextInt();

        Personajes jugador = switch (claseElegida) {
            case 1 -> Personajes.GUERRERO;
            case 2 -> Personajes.MAGO;
            case 3 -> Personajes.PALADIN;
            default -> Personajes.GUERRERO;
        };

        estado.agregarPersonaje(jugador);
        estado.mostrarEstado();


        System.out.println(ConsoleColors.YELLOW_UNDERLINED + "Elige un camino:" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "1. Bosque Sombrío" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "2. Templo en Ruinas" + ConsoleColors.RESET);

        int caminoElegido = scanner.nextInt();

        switch (caminoElegido) {
            case 1 -> manejarCaminoBosque();
            case 2 -> manejarCaminoRuinas();
            default -> System.out.println(ConsoleColors.RED_BRIGHT + "Elección no válida." + ConsoleColors.RESET);
        }

        scanner.close();
    }

    private void manejarCaminoBosque() {
        System.out.println("Empiezas a caminar por el bosque y de repente te topas con un Goblin!");
        System.out.println("Goblin: Alto ahí humano, no pasarás por aqui. Hace mas de 100 años que cuido este bosque.");
        System.out.println("Goblin: Y ninguno ha podido pasar sobre mi cadaver.");
        System.out.println("Tú: No me asustas rata verde.");
        Personajes jugador = estado.getPersonajeActual();
        Enemigos goblin =  Enemigos.GOBLIN;
        estado.agregarNpc(goblin);
        combate(estado, goblin);

        if (jugador.getSaludActual() > 0) {
            estado.ganarMonedas();
            System.out.println("Una vez derrotado, notas algo brillante en su bolsillo");
            System.out.println("¡Una manzana encantada! Esta restaura toda tu vida y mana.");

            jugador.getSaludMax();

            System.out.println(ConsoleColors.YELLOW_UNDERLINED + "Ahora sí, tienes que decidir por donde seguir tu camino\n" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "1. Profundidaes del bosque" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT +"2. Laberinto" + ConsoleColors.RESET);
            int segundoCamino = scanner.nextInt();
            if (segundoCamino == 1) manejarCaminoProfundidadesDelBosque();
            else manejarCaminoLaberinto();
        } else {
            estado.setGameOver(true);
        }

    }

    private void manejarCaminoRuinas() {

        System.out.println("Decides explorar el Templo en Ruinas y te de repente escuchas un ruido.!");
        System.out.println("Es un GOLÉM.");
        Enemigos golem = Enemigos.GOLEM;
        estado.agregarNpc(golem);
        combate(estado, golem);

        Personajes jugador = estado.getPersonajeActual();
      
        if (jugador.getSaludMax() > 0) {
            estado.ganarMonedas();
            System.out.println("Notas algo brillante luego de que este se desmoronara. Es una especie de anillo.");
            System.out.println("Decides colocartelo y este provoca que se te restaure toda la vida y el mana.");

            jugador.getSaludMax();

           System.out.println(ConsoleColors.YELLOW_UNDERLINED + "Ahora sí, tienes que decidir por donde seguir tu camino\n" + ConsoleColors.RESET);
           System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "1. Portal tenebroso" + ConsoleColors.RESET);
           System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "2. Profundidades de la Cueva" + ConsoleColors.RESET);
            int segundoCamino = scanner.nextInt();
            if (segundoCamino == 1) manejarCaminoPortal();
            else manejarCaminoProfundidadesDeLaCueva();
        } else {
            estado.setGameOver(true);
        }

    }

    private void manejarCaminoProfundidadesDelBosque() {

        System.out.println("Te adentras en las profundidades del bosque y luego de caminar un rato... .");
        System.out.println("Encuentras una cabaña un tanto sospechosa. Decides entrar.");
        System.out.println("Al abrir la puerta un Hechicero te sorprende.");
        System.out.println("Mago oscuro: Hacia tiempo que no veia a alguien por aqui. Pero genial, me hacian falta ingredientes para mis pociones.");
        System.out.println("Tú: ¡No conseguiras nada de mí!");
        Enemigos magoOscuro = Enemigos.MAGO_OSCURO;
        estado.agregarNpc(magoOscuro);
        combate(estado, magoOscuro);

        Personajes jugador = estado.getPersonajeActual();
        if (jugador.getSaludMax() > 0) {
            estado.ganarMonedas();
            System.out.println("Lo has derrotado, pero ¡oh! parece que previo a eso te lanza una poción.");
            System.out.println(" (Splash), ¡APARECES EN OTRO LUGAR!");
            estado.visitarTienda();
            manejarCaminoDragon();
        } else {
            estado.setGameOver(true);
        }

    }

    private void manejarCaminoLaberinto() {
        System.out.println("A lo lejos notas la entrada de un laberinto de arboles y plantas. Decides entrar a investigar.");
        System.out.println("Adentrandote en él notas como los arbustos comienzan a encerrarte y llevarte a una dirección.");
        System.out.println("Al llegar al final, te encuentras con un señor de raro aspecto.");
        System.out.println("Druida: ¿Quien eres tú?¿Qué haces aquí?");
        System.out.println("Tú: E, estoy busc..");
        System.out.println("Druida: No me interesa, seras fertilizante para mis preciadas plantas.");
        System.out.println("Tú: No lo conseguirás muy fácil. ¡A pelear!");
        Enemigos druida = Enemigos.DRUIDA;
        estado.agregarNpc(druida);
        combate(estado, druida);
        Personajes jugador = estado.getPersonajeActual();
        if (jugador.getSaludMax() > 0) {
            estado.ganarMonedas();
            System.out.println("Las plantas y árboles comienzan a desvanecerse y decides alejarte de ahi.");
            System.out.println("Te alejas tanto que te encuentras una casa rodante. Decides entrar.");
            estado.visitarTienda();
            manejarCaminoBestia();
        } else {
        estado.setGameOver(true);
    }
    }

    private void manejarCaminoPortal() {
        System.out.println("Encuentras una especie de habitacion secreta, en donde una luz resplandeciente no te dejaba ver.");
        System.out.println("Al entrar notas que al final hay un portal. ¿Quien sabe donde podria llevarte?");
        System.out.println("Debido a que eres una persona muy valiente decides ir a usarlo.");
        System.out.println("Pero justo antes de teletransportante (Tsss tsss tsss) es Eunectes (anaconda gigante).");
        System.out.println("Comienzas a correr pero esta es mas rapida que tú. Por lo que no tienes otra que pelear.");
        Enemigos anacondaGigante = Enemigos.ANACONDA;
        estado.agregarNpc(anacondaGigante);
        combate(estado, anacondaGigante);

        Personajes jugador = estado.getPersonajeActual();
        if (jugador.getSaludMax() > 0) {
            estado.ganarMonedas();
        System.out.println("Tú: Nunca habia tenido tanto miedo. Pero bueno no toca de otra que seguir.");
        System.out.println("Decides irte por el portal que habias encontrado.");
        System.out.println("(Se teletransporta)");
        estado.visitarTienda();
        manejarCaminoDragon();
        } else {
            estado.setGameOver(true);

        }
    }


    private void manejarCaminoProfundidadesDeLaCueva() {
        System.out.println("Te adentras en las profundidades de la cueva y comienzas a escuchar un ¡zumbido!");
        System.out.println("Boo, booo. Es un FANTASMA");
        System.out.println("Decides atacarlo, ya que te da genera miedo.");
        Enemigos espectro = Enemigos.ESPECTRO;
        estado.agregarNpc(espectro);
        combate(estado, espectro);

        Personajes jugador = estado.getPersonajeActual();
        if (jugador.getSaludMax() > 0) {
            estado.ganarMonedas();
            System.out.println("Tú: No entiendo como he podido acabar con él. Pero hay que seguir investigando.");
            System.out.println("Decides continuar tu camino y ves un rastro de luz. Al salir de la cueva te encuentras con una casa rodante.");
            System.out.println("Entras a investigar.");
            estado.visitarTienda();
            manejarCaminoBestia();
        } else {
            estado.setGameOver(true);
        }
    }


    private void manejarCaminoBestia() {
        System.out.println("Una vez afura, sigues con tu camino. Y comienzas a seguir un rastro de sangre.");
        System.out.println("Al llegar al final de este. Ves un monstruo alimentandose de un jabalí. Por lo que actuas sigilosamente.");
        System.out.println("Y de repente... (¡CRAC!) pisas una rama. Provocando que esta te descubra.");
        System.out.println("Y al girarse notas que tiene 3 CABEZAS. Es ella, la bestia que comenzó todo. La CULPABLE de todo.");
        System.out.println("Por lo que decides actuar y comenzar la batalla.\n");
        Personajes jugador = estado.getPersonajeActual();

        System.out.println(ConsoleColors.RED_UNDERLINED + "Te enfrentas a la bestia.!" + ConsoleColors.RESET);
        Enemigos bestia = Enemigos.BESTIA;
        estado.agregarNpc(bestia);
        combate(estado, bestia);

        if (jugador.getSaludMax() > 0) {
            System.out.println(ConsoleColors.GREEN_BACKGROUND + "¡Has derrotado a la bestia y restaurado la paz!" + ConsoleColors.RESET );
        } else {
            estado.setGameOver(true);
        }
    }

    private void manejarCaminoDragon() {
        System.out.println("Al salir notas que nada esta igual. El cielo se torna de color negro en un instante.");
        System.out.println("Miras para arriba y ves algo terrible. Es él, el DRAGÓN OSCURO.");
        System.out.println("Según las leyendas una vez acabado todas las criaturas malignas desapareceran.");
        System.out.println("Por lo que decides actuar y lanzarte contra él.\n");
        Personajes jugador = estado.getPersonajeActual();

        Enemigos dragon = Enemigos.DRAGON;
        estado.agregarNpc(dragon);
        combate(estado, dragon);

        if (jugador.getSaludMax() > 0) {
            System.out.println(ConsoleColors.GREEN_BACKGROUND + "¡Has derrotado al Dragón oscuro y restaurado la paz!" + ConsoleColors.RESET);
        } else {
            estado.setGameOver(true);
        }
    }
}
