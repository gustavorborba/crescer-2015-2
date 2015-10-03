select * from Material
select * from PedidoItem
select * from Pedido
select * from ProdutoMaterial
select * from Produto
select * from Cliente

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



--6)
select Ped.IDPedido,Ped.DataEntrega,Ped.ValorPedido, 
		PedItem.Quantidade,
		Clien.Nome,clien.RazaoSocial,
		Clien.Situacao,Clien.CEP,Clien.Endereco,Clien.Bairro
from Pedido as Ped
inner join Cliente as Clien
on
Clien.IDCliente=Ped.IDCliente
inner join PedidoItem as PedItem
on
PedItem.IDPedido=Ped.IDPedido
inner join Produto as Prod
on
PedItem.IDProduto=Prod.IDProduto
inner join ProdutoMaterial as ProdMat
on
ProdMat.IDProduto=Prod.IDProduto
inner join Material as Mater
on
ProdMat.IDMaterial=Mater.IDMaterial
where
Mater.Descricao like '%#%'





