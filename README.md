Reconquistando la Tierra de Fantasía

En esta aventura, acompañarás a una raza de guerreros en su misión por reconquistar la tierra que le ha sido arrebatada en anteriores batallas. Estos guerreros han recobrado fuerzas y disponen de un ejército que consideran suficientemente poderoso para emprender esta epopeya.
De camino a la tierra deseada se encontrarán con diversos poblados. Algunos de los cuales son hostiles, a los que deberán vencer para poder continuar el camino. Otros poblados son aliados, y permitirán que las tropas descansen y la mitad de su población se sumará a tu ejército.
Es importantísimo no desperdiciar recursos y, aún a riesgo de no encontrar poblados aliados, recorrer el camino más rápido entre su ubicación actual y la tierra destino: el tiempo apremia. Cada batalla o descanso, dura un día.
Se te buscó, hechicero del código, para que prepares unos conjuros algorítmicos que te permitan:
1.	predecir si esta misión es factible, y
2.	en caso de serlo:
○	cuántos guerreros llegarían hasta el final del camino, y
○	en cuánto tiempo.
Datos para resolver el problema
Razas
Un Wrives tiene una salud inicial de 108. 
Ocasiona un daño básico de 113 puntos. 
Cuando ataca, lo hace con 2 veces su daño, cada 2 ataques. 
Al recibir un ataque recibe 2 veces el daño, ya que no lleva armadura. 
Cuando descansa, se rehúsa a atacar hasta que lo ataquen. Gracias a esto, aumenta su salud y su salud máxima en 50.
Una Reralopes tiene una salud inicial de 53. 
Ocasiona un daño básico de 27 puntos. 
Cuando ataca, erra 2 de cada 4 ataques. 
Al recibir un ataque se desconcentra y sus ataques vuelven al valor normal inicial. 
Cuando descansa, sus próximos 3 ataques (de esa unidad) dañan el doble del valor correspondiente.
Una Radaiteran tiene una salud inicial de 36. 
Ocasiona un daño básico de 56 puntos. 
Cuando ataca, lo hace cada vez con más fuerza (3 de daño extra x la cantidad de ataques dados). Al recibir un ataque lo hace normalmente. Cuando descansa, no le sucede nada.
Un Nortaichian tiene una salud inicial de 66. 
Ocasiona un daño básico de 18 puntos. 
Cuando ataca, se cura un 4 por ciento de su salud. 
Al recibir un ataque se enfurece y sus ataques multiplican por 2 su daño (dura 2 turnos propios). Cuando descansa, recupera toda su salud, pero se vuelve de piedra por 2 turnos (contiguos), lo que hace que no pueda atacar, pero reduce el daño entrante en 1/2.
Batallas
Las batallas en la Tierra de Fantasía se realizan de una manera muy ordenada:
1.	Se forman ambos ejércitos en línea. Nuestro ejército formará primero a las unidades aliadas, luego a las propias.
2.	La unidad que haya quedado herida de la batalla anterior siempre será la última en recibir ataques.
3.	Siempre comienza a atacar nuestro bando.
4.	Se turnan ambos ejércitos para atacarse.
5.	Al quedarse con la salud en cero, la unidad se desmaya y queda fuera de combate y no continúa la misión.
6.	Termina el combate cuando un ejército se queda sin contendientes de pie.
Poblados
Se suministrará un archivo con la información de los caminos que interconectan a los poblados, y los datos de dicho poblado. Por ejemplo:
4
1 100 Wrives propio
2 30 Reralopes aliado
3 40 Nortaichian enemigo
4 60 Nortaichian enemigo
1 -> 4
1 2 10
1 3 20
2 3 5
3 4 7

En ese archivo figura toda la información necesaria para la predicción:
●	Una línea con la cantidad de pueblos (n, 4 en el ejemplo).
●	n líneas autonumeradas, que representan cada pueblo, con el total de habitantes, la raza, y si es propio / aliado / enemigo. “Propio” será un único pueblo.
●	Una línea que indica el pueblo inicial, y el pueblo final (1 -> 4).
●	x líneas que indican la distancia entre cada par de pueblos, siendo estos datos pueblo de origen, pueblo destino, distancia en kilómetros.
Dato de vital importancia para la trama: Una tropa avanza 10 kilómetros por día.
