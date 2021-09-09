> **PARTE 1. SOLID**
>
> **Objetivos**
>
> Comprender y saber aplicar los principios SOLID sobre una aplicación
> existente.
>
> **La aplicación**
>
> Sea una aplicación que hace lo siguiente:

+-------+-------------------------------------------------------------+
| > 1\. | +---+---------------------------------------------------+   |
| >     | |   | > Pide dos nombres de ficheros al usuario: uno de |   |
| > 2\. | |   | > entrada y otro de salida.                       |   |
|       | |   | >                                                 |   |
|       | |   | > Transforma el fichero de entrada a un XML       |   |
|       | |   | > escribiéndolo en el fichero de salida.          |   |
|       | +---+---------------------------------------------------+   |
|       |                                                             |
|       | 1\.                                                         |
|       |                                                             |
|       | 2\.                                                         |
+-------+-------------------------------------------------------------+

> **Tareas.**
>
> Antes de empezar descarga el código fuente asociado a esta tarea e
> impórtalo en Eclipse (File-\>Import-\>Existing Java Project).

+-------+-----------------------------+-----------------------------+
| > 1\. | +---+-------------------+   |                             |
| >     | |   | > Identifica las  |   |                             |
| > 2\. | |   | > diferentes      |   |                             |
|       | |   | >                 |   |                             |
|       | |   | responsabilidades |   |                             |
|       | |   | > que existen en  |   |                             |
|       | |   | > este programa.  |   |                             |
|       | |   | > Haz una lista   |   |                             |
|       | |   | > con ellas.      |   |                             |
|       | |   | >                 |   |                             |
|       | |   | > Refactoriza la  |   |                             |
|       | |   | > aplicación para |   |                             |
|       | |   | > cumplir estos   |   |                             |
|       | |   | >                 |   |                             |
|       | |   |  ​**objetivos**​: |   |                             |
|       | +---+-------------------+   |                             |
|       |                             |                             |
|       | 1\.                         |                             |
|       |                             |                             |
|       | 2\.                         |                             |
+=======+=============================+=============================+
|       | > 1\.                       | > El origen de datos (ahora |
|       |                             | > ficheros) pueda ser       |
|       |                             | > distinto ​**y/o**​ el     |
|       |                             | > destino de los            |
+-------+-----------------------------+-----------------------------+
|       | > datos también.            |                             |
+-------+-----------------------------+-----------------------------+
|       | > 2\.                       | > La transformación que se  |
|       |                             | > hace de la entrada pueda  |
|       |                             | > ser otra representación   |
+-------+-----------------------------+-----------------------------+
|       | > basada en texto           |                             |
|       | > cualquiera (no a XML).    |                             |
+-------+-----------------------------+-----------------------------+

> Una vez refactorizada:

+-------+-----------------------------+-----------------------------+
| > 1\. | > Responde a estas          |                             |
|       | > cuestiones:               |                             |
+=======+=============================+=============================+
|       | > ○                         | > ¿​**Qué**​ principio o    |
|       |                             | > principios SOLID has      |
|       |                             | > empleado para cada uno de |
|       |                             | > los dos                   |
+-------+-----------------------------+-----------------------------+
|       | > objetivos anteriores,     |                             |
|       | > ​**cómo**​ los has        |                             |
|       | > empleado y ​**por qué**​? |                             |
+-------+-----------------------------+-----------------------------+

> **Single Responsibility**​. Identifico las clases según su
> responsabilidad: Podemos identificar una clase que ​**lee un
> archivo**​, otra que ​**transforma de TAB a XML**​ y otra que
> ​**escribe el texto a un archivo**​. Aparte de las clase encargada con
> la comunicación con el usuario (​**UI**​) y el ​**main.**
>
> **Open/Closed Principle**​. Observando las posibles modificaciones o
> cambios de la\
> funcionalidad del software nos damos cuenta que si cambia el requisito
> de lectura escritura o transformación, deberíamos modificar el código
> en cascada. Las clases están fuertemente ligadas a los requisitos
> iniciales. Por eso en un ejercicio de abstracción, creamos las
> interfaces ​***Reader, Writer y Transform***​. Estas se encargan de
> una responsabilidad mas abstracta, Leer (de donde sea como sea),
> Escribir (como y donde sea) y Transformar(El formato que sea a
> cualquier otro formato). Y las f[​uncionalidades concretas]{.ul}​
> (​*leer de* ​***archivo***​*, \...*​) serán clases que implementen ese
> interfaz. Por lo tanto al querer modificar estas
>
> funcionalidades bastaría con añadir una clase que implemente la nueva
> funcionalidad concreta, estando la aplicación ​**cerrada para la
> modificación y abierto para ser**\
> **extendido.**
>
> **Dependency Inversion.** ​Al crear estas interfaces, separando
> responsabilidades creamos una clase: TextTransformer, encargada de
> recibir un Reader, un Writer y un Transformer y llamas a su método
> transfrom para coordinar la lectura, transformación y escritura. Este
> método dependería en principio de las clases concretas (TabToXML,
> FileWriter, ..). Al hacerlo con interfaces se crea una inversión de
> dependencia, donde ​**TextTransformer depende de abstracciones**​,
> interfaces, no de módulos de bajo nivel. Haciendo las dependencias de
> alto nivel independientes y, por lo tanto portables.

+-------+-------------------------------------------------------------+
| > 2\. | > Elabora una tabla para documentar las responsabilidades   |
|       | > de las clases                                             |
+-------+-------------------------------------------------------------+

+-------------------+-------------------------------------------------+
| > Clase           | > Responsabilidad                               |
+===================+=================================================+
| > FileReader      | > Lee un archivo de disco y lee línea a línea.  |
|                   | > Implementa Reader                             |
+-------------------+-------------------------------------------------+
| > TABtoXML        | > Convierte formato TAB a XML. Implementa       |
|                   | > Transformer.                                  |
+-------------------+-------------------------------------------------+
| > FileWriter      | > Escribe linea a linea en un archivo en disco. |
|                   | > Implementa Writer                             |
+-------------------+-------------------------------------------------+
| > TextTransformer | > Encargada de aunar las 3 interfaces para la   |
|                   | > transformación                                |
+-------------------+-------------------------------------------------+
| > UI              | > Encargada de la interfaz de usuario (mostrar  |
|                   | > y obtener información)                        |
+-------------------+-------------------------------------------------+
| > ConverterApp    | > Main                                          |
+-------------------+-------------------------------------------------+

+-------+-------------------------------------------------------------+
| > 3\. |   -- -----------------------                                |
|       | ----------------------------------------------------------- |
|       |      Elabora una tabla par                                  |
|       | a documentar el principio OCP (Open Closed Principle) en tu |
|       |   -- -----------------------                                |
|       | ----------------------------------------------------------- |
|       |                                                             |
|       | 3\.                                                         |
+-------+-------------------------------------------------------------+

> código. Una clase que respeta el principio OCP, está cerrada para
> modificación pero abierta para extensión, siempre centrándonos en una
> modificación futura concreta. Por lo tanto, la tabla debe contener
> estas columnas.

+-------------------+--------------------------------+---------------+
| > Clase           | > Modificación posible         | > Punto de\   |
|                   |                                | > extensión   |
+===================+================================+===============+
| > TextTrasnformer | Ahora queremos leer no solo de | > Reader      |
|                   | ficheros en disco              |               |
+-------------------+--------------------------------+---------------+
| > TextTransformer | > Ahora queremos escribir los  | > Writer      |
|                   | > datos no solo de ficheros en |               |
|                   | > disco                        |               |
+-------------------+--------------------------------+---------------+
| > TextTransformer | > Ahora queremos transformar   | > Transformer |
|                   | > texto de distintas formas en |               |
|                   | > vez de solo de TAB a XML     |               |
+-------------------+--------------------------------+---------------+

+-------+-------------------------------------------------------------+
| > 4\. | +---+---------------------------------------------------+   |
|       | |   | > Modifica la aplicación para que la salida se    |   |
|       | |   | > produzca por pantalla y no a fichero. ¿Tuviste  |   |
|       | |   | > que cambiar código existente a mayores que el   |   |
|       | |   | > método ​*main*​? Describe brevemente la         |   |
|       | |   | > modificación.                                   |   |
|       | +---+---------------------------------------------------+   |
|       |                                                             |
|       | 4\.                                                         |
+-------+-------------------------------------------------------------+

> No, solamente añadimos la clase ConsoleWriter que implementa la
> interfaz Writer. Cambiamos el main para que cree el objeto Writer en
> modo consola en vez de fichero y listo.
