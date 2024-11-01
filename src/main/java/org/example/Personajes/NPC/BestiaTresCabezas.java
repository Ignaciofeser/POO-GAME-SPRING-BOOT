package org.example.Personajes.NPC;
import org.example.ConsoleColors;
import org.example.Personajes.MainCharacter;
import org.example.Personajes.Npc;

public class BestiaTresCabezas extends Npc {
    public BestiaTresCabezas() {
        super("Bestia de tres cabezas", 200, 30, 20);
    }

    /*@Override
    public void habilidadEspecialNpc(MainCharacter jugador) {
        int danio = getFuerza() * 3;
        System.out.println(getNombre() + " usa Aliento Devastador, causando " + ConsoleColors.RED_BRIGHT + danio + ConsoleColors.RESET + " de daño a " + jugador.getNombre());
        jugador.recibirDanio(danio);
    }*/
}
