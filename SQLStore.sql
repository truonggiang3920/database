CREATE SCHEMA IF NOT EXISTS store_cms_plusplus DEFAULT CHARACTER SET utf8mb4;
USE store_cms_plusplus;

CREATE TABLE `store_cms_plusplus`.`laptop` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(255) NULL,
  `url` VARCHAR(255) NULL,
  `maker` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  `ram` VARCHAR(45) NULL,
  `cpu` VARCHAR(45) NULL,
  `ssd` VARCHAR(45) NULL,
  `hdd` VARCHAR(45) NULL,
  `price` FLOAT NULL,
  `card` VARCHAR(45) NULL,
  `screen_resolution` VARCHAR(45) NULL,
  `screen_size` FLOAT NULL,
  `sold` INT NULL,
  `created_timestamp` TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `last_updated_timestamp` TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6));

INSERT INTO store_cms_plusplus.laptop (`name`,`url`,`maker`,`type`,`ram`,`cpu`,`ssd`,`hdd`,`price`,`card`,`screen_resolution`,`screen_size`,`sold`) VALUES ('Laptop ASUS VivoBook X407MA-BV169T (14\" HD/N5000/4GB/1TB HDD/UHD 605/Win10/1.7 kg)','https://phongvu.vn/may-tinh-xach-tay-laptop-asus-x407ma-bv169t-n5000-s19010084.html','ASUS','VivoBook','4GB','Intel Pentium Silver N5000',NULL,'1TB',7290000,'Intel UHD Graphics 605','1366x768',14,20);
INSERT INTO store_cms_plusplus.laptop (`name`,`url`,`maker`,`type`,`ram`,`cpu`,`ssd`,`hdd`,`price`,`card`,`screen_resolution`,`screen_size`,`sold`) VALUES ('Laptop Apple MacBook Air 13\" 2019 MVFL2SA/A (Core i5/8GB/256GB SSD/UHD 617/macOS/1.3 kg)','https://phongvu.vn/may-tinh-xach-tay-laptop-macbook-air-2019-mvfl2saa-bac-s190800125.html','APPLE','MacBook Air','8GB','Intel Core i5','256GB',NULL,36990000,'Intel UHD Graphics 617','2560x1600',13.3,50);
INSERT INTO store_cms_plusplus.laptop (`name`,`url`,`maker`,`type`,`ram`,`cpu`,`ssd`,`hdd`,`price`,`card`,`screen_resolution`,`screen_size`,`sold`) VALUES ('Laptop Dell Inspiron 7570-782P81 (15.6\" FHD/i7-8550U/8GB/1TB HDD/940MX/Win10/1.9 kg)','https://phongvu.vn/may-tinh-xach-tay-laptop-dell-inspiron-15-7570-782p81-bac-s1703094.html','DELL','Inspiron','8GB','Intel Core i7-8550U ','256GB','1TB',29990000,'Intel UHD Graphics 620','1920x1080',15.6,30);
