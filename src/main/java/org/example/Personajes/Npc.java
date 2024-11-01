package org.example.Personajes;

import org.example.Personaje;

public abstract class Npc extends Personaje {

    public Npc(String nombre, int salud, int fuerza, int defensa) {
        super(nombre, salud, fuerza, defensa);
    }

    public void habilidadEspecialNpc(MainCharacter jugador) {

    }

    @Override
    public String toString() {
        return String.format("Enemigo: %s\nSalud: %d\nFuerza: %d\nDefensa: %d",
                getNombre(), getSalud(), getFuerza(), getDefensa());
    }

}

