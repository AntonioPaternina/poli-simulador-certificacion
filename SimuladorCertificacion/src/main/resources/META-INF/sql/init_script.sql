
-- temas de certificacion
insert into temacertificacionentity(id, nombre) values (1, 'Java Class Design');
insert into temacertificacionentity(id, nombre) values (2, 'Polymorphism');
insert into temacertificacionentity(id, nombre) values (3, 'Method Overloading');
insert into temacertificacionentity(id, nombre) values (4, 'Overriding');
insert into temacertificacionentity(id, nombre) values (5, 'Advanced Class Design');
insert into temacertificacionentity(id, nombre) values (6, 'Access Modifier');
insert into temacertificacionentity(id, nombre) values (7, 'Inner Class');
insert into temacertificacionentity(id, nombre) values (8, 'Interfaces');
insert into temacertificacionentity(id, nombre) values (9, 'Generics and Collections');
insert into temacertificacionentity(id, nombre) values (10, 'Generic Classes');
insert into temacertificacionentity(id, nombre) values (11, 'Creating and Using Generic Classes');
insert into temacertificacionentity(id, nombre) values (12, 'Java Concurrency');
insert into temacertificacionentity(id, nombre) values (13, 'Using the Java SE 8 Date/Time API');
insert into temacertificacionentity(id, nombre) values (14, 'Building Database Applications with JDBC');
insert into temacertificacionentity(id, nombre) values (15, 'Localization');
insert into temacertificacionentity(id, nombre) values (16, 'Java I/O');
insert into temacertificacionentity(id, nombre) values (17, 'Lambda Built-in functional interfaces');
insert into temacertificacionentity(id, nombre) values (18, 'Exceptions and Assertions');

-- preguntas
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (1, 1, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', '1. public class Overloading {
2. 
3. 	public static int metodoCualquiera(int a1, int a2) {
4. 		return a1 + a2;
5.   	}
6. 
7.   	public static long metodoCualquiera(int b1, int b2) {
8.     	return b1 + b2;
9.   	}
10. 
11.	public static void main(String args[]) {
12.  		System.out.println(metodoCualquiera(1, 2));
13.	}
14. }');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (2, 2, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'class Base {

    Base copy() {
        return new Base();
    }

    public String toString() {
        return "Derived";
    }
}

public class Derived extends Base {

    Derived copy() {
        return new Derived();
    }

    public String toString() {
        return "Derived";
    }

    public static void main(String args[]) {
        Base base = new Derived();
        System.out.println(base.copy());
    }
}');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (3, 3, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'package Main;

public class claseA {
    private int miVar1 = 1;
    public int miVar2 = 2;
    int miVar3 = 3;
}
package Main;

public class claseB {

    public static void main(String[] args) {
   	 claseA a = new claseA();
   	 int v1 = a.miVar2;
   	 int v2 = a.miVar3;
   	 int v3 = a.miVar1;
	System.out.println(v2);
    }
}
package otroPaquete;

import Main.claseA;

public class classC {

    public static void main(String[] args) {
   	 claseA a = new claseA();
   	 int v1 = a.miVar2;
   	 int v2 = a.miVar3;
   	 int v4 = a.miVar1;
	System.out.println(v1);
    }
}');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (4, 4, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'package Main;

public class clase1 {
    public void metodo1() {
   	 System.out.println("método publico");
    }

    private void metodo2() {
   	 System.out.println("método privado");
    }

    protected void metodo3() {
   	 System.out.println("Metodo protegido");
    }
}
package Main;

public class clase2 {

    public static void main(String[] args) {
    clase1 obj = new clase1();
    obj.metodo1();
    obj.metodo3();

    }

}');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (5, 5, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'public class Principal {
    int atri;

    public void metedoPrincipal() {
   	 secundaria objsec = new secundaria();
   	 objsec.metodoSecundario();
    }

    class secundaria {
   	 public void metodoSecundario() {
   		 System.out.println("Imprime");
   	 }
    }
}
public class alterna {
    public static void main(String[] args) {
   	 Principal.secundaria obj = prin.new secundaria();
   	 obj.metodoSecundario();

    }
}');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (6, 6, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'interface Figura {
    final default double calcularArea() {
        return 0;
    }
}

public class Test implements Figura {

    public static void main(String[] args) {
        Figura f = new Test();
        System.out.println(f.calcularArea());
    }
}');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (7, 7, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'public class Caja<T> {
    private T t;

Caja<Integer> integerBox = new Box<Integer>();
Caja<String> stringBox = new Box<String>();');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (8, 8, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'public class Test<T> {

    T entero;
    T cadena;

    Test(T entero, T cadena) {
        this.entero = entero;
        this.cadena = cadena;
    }

    public T getEntero() {
        return entero;
    }

    public T getCadena() {
        return cadena;
    }

    public static void main(String[] args) {
        Test<Integer, String> test = new Test<>(600, "prueba");
        System.out.println(test.getEntero() + test.getCadena());
    }
}');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (9, 9, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'public class HIlo extends Thread {
    
    public void run(){  
   	   for(int i=1;i<=3;i++){  
   		try{  
   	 	Thread.sleep(50);  
   		}catch(Exception e){System.out.println(e);}  
   	   System.out.println(i);  
   	   }  
   	  }  
   	 public static void main(String args[]){  
   	  HIlo t1=new HIlo();  
   	  HIlo t2=new HIlo();  
   	  HIlo t3=new HIlo();  
   	  t1.start();  
   	  try{  
   	   t1.join();  
   	  }catch(Exception e){System.out.println(e);}  
   	   
   	  t2.start();  
   	  t3.start();  
 }');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (10, 10, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'public class RunnableImpl implements Runnable {
    public void run() {
   	 System.out.println("In run(); El nombre del hilo es: " + Thread.currentThread().getName());
    }

    public static void main(String args[]) throws Exception {
   	 Thread myThread = new Thread(new RunnableImpl());
   	 myThread.start();
   	 System.out.println("In main(); El nombre del hilo es: " + Thread.currentThread().getName());
    }
}

public class Test extends Base {

    public int metodo(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        Base base = new Test();
        System.out.println(base.metodo(-6, 3));
    }
}');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (11, 11, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'import java.time.LocalDate;
import java.time.Period;
public class Programa {
    public static void main (String[] args) {
   	 
   	 LocalDate fechaA = LocalDate.of(1983, 2, 25);
   	 LocalDate fechaB = LocalDate.of(2016, 10, 04);
   	 Period period = Period.between(fechaA, fechaB);
   	 System.out.printf("Periodo %s y %s"
   	 + "hay %d años, %d meses"
   	 + " y %d dias%n", fechaA, fechaB,
   	 period.getYears(),
   	 period.getMonths(),
   	 period.getDays());
   	 }

}');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (12, 12, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        LocalDate hoy = LocalDate.of(1969, 31, 3);
        System.out.println(hoy);
    }
}');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (13, 13, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) throws SQLException {
        try (Connection connection = connectToDb();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM test")) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(0) + " - "
                        + resultSet.getString(1));
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public static Connection connectToDb() throws SQLException {
        String url = "jdbc:derby://localhost:1527/test;create=true";
        String userName = "app";
        String password = "app";
        return DriverManager.getConnection(url, userName, password);
    }
}');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (14, 14, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMAN);
        ResourceBundle resBundle
                = ResourceBundle.getBundle("Test");
        System.out.println(resBundle.getString("test"));
    }
}');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (15, 15, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'import java.io.*;;

public class Programa {
    private static final String OUTPUT_File = "C:/Users/Desktop/prueba.txt";
 
   public static void main (String[] args){
   	 String str = "";
   	 char [] chars = new char[1000];
   	 
   	 try (BufferedReader miBuffer = new BufferedReader(new FileReader(new File(OUTPUT_File)), 4096)) {
   		 while ((miBuffer.read(chars)) !=-1){
   			 String chunk = new String(chars);
   			 System.out.println(chunk);
   		 }
   	 } catch (IOException e) {
   		 e.printStackTrace();
   	 }
    }

}');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (16, 16, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'import java.io.*;;

public class Programa implements Serializable {
    private static final long serilVersionUID = 8309080721495266420L;
    private String nombre;
    private String apellido;
    private String cargo;

    public Programa(String nombre, String apellido, String cargo) {
   	 super();
   	 this.nombre = nombre;
   	 this.apellido = apellido;
   	 this.cargo = cargo;
    }

    public String getNombre() {
   	 return nombre;
    }

    public void setNombre(String nombre) {
   	 this.nombre = nombre;
    }

    public String getApellido() {
   	 return apellido;
    }

    public void setApellido(String apellido) {
   	 this.apellido = apellido;
    }

    public String getCargo() {
   	 return cargo;
    }

    public void setCargo(String cargo) {
   	 this.cargo = cargo;
    }

    public boolean igual(Object obj) {
   	 return (this.nombre.equals(((Programa) obj).nombre) && this.apellido.equals(((Programa) obj).apellido)
   			 && this.cargo.equals(((Programa) obj).cargo));

    }

    public String toString() {
   	 return getNombre() + " " + getApellido() + " " + getCargo();

    }
}
public class SalidaObjeto {

    public static void main(String[] args)  {
    try {
   	 FileOutputStream file = new FileOutputStream("C:/Users/Papi/Desktop/prueba2.txt");
   	 Programa prg = new Programa("Elkin","Martinez", "Desarrolador");
   	 ObjectOutputStream salida = new ObjectOutputStream(file);
   	 salida.writeObject(prg);
   	 salida.close();
    } catch (FileNotFoundException e) {
   	 e.printStackTrace();
    }catch (IOException e){
   	 e.printStackTrace();
    }
    }
}');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (17, 17, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'import java.io.*;;

public class Programa {
    public static void main(String[] args) {
   	 ByteArrayOutputStream arreglobufer = new ByteArrayOutputStream();
   	 for (int i = 0; i < 10; i++) {
   		 arreglobufer.write((byte)(Math.random() * 100));
   	 }
   	 
   	 byte[] arreglo = arreglobufer.toByteArray();
   	 System.out.println(" Arreglo original");
   	 for (byte b : arreglo)
   		 System.out.println(b + " ");
   	 arreglobufer.reset();
   	 arreglobufer.write(arreglo, 4, 6);
   	 System.out.println("\n El nuevo arreglo de arreglo> ");
   	 for (byte b : arreglobufer.toByteArray()) {
   		 System.out.print( b + " ");
   	 }
    }    
}');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (18, 18, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'import java.util.function.Predicate;

public class Test {

    public static void main(String[] args) {
        Predicate<Integer> validarNulo = arg -> arg != null;
        Predicate<Integer> validarCero = arg -> arg > 0;
        Predicate<Integer> validarNuloYCero = validarNulo.and(validarCero);

        Integer enteroPrueba = null;
        System.out.println(validarNuloYCero.test(enteroPrueba));
    }
}');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (19, 19, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', '1. class NoEmiteSonido extends Exception {
2. }
3. 
4. interface Ruidoso {
5. 
6.     public abstract void sonar() throws NoEmiteSonido;
7. }
8. 
9. interface Atacante {
10. 
11.     public void atacar();
12. }
13. 
14. abstract class Terrestre implements Atacante {
15. 
16.     public void sonar() {
17.         System.out.print("no puede sonar ");
18.     }
19. 
20. }
21. 
22. class Pato extends Terrestre implements Ruidoso, Atacante {
23. 
24.     public void volar() {
25.         System.out.print("vuela ");
26.     }
27. }');
insert into preguntaentity(id, orden, tipopregunta, textoinicio, textofin, fragmentocodigo) values (20, 20, 'SELECCION_UNICA', 'Considere el siguiente fragmento de código:', 'Escoja la opción correcta basada en el fragmento de código anterior:', 'import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        Stream<String> palabras = Pattern.compile(" ").splitAsStream("a aa aaa aaaa aaaa");
        System.out.println(palabras.map(elemento -> elemento.length()).count());
    }
}');

-- respuestas
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 1, 1, false, 'Se imprime en consola: 3');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 1, 2, false, 'Se imprime en consola 12');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 1, 3, false, 'Se obtiene el error de compilación “incompatible types: possible lossy conversion from int to long” en la línea 8');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 1, 4, false, 'Se obtiene el error de compilación “method metodoCualquiera(int,int) is already defined in class Overloading” en la línea 7');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 2, 1, false, 'Se imprime en consola: Base');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 2, 2, false, 'Se imprime en consola: Derived');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 2, 3, false, 'Ocurre un error de compilación');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 2, 4, false, 'Ocurre un error en tiempo de ejecución');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 3, 1, false, 'Se imprime en consola: 3');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 3, 2, false, 'Se imprime en consola 2.');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 3, 3, false, 'El código no compila, no es posible acceder a la variable miVar1 en claseB.');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 3, 4, false, 'No es posible acceder a la variable miVar1 en claseB, No es posible acceder a la variable miVar3 en claseC, No es posible acceder a la variable miVar1 en claseC');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 3, 5, false, 'Se imprime en consola; 3 2');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 4, 1, false, 'Se Imprime en consola: método publico');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 4, 2, false, 'se obtiene un error de compilación,porque el  método no es visible');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 4, 3, false, 'Se imprime en consola: Metodo protegido');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 4, 4, false, 'Se imprime método publico Metodo protegido, debido a que las clases están contenidas en el mismo paquete');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 5, 1, false, 'Se imprime en consola: imprime');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 5, 2, false, 'El código compila pero no se imprime nada en consola');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 5, 3, false, 'El código no  compila porque no pueden haber dos clases dentro de un archivo  .class');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 5, 4, false, 'El código no compila porque hay  que instanciar  primero un objeto de la clase principal para poder crear una instancia en de la clase secundaria');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 6, 1, false, 'Se imprime en consola: 1');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 6, 2, false, 'El código no compila puesto que la interfaz Figura sólo puede declarar métodos abstractos y no una implementación');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 6, 3, false, 'El código no compila puesto que el método calcularArea debe retornar un double y está retornando un literal entero');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 6, 4, false, 'El código no compila puesto que el método calcularArea no puede ser declarado como final');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 6, 5, false, 'El código no compila puesto que como la clase Test no es abstracta entonces debe implementar el método calcularArea() declarado en la interfaz Figura');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 7, 1, false, 'Son objetos de la clase caja, con tipos enteros y cadena');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 7, 2, false, 'La clase caja extiende de la clase <T> y se crean objetos');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 7, 3, false, 'Se crean objetos de tipo Integer y String dentro de una colección de tipo <T>');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 7, 4, false, 'Se declara la clase Caja  con un tipo  genérico <T> que indica que la clase puede tener un conjuntos de tipos y luego se crean los tipos de cajas que almacenaran tipos  Integer y String');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 7, 5, false, 'Se obtiene la excepción NumberFormatException al tratar de interpretar la cadena “prueba” como un número para poderla utilizar en la operación de suma');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 8, 1, false, 'Se Imprime en consola: 600prueba');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 8, 2, false, 'Se obtiene una excepción en tiempo de ejecución puesto que la operación “+” no está definida para los tipos Integer + String');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 8, 3, false, 'Se obtiene error de compilación puesto que se usa un número incorrecto de argumentos de tipo genérico al declarar la variable test');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 8, 4, false, 'Se obtiene un error de compilación puesto que la clase Test espera un argumento de tipo genérico y se está instanciando new Test<> sin ningún argumento');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 8, 5, false, 'Se obtiene la excepción NumberFormatException al tratar de interpretar la cadena “prueba” como un número para poderla utilizar en la operación de suma');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 9, 1, false, 'Se imprime en consola: 123');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 9, 2, false, 'Se imprime en consola: 11 22 33');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 9, 3, false, 'El código no compila');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 9, 4, false, 'Se imprime en consola 123 11 22 33');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 10, 1, false, 'Se imprime en consola: In main(); thread name is: main');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 10, 2, false, 'Se imprime en consola: In run(); thread name is: Thread-0');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 10, 3, false, 'In run(); thread name is: Thread-0  In main(); thread name is: main');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 10, 4, false, 'In main(); thread name is: main thread name is: Thread-0');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 11, 1, false, 'Calcular la fecha de ingreso al sistema');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 11, 2, false, 'Calcula la fecha en que se inicio windows xp');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 11, 3, false, 'Muestra el tiempo transcurrido entre las dos fechas');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 11, 4, false, 'Calcula el tiempo de vida del sistema operativo');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 12, 1, false, 'El código compila bien pero se lanza una excepción DateTimeException porque el año no puede ser menor a 1970 (tiempo Unix/POSIX).');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 12, 2, false, 'Se imprime en consola: 1969-03-31');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 12, 3, false, 'El código compila bien pero se lanza la excepción DateTimeException en tiempo de ejecución porque el mes es inválido');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 12, 4, false, 'Se imprime en consola: 1969-31-03');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 13, 1, false, 'ocurre un error de compilación puesto que no se ha llamado close() en los recursos: Connection, Statement y ResultSet');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 13, 2, false, 'se imprime en consola: 1 - test');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 13, 3, false, 'el código compila y ejecuta sin errores pero no se imprime nada en consola');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 13, 4, false, 'Se lanza la excepción SQLException ya que la columna está fuera de rango');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 14, 1, false, 'Se imprime en consola: test');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 14, 2, false, 'Se imprime en consola: prueba');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 14, 3, false, 'Se lanza la excepción java.util.MissingResourceException puesto que el recurso Test debe tener el sufijo de la siguiente manera: “Test.properties”');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 14, 4, false, 'Se lanza la excepción java.util.MissingResourceException puesto que no hay ningún archivo properties para Locale.GERMAN');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 15, 1, false, 'Se compila pero arroja una excepción del tipo java.io.FileNotFoundException');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 15, 2, false, 'Se compila, lee los datos del  y los prueba.txt muestra en consola');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 15, 3, false, 'Se compila, crear un archivo con el nombre  prueba.txt');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 15, 4, false, 'Se compila pero no se muestra nada en consola');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 16, 1, false, 'Se compila pero arroja una excepción del tipo java.io.FileNotFoundException e');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 16, 2, false, 'Se compila, pero arroja una excepción del tipo java.io.IOException e');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 16, 3, false, 'Se compila sin errores');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 16, 4, false, 'Se compila y crea un archivo incluyendo los atributos del aobjeto');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 17, 1, false, 'Se compila y muestra en consola que un arreglo');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 17, 2, false, 'Se compila y muestra en consola un arreglo de números aleatorios');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 17, 3, false, 'Se compila crea un arreglo aleatorio de numeros y muestra en consola el contenido del arreglo, y salida el búfer capturado de arreglo');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 17, 4, false, 'No se compila');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 18, 1, false, 'el código compila bien pero se arroja la excepción NullPointerException al tratar de evaluar la expresión arg > 0');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 18, 2, false, 'se imprime en consola false ya que ambos Predicate retornan false');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 18, 3, false, 'el código no compila puesto que test no puede recibir null como argumento');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 18, 4, false, 'se imprime en consola true puesto que no se cumple ninguno de los predicados y se supera la prueba');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 19, 1, false, 'el código no compila puesto que la clase Terrestre implementa Atacante pero no implementa el método atacar()');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 19, 2, false, 'el código no compila, sin embargo, para que el código compile correctamente es necesario que la clase Pato implemente correctamente los métodos atacar() y sonar()');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 19, 3, false, 'el código no compila, sin embargo, para que el código compile correctamente es necesario que la clase Pato implemente correctamente el método atacar()');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 19, 4, false, 'el código compila correctamente');

insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 20, 1, false, 'el código no compila puesto que count() no está definido');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 20, 2, false, 'se arroja la excepción IllegalStateException');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 20, 3, false, 'se imprime en consola: 4');
insert into opcionrespuestaentity(id, pregunta_id, orden, opcioncorrecta, contenido) values (next value for hibernate_sequence, 20, 4, false, 'se imprime en consola 5');