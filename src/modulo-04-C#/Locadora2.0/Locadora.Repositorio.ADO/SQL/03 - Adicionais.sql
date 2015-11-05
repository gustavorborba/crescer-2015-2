create table Selo
(IDSelo integer not null identity primary key,
Selo varchar(10) not null)

alter table Jogo add IDSelo integer constraint FK_idSelo foreign key references Selo(IDSelo)

alter table Jogo add Descricao varchar(max)

alter table Jogo add URLImagem varchar(255)

alter table Jogo add URLVideo varchar(255)
