ALTER TABLE job_post_activity
DROP
FOREIGN KEY FK44003mnvj29aiijhsc6ftsgxe;

ALTER TABLE job_post_activity
DROP
FOREIGN KEY FK62yqqbypsq2ik34ngtlw4m9k3;

ALTER TABLE job_seeker_apply
DROP
FOREIGN KEY FKmfhx9q4uclbb74vm49lv9dmf4;

ALTER TABLE job_seeker_save
DROP
FOREIGN KEY FKpb44x040gkdltxqy9m7jmvvf3;

ALTER TABLE job_post_activity
DROP
FOREIGN KEY FKpjpv059hollr4tk92ms09s6is;

DROP TABLE job_company;

DROP TABLE job_location;

DROP TABLE job_post_activity;

ALTER TABLE job_seeker_apply
DROP
COLUMN apply_date;

ALTER TABLE job_seeker_apply
DROP
COLUMN cover_letter;

ALTER TABLE job_seeker_apply
DROP
COLUMN job;

ALTER TABLE job_seeker_save
DROP
COLUMN job;

ALTER TABLE users
    MODIFY is_active BIT (1) NOT NULL;