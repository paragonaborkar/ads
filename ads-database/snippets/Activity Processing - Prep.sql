SET FOREIGN_KEY_CHECKS=0;

update controller_release set processed = 0;
update controller_work_package set processed = 0;
delete from  qtree_disposition;
delete from  application;
delete from activity_lob_x_ref;
delete from activity;
delete from activity_response;
delete from user_corporate;

SET FOREIGN_KEY_CHECKS=1;

# Only to simulate DiscoverOwner if needed.
UPDATE `ads_dev`.`qtree` SET `last_accessed`='2018-03-22 12:04:19' WHERE last_accessed is null; 