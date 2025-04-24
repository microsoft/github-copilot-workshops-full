# Documentación Técnica de la Aplicación de Gestión de Empleados

## Modelo de Datos: `Employee`
El modelo `Employee` representa un empleado en el sistema. Contiene los siguientes atributos:

- **id (int):** Identificador único del empleado.
- **name (str):** Nombre completo del empleado.
- **position (str):** Puesto o cargo del empleado.
- **department (str):** Departamento al que pertenece el empleado.

### Métodos del Modelo
- **`__init__(self, id, name, position, department):`**  
  Constructor que inicializa un empleado con los atributos proporcionados.

- **`to_dict(self):`**  
  Convierte el objeto `Employee` a un diccionario para facilitar su manipulación y serialización.

---

## Controlador: `EmployeeController`
El controlador gestiona las operaciones relacionadas con los empleados. Utiliza un almacenamiento en memoria para los datos.

### Métodos Públicos
- **`add_employee(self, employee_data):`**  
  Agrega un nuevo empleado al sistema.  
  **Args:**  
  - `employee_data (dict):` Datos del empleado a agregar.  
  **Returns:**  
  - `dict:` El empleado recién agregado.

- **`list_employees(self):`**  
  Devuelve una lista de todos los empleados registrados.  
  **Returns:**  
  - `list:` Lista de empleados.

- **`update_employee(self, employee_id, employee_data):`**  
  Actualiza los datos de un empleado existente.  
  **Args:**  
  - `employee_id (int):` ID del empleado a actualizar.  
  - `employee_data (dict):` Nuevos datos del empleado.  
  **Returns:**  
  - `dict:` Empleado actualizado.  
  **Raises:**  
  - `ValueError:` Si no se encuentra el empleado.

- **`delete_employee(self, employee_id):`**  
  Elimina un empleado por su ID.  
  **Args:**  
  - `employee_id (int):` ID del empleado a eliminar.  
  **Returns:**  
  - `dict:` Mensaje de confirmación.  
  **Raises:**  
  - `ValueError:` Si no se encuentra el empleado.

- **`getEmployeeById(self, employee_id):`**  
  Recupera un empleado por su ID.  
  **Args:**  
  - `employee_id (int):` ID del empleado.  
  **Returns:**  
  - `dict:` Datos del empleado o un mensaje de error.

- **`getEmployeeByEmail(self, email):`**  
  Recupera un empleado por su correo electrónico.  
  **Args:**  
  - `email (str):` Correo electrónico del empleado.  
  **Returns:**  
  - `dict:` Datos del empleado o un mensaje de error.

- **`getSortedEmployeesByLastName(self):`**  
  Devuelve una lista de empleados ordenados por su apellido.  
  **Returns:**  
  - `list:` Lista de empleados ordenados.

### Métodos Privados
- **`_get_all_employees(self):`**  
  Método privado para obtener todos los empleados.

- **`_save_employee(self, employee):`**  
  Método privado para guardar un empleado en la lista.

- **`_find_employee_by_email(self, email):`**  
  Método privado para buscar un empleado por correo electrónico.

- **`_sort_employees_by_last_name(self, employees):`**  
  Método privado para ordenar empleados por apellido.

---

## Rutas: `employee_routes`
Las rutas definen los puntos de acceso para interactuar con los datos de empleados.

### Rutas Disponibles
- **`GET /employees:`**  
  Devuelve una lista de todos los empleados.  
  **Response:**  
  - `200 OK:` Lista de empleados.

- **`POST /employees:`**  
  Agrega un nuevo empleado al sistema.  
  **Request Body:**  
  - `dict:` Datos del empleado.  
  **Response:**  
  - `201 Created:` Empleado agregado.

- **`DELETE /employees/<int:id>:`**  
  Elimina un empleado por su ID.  
  **Response:**  
  - `204 No Content:` Confirmación de eliminación.

- **`PUT /employees/<int:id>:`**  
  Actualiza los datos de un empleado por su ID.  
  **Request Body:**  
  - `dict:` Nuevos datos del empleado.  
  **Response:**  
  - `200 OK:` Empleado actualizado.

- **`GET /employees/sorted-by-last-name:`**  
  Devuelve una lista de empleados ordenados por apellido.  
  **Response:**  
  - `200 OK:` Lista de empleados ordenados.

---

## Aplicación Principal: `app.py`
El archivo principal de la aplicación configura y ejecuta el servidor Flask.

### Métodos
- **`create_app():`**  
  Crea y configura una instancia de la aplicación Flask.  
  **Returns:**  
  - `Flask:` Instancia de la aplicación.

- **`if __name__ == "__main__":`**  
  Ejecuta la aplicación en modo de depuración en el puerto 5200.