-----------------------------------------------------------------------------------------------------
-----------------------------------------PRIMERA ENTREGA--------------------------------------------- -----------------------------------------------------------------------------------------------------

La estructura seria:
						Interfaz Personaje -->
							Objeto Autobot
								Objeto Los 4 tipos de autobots			
							Objeto Decepticon
								Objeto Los 4 tipos de decepticons
Donde con esta estructura se pueden diferenciar unos a otros para no atacarse entre si

Tablero es una matriz de Posiciones ( casilleros ), donde cada casillero/posicion es un objeto que 
sabe si esta ocupado ( SOLO PUEDE TENER UN PERSONAJE tanto en aire como en tierra, es indiferente )
tiene una referencia al personaje porque el casillero sabe a quien tiene si esta ocupado
y primeramente el objeto casillero/posicion tendria la misma posicion "X,Y" que tiene el mapa como clave

Se considera que el algoformer sabe como moverse y es el que puede moverse, luego
se comunica con el tablero para indicar el cambio de posicion

el movimiento valida que en el eje x se mueva < = a la distancia maxima y tambien 
que ne el eje y se mueva < = a la distancia maxima


-----------------------------------------------------------------------------------------------------
-----------------------------------------SEGUNDA ENTREGA--------------------------------------------- -----------------------------------------------------------------------------------------------------

Cambios segun lo hablado en la clase:

-Cambio general en los algoformers para que los mismos posean un estado,
en el cual esten sus atributos
-Creacion de todos los estados
-Refactoring de nombres para que el tablero sea mas generalizado
-Creada funcion para calcular distancion en la clase Posicon
-Agregada verificacion de movimiento de algoformers
-La clase posicionable se convirtio en interfaz
-Cambio en la clase partida para que el mismo sea quien ingrese a los
algoformers a las posiciones que se establezcan y que el cree y
posicione la chispaSuprema y almacene su posicion
-Cambio dentro de EstadoAlgoformer para conocer si el algoformer es una
unidad terrestre o es una unidad aerea

Incorporacion de Integracion Continua con Travis