# Clases en java

En Java, una clase es una plantilla o un modelo a partir del cual se crean objetos. Aquí te explico los conceptos básicos:

# Definición de clase:

> Se define utilizando la palabra clave class, seguida del nombre de la clase.
> Ejemplo:
>
> ```
> public class MiClase {
> // Atributos y métodos
> }
> ```

## Atributos:

> Son variables que representan las propiedades o características de la clase.
> Ejemplo:

> ```
> public class Persona {
>   String nombre;
>   int edad;
> }
> ```

## Métodos:

> Son funciones dentro de la clase que definen el comportamiento de los objetos.
> Ejemplo:
>
> ```
> public class Persona {
>   String nombre;
>   int edad;
>   void saludar() {
>       System.out.println("Hola, mi nombre es " + nombre);>
>   }
>
> }
> ```

## Constructor:

> Es un método especial que se llama cuando se crea un objeto de la clase.
> Se usa para inicializar los atributos.
> Ejemplo:
>
> ```
> public class Persona {
>   String nombre;
>   int edad;
>
>   Persona(String nombre, int edad) {
>       this.nombre = nombre;
>       this.edad = edad;
>       }
> }
> ```

## Creación de objetos:

> Un objeto se crea usando la palabra clave new.
>
> ` Persona persona1 = new Persona("Juan", 30);`

## Encapsulamiento:

> Los atributos generalmente se mantienen privados, y se accede a ellos mediante métodos públicos (getters y setters).
> Ejemplo:
>
> ```
> public class Persona {
>   private String nombre;
>   private int edad;
>
>
>    public String getNombre() {
>        return nombre;
>    }
>
>    public void setNombre(String nombre) {
>        this.nombre = nombre;
>    }
>
>    public int getEdad() {
>        return edad;
>    }
>
>    public void setEdad(int edad) {
>        this.edad = edad;
>    }
>
> }
>
> ```

## Herencia:

> Una clase puede heredar de otra clase, permitiendo reutilizar código.
> Se usa la palabra clave extends.
> Ejemplo:
>
> ```
> public class Empleado extends Persona {
> double salario;
>
>    Empleado(String nombre, int edad, double salario) {
>        super(nombre, edad);
>        this.salario = salario;
>    }
>
> }
> ```

## Polimorfismo:

> Permite usar un objeto de una clase derivada como si fuera de su clase base.
> Ejemplo:
>
> `Persona persona = new Empleado("Ana", 25, 50000);`
