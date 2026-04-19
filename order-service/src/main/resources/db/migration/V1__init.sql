CREATE TABLE `orders`
(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `order_number` VARCHAR(255) NOT NULL,
    `sku_code` VARCHAR(255) NOT NULL,
    `price` DECIMAL(19, 2) NOT NULL,
    `quantity` INT(11) NOT NULL,
    PRIMARY KEY (`id`)
);