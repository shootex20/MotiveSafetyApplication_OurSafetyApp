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
`emergencyContact_ID` int,  
PRIMARY KEY (`person_ID`), 
INDEX `person_emergencyContact_id_fk_idx` (`emergencyContact_ID` ASC),
CONSTRAINT `fk_person_emergencyContact_id`
    FOREIGN KEY (`emergencyContact_ID`)
    REFERENCES `oursafetydb`.`emergencyContact` (`emergencyContact_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `oursafetydb`.`companyPerson` ( 
`companyPerson_ID` int, /*PK*/ 
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`company_ID` int, /*FK*/ 
`person_ID` int, /*FK*/ 
`email` VARCHAR(60),
PRIMARY KEY (`companyPerson_ID`), 
INDEX `companyPerson_company_id_fk_idx` (`company_ID` ASC),
INDEX `companyPerson_person_id_fk_idx` (`person_ID` ASC),
CONSTRAINT `fk_companyPerson_company_id`
    FOREIGN KEY (`company_ID`)
    REFERENCES `oursafetydb`.`company` (`company_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `fk_companyPerson_person_id`
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
`company_ID` int, 
PRIMARY KEY (`url_ID`), 
INDEX `fk_url_typelibrary_idx` (`typeLibrary_ID` ASC),
INDEX `fk_url_company_idx` (`company_ID` ASC),
CONSTRAINT `fk_url_typelibrary`
    FOREIGN KEY (`typeLibrary_ID`)
    REFERENCES `oursafetydb`.`typeLibrary` (`typeLibrary_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
CONSTRAINT `fk_url_company`
    FOREIGN KEY (`company_id`)
    REFERENCES `oursafetydb`.`typeLibrary` (`company_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
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
`isChargeableType` BOOLEAN, 
`isDepletingType` BOOLEAN, 
`isDepreactiationType` BOOLEAN, 
`itemClassInformation` VARCHAR(30),
PRIMARY KEY (`ItemClass_ID`), 
INDEX `fk_itemClass_itemClassFields_idx` (`itemClassFields_ID` ASC), 
CONSTRAINT `fk_itemClass_itemClassFields_ID` 
    FOREIGN KEY(`itemClassFields_ID`) 
    REFERENCES `oursafetydb`.`itemClassFields` (`itemClassFields_ID`) 
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
PRIMARY KEY (`companyPersonPhone_ID`), 
INDEX `fk_companyPersonPhone_CompanyPerson_idx` (`companyPerson_ID` ASC),
INDEX `fk_companyPersonPhone_Phone_idx` (`phone_ID` ASC),
CONSTRAINT `fk_companypersonphone_companypersonid`
    FOREIGN KEY(`companyPerson_ID`)
    REFERENCES `oursafetydb`.`companyPerson` (`companyPerson_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `fk_companypersonphone_phone`
    FOREIGN KEY(`phone_ID`)
    REFERENCES `oursafetydb`.`phone` (`phone_ID`)
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
`isChargeableType` BOOLEAN, 
`isDepletingType` BOOLEAN, 
`isDepreactiationType` BOOLEAN, 
`itemClassInformation` VARCHAR(30),
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
`emergencyContactFirstName` VARCHAR(30),
`emergencyContactLastName` VARCHAR(30),
`emergencyContactNumber` VARCHAR(30),
`emergencyContactRelationship` VARCHAR(20),
PRIMARY KEY(`emergencyContact_ID`))
ENGINE = InnoDB;

/*
CREATE TABLE IF NOT EXISTS `oursafetydb`.`addressRegion` ( 
 `addressRegion_ID` int AUTO_INCREMENT, /*PK
`dateAdded` date, 
`dateRemoved` date, 
`userAdded` int, 
`userRemoved` int, 
`parentType` int, /*  for)*/ 
/*`parentID` int, /*  for)
`spaceCode` VARCHAR(10), 
PRIMARY KEY (`addressRegion_ID`)) 
ENGINE = InnoDB;
*/
 
CREATE TABLE IF NOT EXISTS `oursafetydb`.`address` ( 
`address_ID`  int, 
`dateAdded`  date, 
`dateRemoved`  date, 
`userAdded`  int, 
`userRemoved`  int, 
`typeLibrary_ID`  int, 
`addressLine1`  VARCHAR(200), 
`addressLine2`  VARCHAR(200),
`city` VARCHAR(100),
`province` VARCHAR(20),
`country` VARCHAR(100),
`postalCode`  VARCHAR(6), 
PRIMARY KEY(`address_ID`), 
INDEX `fk_address_typelibrary_idx` (`typeLibrary_ID` ASC), 
CONSTRAINT `fk_address_typelibrary_ID` 
    FOREIGN KEY (`typeLibrary_ID`) 
    REFERENCES `oursafetydb`.`typeLibrary` (`typeLibrary_ID`) 
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
`companyType_ID` int AUTO_INCREMENT, 
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
    REFERENCES `oursafetydb`.`typeLibrary` (`typeLibrary_ID`) 
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
`companyPerson_ID` int, 
`positionTitle` VARCHAR(100), 
PRIMARY KEY (`companyPositions_ID`), 
INDEX `fk_companyPositions_company_ID_idx` (`company_id` ASC),
INDEX `fk_companyPositions_companyPerson_idx` (`companyPerson_ID` ASC),
CONSTRAINT `fk_companyPositions_company_ID` 
    FOREIGN KEY (`company_ID`) 
    REFERENCES `oursafetyapp`.`company` (`company_ID`) 
    ON DELETE NO ACTION
    ON UPDATE NO ACTION, 
CONSTRAINT `fk_companyPositions_companyPerson_ID`
    FOREIGN KEY (`companyPerson_ID`) 
    REFERENCES `oursafetyapp`.`companyPerson` (`companyPerson_ID`)
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION) 
ENGINE = InnoDB;

 



-- Dumping data for table oursafetydb.company: ~1 rows (approximately)
DELETE FROM `company`;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` (`company_ID`, `dateAdded`, `dateRemoved`, `userAdded`, `userRemoved`, `shortname`, `name`, `description`, `saltHash`, `account`, `industry`) VALUES
	(0, '2021-02-09', NULL, 1, NULL, 'ABC_company', 'ABC_Company', 'ABC company', NULL, NULL, NULL);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;

-- Dumping data for table oursafetydb.companyperson: ~1 rows (approximately)
DELETE FROM `companyperson`;
/*!40000 ALTER TABLE `companyperson` DISABLE KEYS */;
INSERT INTO `companyperson` (`companyPerson_ID`, `dateAdded`, `dateRemoved`, `userAdded`, `userRemoved`, `company_ID`, `person_ID`) VALUES
	(0, '2021-02-09', NULL, 2, NULL, 0, 0);
/*!40000 ALTER TABLE `companyperson` ENABLE KEYS */;

-- Dumping data for table oursafetydb.companypersonphone: ~3 rows (approximately)
DELETE FROM `companypersonphone`;
/*!40000 ALTER TABLE `companypersonphone` DISABLE KEYS */;
INSERT INTO `companypersonphone` (`companyPersonPhone_ID`, `dateAdded`, `dateRemoved`, `userAdded`, `userRemoved`, `companyPerson_ID`, `phone_ID`) VALUES
	(0, '2021-02-09', NULL, 2, NULL, NULL, 1),
	(1, '2021-02-09', NULL, 2, NULL, NULL, 2),
	(2, '2021-02-09', NULL, 2, NULL, NULL, 0);
/*!40000 ALTER TABLE `companypersonphone` ENABLE KEYS */;

-- Dumping data for table oursafetydb.person: ~1 rows (approximately)
DELETE FROM `person`;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`person_ID`, `dateAdded`, `dateRemoved`, `userAdded`, `userRemoved`, `firstName`, `lastName`, `dateOfBirth`, `gender`) VALUES
	(0, '2021-02-09', NULL, 2, NULL, 'Alice', 'Lee', '2000-01-01', 'M');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;

-- Dumping data for table oursafetydb.phone: ~3 rows (approximately)
DELETE FROM `phone`;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
INSERT INTO `phone` (`phone_ID`, `dateAdded`, `dateRemoved`, `userAdded`, `userRemoved`, `typeLibrary_ID`, `countryCode`, `areaCode`, `localNumber`, `extension`) VALUES
	(0, '2021-02-09', NULL, 2, NULL, 1, '1', '403', '333', '3333'),
	(1, '2021-02-09', NULL, 2, NULL, 2, '1', '403', '222', '2222'),
	(2, '2021-02-09', NULL, 2, NULL, 3, '1', '403', '111', '1111');
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;

-- Dumping data for table oursafetydb.typelibrary: ~21 rows (approximately)
DELETE FROM `typelibrary`;
/*!40000 ALTER TABLE `typelibrary` DISABLE KEYS */;
INSERT INTO `typelibrary` (`typeLibrary_ID`, `dateAdded`, `dateRemoved`, `userAdded`, `userRemoved`, `type`, `description`, `isCategory`) VALUES
	(0, '2021-02-09', NULL, 1, NULL, 'phone', 'phone', 'T'),
	(1, '2021-02-09', NULL, 1, NULL, 'phone', 'company phone', 'F'),
	(2, '2021-02-09', NULL, 1, NULL, 'phone', 'fax', 'F'),
	(3, '2021-02-09', NULL, 1, NULL, 'phone', 'personal phone', 'F'),
	(100, '2021-02-09', NULL, 1, NULL, 'manual', 'manual', 'T'),
	(101, '2021-02-09', NULL, 1, NULL, 'manual', 'safety manual', 'F'),
	(102, '2021-02-09', NULL, 1, NULL, 'manual', 'equipment manual', 'F'),
	(103, '2021-02-09', NULL, 1, NULL, 'manual', 'construction manual', 'F'),
	(200, '2021-02-09', NULL, 1, NULL, 'equipment', 'equipment', 'T'),
	(201, '2021-02-09', NULL, 1, NULL, 'equipment', 'car', 'F'),
	(202, '2021-02-09', NULL, 1, NULL, 'equipment', 'screwdriver', 'F'),
	(300, '2021-02-09', NULL, 1, NULL, 'companyRelationship', 'company relationship', 'T'),
	(301, '2021-02-09', NULL, 1, NULL, 'companyRelationship', 'cooperate', 'F'),
	(302, '2021-02-09', NULL, 1, NULL, 'companyRelationship', 'sponsor', 'F'),
	(310, '2021-02-09', NULL, 1, NULL, 'address', 'address', 'T'),
	(311, '2021-02-09', NULL, 1, NULL, 'address', 'company address', 'F'),
	(312, '2021-02-09', NULL, 1, NULL, 'address', 'personal address', 'F'),
	(320, '2021-02-09', NULL, 1, NULL, 'companyType', 'company type', 'T'),
	(321, '2021-02-09', NULL, 1, NULL, 'companyType', 'construction company', 'F'),
	(350, '2021-02-09', NULL, 1, NULL, 'url', 'url', 'T'),
	(351, '2021-02-09', NULL, 1, NULL, 'url', 'official website', 'F');