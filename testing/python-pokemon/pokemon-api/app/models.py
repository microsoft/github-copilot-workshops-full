class Pokemon:
    def __init__(self, id: int, name: str, type: str):
        self.id = id
        self.name = name
        self.type = type

    def to_dict(self):
        return {"id": self.id, "name": self.name, "type": self.type}