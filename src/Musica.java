public class Musica {
    private String titulo;
    private String artista;
    private String album;
    private String genero;
    private int anoLancamento;
    private double  duracao;

    public Musica (String titulo, String artista, String album, String genero, int anoLancamento, double duracao){
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.duracao = duracao;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public String getInfo() {
        return "Título: " + titulo + "\n" +
               "Artista: " + artista + "\n" +
               "Álbum: " + album + "\n" +
               "Gênero: " + genero + "\n" +
               "Ano de Lançamento: " + anoLancamento + "\n" +
               "Duração: " + duracao + " segundos";
    }

    
}
