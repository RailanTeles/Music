import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;
    private List<Musica> musicPlaylist = new ArrayList<>();

    public Playlist(String nome){
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

    // Metodo para add musicas
    public void addMusicPlaylist(Musica musica){
        this.musicPlaylist.add(musica);
    }

    // Método para remover músicas

    // Metodo para editar a posição da música

    // Metodo para excluir a playlist

}
