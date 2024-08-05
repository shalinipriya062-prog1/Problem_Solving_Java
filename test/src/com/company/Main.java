package com.company;
import java.util.*;

//test
public class Main {

    public static void main(String[] args) {
        String [] e = {"f","t","o"};
        String fi = (e.length>0) ? e[0]: null;
        System.out.println(fi);
    }
}

/*WITH view1 as(
        select h.BUYER_ID as BUYER_ID, h.HOUSE_ID as HOUSE_ID, p.PRICE as PRICE from house h left join price p on h.HOUSE_ID = p.HOUSE_ID
)


select DISTINCT(BUYER_ID), sum(PRICE) as TOTAL_WORTH from view1
group by BUYER_ID HAVING sum(PRICE) > 100 and count(HOUSE_ID)>1;*/
