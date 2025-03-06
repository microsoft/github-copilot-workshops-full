class Employee:
    employees = []

    def __init__(self, id, name, position, department):
        self.id = id
        self.name = name
        self.position = position
        self.department = department

    def to_dict(self):
        return {
            'id': self.id,
            'name': self.name,
            'position': self.position,
            'department': self.department
        }

    @classmethod
    def get_all_employees(cls):
        return [employee.to_dict() for employee in cls.employees]

    @classmethod
    def create_employee(cls, employee_data):
        employee = Employee(**employee_data)
        cls.employees.append(employee)
        return employee.to_dict()

    @classmethod
    def remove_employee(cls, employee_id):
        cls.employees = [employee for employee in cls.employees if employee.id != employee_id]

    @classmethod
    def modify_employee(cls, employee_id, employee_data):
        for employee in cls.employees:
            if employee.id == employee_id:
                employee.name = employee_data.get('name', employee.name)
                employee.position = employee_data.get('position', employee.position)
                employee.department = employee_data.get('department', employee.department)
                return employee.to_dict()
        return None