select * from users;
select * from authorities;
select * from blog_entity;

delete from users;
delete from blog_entity;
insert into users (id,username,password) values(1,"karlchan","password");

/**
 *user SQL 
 */

/**
 *entity 新增 
 */
select * from blog_entity where id < 100  for update;
select * from blog_entity where USER_ID =1 and isTemp =0;
delete from blog_entity where id < 100;


select * From blog_image;
delete from blog_image where id < 100;
select 
    blogentity0_.id as col_0_0_,
    blogentity0_.title as col_1_0_,
    blogentity0_.content as col_2_0_,
    blogentity0_.createdate as col_3_0_,
    blogentity0_.readprivate as col_4_0_,
    blogentity0_.commentable as col_5_0_,
    images1_.id as col_6_0_,
    images1_.name as col_7_0_,
    images1_.description as col_8_0_,
    images1_.position as col_9_0_
from
    BLOG_ENTITY blogentity0_
        left  join
    BLOG_IMAGE images1_ ON blogentity0_.id = images1_.ENTITY_ID
where
    blogentity0_.isTemp = 1
        and blogentity0_.USER_ID = 1;
