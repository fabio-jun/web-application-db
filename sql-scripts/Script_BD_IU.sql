-- ADICIONAR UM NOVO JOGO 
INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES ('God of War', 'jogo legal', 129.99, '2023-10-19', 9.80,'\imagens\God_of_war');
INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES ('Horizon', 'jogo interessante', 250.00, '2019-08-05', 5.78,'\imagens\Horizon');

-- ADICIONAR UMA CATEGORIA E ASSOCIÁ-LA A UM JOGO
INSERT INTO loja.categoria (nome_categoria,cat_id_jogo) VALUES ('ação', 1);
INSERT INTO loja.categoria (nome_categoria,cat_id_jogo) VALUES ('aventura', 2);

-- ADICIONAR UMA PLATAFORMA E ASSOCIÁ-LA A UM JOGO
INSERT INTO loja.plataforma (nome_plataforma, plat_id_jogo) VALUES ('PS4', 1);
INSERT INTO loja.plataforma (nome_plataforma, plat_id_jogo) VALUES ('XBOX', 2);

-- ADICIONAR UM DESENVOLVEDOR E ASSOCIÁ-LO A UM JOGO
INSERT INTO loja.desenvolvedor (nome_desenvolvedor, des_id_jogo) VALUES ('Santa Monica Studio', 1);
INSERT INTO loja.desenvolvedor (nome_desenvolvedor, des_id_jogo) VALUES ('Guerrilla Games', 2);

-- CADASTRAR UM NOVO CLIENTE
INSERT INTO loja.cliente (pnome, snome, endereco, telefone, email, senha) 
VALUES ('Jose', 'da silva', 'Avenida JK, 123', '55043912345678', 'josedasilva@gmail.com', 'jose123');

-- ADICIONAR ITENS AO CARRINHO
INSERT INTO loja.carrinho (car_id_cliente, car_id_jogo, car_qtd) VALUES (1, 1, 1);
INSERT INTO loja.carrinho (car_id_cliente, car_id_jogo, car_qtd) VALUES (1, 2, 2);

-- ATUALIZAR QUANTIDADE DE UM ITEM DO CARRINHO
UPDATE loja.carrinho SET car_qtd = 3 WHERE car_id_cliente = 1 AND car_id_jogo = 1;

-- REMOVER ITEM DO CARRINHO
DELETE FROM loja.carrinho WHERE car_id_cliente = 1 AND car_id_jogo = 1;

-- FINALIZAR COMPRA  --> INSERIR TABELA EM COMPRA, PASSAR OS ITENS E CALCULAR PRECO
INSERT INTO loja.compra (comp_id_cliente, comp_preco) VALUES (1, 889.97);

INSERT INTO loja.item_compra (item_id_comp, item_id_jogo, item_nome_jogo, item_preco_jogo, item_qtd) VALUES (1, 1, 'God of War', 129.99, 3);
INSERT INTO loja.item_compra (item_id_comp, item_id_jogo, item_nome_jogo, item_preco_jogo, item_qtd) VALUES (1, 2, 'Horizon', 250.00, 2);

-- CONSULTAR JOGOS POR CATEGORIA
SELECT j.nome, j.descricao, j.preco, j.lancamento, j.nota, j.image_path, c.nome_categoria, p.nome_plataforma, d.nome_desenvolvedor 
FROM loja.categoria c 
JOIN loja.jogo j ON c.cat_id_jogo = j.id_jogo
JOIN loja.plataforma p ON c.cat_id_jogo = p.plat_id_jogo 
JOIN loja.desenvolvedor d ON c.cat_id_jogo = d.des_id_jogo 
WHERE nome_categoria = 'ação';

-- CONSULTAR JOGOS POR PLATAFORMA
SELECT j.nome, j.descricao, j.preco, j.lancamento, j.nota, j.image_path, c.nome_categoria, p.nome_plataforma, d.nome_desenvolvedor 
FROM loja.plataforma p
JOIN loja.jogo j ON p.plat_id_jogo = j.id_jogo
JOIN loja.categoria c ON p.plat_id_jogo  = c.cat_id_jogo
JOIN loja.desenvolvedor d ON p.plat_id_jogo  = d.des_id_jogo 
WHERE nome_plataforma = 'XBOX';

-- CONSULTAR JOGOS POR DESENVOLVEDOR
SELECT j.nome, j.descricao, j.preco, j.lancamento, j.nota, j.image_path, c.nome_categoria, p.nome_plataforma, d.nome_desenvolvedor 
FROM loja.desenvolvedor d
JOIN loja.jogo j ON d.des_id_jogo = j.id_jogo
JOIN loja.categoria c ON d.des_id_jogo = c.cat_id_jogo
JOIN loja.plataforma p ON d.des_id_jogo = p.plat_id_jogo
WHERE nome_desenvolvedor = 'Santa Monica Studio';

--CONSULTAR COMPRAS POR CLIENTE
SELECT item_id_comp AS id_compra, id_item_comp AS id_item, item_nome_jogo AS nome_jogo, item_preco_jogo AS preco_jogo, item_qtd
FROM loja.item_compra
WHERE item_id_comp = 1;

-- ATUALIZAR INFORMAÇÕES DO CLIENTE
UPDATE loja.cliente 
SET pnome = 'Maria',
snome = 'Pinheiro',
endereco = 'Avenida Higienópolis, 456',
telefone = '55043987654321',
email = 'MariaPinheiro@gmail.com',
senha = 'maria456'
WHERE id_cliente = 1;

-- REMOVER JOGO
DELETE FROM loja.jogo WHERE nome = 'God of War'; --> ou utilizar id do jogo

-- REMOVER CLIENTE
DELETE FROM loja.cliente WHERE id_cliente = 1;

-- REMOVER COMPRA 
DELETE FROM loja.compra WHERE id_comp = 1;