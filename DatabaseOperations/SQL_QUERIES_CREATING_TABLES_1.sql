use myciti;

CREATE TABLE ClientInfoPage (
	ClientID BIGINT NOT NULL CONSTRAINT ClientInfoPage_ClientID_PK PRIMARY KEY IDENTITY(1,1),
	ClientName VARCHAR(50),
	ClientAge INT,
	ClientGender VARCHAR(7),
	ClientEmail VARCHAR(100) NOT NULL,
	ClientPhoneNo VARCHAR(10),
	ClientInvestAmount BIGINT NOT NULL,
	Username VARCHAR(50) NOT NULL UNIQUE,
	Passwords VARCHAR(50) 
);

CREATE TABLE ResponseValueToWeightsAllocated (
	ResponseID INT NOT NULL CONSTRAINT ResponseValueToWeightsAllocated_ResponseID_PK PRIMARY KEY,
	WeightsAllocated FLOAT,
);

CREATE TABLE ClientResponse (
    ClientID BIGINT NOT NULL CONSTRAINT ClientResponse_ClientID_FK FOREIGN KEY REFERENCES ClientInfoPage,
    ResponseID INT NOT NULL CONSTRAINT ClientResponse_ResponseID_FK FOREIGN KEY REFERENCES ResponseValueToWeightsAllocated (ResponseID) ,
    ResponseValue FLOAT,
	CONSTRAINT ClientResponse_ClientID_ResponseID_CK PRIMARY KEY (ClientID, ResponseID)
);


--insert into ClientInfoPage values(1,'akshay',22,'male','3kshay@iitk.ac.in','239494',22939030,'3kshay4aswan','wrestle123');
--insert into ClientInfoPage values(2,'a3kshay',22,'male','3ksha2@iitk.ac.in','239493',22939230,'3kshay4aswan1',HASHBYTES('SHA1','@wrestle123'));
--drop table ClientInfoPage
--select * from ClientInfoPage

--CREATE TABLE ClientFinancialGoalsInfo (
--	ClientID INT NOT NULL CONSTRAINT ClientFinancialGoalsInfo_ClientID_FK FOREIGN KEY 
--);

---------------------------------------------------------------------------------------------------------------

CREATE TABLE Asset (
	AssetID INT NOT NULL CONSTRAINT ASSET_AssetID_PK PRIMARY KEY,
	AssetName VARCHAR(20),
	Risk FLOAT,
	Reward FLOAT
);

CREATE TABLE AllocatedAssetResult (
	ClientID BIGINT NOT NULL CONSTRAINT AllocatedAssetResult_ClientID_FK FOREIGN KEY REFERENCES ClientInfoPage,
	AssetID INT NOT NULL ,
	AllocatedRatio FLOAT,
	CONSTRAINT AllocatedAssetResult_ClientID_ResponseID_CK PRIMARY KEY (ClientID, AssetID)
);

CREATE TABLE FinancialGoals (
	ClientID BIGINT NOT NULL CONSTRAINT FinancialGoals_ClientID_FK FOREIGN KEY REFERENCES ClientInfoPage,
	GoalID BIGINT NOT NULL,
	GoalAmount BIGINT,
	CurrentYear INT DEFAULT year(getdate()),
	GoalYear INT NOT NULL,
	GoalsMet BIT DEFAULT NULL, 
	CONSTRAINT FinancialGoals_ClientID_GoalID_CK PRIMARY KEY (ClientID, GoalID)
);

INSERT INTO Asset VALUES (1,'Equities',16.60649836,8.725757576);
INSERT INTO Asset VALUES (2,'Treasury2',3.76208953783273,5.40424657534247);
INSERT INTO Asset VALUES (3,'Treasury3',3.67533203064266,5.61305283757338);
INSERT INTO Asset VALUES (4,'Treasury5',3.48753223688171,5.93506849315068);
INSERT INTO Asset VALUES (5,'Treasury7',3.31956364736342,6.16608610567515);
INSERT INTO Asset VALUES (6,'Treasury10',3.15608518805268,6.40667318982388);
INSERT INTO Asset VALUES (7,'Treasury20',3.05966991176694,6.80774951076321);
INSERT INTO Asset VALUES (8,'Treasury30',3.07257404729752,6.85528375733856);
INSERT INTO Asset VALUES (9,'AAA',1.902975434,7.624072289);
INSERT INTO Asset VALUES (10,'Cash',3.628574904091,4.83157382091596);




