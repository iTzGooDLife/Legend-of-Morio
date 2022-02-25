package interfaz;
import main.Main;
import java.util.ArrayList;

import jugador.Jugador;

public class Monstruo implements Enemigo{

    //Atributos pedidos del enemigo
    private int vida, dano;

    /*Atributos locales para el funcionamiento del metodo "combate"
    respuesta: Input del usuario a traves de la clase Main
    vida_inicial: vida inicial del monstruo para que "aparezca uno" nuevo cada que pasa por la casilla
    hechizo: Daño que realizada el jugador con un hechizo
    ataque: Daño que realizada el jugador con un ataque
    */
    private int respuesta;
    private int vida_inicial;
    private int hechizo;
    private int ataque;

    //Constructor donde se establecen los atributos locales al crear un nuevo Monstruo.
    public Monstruo(int vida, int dano){
        this.vida = vida;
        this.dano = dano;
        this.vida_inicial = vida;
    }

    //Metodo que se implementa de la interfaz "Enemigo".
    /*
    Metodo que se encarga de toda la "pelea" entre el jugador y el monstruo.
    Se ejecuta mientras el monstruo y el jugador esten vivos. 
    El jugador tiene la opcion de elegir entre atacar o mostrar stats actuales.
    Una vez el jugador ataque, se llamara al metodo correspondiente del jugador.
    Luego del ataque del jugador el monstruo ejecuta su ataque y si muere el jugador se acaba del juego.
    En caso de matar al monstruo se revisa la lista de misiones y si se cumple alguna sobre eliminar monstruos
    se otorga la recompensa correspondiente y se quita de la lista de misiones.
    Al ser de tipo void no retorna nada.
    */
    public void combate(Jugador player) {
        System.out.println("Te has encontrado con un monstruo, buena suerte "+player.getNombre()+".");
        while(this.vida>0 && player.getVida()>0){   //Se ejecuta mientras la vida del Jefe Final y del jugador sean mayor a 0.
            System.out.println("\t1. Lanzar ataque \n\t2. Lanzar hechizo\n\t3. Mostrar stats");
            this.respuesta = Main.getEntrada().nextInt();
            if(this.respuesta==3){
                while(this.respuesta==3){
                    player.mostrar_stats();
                    System.out.println("\t1. Lanzar ataque \n\t2. Lanzar hechizo\n\t3. Mostrar stats");
                    this.respuesta = Main.getEntrada().nextInt();
                }
            }
            if(this.respuesta==1){
                ataque=player.ataque();
                System.out.println("Daño realizado con el ataque: "+ataque);
                this.vida-=ataque;
            }
            else if(this.respuesta==2){
                hechizo=player.hechizo();
                System.out.println("Daño realizado con el hechizo: "+hechizo);
                this.vida-=hechizo;
            }
            ////
            if(this.vida<=0){//Muere el monstruo
                ArrayList<Integer> arl = new ArrayList<Integer>();
                System.out.println("¡Has derrotado al monstruo. ¡Felicidades!");
                player.setMonstruos_asesinados(player.getMonstruos_asesinados()+1);
                ///
                for(int i=0;i<player.getCantidad_misiones();i++){//Itera sobre la lista de misiones
                    if(player.getLista_misiones().get(i).getRequisito()=='m'){//filtra las que son llegar a un punto especifico
                        player.getLista_misiones().get(i).setCantidad(player.getLista_misiones().get(i).getCantidad()+1);
                        if(player.getLista_misiones().get(i).verificar_requisito()){//Se cumplio el requisito
                            System.out.println("Has completado una misión al eliminar a: "+player.getMonstruos_asesinados()+" monstruos.");//Otorga recompensa de la mision
                            System.out.println("Recompensa obtenida: "+player.getLista_misiones().get(i).getRecompensa());//Otorga recompensa de la mision
                            player.subir_experiencia(player.getLista_misiones().get(i).getRecompensa());
                            arl.add(i);//Se añade a una lista auxiliar
                        }
                    }
                }
                for(int j=0;j<arl.size();j++){//Se eliminan las misiones cumplidas.
                    player.getLista_misiones().remove((int) arl.get(j));
                    player.setCantidad_misiones(player.getCantidad_misiones()-1);
                }
                arl.clear();
                this.vida=this.vida_inicial;//Se establece la vida inicial para que haya otro monstruo al volver a la casilla
                break;
            }
            else{//Monstruo sigue vivo
                System.out.println("Vida actual del monstruo: "+this.vida);
                player.setVida(player.getVida()-this.dano);//ataque monstruo
                System.out.println("El monstruo ha lanzado un ataque, daño sufrido: "+this.dano);
            }
            if(player.getVida()<=0){//Muere el jugador
                player.setVida(0);
                System.out.println("Vida actual: "+player.getVida());
                System.out.println("El monstruo te ha derrotado:(");
            }
        }       
    }
}