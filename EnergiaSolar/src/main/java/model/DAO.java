package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** Módulo de conexão **/
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbbmsolar?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "Bmsolar1234*";

	// Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * // Teste de conexão BD public void testeConexao() { try { Connection con =
	 * conectar(); System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); } }
	 **/

	/** CRUD CREATE **/
	public void inserirCidade(JavaBeans cidade) {
		String create = "insert into irradcid (nomecid, janeiro, fevereiro, marco, abril, maio, junho, julho, agosto, setembro, outubro, novembro, dezembro, media) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			// Abrir a conexão com o BD
			Connection con = conectar();
			// Preparar a query para execução no BD
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros '?' pelo contéudo das variáveis do JavaBeans
			pst.setString(1, cidade.getNomecid());
			pst.setString(2, cidade.getJaneiro());
			pst.setString(3, cidade.getFevereiro());
			pst.setString(4, cidade.getMarco());
			pst.setString(5, cidade.getAbril());
			pst.setString(6, cidade.getMaio());
			pst.setString(7, cidade.getJunho());
			pst.setString(8, cidade.getJulho());
			pst.setString(9, cidade.getAgosto());
			pst.setString(10, cidade.getSetembro());
			pst.setString(11, cidade.getOutubro());
			pst.setString(12, cidade.getNovembro());
			pst.setString(13, cidade.getDezembro());
			pst.setString(14, cidade.getMedia());

			// Executar query
			pst.executeUpdate();
			// Encerrar a conexão com o BD
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD READ **/
	// Utilizamos um vetor dinâmico para listar os dados (será utilizado o mesmo
	// tipo para listar as cidades
	public ArrayList<JavaBeans> listarCidades() {
		// Criando objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> cidades = new ArrayList<>();
		String read = "select * from irradcid order by nomecid";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// Variáveis para receber os dados do DB
				String idcid = rs.getString(1);
				String nomecid = rs.getString(2);
				String janeiro = rs.getString(3);
				String fevereiro = rs.getString(4);
				String marco = rs.getString(5);
				String abril = rs.getString(6);
				String maio = rs.getString(7);
				String junho = rs.getString(8);
				String julho = rs.getString(9);
				String agosto = rs.getString(10);
				String setembro = rs.getString(11);
				String outubro = rs.getString(12);
				String novembro = rs.getString(13);
				String dezembro = rs.getString(14);
				String media = rs.getString(15);

				// Populando o ArrayList
				cidades.add(new JavaBeans(idcid, nomecid, janeiro, fevereiro, marco, abril, maio, junho, julho, agosto,
						setembro, outubro, novembro, dezembro, media));
			}
			con.close();
			return cidades;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/** CRUD UPDATE **/
	// Selecionar cidade
	public void selecionarCidade(JavaBeans cidade) {
		String read2 = "select * from irradcid where idcid = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, cidade.getIdcid());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				// Setar as variáveis JavaBeans
				cidade.setIdcid(rs.getString(1));
				cidade.setNomecid(rs.getString(2));
				cidade.setJaneiro(rs.getString(3));
				cidade.setFevereiro(rs.getString(4));
				cidade.setMarco(rs.getString(5));
				cidade.setAbril(rs.getString(6));
				cidade.setMaio(rs.getString(7));
				cidade.setJunho(rs.getString(8));
				cidade.setJulho(rs.getString(9));
				cidade.setAgosto(rs.getString(10));
				cidade.setSetembro(rs.getString(11));
				cidade.setOutubro(rs.getString(12));
				cidade.setNovembro(rs.getString(13));
				cidade.setDezembro(rs.getString(14));
				cidade.setMedia(rs.getString(15));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// Editar a cidade
	public void alterarCidade(JavaBeans cidade) {
		String create = "update irradcid set nomecid=?, janeiro=?, fevereiro=?, marco=?, abril=?, maio=?, junho=?, julho=?, agosto=?, setembro=?, outubro=?, novembro=?, dezembro=?, media=? where idcid=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, cidade.getNomecid());
			pst.setString(2, cidade.getJaneiro());
			pst.setString(3, cidade.getFevereiro());
			pst.setString(4, cidade.getMarco());
			pst.setString(5, cidade.getAbril());
			pst.setString(6, cidade.getMaio());
			pst.setString(7, cidade.getJunho());
			pst.setString(8, cidade.getJulho());
			pst.setString(9, cidade.getAgosto());
			pst.setString(10, cidade.getSetembro());
			pst.setString(11, cidade.getOutubro());
			pst.setString(12, cidade.getNovembro());
			pst.setString(13, cidade.getDezembro());
			pst.setString(14, cidade.getMedia());
			pst.setString(15, cidade.getIdcid());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/** CRUD DELETE **/
	public void deletarCidade(JavaBeans cidade) {
		String delete = "delete from irradcid where idcid=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, cidade.getIdcid());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/** CRUD CREATE **/
	public void inserirCliente(Clientes cliente) {
		String create = "insert into clientes (cliente, cpf, empresa, cnpj, telefone1, telefone2) values (?, ?, ?, ?, ?, ?)";
		try {
			// Abrir a conexão com o BD
			Connection con = conectar();
			// Preparar a query para execução no BD
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros '?' pelo contéudo das variáveis do JavaBeans
			pst.setString(1, cliente.getNomecli());
			pst.setString(2, cliente.getCpf());
			pst.setString(3, cliente.getNomeemp());
			pst.setString(4, cliente.getCnpj());
			pst.setString(5, cliente.getTel1());
			pst.setString(6, cliente.getTel2());

			// Executar query
			pst.executeUpdate();
			// Encerrar a conexão com o BD
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<Clientes> listarClientes() {
		// Criando objeto para acessar a classe JavaBeans
		ArrayList<Clientes> clientes = new ArrayList<>();
		String read = "select * from clientes order by idcli";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// Variáveis para receber os dados do DB
				String idcli = rs.getString(1);
				String cliente = rs.getString(2);
				String cpf = rs.getString(3);
				String empresa = rs.getString(4);
				String cnpj = rs.getString(5);
				String telefone1 = rs.getString(6);
				String telefone2 = rs.getString(7);

				// Populando o ArrayList
				clientes.add(new Clientes(idcli, cliente, cpf, empresa, cnpj, telefone1, telefone2));
			}
			con.close();
			return clientes;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD UPDATE **/
	// Selecionar cliente
	public void selecionarCliente(Clientes cliente) {
		String read2 = "select * from clientes where idcli = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, cliente.getIdcli());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				// Setar as variáveis JavaBeans
				cliente.setIdcli(rs.getString(1));
				cliente.setNomecli(rs.getString(2));
				cliente.setCpf(rs.getString(3));
				cliente.setNomeemp(rs.getString(4));
				cliente.setCnpj(rs.getString(5));
				cliente.setTel1(rs.getString(6));
				cliente.setTel2(rs.getString(7));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// Editar a cliente
		public void alterarCliente(Clientes cliente) {
			String create = "update clientes set cliente=?, cpf=?, empresa=?, cnpj=?, telefone1=?, telefone2=? where idcli=?";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, cliente.getNomecli());
				pst.setString(2, cliente.getCpf());
				pst.setString(3, cliente.getNomeemp());
				pst.setString(4, cliente.getCnpj());
				pst.setString(5, cliente.getTel1());
				pst.setString(6, cliente.getTel2());
				pst.setString(7, cliente.getIdcli());
				pst.executeUpdate();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	
		/** CRUD DELETE **/
		public void deletarCliente(Clientes cliente) {
			String delete = "delete from clientes where idcli=?";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, cliente.getIdcli());
				pst.executeUpdate();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
}
