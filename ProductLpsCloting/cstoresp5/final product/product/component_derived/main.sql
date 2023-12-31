/*B-fline*/

/*Code injected by: ProductModel-AlterSQL*/
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(20000) NOT NULL,
  `price` int(9) NOT NULL,
  `img` varchar(400) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*Code injected by: ProductModel-AlterSQL*/


/*Code injected by: Comments-AlterSQL*/
DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product` int(11) NOT NULL,
  `description` varchar(100) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*Code injected by: Comments-AlterSQL*/


/*Code injected by: UserModel-AlterSQL*/
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `user` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*Code injected by: UserModel-AlterSQL*/



/*B-lline*/

/*Code injected by: Rating-AlterSQL*/
ALTER TABLE `product` ADD `num_rates` INT(9) NOT NULL DEFAULT '0' AFTER `img`, ADD `total_rates` INT(9) NOT NULL DEFAULT '0' AFTER `num_rates`;
/*Code injected by: Rating-AlterSQL*/

