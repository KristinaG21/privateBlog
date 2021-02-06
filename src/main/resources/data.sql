DROP TABLE IF EXISTS ARTICLES;

CREATE TABLE ARTICLES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  headline VARCHAR(250) NOT NULL,
  body VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL,
  date_time VARCHAR(250) NOT NULL
);

INSERT INTO ARTICLES (headline,body,author,date_time) VALUES
  ('Article-1', 'Lorem ipsum dolor sit amet, cum tation consequat ei. Nec ne populo discere adversarium. Dolores appareat eleifend ei his, ex mei errem voluptatum.', 'Name Surname','September 6'),
  ('Article-2', 'Lorem ipsum dolor sit amet, cum tation consequat ei. Nec ne populo discere adversarium. Dolores appareat eleifend ei his, ex mei errem voluptatum.', 'Name Surname','October 9 '),
  ('Article-3', 'Lorem ipsum dolor sit amet, cum tation consequat ei. Nec ne populo discere adversarium. Dolores appareat eleifend ei his, ex mei errem voluptatum.', 'Name Surname','December 10');
