package ecoponto;

import java.util.ArrayList;
import java.util.List;

public class Ecoponto {
	private String name;					// Ecoponto name.
	private String location;				// Ecoponto location.
	private Owner owner;					// Ecoponto owner.
	private List<TrashType> trashTypes;		// Array com os tipos de lixo que o negócio aceita.
	
	// constructor.
	public Ecoponto(String name, String location, Owner owner) {
        this.name = name;
        this.location = location;
        this.owner = owner;
        this.trashTypes = new ArrayList<>();
    }
	
	// adiciona tipo de lixo.
	public void addTrashType(TrashType type) {
		trashTypes.add(type);
	}
	
	// remove tipo de lixo.
	public void removeTrashType(TrashType type) {
		trashTypes.remove(type);
	}

	// getters.
	public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Owner getOwner() {
        return owner;
    }

    public List<TrashType> getTrashTypes() {
        return trashTypes;
    }
    
 // setters.
 	public void setName(String name) {
         this.name = name;
     }

     public void setLocation(String location) {
         this.location = location;
     }

     public void setOwner(Owner owner) {
         this.owner = owner;
     }

     public void setTrashTypes(List<TrashType> trashTypes) {
         this.trashTypes = trashTypes;
     }
}
