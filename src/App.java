import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    // Variáveis para coletar os dados do usuário
    static private String titulo;
    static private String artista;
    static private String album;
    static private String genero;
    static private int anoLancamento;
    static private double duracao;

    // Listas para ajudar na pesquisa
    static private List<Musica> listMusicas = new ArrayList<>();
    static private List<Artista> listArtista = new ArrayList<>();
    static private List<Album> listAlbum = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Variáveis para teste
        // Musica musica1 = new Musica("Horizonte Distante", "Banda Solaris", "Aurora Boreal", "Progressive Rock", 2022, 240.0);
        // listMusicas.add(musica1);
        // Musica musica2 = new Musica("Caminho das Estrelas", "Banda Solaris", "Aurora Boreal", "Progressive Rock", 2022, 215.5);
        // listMusicas.add(musica2);
        // Musica musica3 = new Musica("Sombras do Amanhã", "Eclipse Urbano", "Cidade Luz", "Indie Rock", 2021, 200.2);
        // listMusicas.add(musica3);
        // Musica musica4 = new Musica("Maré Cheia", "Ventos do Sul", "Oceano Azul", "MPB", 2020, 180.8);
        // listMusicas.add(musica4);


        while (true) {
            System.out.println("Selecione o que você quer fazer:");
            System.out.println("1 - Adicionar Música");
            System.out.println("2 - Realizar buscas");
            System.out.println("3 - Playlists");
            System.out.println("4 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1 -> {
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
                    scanner.nextLine(); 

                    System.out.println("Duração (em minutos):");
                    duracao = scanner.nextDouble();
                    scanner.nextLine(); 

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

                    // Se o artista não existir, ele cria e adiciona à lista
                    if (!artistaEncontrado) {
                        autor = new Artista(artista);
                        listArtista.add(autor);
                    }
                    autor.addMusicArtista(titulo); // Adiciona a música ao artista

                    Album albumObj = null;
                    boolean albumEncontrado = false;
                    // Mesma coisa do autor, mas para o álbum
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
                    albumObj.addMusicAlbum(titulo); // Adiciona a música ao álbum

                    // Cria uma nova instância de música
                    Musica musica = new Musica(titulo, artista, album, genero, anoLancamento, duracao);
                    // Adiciona à lista de músicas
                    listMusicas.add(musica);
                }

                case 2 -> {
                    System.out.println("Selecione o tipo de busca:");
                    System.out.println("1 - Por Título");
                    System.out.println("2 - Por Artista");
                    System.out.println("3 - Por Álbum");
                    System.out.println("4 - Por Gênero");
                    System.out.println("5 - Por Ano de Lançamento");
                    int opcaoBusca = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.println("Digite o termo de busca:");
                    String termoBusca = scanner.nextLine();

                    List<Musica> resultados = new ArrayList<>();

                    switch (opcaoBusca) {
                        case 1 -> {
                            for (Musica musica : listMusicas) {
                                if (musica.getTitulo().equalsIgnoreCase(termoBusca)) {
                                    resultados.add(musica);
                                }
                            }
                    }
                        case 2 -> {
                            for (Musica musica : listMusicas) {
                                if (musica.getArtista().equalsIgnoreCase(termoBusca)) {
                                    resultados.add(musica);
                                }
                            }
                    }
                        case 3 -> {
                            for (Musica musica : listMusicas) {
                                if (musica.getAlbum().equalsIgnoreCase(termoBusca)) {
                                    resultados.add(musica);
                                }
                            }
                    }
                        case 4 -> {
                            for (Musica musica : listMusicas) {
                                if (musica.getGenero().equalsIgnoreCase(termoBusca)) {
                                    resultados.add(musica);
                                }
                            }
                    }
                        case 5 -> {
                            int anoBusca = Integer.parseInt(termoBusca);
                            for (Musica musica : listMusicas) {
                                if (musica.getAnoLancamento() == anoBusca) {
                                    resultados.add(musica);
                                }
                            }
                    }
                        default -> System.out.println("Opção inválida.");
                    }

                    if (resultados.isEmpty()) {
                        System.out.println("Nenhuma música encontrada.");
                    } else {
                        System.out.println("Resultados da busca:");
                        for (Musica musica : resultados) {
                            System.out.println("-------------------");
                            System.out.println(musica.getInfo());
                        }
                    }
                    System.out.println("-------------------");
                }

                case 3 -> {
                    int opcao2 = 1;
                    while (opcao2 >= 1 && opcao2 <= 4) {
                        System.out.println("Edição de Playlist:");
                        System.out.println("1 - Criar Playlist");
                        System.out.println("2 - Editar Playlists");
                        System.out.println("3 - Excluir Playlist");
                        System.out.println("4 - Visualizar Playlists");
                        System.out.println("5 - Voltar");
                        opcao2 = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer

                        switch (opcao2) {
                            case 1 -> {
                                // Criar Playlist
                            }
                            case 2 -> {
                                // Editar Playlist
                            }
                            case 3 -> {
                                // Excluir Playlist
                            }
                            case 4 -> {
                                // Visualizar Playlist
                            }
                            case 5 -> {
                                System.out.println("Saindo...");
                            }
                            default -> {
                                System.out.println("Opção inválida");
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
                    System.out.println("Opção inválida");
                }
            }
        }
    }
}