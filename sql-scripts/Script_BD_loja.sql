CREATE SCHEMA loja;

CREATE SEQUENCE loja.jogo_id_seq START 1 INCREMENT 1;
CREATE SEQUENCE loja.cliente_id_seq START 1 INCREMENT 1;
CREATE SEQUENCE loja.compra_id_seq START 1 INCREMENT 1;
CREATE SEQUENCE loja.item_compra_id_seq START 1 INCREMENT 1;

CREATE TABLE loja.jogo (
	id_jogo INT DEFAULT nextval('loja.jogo_id_seq'),
	nome VARCHAR(200) NOT NULL,
	descricao VARCHAR(400) NOT NULL,
	preco NUMERIC(6,2) NOT NULL,
	lancamento DATE DEFAULT CURRENT_DATE,
	nota NUMERIC (4,2) NOT NULL,
	image_path VARCHAR(150),

	CONSTRAINT ck_jogo_preco CHECK (preco >= 0.00),
	CONSTRAINT ck_jogo_nota CHECK (nota >= 0.00 AND nota <= 10.0),
	CONSTRAINT uk_jogo_nome UNIQUE (nome),
	CONSTRAINT uk_jogo_image_path UNIQUE (image_path),
	CONSTRAINT pk_jogo PRIMARY KEY (id_jogo)
);

CREATE TABLE loja.categoria (
	nome_categoria VARCHAR(70),
	cat_id_jogo INT,

	CONSTRAINT fk_cat_nome_jogo FOREIGN KEY (cat_id_jogo) REFERENCES loja.jogo (id_jogo) ON DELETE CASCADE,
	CONSTRAINT pk_cat PRIMARY KEY (nome_categoria, cat_id_jogo)
);

CREATE TABLE loja.plataforma (
	nome_plataforma VARCHAR(70),
	plat_id_jogo INT,

	CONSTRAINT fk_plat_id_jogo FOREIGN KEY (plat_id_jogo) REFERENCES loja.jogo (id_jogo) ON DELETE CASCADE,
	CONSTRAINT pk_plat PRIMARY KEY (nome_plataforma, plat_id_jogo)
);

CREATE TABLE loja.desenvolvedor (
	nome_desenvolvedor VARCHAR(70),
	des_id_jogo INT,

	CONSTRAINT fk_des_id_jogo FOREIGN KEY (des_id_jogo) REFERENCES loja.jogo (id_jogo) ON DELETE CASCADE,
	CONSTRAINT pk_des PRIMARY KEY (nome_desenvolvedor, des_id_jogo)
);

CREATE TABLE loja.cliente (
	id_cliente INT DEFAULT nextval('loja.cliente_id_seq'),
	pnome VARCHAR(20) NOT NULL,
	snome VARCHAR(150) NOT NULL,
	endereco VARCHAR(200) NOT NULL,
	telefone CHAR(15) NOT NULL,
	email VARCHAR(100) NOT NULL,
	senha VARCHAR(100) NOT NULL,

	CONSTRAINT pk_cliente PRIMARY KEY (id_cliente),
	CONSTRAINT uk_cliente_email UNIQUE (email),
	CONSTRAINT uk_cliente_telefone UNIQUE (telefone)
);

CREATE TABLE loja.carrinho (
	car_id_cliente INT,
	car_id_jogo INT,
	car_qtd INT,

	CONSTRAINT ck_car_qtd CHECK (car_qtd > 0),
	CONSTRAINT fk_car_id_cliente FOREIGN KEY (car_id_cliente) REFERENCES loja.cliente (id_cliente) ON DELETE CASCADE,
	CONSTRAINT fk_car_id_jogo FOREIGN KEY (car_id_jogo) REFERENCES loja.jogo (id_jogo) ON DELETE CASCADE,
	CONSTRAINT pk_car PRIMARY KEY (car_id_cliente, car_id_jogo)
);

CREATE TABLE loja.compra (
	id_comp INT DEFAULT nextval ('loja.compra_id_seq'),
	comp_id_cliente INT,
	comp_preco NUMERIC (6,2), --preço total da compra

	CONSTRAINT fk_comp_id_cliente FOREIGN KEY (comp_id_cliente) REFERENCES loja.cliente (id_cliente) ON DELETE SET NULL,
	CONSTRAINT pk_comp PRIMARY KEY (id_comp)
);

CREATE TABLE loja.item_compra (
	id_item_comp INT DEFAULT nextval ('loja.item_compra_id_seq'), -- id dos itens da compra
	item_id_comp INT, -- id da compra
	item_id_jogo INT,
	item_nome_jogo VARCHAR(200),
	item_preco_jogo NUMERIC(6,2),
	item_qtd INT,

	CONSTRAINT ck_comp_qtd CHECK (item_qtd >= 0),
	CONSTRAINT fk_item_id_jogo FOREIGN KEY (item_id_jogo) REFERENCES loja.jogo (id_jogo) ON DELETE SET NULL,
	CONSTRAINT fk_item_id_comp FOREIGN KEY (item_id_comp) REFERENCES loja.compra (id_comp) ON DELETE CASCADE,
	CONSTRAINT pk_item PRIMARY KEY (id_item_comp)
);

CREATE TABLE loja.review (
	rev_id_jogo INT,
	rev_id_cliente INT,
	rev_comentario VARCHAR(400),
	rev_nota NUMERIC(4,2),
	rev_data DATE DEFAULT CURRENT_DATE,

	CONSTRAINT fk_rev_id_cliente FOREIGN KEY (rev_id_cliente) REFERENCES loja.cliente (id_cliente) ON DELETE CASCADE,
	CONSTRAINT fk_rev_id_jogo FOREIGN KEY (rev_id_jogo) REFERENCES loja.jogo (id_jogo) ON DELETE CASCADE,
	CONSTRAINT pk_review PRIMARY KEY (rev_id_jogo, rev_id_cliente),
	CONSTRAINT ck_rev_nota CHECK (rev_nota >= 0.00 AND rev_nota <= 10.0)
);