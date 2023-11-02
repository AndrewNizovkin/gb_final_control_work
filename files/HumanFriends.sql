DROP DATABASE IF EXISTS HumanFriends;
CREATE DATABASE HumanFriends;
USE  HumanFriends;

DROP TABLE IF EXISTS Pets;
CREATE TABLE Pets (
    id INT PRIMARY KEY,
    Name VARCHAR(32),
    TypeAnimal VARCHAR(32),
    BirthDate DATE,
    Commands VARCHAR(50)
);

INSERT INTO Pets VALUES
(1, 'Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
(2, 'Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
(3, 'Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'),
(4, 'Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
(5, 'Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
(6, 'Peanut', 'Humster', '2021-08-01', 'Roll, Spin'),
(7, 'Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll'),
(8, 'Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump');

DROP TABLE IF EXISTS PackAnimals;
CREATE TABLE PackAnimals (
    id INT PRIMARY KEY,
    Name VARCHAR(32),
    TypeAnimal VARCHAR(32),
    BirthDate DATE,
    Commands VARCHAR(50)
);

INSERT INTO PackAnimals VALUES
(1, 'Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
(2, 'Sandy', 'Camel', '2016-11-03', 'Walk, CarryLoad'),
(3, 'Eeyore', 'Donkey', '2017-09-18', 'Walk, CarryLoad, Bray'),
(4, 'Stormy', 'Horse', '2014-05-05', 'Trot, Canter'),
(5, 'Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
(6, 'Burro', 'Donkey', '2019-01-23', 'Walk, Bray, Kick'),
(7, 'Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop'),
(8, 'Sahara', 'Camel', '2015-08-14', 'Walk, Run');

SELECT * FROM Pets;
SELECT * FROM  PackAnimals;

-- Deletes recods with Camels

DELETE FROM PackAnimals
WHERE TypeAnimal = 'Camel';

SELECT * FROM  PackAnimals;

-- Creates table with Horses and Donkeys

DROP TABLE IF EXISTS HorsesDonkeys;
CREATE TABLE HorsesDonkeys
SELECT * FROM PackAnimals
WHERE TypeAnimal = 'Horse' OR TypeAnimal = 'Donkey';

SELECT * FROM HorsesDonkeys;

-- Creates table with young animal

DROP TABLE IF EXISTS YoungAnimals;
CREATE TABLE YoungAnimals
SELECT Pets.id, Pets.Name, Pets.TypeAnimal, Pets.BirthDate, Pets.Commands,
TIMESTAMPDIFF(MONTH, Pets.BirthDate, CURDATE()) AS 'Age, month'
FROM Pets
WHERE ((CAST( NOW() as DATE ) - Pets.BirthDate) / 10000) BETWEEN 1 AND 3

UNION

SELECT PackAnimals.id,
PackAnimals.Name, PackAnimals.TypeAnimal, PackAnimals.BirthDate, PackAnimals.Commands,
TIMESTAMPDIFF(MONTH, PackAnimals.BirthDate, CURDATE()) AS 'Age, month'
FROM PackAnimals
WHERE ((CAST( NOW() as DATE ) - PackAnimals.BirthDate) / 10000) BETWEEN 1 AND 3;
HorsesDonkeys
SELECT * FROM YoungAnimals;

-- Creates summary table

DROP TABLE IF EXISTS SummaryTable;
CREATE TABLE  SummaryTable
SELECT p.id, p.Name, p.TypeAnimal, p.BirthDate, p.Commands,
'Pets' AS Parent
FROM Pets AS p

UNION

SELECT pa.id, pa.Name, pa.TypeAnimal, pa.BirthDate, pa.Commands,
'PackAnimals' AS Parent
FROM PackAnimals AS pa

UNION

SELECT hd.id, hd.Name, hd.TypeAnimal, hd.BirthDate, hd.Commands,
'HorsesDonkeys' AS Parent
FROM HorsesDonkeys AS hd

UNION

SELECT y.id, y.Name, y.TypeAnimal, y.BirthDate, y.Commands,
'YoungAnimals' AS Parent
FROM YoungAnimals AS y;

SELECT * FROM SummaryTable;

