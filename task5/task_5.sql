-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema MyShop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema MyShop
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `MyShop` ;
CREATE SCHEMA IF NOT EXISTS `MyShop` ;
USE `MyShop` ;

-- -----------------------------------------------------
-- Table `MyShop`.`Suppliers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyShop`.`Suppliers` (
  `SupplierID` INT NOT NULL AUTO_INCREMENT,
  `SupplierName` VARCHAR(45) NULL,
  `City` VARCHAR(20) NULL,
  `Country` VARCHAR(20) NULL,
  PRIMARY KEY (`SupplierID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MyShop`.`Categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyShop`.`Categories` (
  `CategoryID` INT NOT NULL AUTO_INCREMENT,
  `CategoryName` VARCHAR(20) NULL,
  `Description` VARCHAR(100) NULL,
  PRIMARY KEY (`CategoryID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MyShop`.`Products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyShop`.`Products` (
  `ProductID` INT NOT NULL AUTO_INCREMENT,
  `ProductName` VARCHAR(45) NULL,
  `SupplierID` INT NOT NULL,
  `CategoryID` INT NOT NULL,
  `Price` DECIMAL(10,2) NULL,
  PRIMARY KEY (`ProductID`, `SupplierID`, `CategoryID`),
  INDEX `fk_Products_Suppliers_idx` (`SupplierID` ASC) VISIBLE,
  INDEX `fk_Products_Categories1_idx` (`CategoryID` ASC) VISIBLE,
  CONSTRAINT `fk_Products_Suppliers`
    FOREIGN KEY (`SupplierID`)
    REFERENCES `MyShop`.`Suppliers` (`SupplierID`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Products_Categories1`
    FOREIGN KEY (`CategoryID`)
    REFERENCES `MyShop`.`Categories` (`CategoryID`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

INSERT INTO `MyShop`.`Products`(`ProductID`, `ProductName`, `SupplierID`, `CategoryID`, `Price`) VALUES(1, 'Chais', 1, 1, 18.00);
INSERT INTO `MyShop`.`Products`(`ProductID`, `ProductName`, `SupplierID`, `CategoryID`, `Price`) VALUES(2, 'Chang', 1, 1, 19.00);
INSERT INTO `MyShop`.`Products`(`ProductID`, `ProductName`, `SupplierID`, `CategoryID`, `Price`) VALUES(3, 'Aniseed Syrup', 1, 2, 10.00);
INSERT INTO `MyShop`.`Products`(`ProductID`, `ProductName`, `SupplierID`, `CategoryID`, `Price`) VALUES(4, 'Chef Anton’s Cajun Seasoning', 2, 2, 22.00);
INSERT INTO `MyShop`.`Products`(`ProductID`, `ProductName`, `SupplierID`, `CategoryID`, `Price`) VALUES(5, 'Chef Anton’s Gumbo Mix', 2, 2, 21.35);

INSERT INTO `MyShop`.`Suppliers`(`SupplierID`, `SupplierName`, `City`, `Country`) VALUES(1, 'Exotic Liquid', 'London', 'UK');
INSERT INTO `MyShop`.`Suppliers`(`SupplierID`, `SupplierName`, `City`, `Country`) VALUES(2, 'New Orleans Cajun Delights', 'New Orleans','USA');
INSERT INTO `MyShop`.`Suppliers`(`SupplierID`, `SupplierName`, `City`, `Country`) VALUES(3, 'Grandma Kelly’s Homestead','Ann Arbor', 'USA');
INSERT INTO `MyShop`.`Suppliers`(`SupplierID`, `SupplierName`, `City`, `Country`) VALUES(4, 'Tokyo Traders', 'Tokyo', 'Japan');
INSERT INTO `MyShop`.`Suppliers`(`SupplierID`, `SupplierName`, `City`, `Country`) VALUES(5, 'Cooperativa de Quesos ‘Las Cabras’', 'Oviedo', 'Spain');

INSERT INTO `MyShop`.`Categories`(`CategoryID`, `CategoryName`, `Description`) VALUES(1, 'Beverages', 'Soft drinks, coffees, teas, beers, and ales');
INSERT INTO `MyShop`.`Categories`(`CategoryID`, `CategoryName`, `Description`) VALUES(2, 'Condiments', 'Sweet and savory sauces, relishes, spreads, and seasonings');
INSERT INTO `MyShop`.`Categories`(`CategoryID`, `CategoryName`, `Description`) VALUES(3, 'Confections', 'Desserts, candies, and sweet breads');
INSERT INTO `MyShop`.`Categories`(`CategoryID`, `CategoryName`, `Description`) VALUES(4, 'Dairy Products', 'Cheeses');
INSERT INTO `MyShop`.`Categories`(`CategoryID`, `CategoryName`, `Description`) VALUES(5, 'Grains/Cereals', 'Breads, crackers, pasta, and cereal');

-- Select product with product name that begins with ‘C’
SELECT `ProductName` FROM `Products` WHERE `ProductName` LIKE 'C%';

-- Select product with the smallest price.
SELECT `ProductName` FROM `Products` WHERE `Price` = (SELECT MIN(`Price`) FROM `Products`);

-- Select cost of all products from the USA
SELECT `ProductName`, `Price` FROM `Products` WHERE `SupplierID` 
IN (SELECT `SupplierID` FROM `Suppliers` WHERE `Country` = 'USA');

-- Select suppliers that supply Condiments
SELECT `SupplierName` FROM `Suppliers` WHERE `SupplierID` 
IN (SELECT `SupplierID` FROM `Products` WHERE `CategoryID` IN (SELECT `CategoryID` FROM `Categories` WHERE `CategoryName` = 'Condiments'));

-- Add to database new supplier with name: ‘Norske Meierier’, city: ‘Lviv’, country: ‘Ukraine’ which
-- will supply new product with name: ‘Green tea’, price: 10, and related to category with name: ‘Beverages’.
INSERT INTO `Suppliers`(`SupplierName`, `City`, `Country`) VALUES ('Norske Meierier', 'Lviv', 'Ukraine');
INSERT INTO `Products`(`ProductName`, `SupplierID`, `CategoryID`, `Price`) 
VALUES('Green tea', (SELECT `SupplierID` FROM `Suppliers` WHERE `SupplierName` = 'Norske Meierier'), 
(SELECT `CategoryID` FROM `Categories` WHERE `CategoryName` = 'Beverages'), 10.00);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
