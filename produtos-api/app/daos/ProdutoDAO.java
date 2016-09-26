package daos;

import com.avaje.ebean.Finder;

import models.Produto;

public class ProdutoDAO {

	private Finder<Long, Produto> produtos = new Finder<>(Produto.class);
	public Produto comCodigo(String codigo) {
		Produto produto = produtos.query()
				.where()
				.eq("codigo", codigo)
				.findUnique();
		return produto;
	}
}
