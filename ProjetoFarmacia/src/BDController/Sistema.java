package BDController;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Sistema {
	private Connection connection=null;
	private java.sql.Statement statement=null;
	private ResultSet resultset=null;
	
	public void conectar() {
		String servidor = "jdbc:mysql://localhost/farmacia";
		String usuario = "root";
		String senha = "mysql";
		String driver="com.mysql.cj.jdbc.Driver";
	
		try{
			Class.forName(driver);
			this.connection=DriverManager.getConnection(servidor,usuario,senha);
			this.statement=this.connection.createStatement();
		}catch (Exception e){
			System.out.println("Error:"+e.getMessage());
		}
		
	}
	
	public boolean estaConectado() {
		if(this.connection !=null) {
			return true; 
		}else{
			return false;
		}
	}
	
	
	public ArrayList<String[]> getClientes(){

		try {
		//tratando a exceção do nosso retorno do slect
		
		String query="select idClientes, nome, email, cpf, tel from cliente;";
		this.resultset=this.statement.executeQuery(query);
		this.statement=this.connection.createStatement(); 
		
		
		ArrayList<String[]> lista = new ArrayList<String[]>();
		//criar laço de repetição
		while(this.resultset.next()) {
			String[] list = {resultset.getString("idClientes"), resultset.getString("nome"), resultset.getString("email"), resultset.getString("cpf"), resultset.getString("tel")};
			lista.add(list);
		}
		
		return lista;
		
		} catch(Exception e) {
		System.out.println("Error"+e.getMessage());
		return null;
		}
			
	}
	
	public ArrayList<String[]> getClientesPesquisar(String forma, String input){

		try {
		//tratando a exceção do nosso retorno do slect
		
		toString();
		
		input = "%" + input + "%";
		String query = String.format("select idClientes, nome, email, cpf, tel from cliente where %s like \"%s\";", forma, input);
		this.resultset=this.statement.executeQuery(query);
		this.statement=this.connection.createStatement(); 
		
		
		ArrayList<String[]> lista = new ArrayList<String[]>();
		//criar laço de repetição
		while(this.resultset.next()) {
			String[] list = {resultset.getString("idClientes"), resultset.getString("nome"), resultset.getString("email"), resultset.getString("cpf"), resultset.getString("tel")};
			lista.add(list);
		}
		
		return lista;
		
		} catch(Exception e) {
		System.out.println("Error"+e.getMessage());
		return null;
		}
			
	}
	
	
	public String[] getClienteID (String id){
		try {
			String query="select idClientes, nome, email, cpf, tel from cliente where idClientes="+id+";";
			this.resultset=this.statement.executeQuery(query);
			this.statement=this.connection.createStatement();
			this.resultset.next();
			String[] cliente = {resultset.getString("idClientes"), resultset.getString("nome"), resultset.getString("email"), resultset.getString("cpf"), resultset.getString("tel")};
			
			return cliente;
		} catch(Exception e) {
			System.out.println("Error"+e.getMessage());
			return null;
		}

	}
	
	public String[] getClienteEmail (String email){
		try {
			toString();
			String query = String.format("select idClientes, nome, email, cpf, tel from cliente where email=\"%s\";", email);
			this.resultset=this.statement.executeQuery(query);
			this.statement=this.connection.createStatement();
			this.resultset.next();
			String[] cliente = {resultset.getString("idClientes"), resultset.getString("nome"), resultset.getString("email"), resultset.getString("cpf"), resultset.getString("tel")};
			
			return cliente;
		} catch(Exception e) {
			System.out.println("Error"+e.getMessage());
			return null;
		}
	}
		
	
	public String[] getClienteCPF(String cpf){
		try {
			toString();
			String query = String.format("select idClientes, nome, email, cpf, tel from cliente where cpf=\"%s\";", cpf);
			this.resultset=this.statement.executeQuery(query);
			this.statement=this.connection.createStatement();
			this.resultset.next();
			String[] cliente = {resultset.getString("idClientes"), resultset.getString("nome"), resultset.getString("email"), resultset.getString("cpf"), resultset.getString("tel")};
			
			return cliente;
		} catch(Exception e) {
			System.out.println("Error"+e.getMessage());
			return null;
		}
	}
	
	public void postToClientes(String idClientes, String nomeCliente, String cpfCliente, String telCliente, String emailCliente) {
		try {
			if(nomeCliente.trim().equals("") || cpfCliente.trim().equals("") || telCliente.trim().equals("") ||emailCliente.trim().equals("") ){
				System.out.println("Cliente não cadastrado");
			}else {
				String query="Insert into cliente (idClientes, nome, email, cpf, tel) values (null, '"+nomeCliente+"','"+emailCliente+"','"+cpfCliente+"','"+telCliente+"');";
				System.out.println(query);
				this.statement.executeUpdate(query);
			}	
			
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	//NÃO ENCOSTA - INÍCIO
	public void postToEndereco(String idEndereco, String logradouro, String numero, String complemento, String bairro, String cidade, String cep, String uf) {
		
		try {
			if(logradouro.trim().equals("") || numero.trim().equals("") || bairro.trim().equals("") ||  cidade.trim().equals("") ||  
			   cep.trim().equals("") || uf.trim().equals("")){
				System.out.println("Endereço não cadastrado");
			}else {
	            String query = "select max(idClientes) from cliente";
	            this.resultset = this.statement.executeQuery(query);
	            this.statement = this.connection.createStatement();
	            this.resultset.next();
	            String maxID= resultset.getString("max(idClientes)");
	            int lastID= Integer.parseInt(maxID);
	            String query2="Insert into endereco (idEndereco, logradouro, numero, complemento, bairro, cidade, cep, uf, Cliente_idClientes) values (null, '"+logradouro+"','"+numero+"','"+complemento+"','"+bairro+"','"+cidade+"','"+cep+"', '"+uf+"', '"+lastID+"');";
				System.out.println(query2);
				this.statement.executeUpdate(query2);	
			}		
		}catch(Exception e){
				System.out.println("Error: "+e.getMessage());
			}
				
	}
	
	//FIM - PRONTO
	
	/*
	public void updateClientes(String id, String contatos) {
		try {
			//linha de execução da sintaxe de update em SQL
			String query="update cliente set clientes=('"+clientes+"') where id=('"+id+"');";
			System.out.println(query);
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	public void deleteContato(String id) {
		try {
			//linha de execução da sintaxe de delete em SQL
			String query="delete from contatos where idCliente=('"+id+"');";
			System.out.println(query);
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	*/
	
	public ArrayList<String[]> getProdutos(){

		try {
		String query="select codProduto, nome, descricao, preco, estoque, flagRemedio, flagGenerico from produto;";
		this.resultset=this.statement.executeQuery(query); 
		this.statement=this.connection.createStatement(); 

		ArrayList<String[]> lista = new ArrayList<String[]>();
		//criar laço de repetição
		while(this.resultset.next()) {
			String[] list = {resultset.getString("codProduto"), resultset.getString("nome"), resultset.getString("descricao"), resultset.getString("preco"), resultset.getString("estoque"), resultset.getString("flagRemedio"), resultset.getString("flagGenerico")};
			lista.add(list);
		}
		
		return lista;
		
		} catch(Exception e) {
		System.out.println("Error"+e.getMessage());
		return null;
		}
			
	}
	
	public void postPedido(String idCompra, String idCliente, String idProduto, String Data, String valor_unico, String qtd, String desconto, String valor_final) {
		try {
			String query="Insert into compra (null, idCliente, idProduto, Data, valor_unico, qtd, desconto, valor_final) values (null, '"+idCliente+"','"+idProduto+"','"+Data+"','"+valor_unico+"','"+qtd+"','"+desconto+"', '"+valor_final+"');";
			System.out.println(query);
			this.statement.executeUpdate(query);
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	
}
