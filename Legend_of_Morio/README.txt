Intrucción de compilación:

consejos para trabajar con el programa:
Al ejecutar primero tratará con el DM, el cual se encargará de establecer el mundo. 
Se deberá manerar las preguntas mediantes números a menos que en la consola se indique lo contrario (Caso de tipo de misión del npc neutro). 
El programa indicará cada etapa, entre las cuales están: Empezar el juego, mover tierra, empezar y terminar combate, terminar juego, etc...

Detalles adicionales e interpretaciones sobre la entrega:
Se importaron algunos elementos, tanto para general números aleatorios como para pedir input al usuario por consola.
La forma de subir nivel del Druida lo interprete como que por cada nivel que sube se aumentaban todos los stats en el nivel en el que iba.
Cada vez que se pase por la misma casilla, si habia un monstruo, este volverá a aparecer y volverá a interactuar con el npc (en caso de haber uno),
si el npc es neutro, interactuará, pero no dará nuevamente su misión.
Si una mision da al jugador la suficiente experiencia como para subir mas de un nivel, subirá los niveles correspondientes uno por uno.
En caso que el DM decida que en una casilla no hay monstruo se ignorará toda interacción de combate en esa casilla, pero seguirá la del npc en caso de haber uno.
Se hizo un menú para el usuario, que consiste en si quiere mover al jugador o mostrar stats.

Cosas adicionales a las pedidas:
Main: A la clase main le agregue un metodo auxiliar que se llama Iniciar_mundo() el cual se encarga de tener la mayor parte
de la interacción con el DM, es de tipo Lista de Tierras. En este metodo se crea el mundo y se ocupa en el metodo Main, donde
la lista que retorna se almacena en una lista local del main.
Tambien le agregué dos variables globables, las cuales corresponden a la entrada que se recibirá por consola y el otro es un entero
que corresponde al tamaño del mundo.

Jefe_Final: Al jefe final se le agregaron atributos, los cuales son:
    respuesta: Input del usuario a traves de la clase Main
    hechizo: Daño que realizada el jugador con un hechizo
    ataque: Daño que realizada el jugador con un ataque
    vida_max: Vida maxima del jefe_final (se usa para cambiar de fase)
    dano_fase: Daño que realizará el Jefe Final el cual dependerá de la fase actual en la que se encuentre
    cambio: flag para verificar que se cambie de fase solo una vez.

Monstruo: A la clase Monstruo se le agregaron atributos, los cuales son:
    respuesta: Input del usuario a traves de la clase Main
    vida_inicial: vida inicial del monstruo para que "aparezca uno" nuevo cada que pasa por la casilla
    hechizo: Daño que realizada el jugador con un hechizo
    ataque: Daño que realizada el jugador con un ataque

Jugador: Se le agregaron multiples atributos para el correcto funcionamiento de programa, los corresponden a los maximos de
sus stats actuales y otros extras. Los extras son contadores de cosas especificas los cuales son: cantidad_misiones, monstruos_asesinados, posicion.
Tambien esta incluido una flag que corresponde a si ya asesino o no al jefe final (ayuda a terminar el programa en caso de ser asi).

Tambien le añadi un metodo que se llama "mostrar_stats", el cual al llamarlo muestra las estadisticas actuales del jugador. 

Mago, Druida, Guerrero: A las 3 clases se le añadio el mismo metodo, el cual es uno de tipo void y y se llama Mejorar(). Este metodo se utiliza al momento 
de subir de nivel para mejorar los stats según las especificaciones pedidas y para establecer los stats al maximo cada que se sube de nivel.

Bosque, Montana, Planicie: Se le añadio un número flotante aleatorio, el cual sirve para la posibilidad de spawneo de los mobs.

Además se le añadieron los getters y setters correspondientes a los atributos extras previamente mencionados.

pd: El creador se esforzo mucho asi que espero que lo aprecien:(