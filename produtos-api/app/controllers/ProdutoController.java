package controllers;

import javax.inject.Inject;

import daos.ProdutoDAO;
import models.Produto;
import play.data.Form;
import play.data.FormFactory;
import play.data.validation.ValidationError;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.formularioDeNovoProduto;

public class ProdutoController extends Controller {

	@Inject
	private FormFactory formularios;
	private ProdutoDAO produtoDAO;

	public Result salvaNovoProduto() {
		Form<Produto> formulario = formularios.form(Produto.class).bindFromRequest();
		Produto produto = formulario.get();
		if (produto.getPreco() < 0.0) {
			formulario.reject(new ValidationError("preco", "O preço do produto tem que ser maior que 0"));
		}
		if (produtoDAO.comCodigo(produto.getCodigo()) != null) {
			formulario.reject(new ValidationError("codigo", "Já existe um produto com este código!"));
		}
		if (formulario.hasErrors()) {
			return badRequest(formularioDeNovoProduto.render(formulario));
		}
		produto.save();
		return redirect(routes.ProdutoController.formularioDeNovoProduto());
	}

	public Result formularioDeNovoProduto() {
		Produto produto = new Produto();
		produto.setTipo("livro");
		Form<Produto> formulario = formularios.form(Produto.class).fill(produto);
		return ok(formularioDeNovoProduto.render(formulario));
	}
}
