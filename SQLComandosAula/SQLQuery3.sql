select * from Cidade



--Exercicios aula
--1)
begin

	declare @vNome varchar(200), @vUF char(2), @vIDCidade integer
	set @vNome='Joao'
	set @vUF='RS'
	
	select @vIDCidade=IDCidade
	from Cidade
	where
	Nome=@vNome and UF=@vUF

	if (@@rowcount = 0)begin
		insert into Cidade
		(Nome,UF)
		values
		(@vNome,@vUF)
		print scope_identity()
		end 
	print @vIDCidade
end

--2)

