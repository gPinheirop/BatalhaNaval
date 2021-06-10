import java.util.Random;
import java.util.Scanner;

public class BatalhaNaval {
	public static void main(String[] args) {
		
	menu();

	}
	/*O m�todo menu consiste em um while que s� tem o seu loop quebrado quando o usu�rio realiza uma escolha. A estrutura respons�vel por realizar essa "escolha � um
	 * switch case mais um Scanner onde ap�s o mesmo atribuir um valor int para variavel "opcoes" o switch case inicia um bloco com 
	 * n�mero igual ao valor rec�m atribu�do sendo que:
	 * 1 = jogador vs jogador;
	 * 2 = jogador contra m�quina;
	 * 3 = regras do jogo;
	 * 4 = voltar para um outro menu anterior contendo os jogos restantes;
	 * OBS: m�todo � completamente descart�vel, o jogo em si funciona sozinho sem um menu
	 */
	public static void menu() {

		int opcoes;
		boolean validaOpcao = false;

		Scanner scanner = new Scanner(System.in);

		while ( validaOpcao == false) {
			
			System.out.println("escolha uma das op��es do menu digitando o valor das mesmas");
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
						+ "Batalha Naval � um jogo onde dois jogadores v�o colocar os seus barcos no tabuleiro e v�o tentar"
						+ "afundar todos os barcos do seu advers�rio atrav�s da adivinha��o, uma vez que os jogadores n�o podem"
						+ "ver o tabuleiro e a posi��o dos barcos um dos outros. "
						+ "para colocar os seus barcos no mapa o jogador vai escolher onde no tabuleiro o seu barco vai come�ar"
						+ "e para qual dire��o ele deve ser completado. Exemplo:"
						+ "\n o submarino come�a na linha 0 e na coluna 0 e ser� direcionado para direita. ou seja o submarino vai"
						+ "ocupar os espa�os 0, 0 mais a linhha 0 e a coluna 1 e ser� representado no tabuleiro como um 'O'."
						+ "\n os barcos s�o:"
						+ "\n 1 - porta-avi�es (cinco espa�os);"
						+ "\n 2 - navios-tanque (quatro espa�os);"
						+ "\n 3 - contratorpedeiros (tr�s espa�os);"
						+ "\n 4 - submarinos (dois espa�os)."
						+ "\n O vencedor � declarado assim que todos os barcos do seu oponente forem afundados por meio das"
						+ "advinha��es, esse tipo de jogada � feito escolhendo uma linha e uma coluna do tabuleiro para bombardear"
						+ "se acertar um espa�o vazio uma '+' ser� colocada no mapa, se acertar um barco um 'X' ser�"
						+ "adicionado no tabuleiro ");
				break;

			case 4 :
				validaOpcao = true;
				//metodo do menu original

				break;

			default :
				System.out.println("valor inv�lido, insira um valor que corresponde a uma opcao do menu");
				break;
			}
		}
	}
/*batalhaNavalPvP � um m�todo que contem outros m�todos dentro dele onde todos trabalham em conjunto para executar o jogo "batalha naval". Em resumo o batalhaNavalPvP
 * cria dois arrays bidimensionais 10/10 vazios (mapaP1 e mapaP2) para representar os tabuleiros onde o jogo � jogado. Ap�s isso os "barcos" s�o adicionados ao tabuleiro
 * seguindo os comandos do jogador gra�as ao metodo geradorDeBarcos(mapa) e uma vez que todos os "barcos" foram adicionados eles sao contados e a
 * din�mica de turnos se inicia. (while (vencedor ==false)) O jogador 1 tenta bombardear os barcos do jogador 2 (mapaP2 = fazJogada(mapaP2, turno))
 * e logo ap�s essa a��o o jogador 2 assume o papel de atacar o mapa advers�rio (mapaP1 = fazJogada(mapaP2, turno). 
 * O m�todo tem seu fim quando os barcos de um dos jogadores s�o todos afundados ((if (barcoP1 == 0)) ou (if (barcoP2 == 0))) e o vencedor � anunciado (vencedor = true).
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
	
	/*O m�todo criaMapa usa nos seus par�metros duas vari�veis do tipo int que v�o servir como limitadores para o tamanhos de cada dimen��o do array
	 * */
	public static int[] [] criaMapa(int linhas, int colunas) {

		int [][] mapa = new int [linhas] [colunas];


		return mapa;
	}
	
	/* A fun��o do m�todo desenhaMapa � de ler um array bidimensional e com base nos valores encontrados dentro dele gerar uma impress�o de uma parte do mapa.
	 * O tipo de estrutura desenvolvida para ler o array bidimensional foi um for (int linhas = 0 ; linhas < mapa.length ; linhas++) para ler as linhas e imprimir as divisorias
	 *  mais um while(colunas < 10 ) com um switch para ler as colunas e ap�s essa leitura imprimir quadrados com um conteudo diferente para cada possibilidade de valor
	 *  que os demais metodos podem ter adicionado ao array como:
	 *  0 = espa�o vazio;
	 *  1 = tiro em um espa�o vazio;
	 *  2 = se a vari�vel partida for false temos um s�mbolo que representa um barco. Caso seja executada com a variavel partida = true temos um espa�o vazio;
	 *  3 = tiro em um barco;
	 *  A exixt�ncia da vari�vel partida se faz necess�ria devido as duas diferentes circunst�ncias onde o metodo desenhaMapa pode ser executado. A primeira � para ilustrar
	 *  onde os barcos est�o sendo colocados no mapa e assim auxiliar o jogador nas suas escolhas J� a segunda seria durante o jogo em si onde a informa��o do barco inimigo 
	 *  � de suma import�ncia para o a partida e como as jogadas ocorrem no mapa do advers�rio, a localiza��o dos seus barcos deve ser ocultada.
	 *  OBS: a l�gica de um for que zera o valor das colunas ap�s a execu��o de um while que incrementa o valor das mesmas at� se equipara ao limite do array 
	 *  foi desenvolvida para ler o mapa[][] antes de ser do meu conhecimento a l�gica dos dois for's sendo o mapa[i].length para o segundo for por�m
	 *   ambos s�o v�lidos para esse m�todo.
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
	
	/*O m�todo fazJogada retorna o array bidimensional que ele usa de par�metro. Sua fun��o � de proporcionar ao jogador a oportunidade de escolher dois valores 
	 * que representam as linhas e as colunas do mapa([linhas][colunas]) e alterar esse espa�o uma vez que esse movimento for validado. A l�gica consiste em 
	 * um loop (while (verificaJogadas == false)) inicia o processo de valida��o da jogada e s� � fechado uma vez que essa escolha seja uma que respeite as regras 
	 * do jogo, ou seja:
	 * o valor de linhas e colunas estejam dentro dos limites do array e que essa escolha n�o seja feita em um local j� escolido anteriormente.
	 *  Dando seguimento a l�gica, temos um switch que com base no valor que o array mapa[linhas][colunas] possua ele ir� mud�-lo ou n�o. as possibilidades s�o:
	 *  0 = errou o barco, jogada v�lida, valor alterado para 1
	 *  1 = jogada inv�lida
	 *  2 = navio inimigo acertado, jogada v�lida, valor alterado para 3
	 *  3 = jogada inv�lida
	 *  a variavel turno serve apenas para explicar, durante os momentos iniciais da pertida, como fazer uma jogada.
	 * */
	public static int [][] fazJogada(int mapa [][], int turno){

		Scanner registraJogadas = new Scanner(System.in);

		int colunas = 0, linhas = 0;

		boolean verificaJogadas = false, verificaRegistro = false;

		if (turno == 0) {

			System.out.println("fa�a a sua jogada declarando um valor dentro do intervalo de 0 a 9 que ir� reprensentar"
					+ "em qual coluna e em qual linha ela vai ser realizada");
		}else {
			System.out.println("fa�a sua jogada");	
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

					System.out.println("voc� errou");
					mapa[linhas][colunas] = 1;
					verificaJogadas = true;
					break;

				case 1:

					verificaRegistro = false;
					System.out.println("jogada inv�lida, refa�a sua jogada num local n�o escolhido anteriormente");
					break;

				case 2:

					System.out.println("voc� acertou um navio inimigo!");
					mapa[linhas][colunas] = 3;
					verificaJogadas = true;
					break;

				case 3:

					verificaRegistro = false;
					System.out.println("jogada invalida, refa�a sua jogada num local n�o escolhido anteriormente");
					break;

				}
			}
		}

		return mapa;
	}
	
	/*geradorDeBarcos tamb�m retorna o array que ele usa de par�metro, altera os valores desse array e possui l�gicas de valida��o que visam detectar se as escolhas 
	 * do jogador v�o violar as regras do jogo ou n�o. O seu  diferencial est� na logica de dire��o e mais algumas peculiaridades.
	 * A estrutura do m�todo se resume a while's(validaBarco== false) que s� permitem dar seguimento ao resto do c�digo uma vez que esse "barco" seja validado,
	 * dentro desses while's temos a informa��o do tipo do barco e quantos espa�os ele ocupa. uma vez que essas informa��es foram impressas o mapa � "desenhado" pelo m�todo
	 * desenhaMapa com partida = false e a estrutura para coletar e validar a dire��o � iniciada. esse while (validaDirecao == false) � seguido por uma l�gica que visa 
	 * assegurar que a escolha das linhas e colunas est�o dentro do esperado e por fim mais duas l�gicas. A primeira e para validar a dire��o e uma segunda que
	 * disponibiliza a chance de trocar as posi��es iniciais (linhas e colunas). Essa primeira estrutura se encontra dentro de um if que s� � executado uma vez que
	 * as linhas e colunas estejam validadas. Em seu in�cio temos um Scanner que coleta valores do tipo int que simbolizam as dire��es:
	 * 1 = direita
	 * 2 = esquerda
	 * 3 = cima
	 * 4 = baixo
	 * 5 = troca das posi��es iniciais 
	 * esses valores s�o guardados na vari�vel "dire��o" que vai ser usada como um dos par�metros do m�todo validadorDeDirecao. O validadorDeDirecao retornar� uma vari�vel
	 * do tipo boolean (validaDirecao) que inicialmente � false mas o m�todo pode alterar o seu valor para true e assim que essa altera��o for feita o loop 
	 * (while validaDirecao == false) h� de ser quebrado e finalmente os valores do barco poder�o ser alterados pelo m�todo colocaBarco e a variavel validaBarco1 sera true.
	 * os demais barcos seguem a mesma l�gica para serem validados por�m com um decr�ssimo na vari�vel "barco" ao inicio de cada while(validaBarco == false).
	 * */
	public static int [][] geradorDeBarcos(int mapa[][]){

		Scanner coletaEscolha = new Scanner(System.in);

		int barco = 4, colunas = 0 , linhas = 0 , direcao = 0, troca = 0;

		boolean partida = false;

		boolean validaBarco1 = false, validaBarco2 = false,validaBarco3 = false, validaBarco4 = false;

		boolean validaLinhaColuna =false, validaDirecao = false ;

		System.out.println("declare onde ir� adicionar os seus barcos digitando em qual linha e em qual coluna o seu barco"
				+ " vai come�ar e em seguida para qual dire��o ele estar� orientado (direita, esquerda, cima ou para baixo). ");

		while(validaBarco1 == false) {

			System.out.println("1 - Porta-avioes (5 espa�os)");
			desenhaMapa(mapa,partida);
			System.out.println("declare a posi��o do barco em linhas e colunas");

			while (validaDirecao == false) {

				if(validaLinhaColuna == false) {

					System.out.println("linha: ");
					linhas = coletaEscolha.nextInt();
					System.out.println("coluna:");
					colunas = coletaEscolha.nextInt();

					validaLinhaColuna = validadorDeLinhaColuna(mapa, linhas, colunas, barco, validaLinhaColuna);
				}

				if (validaLinhaColuna == true) {

					System.out.println("declare para qual dire��o ele estar� orientado");
					System.out.println("\n 1 para direita"
							+ "\n 2 para esquerda"
							+ "\n 3 para cima"
							+ "\n 4 para baixo"
							+ "\n 5 para escolher uma nova posi��o inicial");
					direcao = coletaEscolha.nextInt();   

					validaDirecao = validadorDeDirecao( mapa, linhas, colunas, barco, direcao, validaDirecao);

					if (validaLinhaColuna == true && validaDirecao == false) {
						System.out.println("gostaria de trocar a posi��o inicial escolhida?\n"
								+ "se sim digite 1 e caso n�o queira digite 2");
						troca = coletaEscolha.nextInt();
						switch (troca) {
						case 1:
							validaLinhaColuna = false;
							System.out.println("voce optou por sim");
							troca = 0;
							break;

						case 2 :

							System.out.println("voce optou por n�o");
							troca = 0;
							break;

						default:

							System.out.println("valor fora do intervalo mencionado.Escolha de posi��o inicial mantida");
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

			System.out.println("2 - Navio-tanque (quatro espa�os)");
			desenhaMapa(mapa, partida);
			System.out.println("declare a posi��o do barco em linhas e colunas");

			while(validaDirecao == false) {

				if(validaLinhaColuna == false) {

					System.out.println("linha:");
					linhas = coletaEscolha.nextInt();
					System.out.println("coluna:");
					colunas = coletaEscolha.nextInt();

					validaLinhaColuna = validadorDeLinhaColuna(mapa, linhas, colunas, barco, validaLinhaColuna);
				}

				if (validaLinhaColuna == true) {

					System.out.println("declare para qual dire��o ele estar� orientado");
					System.out.println("\n 1 para direita"
							+ "\n 2 para esquerda"
							+ "\n 3 para cima"
							+ "\n 4 para baixo"
							+ "\n 5 para escolher uma nova posi��o inicial");
					direcao = coletaEscolha.nextInt();   

					validaDirecao = validadorDeDirecao( mapa, linhas, colunas, barco, direcao, validaDirecao);

					if (validaLinhaColuna == true && validaDirecao == false) {
						System.out.println("gostaria de trocar a posi��o inicial escolhida?\n"
								+ "se sim digite 1 e caso n�o queira digite 2");
						troca = coletaEscolha.nextInt();
						switch (troca) {
						case 1:
							validaLinhaColuna = false;
							System.out.println("voce optou por sim");
							troca = 0;
							break;

						case 2 :
							System.out.println("voce optou por n�o");
							troca = 0;
							break;

						default:
							System.out.println("valor fora do intervalo mencionado.Escolha de posi��o inicial mantida");
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

			System.out.println("3 - Contratorpedeiro (3 espa�os)");
			desenhaMapa(mapa, partida);
			System.out.println("declare a posi��o do barco em linhas e colunas");

			while(validaDirecao == false) {

				if (validaLinhaColuna == false){

					System.out.println("linhas : ");
					linhas = coletaEscolha.nextInt();
					System.out.println("linhas : ");
					colunas = coletaEscolha.nextInt();

					validaLinhaColuna = validadorDeLinhaColuna(mapa, linhas, colunas, barco, validaLinhaColuna);
				}

				if (validaLinhaColuna == true) {

					System.out.println("declare para qual dire��o o barco estar� orientado");
					System.out.println("\n 1 para direita"
							+ "\n 2 para esquerda"
							+ "\n 3 para cima"
							+ "\n 4 para baixo"
							+ "\n 5 para escolher uma nova posi��o");
					direcao = coletaEscolha.nextInt();

					validaDirecao = validadorDeDirecao(mapa, linhas, colunas, barco, direcao, validaDirecao);

					if (validaLinhaColuna == true && validaDirecao == false) {

						System.out.println("gostaria de trocar a posi��o inicial escolhida ?"
								+ "\n Se sim digite 1 e caso n�o queira digite 2");
						troca = coletaEscolha.nextInt();

						switch (troca) {
						case 1:

							System.out.println("voce optou por sim");
							validaLinhaColuna = false;

							break;

						case 2: 

							System.out.println("voce optou por n�o");

						default:
							System.out.println("valor fora do intervalo mencionado.Escolha de posi��o inicial mantida");
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
			System.out.println("declare a posi��o do barco em linhas e colunas");

			while(validaDirecao == false) {

				if(validaLinhaColuna == false) {

					System.out.println("linha:");
					linhas = coletaEscolha.nextInt();
					System.out.println("coluna:");
					colunas = coletaEscolha.nextInt();

					validaLinhaColuna = validadorDeLinhaColuna(mapa, linhas, colunas, barco, validaLinhaColuna);
				}

				if (validaLinhaColuna == true) {

					System.out.println("declare para qual dire��o o barco estar� orientado");
					System.out.println("\n 1 para direita"
							+ "\n 2 para esquerda"
							+ "\n 3 para cima"
							+ "\n 4 para baixo"
							+ "\n 5 para escolher uma nova posi��o inicial");
					direcao = coletaEscolha.nextInt();   

					validaDirecao = validadorDeDirecao( mapa, linhas, colunas, barco, direcao, validaDirecao);

					if (validaLinhaColuna == true && validaDirecao == false) {
						System.out.println("gostaria de trocar a posi��o inicial escolhida?\n"
								+ "Se sim digite 1 e caso n�o queira digite 2");
						troca = coletaEscolha.nextInt();
						switch (troca) {
						case 1:
							validaLinhaColuna = false;
							System.out.println("voce optou por sim");
							break;

						case 2 :
							System.out.println("voce optou por n�o");
							break;

						default:
							System.out.println("valor fora do intervalo mencionado.Escolha de posi��o inicial mantida");
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
	
	/*O m�todo validadorDeLinhaColuna retorna um boolean usado no seu par�metro e obtido no m�todo geradorDeBarcos.
	 * Utilizando um array bidimencional mais as vari�veis linhas, colunas e barco como par�metros a finalidade desse m�todo � ler o valor de mapa[linhas][colunas]
	 * e verificar se esse primeiro valor de um poss�vel "barco" est� dentro dos limites do array e no caso dos barcos que ser�o constru�dos ap�s o primeiro barco ha tamb�m 
	 * um teste para verificar se o come�o desse barco n�o esta alocado na mesma posi��o de um outro barco
	 * if ((linhas >= 0 && linhas <= 9) && (colunas >= 0 && colunas <= 9 ) ) para as linhas e
	 * && mapa[linhas][colunas]==0 para ver se n�o existe um outro barco ocupando essa posi��o.
	 * */
	public static boolean validadorDeLinhaColuna (int [][] mapa, int linhas, int colunas, int barco,boolean validaColunaLinha) {

		if (barco == 4) {

			if ((linhas >= 0 && linhas <= 9) && (colunas >= 0 && colunas <= 9 ) ) {

				validaColunaLinha = true;
			}else {

				System.out.println("escolha inv�lida, selecione uma nova posi��o");
			}

		}else {

			if ((linhas >= 0 && linhas <= 9) && (colunas >=0 && colunas <=9 ) && mapa[linhas][colunas]==0) {

				validaColunaLinha = true;
			}else {

				System.out.println("escolha inv�lida, selecione uma nova posi��o");
			}

		}

		return validaColunaLinha;
	}
	
	/*Com uma finalidade, retorno e par�metros similares, o m�todo validadorDeDirecao se distancia do seu antecessor devido a logica que o constr�i.
	 *esse m�todo utiliza um switch (direcao) para detectar qual dire��o foi escolhida pelo usu�rio e uma vez identificada if's, else if's um for e um outro switch
	 * s�o apresentados com a finalidade de testar se um barco constru�do na dire��o escolhida geraria alguma viola��o nas regras ou n�o.
	 *Exemplo com uma escolha de construir um barco da esquerda para direita:
	 *O if(colunas + barco <= 9) vai testar se o barco vai respeitar os limites do array ou n�o;
	 *O for (int i = 0, limite = barco + 1, contador = 0; i < limite ; i++) vai gerar todos os valores que o barco ocuparia;
	 *O switch (mapa[linhas][colunas+i]) vai testar se todos os valores que o barco vai ocupar est�o vazios. Caso n�o estejam uma mensagem de erro vai ser gerada posteriormente;
	 *a medida que cada valor for v�lido (ou seja 0) um contador � incrementado. se eles n�o forem v�lidos as linhas e colunas com erro v�o ser impressas na mensagem de erro;
	 *O if(contador == limite) serve validar a escolha do usu�rio.
	 *O else if (erro) � a estrutura respons�vel para gerar a mensagem de erro;
	 *O if (contaErro) verifica se houve erros no decorrer do for e imnprime mais uma mensagem de erro.
	 *explicando como funciona as escolhas:
	 *1 = direita => incrementando o valor das colunas ao decorrer do for;
	 *2 = esquerda => decrementando o valor das colunas ao decorrer do for;
	 *3 = cima => decrementando o valor das linhas ao decorrer do for;
	 *4 = baixo => incrementando o valor das linhas ao decorrer do for;
	 *5 = troca de posi��o => um bloco do switch vazio que existe para n�o retornar uma mensagem de erro mas ainda sim manter a ValidaDirecao como false;
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
						
						System.out.println("erro na posi��o linha: " + LinhaInvalida + " coluna: " + colunaInvalida);
					}
					
					erro = false;
				}
				
				if (contaErro > 0) {
					
					System.out.println("por favor refa�a a sua escolha");
				}

			}else {

				validaDirecao = false;
				System.out.println("dire��o escolhida para o barco � inv�lida, por favor escolha outra");
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
						
						System.out.println("erro na posi��o linha: " + LinhaInvalida + " coluna: " + colunaInvalida );
					}
				}
				
				if (contaErro > 0) {
					
					System.out.println("por favor refa�a a sua escolha");
				}

			}else {

				validaDirecao = false;
				System.out.println("dire��o escolhida para o barco � inv�lida, escolha outra");
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
						
						System.out.println("erro na posi��o linha: " + LinhaInvalida + " coluna: " + colunaInvalida);
					}
					
					erro = false;
				}
				
				if (contaErro > 0) {
					
					System.out.println("por favor refa�a a sua escolha");
				}

			}else {

				System.out.println("dire��o escolhida para o barco � inv�lida, escolha outra");
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
						
						System.out.println("erro na posi��o linha: " + LinhaInvalida + " coluna:  " + colunaInvalida);
					}
					
					erro = false;
				}
				
				if (contaErro > 0) {
					
					System.out.println("por favor refa�a a sua escolha");
				}

			}else {

				validaDirecao = false;
				System.out.println("dire��o escolhida para o barco � inv�lida, escolha outra");
			}

			break;

		case 5:
			break;

		default:

			validaDirecao = false;
			System.out.println("valor da dire��o foi inv�lido, por favor escolha um valor que corresponde a uma dire��o");
			break;
		}

		return validaDirecao;
	}
	
	/*colocaBarco retorna o array[][] que usa como par�metro e sua finalidade � utilizar dos testes de valida��o feitos antes dele ser executado para "posicionar o barco
	 * no mapa" sem erros no c�digo.
	 * a maneira na qual ele realiza essa tarefa muito se assemelha ao m�todo validadorDeDirecao devido aos switch's aos for's e de fato �, a direfen�a entre eles est�
	 *  no retorno e na altera��o do valor do array gerado pelo for para 2
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
	
	/*contadorDeBarcos � um m�todo que consiste em uma estrutura de dois for's para ler as duas dimen��es do array que se encontra em seu par�metro. Ap�s essa leitura
	 * o valor de int contador � incrementado a medida que o valor 2 for sendo identificado pelo if (mapa[i][j] ==2). No fim o n�mero de "barcos" levantados pelo m�todo
	 * v�o ser retornados e usados na l�gica do m�todo batalhaNavalPvP.
	 * OBS: a l�gica utilizada no desenhaMapa tamb�m poderia ser usada nesse m�todo por�m foi de escolha pessoal minha tentar usar as duas logicas no mesmo programa visando 
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

	/*os metodos a seguir s�o reimagina��es dos anteriores por�m, ao inv�s de usar Scanners para para coletar as respostas dos usu�rios, atrav�s do Random do java.util
	 * o pr�prio c�digo gera esses valores num intervalo correto.
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