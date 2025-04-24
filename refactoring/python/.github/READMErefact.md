### Ejercicio 1: Migraciones de código desde un markdown

**Objetivo**: Migrar el código de un archivo markdown a un proyecto Python.
Mediante el uso de copilot instructions para añadir contexto extra y aproximar el diseño a nuestra arquitectura.
Usaremos github copilot para ayudarnos a completar el código.



**Instrucciones**:
1. Crea un nuevo proyecto Python en tu IDE favorito.
2. A través del README.md pide a copilot que genere el scaffolding del proyecto. Usa copilot-instructions.md para añadir contexto extra. y así poderlo adaptar a tu arquitectura.
3. Compila el código generado por copilot y asegúrate de que no hay errores. python app

```
[Chat Edits] Añadir como contexto README.md-> @workspace /new Crea un schafolding a partir de este readme
```

Debería generar un schafolding como: 
```
employee-management
├── app
│   ├── __init__.py
│   ├── controllers
│   │   └── employee_controller.py
│   ├── models
│   │   └── employee.py
│   ├── routes
│   │   └── employee_routes.py
│   └── app.py
├── requirements.txt
└── README.md
```
 Con el chat, ejecutar la app e ir solventando errores y pasando trazas:
 ```
  pip install -r requirements.txt
```

   ```
   python app/app.py
   ```

### Ejercicio 1: Refactorización de Métodos

**Objetivo**: Refactorizar métodos largos en métodos más pequeños y manejables.

**Instrucciones**:
1. Refactoriza el método `getAllEmployees` para que use un método privado que maneje la lógica de obtención de empleados.
2. Refactoriza el método `saveEmployee` para que use un método privado que maneje la lógica de guardado.

```
[Chat Edits] -> Crea un nuevo metodo que obtenga todos los empleados a partir de otro método privado
```
```
[Chat Edits] -> Crea un nuevo metodo que guarde todos los empleados a partir de otro método privado
```

### Ejercicio 2: Control de Errores

**Objetivo**: Añadir control de errores a los métodos del servicio.

**Instrucciones**:
1. Añade control de errores al método `getEmployeeById` para manejar el caso en que el empleado no exista.
2. Añade control de errores al método `deleteEmployee` para manejar el caso en que el empleado no exista.

```
[Chat Edits] -> Crea metodo getEmployeeById para obtener el empleado por ID y además añade un control de errores para el caso de que un empleado no exista. Puede ser un try-catch.
```

```
[Chat Edits] -> Crea metodo deleteEmployee para eliminar el empleado por ID y además añade un control de errores para el caso de que un empleado no exista. Puede ser un try-catch.
```
### Ejercicio 3: Extracción de Funciones

**Objetivo**: Extraer lógica repetitiva en métodos reutilizables.

**Instrucciones**:
1. Extrae la lógica de búsqueda de empleados por correo electrónico en un método privado reutilizable.
2. Extrae la lógica de ordenación de empleados por apellido en un método privado reutilizable.

```
[Chat Edits] -> Haz una función de busquéda de empleados por correo electronico y extraelo en un metodo privado reutilizable.
```
```
[Chat Edits] -> Haz una función de ordenación de empleados por apellido y extraelo en un metodo privado reutilizable.
```

### Ejercicio 4: Añadir Nuevas Funcionalidades

**Objetivo**: Añadir nuevos métodos al repositorio y usarlos en el servicio.

**Instrucciones**:
1. Añade un método en el repositorio para buscar empleados por nombre y un método para ordenar por apellido.
2. Usa este método en el servicio para implementar una nueva funcionalidad.

```
[Chat Edits] -> Haz una función de busquéda de empleadospor nombre electronico.
```

```
[Chat Edits] -> Añade esa funcionalidad como ruta en employee_routes.py
```

### Ejercicio 5: Documentación

**Objetivo**: Añadir documentación a los métodos del servicio.

```
[Chat Edits] Seleccionar employee_controller.py -> Añade documentación técnica sobre los métodos del servicio y guardalo en un .md
```

**Instrucciones**:
1. Añade comentarios a todos los métodos públicos.

```
[Copilot Intructions] -> Añade comentarios a todos los métodos del servicio cuando se creen
```


```
[Chat Edits] -> Añade comentarios a todos los métodos
```
