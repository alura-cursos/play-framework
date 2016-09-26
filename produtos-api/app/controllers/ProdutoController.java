package controllers;

import javax.inject.Inject;

import daos.ProdutoDAO;
import models.Produto;
import play.data.Form;
import play.data.FormFactory;
import play.data.validation.ValidationError;
import play.mvc.*;
import validadores.ValidadorDeProduto;
import views.html.*;

public class ProdutoController extends Controller {

	@Inject
	private FormFactory formularios;
	@Inject
	private ValidadorDeProduto validadorDeProduto;
	
	public Result salvaNovoProduto() {
		Form<Produto> formulario = formularios.form(Produto.class).bindFromRequest();
		Produto produto = formulario.get();
		
		if (validadorDeProduto.temErros(formulario)) {
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
