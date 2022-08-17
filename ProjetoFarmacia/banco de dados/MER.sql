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
AUTO_INCREMENT = 37
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `farmacia`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmacia`.`venda` (
  `idCompra` INT NOT NULL AUTO_INCREMENT,
  `Cliente_idClientes` INT NOT NULL,
  `data` DATE NULL DEFAULT NULL,
  `valor_bruto` DOUBLE NULL DEFAULT NULL,
  `desconto` DOUBLE NULL DEFAULT NULL,
  `valor_final` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`idCompra`),
  INDEX `fk_compra_Cliente1_idx` (`Cliente_idClientes` ASC) VISIBLE,
  CONSTRAINT `fk_compra_Cliente1`
    FOREIGN KEY (`Cliente_idClientes`)
    REFERENCES `farmacia`.`cliente` (`idClientes`))
ENGINE = InnoDB
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
AUTO_INCREMENT = 6
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
  `cod_Venda` INT NOT NULL,
  `venda_idCompra` INT NOT NULL,
  `produto_codProduto` INT NOT NULL,
  `qtd` INT NULL,
  `valor_unt` DOUBLE NULL,
  `valor_total` DOUBLE NULL,
  PRIMARY KEY (`cod_Venda`),
  INDEX `fk_venda_has_produto_produto1_idx` (`produto_codProduto` ASC) VISIBLE,
  INDEX `fk_venda_has_produto_venda1_idx` (`venda_idCompra` ASC) VISIBLE,
  CONSTRAINT `fk_venda_has_produto_venda1`
    FOREIGN KEY (`venda_idCompra`)
    REFERENCES `farmacia`.`venda` (`idCompra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_has_produto_produto1`
    FOREIGN KEY (`produto_codProduto`)
    REFERENCES `farmacia`.`produto` (`codProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
