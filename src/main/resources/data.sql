DROP TABLE IF EXISTS ARTICLES;

CREATE TABLE ARTICLES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  headline VARCHAR(250)  NOT NULL,
  description VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL
);

INSERT INTO ARTICLES (headline, description, author) VALUES
  ('Article-1', 'Lorem ipsum dolor sit amet, cum tation consequat ei. Nec ne populo discere adversarium. Dolores appareat eleifend ei his, ex mei errem voluptatum.', 'Name Surname'),
  ('Article-2', 'Lorem ipsum dolor sit amet, cum tation consequat ei. Nec ne populo discere adversarium. Dolores appareat eleifend ei his, ex mei errem voluptatum.', 'Name Surname'),
  ('Article-3', 'Lorem ipsum dolor sit amet, cum tation consequat ei. Nec ne populo discere adversarium. Dolores appareat eleifend ei his, ex mei errem voluptatum.', 'Name Surname');
