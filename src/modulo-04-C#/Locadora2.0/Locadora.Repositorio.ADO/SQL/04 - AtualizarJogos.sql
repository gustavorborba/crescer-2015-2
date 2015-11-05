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

update Jogo set Descricao='Chrono Trigger é um jogo de RPG eletrônico. Foi lançado para o console Super Nintendo no Japão em março de 1995, e uma versão aprimorada para PlayStation foi lançada em novembro de 1999.' where Id=1;
