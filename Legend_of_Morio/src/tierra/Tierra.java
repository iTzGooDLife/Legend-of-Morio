package tierra;
import interfaz.*;
import jugador.*;
import npc.*;

//Metodo abstracto Tierra
public abstract class Tierra {
    
    //Atributos pedidos en la tarea, que corresponden a la probabilidad que aparezcan enemigos (establecida por el DM)
    //Al monstruo, Jefe Final y NPC definidos por el DM.
    private float probabilidad_enemigo;
    private Monstruo monstruo;
    private Jefe_Final jefe_final;
    private NPC npc;

    //Constructor de la clase Tierra
    public Tierra(float probabilidad_enemigo, Monstruo monstruo, Jefe_Final jefe_final, NPC npc){
        this.npc = npc;
        this.probabilidad_enemigo = probabilidad_enemigo;
        this.monstruo = monstruo;
        this.jefe_final = jefe_final;
    }
    
    //Metodo abstracto acción que se heredará a Montana, Bosque y Planicie.
    public abstract boolean accion(Jugador player);
    
    //Getters
    public NPC getNpc() {
        return npc;
    }public Jefe_Final getJefe_final() {
        return jefe_final;
    }public Monstruo getMonstruo() {
        return monstruo;
    }public float getProbabilidad_enemigo() {
        return probabilidad_enemigo;
    }
    //Setters
    public void setJefe_final(Jefe_Final jefe_final) {
        this.jefe_final = jefe_final;
    }public void setMonstruo(Monstruo monstruo) {
        this.monstruo = monstruo;
    }public void setNpc(NPC npc) {
        this.npc = npc;
    }public void setProbabilidad_enemigo(float probabilidad_enemigo) {
        this.probabilidad_enemigo = probabilidad_enemigo;
    }
}
