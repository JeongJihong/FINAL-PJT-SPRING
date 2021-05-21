-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


USE `happyhouse`;


-- -----------------------------------------------------
-- Table `ssafyweb`.`members`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`members` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`members` (
  `id` VARCHAR(30) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NULL,
  `address` VARCHAR(200) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO members (id, name, password, email, address)
VALUES('admin', '관리자', 'admin', 'admin@ssafy.com','서울시 역삼동');

INSERT INTO members (id, name, password, email, address)
VALUES('ssafy', '김싸피', 'ssafy', 'ssafy@ssafy.com','대전시 덕명동');

INSERT INTO members (id, name, password, email, address)
VALUES('ssafy2', '이싸피', 'ssafy2', 'ssafy2@ssafy.com','대전시 노은동');

INSERT INTO members (id, name, password, email, address)
VALUES('ssafy3', '삼싸피', 'ssafy3', 'ssafy3@ssafy.com','대전시 궁동');

INSERT INTO members (id, name, password, email, address)
VALUES('ssafy4', '사싸피', 'ssafy4', 'ssafy4@ssafy.com','대전시 봉명동');



-- -----------------------------------------------------
-- Table `happyhouse`.`guestbook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`article` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`article` (
  `articleno` INT NOT NULL AUTO_INCREMENT,
  `id` VARCHAR(30) NOT NULL,
  `subject` VARCHAR(100) NOT NULL,
  `content` VARCHAR(2000) NOT NULL,
  `regtime` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  INDEX `article_id_FK_idx` (`id` ASC ),
  PRIMARY KEY (`articleno`),
  CONSTRAINT `article_id_FK`
    FOREIGN KEY (`id`)
    REFERENCES `happyhouse`.`members` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into article (id, subject, content)
values ('admin', '공지1', '안녕하세요. 5기 여러분
금일 본 과정 11주차 5일 교육이 시작됩니다! :slightly_smiling_face:
금일 수업은 각 반 교수님 주도 하에 웹엑스로 진행됩니다.
각 반 MM 웹엑스 :webex: 주소로 9시 전 늦지 않게 접속해주세요!! ');
insert into article (id, subject, content) values ('admin', '공지2', '안녕하세요. ');
insert into article (id, subject, content) values ('admin', '공지3', '안녕하세요. ');
insert into article (id, subject, content) values ('admin', '공지4', '안녕하세요. ');




-- -----------------------------------------------------
-- Table `happyhouse`.`interest`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`interest` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`interest` (
  `id` VARCHAR(30) NOT NULL,
  `dong` VARCHAR(30) NOT NULL,
  INDEX `interest_id_FK_idx` (`id` ASC ),
  PRIMARY KEY (`id`,`dong`),
  CONSTRAINT `interest_id_FK`
    FOREIGN KEY (`id`)
    REFERENCES `happyhouse`.`members` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into interest (id, dong) values ('ssafy', '서빙고동');
insert into interest (id, dong) values ('ssafy', '용문동');

-- -----------------------------------------------------
-- Table `happyhouse`.`envcheck`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `happyhouse`.`envcheck` ;

-- CREATE TABLE IF NOT EXISTS `happyhouse`.`envcheck` (
--   `coname`		VARCHAR(30) NOT NULL,
--   `cotype`	 	VARCHAR(30) NOT NULL,
--   `checkdate`	VARCHAR(10) NOT NULL,
--   `hasproblem`	VARCHAR(1)	NOT NULL,
--   `checkdetail`	VARCHAR(40) NOT NULL,
--   `dong`		VARCHAR(30) NOT NULL,
--   `coaddr`	 	VARCHAR(60) NOT NULL,

--   
--   PRIMARY KEY (`coname`,`checkdate`,`checkdetail`)
-- )
-- ENGINE = InnoDB;

-- input csv

-- setting
SHOW VARIABLES LIKE "local_infile"; -- 만약 OFF으로 설정되어 있다면 아래 명령어 실행.
SET GLOBAL local_infile = 'ON';

SHOW VARIABLES LIKE "secure_file_priv";	-- 읽어들이는 기본폴더경로 찾기 명령어. 찾아서 아래 경로 수정

-- Load DATA
LOAD DATA INFILE  "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/envDB.csv" INTO TABLE `envcheck`
CHARACTER SET utf8mb4
FIELDS TERMINATED BY ','
IGNORE 1 LINES;




-- -----------------------------------------------------
-- Table `happyhouse`.`hospital`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`hospital` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`hospital` (
  `dong`		VARCHAR(10),
  `hname`		VARCHAR(40), 
  `haddr`	 	VARCHAR(60), 
  `htype`	 	VARCHAR(1), -- 'A':외래진료만 가능 'B':입원도 가능
  `htel`		VARCHAR(20),
  
  PRIMARY KEY (`hname`,`dong`)
)
ENGINE = InnoDB;


-- input csv
-- setting
SHOW VARIABLES LIKE "local_infile"; -- 만약 OFF으로 설정되어 있다면 아래 명령어 실행.
SET GLOBAL local_infile = 'ON';

SHOW VARIABLES LIKE "secure_file_priv";	-- 읽어들이는 기본폴더경로 찾기 명령어. 찾아서 아래 경로 수정

-- Load DATA
LOAD DATA INFILE  "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/hospitalDB.csv" INTO TABLE `hospital`
CHARACTER SET utf8mb4
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\r'
IGNORE 1 ROWS;



commit;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
