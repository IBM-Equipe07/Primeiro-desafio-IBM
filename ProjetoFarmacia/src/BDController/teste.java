package BDController;

public class teste {
	public static void main(String[] args) throws Exception {
//		StringBuilder cep = CepAuto.getCep("41330095");
//		
		Sistema executar = new Sistema();
		executar.conectar();
//		
//		ArrayList<String[]> lista = executar.getClientes();
//		
//		for(String[] p :lista) {
//			System.out.println(p[0]+ " " + p[1] + " " + p[2]);
//		}
		
		String[] pessoa = executar.getClienteCPF("142.456.789.14");
		if(pessoa != null) {
			System.out.println(pessoa[0] + " " + pessoa[1]);
		} else {
			System.out.println("VAZIO");
		}
		
	}
}
