package controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import daos.ProdutoDAO;
import models.EnvelopeDeProdutos;
import models.Produto;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.data.validation.ValidationError;
import play.libs.Json;
import play.mvc.*;

public class ApiController extends Controller {

	@Inject
	private ProdutoDAO produtoDAO;
	@Inject
	private FormFactory formularios;

	public Result todos() {
		EnvelopeDeProdutos envelopeDeProdutos = new EnvelopeDeProdutos(produtoDAO.todos());
		return ok(Json.toJson(envelopeDeProdutos));
	}

	public Result doTipo(String tipo) {
		EnvelopeDeProdutos envelope = new EnvelopeDeProdutos(produtoDAO.doTipo(tipo));
		return ok(Json.toJson(envelope));
	}

}
