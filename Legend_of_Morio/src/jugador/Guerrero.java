package jugador;

//Clase Guerrero que hereda la clase jugador
public class Guerrero extends Jugador{

    
    //Constructor de la clase Guerrero, donde se establecen los estados iniciales del jugador tipo Guerrero.
    public Guerrero(String nombre){
        super(nombre);
        this.setVida(20);
        this.setFuerza(9);
        this.setInteligencia(1);
        this.setEnergia(10);
        this.setMana(2);
        //
        this.setVida_max(20);
        this.setFuerza_max(9);
        this.setInteligencia_max(1);
        this.setEnergia_max(10);
        this.setMana_max(2);
    }

    //Metodo Auxiliar para subir los stats según su clase (se usa en el metodo subir_experiencia).
    /*
    Se usa al subir de nivel al jugador, para mejorar sus stats y poner al maximo los actuales debido a la subida de nivel.
    */
    public void Mejorar(){
        this.setVida_max(this.getVida_max()+3*this.getNivel());
        this.setMana_max(this.getMana_max()+1);
        this.setEnergia_max(this.getEnergia_max()+2*this.getNivel());
        this.setInteligencia_max(this.getInteligencia_max()+1);
        this.setFuerza_max(this.getFuerza_max()+5*this.getNivel());
        //
        this.setVida(this.getVida_max());
        this.setMana(this.getMana_max());
        this.setEnergia(this.getEnergia_max());
        this.setInteligencia(this.getInteligencia_max());
        this.setFuerza(this.getFuerza_max());
    }

    //Metodo Ataque (mismo funcionamiento que las demas clases de jugador, excepto por los costos)
    /*
    El metodo ataque se encarga de ejecutar el ataque del jugador.
    Si la energia del jugador es menor o igual a 0, entonces el daño del ataque será de 0 ya que no tiene energia y no disminuira mas de 0.
    En caso contrario, se verá si la energia es menor a 5 (pero todavia mayor a 0) y si se cumple el ataque se ejecuta de igual manera
    y la energía se establece en 0.
    En caso de que la energia sea mayor o igual a 5 se resta de la energia el costo del ataque (3).
    retorna un entero que corresponde a la cantidad de daño que hará el ataque.
    */
    @Override
    public int ataque() {
    //Agregar especificaciones
        int suma, energia_final;
        if(this.getEnergia()>0){
            this.setEnergia(this.getEnergia()-5);
            suma = (this.getFuerza()*2)+(this.getEnergia()+5);
            energia_final = (this.getEnergia()<0) ? 0:this.getEnergia();
        }
        else{
            suma = energia_final = 0;
        }
        this.setEnergia(energia_final);
        return suma;
    }

    //Metodo hechizo (mismo funcionamiento que las demas clases de jugador, excepto por los costos)
    /*
    El metodo hechizo se encarga de ejecutar el hechizo del jugador.
    Si el maná del jugador es menor o igual a 0, entonces el daño del hechizo será de 0 ya que no tiene maná y no disminuira mas de 0.
    En caso contrario, se verá si el maná es menor a 3 (pero todavia mayor a 0) y si se cumple el hechizo se ejecuta de igual manera
    y el maná se establece en 0.
    En caso de que el maná sea mayor o igual a 3 se resta del maná el costo del hechizo (3).
    retorna un entero que corresponde a la cantidad de daño que hará el hechizo.
    */
    @Override
    public int hechizo() {
        int suma, mana_final;
        if(this.getMana()>0){
            this.setMana(this.getMana()-3);
            suma = (this.getInteligencia()*((int)(this.getFuerza()/4)))+(this.getMana()+3);
            mana_final = (this.getMana()<0) ? 0:this.getMana();
        }
        else{
            suma = mana_final = 0;
        }
        this.setMana(mana_final);
        return suma;

    }

    //subir_experiencia (mismo funcionamiento que las demas clases de jugador)
    /*
    Metodo heredado de la clase Jugador y se sobreescribe.
    El metodo subir_experiencia consiste en un ciclo while que le quita uno a la xp entregada como parametro y se ejecutará hasta que la xp sea igual a 0.
    En cada ciclo se verifica si la xp es una de las cantidades en las que sube de nivel, en caso de que sea asi, se llama al metodo anterior Mejorar() y
    subiran los stats maximos y los actuales se estableceran en el maximo posible y se le anuncia al jguador el nivel actualizado.
    */
    @Override
    public void subir_experiencia(int xp) {
        while(xp!=0){
            this.setXp(this.getXp()+1);
            xp--;
            if(this.getXp()==10){
                this.setNivel(this.getNivel()+1);
                Mejorar();
                System.out.println("Felicidades "+getNombre()+" has subido de nivel.\nNivel actual: "+getNivel());
            }
            else if(this.getXp()==25){
                this.setNivel(this.getNivel()+1);
                Mejorar();
                System.out.println("Felicidades "+getNombre()+" has subido de nivel.\nNivel actual: "+getNivel());
            }
            //
            else if(this.getXp()==50){
                this.setNivel(this.getNivel()+1);
                Mejorar();
                System.out.println("Felicidades "+getNombre()+" has subido de nivel.\nNivel actual: "+getNivel());
            }
            else if(this.getXp()==100){
                this.setNivel(this.getNivel()+1);
                Mejorar();
                System.out.println("Felicidades "+getNombre()+" has subido de nivel.\nNivel actual: "+getNivel());
            }
            else if(this.getXp()==200){
                this.setNivel(this.getNivel()+1);
                Mejorar();
                System.out.println("Felicidades "+getNombre()+" has subido de nivel.\nNivel actual: "+getNivel());
            }
            else if(this.getXp()==350){
                this.setNivel(this.getNivel()+1);
                Mejorar();
                System.out.println("Felicidades "+getNombre()+" has subido de nivel.\nNivel actual: "+getNivel());
            }
            else if(this.getXp()==600){
                this.setNivel(this.getNivel()+1);
                Mejorar();
                System.out.println("Felicidades "+getNombre()+" has subido de nivel.\nNivel actual: "+getNivel());
            }
            else if(this.getXp()==900){
                this.setNivel(this.getNivel()+1);
                Mejorar();
                System.out.println("Felicidades "+getNombre()+" has subido de nivel.\nNivel actual: "+getNivel());
            }    
        }
    }
}
