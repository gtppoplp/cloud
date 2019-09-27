INSERT INTO `cloud_user_center`.`oa_user`(`id`, `job_number`, `username`, `password`, `name`, `mobile`, `enabled`,
                                          `account_non_expired`, `credentials_non_expired`, `account_non_locked`,
                                          `created_id`, `created_time`, `created_by`, `updated_id`, `updated_time`,
                                          `updated_by`)
VALUES (1, 'FD-0001', 'admin', '$2a$10$tvUhDidHaEKy3zMMyArGJus9noyygV/z77kzPYgvvwZId88mTt8xe', '超级管理员', '18076382808',
        1, 1, 1, 1, 1, unix_timestamp(now()), '超级管理员', 1, unix_timestamp(now()), '超级管理员');
