from flask import Blueprint, request, jsonify
from controllers.employee_controller import EmployeeController
from models.employee import Employee

employee_routes = Blueprint('employee_routes', __name__)
employee_model = Employee  # Assuming Employee model has necessary methods
controller = EmployeeController(employee_model)

@employee_routes.route('/employees', methods=['GET'])
def list_employees():
    employees = controller.list_employees()
    return jsonify(employees), 200

@employee_routes.route('/employees', methods=['POST'])
def add_employee():
    data = request.json
    employee = controller.add_employee(data)
    return jsonify(employee), 201

@employee_routes.route('/employees/<int:employee_id>', methods=['DELETE'])
def delete_employee(employee_id):
    controller.delete_employee(employee_id)
    return '', 204

@employee_routes.route('/employees/<int:employee_id>', methods=['PUT'])
def update_employee(employee_id):
    data = request.json
    employee = controller.update_employee(employee_id, data)
    return jsonify(employee), 200