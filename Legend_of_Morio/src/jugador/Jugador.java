package jugador;
import misiones.Mision;
import java.util.ArrayList;
import java.util.List;

//Clase abstracta jugador
public abstract class Jugador{
    //Metodos pedidos, personalizados y maximos, separados.
    private String nombre;//pedido
    private int vida, xp, fuerza, inteligencia, energia, mana, nivel;//Pedidos
    private int vida_max, energia_max, mana_max, inteligencia_max, fuerza_max;//Maximos
    private int state,cantidad_misiones,monstruos_asesinados, posicion;//personalizados
    private List<Mision> lista_misiones = new ArrayList<>();//Lista misiones|pedidos
    
    //Constructor de la clase Jugador, que recibe un String como parametro que corresponde al nombre del jugador.
    //Se establecen estados iniciales (los generales que son iguales para todos los jugadores.)
    public Jugador(String nombre){
        this.nombre = nombre;
        this.setState(0);
        this.setCantidad_misiones(0);
        this.setMonstruos_asesinados(0);
        this.setXp(0);
        this.setNivel(1);
    }
    //Metodo que al llamarlo se encarga de mostrar los stats actuales del jugador.
    public void mostrar_stats() {
        System.out.println("Tus estadisticas actuales son las siguientes:\nVida actual: "+ this.getVida());
        System.out.println("Maná: "+ this.getMana());
        System.out.println("Energía: "+ this.getEnergia());
        System.out.println("Inteligencia: "+ this.getInteligencia());
        System.out.println("Fuerza: "+ this.getFuerza());
    }

    //Metodos abstractos que se heredaran a las clases de jugador.
    public abstract int ataque();
    public abstract int hechizo();
    public abstract void subir_experiencia(int xp);

    //Getter Atributos pedidos 
    public String getNombre() {
        return nombre;
    }public int getEnergia() {
        return energia;
    }public int getFuerza() {
        return fuerza;
    }public int getInteligencia() {
        return inteligencia;
    }public int getMana() {
        return mana;
    }public int getVida() {
        return vida;
    }public int getXp() {
        return xp;
    }
    // Getters personalizados
    public int getNivel() {
        return nivel;
    }public int getPosicion() {
        return posicion;
    }public int getState() {
        return state;
    }public int getCantidad_misiones() {
        return cantidad_misiones;
    }public List<Mision> getLista_misiones() {
        return lista_misiones;
    }public int getMonstruos_asesinados() {
        return monstruos_asesinados;
    }
    // Getters Atributos Maximos
    public int getEnergia_max() {
        return energia_max;
    }public int getMana_max() {
        return mana_max;
    }public int getVida_max() {
        return vida_max;
    }public int getFuerza_max() {
        return fuerza_max;
    }public int getInteligencia_max() {
        return inteligencia_max;
    }
    //setter atributos pedidos
    public void setEnergia(int energia) {
        this.energia = energia;
    }public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }public void setMana(int mana) {
        this.mana = mana;
    }public void setXp(int xp) {
        this.xp = xp;
    }public void setVida(int vida) {
        this.vida = vida;
    }
    //Setters personalizados
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }public void setNivel(int nivel) {
        this.nivel = nivel;
    }public void setState(int state) {
        this.state = state;
    }public void setCantidad_misiones(int cantidad_misiones) {
        this.cantidad_misiones = cantidad_misiones;
    }public void setLista_misiones(List<Mision> lista_misiones) {
        this.lista_misiones = lista_misiones;
    }public void setMonstruos_asesinados(int monstruos_asesinados) {
        this.monstruos_asesinados = monstruos_asesinados;
    }
    //Setters Atributos Maximos
    public void setEnergia_max(int energia_max) {
        this.energia_max = energia_max;
    }public void setMana_max(int mana_max) {
        this.mana_max = mana_max;
    }public void setVida_max(int vida_max) {
        this.vida_max = vida_max;
    }public void setFuerza_max(int fuerza_max) {
        this.fuerza_max = fuerza_max;
    }public void setInteligencia_max(int inteligencia_max) {
        this.inteligencia_max = inteligencia_max;
    }
}
