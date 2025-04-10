# Construcción de la API de Pokémon desde cero

Este documento describe los pasos realizados para construir la API de Pokémon desde cero, junto con los comandos necesarios para ejecutarla y configurarla correctamente.

## Pasos para construir la aplicación

1. **Crear el entorno de trabajo**:
   - Crear un directorio para la aplicación.
   - Inicializar un entorno virtual de Python:
     ```bash
     python -m venv venv
     ```
   - Activar el entorno virtual:
     - En Windows:
       ```bash
       venv\Scripts\activate
       ```
     - En macOS/Linux:
       ```bash
       source venv/bin/activate
       ```

   - Alternativamente, puedes usar Conda para crear y gestionar el entorno:
     - Crear un nuevo entorno con Conda:
       ```bash
       conda create --name pokemon-api python=3.8
       ```
     - Activar el entorno:
       ```bash
       conda activate pokemon-api
       ```
3. **Estructurar la aplicación**:
   - Crear la estructura de directorios y archivos:
     ```
     pokemon-api/
     ├── app/
     │   ├── __init__.py
     │   ├── app.py
     │   ├── models.py
     │   ├── routes.py
     │   └── test_routing.py
     ├── requirements.txt
     └── README.md
     ```

     ```
     [Chat Edits] Crea una aplicacion de Pokemon que tenga unos nombres de Pokemon y su tipo. Quiero que sea una API REST ("pokemon-api") en Python usando la libreria FastApi, y que tenga un backend ("app") con operaciones CRUD. En la carpeta llamada "app" quiero tener un fichero app.py, models.py, requirements.txt, routes.py y un init_.py. Crea los ficheros vacios en cuanto a funcionalidades.
     ```

3. **Instalar dependencias**:
   - Crear un archivo `requirements.txt` con las dependencias necesarias, en este caso:
     ```
     fastapi
     uvicorn
     pytest
     ```
   - Instalar las dependencias. Situarse dentro de la carpeta donde este el archivo:
     ```bash
     pip install -r requirements.txt
     ```


4. **Desarrollar la aplicación**:
   - Implementar la lógica principal en `app.py`.
    ```
     [Chat Edits] En app.py haz que se ejcute la app de forma correcta
     ```
   - Definir la clase Pokemon en `models.py`.

     ```
     [Chat Edits] Añade la clase de pokemon en models.py, con atributos de id, nombre de pokemon y su tipo
     ```

   - Configurar las rutas en `routes.py`.

    ```
     [Chat Edits] Añade las rutas a routes.py, con funcionalidades como GET lista de todos los pokemon, GET pokemon por id, POST pokemon, DELETE pokemon por id...
      ```
   
   - Escribir pruebas unitarias en `test_routing.py`.
   
    ```
     [Chat Edits] Añade un nuevo archivo que sea test_routing.py para testear las rutas con pytest
      ```

5. **Ejecutar la aplicación**:
   - Iniciar el servidor FastAPI con Uvicorn. Situarse en `/pokemon-api`:
     ```bash
     uvicorn app.app:app --reload
     ```
   - La aplicación estará disponible en `http://127.0.0.1:8000/` por defecto.

6. **Probar las rutas**:
   - Prueba las rutas con `curl`:
     ```bash
     curl -X GET http://127.0.0.1:8000/pokemon
     ```

      ```bash
     curl -X GET http://127.0.0.1:8000/pokemon/1
     ```

7. **Testear las rutas**:
   - Ejecutar las pruebas unitarias con `pytest`:
     ```bash
     pytest app/test_routing.py
     ```

8. **Crear documentacion**:

 ```
     [Chat Edits] Crea un readme.md que contenga informacion técnica de la aplicacion, una descripcion de las rutas y los test, del modelo, etc...
```
9. **Custom Instructions**:

- Alternativamente se puede usar custom_instructions.md para crear cierto contetso para Copilot a la hora de pedirle acciones. Prueba a escribir que estructura quieres que tengan tus tests o cómo quieres que te comente las funcionalidades. Añade ejemplos si es necesario.

