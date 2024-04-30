package ecoponto;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Ecoponto> ecopontos = new ArrayList<>();
    
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
        	System.out.println("Select an option:\n1. Create an Ecoponto\n2. Edit an Ecoponto\n3. List Ecopontos\n4. List by trash type\n5. Exit;");
        	
        	int opt = scanner.nextInt();

            switch (opt) {
                case 1:
                    createEcoponto(scanner);
                    break;
                case 2:
                    editEcoponto(scanner);
                    break;
                case 3:
                	listEcopontos();
                	break;
                case 4:
                	listByTrashType(scanner);
                	break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
	
	private static void createEcoponto(Scanner scanner) {
		scanner.nextLine(); 	// limpa o buffer do input. 
	    
        System.out.println("Ecoponto name:");
        String name = scanner.nextLine();

        System.out.println("Ecoponto location:");
        String location = scanner.nextLine();

        System.out.println("Ecoponto Owner:");
        String nameOwner = scanner.nextLine();

        System.out.println("Ecoponto Owner CPF:");
        String cpfOwner = scanner.nextLine();
        
        // cria owner e ecoponto.
        Owner owner = new Owner(nameOwner, cpfOwner);
        Ecoponto ecoponto = new Ecoponto(name, location, owner);
        
        // adiciona os tipos de lixo
        // isso é uma função separada pra poder reutilizar na função de editar.
        addTrashType(ecoponto, scanner);
        
        // adiciona ao array com os ecopontos.
        ecopontos.add(ecoponto);
        
        System.out.println("Ecoponto " + name + " created.");
	}
	
	private static void editEcoponto(Scanner scanner) {
	    if (ecopontos.isEmpty()) { 
	    	System.out.println("Create and Ecoponto first.");
	    	System.out.println();
	    	return; 
	    }
	    
		System.out.println("Which Ecoponto do yoy want to edit?");
	    // printa os nomes dos ecopontos.
	    for(int i=0; i<ecopontos.size();i++) {
			Ecoponto ecoponto = ecopontos.get(i);
		    System.out.println(i+1 + ". " + ecoponto.getName());
	    }
	    
	    int opt = scanner.nextInt();
	    
	    Ecoponto ecoponto = ecopontos.get(opt-1);
	    
	    scanner.nextLine(); 	// limpa o buffer do input. 
	    
        System.out.println("Ecoponto name:");
        String name = scanner.nextLine();

        System.out.println("Ecoponto location:");
        String location = scanner.nextLine();

        System.out.println("Ecoponto Owner:");
        String nameOwner = scanner.nextLine();

        System.out.println("Ecoponto Owner CPF:");
        String cpfOwner = scanner.nextLine();
        
        ecoponto.setName(name);
        ecoponto.setLocation(location);
        ecoponto.getOwner().setName(nameOwner);
        ecoponto.getOwner().setCpf(cpfOwner);
        
        // limpa o array do trash types antes de editar pra não ficar restos.
        List<TrashType> newTrashType = new ArrayList<>();
        ecoponto.setTrashTypes(newTrashType);
        
        addTrashType(ecoponto, scanner);
        
        System.out.println("Ecoponto " + name + " edited.");
	}
	
	private static void listEcopontos() {
		for(int i=0; i<ecopontos.size();i++) {
			Ecoponto ecoponto = ecopontos.get(i);
		    System.out.println(String.format("Ecoponto %d:\nname: %s\nlocation: %s\nowner: %s\nowner cpf: %s\n", 
		            i + 1, ecoponto.getName(), ecoponto.getLocation(), 
		            ecoponto.getOwner().getName(), ecoponto.getOwner().getCpf()));
		    // printa os trash types também.
		    List<TrashType> trashTypes = ecoponto.getTrashTypes();
		    System.out.println("Trash Types:");
		    for (int j = 0; j < trashTypes.size(); j++) {
		        System.out.println(trashTypes.get(j).getName());
		    }
		    System.out.println();
		}
	}
	
	private static void listByTrashType(Scanner scanner) {
	    // lista os lixos
	    System.out.println("Choose the trash type you want to filter:");
	    String[] types = {"Plástico", "Metal", "Vidro", "Papel", "Papelão"};
	    for (int i = 0; i < types.length; i++) {
	        System.out.println((i + 1) + ". " + types[i]);
	    }
	    
	    int opt = scanner.nextInt();
	    String selectedType = types[opt - 1];
	    
	    // lista filtrando
	    System.out.println("Ecopontos with " + selectedType + ":");
	    boolean found = false;
	    for (Ecoponto ecoponto : ecopontos) {
	        List<TrashType> trashTypes = ecoponto.getTrashTypes();
	        for (TrashType trashType : trashTypes) {
	            if (trashType.getName().equals(selectedType)) {
	                System.out.println("Name: " + ecoponto.getName() + ", Location: " + ecoponto.getLocation());
	                found = true;
	                break;
	            }
	        }
	    }
	    
	    if (!found) {
	        System.out.println("No ecopontos found with " + selectedType + ".");
	    }
	}
	
	private static void addTrashType(Ecoponto ecoponto, Scanner scanner) {
		// tipos de lixo que podem ter.
	    String[] types = {"Plástico", "Metal", "Vidro", "Papel", "Papelão"};
	    
	    // printa os tipos de lixo.
		while(true) {
			System.out.println("Add new trash type:");
			for (int i = 0; i < types.length; i++) {
		        System.out.println((i + 1) + ". " + types[i]);
		    }
			System.out.println("6. Finish");

		
			int opt = scanner.nextInt();
			
			// se tiver dentro das opções, adiciona.
			if(opt>=1 && opt <= types.length) {
		        ecoponto.addTrashType(new TrashType(types[opt - 1]));
			}
			else if (opt == 6){
				return;
			}
			else {
		        System.out.println("Invalid option.");
			}
		}
		
		
	}
}
