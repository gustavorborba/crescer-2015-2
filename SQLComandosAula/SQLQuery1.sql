
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
select UF, count(Nome)
from Cidade as c
group by UF
having exists(select 1 from Associado as a where