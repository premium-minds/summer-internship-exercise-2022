# Screen Locking - Summer internship exercise

## O problema

Muitos telefones permitem utilizar um padrão geométrico como medida de segurança. Para desbloquear o dispositivo, é preciso
conectar uma sequência de pontos da matriz, fornecendo a sequência certa.
A imagem abaixo tem um padrão de exemplo com 7 pontos [1,2,9,5,4,7,3].


![alt text](screenLock.png?raw=true)

Deverá ser implementado um mecanismo de contagem de padrões a partir de um determinado ponto e com um determinado tamanho.
```
countPatternsFrom(3, 2)(firstPoint, length)
```
O primeiro parâmetro é um valor inteiro que simboliza a posição na matriz com base na imagem.
```
0 < firstPoint <= 9
```
O segundo parâmetro é um valor inteiro que simboliza o tamanho do padrão (numero de pontos do padrão).
```
1 <= length <= 9
```

Como exemplo, a função `countPatternsFrom(3, 2)` deve retornar o numero de padrões possíveis que comecem no ponto `3` e que tenham `2` de tamanho. Neste caso, o resultado esperado seria `5`.
```
[3,2],[3,4],[3,5],[3,6],[3,8].
```

## Regras

* Num padrão, os pontos não podem ser repetidos. Só podem ser utilizados uma vez.
* Num padrão, quaisquer dois pontos subsequentes só podem ser ligados com linhas rectas directas numa destas maneiras :
    * Horizontalmente: como `[1,2]` na imagem padrão de exemplo.
    * Verticalmente: como `[4,7]` na imagem padrão de exemplo.
    * Diagonalmente: como `[9,5]`, bem como `[2,9]`, na imagem padrão de exemplo.
    * Passar por cima de um ponto que já foi 'usado': como `[7,3]` que passou por cima do `5`, sendo que este já tinha sido utilizado.

## O que é preciso fazer

* Implementar o método `countPatternsFrom` em `ScreenLockinPattern`.
* Implementar mais testes em `ScreenLockinPatternTest`

Vai ser valorizado o facto do código estar escrito de forma perceptível e organizada.

## Como correr os testes

* Instalar o mvn [https://maven.apache.org/install.html]
* Correr `mvn test`

## Dúvidas

Quaisquer dúvidas que tenhas, cria uma issue aqui no github :)

