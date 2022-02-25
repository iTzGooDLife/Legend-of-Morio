package interfaz;
import main.Main; //Se importa la clase Main para poder acceder al input del usuario: Main.getEntrada().nextInt();
import jugador.Jugador; //Se importa la clase jugador para poder acceder a las funcionalidades de "player"
//Clase que implementa la interfaz "Enemigo"
public class Jefe_Final implements Enemigo{

    //Atributos pedidos del enemigo
    private String nombre;
    private int vida, dano_base;

    /*Atributos locales para el funcionamiento del metodo "combate"
    respuesta: Input del usuario a traves de la clase Main
    hechizo: Daño que realizada el jugador con un hechizo
    ataque: Daño que realizada el jugador con un ataque
    vida_max: Vida maxima del jefe_final (se usa para cambiar de fase)
    dano_fase: Daño que realizará el Jefe Final el cual dependerá de la fase actual en la que se encuentre
    cambio: flag para verificar que se cambie de fase solo una vez
    */
    private int respuesta, hechizo, ataque, vida_max, dano_fase, cambio;

    //Constructor donde se establecen los atributos locales al crear un nuevo Jefe_Final
    public Jefe_Final(String nombre, int vida, int dano_base){
        this.vida = this.vida_max = vida;
        this.dano_base = dano_base;
        this.nombre=nombre;
    }
    //Metodo que se implementa de la interfaz "Enemigo"
    /*
    Metodo que se encarga de toda la "pelea" entre el jugador y el jefe final.
    Se ejecuta mientras el jefe y el jugador esten vivos. 
    Tienes la opcion de elegir entre atacar o mostrar stats actuales.
    Una vez el jugador ataque, se llamara al metodo correspondiente del jugador.
    Si la vida del jefe final es menor o igual a la mitad se cambiara a fase 1 (fase inicial 2).
    Luego del ataque del jugador el jefe final ejecuta su ataque y si muere el jugador se acaba del juego.
    Al ser de tipo void no retorna nada.
    */
    public void combate(Jugador player) {
        cambio=0;   //Se define cambio
        this.dano_fase=this.dano_base+4;
        System.out.println("Te has encontrado al Jefe Final "+nombre+".\nRezaré por ti "+player.getNombre());
        while(this.vida>0 && player.getVida()>0){   //Se ejecuta mientras la vida del Jefe Final y del jugador sean mayor a 0.
            System.out.println("\t1. Lanzar ataque \n\t2. Lanzar hechizo\n\t3. Mostrar stats");
            this.respuesta = Main.getEntrada().nextInt();   //Input del usuario  
            if(this.respuesta==3){  //Mostrar Stats
                while(this.respuesta==3){   //Mientras su opcion sea mostrar Stats se ejecutará
                    player.mostrar_stats();
                    System.out.println("\t1. Lanzar ataque \n\t2. Lanzar hechizo\n\t3. Mostrar stats");
                    this.respuesta = Main.getEntrada().nextInt();
                }
            }
            if(this.respuesta==1){  //Lanzar Ataque
                ataque=player.ataque(); //Se llamaba al metodo ataque de player
                System.out.println("Daño realizado con el ataque: "+ataque);
                this.vida-=ataque;  //Se quita de la vida del Jefe el daño del ataque
            }
            else if(this.respuesta==2){ //Lanzar hechizo
                hechizo=player.hechizo();   //Se llamaba al metodo hechizo de player
                System.out.println("Daño realizado con el hechizo: "+hechizo);
                this.vida-=hechizo; //Se quita de la vida del Jefe el daño del ataque
            }
            if(this.vida<=((int)(this.vida_max/2))&&cambio==0){ //Si la vida del jefe es la mitad a su vida maxima y aun no cambia de fase, cambiará
                this.dano_fase=this.dano_base+2; //Daño de fase del jefe
                System.out.println(this.nombre+" Esta cambiando de fase, animo!");
                cambio++;   //Cambia la flag para que no se repita el cambio de fase.
            }
            if(this.vida<=0){   //Muere el Jefe Final
                System.out.println("¡Has derrotado a "+this.nombre+ " ¡Felicidades!");//Omedetooo Shinji xd
                player.setState(1); //Cambia el estado del jugador (para poder terminar el juego al matar al jefe final)
                break;
            }
            else{   //No muere aun el jefe
                System.out.println("Vida actual de "+this.nombre+": "+ this.vida);
                player.setVida(player.getVida()-this.dano_fase);    //El Jefe Final realiza su ataque 
                System.out.println(this.nombre+" ha lanzado un ataque, daño sufrido: "+this.dano_fase);
            }
            if(player.getVida()<=0){//Si muere el jugador imprime la vida minima (0) y el texto de muerte.
                player.setVida(0); 
                System.out.println("\nVida actual: "+player.getVida());
                System.out.println(this.nombre+" te ha derrotado:(");
            }

        }
    }

    //Getter
    public int getVida() {
        return vida;
    }public int getAtaque() {
        return ataque;
    }public int getCambio() {
        return cambio;
    }public int getDano_base() {
        return dano_base;
    }public int getDano_fase() {
        return dano_fase;
    }public int getHechizo() {
        return hechizo;
    }public String getNombre() {
        return nombre;
    }public int getRespuesta() {
        return respuesta;
    }public int getVida_max() {
        return vida_max;
    }
    //Setter
    public void setVida(int vida) {
        this.vida = vida;
    }public void setAtaque(int ataque) {
        this.ataque = ataque;
    }public void setCambio(int cambio) {
        this.cambio = cambio;
    }public void setDano_base(int dano_base) {
        this.dano_base = dano_base;
    }public void setDano_fase(int dano_fase) {
        this.dano_fase = dano_fase;
    }public void setHechizo(int hechizo) {
        this.hechizo = hechizo;
    }public void setNombre(String nombre) {
        this.nombre = nombre;
    }public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }public void setVida_max(int vida_max) {
        this.vida_max = vida_max;
    }
}
