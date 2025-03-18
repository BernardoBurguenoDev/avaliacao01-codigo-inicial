package classes;

import java.util.ArrayList;
import java.util.List;

public class Piloto extends Pessoa {
    private String brevete;
    private List<Aeronave> aeronaves; // Lista de aeronaves associadas ao piloto

    public Piloto(String nome, String cpf, String brevete) {
        super(nome, cpf);
        this.brevete = brevete;
        this.aeronaves = new ArrayList<>();
    }

    public String getBrevete() {
        return brevete;
    }

    public List<Aeronave> getAeronaves() {
        return aeronaves;
    }

    public void adicionarAeronave(Aeronave aeronave) {
        aeronaves.add(aeronave);
    }

    @Override
    public String toString() {
        StringBuilder infoAeronaves = new StringBuilder();
        if (aeronaves.isEmpty()) {
            infoAeronaves.append("Nenhuma aeronave cadastrada");
        } else {
            for (Aeronave aeronave : aeronaves) {
                infoAeronaves.append("\n  - ").append(aeronave);
            }
        }

        return super.toString() + "\nBrevete: " + brevete + "\nAeronaves: " + infoAeronaves;
    }
}
