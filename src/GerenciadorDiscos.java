import java.util.ArrayList;
import java.util.List;

public class GerenciadorDiscos {
    private List<Disco> discos;

    public GerenciadorDiscos() {
        this.discos = new ArrayList<>();
    }

    public void adicionarDisco(Disco disco) {
        discos.add(disco);
    }

    public void removerDisco(Disco disco) {
        discos.remove(disco);
    }

    public void listarDiscos() {
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
        } else {
            for (int i = 0; i < discos.size(); i++) {
                System.out.println((i + 1) + " - " + discos.get(i).getTitulo());
            }
        }
    }

    public Disco selecionarDisco(int indice) {
        if (indice >= 0 && indice < discos.size()) {
            return discos.get(indice);
        }
        return null;
    }

    public List<Disco> getDiscos() {
        return discos;
    }
}
