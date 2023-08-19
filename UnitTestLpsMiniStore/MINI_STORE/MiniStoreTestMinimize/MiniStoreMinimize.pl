productline1(L):-
L=[MCL,U1,PRODUCT_VIP,PRODUCT_STAR],
fd_domain(L,0,1),

%U1=Product_Model, Index_Custom,StoreProducts

MCL #=1,
MCL #=U1,
MCL #=PRODUCT_VIP,
MCL #=PRODUCT_STAR,
PRODUCT_VIP #==>U1,
PRODUCT_STAR #==>U1,
fd_labeling(L).
%productline1(L).