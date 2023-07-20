use shop

select * from users
select * from orderdetails
select * from orders
select * from products
select * from categories

insert into orders(username,createDate,address)				
values('trinn',GETDATE(),N'10 Phan huy ích')
insert into orderdetails(orderID,productID,quantity,price)
values(3,19,1,500000),
(2,2,1,479050),
(1,3,1,579050),
(1,4,1,679050),
(1,5,1,779050)

insert into users(username,fullname,password,mobile,admin,email,gender,address)
values('korea',N'Hàn Quốc','123456','0399214849',1,'korea@gmail.com',1,N'331 Phan Huy ích'),
('trinn',N'Khả Trình','24062003','0345447031',0,'trinn@gmail.com',0,N'111 Phan Huy ích')

select top 5 productid from orderdetails
group by productID
order by COUNT(quantity) desc

select * from products
where id in (select top 5 productid from orderdetails
group by productID
order by COUNT(quantity) desc)

insert into products(name,price,description,categoryID,quantity,image,available,createDate)
values(N'Ví',100,'',26,100,'',1,GETDATE())

select * from products p
join categories c
on c.id = p.categoryID
where c.gender = 1
and (c.name LIKE N'Áo thun'
or c.name LIKE N'Áo thun')
order by p.price desc

go
create trigger trg_order on orderdetails after insert as
begin
	Update products
	set products.quantity = products.quantity - (
	select quantity from inserted
	where inserted.productID = products.id)
	from products
	join inserted on products.id = inserted.productID
end
drop trigger trg_order
go
create trigger trg_cancelOrder on orderdetails for delete as
begin
	Update products
	set products.quantity = products.quantity + (
	select quantity from deleted
	where deleted.productID = products.id)
	from products
	join deleted on products.id = deleted.productID
end

alter table users
add image varchar(255)

