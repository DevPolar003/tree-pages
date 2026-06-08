
CREATE TYPE status_read AS ENUM ('READING', 'COMPLETED', 'ABANDONED');
CREATE TYPE theme AS ENUM ('FOREST', 'JAPANESE', 'TROPICAL', 'DESERT');
CREATE TYPE tree_type AS ENUM ('QUARESMEIRA', 'JACARANDA', 'SIBIPURUNA', 'PAU_BRASIL', 'IPE_BRANCO', 'EUCALIPTO');
CREATE TYPE transaction_type AS ENUM ('SPENT', 'EARNED');


CREATE TABLE Reader (
                        id                 BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                        nome               VARCHAR(200)             NOT NULL,
                        email              VARCHAR(100)             NOT NULL UNIQUE,
                        wallet             NUMERIC(10, 2) DEFAULT 0 NOT NULL CHECK (wallet >= 0),
                        streak_days        INT            DEFAULT 0 CHECK (streak_days >= 0),
                        total_minutes_read INT            DEFAULT 0 CHECK (total_minutes_read >= 0)
);

CREATE TABLE Garden (
                        id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                        reader_id  BIGINT NOT NULL,
                        nome       VARCHAR(50),
                        theme      theme DEFAULT 'FOREST',
                        created_at TIMESTAMP,
                        CONSTRAINT fk_garden_reader FOREIGN KEY (reader_id) REFERENCES reader (id)
);


CREATE TABLE Book (
                      id             BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                      garden_id      BIGINT       NOT NULL,
                      reader_id      BIGINT       NOT NULL,
                      title          VARCHAR(150) NOT NULL,
                      author         VARCHAR(120) NOT NULL,
                      page_count     INT DEFAULT 0,
                      reading_status status_read  NOT NULL,
                      CONSTRAINT fk_book_garden FOREIGN KEY (garden_id) REFERENCES garden (id),
                      CONSTRAINT fk_book_reader FOREIGN KEY (reader_id) REFERENCES reader (id)
);

CREATE TABLE Tree (
                      id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                      book_id         BIGINT NOT NULL,
                      garden_id       BIGINT NOT NULL,
                      tree_type       tree_type,
                      growth_progress INT DEFAULT 0,
                      CONSTRAINT fk_tree_book FOREIGN KEY (book_id) REFERENCES book (id),
                      CONSTRAINT fk_tree_garden FOREIGN KEY (garden_id) REFERENCES garden (id)
);

CREATE TABLE reading_session (
                                 id               BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                 reader_id        BIGINT    NOT NULL,
                                 book_id          BIGINT    NOT NULL,
                                 start_time       TIMESTAMP NOT NULL,
                                 end_time         TIMESTAMP NOT NULL,
                                 duration_minutes INT       NOT NULL CHECK (duration_minutes >= 0),
                                 CONSTRAINT fk_session_reader FOREIGN KEY (reader_id) REFERENCES reader (id),
                                 CONSTRAINT fk_session_book FOREIGN KEY (book_id) REFERENCES book (id)
);

CREATE TABLE coin_transaction (
                                  id               BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                  reader_id        BIGINT NOT NULL,
                                  amount           BIGINT DEFAULT 0,
                                  create_at        DATE,
                                  description      VARCHAR(300),
                                  transaction_type transaction_type,
                                  CONSTRAINT fk_transaction_reader FOREIGN KEY (reader_id) REFERENCES reader (id)
);
