package BDController;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CepAuto {
	public static StringBuilder getCep(String intoCep) throws Exception {
		String parseURL = String.format("https://viacep.com.br/ws/%s/json/", intoCep);
		URL url = new URL(parseURL);
		URLConnection connection = url.openConnection();
		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		String cep = "";
		StringBuilder jsonCep = new StringBuilder();
		while((cep = br.readLine()) != null) {
			if (!cep.strip().equals("{") || !cep.strip().equals("}")) {
//				jsonCep.append(cep);
//				String array[] = new String[100];
//				array = cep.split(":");
//				System.out.println(array[1]);
						
			}
		}
		
		return jsonCep;
		
	}
}
