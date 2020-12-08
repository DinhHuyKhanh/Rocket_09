USE employee_ag4; 

-- EX1;
DROP TRIGGER IF EXISTS project_modules_INS;
DELIMITER $$
	CREATE TRIGGER project_modules_INS
	BEFORE INSERT ON `project_modules`
    FOR EACH ROW
    BEGIN 
		IF NEW.`ProjectModulesDate` < (SELECT `ProjectStartDate` FROM projects WHERE projectID= NEW.projectID) THEN 
			SET NEW.`ProjectModulesDate` = (SELECT `ProjectStartDate` FROM projects WHERE projectID= NEW.projectID);
		END IF;
	IF NEW.`ProjectModulesCompletedOn` > (SELECT `ProjectCompletedON` FROM projects WHERE projectID=NEW.projectID) THEN
			SET NEW.`ProjectModulesCompletedOn` =  (SELECT `ProjectCompletedON` FROM projects WHERE projectID=NEW.projectID);
            END IF;
    END $$
DELIMITER ;

INSERT INTO project_modules
VALUES ('12', '1', '2030-03-01 00:00:00', '2030-05-01 00:00:00', 'web customer 1');


-- Exercise 2: View
USE fresher_management;
DROP VIEW IF EXISTS S_Dat_KQ;
CREATE VIEW S_Dat_KQ AS
	SELECT * FROM trainee WHERE ET_IQ>=8 && ET_Gmath >=8 && ET_English >=18 && ET_IQ + ET_Gmath >=20;
    