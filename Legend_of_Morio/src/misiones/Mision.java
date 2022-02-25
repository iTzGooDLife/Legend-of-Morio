package misiones;

public class Mision {
    private char requisito;//'v' es si debe llegar a una casilla en especifico y 'm' si debe matar una cantidad de monstruos especifica 
    private int valor, cantidad, recompensa, estado;
    public Mision(char requisito, int valor, int cantidad, int recompensa){
        this.requisito=requisito;
        this.valor = valor;
        this.cantidad=cantidad;//Revisar
        this.recompensa=recompensa;
    }
    /*
    valor: coordenada de la casilla que debe llegar o la cantidad de Monstruos que debe matar
    cantidad:  la posición actual del personaje o la cantidad de Monstruos que el Jugador lleva matados
    recompensa: la cantidad de xp que gana el Jugador por cumplir la misión.
    */


    /*
    Metodo de tipo booleano.
    Se encarga de verificar si la cantidad que llega el jugador y el valor al que debe llegar son iguales, en caso
    de que se cumpla retornará true, en caso contrario false.
    */
    public boolean verificar_requisito(){
        if(this.valor==this.cantidad){
            return true;
        }
        else{
            return false;
        }
        
    }
    //Getters
    public int getCantidad() {
        return cantidad;
    }public int getEstado() {
        return estado;
    }public int getValor() {
        return valor;
    }public int getRecompensa() {
        return recompensa;
    }public char getRequisito() {
        return requisito;
    }

    //Setters
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }public void setEstado(int estado) {
        this.estado = estado;
    }public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }public void setRequisito(char requisito) {
        this.requisito = requisito;
    }public void setValor(int valor) {
        this.valor = valor;
    }
}
