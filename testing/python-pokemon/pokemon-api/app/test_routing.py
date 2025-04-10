import pytest
from fastapi.testclient import TestClient
from app.app import app

client = TestClient(app)

def test_read_root():
    response = client.get("/")
    assert response.status_code == 200
    assert response.json() == {"message": "Welcome to the Pokémon API!"}

def test_get_all_pokemon():
    response = client.get("/pokemon")
    assert response.status_code == 200
    assert isinstance(response.json(), list)
    assert len(response.json()) > 0

def test_get_pokemon_by_id():
    response = client.get("/pokemon/1")
    assert response.status_code == 200
    assert response.json()["name"] == "Pikachu"

def test_get_pokemon_by_id_not_found():
    response = client.get("/pokemon/999")
    assert response.status_code == 404
    assert response.json()["detail"] == "Pokemon not found"
