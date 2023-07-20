use shop

create table users(
	username varchar(30) primary key
	,fullname nvarchar(30) not null
	,password varchar(30) not null
	,mobile varchar(12) not null
	,admin bit not null
	,email varchar(30) not null
	,gender bit not null
	,address varchar(max)
)

create table categories(
	id bigint identity(1,1) primary key
	,name nvarchar(15) not null
	,gender bit not null
)

create table products(
	id bigint identity(1,1) primary key
	,name nvarchar(100) not null
	,price float not null
	,description nvarchar(max)
	,categoryID bigint not null
	,quantity int not null
	,image varchar(100) 
	,available bit not null
	,createDate date not null
	FOREIGN KEY (categoryID) REFERENCES categories(id)

)

create table orders (
	id bigint identity(1,1) primary key
	,username varchar(30) not null
	,createDate date 
	,address varchar(max) not null
	FOREIGN KEY (username) REFERENCES users(username)
)
create table orderdetails(
	id bigint identity(1,1) primary key
	,orderID bigint not null
	,productID bigint not null
	,quantity int not null
	,price float not null
	FOREIGN KEY (orderID) REFERENCES orders(id)
	,FOREIGN KEY (productID) REFERENCES products(id)
)