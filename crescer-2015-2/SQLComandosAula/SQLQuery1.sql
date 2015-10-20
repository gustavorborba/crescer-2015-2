--Consulta Primeiro Nome
-> 1
select 
	substring(Nome,1,charindex(' ',Nome)-1) as PrimeiroNome
from Associado
---------------------------------------------------------------------------
--Consulta Idade Associado
--> 2
select
	Nome,
	datediff(year,DataNascimento,getdate()) as Idade
from Associado
---------------------------------------------------------------------------
--Consulta MesesTrabalhados
--> 3
select 
	NomeEmpregado,
	datediff(month,DataAdmissao,convert(datetime,'31/12/2000',103)) as MesesTrabalhados
from Empregado
where 
DataAdmissao between convert(datetime,'01/05/1980',103) and convert(datetime,'20/01/1982',103)
---------------------------------------------------------------------------
--Consulta Maior quantidade cargo
--> 4 
select
top 1 (Cargo) as Cargo,
count(1) as Quantidade
from
Empregado
group by Cargo
order by count(1) desc
---------------------------------------------------------------------------
--Culsulta Maior Quantidade Caracteres
---> 5 
select 
	top 1
	Nome,
	len(Nome) as Caracteres
from
Associado
order by len(Nome) desc
---------------------------------------------------------------------------
--Consulta Data com Cinquenta anos
--> 6
select 
	   nome,
       dateadd(year, 50, DataNascimento) as DataComCinquenta,
       datename(dw,dateadd(year, 50, DataNascimento)) as DiaDaSemana
from associado; 
---------------------------------------------------------------------------
--Consulta Numero de Cidades Por UF
--> 7
select 
	UF,
	count(1) as QuantidadeCidades
from Cidade
group by UF
order by Count(1) asc
---------------------------------------------------------------------------
--Consulta Nome e UF iguais de Cidade
--> 8
select
Nome,UF, count(1) as NumeroRepetidos
from 
Cidade
group by Nome,UF 
having count(1)>1
---------------------------------------------------------------------------
--Consulta proximo ID de Associado
--> 9
select
max(IDAssociado) +1 as "Proximo ID"
from Associado
---------------------------------------------------------------------------
--Inserir cidades e UFs Distintos em CidadeAux
--> 10
insert into CidadeAux
select 
min(IDCidade) as ID,Nome,UF
from Cidade
group by  Nome,UF
order by min(IDCidade) asc
---------------------------------------------------------------------------
--> 11
---------------------------------------------------------------------------
---> 12
select IDAssociado,
Nome,
Case when sexo = 'F' then 'Feminino'
when sexo = 'M' then 'Masculino'
else 'sei lá'
End Genero
from associado;
---------------------------------------------------------------------------
--> 13
select NomeEmpregado,
Salario,
Case when Salario> 2326 then '27%'
	when Salario between 1164 and 2326 then '15%'
	when Salario< 1164 then 'O%'
	else 'nao sei'
	end Imposto
from Empregado
order by Salario asc
---------------------------------------------------------------------------
--> 14 
---------------------------------------------------------------------------
--> 15
---------------------------------------------------------------------------
--1)
select Empreg.NomeEmpregado, Dep.NomeDepartamento
from Empregado as Empreg
	inner join Departamento as Dep
	on Empreg.IDDepartamento = Dep.IdDepartamento

--2)
select A.Nome, C.Nome as Cidade
from Associado as A
	left join Cidade as C
	on A.IDCidade=C.IDCidade

--3)

--4)
select A.Nome,C.Nome,
	case when C.UF='RS' then '***'
	else
	null
end UFs
	from Associado as A
	inner join Cidade as C
	on
	A.IDCidade=C.IDCidade


--5)
select E.NomeEmpregado, 
		G.NomeEmpregado as NomeGerente,
		D.NomeDepartamento
from
		Empregado as E
	inner join Empregado as G
	on
	E.IDGerente=G.IDEmpregado
	inner join Departamento as D
	on
	E.IDDepartamento=D.IDDepartamento


--6)
select * 
into EmpregadoAux
from Empregado

update EmpregadoAux
set
EmpregadoAux.Salario+=Salario*0.145
from EmpregadoAux
inner join Departamento
	on
	EmpregadoAux.IDDepartamento=Departamento.IDDepartamento
where
Departamento.Localizacao='SAO PAULO'

--7)
select
(select
	sum(Salario) from EmpregadoAux)-(select sum(Salario) from Empregado) 
as Diferenca

--8)
select top 1
	max(E.Salario) as Maior, D.NomeDepartamento
from Empregado as E
	inner join Departamento as D
	on
	E.IDDepartamento=D.IDDepartamento
group by D.NomeDepartamento
order by max(E.Salario) desc

