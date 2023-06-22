create database db_scv;

use db_scv;

CREATE TABLE PEDIDO (
    idPedido int auto_increment primary key,
    cliente varchar (60) not null,
    telefone varchar (25) not null
);

CREATE TABLE PIZZA (
    idPizza int auto_increment primary key,
    cobertura varchar (50) not null,
    recheio varchar (50) not null,
    molho varchar (50) not null,
    peso float not null,
    preco float not null,
    fk_PEDIDO_idPedido int not null
);

CREATE TABLE SALGADINHO (
    idSalgadinho int auto_increment primary key,
    tipo varchar (15) not null,
    recheio varchar (50) not null,
    massa varchar (50) not null,
    peso float not null,
    preco float not null,
    fk_PEDIDO_idPedido int not null
);

CREATE TABLE LANCHE (
    idLanche int auto_increment primary key,
    molho varchar (50) not null,
    recheio varchar (50) not null,
    pao varchar (50) not null,
    peso float not null,
    preco float not null,
    fk_PEDIDO_idPedido int not null
);
 
ALTER TABLE PIZZA ADD CONSTRAINT FK_PEDIDO_PIZZA
    FOREIGN KEY (fk_PEDIDO_idPedido)
    REFERENCES PEDIDO (idPedido);
 
ALTER TABLE SALGADINHO ADD CONSTRAINT FK_PEDIDO_SALGADINHO
    FOREIGN KEY (fk_PEDIDO_idPedido)
    REFERENCES PEDIDO (idPedido);
 
ALTER TABLE LANCHE ADD CONSTRAINT FK_PEDIDO_LANCHE
    FOREIGN KEY (fk_PEDIDO_idPedido)
    REFERENCES PEDIDO (idPedido);    

desc pedido;
desc pizza;
desc lanche;
desc salgadinho;

select * from pedido;
select * from pizza;
select * from lanche;
select * from salgadinho;