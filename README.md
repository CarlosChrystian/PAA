# Trabalho de Análise de Algoritmos AV2 sobre Programação dinâmica e algoritmos gulosos
Trabalho desenvolvido em Java SE versão 8 Update 112

Ao executar qualquer um dos algoritmos será aberta uma janela de dialogo solicitando escolher o arquivo desejado.

## Sobre os algoritmos um, dois e três:
* Entrada> 

Será realizada a leitura dos valores correspondentes para cada tamanho da haste,
considerando a quebra de linha como uma unidade de tamanho a mais.

* Processamento>

O algoritmo um utiliza abordagem top down sem memorização.
O algoritmo dois utiliza abordagem top down com memorização.
O algoritmo três utiliza abordagem bottom up.

* Saída>

Será exibido no prompt de comando os valores lidos para cada tamanho de haste, em seguida,
o valor máximo encontrado para a haste de acordo com infomamções informadas.

* Exceções>

Caso a linha lida do arquivo possua caracteres inválidos para formar um número inteiro positivo,
a execução do algoritmo será interrompida e o usuário será informado qual linha apresenta valor inválido.

## Sobre o algorito quarto:
* Entrada> 

Cada linha do arquivo representará uma atividade.
O primeiro número da linha representará o em qual tempo a atividade se inicia.
Após um caractere de espaço será lido o segundo número da linha, que representará o tempo que a atividade finaliza.

* Processamento>

A ordenação do algoritmo é realizada pela classe Collections do Java SE através do método sort,
e a ordenação da lista de atividades é definida na classe Atividade no método compareTo
Para informações a respeito do funcionamento consultar:

(https://docs.oracle.com/javase/6/docs/api/java/util/Collections.html)

(https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html)

* Saída>

É exibido no console as atividades lidas do arquivo selecionado.
É exibido no console as atividades de forma ordenada pelo tempo de término.
É exibida as atividades selecionadas para o conjunto de entradas do arquivo.

* Exceções>

Caso a linha lida do arquivo possua caracteres inválidos para formar um número inteiro positivo,
a execução do algoritmo será interrompida e o usuário será informado qual linha apresenta valor inválido.


