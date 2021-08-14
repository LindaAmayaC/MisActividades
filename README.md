# MisActividades

Se crea una aplicación para llevar el control las tareas o actividades que tengamos pendientes por hacer, donde podremos añadir, editar, eliminar
y marcar como realizada las tareas o actividades propuestas.

# Especificaciones.
Se debe desarrollar una lista To-Do, la cual es una serie de ítems, organizados, que corresponden a las tareas pendientes del usuario.
Esta lista To-Do, debe tener las siguientes características:

- Permitir al usuario ver una lista con las actividades pendientes. 
- Permitir al usuario agregar una nueva actividad a la lista. 
- Permitir al usuario marcar una actividad como realizada. 
- Permitir al usuario eliminar una actividad de la lista. 
- Permitir editar la descripción de una actividad. 
- Permitir filtrar lista de actividades por texto de descripción. 
- Permitir al usuario llenar la lista de actividades con frases aleatorias de gatos, indicando cuantas quiere agregar.

Nota: Para traer las frases aleatorias de gatos, debes hacer uso de la siguiente API: https://catfact.ninja/docs

#Funcionalidades realizadas
- Carga y visualizacioón de las tareas pendientes del usuario: para la realizacion de este requerimiento se visualiza el listado de tareas pendientes del usuario en la pantalla pricipal de la aplicacion, estas tareas se encuentran almacenadas en una base de datos de documentos llamada Firestore, servicio proveeido por Firebase, así que la informacion de tareas pendientes del usuariio se encuentra almacenada en la nube y la aplicacón la descarga y la visualiza.
- Visualización del detalle de una tarea pendiente: cuando el usuario selecciona una de las tareas visualizadas por medio del listado de tareas haciendo la accion de tap sobre ellas se visualiza en una nueva pantalla la vista detallada de la tarea seleccionada.
- Borrado de una tarea pendiente: En la pantalla que muestra una tarea detallada pendiente del usuario se añadio un boton flotante el cual si se pulsa elimina la tarea pendiente del usuario que se esta visuyalizando en ese momento, esta eliminacion se hace en Firestore que donde se almacena y luego se retorna a la vista del listado de tareas pendiente donde ya no se visualiza la tarea ya que se vuelve a actualizar la lista de tareas. 


