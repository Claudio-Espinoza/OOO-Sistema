# Objetos en Java

---

En la programación orientada a objetos (POO), un objeto es la representación de una entidad del mundo real en un programa de computadora. Los objetos encapsulan datos (atributos) y comportamiento (métodos) que definen las características y funcionalidades de dicha entidad.

## 1. Características de un Objeto:

> **Atributos:** Son las propiedades o características que describen el estado de un objeto. Se declaran utilizando variables dentro de la clase que define el objeto. Por ejemplo, en una clase Libro, los atributos podrían ser titulo, autor, ISBN y numeroDePaginas.

> **Métodos:** Son las acciones que un objeto puede realizar. Se definen como funciones dentro de la clase y permiten manipular los atributos del objeto o interactuar con otros objetos. Por ejemplo, en una clase Libro, los métodos podrían ser prestar(), devolver(), mostrarInformacion().

## 2. Creación de Objetos:

> Las clases sirven como plantillas para crear objetos. Para crear un objeto a partir de una clase, se utiliza la palabra clave new seguida del nombre de la clase y argumentos entre paréntesis. Por ejemplo, para crear un objeto Libro llamado miLibro, se escribiría:

> `Libro miLibro = new Libro();`

## 3. Acceso a Atributos y Métodos:

> Se utiliza el operador de punto (.) para acceder a los atributos y métodos de un objeto. Por ejemplo, para acceder al atributo titulo del objeto miLibro, se escribiría:

> `String tituloLibro = miLibro.titulo;`

> Para llamar a un método de un objeto, se utiliza el nombre del método seguido de paréntesis, incluyendo argumentos si es necesario. Por ejemplo, para llamar al método mostrarInformacion() del objeto miLibro, se escribiría:

> `miLibro.mostrarInformacion();`

## 4. Beneficios de los Objetos:

> **Modularidad:** Los objetos permiten dividir un programa en módulos independientes y reutilizables, mejorando la organización y el mantenimiento del código.

> **Encapsulación:** Los datos y el comportamiento de un objeto se encuentran ocultos dentro de la clase, protegiéndolos de accesos o modificaciones no deseados.

> **Reutilización:** Las clases pueden ser reutilizadas para crear múltiples objetos con las mismas características y comportamiento, ahorrando tiempo y esfuerzo de programación.

> **Abstracción:** Los objetos permiten enfocarse en las características y funcionalidades esenciales de una entidad, ignorando detalles de implementación innecesarios.

## 5. Ejemplo:

> Imagina un sistema de gestión de bibliotecas. Se pueden crear clases para representar libros, autores, usuarios y préstamos. Cada clase tendría sus propios atributos y métodos, y los objetos de estas clases se utilizarían para almacenar y manipular la información del sistema.

# Recursos adicionales:

---

https://www.tokioschool.com/formaciones/cursos-programacion/java/
https://www.youtube.com/watch?v=OAfH0KHqvKs
https://www.programarya.com/Cursos/Java/Objetos-y-Clases
