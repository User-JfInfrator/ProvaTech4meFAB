package classes;
public class Pessoa {
    protected String nome;
    protected String cpf;

    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        if(cpf.length() != 11){
            System.out.println("O cpf tem que ter 11 números!");
        }
        else{
            this.cpf = cpf;
        }
    }
    
    
    


    
    
}
