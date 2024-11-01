package org.example.Personajes;
import org.example.ConsoleColors;
import org.example.Personaje;
import org.example.Personajes.PJ.Guerrero;

public abstract class MainCharacter extends Personaje {
    private int mana;
    private int manaMax;
    private int manaHabilidad;
    private double multiplicadorHabilidadEspecial;

    public MainCharacter(String nombre, int salud, int fuerza, int defensa, int mana, int manaMax, int manaHabilidad, int multiplicadorHabilidadEspecial) {
        super(nombre, salud, fuerza, defensa);
        this.mana = mana;
        this.manaMax = manaMax;
        this.manaHabilidad = manaHabilidad;
        this.multiplicadorHabilidadEspecial = 1.0;
    }


    public void mejorarHabilidadEspecial() {
        this.multiplicadorHabilidadEspecial *= 2; // Duplica la eficacia de la habilidad especial
        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + "Habilidad especial mejorada. Nuevo multiplicador: " + this.multiplicadorHabilidadEspecial + ConsoleColors.RESET);
    }

    public double getMultiplicadorHabilidadEspecial() {
        return multiplicadorHabilidadEspecial;
    }


    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = Math.max(0, Math.min(mana, this.manaMax));
    }

    public void restaurarSalud() {
        this.setSalud(this.getSaludMax());
        System.out.println(ConsoleColors.PURPLE_BOLD + "Salud restaurada completamente." + ConsoleColors.RESET);
    }

    public void restaurarMana() {
        this.mana = this.manaMax;
        System.out.println(ConsoleColors.BLUE_BOLD + "Mana restaurado completamente." + ConsoleColors.RESET);
    }

    public void restaurarSaludYMana() {
        this.setSalud(this.getSaludMax());
        this.mana = this.manaMax;
        System.out.println(ConsoleColors.GREEN_BOLD + "Tu salud y mana han sido restauradas completamente" + ConsoleColors.RESET);

    }


    public int getManaHabilidad() {
        return manaHabilidad;
    }


    public boolean usarHabilidadEspecial(Personaje objetivo) {
        if (this.mana >= this.manaHabilidad) {
            habilidadEspecial(objetivo);
            return true;
        } else {
            System.out.println(ConsoleColors.RED_BRIGHT + "No tienes suficiente mana para usar la habilidad especial." + ConsoleColors.RESET);
            return false;
        }
    }

    public abstract void habilidadEspecial(Personaje objetivo);

    public void regenerarMana() {
        this.mana = Math.min(this.mana + 5, this.manaMax); // Regenera 5 mana por turno, máximo hasta manaMax
    }

    @Override
    public String toString() {
        return String.format("Personaje: %s\nSalud: %d\nFuerza: %d\nDefensa: %d\nMana: %d\nManaxHabilidad: %d",
                getNombre(), getSalud(), getFuerza(), getDefensa(), mana, manaHabilidad);
    }
}

