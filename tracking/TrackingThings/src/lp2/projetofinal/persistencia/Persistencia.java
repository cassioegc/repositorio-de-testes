package lp2.projetofinal.persistencia;

/**
 * Classe responsavel por encapsular os metodos relacionados a persistencia no
 * projeto.
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 03
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

import lp2.projetofinal.entidades.ChaveNomeTelefone;
import lp2.projetofinal.entidades.Emprestimo;
import lp2.projetofinal.entidades.Usuario;

public class Persistencia {

	/**
	 * Metodo responsavel por salvar a lista de emprestimos no arquivo
	 * emprestimos.dat.
	 * 
	 * @param emprestimos
	 *            Lista de Emprestimos, com os emprestimos atuais registrados no
	 *            sistema.
	 */
	public static void salvarEmprestimos(List<Emprestimo> emprestimos) {

		try {

			FileOutputStream fos = new FileOutputStream("data/emprestimos.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(emprestimos);

			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo responsavel por carregar e retornar a lista de emprestimos contido
	 * no arquivo emprestimos.dat.
	 * 
	 * @return Retorna uma Lista com os emprestimos recuperados, caso o arquivo
	 *         esteja vazio ou não exista, retorna null.
	 */
	public static List<Emprestimo> carregaEmprestimos() {

		try {

			File arquivo = new File("data/emprestimos.dat");
			if (!arquivo.exists())
				arquivo.createNewFile();

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);

			@SuppressWarnings("unchecked")
			List<Emprestimo> emprestimos = (List<Emprestimo>) ois.readObject();

			ois.close();
			return emprestimos;

		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * Metodo responsavel por carregar e retornar o mapa de usuarios contido no
	 * arquivo usuarios.dat.
	 * 
	 * @return Retorna um mapa com os usuarios recuperados no arquivo
	 *         usuarios.dat. Caso o arquivo esteja vazio ou não exista, retorna
	 *         null.
	 */
	public static Map<ChaveNomeTelefone, Usuario> carregaUsuarios() {

		try {

			File arquivo = new File("data/usuarios.dat");
			if (!arquivo.exists())
				arquivo.createNewFile();

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);

			@SuppressWarnings("unchecked")
			Map<ChaveNomeTelefone, Usuario> usuarios = (Map<ChaveNomeTelefone, Usuario>) ois.readObject();

			ois.close();
			return usuarios;

		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * Metodo responsavel por salvar o mapa de usuarios no arquivo usuarios.dat.
	 * 
	 * @param usuarios
	 *            Mapa de usuarios com os usuarios atuais cadastrados no
	 *            sistema.
	 */
	public static void salvarUsuarios(Map<ChaveNomeTelefone, Usuario> usuarios) {

		try {

			FileOutputStream fos = new FileOutputStream("data/usuarios.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(usuarios);
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void resetar() {
		
		File arquivoUm = new File("data/emprestimos.dat");
		File arquivoDois = new File("data/usuarios.dat");
		
		arquivoUm.delete();
		arquivoDois.delete();
	}

}
