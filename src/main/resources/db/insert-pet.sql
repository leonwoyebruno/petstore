SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE pet_animal;

INSERT INTO pet_animal(`Id`, `name`, `breed`, `types`, `sex`, `age`)
VALUES (200, 'bobby', 'german shepherd', 'DOG', 'MALE', 15),
(201, 'bobby', 'german shepherd', 'DOG', 'MALE', 15),
(202, 'bobby', 'german shepherd', 'DOG', 'FEMALE', 15),
(203, 'bobby', 'german shepherd', 'SNAKE', 'MALE', 15),
(204, 'bobby', 'german shepherd', 'DOG', 'FEMALE', 15),
(205, 'bobby', 'german shepherd', 'CAT', 'MALE', 15),
(206, 'bobby', 'german shepherd', 'DOG', 'MALE', 15),
(207, 'bobby', 'german shepherd', 'DOG', 'FEMALE', 15);








SET  FOREIGN_KEY_CHECKS = 1;