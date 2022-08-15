

public class BancoDeDados {

	public static void main(String[] args) {
		Sistema executar = new Sistema();
		executar.conectar();
		
		if(executar.estaConectado()) { 
			//permite chamar a opção read do CRUD
			//executar.listaClientes();
			
			//Permite chamar a opção Insert do CRUD
			//executar.inserirClientes("Ricardo Lima","047.869.155-77","71 98299-4249","ricardo@gmail.com");
			
			//Chamando opção upadate do CRUD
			//sintaxeBanco.updateContato("32", "Samira Pereira");
			
			//Chamando opção delete do CRUD
			//sintaxeBanco.deleteContato("21");
			System.out.println("Conexão com o banco de dados foi com êxito.");
		}else {
			System.out.println("Não foi possível conectar ao banco de dados");
		}
	}

}
