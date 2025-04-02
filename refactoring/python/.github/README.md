# Employee Management System

This project is an Employee Management System built using Python and Flask. It provides a simple API to manage employee records, allowing for operations such as listing, adding, deleting, and updating employee information.

## Project Structure

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

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   cd employee-management
   ```

2. **Create a virtual environment:**
   ```
   python -m venv venv
   source venv/bin/activate  # On Windows use `venv\Scripts\activate`
   ```

3. **Install the required packages:**
   ```
   pip install -r requirements.txt
   ```

4. **Run the application:**
   ```
   python app/app.py
   ```

## API Endpoints

- `GET /employees` - List all employees
- `POST /employees` - Add a new employee
- `DELETE /employees/<id>` - Delete an employee by ID
- `PUT /employees/<id>` - Update an employee by ID

## Usage Examples

### List Employees
```
GET /employees
```

### Add Employee
```
POST /employees
{
    "name": "John Doe",
    "position": "Software Engineer",
    "department": "Engineering"
}
```

### Delete Employee
```
DELETE /employees/1
```

### Update Employee
```
PUT /employees/1
{
    "name": "John Smith",
    "position": "Senior Software Engineer",
    "department": "Engineering"
}
```

## License

This project is licensed under the MIT License.