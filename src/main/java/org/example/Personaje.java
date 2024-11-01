package org.example;

public abstract class Personaje {
    private String nombre;
    private int salud;
    private int saludMax;
    private int fuerza;
    public int defensa;

    public Personaje(String nombre, int salud, int fuerza, int defensa) {
        this.nombre = nombre;
        this.salud = salud;
        this.saludMax = salud;
        this.fuerza = fuerza;
        this.defensa = defensa;

    }

    public int getFuerza(){
        return fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getSaludMax() {
        return saludMax;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) { // Método para establecer la salud
        this.salud = salud;
    }

    public void recibirDanio(int danio) {
        this.salud -= danio;
        if (this.salud < 0) this.salud = 0;
    }

    public int atacar(Personaje objetivo) {
        int danio = Math.max(0, this.fuerza - objetivo.defensa);
        objetivo.recibirDanio(danio);
        return danio;
    }


    @Override
    public String toString() {
        return "";
    }


}