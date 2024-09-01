-- ADICIONAR UM NOVO JOGO 
INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES ('God of War',
'Com a vingança contra os deuses do Olimpo em um passado distante, Kratos agora vive como um mortal no reino dos deuses e monstros nórdicos.',
129.99, '2023-10-19', 9.40,'\imagens\God_of_war');

INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES ('Horizon Zero Dawn', 
'Viva a experiência de Aloy dos Nora em sua busca lendária para desvendar os mistérios de um mundo controlado por Máquinas mortais.',
89.90, '2019-08-05', 8.90,'\imagens\Horizon_Zero_Dawn');

INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES ('Final Fantasy VII Rebirth', 
'Descubra um mundo vasto e vibrante neste lançamento independente do projeto de remake de Final Fantasy VII.',
349.90, '2024-02-29', 9.20,'\imagens\Final_Fantasy_VII_Rebirth');

INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES ('Demons Souls', 
'Totalmente reconstruído do zero, este remake convida você a vivenciar a história inquietante e o combate cruel de Demons Souls™.',
325.49, '2020-11-12', 9.20,'\imagens\Demons_Souls');

INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES ('Forza Horizon 4', 
'Pela primeira vez no gênero de corrida e automóveis, experimente temporadas dinâmicas em um mundo aberto compartilhado.',
50.25, '2018-09-28', 9.20,'\imagens\Forza_Horizon_4');

INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES ('Halo 5: Guardians', 
'Halo 5: Guardians oferece uma experiência multijogador épica com vários modos, ferramentas completas para criação de níveis e um novo capítulo da saga do Master Chief.',
99.00, '2015-10-26', 9.20,'\imagens\Halo_5_Guardians');

INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES ('Microsoft Flight Simulator', 
'Vá para os céus e experimente a alegria de voar na próxima geração do Microsoft Flight Simulator. O mundo está ao seu alcance.',
249.95, '2020-08-18', 9.00,'\imagens\Microsoft_Flight_Simulator');

INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES ('Halo Infinite', 
'Quando toda a esperança está perdida e o destino da humanidade está em jogo, o Master Chief está pronto para enfrentar o inimigo mais implacável que já enfrentou',
299.00, '2021-12-08', 8.70,'\imagens\Halo_Infinite');

INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES ('The Legend of Zelda: Breath of the Wild', 
'Entre em um mundo de descobertas, exploração e aventura em The Legend of Zelda: Breath of the Wild, o novo jogo da famosa série que veio para romper barreiras.',
299.00, '2017-03-03', 9.70,'\imagens\The_Legend_of_Zelda_Breath_of_the_Wild');

INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES ('Super Mario Odyssey', 
'Explore lugares incríveis longe do Reino Cogumelo com o Mario e o novo aliado Cappy em uma imensa aventura 3D ao redor do mundo.',
299.00, '2017-10-27', 9.70,'\imagens\Super_Mario_Odyssey');

INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES ('Disco Elysium: The Final Cut', 
'Você é um detetive com um sistema de habilidades único à sua disposição, e um caminho a ser trilhado por todo um quarteirão de uma cidade.',
249.95, '2019-10-15', 9.00,'\imagens\Disco_Elysium_The_Final_Cut');

INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES ('Stardew Valley',
'Você herdou a antiga fazenda do seu avô, em Stardew Valley. Com ferramentas de segunda-mão e algumas moedas, você parte para dar início a sua nova vida.',
24.99, '2016-02-26', 8.90,'\imagens\Stardew_Valley');

INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES ('Baldurs Gate 3',
'Reúna seu grupo e volte aos Reinos Esquecidos em uma história de amizade e traição, sacrifício e sobrevivência, e tentação pelo poder absoluto.',
199.99, '2023-08-03', 9.60,'\imagens\Baldurs_Gate_3');

-- ADICIONAR UMA CATEGORIA E ASSOCIÁ-LA A UM JOGO
INSERT INTO loja.categoria (nome_categoria,cat_id_jogo) VALUES ('acao', 1);
INSERT INTO loja.categoria (nome_categoria,cat_id_jogo) VALUES ('aventura', 2);
INSERT INTO loja.categoria (nome_categoria,cat_id_jogo) VALUES ('rpg', 3);
INSERT INTO loja.categoria (nome_categoria,cat_id_jogo) VALUES ('rpg', 4);
INSERT INTO loja.categoria (nome_categoria,cat_id_jogo) VALUES ('corrida', 5);
INSERT INTO loja.categoria (nome_categoria,cat_id_jogo) VALUES ('fps', 6);
INSERT INTO loja.categoria (nome_categoria,cat_id_jogo) VALUES ('simulador', 7);
INSERT INTO loja.categoria (nome_categoria,cat_id_jogo) VALUES ('fps', 8);
INSERT INTO loja.categoria (nome_categoria,cat_id_jogo) VALUES ('rpg', 9);
INSERT INTO loja.categoria (nome_categoria,cat_id_jogo) VALUES ('aventura', 10);
INSERT INTO loja.categoria (nome_categoria,cat_id_jogo) VALUES ('rpg', 11);
INSERT INTO loja.categoria (nome_categoria,cat_id_jogo) VALUES ('simulador', 12);
INSERT INTO loja.categoria (nome_categoria,cat_id_jogo) VALUES ('rpg', 13);

-- ADICIONAR UMA PLATAFORMA E ASSOCIÁ-LA A UM JOGO
INSERT INTO loja.plataforma (nome_plataforma, plat_id_jogo) VALUES ('PS4', 1);
INSERT INTO loja.plataforma (nome_plataforma, plat_id_jogo) VALUES ('PS4', 2);
INSERT INTO loja.plataforma (nome_plataforma, plat_id_jogo) VALUES ('PS5', 3);
INSERT INTO loja.plataforma (nome_plataforma, plat_id_jogo) VALUES ('PS5', 4);
INSERT INTO loja.plataforma (nome_plataforma, plat_id_jogo) VALUES ('XBOX', 5);
INSERT INTO loja.plataforma (nome_plataforma, plat_id_jogo) VALUES ('XBOX', 6);
INSERT INTO loja.plataforma (nome_plataforma, plat_id_jogo) VALUES ('XBOXSX', 7);
INSERT INTO loja.plataforma (nome_plataforma, plat_id_jogo) VALUES ('XBOXSX', 8);
INSERT INTO loja.plataforma (nome_plataforma, plat_id_jogo) VALUES ('SWITCH', 9);
INSERT INTO loja.plataforma (nome_plataforma, plat_id_jogo) VALUES ('SWITCH', 10);
INSERT INTO loja.plataforma (nome_plataforma, plat_id_jogo) VALUES ('SWITCH', 11);
INSERT INTO loja.plataforma (nome_plataforma, plat_id_jogo) VALUES ('SWITCH', 12);
INSERT INTO loja.plataforma (nome_plataforma, plat_id_jogo) VALUES ('SWITCH', 13);

-- ADICIONAR UM DESENVOLVEDOR E ASSOCIÁ-LO A UM JOGO
INSERT INTO loja.desenvolvedor (nome_desenvolvedor, des_id_jogo) VALUES ('Santa Monica Studio', 1);
INSERT INTO loja.desenvolvedor (nome_desenvolvedor, des_id_jogo) VALUES ('Guerrilla Games', 2);
INSERT INTO loja.desenvolvedor (nome_desenvolvedor, des_id_jogo) VALUES ('Square Enix', 3);
INSERT INTO loja.desenvolvedor (nome_desenvolvedor, des_id_jogo) VALUES ('Blue Point', 4);
INSERT INTO loja.desenvolvedor (nome_desenvolvedor, des_id_jogo) VALUES ('Playground Games', 5);
INSERT INTO loja.desenvolvedor (nome_desenvolvedor, des_id_jogo) VALUES ('343 Industries', 6);
INSERT INTO loja.desenvolvedor (nome_desenvolvedor, des_id_jogo) VALUES ('Asobo Studio', 7);
INSERT INTO loja.desenvolvedor (nome_desenvolvedor, des_id_jogo) VALUES ('343 Industries', 8);
INSERT INTO loja.desenvolvedor (nome_desenvolvedor, des_id_jogo) VALUES ('Nintendo', 9);
INSERT INTO loja.desenvolvedor (nome_desenvolvedor, des_id_jogo) VALUES ('Nintendo', 10);
INSERT INTO loja.desenvolvedor (nome_desenvolvedor, des_id_jogo) VALUES ('ZA/UM', 11);
INSERT INTO loja.desenvolvedor (nome_desenvolvedor, des_id_jogo) VALUES ('ConcernedApe', 12);
INSERT INTO loja.desenvolvedor (nome_desenvolvedor, des_id_jogo) VALUES ('Larian Studios', 13);

-- CADASTRAR UM NOVO CLIENTE
INSERT INTO loja.cliente (pnome, snome, endereco, telefone, email, senha) 
VALUES ('Jose', 'da Silva', 'Avenida JK, 123', '43912345678', 'josedasilva@gmail.com', 'jose123');

-- CADASTRAR UM NOVO CLIENTE
INSERT INTO loja.cliente (pnome, snome, endereco, telefone, email, senha) 
VALUES ('Maria', 'das Dores', 'Avenida Higienópolis, 1024', '43912345123', 'mariadasdores@gmail.com', 'maria1024');

-- ADICIONAR ITENS AO CARRINHO
INSERT INTO loja.carrinho (car_id_cliente, car_id_jogo, car_qtd) VALUES (1, 1, 1);
INSERT INTO loja.carrinho (car_id_cliente, car_id_jogo, car_qtd) VALUES (1, 2, 2);

INSERT INTO loja.carrinho (car_id_cliente, car_id_jogo, car_qtd) VALUES (2, 3, 2);
INSERT INTO loja.carrinho (car_id_cliente, car_id_jogo, car_qtd) VALUES (2, 4, 3);

-- ADICIONAR REVIEWS PARA OS JOGOS
INSERT INTO loja.review (rev_id_jogo, rev_id_cliente, rev_comentario, rev_nota) 
VALUES (1, 1, 'Jogo incrível, ótima história e gráficos impressionantes', 9.6);

INSERT INTO loja.review (rev_id_jogo, rev_id_cliente, rev_comentario, rev_nota) 
VALUES (2, 1, 'Achei o jogo interessante, mas poderia ter mais variedade de missões.', 6.5);

INSERT INTO loja.review (rev_id_jogo, rev_id_cliente, rev_comentario, rev_nota) 
VALUES (3, 2, 'Jogo chato, muito repetitivo', 3.0);

INSERT INTO loja.review (rev_id_jogo, rev_id_cliente, rev_comentario, rev_nota) 
VALUES (4, 2, 'Achei muito difícil, perdi o interesse.', 5.5);

-- ATUALIZAR QUANTIDADE DE UM ITEM DO CARRINHO
UPDATE loja.carrinho SET car_qtd = 3 WHERE car_id_cliente = 1 AND car_id_jogo = 1;
UPDATE loja.carrinho SET car_qtd = 3 WHERE car_id_cliente = 2 AND car_id_jogo = 3;

-- REMOVER ITEM DO CARRINHO
DELETE FROM loja.carrinho WHERE car_id_cliente = 1 AND car_id_jogo = 1;
DELETE FROM loja.carrinho WHERE car_id_cliente = 2 AND car_id_jogo = 4;

-- FINALIZAR COMPRA  --> INSERIR TABELA EM COMPRA, PASSAR OS ITENS E CALCULAR PRECO
INSERT INTO loja.compra (comp_id_cliente, comp_preco) VALUES (1, 309.79);

INSERT INTO loja.item_compra (item_id_comp, item_id_jogo, item_nome_jogo, item_preco_jogo, item_qtd) VALUES (1, 1, 'God of War', 129.99, 3);
INSERT INTO loja.item_compra (item_id_comp, item_id_jogo, item_nome_jogo, item_preco_jogo, item_qtd) VALUES (1, 2, 'Horizon', 89.90, 2);

INSERT INTO loja.compra (comp_id_cliente, comp_preco) VALUES (2, 675.39);

INSERT INTO loja.item_compra (item_id_comp, item_id_jogo, item_nome_jogo, item_preco_jogo, item_qtd) VALUES (2, 3, 'Final Fantasy VII Rebirth', 349.90, 1);
INSERT INTO loja.item_compra (item_id_comp, item_id_jogo, item_nome_jogo, item_preco_jogo, item_qtd) VALUES (2, 4, 'Demons Souls', 325.49, 1);

-- CONSULTAR JOGOS POR CATEGORIA
SELECT j.nome, j.descricao, j.preco, j.lancamento, j.nota, j.image_path, c.nome_categoria, p.nome_plataforma, d.nome_desenvolvedor 
FROM loja.categoria c 
JOIN loja.jogo j ON c.cat_id_jogo = j.id_jogo
JOIN loja.plataforma p ON c.cat_id_jogo = p.plat_id_jogo 
JOIN loja.desenvolvedor d ON c.cat_id_jogo = d.des_id_jogo 
WHERE nome_categoria = 'fps';

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

-- CONSULTAR REVIEWS DE UM JOGO
SELECT rev_id_cliente, rev_comentario, rev_nota, rev_data
FROM loja.review
WHERE rev_id_jogo = 1;

-- CONSULTAR REVIEWS DE UM CLIENTE
SELECT rev_id_jogo, rev_comentario, rev_nota, rev_data
FROM loja.review
WHERE rev_id_cliente = 1;

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

-- REMOVER REVIEW DE UM CLIENTE PARA UM JOGO
DELETE FROM loja.review 
WHERE rev_id_jogo = 1 AND rev_id_cliente = 1;

--CONSULTAR COMPRAS POR CLIENTE
SELECT item_id_comp AS id_compra, id_item_comp AS id_item, item_nome_jogo AS nome_jogo, item_preco_jogo AS preco_jogo, item_qtd
FROM loja.item_compra
WHERE item_id_comp = 1;

-- CONSULTAR REVIEWS DE UM CLIENTE
SELECT rev_id_jogo, rev_comentario, rev_nota, rev_data
FROM loja.review
WHERE rev_id_cliente = 1;

--CONSULTAR COMPRAS POR CLIENTE
SELECT item_id_comp AS id_compra, id_item_comp AS id_item, item_nome_jogo AS nome_jogo, item_preco_jogo AS preco_jogo, item_qtd
FROM loja.item_compra
WHERE item_id_comp = 2;

-- CONSULTAR REVIEWS DE UM CLIENTE
SELECT rev_id_jogo, rev_comentario, rev_nota, rev_data
FROM loja.review
WHERE rev_id_cliente = 2;