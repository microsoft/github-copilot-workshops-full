class EmployeeController:
    def __init__(self, employee_model):
        self.employee_model = employee_model

    def list_employees(self):
        return self.employee_model.get_all_employees()

    def add_employee(self, employee_data):
        return self.employee_model.create_employee(employee_data)

    def delete_employee(self, employee_id):
        return self.employee_model.remove_employee(employee_id)

    def update_employee(self, employee_id, employee_data):
        return self.employee_model.modify_employee(employee_id, employee_data)