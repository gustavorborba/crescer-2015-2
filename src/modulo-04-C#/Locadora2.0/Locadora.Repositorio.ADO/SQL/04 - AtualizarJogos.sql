update Jogo set URLImagem='criticalhits.com.br/wp-content/uploads/2013/08/chrono-trigger.jpga' where Id=1

insert into Selo
(Selo)
values
('Ouro')

insert into Selo
(Selo)
values
('Prata')

insert into Selo
(Selo)
values
('Bronze')

//selo padrao
update Jogo set IDSelo=1;

update Jogo set Descricao='Chrono Trigger � um jogo de RPG eletr�nico. Foi lan�ado para o console Super Nintendo no Jap�o em mar�o de 1995, e uma vers�o aprimorada para PlayStation foi lan�ada em novembro de 1999.' where Id=1;
