from flask import Flask
from routes.employee_routes import employee_routes

def create_app():
    app = Flask(__name__)
    
    app.register_blueprint(employee_routes)
    
    return app

if __name__ == "__main__":
    app = create_app()
    app.run(debug=True)