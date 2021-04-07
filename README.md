# car-fleet

MySQL DB
create database fleet_db;
create user 'fleet_user'@'%' identified by 'fleet_password';
grant all on fleet_db.* to 'fleet_user'@'%';
