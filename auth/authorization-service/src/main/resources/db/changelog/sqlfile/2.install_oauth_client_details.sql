INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types,
                                         web_server_redirect_uri, authorities, access_token_validity,
                                         refresh_token_validity, additional_information, autoapprove)
VALUES ('oa', NULL, '$2a$10$tvUhDidHaEKy3zMMyArGJus9noyygV/z77kzPYgvvwZId88mTt8xe', 'all',
        'password,refresh_token', NULL, NULL, 86400, 604800, NULL, NULL);
