from fastapi import APIRouter, HTTPException
from .models import Pokemon

router = APIRouter()

pokemon_db = [
    Pokemon(id=1, name="Pikachu", type="Electric"),
    Pokemon(id=2, name="Charmander", type="Fire"),
    Pokemon(id=3, name="Bulbasaur", type="Grass")
]

@router.get("/")
def read_root():
    """Root endpoint."""
    return {"message": "Welcome to the Pokémon API!"}

@router.get("/pokemon")
def get_pokemon():
    """Retrieve all Pokémon."""
    return [pokemon.to_dict() for pokemon in pokemon_db]

@router.get("/pokemon/{pokemon_id}")
def get_pokemon_by_id(pokemon_id: int):
    """Retrieve a Pokémon by its ID."""
    for pokemon in pokemon_db:
        if pokemon.id == pokemon_id:
            return pokemon.to_dict()
    raise HTTPException(status_code=404, detail="Pokemon not found")