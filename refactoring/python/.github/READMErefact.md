### Ejercicio 1: Migraciones de código desde un markdown

**Objetivo**: Migrar el código de un archivo markdown a un proyecto Python.
Mediante el uso de copilot instructions para añadir contexto extra y aproximar el diseño a nuestra arquitectura.
Usaremos github copilot para ayudarnos a completar el código.

**Instrucciones**:
1. Crea un nuevo proyecto Python en tu IDE favorito.
2. A través del README.md pide a copilot que genere el scaffolding del proyecto. Usa copilot-instructions.md para añadir contexto extra. y así poderlo adaptar a tu arquitectura.
3. Compila el código generado por copilot y asegúrate de que no hay errores. python app

### Ejercicio 1: Refactorización de Métodos

**Objetivo**: Refactorizar métodos largos en métodos más pequeños y manejables.

**Instrucciones**:
1. Refactoriza el método `getAllEmployees` para que use un método privado que maneje la lógica de obtención de empleados.
2. Refactoriza el método `saveEmployee` para que use un método privado que maneje la lógica de guardado.

### Ejercicio 2: Control de Errores

**Objetivo**: Añadir control de errores a los métodos del servicio.

**Instrucciones**:
1. Añade control de errores al método `getEmployeeById` para manejar el caso en que el empleado no exista.
2. Añade control de errores al método `deleteEmployee` para manejar el caso en que el empleado no exista.

### Ejercicio 3: Extracción de Funciones

**Objetivo**: Extraer lógica repetitiva en métodos reutilizables.

**Instrucciones**:
1. Extrae la lógica de búsqueda de empleados por correo electrónico en un método privado reutilizable.
2. Extrae la lógica de ordenación de empleados por apellido en un método privado reutilizable.


### Ejercicio 4: Añadir Nuevas Funcionalidades

**Objetivo**: Añadir nuevos métodos al repositorio y usarlos en el servicio.

**Instrucciones**:
1. Añade un método en el repositorio para buscar empleados por nombrey un método para ordenar por apellido.
2. Usa este método en el servicio para implementar una nueva funcionalidad.


### Ejercicio 5: Documentación

**Objetivo**: Añadir documentación a los métodos del servicio.

**Instrucciones**:
1. Añade comentarios a todos los métodos públicos.
