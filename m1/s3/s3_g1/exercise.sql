CREATE TABLE fornitori(
	numeroFornitore SERIAL PRIMARY KEY,
	denominazione VARCHAR NOT NULL,
	regioneResidenza VARCHAR NOT NULL
);

CREATE TABLE prodotti(
	id SERIAL PRIMARY KEY,
	descrizione VARCHAR DEFAULT 'Not available',
	inProduzione BOOL NOT NULL,
	inCommercio BOOL NOT NULL,
	dataAttivazione DATE DEFAULT CURRENT_DATE,
	dataDisattivazione DATE DEFAULT '01-01-2100'
);

CREATE TABLE clienti(
	numeroCliente SERIAL PRIMARY KEY,
	nome VARCHAR NOT NULL,
	cognome VARCHAR NOT NULL,
	dataNascita DATE NOT NULL,
	regioneResidenza VARCHAR NOT NULL
);

CREATE TABLE fatture(
	numeroFattura SERIAL PRIMARY KEY,
	tipologia VARCHAR NOT NULL,
	importo INTEGER NOT NULL,
	IVA INTEGER NOT NULL,
	idCliente INTEGER NOT NULL,
	dataFattura DATE NOT NULL,
	numeroFornitore INTEGER NOT NULL,
	CONSTRAINT fattura_cliente_pk FOREIGN KEY (idCliente) REFERENCES clienti (numeroCliente),
	CONSTRAINT fattura_fornitore_pk FOREIGN KEY (numeroFornitore) REFERENCES fornitori (numeroFornitore)
);

-- fix date
ALTER TABLE prodotti ALTER COLUMN dataDisattivazione SET DEFAULT '2100-01-01';


-- creazione entità
INSERT INTO fornitori (denominazione, regioneResidenza) VALUES ('Lizzo Corp', 'Lazio');
INSERT INTO fornitori (denominazione, regioneResidenza) VALUES ('Umberto Corp', 'Lazio');
INSERT INTO fornitori (denominazione, regioneResidenza) VALUES ('Ema Corp', 'Lombardia');
INSERT INTO fornitori (denominazione, regioneResidenza) VALUES ('Anonym Corp', 'Sicilia');

INSERT INTO prodotti (descrizione, inproduzione, incommercio, dataattivazione, datadisattivazione) VALUES ('Olographic interface', true, false, '2017-02-04', '2100-01-01');
INSERT INTO prodotti (descrizione, inproduzione, incommercio, dataattivazione, datadisattivazione) VALUES ('AI Assistant', true, true, '2017-09-01', '2035-01-01');
INSERT INTO prodotti (descrizione, inproduzione, incommercio, dataattivazione, datadisattivazione) VALUES ('Iron Man Suite', true, false, '2022-08-07', '2029-01-01');
INSERT INTO prodotti (descrizione, inproduzione, incommercio, dataattivazione, datadisattivazione) VALUES ('Hydrogen Car', true, true, '2021-06-04', '2040-01-01');
INSERT INTO prodotti (descrizione, inproduzione, incommercio, dataattivazione, datadisattivazione) VALUES ('Flying Car', true, false, '2017-05-05', '2031-02-01');

INSERT INTO clienti (nome, cognome, datanascita, regioneresidenza) VALUES ('Mario', 'Americano', '1978-03-09', 'Veneto');
INSERT INTO clienti (nome, cognome, datanascita, regioneresidenza) VALUES ('Gino', 'Tedesco', '1985-01-04', 'Molise');
INSERT INTO clienti (nome, cognome, datanascita, regioneresidenza) VALUES ('Marco', 'Norvegese', '1990-02-06', 'Lazio');
INSERT INTO clienti (nome, cognome, datanascita, regioneresidenza) VALUES ('Chiara', 'Cinese', '1992-11-09', 'Sardegna');
INSERT INTO clienti (nome, cognome, datanascita, regioneresidenza) VALUES ('Marta', 'Svedese', '1969-02-12', 'Liguria');
INSERT INTO clienti (nome, cognome, datanascita, regioneresidenza) VALUES ('Gianna', 'Colombiana', '1987-10-10', 'Marche');

INSERT INTO fatture (tipologia, importo, iva, idCliente, dataFattura, numeroFornitore)
VALUES ('A', 7800, 20, 2, '2023-02-02', 1);
INSERT INTO fatture (tipologia, importo, iva, idCliente, dataFattura, numeroFornitore)
VALUES ('A', 18900, 20, 4, '2022-01-01', 2);
INSERT INTO fatture (tipologia, importo, iva, idCliente, dataFattura, numeroFornitore)
VALUES ('A', 2400, 22, 3, '2020-05-05', 3);
INSERT INTO fatture (tipologia, importo, iva, idCliente, dataFattura, numeroFornitore)
VALUES ('B', 1100, 22, 3, '2021-05-05', 3);
INSERT INTO fatture (tipologia, importo, iva, idCliente, dataFattura, numeroFornitore)
VALUES ('B', 900, 22, 4, '2022-03-03', 4);
INSERT INTO fatture (tipologia, importo, iva, idCliente, dataFattura, numeroFornitore)
VALUES ('C', 290, 22, 5, '2023-01-01', 2);
INSERT INTO fatture (tipologia, importo, iva, idCliente, dataFattura, numeroFornitore)
VALUES ('A', 21590, 20, 5, '2022-07-07', 1);
INSERT INTO fatture (tipologia, importo, iva, idCliente, dataFattura, numeroFornitore)
VALUES ('A', 14590, 20, 1, '2019-08-08', 4);


-- alterazione dati per esercizio
UPDATE clienti SET datanascita = '1982-02-06' WHERE numerocliente = 1;
UPDATE clienti SET datanascita = '1982-04-01' WHERE numerocliente = 6;


-- queries

-- es.1
SELECT nome, cognome FROM clienti WHERE EXTRACT(YEAR FROM datanascita) = '1982';

-- es.2
SELECT COUNT(*) AS num_fatture FROM fatture WHERE iva = 20;

-- es.3
SELECT EXTRACT(YEAR FROM dataFattura) AS anno, COUNT(*) AS num_fatture, SUM(importo) AS somma FROM fatture GROUP BY EXTRACT(YEAR from dataFattura);

-- es.4
SELECT * FROM prodotti WHERE EXTRACT(YEAR FROM dataattivazione) = 2017 AND (inproduzione = true OR incommercio = true);

-- es.5
SELECT EXTRACT(YEAR FROM dataFattura) AS anno, COUNT(*) AS numero FROM fatture WHERE iva = 20 GROUP BY EXTRACT(YEAR FROM dataFattura);

-- es.6
SELECT EXTRACT(YEAR FROM dataFattura) AS anno FROM fatture WHERE tipologia = 'A' GROUP BY EXTRACT(YEAR FROM dataFattura) HAVING COUNT(*) >= 2;

-- es.7
SELECT numeroFattura, importo, iva, dataFattura, fornitori.denominazione AS nomeeee FROM fatture LEFT JOIN fornitori ON fatture.numeroFornitore = fornitori.numeroFornitore;

-- es.8
SELECT SUM(importo) FROM fatture 
INNER JOIN clienti ON fatture.idCliente = clienti.numeroCliente 
GROUP BY clienti.regioneResidenza;

-- es.9
SELECT COUNT(*) FROM fatture 
INNER JOIN clienti ON fatture.idCliente = clienti.numeroCliente 
WHERE EXTRACT(YEAR FROM clienti.dataNascita) = 1982 AND importo > 50;

-- es.10
-- fix per la query
UPDATE clienti SET regioneResidenza = 'Lombardia' WHERE numeroCliente = 2;
UPDATE clienti SET regioneResidenza = 'Lombardia' WHERE numeroCliente = 3;

SELECT CONCAT(nome, '-', cognome) AS denominazione FROM clienti
WHERE regioneResidenza = 'Lombardia';














