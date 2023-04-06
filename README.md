<h1>Arquitetura Hexagonal</h1>

<p>A arquitetura hexagonal, conhecida também como <strong>Ports and Adapters</strong>, é um design de código que,
assim como as outras arquiteturas como <strong>onion e clean architecture</strong> entre outras,
tem como principal objetivo realizar o isolamente das lógicas de negócios do domínio em que estamos inseridos. 
Realizando este isolamento, conseguimos ter os benefícios de focar em nossas lógicas de negocios e deixa-las agnoticas
de tecnlogias, pois são as regras e processos inseridas nessa camada que dá o sentido ao nosso software 
para existir. Além disso, conseguimos ter uma testabilidade maior por xxxx</p>

<h2>Certo, mas o que são <strong>ports</strong> ?</h2>

<p><strong>Ports</strong> são interfaces que servem como um meio de comunicação pelo qual a aplicação irá conversar com o mundo
externo, ou seja, nosso nucleo da aplicação conversará com o mundo externo através de ports e que futuramente os
<strong>adapters</strong> a implementarão e terão todas comunicações concretas. Dessa forma, temos nossas lógicas de 
negócios isoladas e os adapters com as implementações concretas utilizando as tecnologias que foram decididas no projeto
independentemente das lógicas de negocios.

Além disso, ports podem ser divididas em <strong>driver</strong> e <strong>driven</strong>.</p>

<p><strong>Driver ports</strong>: são portas que acionam o núcleo interno da aplicação para executar uma funcionalidade que é exposta ao mundo externo.</p>

<p><strong>Driven ports</strong>: são portas que o núcleo da aplicação acionam para ela conseguir cumprir os objetivos das funcionalidades expostas em driver ports.</p>

<p>Como exemplo, nessa pequena aplicação temos uma port chamada <strong>ForObtainingDollarQuote</strong> que no meu adapter
<strong>ForObtainingDollarQuoteAdapter</strong> realizei a chamada a um microsservico externo e obtive o valor da cotação atual do dolar.
No entanto, nada me impediria de por algum motivo de decisão de projeto, realizar uma nova implementação dessa port e começar a buscar os valores
da cotação de um banco de dados NoSQL ou até mesmo de um tópico num Kafka.</p>

<h2>E o que são as <strong>adapters</strong> ?</h2>

Como já dito acima, os adapters são as implementações das ports, ou seja, são classes que cumprem os contratos das ports 
e possuem implementações concretas. Além disso, para cada port presente na aplicação, temos um Adapter que a implementa,
fazendo com que os atores interajam com os adapters e estes com as ports.
A seguir será explicado o passo a passo de uma simples API que retorna o cálculo de uma fatura(Invoice).

<h2>InvoiceMicrosservice</h2>
Bom, partindo da idea do XXXX, primeiro devemos definir os atores presente


<h2>Resultado final</h2>

