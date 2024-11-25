import java.util.ArrayList;
import java.util.List;

public class Disco {
    private String titulo;
    private int ano;
    private List<Artista> artistas;
    private List<String> faixas;

    public Disco(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
        this.artistas = new ArrayList<>();
        this.faixas = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public void adicionarArtista(Artista artista) {
        artistas.add(artista);
    }

    public void removerArtista(Artista artista) {
        artistas.remove(artista);
    }

    public void adicionarFaixa(String faixa) {
        faixas.add(faixa);
    }

    public void removerFaixa(String faixa) {
        faixas.remove(faixa);
    }

    public void editarDisco(String novoTitulo, int novoAno) {
        this.titulo = novoTitulo;
        this.ano = novoAno;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(titulo).append("\n");
        sb.append("Ano: ").append(ano).append("\n");
        sb.append("Faixas: ").append(faixas.isEmpty() ? "Nenhuma" : String.join(", ", faixas)).append("\n");
        sb.append("Artistas: ");
        if (artistas.isEmpty()) {
            sb.append("Nenhum");
        } else {
            for (Artista artista : artistas) {
                sb.append("\n  - ").append(artista);
            }
        }
        return sb.toString();
    }
}
