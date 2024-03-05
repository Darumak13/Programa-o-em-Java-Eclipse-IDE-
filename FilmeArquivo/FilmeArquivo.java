import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

class ArquivoTextoLeitura {

	private BufferedReader entrada;

	ArquivoTextoLeitura(String nomeArquivo) {
		try {
			entrada = new BufferedReader(new InputStreamReader(new FileInputStream(nomeArquivo), "UTF-8"));
		} catch (UnsupportedEncodingException excecao) {
			System.out.println(excecao.getMessage());
		} catch (FileNotFoundException excecao) {
			System.out.println("Arquivo nao encontrado");
		}

		return;
	}

	public void fecharArquivo() {
		try {
			entrada.close();
		} catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);
		}
	}

	@SuppressWarnings("finally")
	public String ler() {

		String textoEntrada = null;
		try {
			textoEntrada = entrada.readLine();
		} catch (EOFException excecao) { // Excecao de final de arquivo.
			textoEntrada = null;
		} catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
			textoEntrada = null;
		} finally {
			return textoEntrada;
		}
	}

}

public class FilmeArquivo {

	public static String getPathArquivo() {
		String os = System.getProperty("os.name");
		if (os.contains("Windows"))
			return "filmes.txt";
		else
			return "/tmp/filmes.txt";
	}

	private int ID;
	private String Titulo;
	private String Diretor;
	private String Ator1;
	private String Ator2;
	private int Duracao;
	private String Categoria;
	private String Pais_Origem;
	private int Ano;
	private String Filmes;

	public FilmeArquivo(int id, String titulo, String diretor, String ator1, String ator2, int duracao,
			String categoria, String pais_origem, int ano) {
		this.ID = id;
		this.Titulo = titulo;
		this.Diretor = diretor;
		this.Ator1 = ator1;
		this.Ator2 = ator2;
		this.Duracao = duracao;
		this.Categoria = categoria;
		this.Pais_Origem = pais_origem;
		this.Ano = ano;
	}

	public FilmeArquivo(String filmes, String at1, String at2, String dir, String titu, String cate, String pdo,
			int ano, int id, int dur) {

		this.Filmes = filmes;
		this.Ator1 = at1;
		this.Ator2 = at2;
		this.Diretor = dir;
		this.Titulo = titu;
		this.Categoria = cate;
		this.Pais_Origem = pdo;
		this.Ano = ano;
		this.ID = id;
		this.Duracao = dur;

	}

	public String getFilme() {
		return Filmes;
	}

	public void setFilme(String filme) {
		this.Filmes = filme;
	}

	public int getAno() {
		return Ano;
	}

	public void setAno(int ano) {
		this.Ano = ano;
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		this.Titulo = titulo;
	}

	public String getDiretor() {
		return Diretor;
	}

	public void setDiretor(String diteror) {
		this.Diretor = diteror;
	}

	public String getAtor1() {
		return Ator1;
	}

	public void setAtor1(String ator1) {
		this.Ator1 = ator1;
	}

	public String getAtor2() {
		return Ator2;
	}

	public void setAtor2(String ator2) {
		this.Ator2 = ator2;
	}

	public int getDuracao() {
		return Duracao;
	}

	public void setDuracao(int duracao) {
		this.Duracao = duracao;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		this.Categoria = categoria;
	}

	public String getPais_origem() {
		return Pais_Origem;
	}

	public void setPais_origem(String pais_origem) {
		this.Pais_Origem = pais_origem;
	}

	public FilmeArquivo clone() {
		FilmeArquivo clone = new FilmeArquivo(Filmes, Ator1, Ator2, Diretor, Categoria, Pais_Origem, Titulo, Ano, ID,
				Duracao);
		clone.Filmes = this.Filmes;
		clone.ID = this.ID;
		clone.Titulo = this.Titulo;
		clone.Diretor = this.Diretor;
		clone.Ator1 = this.Ator1;
		clone.Ator2 = this.Ator2;
		clone.Duracao = this.Duracao;
		clone.Categoria = this.Categoria;
		clone.Pais_Origem = this.Pais_Origem;

		return clone;

	}

	public static void Bubblesort(FilmeArquivo[] array, int Tamanho) { 
		int Mov;
		int Comp ; 
		for (int i = (Tamanho - 1); i > 0; i--) {
			
			for (int j = 0; j < i; j++) {
				
				if (eMaior(array[j], array[j + 1])) { // , Comparacao , Movimentacao)) {

					FilmeArquivo temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void Insert(FilmeArquivo[] array, int Tamanho) {
		for (int i = 1; i < Tamanho; i++) {
			FilmeArquivo tmp = array[i];
			int j = i - 1;

			while ((j >= 0) && (eMaior(array[j], tmp))) {
				array[j + 1] = array[j];
				j--;

				array[j + 1] = tmp;
			}
		}
	}

	public static void Select(FilmeArquivo[] array, int Tamanho) {
		for (int i = 0; i < (Tamanho - 1); i++) {
			int menor = i;
			for (int j = (i + 1); j < Tamanho; j++) {
				if (eMaior(array[menor], array[j])) {
					menor = j;
				}
			}
			FilmeArquivo temp = array[i];
			array[i] = array[menor];
			array[menor] = temp;
		}
	}

	public static boolean eMaior(FilmeArquivo a, FilmeArquivo b) { // , int Comparacao ) {

		if (a.getAno() > b.getAno())

		{

			return true;

		}

		else if (a.getAno() == b.getAno()) {

			if (a.getCategoria().compareTo(b.getCategoria()) > 0) {

				return true;

			}

			else if (a.getCategoria().equals(b.getCategoria())) {

				if (a.getTitulo().compareTo(b.getTitulo()) > 0) {

					return true;

				}

			}

		}

		return false;

	}

	public static FilmeArquivo Ler(String linha) {

		String[] info = linha.split("#");

		int id = Integer.parseInt(info[0]);

		String titulo = info[1];

		String diretor = info[2];

		String ator1 = info[3];

		String ator2 = info[4];

		int ano = Integer.parseInt(info[5]);

		int duracao = Integer.parseInt(info[6]);

		String categoria = info[7];

		String pais_origem = info[8];

		return new FilmeArquivo(id, titulo, diretor, ator1, ator2, duracao, categoria, pais_origem, ano);

	}

	public String toString() {

		return "[" + getTitulo() + "]" + " [" + getAno() + "]" + " [" + getPais_origem() + "]" + " [" + getCategoria()
				+ "]" + " [" + getDiretor() + "]" + " [" + getAtor1() + ", " + getAtor2() + "]" + " [" + getDuracao()
				+ "]" + " [" + getId() + "] ";

	}

	public static void main(String[] args) {

		MyIO.setCharset("UTF-8");
		ArquivoTextoLeitura arqler = new ArquivoTextoLeitura(getPathArquivo());
		String linha = arqler.ler();

		FilmeArquivo[] Objetos = new FilmeArquivo[2000];
		FilmeArquivo[] pesquisas = new FilmeArquivo[1000];

		int i = 0;
		int j = 0;
		float Movimentacoes = 0;
		float Comparacoes = 0;

		FilmeArquivo Objeto;

		// while ((Objeto = FilmeArquivo.Ler()) != null)
		while (linha != null) {
			Objeto = FilmeArquivo.Ler(linha);
			Objetos[i++] = Objeto;
			linha = arqler.ler();

		}

		arqler.fecharArquivo();

		String linha2 = "";

		while (!linha2.equals("FIM")) {
			linha2 = MyIO.readLine();

			if (!linha2.equals("FIM")) {

				String[] info = linha2.split(";");

				String titulo = info[0];

				int ano = Integer.parseInt(info[1]);

				int tempo = Integer.parseInt(info[2]);

				pesquisas[j] = pesquisa(Objetos, titulo, ano, tempo);
				j++;
			}
		}

		FilmeArquivo[] pesquisasBubble = new FilmeArquivo[j];
		FilmeArquivo[] pesquisasInsert = new FilmeArquivo[j];
		FilmeArquivo[] pesquisasSelect = new FilmeArquivo[j];

		for (int k = 0; k < j; k++) {
			pesquisasBubble[k] = pesquisas[k].clone();
			pesquisasInsert[k] = pesquisas[k].clone();
			pesquisasSelect[k] = pesquisas[k].clone();
		}

		Bubblesort(pesquisasBubble, j); // , Comparacoes , Movimentacoes);
		// Insert(pesquisasInsert, j);
		// System.out.println("## INSERT [COMPARACOES] [0k] [MOVIMENTACOES] [0k]");
		// Select(pesquisasSelect , j );

		for (int k = 0; k < j; k++) {
			System.out.println(pesquisasBubble[k]);

		}
		System.out.printf("## BUBBLE [COMPARACOES] [0] [MOVIMENTACOES] [0]");

		/*
		 * for (int k = 0; k < j; k++) { System.out.println(pesquisasInsert[k]);
		 * 
		 * }
		 * 
		 */

		/*
		 * for (int k = 0; k < j; k++) { System.out.println(pesquisasSelect[k]);
		 * 
		 * }
		 */
	}

	public static FilmeArquivo pesquisa(FilmeArquivo[] objeto, String titulo, int ano, int tempo) {
		for (int i = 0; i < objeto.length; i++) {

			if (objeto[i].getTitulo().equals(titulo) && objeto[i].getAno() == ano && objeto[i].getDuracao() == tempo) {

				/*
				 * MyIO.println("[" + objeto[i].getTitulo() + "]" + " [" + objeto[i].getAno() +
				 * "]" + " [" + objeto[i].getPais_origem() + "]" + " [" +
				 * objeto[i].getCategoria() + "]" + " [" + objeto[i].getDiretor() + "]" + " [" +
				 * objeto[i].getAtor1() + ", " + objeto[i].getAtor2() + "]" + " [" +
				 * objeto[i].getDuracao() + "]" + " [" + objeto[i].getId() + "] ");
				 */
				return objeto[i];

			}

		}
		return null;

	}

}
