class Employee:
    """Clase que representa el modelo de datos de un empleado."""
    
    def __init__(self, id, name, position, department):
        """Inicializa un nuevo empleado con los atributos proporcionados.
        
        Args:
            id (int): Identificador único del empleado.
            name (str): Nombre del empleado.
            position (str): Puesto del empleado.
            department (str): Departamento del empleado.
        """
        self.id = id  # Identificador único del empleado
        self.name = name  # Nombre del empleado
        self.position = position  # Puesto del empleado
        self.department = department  # Departamento del empleado

    def to_dict(self):
        """Convierte el objeto Employee a un diccionario.
        
        Returns:
            dict: Representación del empleado como diccionario.
        """
        return {
            'id': self.id,
            'name': self.name,
            'position': self.position,
            'department': self.department
        }