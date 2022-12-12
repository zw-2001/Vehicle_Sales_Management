--
-- DROP TABLE IF EXISTS
-- 

DROP TABLE IF EXISTS `InvoiceDetail`;
DROP TABLE IF EXISTS `Stock`;
DROP TABLE IF EXISTS `Invoice`;
DROP TABLE IF EXISTS `Vehicle`;
DROP TABLE IF EXISTS `User`;
DROP TABLE IF EXISTS `Country`;

--
-- Structure de la table `Country`
--

CREATE TABLE IF NOT EXISTS `Country` (
  `Id_Country` INT UNIQUE NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Tax` INT NOT NULL

);

ALTER TABLE Country
	ADD PRIMARY KEY (`Id_Country`);

--
-- Déchargement des données de la table `Country`
--

INSERT INTO `Country` (`Name`, `Tax`) VALUES
('France', 20),
('Belgique', 21),
('Luxembourg', 17),
('Suisse', 8),
('Allemagne', 19),
('Italie', 22),
('Espagne', 21),
('Portugal', 23),
('Royaume-Uni', 20),
('Irlande', 23),
('Pays-Bas', 21),
('Danemark', 25),
('Suède', 25),
('Norvège', 25),
('Finlande', 24),
('Autriche', 20),
('Pologne', 23),
('Hongrie', 27),
('République Tchèque', 21),
('Slovaquie', 20),
('Roumanie', 24),
('Bulgarie', 20),
('Grèce', 24),
('Turquie', 18),
('Islande', 24),
('Liechtenstein', 8),
('Monaco', 20),
('Andorre', 4),
('Saint-Marin', 22),
('Vatican', 4),
('Malte', 18),
('Chypre', 19),
('Bosnie-Herzégovine', 17),
('Serbie', 20),
('Monténégro', 19),
('Macédoine', 18),
('Albanie', 20),
('Croatie', 25),
('Slovénie', 22),
('Estonie', 20),
('Lettonie', 21),
('Lituanie', 21),
('Israël', 17),
('Maroc', 20),
('Tunisie', 19),
('Algérie', 19),
('Libye', 14),
('Egypte', 14),
('Soudan', 14),
('Mauritanie', 18),
('Mali', 18),
('Guinée', 18),
('Côte d''Ivoire', 18),
('Burkina Faso', 18),
('Niger', 18),
('Togo', 18),
('Bénin', 18),
('Maurice', 15),
('Sénégal', 18),
('Gambie', 18),
('Guinée-Bissau', 18),
('Guinée équatoriale', 18),
('Gabon', 18),
('République centrafricaine', 18),
('Cameroun', 18),
('Tchad', 18),
('République du Congo', 18),
('République démocratique du Congo', 18),
('Angola', 18),
('Guinée-Bissau', 18),
('Sao Tomé-et-Principe', 18),
('Equatorial Guinea', 15),
('Nigeria', 24),
('Kenya', 16),
('Ouganda', 18),
('Tanzanie', 18),
('Rwanda', 18),
('Burundi', 18),
('Mozambique', 18),
('Zimbabwe', 18),
('Zambie', 18),
('Malawi', 18),
('Botswana', 18),
('Namibie', 18),
('Afrique du Sud', 18),
('Lesotho', 18),
('Swaziland', 18),
('Madagascar', 18),
('Comores', 18),
('Seychelles', 18),
('Maurice', 15),
('Réunion', 18),
('Mayotte', 18),
('Congo', 18),
('Ile Maurice', 15),
('Ile de la Réunion', 18),
('Mayotte', 18);

-- --------------------------------------------------------

-- 
-- Structure de la table `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `Id_User` INT UNIQUE NOT NULL AUTO_INCREMENT,
  `Id_Country` INT NOT NULL,
  `Type` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(50) UNIQUE NOT NULL,
  `Password` VARCHAR(64) NOT NULL,
  `FirstName` VARCHAR(50) NOT NULL,
  `LastName` VARCHAR(50) NOT NULL

);

ALTER TABLE User
	ADD PRIMARY KEY (`Id_User`),
  ADD FOREIGN KEY (`Id_Country`) REFERENCES `Country` (`Id_Country`);

--
-- Déchargement des données de la table `User`
--

INSERT INTO `User` (`Id_Country`, `Type`, `Email`, `Password`, `FirstName`, `LastName`) VALUES
(1, 'Administrator', 'william@cupcake.com', '�\0���ș�)xq@bB��\ZSB����aF�K', 'William', 'Zhang'),
(1, 'Administrator', 'lisa-marie@cupcake.com', '�\0���ș�)xq@bB��\ZSB����aF�K', 'Lisa-Marie', 'Zheng'),
(2, 'Company', 'company@company.com', '#Q|	�<2��f\0=[%]�гҹi�Z�Zf-`%}', 'Company', 'Company'),
(3, 'Individual', 'individual@individual.com', ' �=\'C��#�@e/(O9P��#(�3�;��g�$', 'Individual', 'Individual'),
(4, 'Company', 'adonny.bobestel@free.fr', 'O3RmTVOHi6alTux', 'Adonny', 'Bobestel'),
(5, 'Individual', 'foster.choillot@gmail.fr', 'S4cE3PwgmGfzt0t', 'Foster', 'Choillot'),
(6, 'Company', 'dwayne.albeves@orange.fr', 'L2AkhQPKO575bXP', 'Dwayne', 'Albeves'),
(7, 'Company', 'grady.choithier@yahoo.com', '0QLX3Zb3VnuGN41', 'Grady', 'Choithier'),
(8, 'Individual', 'aquinton.lamanas@gmail.com', 'JY49ZOkl6hCkkeK', 'Aquinton', 'Lamanas'),
(9, 'Individual', 'darin.chauvelli@hotmail.fr', 's8h2wJ95DfQNGos', 'Darin', 'Chauvelli'),
(10, 'Company', 'evan.ronchessac@yahoo.com', 'DAwd7KAov64eSn2', 'Evan', 'Ronchessac');

-- --------------------------------------------------------

--
-- Structure de la table `Vehicle`
--

CREATE TABLE IF NOT EXISTS `Vehicle` (
  `Id_Vehicle` INT UNIQUE NOT NULL AUTO_INCREMENT,
  `Vehicle` VARCHAR(32) NOT NULL,
  `Type` VARCHAR(32) NOT NULL,
  `Brand` VARCHAR(45) NOT NULL,
  `Price` DECIMAL(13,2) NOT NULL,
  `Energy` VARCHAR(45) NOT NULL,
  `Gearbox` VARCHAR(45) NOT NULL,
  `Seat` INT NOT NULL,
  `Image` VARCHAR(32) NOT NULL
);

ALTER TABLE Vehicle
	ADD PRIMARY KEY (`Id_Vehicle`);

--
-- Déchargement des données de la table `Vehicle`
--

INSERT INTO `Vehicle` (`Vehicle`, `Type`, `Brand`, `Price`, `Energy`, `Gearbox`, `Seat`, `Image`) VALUES
('Scooter ', '125', 'Kymco', 3599.99, 'Gasoline', 'Manual', 2, 'KymcoPeopleS125.jpg'),
('Scooter', '125', 'Yamaha', 5599.99, 'Electric', 'Manual', 2, 'XMAX125TechMAX.jpg'),
('Scooter', 'Electric', 'Brumaire', 2790, 'Electric', 'Automatic', 2, 'Electricbrumaire.jpg'),
('Scooter', 'Electric', 'Frison', 9490, 'Electric', 'Automatic', 2, 'FrisonT10.jpg'),
('Scooter', '3 wheels', 'Piaggio', 11499.99, 'Hybrid', 'Manual', 2, 'MP3500Piaggio.jpg'),
('Scooter', '3 wheels', 'Peugeot', 10299.99, 'Gasoline', 'Manual', 2, 'PeugeotMetropolisSW.jpg'),
('Car', '4x4', 'Dacia', 16990, 'Electric', 'Automatic', 4, 'DaciaDuster.jpg'),
('Car', '4x4', 'Jeep', 41700, 'Hybrid', 'Automatic', 4, 'JeepRenegade.jpg'),
('Car', 'Berline', 'Peugeot', 44100, 'Hybrid', 'Automatic', 5, 'Peugeot508.jpg'),
('Car', 'Berline', 'Fiat', 16990, 'Hybrid', 'Manual', 5, 'FiatTipo.jpg'),
('Car', 'Crossover', 'Citroen', 21980, 'Electric', 'Automatic', 5, 'CitroenC3Aircross.jpg'),
('Car', 'Crossover', 'Kia', 20690, 'Electric', 'Manual', 5, 'KiaStonic.jpg'),
('Car', 'Pick-up', 'Renault', 26990, 'Diesel', 'Automatic', 3, 'RenaultAlaskan.jpg'),
('Car', 'Pick-up', 'Mercedes', 54000, 'Gasoline', 'Manual', 3, 'MercedesClasseX.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `Invoice`
--

CREATE TABLE IF NOT EXISTS `Invoice` (
  `Id_Invoice` INT UNIQUE NOT NULL AUTO_INCREMENT,
  `Id_User` INT NOT NULL,
  `Date` DATE NOT NULL,
  `Payment` VARCHAR(45) NOT NULL,
  `NbMonth` INT NOT NULL,
  `Total` DECIMAL(13,2) NOT NULL
);

ALTER TABLE Invoice
	ADD PRIMARY KEY (`Id_Invoice`),
  ADD FOREIGN KEY (`Id_User`) REFERENCES `User` (`Id_User`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

--
-- Déchargement des données de la table `Invoice`
--

INSERT INTO `Invoice` (`Id_User`, `Date`, `Payment`, `NbMonth`, `Total`) VALUES
(2, '2012-12-31', 'Credit', 3, 37579.99),
(2, '2016-05-23', 'Cash', 0, 5580),
(3, '2017-01-01', 'Credit', 6, 125100),
(3, '2019-08-26', 'Cash', 0, 16990),
(2, '2020-01-29', 'Credit', 10, 41199.96);

-- --------------------------------------------------------

--
-- Structure de la table `InvoiceDetail`
--

CREATE TABLE IF NOT EXISTS `InvoiceDetail` (
  `Id_Invoice` INT NOT NULL,
  `Id_Vehicle` INT NOT NULL,
  `Quantity` INT NOT NULL,
  `Total` DECIMAL(13,2) NOT NULL
);

ALTER TABLE InvoiceDetail
	ADD PRIMARY KEY (`Id_Invoice`, `Id_Vehicle`),
  ADD FOREIGN KEY (`Id_Invoice`) REFERENCES `Invoice` (`Id_Invoice`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  ADD FOREIGN KEY (`Id_Vehicle`) REFERENCES `Vehicle` (`Id_Vehicle`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

--
-- Déchargement des données de la table `InvoiceDetail`
--

INSERT INTO `InvoiceDetail` (`Id_Invoice`, `Id_Vehicle`, `Quantity`, `Total`) VALUES
(1, 7, 2, 33980),
(1, 1, 1, 3599.99),
(2, 3, 2, 5580),
(3, 8, 3, 125100),
(4, 10, 1, 16990),
(5, 6, 4, 41199.96);

-- --------------------------------------------------------

--
-- Structure de la table `Stock`
--

CREATE TABLE IF NOT EXISTS `Stock` (
  `Id_Stock` INT UNIQUE NOT NULL AUTO_INCREMENT,
  `Id_Vehicle` INT NOT NULL,
  `AcquisitionDate` DATE NOT NULL,
  `Quantity` INT NOT NULL,
  `Price` DECIMAL(13,2) NOT NULL
);

ALTER TABLE Stock
	ADD PRIMARY KEY (`Id_Stock`),
  ADD FOREIGN KEY (`Id_Vehicle`) REFERENCES `Vehicle` (`Id_Vehicle`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

--
-- Déchargement des données de la table `Stock`
--

INSERT INTO `Stock` (`Id_Vehicle`, `AcquisitionDate`, `Quantity`, `Price`) VALUES
(4, '2021-12-12', 3, 7010.59),
(7, '2020-10-23', 5, 13990.90),
(8, '2021-06-04', 2, 27990),
(5, '2021-09-10', 4, 9299.99),
(13, '2020-11-11', 2, 13995.95),
(10, '2022-04-01', 1, 13990),
(14, '2022-01-15', 2, 32000),
(7, '2022-07-25', 3, 14990),
(5, '2022-08-03', 2, 9499.99),
(1, '2020-12-18', 4, 2500);