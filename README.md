<h1 align="center">Primeiro desafio - if (black){code()} </h1>

## Sobre o projeto 🔎:

<p align="justify">Este projeto trata-se de um desafio realizado durante o programa If black, then code realizado pela Gama Academy em parceria com a IBM.</p>

<p align="justify">O objetivo do projeto foi construir uma API para uma loja fictícia "Tudo de bom", em que permite realizar a inserção de novos clientes, incluindo dados pessoais e de contato, além de um controle de estoque e também a visualização do histórico de transações realizadas.</p>

## Endpoints:

#### a. Construção do diagrama DER E MER:

![](./ProjetoFarmacia/banco%20de%20dados/MER.sql.png)

<p align="justify">Aqui nós construímos o diagrama de entidade relacionamento para descrever as entidades envolvidas no processo, com seus atributos e como elas se relacionam entre si. Após isso, obtivemos o Modelo de Entidade Relacionamento, conforme abaixo: </p>

```
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema farmacia
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema farmacia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `farmacia` DEFAULT CHARACTER SET utf8 ;
USE `farmacia` ;

-- -----------------------------------------------------
-- Table `farmacia`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmacia`.`cliente` (
  `idClientes` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `tel` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idClientes`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE,
  UNIQUE INDEX `tel_UNIQUE` (`tel` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 38
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `farmacia`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmacia`.`produto` (
  `codProduto` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `descricao` TEXT NULL DEFAULT NULL,
  `preco` DOUBLE NULL DEFAULT NULL,
  `estoque` INT NULL DEFAULT NULL,
  `flagRemedio` VARCHAR(1) NULL DEFAULT NULL,
  `flagGenerico` VARCHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`codProduto`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `farmacia`.`compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmacia`.`compra` (
  `idCompra` INT NOT NULL AUTO_INCREMENT,
  `Cliente_idClientes` INT NULL DEFAULT NULL,
  `produto` INT NULL DEFAULT NULL,
  `data` VARCHAR(12) NULL DEFAULT NULL,
  `valor_unit` DOUBLE NULL DEFAULT NULL,
  `desconto` DOUBLE NULL DEFAULT NULL,
  `valor_final` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`idCompra`),
  INDEX `fk_compra_Cliente1_idx` (`Cliente_idClientes` ASC) VISIBLE,
  INDEX `fk_compra_codProduto` (`produto` ASC) VISIBLE,
  CONSTRAINT `fk_compra_Cliente1`
    FOREIGN KEY (`Cliente_idClientes`)
    REFERENCES `farmacia`.`cliente` (`idClientes`),
  CONSTRAINT `fk_compra_codProduto`
    FOREIGN KEY (`produto`)
    REFERENCES `farmacia`.`produto` (`codProduto`))
ENGINE = InnoDB
AUTO_INCREMENT = 43
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `farmacia`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmacia`.`endereco` (
  `idEndereco` INT NOT NULL AUTO_INCREMENT,
  `logradouro` VARCHAR(45) NULL DEFAULT NULL,
  `numero` INT NULL DEFAULT NULL,
  `complemento` VARCHAR(45) NULL DEFAULT NULL,
  `bairro` VARCHAR(45) NULL DEFAULT NULL,
  `cidade` VARCHAR(45) NULL DEFAULT NULL,
  `cep` VARCHAR(10) NULL DEFAULT NULL,
  `uf` VARCHAR(2) NULL DEFAULT NULL,
  `Cliente_idClientes` INT NOT NULL,
  PRIMARY KEY (`idEndereco`),
  INDEX `fk_Endereco_Cliente1_idx` (`Cliente_idClientes` ASC) VISIBLE,
  CONSTRAINT `fk_Endereco_Cliente1`
    FOREIGN KEY (`Cliente_idClientes`)
    REFERENCES `farmacia`.`cliente` (`idClientes`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `farmacia`.`itenspedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmacia`.`itenspedidos` (
  `num_sequencial` INT NOT NULL,
  `compra_idCompra` INT NOT NULL,
  `Produto_codProduto` INT NOT NULL,
  `quantidade` INT NULL DEFAULT NULL,
  `valor_unico` DOUBLE NULL DEFAULT NULL,
  `valor_total` SMALLINT GENERATED ALWAYS AS ((`quantidade` * `valor_unico`)) VIRTUAL,
  PRIMARY KEY (`num_sequencial`),
  INDEX `fk_compra_has_Produto_Produto1_idx` (`Produto_codProduto` ASC) VISIBLE,
  INDEX `fk_compra_has_Produto_compra1_idx` (`compra_idCompra` ASC) VISIBLE,
  CONSTRAINT `fk_compra_has_Produto_compra1`
    FOREIGN KEY (`compra_idCompra`)
    REFERENCES `farmacia`.`compra` (`idCompra`),
  CONSTRAINT `fk_compra_has_Produto_Produto1`
    FOREIGN KEY (`Produto_codProduto`)
    REFERENCES `farmacia`.`produto` (`codProduto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


```


#### b. GET, PUT, POST, DELETE:

<p align="justify">Na parte de back-end, utilizamos métodos para realizar o CRUD dentro do banco de dados.</p>

<p align="justify">Método para dar get na tabela de clientes no banco de dados: </p>


```
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
	
```

<p align="justify">Além do get na tabela clientes foi necessário inserir os dados de indereço, para isso, usamos:</p>

```
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

```
<p align="justify">Para relizar a leitura dos dados da tabela de Clientes, utilizamos alguns métodos que nos permitem pesquisar os dados dos clientes pelo nome, cpf, email ou id. </p>

```
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
```

#### c. Histórico de transações entre contas

<p align="justify">Utilizamos um ArrayList para obter os dados da lista de transações, através de dados obtido em outras tabelas. </p>


```
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
	
```
#### d. Controle de estoque

<p align="justify">Aqui o método realiza alteração no estoque de produtos ao mesmo tempo em que a compra é confirmada.</p>

```
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
```

#### e. Desconto para medicamentos genéricos

<p align="justify">Utilizamos as flags para identificar os produtos que são medicamento e os que são genéricos, dessa forma podendo aplicar os 20% de desconto, conforme solicitado. </p>

```
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
```


## Layout final do projeto 🖼️:


## Autores 👨‍🎨:

O projeto foi realizado pela equipe 07, composta pelos suuuuper integrantes:

Evaldo Fonseca, Lucas Araújo, Ricardo Lima e Thiago Conceição. 

