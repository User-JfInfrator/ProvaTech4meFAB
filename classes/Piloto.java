package classes;

public class Piloto extends Pessoa {

    private String breve;

    private Aeronave aero;



    public Aeronave getAero() {
        return aero;
    }

    public void setAero(Aeronave aero) {
        this.aero = aero;
    }


    @Override
    public String toString() {
        String texto = " ";
        texto += "Nome: " + nome;
        texto += " | Cpf: " + cpf;
        texto += " | Brevê: " + breve;
        texto += " | Aeronave: " + aero;
        return texto;
        
    }


    public String getBreve() {
        return breve;
    }


    public void setBreve(String breve) {
        this.breve = breve;
    }

    
    



    

    


    
}
