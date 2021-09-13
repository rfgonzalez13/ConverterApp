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
