Exercicio 04

Este projeto le um arquivo csv com dados de produtos, calcula o valor total de cada produto (preco * quantidade) e gera um novo arquivo com os resultados

Entrada esperada:
arquivo em C:\temp\arquivo.csv

Formato:
TV,900.00,2
Mouse,50.00,5
Tablet,350.50,1

Cada linha possui:
nome, preco, quantidade

Processo:
o programa le cada linha do arquivo, separa os dados usando split(","), cria um objeto Product e calcula o valor total

Saida:
arquivo gerado em C:\temp\out\summary.csv

Formato:
TV,1800.00
Mouse,250.00
Tablet,350.50

Como executar:

1. criar o arquivo de entrada em C:\temp\arquivo.csv
2. rodar a classe Program
3. verificar o arquivo gerado na pasta out
