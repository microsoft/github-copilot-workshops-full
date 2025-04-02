### Ejercicio 1: Migraciones de código desde un markdown

**Objetivo**: Migrar el código de un archivo markdown a un proyecto Java.
Mediante el uso de copilot instructions para añadir contexto extra y aproximar el diseño a nuestra arquitectura.
Usaremos github copilot para ayudarnos a completar el código.
**Instrucciones**:
1. Crea un nuevo proyecto Java en tu IDE favorito.
2. A través del READMEFUNC.md pide a copilot que genere el scaffolding del proyecto.
3. Compila el código generado por copilot y asegúrate de que no hay errores. ./mvnw spring-boot:run

### Ejercicio 1: Refactorización de Métodos

**Objetivo**: Refactorizar métodos largos en métodos más pequeños y manejables.

**Instrucciones**:
1. Refactoriza el método `getAllEmployees` para que use un método privado que maneje la lógica de obtención de empleados.
2. Refactoriza el método `saveEmployee` para que use un método privado que maneje la lógica de guardado.

**Código Modificado**:
```java
public List<Employee> getAllEmployees() {
    return fetchAllEmployees();
}

private List<Employee> fetchAllEmployees() {
    return employeeRepository.findAll();
}

public Employee saveEmployee(Employee employee) {
    return persistEmployee(employee);
}

private Employee persistEmployee(Employee employee) {
    return employeeRepository.save(employee);
}
```

### Ejercicio 2: Control de Errores

**Objetivo**: Añadir control de errores a los métodos del servicio.

**Instrucciones**:
1. Añade control de errores al método `getEmployeeById` para manejar el caso en que el empleado no exista.
2. Añade control de errores al método `deleteEmployee` para manejar el caso en que el empleado no exista.

**Código Modificado**:
```java
public Employee getEmployeeById(Long id) {
    return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
}

public void deleteEmployee(Long id) {
    if (!employeeRepository.existsById(id)) {
        throw new EmployeeNotFoundException("Employee not found with id: " + id);
    }
    employeeRepository.deleteById(id);
}
```

### Ejercicio 3: Extracción de Funciones

**Objetivo**: Extraer lógica repetitiva en métodos reutilizables.

**Instrucciones**:
1. Extrae la lógica de búsqueda de empleados por correo electrónico en un método privado reutilizable.
2. Extrae la lógica de ordenación de empleados por apellido en un método privado reutilizable.

**Código Modificado**:
```java
public Employee findEmployeeByEmail(String email) {
    return fetchEmployeeByEmail(email);
}

private Employee fetchEmployeeByEmail(String email) {
    return employeeRepository.findByEmail(email).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with email: " + email));
}

public List<Employee> getEmployeesOrderedBySurname() {
    return fetchEmployeesOrderedBySurname();
}

private List<Employee> fetchEmployeesOrderedBySurname() {
    return employeeRepository.findAllByOrderBySurname();
}
```

### Ejercicio 4: Añadir Nuevas Funcionalidades

**Objetivo**: Añadir nuevos métodos al repositorio y usarlos en el servicio.

**Instrucciones**:
1. Añade un método en el repositorio para buscar empleados por nombre.
2. Usa este método en el servicio para implementar una nueva funcionalidad.

**Código Modificado**:

**EmployeeRepository.java**:
```java
List<Employee> findByName(String name);
```

**EmployeeService.java**:
```java
public List<Employee> getEmployeesByName(String name) {
    return employeeRepository.findByName(name);
}
```

### Ejercicio 5: Documentación

**Objetivo**: Añadir documentación a los métodos del servicio.

**Instrucciones**:
1. Añade comentarios Javadoc a todos los métodos públicos del servicio.

**Código Modificado**:
```java
/**
 * Retrieves all employees.
 * 
 * @return a list of all employees.
 */
public List<Employee> getAllEmployees() {
    return fetchAllEmployees();
}

/**
 * Retrieves an employee by their ID.
 * 
 * @param id the ID of the employee.
 * @return the employee with the given ID.
 * @throws EmployeeNotFoundException if the employee is not found.
 */
public Employee getEmployeeById(Long id) {
    return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
}

// Add similar Javadoc comments for other methods...
```