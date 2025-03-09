import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    // Variaveis para coletar os dados do usuário
    static private String titulo;
    static private String artista;
    static private String album;
    static private String genero;
    static private int anoLancamento;
    static private double  duracao;

    // Listas para mostrar ajudar na pesquisa
    static private List<Musica> listMusicas = new ArrayList<>();
    static private List<Artista> listArtista = new ArrayList<>();
    static private List<Album> listAlbum = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while(true){
            System.out.println("Selecione o que você quer fazer:");
            System.out.println("1 - Adicionar Música");
            System.out.println("2 - Realizar buscas");
            System.out.println("3 - Playlists");
            System.out.println("4 - Sair");
            opcao = scanner.nextInt();

            switch(opcao){
                case 1 -> {
                    System.out.println("");
                    System.out.println("Título:");
                    titulo = scanner.nextLine();  
                    
                    System.out.println("Artista:");
                    artista = scanner.nextLine();  
                    
                    System.out.println("Álbum:");
                    album = scanner.nextLine();
                    
                    System.out.println("Gênero:");
                    genero = scanner.nextLine();  
                    
                    System.out.println("Ano de Lançamento:");
                    anoLancamento = scanner.nextInt();  
                    
                    scanner.nextLine(); // Limpar o buffer
                    
                    System.out.println("Duração (em minutos):");
                    duracao = scanner.nextDouble();
                    
                    Artista autor = null;
                    boolean artistaEncontrado = false;
                    // Loop para verificar se o autor já existe
                    for (Artista artistaItem : listArtista) {
                        if (artistaItem.getNome().equals(artista)) {
                            autor = artistaItem;  
                            artistaEncontrado = true;
                            break;
                        }
                    }

                    // Se o artista não existir, ele cria e adiciona a lista
                    if (!artistaEncontrado) {
                        autor = new Artista(artista); 
                        listArtista.add(autor); 
                    }
                    autor.addMusicArtista(titulo); // Ele sempre adiciona a musica no artista 



                    Album albumObj = null;
                    boolean albumEncontrado = false;
                    // Mesma coisa do autor, mas para o albúm
                    for (Album albumItem : listAlbum) {
                        if (albumItem.getNome().equals(album)) {
                            albumObj = albumItem; 
                            albumEncontrado = true;
                            break;
                        }
                    }

                    if (!albumEncontrado) {
                        albumObj = new Album(album); 
                        listAlbum.add(albumObj); 
                    }
                    albumObj.addMusicAlbum(titulo); 

                    // Cria uma nova instância de música
                    Musica musica = new Musica(titulo, artista, album, genero, anoLancamento, duracao);
                    // Adiciona a lista de músicas
                    listMusicas.add(musica);
                }

                case 2 -> {
                    System.out.println("");
                    
                }

                case 3 -> {
                    int opcao2 = 1;
                    while(opcao2 >= 1 & opcao2 <= 4){
                        System.out.println("");
                        System.out.println("Edição de Playlist:");
                        System.out.println("1 - Criar Playlist");
                        System.out.println("2 - Editar Playlists");
                        System.out.println("3 - Excluir Playlist");
                        System.out.println("4 - Visualizar Playlists");
                        System.out.println("5 - Voltar");
                        opcao2 = scanner.nextInt();

                        switch(opcao2){
                            case 1 -> {
                                // Criar Playlists

                            }

                            case 2 -> {
                                // Adicionar, remover e reordenar músicas, de preferencia, com outro switch
                            }

                            case 3 -> {
                                // Remover
                            }

                            case 4 -> {
                                // Visualizar
                            }

                            case 5 -> {
                                System.out.println("Saindo..");
                            }

                            default -> {
                                System.out.println("Opção invalida");
                                opcao2 = 1;
                            }
                        }
                        
                        
                    }
                }

                case 4 -> {
                    scanner.close();
                    System.exit(0);
                }

                default -> {
                    System.out.println("Opção invalida");
                    System.out.println("");
                }
            }
        }

    }
}
