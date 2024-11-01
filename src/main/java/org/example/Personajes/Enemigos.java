package org.example.Personajes;

import org.example.ConsoleColors;

public enum Enemigos {
    ANACONDA("Anaconda", 100, 20, "Regeneración", 5),
    BESTIA("Bestia de tres cabezas", 200, 30, "Aliento Devastador", 20),
    DRAGON("Dragón Oscuro", 250, 35, "Bola de Fuego", 15),
    DRUIDA("Druida", 75, 15, "Planta Protectora", 10),
    ESPECTRO("Espectro", 100, 25, "Drenaje de Alma", 0),
    GOBLIN("Goblin", 75, 20, "Doble Ataque", 8),
    GOLEM("Golem", 150, 20, "Piel de Piedra", 10),
    MAGO_OSCURO("Mago Oscuro", 80, 25, "Poción Explosiva", 5);

    private String nombre;
    private int saludMax;
    private int saludActual;
    private int fuerza;
    private String habilidadEspecial;
    private int defensa;

    Enemigos(String nombre, int saludMax, int fuerza, String habilidadEspecial, int defensa) {
        this.nombre = nombre;
        this.saludMax = saludMax;
        this.saludActual = saludMax;
        this.fuerza = fuerza;
        this.habilidadEspecial = habilidadEspecial;
        this.defensa = defensa;
    }

    public void usarHabilidadEspecial(Personajes jugador) {
        System.out.println(ConsoleColors.PURPLE_BOLD + getNombre() + ConsoleColors.RESET + " usa " + habilidadEspecial + "!");
        int danio;
        int curacion;
        int saludActual;

        switch (habilidadEspecial) {
            case "Regeneración":
                curacion = (int) (saludMax * 0.25);
                setSaludActual(Math.min(getSaludActual() + curacion, saludMax));
                System.out.println(getNombre() + " usa Regeneración, recuperando un 25% de su salud máxima.");
                break;

            case "Aliento Devastador":
                danio = getFuerza() * 3;
                System.out.println(getNombre() + " usa Aliento Devastador, causando " + ConsoleColors.RED_BRIGHT + danio + ConsoleColors.RESET + " de daño a " + jugador.getNombre());
                jugador.recibirDanio(danio);
                break;

            case "Bola de Fuego":
                danio = getFuerza() * 2;
                System.out.println(getNombre() + " usa Bola de Fuego, causando " + ConsoleColors.RED_BRIGHT + danio + ConsoleColors.RESET + " de daño a " + jugador.getNombre());
                jugador.recibirDanio(danio);
                break;

            case "Planta Protectora":
                curacion = (int) (saludMax * 0.10);
                setSaludActual(Math.min(getSaludActual() + curacion, saludMax));
                System.out.println(getNombre() + " usa Planta Protectora, recuperando un 10% de su salud máxima.");
                break;

            case "Drenaje de Alma":
                danio = 15;
                jugador.recibirDanio(danio);
                saludActual = getSaludActual();
                setSaludActual(Math.min(saludActual + danio, saludMax));
                System.out.println(getNombre() + " usa Drenaje de Alma, absorbiendo " + ConsoleColors.RED_BRIGHT + danio + ConsoleColors.RESET + " de salud del jugador.");
                System.out.println(jugador.getNombre() + " ha perdido " + ConsoleColors.RED_BRIGHT + danio + ConsoleColors.RESET + " puntos de salud.");
                break;

            case "Doble Ataque":
                danio = getFuerza() * 2;
                System.out.println(getNombre() + " usa Doble Ataque, causando " + ConsoleColors.RED_BRIGHT + danio + ConsoleColors.RESET + " de daño a " + jugador.getNombre());
                jugador.recibirDanio(danio);
                break;

            case "Piel de Piedra":
                System.out.println(getNombre() + " usa Piel de Piedra, aumentando su defensa en un 10%.");
                this.defensa += (int) (this.defensa * 0.10);
                break;

            case "Poción Explosiva":
                danio = getFuerza() * 2;
                System.out.println(getNombre() + " te lanza una Poción Explosiva, causando " + ConsoleColors.RED_BRIGHT + danio + ConsoleColors.RESET + " de daño a " + jugador.getNombre());
                jugador.recibirDanio(danio);
                break;

            default:
                System.out.println("Habilidad especial no reconocida.");
                break;
        }
    }

    public void recibirDanio(int danio) {
        int danioReducido = Math.max(danio - defensa, 0);
        saludActual -= danioReducido;
        System.out.println(nombre + " recibe " + danioReducido + " puntos de daño. Salud restante: " + saludActual);

        if (saludActual <= 0) {
            System.out.println(nombre + " ha sido derrotado.");
            saludActual = 0;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getSaludMax() {
        return saludMax;
    }

    public int getSaludActual() {
        return saludActual;
    }

    public void setSaludActual(int saludActual) {
        this.saludActual = saludActual;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
}
