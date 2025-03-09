import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;
    private List<Musica> musicPlaylist = new ArrayList<>();

    public Playlist(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Musica> getMusicPlaylist() {
        return musicPlaylist;
    }

    public void setMusicPlaylist(List<Musica> musicPlaylist) {
        this.musicPlaylist = musicPlaylist;
    }

    // Método para adicionar músicas
    public void addMusicPlaylist(Musica musica) {
        this.musicPlaylist.add(musica);
    }

    // Método para remover músicas
    public void removeMusicPlaylist(Musica musica) {
        this.musicPlaylist.remove(musica);
    }

    // Método para editar a posição da música
    public void editarPosicaoMusica(int posicaoAtual, int novaPosicao) {
        if (posicaoAtual >= 0 && posicaoAtual < musicPlaylist.size() &&
            novaPosicao >= 0 && novaPosicao < musicPlaylist.size()) {
            Musica musica = musicPlaylist.remove(posicaoAtual);
            musicPlaylist.add(novaPosicao, musica);
        } else {
            System.out.println("Posições inválidas.");
        }
    }

    // Método para excluir a playlist
    public void excluirPlaylist() {
        this.musicPlaylist.clear();
    }
}