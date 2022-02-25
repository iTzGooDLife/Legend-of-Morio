package main;
import jugador.*;
import npc.*;
import interfaz.*;
import tierra.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Variables global que corresponden al Scanner y al tamaño del mundo.
    static Scanner entrada = new Scanner(System.in);
    private static int tamano;

    /*
    Metodo auxiliar de tipo lista de Tierras.
    Se utiliza en el Main y se encarga de pedir las especificaciones del mundo al DM.
    Primero le pregunta al DM cual será el tamaño del mundo, luego itera sobre ese rango y va creando el mundo según
    lo que introduciendo el DM en terminal.
    Va añadiendo las Tierras creadas a la lista y posteriormente la retorna.
    */
    public static List<Tierra> Iniciar_mundo(){
        int tierra; //Tierra y posicion inicial
        int enemigo, vida_enemigo, dano_enemigo; //Monstruo / Jefe Final
        int npc_tipo, npc_valor1, npc_valor2, validador_npc; // NPC
        char npc_valor4;
        float probabilidad_enemigo;
        String nombre_jefe, nombre_npc;
        Tierra tierra2;
        Jefe_Final jefe_final;
        Monstruo monstruo;
        NPC npc;
        List<Tierra> mundo = new ArrayList<>();
        System.out.print("¡Hola Dungeon Master! Ingresa el tamaño del mundo: ");
        tamano = entrada.nextInt();
        entrada.nextLine();
        ///
        for(int i=0;i<tamano;i++){
            ////
            System.out.println("Tipo de tierra para la casilla "+i+": \n\t1. Montaña\n\t2. Planicie\n\t3. Bosque");
            tierra = entrada.nextInt();
            entrada.nextLine();
            if(tierra==1 || tierra==3){
                System.out.println("¡Oh! Sabia elección, aunque pobre jugador");
            }
            else{
                System.out.println("Que agradable de su parte");
            }
            ////
            System.out.println("¿Cual será la probabilidad de aparición de un enemigo?");
            probabilidad_enemigo = entrada.nextFloat();
            entrada.nextLine();
            if(((int)(probabilidad_enemigo*100))<30){
                System.out.println("Que agradable casilla.");
            }
            else if(((int)(probabilidad_enemigo*100))>=50){
                System.out.println("Uf, casilla dificil.");
            }
            ////
            System.out.println("¿Cual será el tipo de enemigo que podría aparecer?\n\t1. Jefe Final\n\t2. Mounstro");
            enemigo = entrada.nextInt();
            if(enemigo==1){
                System.out.println("F por el jugador");
            }
            ////
            System.out.println("¿Cual será la vida del enemigo?");
            vida_enemigo = entrada.nextInt();
            if(enemigo==1){
                System.out.println("¿Cual será el daño base del Jefe Final?");
                dano_enemigo = entrada.nextInt();
                entrada.nextLine();
                System.out.println("¿Cual será el nombre del Jefe Final?");
                nombre_jefe = entrada.nextLine();
                jefe_final = new Jefe_Final(nombre_jefe, vida_enemigo, dano_enemigo);
                monstruo = null;
            }
            else{
                System.out.println("¿Cual será el daño del Monstruo?");
                dano_enemigo = entrada.nextInt();
                monstruo = new Monstruo(vida_enemigo, dano_enemigo);
                jefe_final = null;
            }
            ////
            System.out.println("¿Quieres añadir un npc?\n\t1. Sí\n\t2. No");
            validador_npc = entrada.nextInt();
            ////
            if(validador_npc==1){
                System.out.println("¿Que tipo de NPC habrá en esta casilla?\n\t1. Bueno\n\t2. Malo\n\t3. Neutro");
                npc_tipo = entrada.nextInt();
                entrada.nextLine();
                System.out.println("¿Cual será el nombre del npc?");
                nombre_npc = entrada.nextLine();
                if(npc_tipo==1){//Bueno
                    System.out.println("¿Que atributo mejorará?\n\t1. energía\n\t2. maná\n\t3. xp\n\t4. vida");
                    npc_valor1 = entrada.nextInt();
                    System.out.print("Cantidad a mejorar: ");
                    npc_valor2 = entrada.nextInt();
                    switch(npc_valor1){
                        case 1:
                        npc = new Bueno(nombre_npc, "Energía", npc_valor2);
                        break;
                        case 2:
                        npc = new Bueno(nombre_npc, "Maná", npc_valor2);
                        break;
                        case 3:
                        npc = new Bueno(nombre_npc, "xp", npc_valor2);
                        break;
                        default://tomara cualquier otro valor como vida
                        npc = new Bueno(nombre_npc, "Vida", npc_valor2);
                    }
                }
                else if(npc_tipo==2){//Malo
                    System.out.print("Cantidad de energia a disminuir: ");
                    npc_valor1 = entrada.nextInt();
                    System.out.print("Cantidad de maná a disminuir: ");
                    npc_valor2 = entrada.nextInt();
                    entrada.nextLine();
                    npc = new Malo(nombre_npc, npc_valor1, npc_valor2);
                }
                else{//Neutro
                    System.out.println("Tipo de requisito de la misión: \n\t1. Matar una cantidad de monstruos (Escribir 'm')\n\t2. Llegar a una casilla en especifico (Escribir 'v').");
                    npc_valor4 = entrada.nextLine().charAt(0);
                    System.out.print("Valor a alcanzar: ");
                    npc_valor1 = entrada.nextInt();
                    System.out.print("Valor de la recompensa: ");
                    npc_valor2 = entrada.nextInt();
                    entrada.nextLine();
                    npc = new Neutro(nombre_npc, npc_valor4, npc_valor1, npc_valor2, 0);
                }
            }
            else{
                npc = null;
            }
            if(tierra==1){
                tierra2 = new Montana(probabilidad_enemigo, monstruo, jefe_final, npc);
                
            }
            else if(tierra==2){
                tierra2 = new Planicie(probabilidad_enemigo, monstruo, jefe_final, npc);
            }
            else{
                tierra2 = new Bosque(probabilidad_enemigo, monstruo, jefe_final, npc);
            }
            mundo.add(tierra2);
        }
        return mundo;
    }

    /*
    Metodo Main
    Se crean variables locales y se recibe la tierra creada con el metodo Iniciar_Mundo previamente descrito.
    Aquí se pide el nombre del jugador y que clase será. Posteriormente inicia el juego.
    Se tiene un menú en el que el jugador podrá decidir si se quiere o si quiere mostrar sus Status.
    El jugador empieza en la casilla establecida por el DM y se mueve por la lista de tierras mediante un ciclo while.
    Al moverse se llama al atributo accion de cada tierra que ejecuta las acciones correspondientes.
    Al llegar satisfactoriamente a cada casilla revisa si tiene una misión que consista en llegar a esa casilla 
    y en caso de ser asi le otorga la recompensa correspondiente y elimina la misión de la lista de misiones.
    Si en algun momento del ciclo while el jugador muere o mata al jefe final se termina el juego.
    Cabe mencionar que el mundo es ciclico.
    */
    public static void main(String[] args){
        int posicion, class_player, movimiento, menu;
        boolean accion_mundo;
        String name_player;
        List<Tierra> mundo = Iniciar_mundo();
        System.out.print("¿Cual será la posición inicial del jugador? ");
        posicion = entrada.nextInt();
        entrada.nextLine();
        System.out.print("¿Cual será el nombre del jugador? ");
        name_player = entrada.nextLine();
        System.out.println("¿Cual será la clase del jugador?: \n\t1. Mago\n\t2. Guerrero\n\t3. Druida");
        class_player = entrada.nextInt();
        Jugador player;
        if(class_player==1){//Se Crea el jugador
            player = new Mago(name_player);
        }
        else if(class_player==2){
            player = new Guerrero(name_player);
        }
        else{
            player = new Druida(name_player);
        }
        player.setPosicion(posicion);//Establece posicion jugador
        System.out.println("Comienza el juego, Buena suerte, ¡la necesitarás!");
        do{
            System.out.println("Actualmente estas en la casilla "+player.getPosicion()+".");
            System.out.println("Acción a realizar:\n\t1. Mostrar stats\n\t2. Mover jugador");
            menu = entrada.nextInt();
            if(menu==1){
                while(menu==1){
                    player.mostrar_stats();
                    System.out.println("Acción a realizar:\n\t1. Mostrar stats\n\t2. Mover jugador");
                    menu = entrada.nextInt();
                }
            }
            System.out.println("¿Donde te quieres mover?\n\t1. Izquierda\n\t2. Derecha");
            movimiento = entrada.nextInt();
            entrada.nextLine();
            if(movimiento==1){
                if(posicion==0){//Llega al limite del mundo y vuelve al final
                    posicion=tamano;
                }
                accion_mundo = mundo.get(--posicion).accion(player);
                if(accion_mundo==false && player.getVida()>0){//No pudo llegar a la Tierra
                    posicion++;
                    accion_mundo=true;
                }
            }
            else{
                if(posicion==tamano-1){//Dio la vuelta al mundo y vuelve al inicio
                    posicion=-1;
                }
                accion_mundo = mundo.get(++posicion).accion(player);
                if(accion_mundo==false && player.getVida()>0){//No pudo llegar a la Tierra
                    posicion--;
                    accion_mundo=true;
                }
            }
            player.setPosicion(posicion);//Establece posicion jugador
            ArrayList<Integer> arl = new ArrayList<Integer>();//Itera sobre la lista de misiones
            for(int i=0;i<player.getCantidad_misiones();i++){
                if(player.getLista_misiones().get(i).getRequisito()=='v'){//filtra las que son llegar a un punto especifico
                    player.getLista_misiones().get(i).setCantidad(posicion);
                    if(player.getLista_misiones().get(i).verificar_requisito()){//Se cumplio el requisito
                        System.out.println("Has completado una misión al llega a la parte: "+posicion+" del mundo.");
                        System.out.println("Recompensa obtenida: "+player.getLista_misiones().get(i).getRecompensa());//Otorga recompensa de la mision
                        player.subir_experiencia(player.getLista_misiones().get(i).getRecompensa());//Otorga recompensa de la mision
                        arl.add(i);//Se añade a una lista auxiliar
                    }
                }
            }
            for(int j=0;j<arl.size();j++){//Se eliminan las misiones cumplidas.
                player.getLista_misiones().remove((int)arl.get(j));
                player.setCantidad_misiones(player.getCantidad_misiones()-1);
            }
            arl.clear();
            if(player.getState()==1){//Jugador asesina al jefe final
                break;
            }
            if(player.getVida()<=0){//Jugador muere
                System.out.println("¡Game Over!");
                break;
            }
            
        }
        while(accion_mundo==true && player.getState()==0);
        entrada.close();
    }
    //Getters
    public static Scanner getEntrada() {
        return entrada;
    }public static int getTamano() {
        return tamano;
    }
    //Setters
    public static void setEntrada(Scanner entrada) {
        Main.entrada = entrada;
    }public static void setTamano(int tamano) {
        Main.tamano = tamano;
    }
}
