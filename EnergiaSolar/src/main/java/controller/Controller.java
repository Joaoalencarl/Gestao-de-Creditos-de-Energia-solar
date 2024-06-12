package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArmazenarCalcs;
import model.Calculos;
import model.Clientes;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/index", "/novacid", "/insert", "/prodesp", "/select", "/update",
		"/delete", "/calcProdEsp", "/atendIni", "/novocli", "/insertcliente", "/editarcli", "/deletecli", "/updatecli" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans cidade = new JavaBeans();
	Calculos calculos = new Calculos();
	ArmazenarCalcs resultados = new ArmazenarCalcs();
	Clientes cliente = new Clientes();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		//System.out.println(action);
		if (action.equals("/main")) {
			listarCidades(request, response);
		} else if (action.equals("/index")) {
			response.sendRedirect("index.html");
		} else if (action.equals("/prodesp")) {
			listarCidadesProdesp(request, response);
		} else if (action.equals("/novacid")) {
			response.sendRedirect("novacid.jsp");
		} else if (action.equals("/insert")) {
			novaCidade(request, response);
		} else if (action.equals("/select")) {
			listarCidade(request, response);
		} else if (action.equals("/update")) {
			editarCidade(request, response);
		} else if (action.equals("/delete")) {
			removerCidade(request, response);
		} else if (action.equals("/calcProdEsp")) {
			calcProdEsp(request, response);
		} else if (action.equals("/atendIni")) {
			listarClientes(request, response);
		} else if (action.equals("/novocli")) {
			listarNovosClientes(request, response);
		} else if (action.equals("/insertcliente")) {
			novoCliente(request, response);
		} else if (action.equals("/editarcli")) {
			listarCliente(request, response);
		} else if (action.equals("/updatecli")) {
			editarCliente(request, response);
		} else if (action.equals("/deletecli")) {
			removerCliente(request, response);
		} else {
			response.sendRedirect("index.html");
		}
		// Teste de conexão BD
		// dao.testeConexao();
	}

	// Listar cidades em novacid.jsp
	protected void listarCidades(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criar um objeto que receberá os dados JavaBeans
		ArrayList<JavaBeans> listacid = dao.listarCidades();
		// Encaminhar a lista ao documento novacid. Deve ir para a página novacid
		request.setAttribute("cidades", listacid);
		RequestDispatcher rd = request.getRequestDispatcher("novacid.jsp");
		rd.forward(request, response);
	}

	// Listar cidades em producaoesperada.jsp
	protected void listarCidadesProdesp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criar um objeto que receberá os dados JavaBeans
		ArrayList<JavaBeans> listacid = dao.listarCidades();
		// Encaminhar a lista ao documento novacid. Deve ir para a página novacid
		request.setAttribute("cidades", listacid);
		RequestDispatcher rd = request.getRequestDispatcher("producaoesperada.jsp");
		rd.forward(request, response);
	}

	// Direciona para a página de inserir nova cidade
	protected void novaCidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variáveis JavaBeans
		cidade.setNomecid(request.getParameter("nomecid"));
		cidade.setJaneiro(request.getParameter("janeiro"));
		cidade.setFevereiro(request.getParameter("fevereiro"));
		cidade.setMarco(request.getParameter("marco"));
		cidade.setAbril(request.getParameter("abril"));
		cidade.setMaio(request.getParameter("maio"));
		cidade.setJunho(request.getParameter("junho"));
		cidade.setJulho(request.getParameter("julho"));
		cidade.setAgosto(request.getParameter("agosto"));
		cidade.setSetembro(request.getParameter("setembro"));
		cidade.setOutubro(request.getParameter("outubro"));
		cidade.setNovembro(request.getParameter("novembro"));
		cidade.setDezembro(request.getParameter("dezembro"));
		cidade.setMedia(String.valueOf(calculos.mediaIrradiacao(cidade)));

		// Invocar o método inserirCidade passando o objeto cidade
		dao.inserirCidade(cidade);
		// Redirecionar para o documento
		response.sendRedirect("main"); // Verificar para quem será redirecionado
	}

	// Listar cidade para editar
	protected void listarCidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Query String retorna "selecionado=id" - Foi realizado desta forma pois
		// getParameter retornava somente null
		String textoQuery = request.getQueryString();
		// Remover "selecionado=" da string
		String idcid = textoQuery.replace("selecionado=", "");;
		// Setar a variável JavaBeans
		cidade.setIdcid(idcid);
		// Executar o método selecionarCidade (DAO)
		dao.selecionarCidade(cidade);
		// Setar os atributos do formulário com o conteúdo JavaBeans
		request.setAttribute("idcid", cidade.getIdcid());
		request.setAttribute("nomecid", cidade.getNomecid());
		request.setAttribute("janeiro", cidade.getJaneiro());
		request.setAttribute("fevereiro", cidade.getFevereiro());
		request.setAttribute("marco", cidade.getMarco());
		request.setAttribute("abril", cidade.getAbril());
		request.setAttribute("maio", cidade.getMaio());
		request.setAttribute("junho", cidade.getJunho());
		request.setAttribute("julho", cidade.getJulho());
		request.setAttribute("agosto", cidade.getAgosto());
		request.setAttribute("setembro", cidade.getSetembro());
		request.setAttribute("outubro", cidade.getOutubro());
		request.setAttribute("novembro", cidade.getNovembro());
		request.setAttribute("dezembro", cidade.getDezembro());
		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	// Editar cidade
	protected void editarCidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variáveis JavaBeans
		cidade.setIdcid(request.getParameter("idcid"));
		cidade.setNomecid(request.getParameter("nomecid"));
		cidade.setJaneiro(request.getParameter("janeiro"));
		cidade.setFevereiro(request.getParameter("fevereiro"));
		cidade.setMarco(request.getParameter("marco"));
		cidade.setAbril(request.getParameter("abril"));
		cidade.setMaio(request.getParameter("maio"));
		cidade.setJunho(request.getParameter("junho"));
		cidade.setJulho(request.getParameter("julho"));
		cidade.setAgosto(request.getParameter("agosto"));
		cidade.setSetembro(request.getParameter("setembro"));
		cidade.setOutubro(request.getParameter("outubro"));
		cidade.setNovembro(request.getParameter("novembro"));
		cidade.setDezembro(request.getParameter("dezembro"));
		cidade.setMedia(String.valueOf(calculos.mediaIrradiacao(cidade)));
		// Executar o método alterarCidade()
		dao.alterarCidade(cidade);
		// Redirecionar para o documento novacid.jsp atualizando as alterações
		response.sendRedirect("main");
	}

	// Excluir cidade
	protected void removerCidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebendo Query selecionado2=? e removendo a parte selecionado2= para obter ?
		String idcid = request.getQueryString().replace("selecionado2=", "");
		// Recebimento do id da cidade que será excluída (confirmador.js)
		cidade.setIdcid(idcid);
		// Executar o método deletar cidade
		dao.deletarCidade(cidade);
		// Redirecionar para o documento novacid.jsp atualizando as alterações
		response.sendRedirect("main");
	}
	
	// Calcular produção esperada
	protected void calcProdEsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Pegar texto cid=?&nummod=?&potmod=? e Separar para [cid=?, nummod=?, potmod=?]
		String[] textoQuery = request.getQueryString().split("&");
		//System.out.println(Arrays.toString(textoQuery));
		// Remover textos, deixando somente os valores e armazenar em variáveis
		//Utilizar este ou o de baixo quando for necessário
		String idcid = textoQuery[0].replace("cid=", "");
		String nummod = textoQuery[1].replace("nummod=", "");
		String potmod = textoQuery[2].replace("potmod=", "");
		String efi = textoQuery[3].replace("efi=", "");	
		//Para utilizar este bloco é necessário descomentá-lo, descomentar as variáveis abaixo e descomentar o código em "producaoesperada.jsp"
		/*
		String nomecli = textoQuery[0].replace("nomecliente=", "");
		String idcid = textoQuery[1].replace("cid=", "");
		String nummod = textoQuery[2].replace("nummod=", "");
		String potmod = textoQuery[3].replace("potmod=", "");
		String efi = textoQuery[4].replace("efi=", "");
		String prodjan = textoQuery[5].replace("prodjan=", "");
		String prodfev = textoQuery[6].replace("prodfev=", "");
		String prodmar = textoQuery[7].replace("prodmar=", "");
		String prodabr = textoQuery[8].replace("prodabr=", "");
		String prodmai = textoQuery[16].replace("prodmai=", "");
		String prodjun = textoQuery[9].replace("prodjun=", "");
		String prodjul = textoQuery[10].replace("prodjul=", "");
		String prodago = textoQuery[11].replace("prodago=", "");
		String prodset = textoQuery[12].replace("prodset=", "");
		String prodout = textoQuery[13].replace("prodout=", "");
		String prodnov = textoQuery[14].replace("prodnov=", "");
		String proddez = textoQuery[15].replace("proddez=", "");
		*/
		
		// Setar as variáveis JavaBeans
		cidade.setIdcid(idcid);
		resultados.setNummod(nummod);
		resultados.setPotmod(potmod);
		resultados.setEfi(efi);
		/*
		resultados.setNomecli(nomecli);
		resultados.setProdjan(prodjan);
		resultados.setProdfev(prodfev);
		resultados.setProdmar(prodmar);
		resultados.setProdabr(prodabr);
		resultados.setProdmai(prodmai);
		resultados.setProdjun(prodjun);
		resultados.setProdjul(prodjul);
		resultados.setProdago(prodago);
		resultados.setProdset(prodset);
		resultados.setProdout(prodout);
		resultados.setProdnov(prodnov);
		resultados.setProddez(proddez);
		*/
		
		dao.selecionarCidade(cidade);
		// Chamar método para calcular a potência e Setar na variável JavaBeans
		resultados.setPotencia(String.valueOf(calculos.potenciaInstalada(resultados)));
		// Chamar método para calcular a produção esperada e Setar nas variáveis JavaBeans
		calculos.energiaEsperada(resultados, cidade);		
		
		// Setar os atributos do formulário com o conteúdo JavaBeans
		request.setAttribute("nomecid", cidade.getNomecid());
		request.setAttribute("janeiro", cidade.getJaneiro());
		request.setAttribute("fevereiro", cidade.getFevereiro());
		request.setAttribute("marco", cidade.getMarco());
		request.setAttribute("abril", cidade.getAbril());
		request.setAttribute("maio", cidade.getMaio());
		request.setAttribute("junho", cidade.getJunho());
		request.setAttribute("julho", cidade.getJulho());
		request.setAttribute("agosto", cidade.getAgosto());
		request.setAttribute("setembro", cidade.getSetembro());
		request.setAttribute("outubro", cidade.getOutubro());
		request.setAttribute("novembro", cidade.getNovembro());
		request.setAttribute("dezembro", cidade.getDezembro());
		request.setAttribute("media", cidade.getMedia());
		
		request.setAttribute("nummod", resultados.getNummod());
		request.setAttribute("potmod", resultados.getPotmod());
		request.setAttribute("potencia", resultados.getPotencia());
		
		request.setAttribute("efic", resultados.getEfi());
		request.setAttribute("espjan", resultados.getEspjan());
		request.setAttribute("espfev", resultados.getEspfev());
		request.setAttribute("espmar", resultados.getEspmar());
		request.setAttribute("espabr", resultados.getEspabr());
		request.setAttribute("espmai", resultados.getEspmai());
		request.setAttribute("espjun", resultados.getEspjun());
		request.setAttribute("espjul", resultados.getEspjul());
		request.setAttribute("espago", resultados.getEspago());
		request.setAttribute("espset", resultados.getEspset());
		request.setAttribute("espout", resultados.getEspout());
		request.setAttribute("espnov", resultados.getEspnov());
		request.setAttribute("espdez", resultados.getEspdez());
		request.setAttribute("espmedia", resultados.getEspmedia());
		request.setAttribute("espsoma", resultados.getEspsoma());
		
		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("resultado.jsp");
		rd.forward(request, response);
	}

	// Direciona para a página de inserir novo cliente (novocli.jsp)
		protected void novoCliente(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Setar as variáveis JavaBeans
			cliente.setNomecli(request.getParameter("cli"));
			cliente.setNomeemp(request.getParameter("empr"));
			cliente.setCpf(request.getParameter("cpf"));
			cliente.setCnpj(request.getParameter("cnpj"));
			cliente.setTel1(request.getParameter("tel1"));
			cliente.setTel2(request.getParameter("tel2"));

			// Invocar o método inserirCidade passando o objeto cidade
			dao.inserirCliente(cliente);
			// Redirecionar para o documento
			response.sendRedirect("novocli");
		}
		
		// Listar clientes em atendimentoinicial.jsp
		protected void listarClientes(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Criar um objeto que receberá os dados JavaBeans
			ArrayList<Clientes> listacli = dao.listarClientes();
			// Encaminhar a lista ao documento novacid. Deve ir para a página novacid
			request.setAttribute("clientes", listacli);
			RequestDispatcher rd = request.getRequestDispatcher("atendimentoinicial.jsp");
			rd.forward(request, response);
		}
		
		// Listar clientes em novocli.jsp
		protected void listarNovosClientes(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Criar um objeto que receberá os dados JavaBeans
			ArrayList<Clientes> listacli = dao.listarClientes();
			// Encaminhar a lista ao documento novacid. Deve ir para a página novacid
			request.setAttribute("clientes", listacli);
			RequestDispatcher rd = request.getRequestDispatcher("novocli.jsp");
			rd.forward(request, response);
		}
		
		// Listar cliente para editar
		protected void listarCliente(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Query String retorna "selecionado=id" - Foi realizado desta forma pois
			// getParameter retornava somente null
			String textoQuery = request.getQueryString();
			System.out.println(textoQuery);
			// Remover "selecionado=" da string
			String idcli = textoQuery.replace("selecionado=", "");;
			// Setar a variável JavaBeans
			cliente.setIdcli(idcli);
			// Executar o método selecionarCidade (DAO)
			dao.selecionarCliente(cliente);
			// Setar os atributos do formulário com o conteúdo JavaBeans
			request.setAttribute("idcli", cliente.getIdcli());
			request.setAttribute("cli", cliente.getNomecli());
			request.setAttribute("cpf", cliente.getCpf());
			request.setAttribute("empr", cliente.getNomeemp());
			request.setAttribute("cnpj", cliente.getCnpj());
			request.setAttribute("tel1", cliente.getTel1());
			request.setAttribute("tel2", cliente.getTel2());
			
			// Encaminhar ao documento editarcli.jsp
			RequestDispatcher rd = request.getRequestDispatcher("editarcli.jsp");
			rd.forward(request, response);
		}
		
		// Editar cliente
		protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Setar as variáveis JavaBeans
			cliente.setIdcli(request.getParameter("idcli"));
			cliente.setNomecli(request.getParameter("cli"));
			cliente.setNomeemp(request.getParameter("empr"));
			cliente.setCpf(request.getParameter("cpf"));
			cliente.setCnpj(request.getParameter("cnpj"));
			cliente.setTel1(request.getParameter("tel1"));
			cliente.setTel2(request.getParameter("tel2"));
			// Executar o método alterarCidade()
			dao.alterarCliente(cliente);
			// Redirecionar para o documento novacid.jsp atualizando as alterações
			response.sendRedirect("novocli");
		}
		
		// Excluir cliente
		protected void removerCliente(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Recebendo Query selecionado2=? e removendo a parte selecionado2= para obter ?
			String idcli = request.getQueryString().replace("selecionado2=", "");
			// Recebimento do id da cidade que será excluída (confirmador.js)
			cliente.setIdcli(idcli);
			// Executar o método deletar cidade
			dao.deletarCliente(cliente);
			// Redirecionar para o documento novacid.jsp atualizando as alterações
			response.sendRedirect("novocli");
		}
		
}
