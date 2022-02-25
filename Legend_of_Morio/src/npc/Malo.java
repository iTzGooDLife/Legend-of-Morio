package npc;
import java.util.Random;
import jugador.Jugador;

//Clase que se hereda de npc que corresponde al Bueno.
public class Malo extends NPC{
    
    //Atributos pedidos en la tarea, que corresponden a la cantidad en que se disminuirá la energía y maná.
    private int cantidad_energia;
    private int cantidad_mana;


    //Constructor del npc Bueno
    public Malo(String nombre,int cantidad_energia, int cantidad_mana){
        super(nombre);
        this.cantidad_energia = cantidad_energia;
        this.cantidad_mana = cantidad_mana;
    }
    Random r2 = new Random();

    /*
    Metodo interaccion heredado de npc.
    Este metodo al comienzo establece 2 numeros enteros aleatorios, entre el 1 y 10.
    Uno corresponderá a la energía y el otro al maná, en caso de que alguno de los dos sea menor o igual a 6
    entonces se disminuirá el atributo correspondiente en la cantidad establecida por el DM.
    Si ninguno cumple dicha condición, entonces no disminuirá ningún atributo.
    En caso de que al disminuir alguno de los atributos se llegase a 0, se establecerá en el minimo (0).
    Al ser de tipo void no retornará nada.
    */
    @Override
    public void interaccion(Jugador player) {
        int aleatorio1 = (int)(Math.random()*(10-1+1)+1); //Número aleatorio que corresponde a la energia
        int aleatorio2 = (int)(Math.random()*(10-1+1)+1); //Número aleatorio que corresponde al maná
        if(aleatorio1<=6 && aleatorio2<=6){
            System.out.println(this.getNombre()+": SOY MALO TE VOY A DISMINUIR TU ENERGIA Y MANÁ EN "+ this.cantidad_energia+ " Y "+this.cantidad_mana);
        }
        else if(aleatorio1<=6 && aleatorio2>6){
            System.out.println(this.getNombre()+": SOY MALO TE VOY A DISMINUIR TU ENERGIA EN "+ this.cantidad_energia);
        }
        else if(aleatorio1>6 && aleatorio2<=6){
            System.out.println(this.getNombre()+": SOY MALO TE VOY A DISMINUIR TU MANÁ EN "+ this.cantidad_mana);
        }
        else{
            System.out.println(this.getNombre()+": SOY MALO, ¡PERO SOLO POR ESTA VEZ NO TE DISMINUIRE NADA!");
        }
        if(aleatorio1<=6){
            if((player.getEnergia()-this.cantidad_energia)<0){
                player.setEnergia(0);
            }
            else{
                player.setEnergia(player.getEnergia()-this.cantidad_energia);
            }
        }
        if(aleatorio2<=6){
            if((player.getMana()-this.cantidad_mana)<0){
                player.setMana(0);
            }
            else{
                player.setMana(player.getMana()-this.cantidad_mana);
            }
        }
    }
    //Getters
    public int getCantidad_energia() {
        return cantidad_energia;
    }public int getCantidad_mana() {
        return cantidad_mana;
    }
    //Setters
    public void setCantidad_energia(int cantidad_energia) {
        this.cantidad_energia = cantidad_energia;
    }public void setCantidad_mana(int cantidad_mana) {
        this.cantidad_mana = cantidad_mana;
    }
}
