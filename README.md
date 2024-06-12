# EnergiaSolar
Projeto Java Web - Praticando programação Web.

IDE Utilizada: Eclipse 2022-03.
Linguagens utilizadas: Java, JavaScript, HTML5 e CSS.
Banco de Dados utilizado: MySQL 8.0.
Ferramentas utilizadas: BootStrap 5.1.3.
O padrão MVC foi empregado neste projeto.

Este projeto permite realizar duas operações principais:
- A primeira operação está disponível após clicar no botão "Relatório" da página inicial. Nesta área é possível calcular a energia esperada de produção em kWh. 
    Para realizar este calculo, primeiro é necessário definir a cidade, pois cada cidade tem uma irradiação distinta que influencia no desempenho dos módulos solares;
    Determinar a quantidade de módulos fotovoltaicos;
    Determinar a potência dos módulos fotovoltaicos;
    Determinar a eficiência a ser considerada. A eficiência cai conforme o posicionamento dos módulos fotovoltaicos, em caso de sompreamento e com o tempo de uso.
    Exemplo para teste: Cascavel - 10 - 335 - 85
    Ao clicar no botão "Calcular", algumas informações serão exibidas, além da produção de energia em kWh esperada para cada mês do ano.
    
    Caso a cidade que o usuário queira utiliza não esteja disponível, ao clicar no botão "Nova Cidade", é possível inserir uma nova cidade e uma Irradiação para cada mês do ano nesta cidade. O padrão para inserir a Irradiação deve ser um número real, separa do por ".". Exemplo: "4.50".
    Além de ser possível inserir novas cidades, foi implementado alguma operações básicas. Sendo posséivel editar os dados da cidade, nome e irradiação. Ou então, excluir uma cidade.
    
- A segunda operação está disponível após clicar no botâo "Atendimento" da página inicial. Nesta área será possível criar chamados de atendimento ao cliente. (Em implementação).
    Nesta área também é possível cadastrar novos clientes, editar os dados inseridos e excluir o cliente.
 
Para inserir novas cidades ou editá-las. É realizado algumas validações, onde alguns campos não podem ficar sem ser preenchidos. Esta validação também existe para as funções de novos clientes ou editar. Para os calculos de produção de energia esperada, não é possível realizar os cálculos sem que o número de módulos, sua potência e eficiência sejam inseridos.
