package lsss.appNutri.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/** Mantém uma ObservableList salva em arquivo. */
public class ListaDAO {
	
	private final String nomeDoArquivo;
	
	// Construtor
	public ListaDAO(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}
	
	/** Lê a lista no arquivo e retorna ela. */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ObservableList carregar() {
		System.out.println("Carregando " + nomeDoArquivo);

		try {
			var fis = new FileInputStream(nomeDoArquivo);

			try {
				var ois = new ObjectInputStream(fis);
				var arrayList = (ArrayList) ois.readObject();
				ois.close();
				
				System.out.println("Carregamento bem sucedido, conteúdo: " + arrayList + "\n");
				return FXCollections.observableArrayList(arrayList);
			}
			catch (IOException | ClassNotFoundException e) {
				System.out.println(String.format("Erro ao carregar %s, pode estar corrompido.",
						                         nomeDoArquivo));
				e.printStackTrace();
				System.exit(-1);
				return null; // Nao é executado, mas o compilador obriga a retornar
			}
		} 
		catch (FileNotFoundException e) {
			// Arquivo não existe, retorna lista vazia
			System.out.println(nomeDoArquivo + " não existe, portanto nenhum dado foi carregado.");
			return FXCollections.observableArrayList();
		}
	}
	
	
	/** Salva a lista no arquivo */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void salvar(ObservableList obsList) {
		System.out.println("Salvando " + nomeDoArquivo);
		
		try {
			var fos = new FileOutputStream(nomeDoArquivo);
			var oos = new ObjectOutputStream(fos);
			oos.writeObject(new ArrayList(obsList));
			oos.flush();
			oos.close();
		}
		catch (IOException e) { e.printStackTrace(); }
	}
}
