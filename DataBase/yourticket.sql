DROP DATABASE IF EXISTS yourticketdb WITH (FORCE);
CREATE DATABASE yourticketdb;

ALTER DATABASE yourticketdb OWNER TO postgres;

\c yourticketdb;

GRANT ALL PRIVILEGES ON DATABASE yourticketdb TO postgres;


/**********************************USERS*******************************/
DROP TABLE IF EXISTS trole;
CREATE TABLE trole(
    roleID INTEGER,
    description VARCHAR(15),

    PRIMARY KEY(roleID)
);

DROP TABLE IF EXISTS tuser;
CREATE TABLE tuser(
    userID SERIAL,
    userName VARCHAR(50) UNIQUE,
    userPassword VARCHAR(130),
    available BOOLEAN,
    roleID INTEGER,

    PRIMARY KEY(userID),
    FOREIGN KEY(roleID) REFERENCES trole(roleID)
);

/***************************USERS INFORMATION************************/
DROP TABLE IF EXISTS tcustomer;
CREATE TABLE tcustomer(
    customerID SERIAL,
    name VARCHAR(30),
    lastName VARCHAR(50),
    birthDay DATE,
    country VARCHAR(30),
    addres VARCHAR (100),
    email VARCHAR(50),
    phoneNumber VARCHAR(15),
    userID INTEGER,

    PRIMARY KEY(customerID),
    FOREIGN KEY(userID) REFERENCES tuser(userID)
);

DROP TABLE IF EXISTS tseller;
CREATE TABLE tseller(
    sellerID SERIAL,
    name VARCHAR(100),
    information TEXT,
    rfc VARCHAR(20),
    country VARCHAR(30),
    addres VARCHAR (100),
    email VARCHAR(50),
    phoneNumber VARCHAR(15),
    userID INTEGER,

    PRIMARY KEY(sellerID),
    FOREIGN KEY(userID) REFERENCES tuser(userID)
);




/***************************EVENTS INFORMATION************************/
DROP TABLE IF EXISTS tevent;
CREATE TABLE tevent(
    eventID SERIAL,
    eventName VARCHAR(100),
	eventImg VARCHAR(150),
    information TEXT,
    location VARCHAR(250),
    eventDay TIMESTAMP,
    status VARCHAR(20),
    userID INTEGER,

    PRIMARY KEY(eventID),
    FOREIGN KEY(userID) REFERENCES tuser(userID)
);

DROP TABLE IF EXISTS teventzone;
CREATE TABLE teventzone(
    zoneID SERIAL,
    zoneName VARCHAR(20),
    ticketPrice NUMERIC(8,2),
    eventID INTEGER,

    PRIMARY KEY(zoneID),
    FOREIGN KEY(eventID) REFERENCES tevent(eventID)
);

DROP TABLE IF EXISTS trowzone;
CREATE TABLE trowzone(
    rowID SERIAL,
    rowName VARCHAR(10),
    zoneID INTEGER,

    PRIMARY KEY(rowID),
    FOREIGN KEY(zoneID) REFERENCES teventzone(zoneID)
);

DROP TABLE IF EXISTS tseatrow;
CREATE TABLE tseatrow(
    seatID SERIAL,
    seatNumber INTEGER,
    avalaible BOOLEAN,
    rowID INTEGER,

    PRIMARY KEY(seatID),
    FOREIGN KEY(rowID) REFERENCES trowzone(rowID)
);

/********************************ORDERS INFORMATIONS************************************/
DROP TABLE IF EXISTS torder;
CREATE TABLE torder(
    orderID SERIAL,
    paymentMethod VARCHAR(40),
    orderDate TIMESTAMP,
    status VARCHAR(20),
    seatID INTEGER,
    userID INTEGER,

    PRIMARY KEY(orderID),
    FOREIGN KEY(seatID) REFERENCES tseatrow(seatID),
    FOREIGN KEY(userID) REFERENCES tuser(userID)
);

DROP TABLE IF EXISTS torderhistory;
CREATE TABLE torderhistory(
    orderHistoryID SERIAL,
    paymentMethod VARCHAR(40),
    eventDate TIMESTAMP,
    seatNumber INTEGER,
    rowName VARCHAR(10),
    zoneName VARCHAR(20),
    eventName VARCHAR(100),
    location VARCHAR(250),
    userID INTEGER,

    PRIMARY KEY(orderHistoryID),
    FOREIGN KEY(userID) REFERENCES tuser(userID)
);

/************************************CHECK IN*************************/
DROP TABLE IF EXISTS teticket;
CREATE TABLE teticket(
    teticket VARCHAR(250),
    orderID INTEGER,

    PRIMARY KEY(teticket),
    FOREIGN KEY(orderID) REFERENCES torder(orderID)
);

DROP TABLE IF EXISTS tcheckin;
CREATE TABLE tcheckin(
    ckeckID SERIAL,
    checkDate TIMESTAMP,
    teticket VARCHAR(250),
    orderID INTEGER,

    PRIMARY KEY(ckeckID),
    FOREIGN KEY(teticket) REFERENCES teticket(teticket),
    FOREIGN KEY(orderID) REFERENCES torder(orderID)
);



/********************************************INSERTS*******************************************/
--ROLE
INSERT INTO trole(roleID, description) VALUES(1, 'ADMIN');
INSERT INTO trole(roleID, description) VALUES(2, 'USER');
INSERT INTO trole(roleID, description) VALUES(3, 'SELLER');
--USER
--Pass123
--INSERT INTO tuser(userName,userPassword,available,roleID) VALUES('fredy.user', '$2a$10$KauXPE.nJdYTPcMIpsFfv.GearOVeNgmPVo6iv2jOeWrRAfNpveEK', TRUE, 2);
--USERSELLER
--Pass123
--INSERT INTO tuser(userName,userPassword,available,roleID) VALUES('fredy.seller', '$2a$10$KauXPE.nJdYTPcMIpsFfv.GearOVeNgmPVo6iv2jOeWrRAfNpveEK', TRUE, 3);

--CUSTOMER
--INSERT INTO tcustomer(name,lastName,birthDay,country,addres,email,phoneNumber,userID) VALUES('Fredy', 'Gutierrez Santos', '24-04-1998', 'Mexico', 'Avenida Siempre Viva #18 Colonia San Caralampio, EDOMX', 'fredy.gtsantos@gmail.com', '+525556847138', 1);
--SELLER
--INSERT INTO tseller(name,information,rfc,country,addres,email,phoneNumber,userID) VALUES('TICKETON S.A DE C.V', 'Ticketon empresa lider en organización de eventos masivos', 'TION650618NH5', 'Mexico', 'Mar Muerto #160 Colonia Miguel Hidalgo, CDMX', 'ticketon@gmail.com', '+525549345290', 2);
