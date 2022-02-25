package tierra;
import java.util.Random;
import interfaz.Jefe_Final;
import interfaz.Monstruo;
import jugador.Jugador;
import npc.NPC;

//Clase hija de Tierra
public class Montana extends Tierra{

    //Constructor de la clase Montana
    public Montana(float probabilidad_enemigo, Monstruo monstruo, Jefe_Final jefe_final, NPC npc) {
        super(probabilidad_enemigo, monstruo, jefe_final, npc);//wtf
    }

    //Crea un numero aleatorio.
    Random r2 = new Random();

    /*
    Metodo accion heredado de Tierra
    Metodo de tipo boolean.
    Este metodo al comienzo establece un flotante aleatorio.
    Luego verifica si el jugador tiene la energia suficiente para poder llegar a la montaña, lo que se divide en 3 casos.
    Si la energía es 0, entonces no puede llegar y se devuelve.
    Si la energia es mayor que 0 y menor que 3, entonces llega pero se le resta de su vida lo que falta.
    Si la energia es mayor o igual a 3 se le resta a su energía lo correspondiente.
    Luego de verificar que sigue vivo el jugador se ejecuta la interacción con el npc de la casilla (en caso de haber) y posteriormente 
    el metodo combate el Enemigo que haya en esa casilla.
    En caso de no poder llegar a la casilla o de que muera en algun punto el jugador, retornará false, en caso contrario
    retornará true.
    */
    @Override
    public boolean accion(Jugador player) {
        float probabilidad_enemigo1 = 0 + r2.nextFloat() * (1 - 0);
        System.out.println("El siguiente destino es una montaña. Costo de energía: 3");
        if(player.getEnergia()==0){
            System.out.println("No tienes suficiente energía para llegar a la montaña, te devolverás a la casilla anterior.");
            return false;
        }
        else{
            if(player.getEnergia()>0&&player.getEnergia()<3){
                player.setEnergia(player.getEnergia()-3);
                player.setVida(player.getVida()+player.getEnergia());
                player.setEnergia(0);
                System.out.println("No tienes suficiente energía para llegar ileso a la montaña, se te descontará de tu vida la energía faltante.");
                if(player.getVida()<=0){
                    //state=0;//falso/muerto
                    if(player.getVida()<0){
                        player.setVida(0);
                    }
                    System.out.println("Vida actual: "+player.getVida()+". Tu vida no fue suficiente para soportar el viaje, has perdido!:(");
                    return false;
                }
            }
            else{
                player.setEnergia(player.getEnergia()-3);
                System.out.println("Llegaste ileso a la montaña, energía actual: "+ player.getEnergia());
            }
            if(this.getNpc()!=null){
                this.getNpc().interaccion(player);
            }
            if(player.getVida()>0){
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
                player.setState(0);
                return false;
            }
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
