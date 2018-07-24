create table person(name varchar2(10) not null,
                   mobileNo varchar2(10) not null,
                   balance number(10,2) not null,
                   primary key(mobileNo)); 
                   
create table transaction(mobileNo varchar2(10) not null,
						transactionType varchar2(20) not null,
						amount number(10,2) not null,
						transactionDate date not null,
						foreign key(mobileNo) references person(mobileNo));
                   
                   
            