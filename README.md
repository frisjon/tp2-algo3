# tp2-algo3

### Entregas

(en __negrita__ estan las pruebas ya hechas y pasan)

---
#### 1ra Entrega (5 de junio - 8 de junio)

Turnos, Jugadores, Unidades, Tablero, casillero, transformaciones con costo de Ki únicamente

1. Se ubica un personaje en un casillero, se pide que se mueva, se verifica nueva posición acorde a su modo.
2. Se verifica que no puede haber 2 personajes en el mismo casillero
3. Se ubican 2 personajes y se verifica de que no puede pasar uno encima del otro.
4. Se ubica un personaje __se lo transforma, se verifica que se pueda transformar.__(test en testPersonajes)
5. Se ubica un personaje, realiza una transformación y se pide que se mueva y se verifica que su nueva posición sea acorde.
6. Crear una prueba de integración en la cual se pueda crear un juego, con 2 jugadores cada uno de ellos con sus 3 personajes distribuidos en el tablero según el enunciado.
7. Combinaciones en modos de: Ubicar un Guerrero Z, ubicar un Enemigo de la Tierra, pedir que se ataquen respetando ( y no ) las distancias verificando los daños ( o no daños ).

---
#### 2da Entrega (12 de junio - 15 de junio)

1ra entrega + transformaciones con requisitos especiales + ataques especiales con efectos

1. Posicionar a los Guerreros Z, __llevar a Gohan a su primera transformación, comprobar que no puede llegar a la segunda.__(test en testPersonajes)
2. Posicionar a los Guerreros Z, __dejar a Goku y Piccolo con la vida necesaria para la transformación de Gohan, y comprobar que se realiza correctamente.__(test en testPersonajes)
3. __Posicionar a Gohan y Piccolo y llevar a este último a su primera transformación, luego comprobar que no puede llegar a la segunda.__(test en testPersonajes)
4. __Posicionar a Gohan y Piccolo, dejar a Gohan con la vida necesaria para que Piccolo pueda realizar su segunda transformación, comprobar que los cambios se hicieron correctamente.__(test en testPersonajes)
5. __Posicionar a Cell y comprobar que no puede realizar sus transformaciones.__(test en testPersonajes)
6. Posicionar a Cell y a un Guerrero Z, comprobar el correcto funcionamiento de *absorber vida*.
7. Posicionar a Cell y a un Guerrero Z, efectuar *absorber vida* las veces necesarias para que pueda transformarse y comprobar que los cambios se hicieron correctamente.
8. Posicionar a Majin Boo, y a un Guerrero Z, comprobar el correcto funcionamiento de *Conviértete en chocolate*
9. Posicionar a Goku y verificar que su daño aumenta, al reducir su vida por debajo del 20%.

---
#### 3ra Entrega: (19 de junio - 22 de junio)

2da entrega + Consumibles. Trabajo Práctico completo funcionando, con interfaz gráfica final, sonidos e informe completo.

1. Ubicar un consumible y un personaje en casilleros diferentes, y verificar que el consumible desaparece, al mover el personaje al mismo casillero.
2. Repetir 1 y verificar que se aplica correctamente el efecto de cada consumible (un test por cada consumible).
