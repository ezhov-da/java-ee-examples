DROP TABLE IF EXISTS BOOK;

CREATE TABLE BOOK
(
  ID          INT AUTO_INCREMENT
  ,
  TITLE       VARCHAR(100)
  ,
  PRICE       DOUBLE
  ,
  NUMBER      VARCHAR(255)
  ,
  DESCRIPTION VARCHAR(500)
);

CREATE UNIQUE INDEX IF NOT EXISTS ID
  ON BOOK (ID);

SELECT
  ID,
  TITLE,
  PRICE,
  NUMBER,
  DESCRIPTION
FROM BOOK;

/*
INSERT INTO TBL_PROCESS_DEFINITION_VERSION
(ID, NAME, DEPLOYMENT_ID, DEFINITION_ID, CREATE_DT, USERNAME, DESCRIPTION)
VALUES
  (1, 'test1', 'ru.tander.bpm.research:StubSignalTest:1.0_SIGNAL_TEST', 'StubSignalTest.SignalTest',
   CURRENT_TIMESTAMP(), 'ezhov_da', 'тестовое описание одно для всех')
  , (2, 'test2', 'ru.tander.bpm.research:StubSignalTest:1.0_SIGNAL_TEST', 'StubSignalTest.SignalTest',
     CURRENT_TIMESTAMP(), 'ezhov_da', 'тестовое описание одно для всех')
  , (3, 'test3', 'ru.tander.bpm.research:StubSignalTest:1.0_SIGNAL_TEST', 'StubSignalTest.SignalTest',
     CURRENT_TIMESTAMP(), 'ezhov_da', 'тестовое описание одно для всех')
  , (4, 'test4', 'ru.tander.bpm.research:StubSignalTest:1.0_SIGNAL_TEST', 'StubSignalTest.SignalTest',
     CURRENT_TIMESTAMP(), 'ezhov_da', 'тестовое описание одно для всех')
  , (5, 'test5', 'ru.tander.bpm.research:StubSignalTest:1.0_SIGNAL_TEST', 'StubSignalTest.SignalTest',
     CURRENT_TIMESTAMP(), 'ezhov_da', 'тестовое описание одно для всех')
  , (6, 'test6', 'ru.tander.bpm.research:StubSignalTest:1.0_SIGNAL_TEST', 'StubSignalTest.SignalTest',
     CURRENT_TIMESTAMP(), 'ezhov_da', 'тестовое описание одно для всех');
*/