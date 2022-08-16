package core;
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
		String senha = "Lag03/12/2003";
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
	
	//Criando o metódo para fazer a consulta de dados em SQL para trazer os registros
	public void listaClientes(){
		System.out.println("\tLISTA DE CLIENTES");
		try {
		//tratando a exceção do nosso retorno do slect
		String query="select c.idCliente,c.nomeCliente,c.cpfCliente,c.telCliente,c.emailCliente,e.rua,e.bairro,e.cidade,e.estado,e.clientes_idCliente\r\n"
				+ "from\r\n"
				+ "clientes as c,\r\n"
				+ "endereço as e\r\n"
				+ "where(c.idCliente=e.clientes_idCliente)";
		this.resultset=this.statement.executeQuery(query);
		this.statement=this.connection.createStatement(); 
		
		//criar laço de repetição
		while(this.resultset.next()) {
			String id = resultset.getString("idCliente");
			String nome = resultset.getString("nomeCliente"); 
			String cpf = resultset.getString("cpfCliente");
			String tel = resultset.getString("telCliente");
			String logradouro = resultset.getString("logradouro");
			String numero = resultset.getString("numero");
			String bairro = resultset.getString("bairro");
			String cidade = resultset.getString("cidade");
			String uf = resultset.getString("uf");
		
			System.out.println("************DADOS*************");
			System.out.println("Código do cliente: "+ id);
			System.out.println("Nome: "+ nome);
			System.out.println("Cpf: "+ cpf);
			System.out.println("Telefone: "+ tel);
			System.out.println("***********ENDEREÇO***********");
			System.out.println("Logradouro: "+logradouro);
			System.out.println("Numero: "+numero);
			System.out.println("Bairro: "+bairro);
			System.out.println("Cidade: "+cidade);
			System.out.println("U.F.: "+uf);
			
			
		}
	}catch(Exception e) {
		System.out.println("Error"+e.getMessage());
	}
		
		
		
	}
	
	
	public void inserirClientes(String nomeCliente, String cpfCliente, String telCliente, String emailCliente) {
		try {
			if(nomeCliente.trim().equals("") || cpfCliente.trim().equals("") || telCliente.trim().equals("") ||emailCliente.trim().equals("") ){
				System.out.println("Cliente não cadastrado");
			}else {
				String query="Insert into cliente (nome, email, cpf, tel) values ('"+nomeCliente+"','"+emailCliente+"','"+cpfCliente+"','"+telCliente+"');";
				System.out.println(query);
				this.statement.executeUpdate(query);
			}		
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
			
		} 
	}
	public void inserirEndereco(String logradouro, String numero, String complemento, String bairro, String cidade, String cep, String uf, String Cliente_idClientes) {
		try {
			if(logradouro.trim().equals("") || numero.trim().equals("") || bairro.trim().equals("") ||  cidade.trim().equals("") ||  
			   cep.trim().equals("") ||   uf.trim().equals("") ||  Cliente_idClientes.trim().equals("")){
				System.out.println("Cliente não cadastrado");
			}else {
				String query="Insert into cliente (logradouro, numero, complemento, bairro, cidade, cep, uf, Cliente_idClientes) values ('"+logradouro+"','"+numero+"','"+complemento+"','"+bairro+"','"+cidade+"','"+cep+"', '"+uf+"','"+Cliente_idClientes+"');";
				System.out.println(query);
				this.statement.executeUpdate(query);
			}		
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
			
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
        
        
        
        
    }catch(Exception e) {
        System.out.println("Error"+e.getMessage());
    }
        return null;    
        
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
    
	/*
	public void deleteContato(String id) {
		try {
			//linha de execução da sintaxe de delete em SQL
			String query="delete from contatos where id=('"+id+"');";
			System.out.println(query);
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}*/

}
