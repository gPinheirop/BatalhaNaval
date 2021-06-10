import java.util.Random;
import java.util.Scanner;

public class BatalhaNaval {
	public static void main(String[] args) {
		
	menu();

	}
	/*O método menu consiste em um while que só tem o seu loop quebrado quando o usuário realiza uma escolha. A estrutura responsável por realizar essa "escolha é um
	 * switch case mais um Scanner onde após o mesmo atribuir um valor int para variavel "opcoes" o switch case inicia um bloco com 
	 * número igual ao valor recém atribuído sendo que:
	 * 1 = jogador vs jogador;
	 * 2 = jogador contra máquina;
	 * 3 = regras do jogo;
	 * 4 = voltar para um outro menu anterior contendo os jogos restantes;
	 * OBS: método é completamente descartável, o jogo em si funciona sozinho sem um menu
	 */
	public static void menu() {

		int opcoes;
		boolean validaOpcao = false;

		Scanner scanner = new Scanner(System.in);

		while ( validaOpcao == false) {
			
			System.out.println("escolha uma das opções do menu digitando o valor das mesmas");
			System.out.println("1 - PvP \n2 - PvE \n3 - Regras \n4 - Voltar ");
			opcoes = scanner.nextInt();

			switch (opcoes) {
			case 1: 
				validaOpcao = true;
				batalhaNavalPvP();

				
				break;
			case 2:
				validaOpcao = true;
				batalhaNavalPvE();

				
				break;
			case 3:
				validaOpcao = true;
				System.out.println("regras:"
						+ "Batalha Naval é um jogo onde dois jogadores vão colocar os seus barcos no tabuleiro e vão tentar"
						+ "afundar todos os barcos do seu adversário através da adivinhação, uma vez que os jogadores não podem"
						+ "ver o tabuleiro e a posição dos barcos um dos outros. "
						+ "para colocar os seus barcos no mapa o jogador vai escolher onde no tabuleiro o seu barco vai começar"
						+ "e para qual direção ele deve ser completado. Exemplo:"
						+ "\n o submarino começa na linha 0 e na coluna 0 e será direcionado para direita. ou seja o submarino vai"
						+ "ocupar os espaços 0, 0 mais a linhha 0 e a coluna 1 e será representado no tabuleiro como um 'O'."
						+ "\n os barcos são:"
						+ "\n 1 - porta-aviões (cinco espaços);"
						+ "\n 2 - navios-tanque (quatro espaços);"
						+ "\n 3 - contratorpedeiros (três espaços);"
						+ "\n 4 - submarinos (dois espaços)."
						+ "\n O vencedor é declarado assim que todos os barcos do seu oponente forem afundados por meio das"
						+ "advinhações, esse tipo de jogada é feito escolhendo uma linha e uma coluna do tabuleiro para bombardear"
						+ "se acertar um espaço vazio uma '+' será colocada no mapa, se acertar um barco um 'X' será"
						+ "adicionado no tabuleiro ");
				break;

			case 4 :
				validaOpcao = true;
				//metodo do menu original

				break;

			default :
				System.out.println("valor inválido, insira um valor que corresponde a uma opcao do menu");
				break;
			}
		}
	}
/*batalhaNavalPvP é um método que contem outros métodos dentro dele onde todos trabalham em conjunto para executar o jogo "batalha naval". Em resumo o batalhaNavalPvP
 * cria dois arrays bidimensionais 10/10 vazios (mapaP1 e mapaP2) para representar os tabuleiros onde o jogo é jogado. Após isso os "barcos" são adicionados ao tabuleiro
 * seguindo os comandos do jogador graças ao metodo geradorDeBarcos(mapa) e uma vez que todos os "barcos" foram adicionados eles sao contados e a
 * dinâmica de turnos se inicia. (while (vencedor ==false)) O jogador 1 tenta bombardear os barcos do jogador 2 (mapaP2 = fazJogada(mapaP2, turno))
 * e logo após essa ação o jogador 2 assume o papel de atacar o mapa adversário (mapaP1 = fazJogada(mapaP2, turno). 
 * O método tem seu fim quando os barcos de um dos jogadores são todos afundados ((if (barcoP1 == 0)) ou (if (barcoP2 == 0))) e o vencedor é anunciado (vencedor = true).
 * */
	public static void batalhaNavalPvP(){

		boolean partida = true, vencedor = false;

		int barcoP1 = 0, barcoP2 = 0, turno = 0;
		int mapaP1 [][] = criaMapa(10,10);
		int mapaP2 [][] = criaMapa(10,10);

		System.out.println("iniciando o mapa do jogador 1");
		mapaP1 = geradorDeBarcos(mapaP1);
		barcoP1 = contadorDeBarcos(mapaP1, barcoP1);

		System.out.println("iniciando o mapa do jogador 2");
		mapaP2 = geradorDeBarcos(mapaP2);
		barcoP2 = contadorDeBarcos(mapaP2, barcoP2);

		while (vencedor == false) {

			if (barcoP1>0) {
				System.out.println("turno do jogador 1");
				desenhaMapa(mapaP2, partida);
				mapaP2 = fazJogada(mapaP2, turno);
				barcoP2 = contadorDeBarcos(mapaP2, barcoP2);
			}	

			if (barcoP2 > 0) {
				System.out.println("turno do jogador 2");
				desenhaMapa(mapaP1, partida);
				mapaP1 = fazJogada(mapaP1, turno);
				barcoP1 = contadorDeBarcos(mapaP1, barcoP1);


			}

			turno++;



			if (barcoP1 == 0) {

				vencedor = true;
				System.out.println("jogador 2 foi o vencedor!!!!");
			}

			if (barcoP2 == 0) {

				vencedor = true;
				System.out.println("jogador 1 foi o vencedor!!!!");
			}
		}

	}
	
	public static void batalhaNavalPvE () {
		
		boolean partida = true, vencedor = false; 
		
		int barcoP1 = 0, barcoP2 = 0, turno = 0;
		int mapaP1 [][] = criaMapa(10,10);
		int mapaP2 [][] = criaMapa(10,10);
		
		System.out.println("iniciando o mapa do jogador 1");
		mapaP1 = geradorDeBarcos(mapaP1);
		barcoP1 = contadorDeBarcos(mapaP1, barcoP1);
		
		System.out.println("iniciando o mapa do jogador 2");
		mapaP2 = geradorDeBarcosAleatorio(mapaP2);
		barcoP2 = contadorDeBarcos(mapaP2, barcoP2);
		
		while (vencedor == false) {

			if (barcoP1>0) {
				System.out.println("turno do jogador 1");
				desenhaMapa(mapaP2, partida);
				mapaP2 = fazJogada(mapaP2, turno);
				barcoP2 = contadorDeBarcos(mapaP2, barcoP2);
			}	

			if (barcoP2 > 0) {
				System.out.println("turno do jogador 2");
				desenhaMapa(mapaP1, partida);
				mapaP1 = fazJogadaAleatoria(mapaP1);
				barcoP1 = contadorDeBarcos(mapaP1, barcoP1);

			}
			
			turno++;

			if (barcoP1 == 0) {

				vencedor = true;
				System.out.println("jogador 2 foi o vencedor!!!!");
			}

			if (barcoP2 == 0) {

				vencedor = true;
				System.out.println("jogador 1 foi o vencedor!!!!");
			}
		}
	}
	
	/*O método criaMapa usa nos seus parâmetros duas variáveis do tipo int que vão servir como limitadores para o tamanhos de cada dimenção do array
	 * */
	public static int[] [] criaMapa(int linhas, int colunas) {

		int [][] mapa = new int [linhas] [colunas];


		return mapa;
	}
	
	/* A função do método desenhaMapa é de ler um array bidimensional e com base nos valores encontrados dentro dele gerar uma impressão de uma parte do mapa.
	 * O tipo de estrutura desenvolvida para ler o array bidimensional foi um for (int linhas = 0 ; linhas < mapa.length ; linhas++) para ler as linhas e imprimir as divisorias
	 *  mais um while(colunas < 10 ) com um switch para ler as colunas e após essa leitura imprimir quadrados com um conteudo diferente para cada possibilidade de valor
	 *  que os demais metodos podem ter adicionado ao array como:
	 *  0 = espaço vazio;
	 *  1 = tiro em um espaço vazio;
	 *  2 = se a variável partida for false temos um símbolo que representa um barco. Caso seja executada com a variavel partida = true temos um espaço vazio;
	 *  3 = tiro em um barco;
	 *  A exixtência da variável partida se faz necessária devido as duas diferentes circunstâncias onde o metodo desenhaMapa pode ser executado. A primeira é para ilustrar
	 *  onde os barcos estão sendo colocados no mapa e assim auxiliar o jogador nas suas escolhas Já a segunda seria durante o jogo em si onde a informação do barco inimigo 
	 *  é de suma importância para o a partida e como as jogadas ocorrem no mapa do adversário, a localização dos seus barcos deve ser ocultada.
	 *  OBS: a lógica de um for que zera o valor das colunas após a execução de um while que incrementa o valor das mesmas até se equipara ao limite do array 
	 *  foi desenvolvida para ler o mapa[][] antes de ser do meu conhecimento a lógica dos dois for's sendo o mapa[i].length para o segundo for porém
	 *   ambos são válidos para esse método.
	 * */
	public static void desenhaMapa(int mapa [] [], boolean partida) {

		int colunas = 0;

		for (int linhas = 0 ; linhas < mapa.length ; linhas++) {

			if (linhas == 0 ) {
				System.out.println("    0    1    2    3    4    5    6    7    8    9");
			}

			System.out.println("  --------------------------------------------------");
			System.out.print(linhas+ " ");

			while (colunas < 10 ) {

				switch (mapa[linhas][colunas]) {
				case 0:

					System.out.print("|   |");
					break;

				case 1 :

					System.out.print("| + |");
					break;


				case 2 : 

					if(partida == false) {

						System.out.print("| O |");
					}else {

						System.out.print("|   |");
					}
					break;

				case 3 :

					System.out.print("| X |");
					break;

				default:
					break;
				}


				colunas++;
			}
			System.out.println();
			colunas =0;
		}
		System.out.println("  --------------------------------------------------");

	}
	
	/*O método fazJogada retorna o array bidimensional que ele usa de parâmetro. Sua função é de proporcionar ao jogador a oportunidade de escolher dois valores 
	 * que representam as linhas e as colunas do mapa([linhas][colunas]) e alterar esse espaço uma vez que esse movimento for validado. A lógica consiste em 
	 * um loop (while (verificaJogadas == false)) inicia o processo de validação da jogada e só é fechado uma vez que essa escolha seja uma que respeite as regras 
	 * do jogo, ou seja:
	 * o valor de linhas e colunas estejam dentro dos limites do array e que essa escolha não seja feita em um local já escolido anteriormente.
	 *  Dando seguimento a lógica, temos um switch que com base no valor que o array mapa[linhas][colunas] possua ele irá mudá-lo ou não. as possibilidades são:
	 *  0 = errou o barco, jogada válida, valor alterado para 1
	 *  1 = jogada inválida
	 *  2 = navio inimigo acertado, jogada válida, valor alterado para 3
	 *  3 = jogada inválida
	 *  a variavel turno serve apenas para explicar, durante os momentos iniciais da pertida, como fazer uma jogada.
	 * */
	public static int [][] fazJogada(int mapa [][], int turno){

		Scanner registraJogadas = new Scanner(System.in);

		int colunas = 0, linhas = 0;

		boolean verificaJogadas = false, verificaRegistro = false;

		if (turno == 0) {

			System.out.println("faça a sua jogada declarando um valor dentro do intervalo de 0 a 9 que irá reprensentar"
					+ "em qual coluna e em qual linha ela vai ser realizada");
		}else {
			System.out.println("faça sua jogada");	
		}

		while(verificaJogadas == false) {

			System.out.print("linha :");
			linhas = registraJogadas.nextInt();

			System.out.print("colunas :");
			colunas = registraJogadas.nextInt();

			if ((colunas >= 0 && colunas <= 9) && (linhas >= 0 && linhas <= 9)) {
				verificaRegistro = true;
			}else {
				System.out.println("jogada fora do intervalo permitido,"
						+ " por favor realize uma jogada dentro do intervalo previamente informado");
			}

			if ( verificaRegistro == true) {
				switch (mapa[linhas][colunas]) {
				case 0:

					System.out.println("você errou");
					mapa[linhas][colunas] = 1;
					verificaJogadas = true;
					break;

				case 1:

					verificaRegistro = false;
					System.out.println("jogada inválida, refaça sua jogada num local não escolhido anteriormente");
					break;

				case 2:

					System.out.println("você acertou um navio inimigo!");
					mapa[linhas][colunas] = 3;
					verificaJogadas = true;
					break;

				case 3:

					verificaRegistro = false;
					System.out.println("jogada invalida, refaça sua jogada num local não escolhido anteriormente");
					break;

				}
			}
		}

		return mapa;
	}
	
	/*geradorDeBarcos também retorna o array que ele usa de parâmetro, altera os valores desse array e possui lógicas de validação que visam detectar se as escolhas 
	 * do jogador vão violar as regras do jogo ou não. O seu  diferencial está na logica de direção e mais algumas peculiaridades.
	 * A estrutura do método se resume a while's(validaBarco== false) que só permitem dar seguimento ao resto do código uma vez que esse "barco" seja validado,
	 * dentro desses while's temos a informação do tipo do barco e quantos espaços ele ocupa. uma vez que essas informações foram impressas o mapa é "desenhado" pelo método
	 * desenhaMapa com partida = false e a estrutura para coletar e validar a direção é iniciada. esse while (validaDirecao == false) é seguido por uma lógica que visa 
	 * assegurar que a escolha das linhas e colunas estão dentro do esperado e por fim mais duas lógicas. A primeira e para validar a direção e uma segunda que
	 * disponibiliza a chance de trocar as posições iniciais (linhas e colunas). Essa primeira estrutura se encontra dentro de um if que só é executado uma vez que
	 * as linhas e colunas estejam validadas. Em seu início temos um Scanner que coleta valores do tipo int que simbolizam as direções:
	 * 1 = direita
	 * 2 = esquerda
	 * 3 = cima
	 * 4 = baixo
	 * 5 = troca das posições iniciais 
	 * esses valores são guardados na variável "direção" que vai ser usada como um dos parâmetros do método validadorDeDirecao. O validadorDeDirecao retornará uma variável
	 * do tipo boolean (validaDirecao) que inicialmente é false mas o método pode alterar o seu valor para true e assim que essa alteração for feita o loop 
	 * (while validaDirecao == false) há de ser quebrado e finalmente os valores do barco poderão ser alterados pelo método colocaBarco e a variavel validaBarco1 sera true.
	 * os demais barcos seguem a mesma lógica para serem validados porém com um decréssimo na variável "barco" ao inicio de cada while(validaBarco == false).
	 * */
	public static int [][] geradorDeBarcos(int mapa[][]){

		Scanner coletaEscolha = new Scanner(System.in);

		int barco = 4, colunas = 0 , linhas = 0 , direcao = 0, troca = 0;

		boolean partida = false;

		boolean validaBarco1 = false, validaBarco2 = false,validaBarco3 = false, validaBarco4 = false;

		boolean validaLinhaColuna =false, validaDirecao = false ;

		System.out.println("declare onde irá adicionar os seus barcos digitando em qual linha e em qual coluna o seu barco"
				+ " vai começar e em seguida para qual direção ele estará orientado (direita, esquerda, cima ou para baixo). ");

		while(validaBarco1 == false) {

			System.out.println("1 - Porta-avioes (5 espaços)");
			desenhaMapa(mapa,partida);
			System.out.println("declare a posição do barco em linhas e colunas");

			while (validaDirecao == false) {

				if(validaLinhaColuna == false) {

					System.out.println("linha: ");
					linhas = coletaEscolha.nextInt();
					System.out.println("coluna:");
					colunas = coletaEscolha.nextInt();

					validaLinhaColuna = validadorDeLinhaColuna(mapa, linhas, colunas, barco, validaLinhaColuna);
				}

				if (validaLinhaColuna == true) {

					System.out.println("declare para qual direção ele estará orientado");
					System.out.println("\n 1 para direita"
							+ "\n 2 para esquerda"
							+ "\n 3 para cima"
							+ "\n 4 para baixo"
							+ "\n 5 para escolher uma nova posição inicial");
					direcao = coletaEscolha.nextInt();   

					validaDirecao = validadorDeDirecao( mapa, linhas, colunas, barco, direcao, validaDirecao);

					if (validaLinhaColuna == true && validaDirecao == false) {
						System.out.println("gostaria de trocar a posição inicial escolhida?\n"
								+ "se sim digite 1 e caso não queira digite 2");
						troca = coletaEscolha.nextInt();
						switch (troca) {
						case 1:
							validaLinhaColuna = false;
							System.out.println("voce optou por sim");
							troca = 0;
							break;

						case 2 :

							System.out.println("voce optou por não");
							troca = 0;
							break;

						default:

							System.out.println("valor fora do intervalo mencionado.Escolha de posição inicial mantida");
							troca = 0;
							break;
						}
					}
				}
			}
			colocaBarco( mapa, linhas, colunas, barco, direcao);
			validaBarco1 = true;
		}




		while(validaBarco2 == false) {

			barco--;
			validaLinhaColuna = false;
			validaDirecao = false;

			System.out.println("2 - Navio-tanque (quatro espaços)");
			desenhaMapa(mapa, partida);
			System.out.println("declare a posição do barco em linhas e colunas");

			while(validaDirecao == false) {

				if(validaLinhaColuna == false) {

					System.out.println("linha:");
					linhas = coletaEscolha.nextInt();
					System.out.println("coluna:");
					colunas = coletaEscolha.nextInt();

					validaLinhaColuna = validadorDeLinhaColuna(mapa, linhas, colunas, barco, validaLinhaColuna);
				}

				if (validaLinhaColuna == true) {

					System.out.println("declare para qual direção ele estará orientado");
					System.out.println("\n 1 para direita"
							+ "\n 2 para esquerda"
							+ "\n 3 para cima"
							+ "\n 4 para baixo"
							+ "\n 5 para escolher uma nova posição inicial");
					direcao = coletaEscolha.nextInt();   

					validaDirecao = validadorDeDirecao( mapa, linhas, colunas, barco, direcao, validaDirecao);

					if (validaLinhaColuna == true && validaDirecao == false) {
						System.out.println("gostaria de trocar a posição inicial escolhida?\n"
								+ "se sim digite 1 e caso não queira digite 2");
						troca = coletaEscolha.nextInt();
						switch (troca) {
						case 1:
							validaLinhaColuna = false;
							System.out.println("voce optou por sim");
							troca = 0;
							break;

						case 2 :
							System.out.println("voce optou por não");
							troca = 0;
							break;

						default:
							System.out.println("valor fora do intervalo mencionado.Escolha de posição inicial mantida");
							troca = 0;
							break;
						}
					}
				}


			}

			colocaBarco(mapa, linhas, colunas, barco, direcao);
			validaBarco2 = true;

		}

		while(validaBarco3 == false) {

			barco--;
			validaLinhaColuna = false;
			validaDirecao = false;

			System.out.println("3 - Contratorpedeiro (3 espaços)");
			desenhaMapa(mapa, partida);
			System.out.println("declare a posição do barco em linhas e colunas");

			while(validaDirecao == false) {

				if (validaLinhaColuna == false){

					System.out.println("linhas : ");
					linhas = coletaEscolha.nextInt();
					System.out.println("linhas : ");
					colunas = coletaEscolha.nextInt();

					validaLinhaColuna = validadorDeLinhaColuna(mapa, linhas, colunas, barco, validaLinhaColuna);
				}

				if (validaLinhaColuna == true) {

					System.out.println("declare para qual direção o barco estará orientado");
					System.out.println("\n 1 para direita"
							+ "\n 2 para esquerda"
							+ "\n 3 para cima"
							+ "\n 4 para baixo"
							+ "\n 5 para escolher uma nova posição");
					direcao = coletaEscolha.nextInt();

					validaDirecao = validadorDeDirecao(mapa, linhas, colunas, barco, direcao, validaDirecao);

					if (validaLinhaColuna == true && validaDirecao == false) {

						System.out.println("gostaria de trocar a posição inicial escolhida ?"
								+ "\n Se sim digite 1 e caso não queira digite 2");
						troca = coletaEscolha.nextInt();

						switch (troca) {
						case 1:

							System.out.println("voce optou por sim");
							validaLinhaColuna = false;

							break;

						case 2: 

							System.out.println("voce optou por não");

						default:
							System.out.println("valor fora do intervalo mencionado.Escolha de posição inicial mantida");
							break;
						}

					}
				}
			}
			
			colocaBarco(mapa, linhas, colunas, barco, direcao);				
			validaBarco3 = true;
		}

		while (validaBarco4 == false) {

			barco--;
			validaLinhaColuna = false;
			validaDirecao = false;

			System.out.println("4 - Submarino");
			desenhaMapa(mapa, partida);
			System.out.println("declare a posição do barco em linhas e colunas");

			while(validaDirecao == false) {

				if(validaLinhaColuna == false) {

					System.out.println("linha:");
					linhas = coletaEscolha.nextInt();
					System.out.println("coluna:");
					colunas = coletaEscolha.nextInt();

					validaLinhaColuna = validadorDeLinhaColuna(mapa, linhas, colunas, barco, validaLinhaColuna);
				}

				if (validaLinhaColuna == true) {

					System.out.println("declare para qual direção o barco estará orientado");
					System.out.println("\n 1 para direita"
							+ "\n 2 para esquerda"
							+ "\n 3 para cima"
							+ "\n 4 para baixo"
							+ "\n 5 para escolher uma nova posição inicial");
					direcao = coletaEscolha.nextInt();   

					validaDirecao = validadorDeDirecao( mapa, linhas, colunas, barco, direcao, validaDirecao);

					if (validaLinhaColuna == true && validaDirecao == false) {
						System.out.println("gostaria de trocar a posição inicial escolhida?\n"
								+ "Se sim digite 1 e caso não queira digite 2");
						troca = coletaEscolha.nextInt();
						switch (troca) {
						case 1:
							validaLinhaColuna = false;
							System.out.println("voce optou por sim");
							break;

						case 2 :
							System.out.println("voce optou por não");
							break;

						default:
							System.out.println("valor fora do intervalo mencionado.Escolha de posição inicial mantida");
							break;
						}
					}
				}

			}

			colocaBarco(mapa, linhas, colunas, barco, direcao);
			validaBarco4 = true;
		}

		desenhaMapa(mapa, partida);
		return mapa;
	}
	
	/*O método validadorDeLinhaColuna retorna um boolean usado no seu parâmetro e obtido no método geradorDeBarcos.
	 * Utilizando um array bidimencional mais as variáveis linhas, colunas e barco como parâmetros a finalidade desse método é ler o valor de mapa[linhas][colunas]
	 * e verificar se esse primeiro valor de um possível "barco" está dentro dos limites do array e no caso dos barcos que serão construídos após o primeiro barco ha também 
	 * um teste para verificar se o começo desse barco não esta alocado na mesma posição de um outro barco
	 * if ((linhas >= 0 && linhas <= 9) && (colunas >= 0 && colunas <= 9 ) ) para as linhas e
	 * && mapa[linhas][colunas]==0 para ver se não existe um outro barco ocupando essa posição.
	 * */
	public static boolean validadorDeLinhaColuna (int [][] mapa, int linhas, int colunas, int barco,boolean validaColunaLinha) {

		if (barco == 4) {

			if ((linhas >= 0 && linhas <= 9) && (colunas >= 0 && colunas <= 9 ) ) {

				validaColunaLinha = true;
			}else {

				System.out.println("escolha inválida, selecione uma nova posição");
			}

		}else {

			if ((linhas >= 0 && linhas <= 9) && (colunas >=0 && colunas <=9 ) && mapa[linhas][colunas]==0) {

				validaColunaLinha = true;
			}else {

				System.out.println("escolha inválida, selecione uma nova posição");
			}

		}

		return validaColunaLinha;
	}
	
	/*Com uma finalidade, retorno e parâmetros similares, o método validadorDeDirecao se distancia do seu antecessor devido a logica que o constrói.
	 *esse método utiliza um switch (direcao) para detectar qual direção foi escolhida pelo usuário e uma vez identificada if's, else if's um for e um outro switch
	 * são apresentados com a finalidade de testar se um barco construído na direção escolhida geraria alguma violação nas regras ou não.
	 *Exemplo com uma escolha de construir um barco da esquerda para direita:
	 *O if(colunas + barco <= 9) vai testar se o barco vai respeitar os limites do array ou não;
	 *O for (int i = 0, limite = barco + 1, contador = 0; i < limite ; i++) vai gerar todos os valores que o barco ocuparia;
	 *O switch (mapa[linhas][colunas+i]) vai testar se todos os valores que o barco vai ocupar estão vazios. Caso não estejam uma mensagem de erro vai ser gerada posteriormente;
	 *a medida que cada valor for válido (ou seja 0) um contador é incrementado. se eles não forem válidos as linhas e colunas com erro vão ser impressas na mensagem de erro;
	 *O if(contador == limite) serve validar a escolha do usuário.
	 *O else if (erro) é a estrutura responsável para gerar a mensagem de erro;
	 *O if (contaErro) verifica se houve erros no decorrer do for e imnprime mais uma mensagem de erro.
	 *explicando como funciona as escolhas:
	 *1 = direita => incrementando o valor das colunas ao decorrer do for;
	 *2 = esquerda => decrementando o valor das colunas ao decorrer do for;
	 *3 = cima => decrementando o valor das linhas ao decorrer do for;
	 *4 = baixo => incrementando o valor das linhas ao decorrer do for;
	 *5 = troca de posição => um bloco do switch vazio que existe para não retornar uma mensagem de erro mas ainda sim manter a ValidaDirecao como false;
	 * */
	public static boolean validadorDeDirecao( int[][] mapa, int linhas, int colunas, int barco,int direcao, boolean validaDirecao){

		int LinhaInvalida = 0, colunaInvalida = 0, contaErro = 0;
		boolean erro = false;
		
		switch (direcao) {
		case 1:
			
			if (colunas + barco <= 9) {

				for (int i = 0, limite = barco + 1, contador = 0; i < limite ; i++) {

					switch (mapa[linhas][colunas+i]) {
					case 0:

						contador ++;

						break;

					default:
						
						LinhaInvalida = linhas;
						colunaInvalida = colunas+i;
						erro = true;
						contaErro ++;
						break;
					}

					if(contador == limite) {

						validaDirecao = true;

					}else if (erro) {
						
						System.out.println("erro na posição linha: " + LinhaInvalida + " coluna: " + colunaInvalida);
					}
					
					erro = false;
				}
				
				if (contaErro > 0) {
					
					System.out.println("por favor refaça a sua escolha");
				}

			}else {

				validaDirecao = false;
				System.out.println("direção escolhida para o barco é inválida, por favor escolha outra");
			}


			break;

		case 2:
			
			if(colunas - barco >= 0) {

				for (int i = 0, limite = barco + 1, contador = 0; i < limite ; i++) {

					switch (mapa[linhas][colunas-i]) {
					case 0:

						contador ++;

						break;

					default:
						
						LinhaInvalida = linhas;
						colunaInvalida = colunas-i;
						erro = true;
						contaErro ++;
						break;
					}

					if(contador == limite) {
						validaDirecao = true;
					} else if (erro) {
						
						System.out.println("erro na posição linha: " + LinhaInvalida + " coluna: " + colunaInvalida );
					}
				}
				
				if (contaErro > 0) {
					
					System.out.println("por favor refaça a sua escolha");
				}

			}else {

				validaDirecao = false;
				System.out.println("direção escolhida para o barco é inválida, escolha outra");
			}


			break;

		case 3:
			
			if(linhas - barco >= 0) {
				for (int i = 0, limite = barco + 1, contador = 0; i < limite ; i++) {

					switch (mapa[linhas-i][colunas]) {
					case 0:

						contador ++;

						break;

					default:
						
						LinhaInvalida = linhas-i;
						colunaInvalida = colunas;
						erro = true;
						contaErro ++;
						break;
					}

					if(contador == limite) {
						
						validaDirecao = true;
					} else if (erro) {
						
						System.out.println("erro na posição linha: " + LinhaInvalida + " coluna: " + colunaInvalida);
					}
					
					erro = false;
				}
				
				if (contaErro > 0) {
					
					System.out.println("por favor refaça a sua escolha");
				}

			}else {

				System.out.println("direção escolhida para o barco é inválida, escolha outra");
				validaDirecao = false;

			}


			break;

		case 4:
			
			if(linhas + barco <= 9) {
				for (int i = 0, limite = barco + 1, contador = 0; i < limite ; i++) {

					switch (mapa[linhas+i][colunas]) {
					case 0:

						contador ++;

						break;

					default:
						
						LinhaInvalida = linhas+i;
						colunaInvalida = colunas;
						erro = true;
						contaErro ++;
						break;
					}

					if(contador == limite) {
						
						validaDirecao = true;
					} else if (erro) {
						
						System.out.println("erro na posição linha: " + LinhaInvalida + " coluna:  " + colunaInvalida);
					}
					
					erro = false;
				}
				
				if (contaErro > 0) {
					
					System.out.println("por favor refaça a sua escolha");
				}

			}else {

				validaDirecao = false;
				System.out.println("direção escolhida para o barco é inválida, escolha outra");
			}

			break;

		case 5:
			break;

		default:

			validaDirecao = false;
			System.out.println("valor da direção foi inválido, por favor escolha um valor que corresponde a uma direção");
			break;
		}

		return validaDirecao;
	}
	
	/*colocaBarco retorna o array[][] que usa como parâmetro e sua finalidade é utilizar dos testes de validação feitos antes dele ser executado para "posicionar o barco
	 * no mapa" sem erros no código.
	 * a maneira na qual ele realiza essa tarefa muito se assemelha ao método validadorDeDirecao devido aos switch's aos for's e de fato é, a direfença entre eles está
	 *  no retorno e na alteração do valor do array gerado pelo for para 2
	 * */
	public static int[][] colocaBarco (int[][] mapa, int linhas, int colunas, int barco, int direcao){

		switch (direcao) {
		case 1:
			for(int i = 0, limite = barco + 1 ;i < limite; i++ ) {
				mapa[linhas][colunas+i] = 2;
			}

			break;

		case 2:
			for(int i = 0, limite = barco + 1 ;i < limite; i++ ) {
				mapa[linhas][colunas-i] = 2;
			}

			break;

		case 3:
			for(int i = 0, limite = barco + 1 ;i < limite; i++ ) {
				mapa[linhas-i][colunas] = 2;
			}

			break;

		case 4:
			for(int i = 0, limite = barco + 1 ;i < limite; i++ ) {
				mapa[linhas+i][colunas] = 2;
			}

			break;
		}

		return mapa;
	}
	
	/*contadorDeBarcos é um método que consiste em uma estrutura de dois for's para ler as duas dimenções do array que se encontra em seu parâmetro. Após essa leitura
	 * o valor de int contador é incrementado a medida que o valor 2 for sendo identificado pelo if (mapa[i][j] ==2). No fim o número de "barcos" levantados pelo método
	 * vão ser retornados e usados na lógica do método batalhaNavalPvP.
	 * OBS: a lógica utilizada no desenhaMapa também poderia ser usada nesse método porém foi de escolha pessoal minha tentar usar as duas logicas no mesmo programa visando 
	 * um melhor aprendizado.
	 * */
	public static int contadorDeBarcos (int[][] mapa, int barcos) {

		int contador = 0;

		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {

				if (mapa[i][j] == 2) {

					contador++;

				}
				barcos = contador;

			}

		}
		return barcos;

	}

	/*os metodos a seguir são reimaginações dos anteriores porém, ao invés de usar Scanners para para coletar as respostas dos usuários, através do Random do java.util
	 * o próprio código gera esses valores num intervalo correto.
	 * */
	public static int [][] geradorDeBarcosAleatorio(int mapa[][]){
		
		Random geradorAleatorio = new Random();

		int barco = 4, colunas = 0 , linhas = 0 , direcao = 0;

		boolean partida = false;

		boolean validaBarco1 = false, validaBarco2 = false,validaBarco3 = false, validaBarco4 = false;

		boolean validaLinhaColuna =false, validaDirecao = false ;

		while(validaBarco1 == false) {

			while (validaDirecao == false) {

				if(validaLinhaColuna == false) {

					linhas = geradorAleatorio.nextInt(10);
					colunas = geradorAleatorio.nextInt(10);

					validaLinhaColuna = validadorDeLinhaColunaAleatorio(mapa, linhas, colunas, barco, validaLinhaColuna);
				}

				if (validaLinhaColuna == true) {

					direcao = geradorAleatorio.nextInt(4);   

					validaDirecao = validadorDeDirecaoAleatoria( mapa, linhas, colunas, barco, direcao, validaDirecao);

					if (validaLinhaColuna == true && validaDirecao == false) {
						
						validaLinhaColuna = false;
						
					}
				}
			}
			colocaBarcoAleatorio( mapa, linhas, colunas, barco, direcao);
			validaBarco1 = true;
		}




		while(validaBarco2 == false) {

			barco--;
			validaLinhaColuna = false;
			validaDirecao = false;
			
			while(validaDirecao == false) {

				if(validaLinhaColuna == false) {

					linhas = geradorAleatorio.nextInt(10);
					colunas = geradorAleatorio.nextInt(10);
					
					validaLinhaColuna = validadorDeLinhaColunaAleatorio(mapa, linhas, colunas, barco, validaLinhaColuna);
				}

				if (validaLinhaColuna == true) {

					direcao = geradorAleatorio.nextInt(4); 

					validaDirecao = validadorDeDirecaoAleatoria( mapa, linhas, colunas, barco, direcao, validaDirecao);

					if (validaLinhaColuna == true && validaDirecao == false) {
						
						validaLinhaColuna = false;
					}
				}


			}

			colocaBarcoAleatorio(mapa, linhas, colunas, barco, direcao);
			validaBarco2 = true;

		}

		while(validaBarco3 == false) {

			barco--;
			validaLinhaColuna = false;
			validaDirecao = false;

			while(validaDirecao == false) {

				if (validaLinhaColuna == false){
					
					linhas = geradorAleatorio.nextInt(10);
					colunas = geradorAleatorio.nextInt(10);

					validaLinhaColuna = validadorDeLinhaColunaAleatorio(mapa, linhas, colunas, barco, validaLinhaColuna);
					
				}

				if (validaLinhaColuna == true) {

					direcao = geradorAleatorio.nextInt(4); 

					validaDirecao = validadorDeDirecaoAleatoria(mapa, linhas, colunas, barco, direcao, validaDirecao);
					
					if (validaLinhaColuna == true && validaDirecao == false) {

						validaLinhaColuna = false;

					}
				}
			}
			colocaBarcoAleatorio(mapa, linhas, colunas, barco, direcao);				
			validaBarco3 = true;
		}

		while (validaBarco4 == false) {

			barco--;
			validaLinhaColuna = false;
			validaDirecao = false;

			while(validaDirecao == false) {

				if(validaLinhaColuna == false) {

					linhas = geradorAleatorio.nextInt(10);
					colunas = geradorAleatorio.nextInt(10);
					
					validaLinhaColuna = validadorDeLinhaColunaAleatorio(mapa, linhas, colunas, barco, validaLinhaColuna);
				}

				if (validaLinhaColuna == true) {

					direcao = geradorAleatorio.nextInt(4); 

					validaDirecao = validadorDeDirecaoAleatoria( mapa, linhas, colunas, barco, direcao, validaDirecao);

					if (validaLinhaColuna == true && validaDirecao == false) {
						
						validaLinhaColuna = false;
						
					}
				}

			}

			colocaBarcoAleatorio(mapa, linhas, colunas, barco, direcao);
			validaBarco4 = true;
		}

		desenhaMapa(mapa, partida);
		System.out.println("O mapa do jogador 2 foi gerado");
		return mapa;
	}
	
	public static boolean validadorDeLinhaColunaAleatorio(int [][] mapa, int linhas, int colunas, int barco,boolean validaLinhaColuna) {

		if (barco == 4) {

			if ((linhas >= 0 && linhas <= 9) && (colunas >= 0 && colunas <= 9 ) ) {

				validaLinhaColuna = true;
			}else {
				
				validaLinhaColuna = false;
			}

		}else {

			if ((linhas >= 0 && linhas <= 9) && (colunas >=0 && colunas <=9 ) && mapa[linhas][colunas]==0) {

				validaLinhaColuna = true;
			}else {

				validaLinhaColuna = false;
			}

		}

		return validaLinhaColuna;
	}
	
	public static boolean validadorDeDirecaoAleatoria( int[][] mapa, int linhas, int colunas, int barco,int direcao, boolean validaDirecao){

		switch (direcao) {
		case 0:
			
			if (colunas + barco <= 9) {

				for (int i = 0, limite = barco + 1, contador = 0; i < limite ; i++) {

					switch (mapa[linhas][colunas+i]) {
					case 0:

						contador ++;

						break;

					default:
						
						validaDirecao = false;
					}

					if(contador == limite) {

						validaDirecao = true;

					}
				}

			}else {

				validaDirecao = false;
			}


			break;

		case 1:
			
			if(colunas - barco >= 0) {

				for (int i = 0, limite = barco + 1, contador = 0; i < limite ; i++) {

					switch (mapa[linhas][colunas-i]) {
					case 0:

						contador ++;

						break;

					default:
						
						validaDirecao = false;
					}

					if(contador == limite) {
						
						validaDirecao = true;
					} 
				}

			}else {

				validaDirecao = false;
			}


			break;

		case 2:
			
			if(linhas - barco >= 0) {
				for (int i = 0, limite = barco + 1, contador = 0; i < limite ; i++) {

					switch (mapa[linhas-i][colunas]) {
					case 0:

						contador ++;

						break;

					default:
						
						validaDirecao = false;
					}

					if(contador == limite) {
						
						validaDirecao = true;
					}
				}
				
			}else {

				validaDirecao = false;

			}


			break;

		case 3:
			
			if(linhas + barco <= 9) {
				for (int i = 0, limite = barco + 1, contador = 0; i < limite ; i++) {

					switch (mapa[linhas+i][colunas]) {
					case 0:

						contador ++;

						break;

					default:
						
						validaDirecao = false;
						
						break;
					}

					if(contador == limite) {
						
						validaDirecao = true;
					}
				}
				
			}else {

				validaDirecao = false;
			}

			break;

		}

		return validaDirecao;
	}
	
	public static int[][] colocaBarcoAleatorio(int[][] mapa, int linhas, int colunas, int barco, int direcao){

		switch (direcao) {
		case 0:
			for(int i = 0, limite = barco + 1 ;i < limite; i++ ) {
				mapa[linhas][colunas+i] = 2;
			}

			break;

		case 1:
			for(int i = 0, limite = barco + 1 ;i < limite; i++ ) {
				mapa[linhas][colunas-i] = 2;
			}

			break;

		case 2:
			for(int i = 0, limite = barco + 1 ;i < limite; i++ ) {
				mapa[linhas-i][colunas] = 2;
			}

			break;

		case 3:
			for(int i = 0, limite = barco + 1 ;i < limite; i++ ) {
				mapa[linhas+i][colunas] = 2;
			}

			break;
		}

		return mapa;
	}
	
	public static int [][] fazJogadaAleatoria(int mapa [][]){

		Random geradorAleatorio = new Random();
		
		int colunas = 0, linhas = 0;

		boolean verificaJogadas = false, verificaRegistro = false;	
		
		while(verificaJogadas == false) {

			linhas = geradorAleatorio.nextInt(10);

			colunas = geradorAleatorio.nextInt(10);

			if ((colunas >= 0 && colunas <= 9) && (linhas >= 0 && linhas <= 9)) {
				
				verificaRegistro = true;
				
			}else {
				
				verificaRegistro = false;
			}

			if ( verificaRegistro == true) {
				
				switch (mapa[linhas][colunas]) {
				case 0:
					
					System.out.println("O jogador 2 errou");
					mapa[linhas][colunas] = 1;
					verificaJogadas = true;
					
					break;

				case 1:
					

					verificaRegistro = false;
					
					break;

				case 2:
					
					System.out.println("O jogador 2 acertou");
					mapa[linhas][colunas] = 3;
					verificaJogadas = true;
					
					break;

				case 3:
					
					
					verificaRegistro = false;
					break;

				}
			}
		}

		return mapa;
	}

}