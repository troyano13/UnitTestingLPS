INSERT INTO `product` (`id`, `name`, `description`, `price`, `img`) VALUES
(1, 'Navy Slim Fit Suit Center Vent', 'This notch lapel is the most widely used and most versatile.\r\nIt is accompanied with one bosom chest pocket and two flap pockets.\r\nIt features a centre vent and no pleat pants made of the super rayon, fabric.', 100, 'https://www.mensitaly.com/images/Mens-Navy-Slim-Fit-Suit-22079.jpg'),
(2, 'Bellagio Tuxedo Gold 3PC Suit ', 'test', 100, 'https://www.mensitaly.com/images/Mens-Gold-Color-Vest-Suit-34019.jpg'),
(3, 'Burgundy ~ Maroon ~ Wine Color Two Button Notch Party Suit', 'Burgundy Two Button Notch Party Suit & Tuxedo & Blazer w/ Black Lapel-100% Light Weight Polyester - very durable and easy to clean, black acetate inside body lining.\r\nNon-Adjustable Exact Waist Size Black Trousers are Paired Six Inches lower than Jacket.', 100, 'https://www.mensitaly.com/images/Two-Button-Burgundy-Color-Tuxedo-12943.jpg'),
(4, 'Lynda Couture Promotional Ladies Suits', 'test', 100, 'https://www.mensitaly.com/images/Lynda-Couture-Black-Ladies-Suits-18614.jpg'),
(5, 'Fashion Royal Blue Slim Fit Elbow Patches', 'test', 100, 'https://www.mensitaly.com/images/Royal-Blue-Slim-Fit-Blazer-37497.jpg');

/*B-lline*/

/*Code injected by: UserModel-AlterSQL*/
INSERT INTO `user` (`id`, `name`, `type`, `user`, `pass`) VALUES
(1, 'Daniel Correa', 'admin', 'daniel', 'daniel'),
(2, 'Raúl Mazo', 'user', 'raul', 'raul'),
(3, 'Gloria Lucia', 'user', 'gloria', 'gloria');
/*Code injected by: UserModel-AlterSQL*/


/*Code injected by: Comments-AlterSQL*/
INSERT INTO `comment` (`id`, `product`, `description`, `date`) VALUES
(1, 1, 'Best product in the world', '2018-02-24 23:04:30'),
(2, 1, 'This suit is awesome', '2018-02-24 23:11:44'),
(4, 3, 'Great product', '2018-02-25 13:06:44');
/*Code injected by: Comments-AlterSQL*/
