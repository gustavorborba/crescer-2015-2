--1)
select count(DataPedido) as TotalPedidos
from Pedido
where
month(DataPedido)=09 and year(DataPedido)=2015

--2)
select * from Cliente
where
Nome like '%Ltda' or 
RazaoSocial like '%Ltda'

--3)
insert into Produto
(Nome,PrecoCusto,PrecoVenda,Situacao)
values
('Galocha Maragato',35.67,77.95,'A')

--4)
select *
from Produto
where not exists(select 1 from PedidoItem where PedidoItem.IDProduto=Produto.IDProduto)

--5)
