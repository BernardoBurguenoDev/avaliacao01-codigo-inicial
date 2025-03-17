package classes;

public class Aeronave {
    private String modelo;
    private String numeroRegistro;
    private String pilotoCpf; // Relaciona a aeronave ao piloto

    public Aeronave(String modelo, String numeroRegistro, String pilotoCpf) {
        this.modelo = modelo;
        this.numeroRegistro = numeroRegistro;
        this.pilotoCpf = pilotoCpf;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public String getPilotoCpf() {
        return pilotoCpf;
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo + ", Registro: " + numeroRegistro + ", Piloto CPF: " + pilotoCpf;
    }
}
