# Estructuras de Datos en Java: Conceptos Fundamentales

---

Las estructuras de datos son elementos esenciales en la programación que permiten almacenar, organizar y manipular datos de manera eficiente. En Java, existen diversas estructuras de datos que se adaptan a diferentes necesidades y escenarios.

## 1. Tipos de Estructuras de Datos:

> **Arreglos:** Colecciones de elementos del mismo tipo almacenados en posiciones consecutivas en memoria. Se accede a ellos mediante un índice. Son útiles para almacenar listas de datos homogéneos.
>
> `int[] numeros = new int[10]; // Array de enteros con 10 elementos`

> **Listas:** Colecciones dinámicas de elementos que pueden ser de diferentes tipos. Permiten agregar, eliminar y modificar elementos sin necesidad de conocer su tamaño inicial.
>
> ```
> List<String> nombres = new ArrayList<>(); // Lista de cadenas de texto
> nombres.add("Juan");
> nombres.remove(0);
> ```

> **Conjuntos:\*** Colecciones no ordenadas de elementos únicos. Se utilizan para almacenar conjuntos de datos sin duplicados.
>
> ```
> Set<Integer> numerosPares = new HashSet<>(); // Conjunto de números enteros pares
> numerosPares.add(2);
> numerosPares.add(4);
> System.out.println(numerosPares.contains(3)); // Imprime "false"
> ```

> **Mapas:** Colecciones que asocian claves únicas con valores. Permiten almacenar pares clave-valor de manera eficiente.
>
> ```
> Map<String, Estudiante> estudiantes = new HashMap<>(); // Mapa de estudiantes
> estudiantes.put("123", new Estudiante("Pedro", 32));
> Estudiante pedro = estudiantes.get("123");
> System.out.println(pedro.getNombre()); // Imprime "Pedro"
> ```

> **Pilas:** Colecciones LIFO (Last In, First Out). Los elementos se apilan y se desapilan en el orden inverso al que se agregaron.
>
> ```
> Stack<String> pila = new Stack<>(); // Pila de cadenas de texto
> pila.push("Hola");
> pila.push("Mundo");
> System.out.println(pila.pop()); // Imprime "Mundo"
> ```

> **Colas:** Colecciones FIFO (First In, First Out). Los elementos se encolen y se desencolan en el mismo orden en que se agregaron.
>
> ```
> Queue<Integer> cola = new LinkedList<>(); // Cola de números enteros
> cola.add(10);
> cola.add(20);
> System.out.println(cola.poll()); // Imprime 10
> ```

> **Árboles:** Estructuras jerárquicas que almacenan datos en nodos conectados entre sí. Se utilizan para representar relaciones jerárquicas o de clasificación.
>
> ```
> TreeNode<String> raiz = new TreeNode<>("Raíz");
> TreeNode<String> hijoIzquierdo = new TreeNode<>("Hijo Izquierdo");
> TreeNode<String> hijoDerecho = new TreeNode<>("Hijo Derecho");
> raiz.addChild(hijoIzquierdo);
> raiz.addChild(hijoDerecho);
> ```

> **Grafos:** Estructuras compuestas por nodos conectados por aristas. Se utilizan para representar relaciones entre entidades que no tienen una jerarquía estricta.
>
> ```
> Graph<String> graph = new Graph<>();
> graph.addVertex("A");
> graph.addVertex("B");
> graph.addEdge("A", "B");
> System.out.println(graph.getNeighbors("A")); // Imprime ["B"]
> ```

## 2. Elección de la Estructura de Datos Adecuada:

> La elección de la estructura de datos adecuada depende de las características del problema y de las operaciones que se necesiten realizar sobre los datos.
>
> _Factores a considerar:_
>
> 1. Tipo de datos a almacenar
> 2. Acceso a los elementos (secuencial, aleatorio)
> 3. Necesidad de ordenamiento
> 4. Operaciones de inserción, eliminación y búsqueda
> 5. Eficiencia de memoria y tiempo 3. Implementaciones en Java:
>
> Java proporciona implementaciones predefinidas para la mayoría de las estructuras de datos comunes en la biblioteca estándar. También existen bibliotecas de terceros que ofrecen implementaciones más especializadas.

# Recursos adicionales:

---

https://www.freecodecamp.org/espanol/news/las-principales-estructuras-de-datos-que-deberias-saber-para-tu-proxima-entrevista-de-programacion/
