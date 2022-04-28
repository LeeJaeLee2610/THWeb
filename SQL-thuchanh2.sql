use thuchanh2
Go

create table product(
	id int identity(1, 1) primary key,
	code nvarchar(max),
	description nvarchar(max),
	price money
)
Go

insert into product(code, description, price) values(N'code 1', N'sp 1', 12)