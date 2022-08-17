package BDController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Sistema {
	private Connection connection=null;
	private java.sql.Statement statement=null;
	private ResultSet resultset=null;
	

	// passagem de parametros para o conexao do banco de dados
	public void conectar() {
		//Criação da variável para se conetarr o dataBase
		String servidor = "jdbc:mysql://localhost/farmacia";
		//Usuário do banco de dados
		String usuario = "root";
		//Senha do usuário do banco de dados
		String senha = "admin";
		//Vinculando o driver de conexão
		String driver="com.mysql.cj.jdbc.Driver";
		
		//Permite verificar o tratamento da exceção caso o banco de dados falhar
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
	
	
	public void AlterarEndereco(int Cliente_idClientes, String logradouro, String numero, String complemento, String bairro, String cidade, String cep, String uf) {
        // Alterar pelos campos do banco de dados, após fazer a classe conexao.java
        try {
            String query = "update endereco set logradouro = '"+logradouro+"', numero = '"+numero+"', complemento = '"+complemento+"', bairro = '"+bairro+"', cidade = '"+cidade+"', cep = '"+cep+"', uf = '"+uf+"' where idEndereco = '" + Cliente_idClientes + "';";

            System.out.println(query);
            this.statement.executeUpdate(query);

        }catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
	
	
	public void AlterarClientes(int id, String nome, String cpf, String telefone, String email) {
		// Alterar pelos campos do banco de dados, após fazer a classe conexao.java
		try {
			String query = "update cliente set nome = '"+nome+"', cpf = '"+cpf+"', tel = '"+telefone+"', email = '"+email+"' where idClientes = '" + id + "';";
			
			System.out.println(query);
			this.statement.executeUpdate(query);

		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void DeletarClientes(int id) {
		// Alterar pelos campos do banco de dados, após fazer a classe conexao.java
		try {
			String query = "delete from cliente where idClientes = '" + id + "';";
			
			System.out.println(query);
			this.statement.executeUpdate(query);

		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	
	//Criando o metódo para fazer a consulta de dados em SQL para trazer os registros
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
			return null;
		}

	}
	
	
	public String[] getEnderecoID (String id){
		try {
			String query="select logradouro, numero, complemento, bairro, cidade, cep, uf from endereco where idEndereco="+id+";";
			this.resultset=this.statement.executeQuery(query);
			this.statement=this.connection.createStatement();
			this.resultset.next();
			String[] cliente = {resultset.getString("logradouro"), resultset.getString("numero"), resultset.getString("complemento"), resultset.getString("bairro"), resultset.getString("cidade"), resultset.getString("cep"), resultset.getString("uf")};
			
			return cliente;
		} catch(Exception e) {
			return null;
		}

	}
	
	public String[] getClienteNome (String nome){
		try {
			String query = String.format("select idClientes, nome, email, cpf, tel from cliente where nome like \"%s\";", nome);
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
	
	public ArrayList<String[]> getProdutoForNome (String nome){
		try {
			toString();
			nome = "%" + nome + "%";
			String query=String.format("select codProduto, nome, descricao, preco, estoque, flagRemedio, flagGenerico from produto where nome=\"%s\";", nome);
			this.resultset=this.statement.executeQuery(query);
			this.statement=this.connection.createStatement();
			ArrayList<String[]> lista = new ArrayList<String[]>();
			while(this.resultset.next()) {
				String[] produto = {resultset.getString("codProduto"), resultset.getString("nome"), resultset.getString("descricao"), resultset.getString("preco"), resultset.getString("estoque"), resultset.getString("flagRemedio"), resultset.getString("flagGenerico")};
				lista.add(produto);
			}
				return lista;
				
		} catch(Exception e) {
			System.out.println("Error"+e.getMessage());
			return null;
		}

	}
	
	public String getProdutoNomeID (String id){
		try {
			String query="select nome from produto where codProduto="+id+";";
			this.resultset=this.statement.executeQuery(query);
			this.statement=this.connection.createStatement();
			this.resultset.next(); 
			String nome= resultset.getString("nome");
			return nome;
		} catch(Exception e) {
			System.out.println("Error"+e.getMessage());
			return null;
		}

	}
	
	public String getProdutoPrecoID (String id){
		try {
			String query="select preco from produto where codProduto="+id+";";
			this.resultset=this.statement.executeQuery(query);
			this.statement=this.connection.createStatement();
			this.resultset.next();
			String preco= resultset.getString("preco");
			return preco;
		} catch(Exception e) {
			System.out.println("Error"+e.getMessage());
			return null;
		}

	}
	
	
	public String getProdutoPrecoDescontoID (String id){ 
		try {
			String query="select preco from produto where codProduto="+id+" and flagRemedio='s' and flagGenerico='s';";
			this.resultset=this.statement.executeQuery(query);
			this.statement=this.connection.createStatement();
			this.resultset.next();
			String preco= resultset.getString("preco");
			double precoInt= Double.parseDouble(preco);
			double precoDesconto = precoInt * 0.2;
			toString();
			String preco_desconto = String.format("%.2f", precoDesconto);
			String precoDesc = String.valueOf(preco_desconto);
			return precoDesc;
		} catch(Exception e) {
			System.out.println("Error"+e.getMessage());
			return null;
		}
	}
	
	public String getProdutoPrecoFinalID (String id){ 
		try {
			String query="select preco from produto where codProduto="+id+" and flagRemedio='s' and flagGenerico='s';";
			this.resultset=this.statement.executeQuery(query);
			this.statement=this.connection.createStatement();
			this.resultset.next();
			String preco= resultset.getString("preco");
			double precoInt= Double.parseDouble(preco);
			double precoDesconto = precoInt - (precoInt * 0.2);
			String precoDesc = String.valueOf(precoDesconto);
			return precoDesc;
		} catch(Exception e) {
			System.out.println("Error"+e.getMessage());
			return null;
		}

	}
	
	public void postPedido(String Cliente_idClientes, String produto, String data, String valor_unit, String desconto, String valor_final) {
		try {
			int Clientes_idClientes2 = Integer.parseInt(Cliente_idClientes);
			int produto2 = Integer.parseInt(produto);
			double valor_unit2 = Double.parseDouble(valor_unit);
			double desconto2 = Double.parseDouble(desconto);
			double valor_final2 = Double.parseDouble(valor_final);
			String query="Insert into compra (Cliente_idClientes, produto, data, valor_unit, desconto, valor_final) values ('"+Clientes_idClientes2+"','"+produto2+"','"+data+"','"+valor_unit2+"','"+desconto2+"', '"+valor_final2+"');";
			System.out.println(query);
			this.statement.executeUpdate(query);
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public String getCodCompra(String id) {
		
		try {
	        String query = "select max(idCompra) from compra";
	        this.resultset = this.statement.executeQuery(query);
	        this.statement = this.connection.createStatement();
	        this.resultset.next();
	        String maxID= resultset.getString("max(idCompra)");
	        return maxID;      
		}catch(Exception e){
				System.out.println("Error: "+e.getMessage());
				
			}
		return null;
					
	}
	
	public String getPrecoCompra(String id){ 
		try {
			String query="select valor_final from compra where idCompra="+id+";";
			this.resultset=this.statement.executeQuery(query);
			this.statement=this.connection.createStatement();
			this.resultset.next();
			String preco_total= resultset.getString("valor_final");
			return preco_total;
		} catch(Exception e) {
			System.out.println("Error"+e.getMessage());
			return null;
		}

	}
	
	public boolean postCompra(String num_sequencial, String compra_idCompra, String Produto_codProduto, String quantidade, String valor_unico) {
		try {
			String query = "select estoque from produto where codProduto="+Produto_codProduto+";";
            this.resultset = this.statement.executeQuery(query);
            this.statement = this.connection.createStatement();
            this.resultset.next();
            String estoque= resultset.getString("estoque");
            int estoqueProd= Integer.parseInt(estoque);
            int num_sequencial2 = Integer.parseInt(num_sequencial);
			int compra_idCompra2 = Integer.parseInt(compra_idCompra);
			int Produto_codProduto2 = Integer.parseInt(Produto_codProduto);
			int quantidade2 = Integer.parseInt(quantidade);
			double valor_unico2 = Double.parseDouble(valor_unico);
			if(estoqueProd>=quantidade2) {
				String query2="Insert into itenspedidos (num_sequencial, compra_idCompra, Produto_codProduto, quantidade, valor_unico) values ('"+num_sequencial2+"','"+compra_idCompra2+"','"+Produto_codProduto2+"','"+quantidade2+"','"+valor_unico2+"');";
				System.out.println(query2);
				this.statement.executeUpdate(query2);
				int novoEstoque = estoqueProd - quantidade2;
				String query3="update produto set estoque="+novoEstoque+" where codProduto="+Produto_codProduto+";";
				System.out.println(query3);
				this.statement.executeUpdate(query3);
				return true;	
			}else {
				System.out.println("Estoque insuficiente!");
				return false;
			}
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
		return false;
	}
	
	public ArrayList<String[]> getTransacoes(){

		try {
		String query="select f.num_sequencial, c.idClientes, c.cpf, c.nome,f.Produto_codProduto, i.nome, f.quantidade, p.valor_unit, f.valor_unico, f.valor_total\r\n"
				+ "from\r\n"
				+ "cliente as c,\r\n"
				+ "produto as i, \r\n"
				+ "compra as p,\r\n"
				+ "itenspedidos as f\r\n"
				+ "where c.idClientes = p.Cliente_idClientes and i.codProduto=p.produto and p.idCompra=f.compra_idCompra;";
		this.resultset=this.statement.executeQuery(query); 
		this.statement=this.connection.createStatement();
		ArrayList<String[]> lista = new ArrayList<String[]>();
		while(this.resultset.next()) {
			String[] list = {resultset.getString("f.num_sequencial"), resultset.getString("c.idClientes"), resultset.getString("c.cpf"), resultset.getString("c.nome"), 
					resultset.getString("f.Produto_codProduto"), resultset.getString("i.nome"), resultset.getString("f.quantidade"), resultset.getString("p.valor_unit"), resultset.getString("f.valor_unico"), 
					resultset.getString("f.valor_total")};
			lista.add(list);
			System.out.println(list[0]+" "+list[1]+" "+list[2]+" "+list[3]+" "+list[4]+" "+list[5]+" "+list[6]+" "+list[7]+ " "+list[8]+" "+list[9]);
		}
		return lista;
		} catch(Exception e) {
		System.out.println("Error"+e.getMessage());
		return null;
		}
		
	
	}

}
