create table Product
(
	productid char(10) primary key,
	productname char(40),
	productdesc char(50),
	isproductavailable boolean,
    rating float,
    noitemssold int,
    noreviews int
)

create table Supplier
(
	supplierid char(10) primary key,
	suppliername char(30),
	supplierdesc char(30),
	issupplieravailable boolean
)

create table XMAP_Product_Supplier
(
	psid char(10) primary key,
	productid char(10) references Product(productid),
	supplierid char(10) references Supplier(supplierid),
	productsupplierprice int,
	productsupplierstock int,
	isproductsupplieravailable boolean
)


SELECT * FROM CUSTOMER;
SELECT * FROM USERDETAILS ;
SELECT * FROM SHIPPINGADDRESS ;
SELECT * FROM BILLINGADDRESS ;
SELECT * FROM CART ;



INSERT INTO USERDETAILS VALUES('ADM00001',TRUE,12345,'ROLE_ADMIN')
INSERT INTO CUSTOMER VALUES('CST00000','TomCat',true,'rajeshwar.mrr@gmail.com','9346912116',null,null,null,'ADM00001')

create view Vw_prod_supp_xps as
select p.productid, productname, productdesc,rating,noitemssold, noreviews,s.supplierid,suppliername,psid,productsupplierprice,productsupplierstock
from product p join XMAP_PRODUCT_SUPPLIER x on p.productid=x.productid join supplier s on x.supplierid = s.supplierid

SELECT * FROM XMAP_PRODUCT_SUPPLIER x1 where productsupplierprice = (select min(productsupplierprice) from VW_PROD_SUPP_XPS x2 where x1.productid = x2.productid )

create view vw_cust_rating
as
select pr.reviewid,c.customerid, customername,userid,pr.rating, pr.comments,pr.productid
from customer c join productreview pr on c.customerid=pr.customerid


