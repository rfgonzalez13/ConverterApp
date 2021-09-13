![SOLID](https://miro.medium.com/max/724/1*aouy-7W59qqur-y4-vk9Gw.png)

## La aplicación

Sea una palicacion que hace lo siguiente.  
1. Pide dos nombre de ficheros al usuario: uno de entrada y otro de salida.
2. Transforma el fichero de entrada a un XML escribiéndolo en el fichero de salida.

## Tareas
1. Identifica las diferentes responsabilidades que existen en este programa. Haz una lista con ellas.
2. Refactoriza la aplicación para cumplir estos **objetivos**:
  * El origen de datos (ahora ficheros) pueda ser distinto **y/o** destino de los datos también.
  * La transformacion que se hace de la entrada pueda ser otra representación basada en texto cualquiera (no a XML).

### Principios SOLID aplicados

**_Single Responsability_**. Identificar clases según responsabilidad.  
**Tres** clases(funcionalidades) principales, **leer un archivo**, **transformar de TAB a XML** y otra que **vuelca el resultado a un archivo**.

**_Open/Closed Principle_**.En un ejerciciode abstracción creamos las interfaces **Redaer**, **Writter**, y **Transform**. Estas se encargan de una responsabilidad mas abstracta, **Leer**(de donde sea como sea), **Escribir**(como y donde sea) y **Transformar**(desde cualquier faormato a otro). Por lo tanto al querer modificar la aplicación añadiendo nuevass funcionalidades bastaría con añadir una clase que implemente su interfaz correspondiente, consiguiendo que el **código esté cerrado para la modificación y abierto para ser extendido**. 

**_Dependecy Inversion_**. Creando las interfaces, separando responsabilidades creamos una clase: **TextTransformer**, encargada de recibir un Reader, un Writer y un Transformer. Con el método transform para coordinar la lectura, transformación y escritura. Este método sin interfaces en principio dependería de las clases contretas (TabToXML, FileWriter,...). Al hacerlo con interfaces logramos una inversión de dependencias donde **TextTransformer depende de abstarcciones**, interfaces, no de módulos de bajo nivel. Haciendo las dependencias de alto nivel independientes y, por lo tanto **portables**.

#### Responsabilidades
Clase | Responsabilidad
----- | --------------
FileReader | Lee un archivo de disco y lee línea a línea. Implementa Reader.
TABtoXML | Convierte formato TAB a XML. Implenta Transformer.
FileWriter | Escreba línea a línea en un archivo en disco. Implementa Writer.
TextTransformer | Encargada de aunar las 3 interfaces para la transformación.
UI | Encargada de la interfaz de usuario (mostrar y obternet información).
ConverterApp | Main.

#### Principio OCP (Open Closed Principle)
Clase | Modificación posible | Punto de extensión
----- | -------------------- | ------------------
TextTransformer | Ahora queremos leer no solo de ficheros en disco. | Reader
TextTransformer | Ahora queremos escribir los datos no solo en ficheros en disco. | Writer
TextaTransformer | Ahora queremos transformar texto de sistintas formas en vez de solo de TAB a XML. | Transformer
