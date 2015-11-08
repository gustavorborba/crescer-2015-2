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

update Jogo set IDSelo=1;

update Jogo set Descricao='Sem Descricao'

alter table  Jogo alter column Descricao varchar(max) not null 

alter table Jogo add constraint FK_IDSELOS foreign key (IDSelo) references Selo(IDSelo)
