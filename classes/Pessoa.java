package classes;

public class Pessoa {
    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        setCpf(cpf); // Validação do CPF já acontece aqui
    }

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
        // Verifica se o CPF tem exatamente 11 dígitos numéricos
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido! O CPF deve conter exatamente 11 dígitos numéricos.");
        }
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa { Nome = '" + nome + "', CPF = '" + cpf + "' }";
    }
}
