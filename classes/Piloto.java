package classes;

public class Piloto extends Pessoa {
    private String brevete;

    public Piloto(String nome, String cpf, String brevete) {
        super(nome, cpf);
        this.brevete = brevete;
    }

    public String getBrevete() {
        return brevete;
    }

    public void setBrevete(String brevete) {
        this.brevete = brevete;
    }

    @Override
    public String toString() {
        return "Piloto { Nome = '" + getNome() + "', CPF = '" + getCpf() + "', Brevete = '" + brevete + "' }";
    }
}
