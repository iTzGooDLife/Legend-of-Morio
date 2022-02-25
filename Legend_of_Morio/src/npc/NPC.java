package npc;
import jugador.Jugador;

//Clase Padre de Bueno, Malo y Neutro.
public abstract class NPC {
    //Atributo establecido
    private String nombre;

    //Constructor de la clase, se encarga de settear el nombre del npc.
    public NPC(String nombre){
        this.setNombre(nombre);
    }

    //Metodo que se heredará a las clases previamente mencionadas.
    public abstract void interaccion(Jugador user);
    
    //Getter
    public String getNombre() {
        return nombre;
    }
    //Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
