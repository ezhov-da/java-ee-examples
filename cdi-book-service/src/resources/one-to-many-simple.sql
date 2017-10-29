DROP TABLE IF EXISTS T_E_NOTE_TEST_ONE_TO_MANY;

SELECT *
FROM T_E_NOTE;

CREATE TABLE T_E_NOTE_TEST_ONE_TO_MANY
(
  ID_USER INT                NOT NULL
  ,
  ID      INT AUTO_INCREMENT NOT NULL
  ,
  NAME    VARCHAR(500)       NOT NULL
);

INSERT INTO T_E_NOTE_TEST_ONE_TO_MANY (ID_USER, ID, NAME) SELECT
                                                            1,
                                                            ID,
                                                            NAME
                                                          FROM T_E_NOTE;

SELECT * FROM T_E_NOTE_TEST_ONE_TO_MANY
