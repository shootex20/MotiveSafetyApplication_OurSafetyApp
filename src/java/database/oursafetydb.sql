/* Boxuan Lu, Wenhao Liu, Daniel Quach, Azeb Amare, Parleen Deol */ 

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `oursafetydb` ;

CREATE SCHEMA IF NOT EXISTS `oursafetydb` DEFAULT CHARACTER SET latin1;
USE `oursafetydb` ;

CREATE TABLE IF NOT EXISTS `oursafetydb`.`typeLibrary` (
`typeLibrary_ID` int,
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
/* Come back to this */ 
`type` varchar(30), 
`description` varchar(55), 
`isCategory` CHAR, /*  T being true, F being false.*/ 
PRIMARY KEY (`typeLibrary_ID`)) 
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `oursafetydb`.`company` ( 
`company_ID` int, 
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`shortname` VARCHAR(30), 
`name` VARCHAR(100), 
`description` VARCHAR(255), 
`saltHash` VARCHAR(255), 
`account` VARCHAR(100), 
`industry` VARCHAR(30),  
PRIMARY KEY (`company_ID`)) 
ENGINE = InnoDB; 


CREATE TABLE IF NOT EXISTS `oursafetydb`.`person` ( 
`person_ID` int, /*PK*/  
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`firstName` VARCHAR(255), 
`lastName` VARCHAR(255), 
`dateOfBirth` date, 
`gender` CHAR(1),  
PRIMARY KEY (`person_ID`)) 
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `oursafetydb`.`companyPerson` ( 
`companyPerson_ID` int, /*PK*/ 
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`company_ID` int, /*FK*/ 
`person_ID` int, /*FK*/ 
PRIMARY KEY (`companyPerson_ID`), 
INDEX `companyPerson_company_id_fk_idx` (`company_ID` ASC),
INDEX `companyPerson_person_id_fk_idx` (`person_ID` ASC),
CONSTRAINT `companyPerson_company_id_fk`
    FOREIGN KEY (`company_ID`)
    REFERENCES `oursafetydb`.`company` (`company_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `companyPerson_person_id_fk`
    FOREIGN KEY (`person_ID`)
    REFERENCES `oursafetydb`.`person` (`person_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


/*Can use either person_id OR companyPerson_ID, this will need to be decided upon.*/
CREATE TABLE IF NOT EXISTS `oursafetydb`.`logins` (
`user_id` int AUTO_INCREMENT,
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int,
`username` varchar(30),
`password` varchar(30),
`company_ID` int,
`person_ID` int,
`isActive` CHAR,
`isAdmin` CHAR,
PRIMARY KEY (`user_ID`), 
INDEX `logins_company_id_fk_idx` (`company_ID` ASC),
INDEX `logins_person_id_fk_idx` (`person_ID` ASC),
CONSTRAINT `logins_company_id_fk`
    FOREIGN KEY (`company_ID`)
    REFERENCES `oursafetydb`.`company` (`company_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `logins_person_id_fk`
    FOREIGN KEY (`person_ID`)
    REFERENCES `oursafetydb`.`person` (`person_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `oursafetydb`.`url` ( 
`url_ID` int AUTO_INCREMENT,
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`typeLibrary_ID`  int, 
`URL` VARCHAR(255), 
PRIMARY KEY (`url_ID`), 
INDEX `fk_url_typelibrary_idx` (`typeLibrary_ID` ASC),
CONSTRAINT `fk_url_typelibrary`
    FOREIGN KEY (`typeLibrary_ID`)
    REFERENCES `oursafetydb`.`typeLibrary` (`typeLibrary_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `oursafetydb`.`manual` ( 
`manual_ID` int AUTO_INCREMENT,
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`typeLibrary_ID` int,
`parent` int,
`title` VARCHAR(30), 
`intention` VARCHAR(30), 
`overview` VARCHAR(30), 
`content` VARCHAR(30), 
PRIMARY KEY (`manual_ID`), 
INDEX `fk_manual_typelibrary_idx` (`typeLibrary_ID` ASC),
CONSTRAINT `fk_manual_typelibrary`
    FOREIGN KEY (`typeLibrary_ID`)
    REFERENCES `oursafetydb`.`typeLibrary` (`typeLibrary_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB; 


CREATE TABLE IF NOT EXISTS `oursafetydb`.`manualUse` ( 
`manualUse_ID` int AUTO_INCREMENT,
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`manual_ID` int,
`company_ID` int, 
`companyRole` int, 
`job` int, 
PRIMARY KEY (`manualUse_ID`), 
INDEX `fk_manualUse_manual_idx` (`manual_ID` ASC),
CONSTRAINT `fk_manualUse_manual`
    FOREIGN KEY (`manual_ID`)
    REFERENCES `oursafetydb`.`manual` (`manual_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `oursafetydb`.`itemClassFields` (
`itemClassFields_ID` int AUTO_INCREMENT,
`dateAdded`  date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved`  int, 
`typeLibrary_ID`  int, 
`fieldDescr`  VARCHAR(30), 
`fieldDescrType` VARCHAR(30),
PRIMARY KEY(`itemClassFields_ID`), 
INDEX `fk_itemClassFields_typelibrary_idx` (`typeLibrary_ID` ASC),
CONSTRAINT `fk_itemClassFields_typelibrary`
    FOREIGN KEY (`typeLibrary_ID`)
    REFERENCES `oursafetydb`.`typeLibrary` (`typeLibrary_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `oursafetydb`.`itemClass` ( 
`itemClass_ID` int AUTO_INCREMENT, 
`DateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`itemType` VARCHAR (50), 
`itemClassFields_ID` int, /*FK*/ 
`chargeableType` VARCHAR(30), 
`depletingType` VARCHAR(30), 
`depreactiationType` VARCHAR(30), 
PRIMARY KEY (`ItemClass_ID`), 
INDEX `fk_itemClass_itemClassFields_idx` (`itemClassFields_ID` ASC), 
CONSTRAINT `fk_itemClass_itemClassFields_ID` 
    FOREIGN KEY(`itemClassFields_ID`) 
    REFERENCES `oursafetydb`.`itemClassFields` (`itemClassFields_ID`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `oursafetydb`.`Inventory` ( 
`inventory_ID` int, 
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`item_ID` int, /*FK*/  
`company_ID` int, 
 PRIMARY KEY (`inventory_ID`), 
 INDEX `fk_inventory_item_id_idx` (`item_ID` ASC),
INDEX `fk_inventory_company_id_idx` (`company_ID` ASC),
CONSTRAINT `inventory_item_ID_fk` 
    FOREIGN KEY (`item_ID`) 
    REFERENCES `oursafetydb`.`item` (item_ID) 
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `inventory_company_ID_fk` 
    FOREIGN KEY (`company_ID`)  
    REFERENCES `oursafetydb`.`company` (`company_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `oursafetydb`.` itemClassFields` ( 
`itemClassFields_ID` int AUTO_INCREMENT, /*PK*/ 
`dateAdded`  date, 
`DateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`typeLibrary_ID` int, /*FK*/ 
`fieldDescr` VARCHAR(30), 
`fieldDescrType` VARCHAR(30), 
PRIMARY KEY(`itemClassFields_ID`), 
INDEX `fk_itemClassFields_typeLibrary_ID`(`typeLibrary_ID` ASC),
CONSTRAINT `fk_typeLibrary_typeLibrary_ID`
    FOREIGN KEY(`typeLibrary_ID`)
    REFERENCES `oursafetydb`.`typeLibrary` (`typeLibrary_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `oursafetydb`.`companyPersonPhone` ( 
`companyPersonPhone_ID` int AUTO_INCREMENT, 
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`companyPerson_ID` int, 
`phone_ID` int, 
 PRIMARY KEY (`CompanyPersonPhone_ID`), 
 INDEX `fk_companyPersonPhone_CompanyPerson_idx` (`companyPerson_ID` ASC),
 INDEX `fk_companyPersonPhone_Phone_idx` (`phone_ID` ASC),
CONSTRAINT `fk_companypersonphone_companypersonid`
    FOREIGN KEY(`companyPerson_ID`)
    REFERENCES `oursafetydb`.`companyPerson` (`companyPerson_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `fk_companypersonphone_phone`
    FOREIGN KEY(`phone_ID`)
    REFERENCES `oursafetydb`.`companyPhone` (`phone_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `oursafetydb`.`item` ( 
`item_ID` int AUTO_INCREMENT, /*PK*/ 
`dateAdded` date, 
`DateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`itemClass_ID` int, /*FK*/ 
`model` VARCHAR(30), 
`company_ID` int, /*FK*/ 
`serialNumber` VARCHAR(55), 
`purchaseDate` date,
PRIMARY KEY (`item_ID`), 
INDEX `fk_item_companyID` (`company_ID` ASC),
CONSTRAINT `fk_company_companyID`
    FOREIGN KEY (`company_ID`)
    REFERENCES `oursafetydb`.`company` (`company_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `oursafetydb`.`phone` ( 
`phone_ID` int,
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`typeLibrary_ID` int,
`countryCode` VARCHAR(10), 
`areaCode` VARCHAR(10), 
`localNumber` VARCHAR(10), 
`extension` VARCHAR(10), 
 PRIMARY KEY (`phone_ID`), 
INDEX `fk_phone_typelibrary_id_idx` (`typeLibrary_ID`),
CONSTRAINT `phone_typeLibrary_id_fk` 
    FOREIGN KEY (`typeLibrary_ID`) 
    REFERENCES `oursafetydb`.`typeLibrary` (`typeLibrary_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `oursafetydb`.`companyRelationship` (
`companyRelationship_ID` int, /*PK*/ 
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`parent` int, 
`child` int,  
`typeLibrary_ID` int, 
`company_ID` int,
PRIMARY KEY (`companyRelationship_ID`), 
INDEX `companyRelationship_typeLibrary_ID_fk _idx` (`typeLibrary_ID` ASC), 
INDEX `companyRelationship_company_ID_fk _idx` (`company_ID` ASC), 
CONSTRAINT `companyRelationship_typeLibrary_ID_fk`
    FOREIGN KEY (`typeLibrary_ID`)
    REFERENCES `oursafetydb`.`typeLibrary` (`typeLibrary_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `companyRelationship_company_ID_fk`
    FOREIGN KEY (`company_ID`)
    REFERENCES `oursafetydb`.`company` (`company_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB; 

CREATE TABLE IF NOT EXISTS `oursafetydb`.`emergencyContact` ( 
`emergencyContact_ID` int AUTO_INCREMENT, /*PK*/ 
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`person_ID` int,  /*FK*/ 
`emergencyContact` int, 
`typeLibrary_ID` int, /*FK*/ 
PRIMARY KEY(`emergencyContact_ID`), 
INDEX `fk_emergencyContact_typelibrary_idx` (`typeLibrary_ID` ASC), 
INDEX `fk_emergencyContact_personID_idx` (`person_ID` ASC),
CONSTRAINT `fk_emergencyContact_typelibrary` 
    FOREIGN KEY (`typeLibrary_ID`) 
    REFERENCES `oursafetydb`.`typeLibrary` (`typeLibrary_ID`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION,
CONSTRAINT `fk_emergencyContact_personID` 
    FOREIGN KEY (`person_ID`) 
    REFERENCES `oursafetydb`.`person` (`person_ID`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION) 
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `oursafetydb`.`addressRegion` ( 
 `addressRegion_ID` int AUTO_INCREMENT, /*PK*/ 
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`parentType` int, /*  for)*/ 
`parentID` int, /*  for)*/ 
`spaceCode` VARCHAR(10), 
PRIMARY KEY (`addressRegion_ID`)) 
ENGINE = InnoDB;

 
CREATE TABLE IF NOT EXISTS `oursafetydb`.`address` ( 
`address_ID`  int, 
`dateAdded`  date, 
`dateRemoved`  date, 
`userAdded`  int, 
`userRemoved`  int, 
`typeLibrary_ID`  int, 
`addressLine1`  VARCHAR(200), 
`addressLine2`  VARCHAR(200), 
`addressRegion_ID` int, 
`postalCode`  VARCHAR(6), 
PRIMARY KEY(`address_ID`), 
INDEX `fk_address_typelibrary_idx` (`typeLibrary_ID` ASC), 
INDEX `fk_address_addressRegion_idx` (`addressRegion_ID` ASC), 
CONSTRAINT `fk_address_typelibrary_ID` 
    FOREIGN KEY (`typeLibrary_ID`) 
    REFERENCES `oursafetydb`.`typeLibrary` (`typeLibrary_ID`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION, 
CONSTRAINT `fk_address_addressRegion_ID` 
    FOREIGN KEY (`addressRegion_ID`) 
    REFERENCES `oursafetydb`.`addressRegion` (`addressRegion_ID`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `oursafetydb`.`companyPersonAddress` ( 
`companyPersonAddress_ID` int AUTO_INCREMENT,  
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`companyPerson_ID` int, 
`address_ID` int, 
PRIMARY KEY (`companyPersonAddress_ID`), 
INDEX `fk_companyPersonAddress_companyPerson_idx` (`companyPerson_ID` ASC), 
INDEX `fk_companyPersonAddress_address_ID_idx` (`address_ID` ASC),
CONSTRAINT `fk_companyPersonAddress_companyPerson` 
    FOREIGN KEY (`companyPerson_ID`) 
    REFERENCES `oursafetydb`.`companyPerson` (`companyPerson_ID`)
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION,
CONSTRAINT `fk_companyPersonAddress_address_ID`
    FOREIGN KEY (`address_ID`)
    REFERENCES `oursafetydb`.`address` (`address_ID`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
 
 
CREATE TABLE IF NOT EXISTS `oursafetydb`.`companyNotes` ( 
`companyNotes_ID` int AUTO_INCREMENT, /*PK*/ 
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`companyPerson_ID` int,  /*FK*/ 
`noteDate` date, 
`noteIndex` int, 
`note` VARCHAR(255), 
PRIMARY KEY (`companyNotes_ID`), 
INDEX `fk_companyNotes_companyPerson_idx` (`companyPerson_ID` ASC),
CONSTRAINT `fk_companyNotes_companyPerson`
    FOREIGN KEY (`companyPerson_ID`)
    REFERENCES `oursafetydb`.`companyPerson` (`companyPerson_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
 
 
CREATE TABLE IF NOT EXISTS `oursafetydb`.`companyType` ( 
`companyType_ID` int, 
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`company_ID` int, /*FK*/ 
`typeLibrary_ID` int,   /*FK*/ 
PRIMARY KEY (`companyType_ID`), 
INDEX `fk_companyType_company_ID_idx` (`company_ID` ASC),
INDEX `fk_companyType_typeLibrary_ID_idx` (`typeLibrary_ID` ASC),
CONSTRAINT `fk_companyType_company_ID`
    FOREIGN KEY (`company_ID`)
    REFERENCES `oursafetydb`.`company` (`company_ID`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION, 
CONSTRAINT `fk_companyType_typeLibrary_ID`
    FOREIGN KEY (`typeLibrary_ID`)
    REFERENCES `oursafetydb`.`_typeLibrary` (`typeLibrary_ID`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
 
 
CREATE TABLE IF NOT EXISTS `oursafetydb`.`companyPositions` ( 
`companyPositions_ID` int AUTO_INCREMENT, 
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`company_ID` int, 
`position_ID` int,  
PRIMARY KEY (`companyPositions_ID`), 
INDEX `fk_companyPositions_company_ID_idx` (`company_id` ASC),
INDEX `fk_companyPositions_position_id_idx` (`position_id` ASC),
CONSTRAINT `fk_companyPositions_company_ID` 
    FOREIGN KEY (`company_ID`) 
    REFERENCES `oursafetyapp`.`company` (`company_ID`) 
    ON DELETE NO ACTION
    ON UPDATE NO ACTION, 
CONSTRAINT `fk_companyPositions_position_id`
    FOREIGN KEY (`position_id`) 
    REFERENCES `oursafetyapp`.`positions` (`position_id`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION) 
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `oursafetydb`.`positions` ( 
`positions_ID` int, 
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`positionTitle` VARCHAR(100), 
`companyPersonRole_ID` int, 
PRIMARY KEY (`positions_ID`), 
INDEX `fk_positions_companypersonrole_idx` (`companyPersonRole_ID` ASC),
CONSTRAINT `fk_companypersonrole_companypersonrole`
    FOREIGN KEY (`companyPersonRole_ID`) 
    REFERENCES `oursafetydb`.`companyPersonRole` (`companyPersonRole_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) 
ENGINE = InnoDB;  

 
 CREATE TABLE IF NOT EXISTS `oursafetydb`.`companyPersonRole`( 
`companyPersonRole_ID` int, 
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`companyPerson_ID` int, 
`role` int, 
PRIMARY KEY (`companyPersonRole_ID`), 
INDEX `fk_companypersonrole_companyperson_idx`(`companyPerson_ID` ASC),
CONSTRAINT `fk_companypersonrole_companyperson` 
    FOREIGN KEY (`companyPerson_ID`) 
    REFERENCES `oursafetydb`.`companyperson` (`companyPerson_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
