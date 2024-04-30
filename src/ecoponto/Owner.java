package ecoponto;

class Owner {
    private String name;
    private String cpf;

    public Owner(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    // getters.
    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }
    
    // setters.
    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}