-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 07 sep. 2022 à 14:33
-- Version du serveur : 8.0.27
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `project_java`
--

-- --------------------------------------------------------

--
-- Structure de la table `departement`
--

DROP TABLE IF EXISTS `departement`;
CREATE TABLE IF NOT EXISTS `departement` (
  `nom_departement` varchar(20) NOT NULL,
  `email_departement` varchar(20) NOT NULL,
  PRIMARY KEY (`nom_departement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `departement`
--

INSERT INTO `departement` (`nom_departement`, `email_departement`) VALUES
('ksd', 'ckj'),
('math', 'math1@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `document`
--

DROP TABLE IF EXISTS `document`;
CREATE TABLE IF NOT EXISTS `document` (
  `id_doc` int NOT NULL AUTO_INCREMENT,
  `nom_doc` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type_doc` varchar(20) NOT NULL,
  `id_etape` int NOT NULL,
  `mot_cle` varchar(50) NOT NULL,
  `diposer` varchar(50) NOT NULL,
  PRIMARY KEY (`id_doc`),
  KEY `id-etape` (`id_etape`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `document`
--

INSERT INTO `document` (`id_doc`, `nom_doc`, `type_doc`, `id_etape`, `mot_cle`, `diposer`) VALUES
(1, 'et.txt', 'livrable', 1, 'java code', ''),
(2, 'Filtre.java', 'livrable', 1, 'filtre java', ''),
(3, 'C:\\Users\\user\\Desktop\\probleme 2\\src\\Filtre.java', 'document', 1, 'java code', 'diposer par professeur'),
(4, 'C:\\Users\\user\\Desktop\\probleme1\\src\\Compte.java', 'rapport', 2, 'java code', 'diposer par etudient'),
(5, 'C:\\Users\\user\\Desktop\\probleme1\\src\\Compte.java', 'rapport', 2, 'java code', 'diposer par etudient');

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

DROP TABLE IF EXISTS `entreprise`;
CREATE TABLE IF NOT EXISTS `entreprise` (
  `id_Es` int NOT NULL,
  `email_Es` varchar(20) NOT NULL,
  `tele_Es` varchar(20) NOT NULL,
  `responsable_Es` varchar(20) NOT NULL,
  PRIMARY KEY (`id_Es`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `entreprise`
--

INSERT INTO `entreprise` (`id_Es`, `email_Es`, `tele_Es`, `responsable_Es`) VALUES
(-1, '-1', '-1', '-1'),
(1, '5330@gmail.com', '5330', 'X');

-- --------------------------------------------------------

--
-- Structure de la table `etape`
--

DROP TABLE IF EXISTS `etape`;
CREATE TABLE IF NOT EXISTS `etape` (
  `id_etape` int NOT NULL,
  `duree` varchar(20) NOT NULL,
  `etape_de_depart` varchar(20) NOT NULL,
  `id_projet` int NOT NULL,
  PRIMARY KEY (`id_etape`),
  KEY `id_projet` (`id_projet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `etape`
--

INSERT INTO `etape` (`id_etape`, `duree`, `etape_de_depart`, `id_projet`) VALUES
(1, 'mcd', '15 jour', 3),
(2, '10jour', 'mcd', 17),
(5, 'backoffice', '15jours', 3);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `nom` varchar(15) NOT NULL,
  `prenom` varchar(15) NOT NULL,
  `email` varchar(35) NOT NULL,
  `niveau` varchar(15) NOT NULL,
  `password` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `nom_filiere` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nom_filiere` (`nom_filiere`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`nom`, `prenom`, `email`, `niveau`, `password`, `id`, `nom_filiere`) VALUES
('amine', 'amine', 'amin11@gmail.com', '4eme', '1010', 9, 'GI'),
('dsqd', 'dqds', 'ddd', 'dc', '2022', 13, 'GI'),
('reda', 'drissi', 'reda@gmail.com', '1er', '3333', 18, 'GI');

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

DROP TABLE IF EXISTS `filiere`;
CREATE TABLE IF NOT EXISTS `filiere` (
  `nom_filiere` varchar(20) NOT NULL,
  `nom_departement` varchar(20) NOT NULL,
  PRIMARY KEY (`nom_filiere`),
  KEY `nom_departement` (`nom_departement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `filiere`
--

INSERT INTO `filiere` (`nom_filiere`, `nom_departement`) VALUES
('GI', 'math'),
('idd', 'math'),
('iric', 'math');

-- --------------------------------------------------------

--
-- Structure de la table `laboratoire`
--

DROP TABLE IF EXISTS `laboratoire`;
CREATE TABLE IF NOT EXISTS `laboratoire` (
  `id_labo` int NOT NULL,
  `nom_labo` varchar(20) NOT NULL,
  `email_labo` varchar(20) NOT NULL,
  PRIMARY KEY (`id_labo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `laboratoire`
--

INSERT INTO `laboratoire` (`id_labo`, `nom_labo`, `email_labo`) VALUES
(11, 'Y', 'Y'),
(19, 'XYYYY', 'X'),
(122, 'btm', 'btm@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

DROP TABLE IF EXISTS `professeur`;
CREATE TABLE IF NOT EXISTS `professeur` (
  `id_prof` int NOT NULL AUTO_INCREMENT,
  `nom_prof` varchar(20) NOT NULL,
  `prenom_prof` varchar(20) NOT NULL,
  `grade` varchar(3) NOT NULL,
  `email_prof` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nom_departement` varchar(20) NOT NULL,
  `nom_filiere` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `id_labo` int NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`id_prof`),
  KEY `id_labo` (`id_labo`),
  KEY `nom_filiere` (`nom_filiere`),
  KEY `nom_departement` (`nom_departement`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `professeur`
--

INSERT INTO `professeur` (`id_prof`, `nom_prof`, `prenom_prof`, `grade`, `email_prof`, `nom_departement`, `nom_filiere`, `password`, `id_labo`, `role`) VALUES
(2, 'ahmed', 'ahmed', 'PES', 'ahmed@gmail.com', 'math', 'GI', '1234', 122, 'membre'),
(3, 'yassine', 'momen', 'PES', 'momen@gmail.coom', 'math', 'GI', 'momon', 122, 'membre'),
(6, 'shg', 'sz', 'PES', 'sd', 'math', 'GI', 'ssss', 122, 'chef_filiere'),
(7, 'oussama', 'e', 'PH', 'e', 'math', 'GI', 'aaaa', 122, 'membre');

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

DROP TABLE IF EXISTS `projet`;
CREATE TABLE IF NOT EXISTS `projet` (
  `id_projet` int NOT NULL AUTO_INCREMENT,
  `titre` varchar(20) NOT NULL,
  `date_debut` varchar(20) NOT NULL,
  `duree` varchar(20) NOT NULL,
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_prof` int NOT NULL,
  `id` int NOT NULL,
  `id_labo` int NOT NULL,
  `id_Es` int NOT NULL,
  `encadrant_2` int NOT NULL,
  PRIMARY KEY (`id_projet`),
  KEY `id` (`id`),
  KEY `id_prof` (`id_prof`),
  KEY `id_labo` (`id_labo`),
  KEY `id_Es` (`id_Es`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `projet`
--

INSERT INTO `projet` (`id_projet`, `titre`, `date_debut`, `duree`, `type`, `id_prof`, `id`, `id_labo`, `id_Es`, `encadrant_2`) VALUES
(3, 'getinfo', 'fevrie', '5 mois', 'projet fin d\'etude', 2, 13, 122, -1, 0),
(11, 'e', 'fevrie', '6 mois', 'projet fin d\'etude', 2, 18, 122, -1, 0),
(17, 'ed', 'juin', '2mois', 'pfa', 2, 9, 122, -1, -1);

-- --------------------------------------------------------

--
-- Structure de la table `rendez_vous`
--

DROP TABLE IF EXISTS `rendez_vous`;
CREATE TABLE IF NOT EXISTS `rendez_vous` (
  `id_rv` int NOT NULL AUTO_INCREMENT,
  `date_rv` varchar(20) NOT NULL,
  `heure_rv` varchar(20) NOT NULL,
  `id` int NOT NULL,
  `id_prof` int NOT NULL,
  PRIMARY KEY (`id_rv`),
  KEY `id` (`id`),
  KEY `id_prof` (`id_prof`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `rendez_vous`
--

INSERT INTO `rendez_vous` (`id_rv`, `date_rv`, `heure_rv`, `id`, `id_prof`) VALUES
(1, 'qs', 'qs', 13, 2);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `document`
--
ALTER TABLE `document`
  ADD CONSTRAINT `document_ibfk_1` FOREIGN KEY (`id_etape`) REFERENCES `etape` (`id_etape`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `etape`
--
ALTER TABLE `etape`
  ADD CONSTRAINT `etape_ibfk_1` FOREIGN KEY (`id_projet`) REFERENCES `projet` (`id_projet`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_ibfk_1` FOREIGN KEY (`nom_filiere`) REFERENCES `filiere` (`nom_filiere`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `filiere`
--
ALTER TABLE `filiere`
  ADD CONSTRAINT `filiere_ibfk_1` FOREIGN KEY (`nom_departement`) REFERENCES `departement` (`nom_departement`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD CONSTRAINT `professeur_ibfk_1` FOREIGN KEY (`id_labo`) REFERENCES `laboratoire` (`id_labo`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `professeur_ibfk_2` FOREIGN KEY (`nom_filiere`) REFERENCES `filiere` (`nom_filiere`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `professeur_ibfk_3` FOREIGN KEY (`nom_departement`) REFERENCES `departement` (`nom_departement`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `projet_ibfk_1` FOREIGN KEY (`id`) REFERENCES `etudiant` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `projet_ibfk_2` FOREIGN KEY (`id_prof`) REFERENCES `professeur` (`id_prof`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `projet_ibfk_3` FOREIGN KEY (`id_labo`) REFERENCES `laboratoire` (`id_labo`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `projet_ibfk_4` FOREIGN KEY (`id_Es`) REFERENCES `entreprise` (`id_Es`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD CONSTRAINT `rendez_vous_ibfk_1` FOREIGN KEY (`id`) REFERENCES `etudiant` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `rendez_vous_ibfk_2` FOREIGN KEY (`id_prof`) REFERENCES `professeur` (`id_prof`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
