package tierra;
import java.util.Random;
import interfaz.*;
import jugador.Jugador;
import npc.NPC;

//Clase hija de Tierra

public class Planicie extends Tierra{

    //Constructor de la clase Bosque
    public Planicie(float probabilidad_enemigo, Monstruo monstruo, Jefe_Final jefe_final, NPC npc) {
        super(probabilidad_enemigo, monstruo, jefe_final, npc);
    }

    //Crea un numero aleatorio.
    Random r2 = new Random();

    /*
    Metodo accion heredado de Tierra
    Metodo de tipo boolean.
    Este metodo al comienzo establece un flotante aleatorio.
    Este tipo de tierran no necesita ningún tipo de requisito para poder cruzarla, por lo que no devuelve ni quita stats.
    Primero se ve la interacción con el npc de la casilla (en caso de haber) y posteriormente el metodo combate con el Enemigo 
    que haya en esa casilla.
    En caso de que muera en algun punto el jugador, el metodo retornará false, en caso contrario retornará true.
    */
    @Override
    public boolean accion(Jugador player) {
        float probabilidad_enemigo1 = 0 + r2.nextFloat() * (1 - 0);
//
        System.out.println("El siguiente destino es una planicie.");
        if(this.getNpc()!=null){
            this.getNpc().interaccion(player);
        }
        if(player.getVida()>0){//Quitar
            if(probabilidad_enemigo1<this.getProbabilidad_enemigo()){//Aparece enemigo
                if(this.getJefe_final()!=null){
                    this.getJefe_final().combate(player);
                }
                else if(this.getMonstruo()!=null){
                    this.getMonstruo().combate(player);
                }
                if(player.getVida()<=0){
                    return false;
                }
            }
        }
        else{
            //state=0;
            return false;
        }
        return true;
    }
    //Getter numero aleatorio
    public Random getR2() {
        return r2;
    }
    //Setter numero aleatorio
    public void setR2(Random r2) {
        this.r2 = r2;
    }
}
