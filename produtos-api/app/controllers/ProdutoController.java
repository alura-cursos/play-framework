package controllers;

import play.mvc.*;
import views.html.*;

public class ProdutoController extends Controller {

	public Result salvaNovoProduto() {
		return ok("Formulario foi recebido!");
	}
	
	public Result formularioDeNovoProduto() {
		return ok(formularioDeNovoProduto.render("Cadastro de produto"));
	}
}
