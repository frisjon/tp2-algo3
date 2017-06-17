# tp2-algo3

# Cosas que hay que hacer para que esté prolijo:

- poner los métodos en sus tipos correspondientes (private, static, etc)
- poner las clases en sus tipo correspondientes (private, static, final, etc)
- sacar los try/catch y sólamente dejar throws en la firma cuando realmente haya una posibilidad de que entre en la excepción. Para esto ahora usamos runtime exceptions que el código queda mucho más prolijo.
- poner bien los tipos cuando usamos List/Map. No poner siempre ArrayList/HashMap. Ej: en la firma de colocarPersonajesEnTablero va Map. Lo mismo en los constructores.
- no castear al pedo. Por ejemplo en las pruebas hay cast a int al pedo. Más facil crear double de una, respetando el tipo de dato de la variable que se quiere usar.

### Entregas

#### 3ra Entrega: (19 de junio - 22 de junio)

2da entrega + Consumibles. Trabajo Práctico completo funcionando, con interfaz gráfica final, sonidos e informe completo.

1. Ubicar un consumible y un personaje en casilleros diferentes, y verificar que el consumible desaparece, al mover el personaje al mismo casillero.
2. Repetir 1 y verificar que se aplica correctamente el efecto de cada consumible (un test por cada consumible).
