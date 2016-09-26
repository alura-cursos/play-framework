package controllers;

import java.util.List;

import javax.inject.Inject;

import daos.ProdutoDAO;
import models.EnvelopeDeProdutos;
import models.Produto;
import play.libs.Json;
import play.mvc.*;

public class ApiController extends Controller {

	@Inject
	private ProdutoDAO produtoDAO;
	
	public Result todos() {
		EnvelopeDeProdutos envelopeDeProdutos = new EnvelopeDeProdutos(produtoDAO.todos());
		return ok(Json.toJson(envelopeDeProdutos));
	}
}
