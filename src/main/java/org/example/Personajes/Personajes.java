package org.example.Personajes;

import org.example.ConsoleColors;

public enum Personajes {
    GUERRERO("Guerrero", 160, 30, "Golpe Devastador", 18, 25, 50, 25, 1),
    MAGO("Mago", 110, 20, "Bola de Fuego", 5, 100, 200, 50, 1),
    PALADIN("Paladín", 130, 25, "Bendición", 15, 60, 80, 20, 1);

    private String nombre;
    private int saludMax;
    private int fuerza;
    private String habilidadEspecial;
    private int defensa;
    private int mana;
    private int manaMax;
    private int manaHabilidad;
    private double multiplicadorHabilidadEspecial;

    Personajes(String nombre, int saludMax, int fuerza, String habilidadEspecial, int defensa, int mana, int manaMax, int manaHabilidad, double multiplicadorHabilidadEspecial) {
        this.nombre = nombre;
        this.saludMax = saludMax;
        this.fuerza = fuerza;
        this.habilidadEspecial = habilidadEspecial;
        this.defensa = defensa;
        this.mana = mana;
        this.manaMax = manaMax;
        this.manaHabilidad = manaHabilidad;
        this.multiplicadorHabilidadEspecial = multiplicadorHabilidadEspecial;
    }

    // Función para usar habilidad especial
    public void usarHabilidadEspecial(Npc objetivo) {
        if (getMana() >= getManaHabilidad()) {
            switch (habilidadEspecial) {
                case "Golpe Devastador":
                    int danioGolpe = (int) (getFuerza() * 2 * getMultiplicadorHabilidadEspecial());
                    System.out.println(ConsoleColors.GREEN_BOLD + getNombre() + ConsoleColors.RESET + " usa Golpe Devastador, causando " + ConsoleColors.GREEN_BOLD_BRIGHT + danioGolpe + ConsoleColors.RESET + " de daño a " + objetivo.getNombre());
                    objetivo.recibirDanio(danioGolpe);
                    break;

                case "Bola de Fuego":
                    int danioFuego = getFuerza() * 3;  // La bola de fuego hace 3 veces la fuerza en daño
                    System.out.println(ConsoleColors.GREEN_BOLD + getNombre() + ConsoleColors.RESET + " lanza una bola de fuego!");
                    objetivo.recibirDanio(danioFuego);
                    System.out.println(objetivo.getNombre() + " recibe " + ConsoleColors.GREEN_BOLD_BRIGHT + danioFuego + ConsoleColors.RESET + " puntos de daño.");
                    break;

                case "Bendición":
                    int saludRestaurada = (int) (getSaludMax() * 0.3 * getMultiplicadorHabilidadEspecial());
                    System.out.println(ConsoleColors.GREEN_BOLD + getNombre() + ConsoleColors.RESET + " invoca una bendición y se cura " + ConsoleColors.GREEN_BOLD_BRIGHT + saludRestaurada + ConsoleColors.RESET + " puntos de salud.");
                    // Aumentar la salud sin exceder el máximo
                    setSaludMax(Math.min(getSaludMax() + saludRestaurada, getSaludMax()));
                    break;

                default:
                    System.out.println("Habilidad no reconocida.");
            }
            // Reducir mana tras usar la habilidad
            setMana(getMana() - getManaHabilidad());
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "No hay suficiente mana para usar " + habilidadEspecial + ConsoleColors.RESET);
        }
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSaludMax() {
        return saludMax;
    }

    public void setSaludMax(int saludMax) {
        this.saludMax = saludMax;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public String getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public void setHabilidadEspecial(String habilidadEspecial) {
        this.habilidadEspecial = habilidadEspecial;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getManaMax() {
        return manaMax;
    }

    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
    }

    public int getManaHabilidad() {
        return manaHabilidad;
    }

    public void setManaHabilidad(int manaHabilidad) {
        this.manaHabilidad = manaHabilidad;
    }

    public double getMultiplicadorHabilidadEspecial() {
        return multiplicadorHabilidadEspecial;
    }

    public void setMultiplicadorHabilidadEspecial(double multiplicadorHabilidadEspecial) {
        this.multiplicadorHabilidadEspecial = multiplicadorHabilidadEspecial;
    }
}
