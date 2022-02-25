package npc;
import main.Main;
import jugador.Jugador;
import misiones.Mision;

//Clase que se hereda de npc que corresponde al Neutro.
public class Neutro extends NPC{

    /*
    Atributos pedidos en la tarea, que corresponden al requisito que tendrá la misión, valor al que debe llegar el jugador,
    recompensa por cumplir la misión, una flag para verificar si ya dió misión y una variable local que corresponderá
    a un input del usuario para ver si acepta la misión
    */
    private char requisito;
    private int valor;
    private int recompensa;
    private int ya_dio_mision;//0 false /1 true
    private int respuesta;

    //Constructor del npc Neutro
    public Neutro(String nombre, char requisito, int valor, int recompensa, int ya_dio_mision){
        super(nombre);
        this.requisito = requisito;
        this.valor = valor;
        this.recompensa = recompensa;
        this.ya_dio_mision = ya_dio_mision;
    }

    /*
    Metodo interaccion heredado de npc.
    Este metodo primero verifica si ya el npc ya le dió su misión al jugador, si ya la dió, da un dialogo y termina su 
    interacción con el jugador, en caso contrario sigue con el metodo.
    Si aún no da su misión se le mostrará en pantalla la misión que debe cumplir, con los requisitos y su recompensa
    por terminarla y pregunta si acepta.}
    En caso de no aceptar, da un dialogo y termina su interacción con el Jugador. En caso contrario añade la misión a
    la lista de misiones del jugador, cambia la flag "ya_dio_mision" a true (1) y termina su interacción.
    Al ser de tipo void no retornará nada.
    */
    @Override
    public void interaccion(Jugador player) {
        if(this.ya_dio_mision==0){
            if(this.requisito=='v'){
                System.out.println(this.getNombre()+": hola, ¿quieres cumplir esta mision? Deberas llegar a "+this.valor+" del mundo y recibiras "+ this.recompensa+" de xp.");
            }
            else if(this.requisito=='m'){
                System.out.println(this.getNombre()+": hola, ¿quieres cumplir esta mision? Deberas matar "+this.valor+" de Monstruos y recibiras "+ this.recompensa+" de xp.");
            }
 
            System.out.println(this.getNombre()+": ¿Te atreves a aceptar?\n\t1. Si\n\t2. No");
            //respuesta = entrada.nextInt();
            this.respuesta = Main.getEntrada().nextInt();
            Main.getEntrada().nextLine();
            if(this.respuesta ==  1){//Respuesta equivocada será tomada como no
                Mision mis;
                if(this.requisito=='m'){
                    mis = new Mision(this.requisito, this.valor, 0, this.recompensa);//Monstruos desde que se empieza la mision
                }
                else{
                    mis = new Mision(this.requisito, this.valor, player.getPosicion(), this.recompensa);
                }
                player.getLista_misiones().add(mis);
                player.setCantidad_misiones(player.getCantidad_misiones()+1);
                this.ya_dio_mision=1;//Verdadero
            }
            else{
                System.out.println(this.getNombre()+": Que triste que seas un cobarde "+player.getNombre()+", hasta la proxima.");//revisar
            }
        }
        else{
            System.out.println(this.getNombre()+": Ya te di mi mision, saludos.");
        }
    }
    //Getters
    public int getRecompensa() {
        return recompensa;
    }public char getRequisito() {
        return requisito;
    }public int getRespuesta() {
        return respuesta;
    }public int getValor() {
        return valor;
    }public int getYa_dio_mision() {
        return ya_dio_mision;
    }
    //Setters
    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }public void setRequisito(char requisito) {
        this.requisito = requisito;
    }public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }public void setValor(int valor) {
        this.valor = valor;
    }public void setYa_dio_mision(int ya_dio_mision) {
        this.ya_dio_mision = ya_dio_mision;
    }
}
