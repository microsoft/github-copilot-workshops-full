# Pokémon API

This project is a RESTful API for managing Pokémon data using FastAPI. It allows users to perform CRUD operations on Pokémon, including their names and types.

## Project Structure

```
pokemon-api
├── app
│   ├── __init__.py        # Marks the directory as a Python package
│   ├── app.py             # Main entry point for the FastAPI application
│   ├── models.py          # Defines data models for Pokémon
│   ├── routes.py          # Defines API routes for CRUD operations
│   ├── test_routing.py    # Contains tests for API routes
│   ├── __pycache__/       # Compiled Python files
│   └── requirements.txt   # Lists project dependencies
```

## Setup

1. Clone the repository:
   ```
   git clone <repository-url>
   cd pokemon-api
   ```

2. Install the required dependencies:
   ```
   pip install -r app/requirements.txt
   ```

3. Run the application:
   ```
   uvicorn app.app:app --reload
   ```

## Usage

Once the application is running, you can access the API at `http://127.0.0.1:8000`. You can use tools like Postman or curl to interact with the API.

## Testing

Run the tests to ensure everything is working correctly:
```bash
pytest app/test_routing.py
```

## License

This project is licensed under the MIT License.