DROP TABLE IF EXISTS T_E_INHERITANCE_SINGLE_TABLE;

CREATE TABLE T_E_INHERITANCE_SINGLE_TABLE
(
  ID INT NOT NULL AUTO_INCREMENT
  //Столбец по умолчанию, куда сохраняется название класса.
  //Можно изменить название и тип с помощью аннотации @DiscriminatorColumn,
  //а так же изменить идентификаторы для основного класса подклассов с помощью аннотации: @DiscriminatorValue
  ,DTYPE VARCHAR(256)
  ,NAME VARCHAR(256)
  ,NUMBER VARCHAR(256)
  ,AUTHOR VARCHAR(256)
);

SELECT * FROM T_E_INHERITANCE_SINGLE_TABLE;