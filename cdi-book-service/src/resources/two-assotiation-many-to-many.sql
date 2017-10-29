DROP TABLE IF EXISTS T_E_TWO_ASSOTIATION_MANY_TO_MANY_ARTIST;

CREATE TABLE T_E_TWO_ASSOTIATION_MANY_TO_MANY_ARTIST
(
  ID   INT NOT NULL
  ,
  NAME VARCHAR(100)
);

DROP TABLE IF EXISTS T_E_TWO_ASSOTIATION_MANY_TO_MANY_CD;

CREATE TABLE T_E_TWO_ASSOTIATION_MANY_TO_MANY_CD
(
  ID   INT NOT NULL
  ,
  NAME VARCHAR(100)
);

DROP TABLE IF EXISTS T_E_TWO_ASSOTIATION_MANY_TO_MANY_LINK_CD_ARTIST;

CREATE TABLE T_E_TWO_ASSOTIATION_MANY_TO_MANY_LINK_CD_ARTIST
(
  ID_CD   INT NOT NULL
  ,
  ID_ARTIST INT NOT NULL
);

INSERT INTO T_E_TWO_ASSOTIATION_MANY_TO_MANY_ARTIST VALUES(1,'one_artist');
INSERT INTO T_E_TWO_ASSOTIATION_MANY_TO_MANY_ARTIST VALUES(2,'two_artist');

INSERT INTO T_E_TWO_ASSOTIATION_MANY_TO_MANY_CD VALUES(1,'one_cd');
INSERT INTO T_E_TWO_ASSOTIATION_MANY_TO_MANY_CD VALUES(2,'two_cd');

INSERT INTO T_E_TWO_ASSOTIATION_MANY_TO_MANY_LINK_CD_ARTIST VALUES(1,1);
INSERT INTO T_E_TWO_ASSOTIATION_MANY_TO_MANY_LINK_CD_ARTIST VALUES(1,2);
INSERT INTO T_E_TWO_ASSOTIATION_MANY_TO_MANY_LINK_CD_ARTIST VALUES(2,1);
INSERT INTO T_E_TWO_ASSOTIATION_MANY_TO_MANY_LINK_CD_ARTIST VALUES(2,2);


SELECT * FROM T_E_TWO_ASSOTIATION_MANY_TO_MANY_ARTIST;
SELECT * FROM T_E_TWO_ASSOTIATION_MANY_TO_MANY_CD;
SELECT * FROM T_E_TWO_ASSOTIATION_MANY_TO_MANY_LINK_CD_ARTIST;