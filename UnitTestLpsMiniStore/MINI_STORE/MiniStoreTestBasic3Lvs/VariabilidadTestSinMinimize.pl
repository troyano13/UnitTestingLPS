productline2(L):-
L=[MCL,INDEX_CUSTOM,STORE_PRODUCT,PRODUCT_MODEL,PRODUCT_VIP,PRODUCT_STAR],
fd_domain(L,0,1),

MCL #=1,
MCL #=STORE_PRODUCT,
STORE_PRODUCT #=PRODUCT_MODEL,
STORE_PRODUCT #=PRODUCT_VIP,
STORE_PRODUCT #=INDEX_CUSTOM,
STORE_PRODUCT #=PRODUCT_STAR,

fd_labeling(L).
%productline2(L).