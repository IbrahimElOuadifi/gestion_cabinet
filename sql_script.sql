CREATE DATABASE gestion_cabinet;

USE gestion_cabinet;

CREATE TABLE admin (
	Id int NOT NULL AUTO_INCREMENT,
    Nom VARCHAR(25),
    Prenom VARCHAR(25),
    Adresse VARCHAR(255),
    NGSM VARCHAR(16),
    Civilite VARCHAR(50),
    Email VARCHAR(50),
    Cin VARCHAR(8),
    Login VARCHAR(25) UNIQUE,
    Pswrd VARCHAR(255),
    CONSTRAINT PK_Admin_ID PRIMARY KEY (Id)
);

CREATE TABLE specialite (
	Id int NOT NULL AUTO_INCREMENT,
    libelle VARCHAR(25),
    CONSTRAINT PK_Spe_ID PRIMARY KEY (Id)
);

CREATE TABLE specialite_infirmier (
	Id int NOT NULL AUTO_INCREMENT,
    libelle VARCHAR(25),
    CONSTRAINT PK_SI_ID PRIMARY KEY (Id)
);

CREATE TABLE agenda (
	Id int NOT NULL AUTO_INCREMENT,
	DateDebut DATE,
    HeureDebut TIME,
    DateFin DATE,
    HeureFin TIME,
    Observation VARCHAR(255),
    CONSTRAINT PK_Agen_ID PRIMARY KEY (Id)
);

CREATE TABLE medecin (
	Id int NOT NULL AUTO_INCREMENT,
    Nom VARCHAR(25),
    Prenom VARCHAR(25),
    Adresse VARCHAR(255),
    NGSM VARCHAR(16),
    Civilite VARCHAR(50),
    Email VARCHAR(50),
    Cin VARCHAR(8),
    Login VARCHAR(25) UNIQUE,
    Pswrd VARCHAR(255),
    SpecialiteId INT,
    AgendaId INT,
    CONSTRAINT PK_Med_ID PRIMARY KEY (Id),
    CONSTRAINT FK_Spe_ID FOREIGN KEY (SpecialiteId) REFERENCES specialite(Id),
    CONSTRAINT FK_Spe_Age FOREIGN KEY (AgendaId) REFERENCES agenda(Id)
);

CREATE TABLE infirmier (
	Id int NOT NULL AUTO_INCREMENT,
    Nom VARCHAR(25),
    Prenom VARCHAR(25),
    Adresse VARCHAR(255),
    NGSM VARCHAR(16),
    Civilite VARCHAR(50),
    Email VARCHAR(50),
    Cin VARCHAR(8),
    Login VARCHAR(25) UNIQUE,
    Pswrd VARCHAR(255),
    SpecialiteId INT,
    CONSTRAINT PK_Inf_ID PRIMARY KEY (Id),
    CONSTRAINT FK_SpeInf_ID FOREIGN KEY (SpecialiteId) REFERENCES specialite_infirmier(Id)
);

CREATE TABLE service (
	Id int NOT NULL AUTO_INCREMENT,
    libelle VARCHAR(25),
    MedecinId INT NOT NULL,
    CONSTRAINT PK_Ser_ID PRIMARY KEY (Id),
    CONSTRAINT FK_Ser_ID FOREIGN KEY (MedecinId) REFERENCES medecin(Id)
);

CREATE TABLE service_infirmier (
	Id int NOT NULL AUTO_INCREMENT,
    libelle VARCHAR(25),
    Infirmier INT NOT NULL,
    CONSTRAINT PK_Ser_ID PRIMARY KEY (Id),
    CONSTRAINT FK_SI_ID FOREIGN KEY (Infirmier) REFERENCES infirmier(Id)
);


CREATE TABLE type_assurance (
	Id int NOT NULL AUTO_INCREMENT,
    libelle VARCHAR(25),
    Patient INT NOT NULL,
    CONSTRAINT PK_TA_ID PRIMARY KEY (Id),
    CONSTRAINT FK_TA_Code FOREIGN KEY (Patient) REFERENCES patient(Id)
);


CREATE TABLE patient (
	Id int NOT NULL AUTO_INCREMENT,
    Nom VARCHAR(25),
    Prenom VARCHAR(25),
    Adresse VARCHAR(255),
    NGSM VARCHAR(16),
    Civilite VARCHAR(50),
    Email VARCHAR(50),
    Cin VARCHAR(8),
	DateNaissance DATE,
    DateInsciption DATE,
    Sex VARCHAR(15),
    Profession VARCHAR(25),
    CodeAssurance INT,
    DossierMedical INT NOT NULL,
    CONSTRAINT PK_Pat_ID PRIMARY KEY (Id),
    CONSTRAINT FK_Pat_ID FOREIGN KEY (DossierMedical) REFERENCES dossier_medical(Id)
);

CREATE TABLE render_vous (
	Id int NOT NULL AUTO_INCREMENT,
	DateRend DATE,
    HeureRend TIME,
    Patient INT,
    Service INT,
    CONSTRAINT PK_Agen_ID PRIMARY KEY (Id),
    CONSTRAINT FK_RV_Pat FOREIGN KEY (Patient) REFERENCES patient(Id),
    CONSTRAINT FK_RV_Ser FOREIGN KEY (Service) REFERENCES service(Id)
);

CREATE TABLE annexe_antecedents (
	Id int NOT NULL AUTO_INCREMENT,
    UrlAnnexe VARCHAR(25),
    CONSTRAINT PK_AA_ID PRIMARY KEY (Id)
);

CREATE TABLE dossier_medical (
	Id int NOT NULL AUTO_INCREMENT,
    antecedents VARCHAR(25),
    AnnexeAntecedant INT,
    CONSTRAINT PK_DM_ID PRIMARY KEY (Id),
    CONSTRAINT FK_DM_ID FOREIGN KEY (AnnexeAntecedant) REFERENCES annexe_antecedens(Id)
);

CREATE TABLE motif (
	Id int NOT NULL AUTO_INCREMENT,
	libelle VARCHAR(255),
    RenderVous INT NOT NULL,
    CONSTRAINT PK_Mot_ID PRIMARY KEY (Id),
    CONSTRAINT FK_Mot_Ren FOREIGN KEY (Patient) REFERENCES render_vous(Id)
);

CREATE TABLE etat (
	Id int NOT NULL AUTO_INCREMENT,
	libelle VARCHAR(255),
    CONSTRAINT PK_etat_ID PRIMARY KEY (Id)
);

CREATE TABLE consultation (
	Id int NOT NULL AUTO_INCREMENT,
    DateCon DATE,
    HeureCon TIME,
	rapport VARCHAR(255),
    etat INT NOT NULL,
    Reglement INT NOT NULL,
    CONSTRAINT PK_Con_ID PRIMARY KEY (Id),
    CONSTRAINT FK_Con_Etat FOREIGN KEY (etat) REFERENCES etat(Id),
    CONSTRAINT FK_Con_Reg FOREIGN KEY (Reglement) REFERENCES patient(Id)
);

CREATE TABLE acte (
	Id int NOT NULL AUTO_INCREMENT,
	libelle VARCHAR(255),
    observation VARCHAR(255),
    UrlAnnexe VARCHAR(255),
    Infirmier INT,
    Consultation INT,
    CONSTRAINT PK_Act_ID PRIMARY KEY (Id),
    CONSTRAINT FK_Act_Inf FOREIGN KEY (Infirmier) REFERENCES infirmier(id),
    CONSTRAINT FK_Act_Cons FOREIGN KEY (Consultation) REFERENCES consultation(id)
);

CREATE TABLE orientation (
	Id int NOT NULL AUTO_INCREMENT,
	lettre TEXT,
    Consultation INT,
    CONSTRAINT PK_Or_ID PRIMARY KEY (Id),
    CONSTRAINT FK_Or_Cons FOREIGN KEY (Consultation) REFERENCES consultation(id)
);

CREATE TABLE examens_comp (
	Id int NOT NULL AUTO_INCREMENT,
	lettre TEXT,
    RapportRaponse TEXT,
    UrlReponse VARCHAR(255),
    Consult INT,
    CONSTRAINT PK_EP_ID PRIMARY KEY (Id),
    CONSTRAINT FK_EP_Cons FOREIGN KEY (Consult) REFERENCES consultation(Id)
);

CREATE TABLE certificat (
	Id int NOT NULL AUTO_INCREMENT,
	Titre VARCHAR(255),
    Description TEXT,
    DateCer DATE,
    Consult INT,
    CONSTRAINT PK_Cert_ID PRIMARY KEY (Id),
    CONSTRAINT FK_Cert_Cons FOREIGN KEY (Consult) REFERENCES consultation(Id)
);

CREATE TABLE ordonnance (
	Id int NOT NULL AUTO_INCREMENT,
	Titre VARCHAR(255),
    Consult INT,
    CONSTRAINT PK_Ord_ID PRIMARY KEY (Id),
    CONSTRAINT FK_Ord_Cons FOREIGN KEY (Consult) REFERENCES consultation(Id)
);

CREATE TABLE Medicaments (
	Id int NOT NULL AUTO_INCREMENT,
	libelle VARCHAR(255),
    CONSTRAINT PK_Med_ID PRIMARY KEY (Id)
);

CREATE TABLE Traitement (
	Id int NOT NULL AUTO_INCREMENT,
    Duree TIME,
	Dose VARCHAR(255),
    Medicament INT,
    Ordonnance INT,
    CONSTRAINT PK_Tra_ID PRIMARY KEY (Id),
    CONSTRAINT FK_Tra_Med FOREIGN KEY (Medicament) REFERENCES Medicament(Id),
    CONSTRAINT FK_Tra_Ord FOREIGN KEY (Ordonnance) REFERENCES ordonnance(Id)
);

CREATE TABLE Reglement (
	Id int NOT NULL AUTO_INCREMENT,
	Montont FLOAT,
    Consult INT,
    CONSTRAINT PK_Reg_ID PRIMARY KEY (Id),
    CONSTRAINT FK_Reg_Cons FOREIGN KEY (Consult) REFERENCES consultation(Id)
);

INSERT INTO specialite VALUES(1,'Generaliste');
INSERT INTO specialite VALUES(2,'Gastrologie');
INSERT INTO specialite VALUES(3,'Gynecologue');

INSERT INTO specialite_infirmier VALUES(default,'Plolyvalent');
INSERT INTO specialite_infirmier VALUES(default,'sage-femme');
INSERT INTO specialite_infirmier VALUES(default,'technicien radio');
INSERT INTO specialite_infirmier VALUES(default,'aide-soignant');

INSERT INTO agenda VALUES(default, now(), now(), now(), now(), 'Hello, World!');
INSERT INTO agenda VALUES(default, now(), now(), now(), now(), 'Hello, World!');
INSERT INTO agenda VALUES(default, now(), now(), now(), now(), 'Hello, World!');

INSERT INTO admin VALUES (default, 'El Ouadifi', 'Ibrahim', '', '', '', '', '', 'admin', 'admin');
INSERT INTO medecin VALUES (default, 'El Ouadifi', 'Ibrahim', '', '', '', '', '', 'aa', '123456', 1, 1);
INSERT INTO infirmier VALUES (default, 'El Ouadifi', 'Ibrahim', '', '', '', '', '', 'aa', '123456', 1);

