O GameHub consiste em uma loja virtual dedicada à venda de jogos. No catálogo, cada item possui nome, descrição, preço, data de lançamento, nota de avaliação e o caminho para uma imagem representativa. Os jogos podem ser filtrados por gênero, tipo de plataforma e desenvolvedor.
A aplicação possui a funcionalidade de cadastro de clientes ao criar uma conta com informações de contato, como nome, endereço, telefone e e-mail. Após o cadastro, eles possuem acesso ao carrinho de compras, onde é possível adicionar produtos e gerenciar a quantidade desejada antes de finalizar a compra. Após confirmação do pedido, um identificador é gerado e os detalhes da transação são armazenados.
A loja possui um sistema de integridade do banco de dados, com restrições que garantem a validade das informações, como preços positivos e notas dentro de um intervalo específico. Além disso, mantém a integridade referencial ao utilizar chaves estrangeiras que asseguram a conexão lógica entre as tabelas, como as relações entre jogos, categorias, plataformas e desenvolvedores.
Com relação aos relatórios, pretendemos desenvolver sete. Os relatórios serão de Analise de Vendas relacionada com as avaliacoes, Compras feitas em uma faixa horária específica, vendas de acordo com a categoria, produtos com menos vendas, produtos mais vendidos, vendas por periodo (manhã, tarde, noite) e vendas por plataforma.