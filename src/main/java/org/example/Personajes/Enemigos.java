package org.example.Personajes;

public enum Enemigos {
    ANACONDA("Eunectes", 100, 20, 5),
    BESTIA("Bestia de tres cabezas", 200, 30, 20),
    DRAGON("Dragon Oscuro", 250, 30, 15),
    DRUIDA("Druida", 75, 20, 17),
    ESPECTRO("Espectro", 100, 25, 0),
    GOBLIN("Goblin", 75, 20, 8),
    GOLEM("Golem", 150, 20, 10),
    MAGOOSCURO("Mago Oscuro", 80, 25, 5);

    private String nombre;
    private int saludMax;
    private int fuerza;
    private int defensa;
    private int saludActual;

    Enemigos(String nombre, int saludMax, int fuerza, int defensa) {
        this.nombre = nombre;
        this.saludMax = saludMax;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.saludActual = saludMax;  // Iniciar con salud máxima
    }

    public void recibirDanio(int danio) {
        int danioReducido = Math.max(danio - defensa, 0);  // Reducir daño con base en defensa
        saludActual -= danioReducido;
        System.out.println(nombre + " recibe " + danioReducido + " puntos de daño. Salud restante: " + saludActual);
        if (saludActual <= 0) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    public void atacar(Personajes objetivo) {
        System.out.println(nombre + " ataca a " + objetivo.getNombre());
        int danio = fuerza;
        objetivo.recibirDanio(danio);
        System.out.println(objetivo.getNombre() + " recibe " + danio + " puntos de daño.");
    }
    public String getNombre() {
        return nombre;
    }

    public int getSaludMax() {
        return saludMax;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getSaludActual() {
        return saludActual;
    }

    public void setSaludActual(int saludActual) {
        this.saludActual = saludActual;
    }
}
