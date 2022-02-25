package npc;
import jugador.Jugador;

//Clase que se hereda de npc que corresponde al Bueno.
public class Bueno extends NPC{
    
    //Atributos pedidos en la tarea, que corresponden al atributo a mejorar y a la cantidad en la que se mejorará
    private String atributo;
    private int cantidad;

    //Constructor del npc Bueno
    public Bueno(String nombre, String atributo, int cantidad){
        super(nombre);
        this.atributo = atributo;
        this.cantidad = cantidad;
    }

    /*
    Metodo interaccion heredado de npc.
    Este metodo se encarga de filtrar cual será el atributo que se mejorará y le sumara la cantidad establecida por el DM al 
    jugador (siempre respetando los maximos en caso de haberlos).
    En caso de superar y/o alcanzar el maximo del atributo, se establecerá la cantidad actual como el maximo.
    Al ser de tipo void no retornará nada.
    */
    @Override
    public void interaccion(Jugador player) {
        if(this.atributo=="Maná"){
            System.out.println("¡Hola! Mi nombre es "+this.getNombre()+" te subiré tu maná en: "+this.getCantidad());
            if((player.getMana()+this.cantidad)<player.getMana_max()){
                player.setMana(player.getMana()+this.cantidad);
                System.out.println("Maná actual: "+player.getMana());
            }
            else{
                player.setMana(player.getMana_max());
                System.out.println("Limite de maná alcanzado.\nManá actual: "+player.getMana());
            }
        }
        else if(this.atributo=="Energía"){
            System.out.println("¡Hola! Mi nombre es "+this.getNombre()+" te subiré tu energía en: "+this.getCantidad());
            if((player.getEnergia()+this.cantidad)<player.getEnergia_max()){
                player.setEnergia(player.getEnergia()+this.cantidad);
                System.out.println("Energía actual: "+player.getEnergia());
            }
            else{
                player.setEnergia(player.getEnergia_max());
                System.out.println("Limite de energía alcanzado.\nEnergía actual: "+player.getEnergia());
            }
        }
        else if(this.atributo=="Vida"){
            System.out.println("¡Hola! Mi nombre es "+this.getNombre()+" te subiré tu vida en: "+this.getCantidad());
            if((player.getVida()+this.cantidad)<player.getVida_max()){
                player.setVida(player.getVida()+this.cantidad);
                System.out.println("Vida actual: "+player.getVida());
            }
            else{
                player.setVida(player.getVida_max());
                System.out.println("Limite de vida alcanzado.\nVida actual: "+player.getVida());
            }
        }
        else if(atributo=="xp"){
            System.out.println("¡Hola! Mi nombre es "+this.getNombre()+" te subiré tu experiencia en: "+this.getCantidad());
            player.subir_experiencia(this.getCantidad());
        }
    }

    //Getters
    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    //Setters
    public String getAtributo() {
        return atributo;
    }public int getCantidad() {
        return cantidad;
    }
}
