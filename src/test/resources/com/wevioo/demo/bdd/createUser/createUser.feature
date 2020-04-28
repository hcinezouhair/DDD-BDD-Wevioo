Feature: Test de création des users


  Scenario Outline: Creation de users
    Given le prenom "<PRENOM>"
    And le nom "<NOM>"
    And l adresse mail "<EMAIL>"
    When  j appelle le service de creaion des users
    Then  je recois le code http <HTTP_CODE> et l'erreur suivante "<ERROR_CODE>"

    Examples:
      | PRENOM    | NOM      | EMAIL           | HTTP_CODE | ERROR_CODE     |
      | ZOUHIR    | HCINE    | test@wevioo.com | 201       | -              |
      | ZOUHIR    | HCINE123 | test@wevioo.com | 400       | BAD_LAST_NAME  |
      | ZOUHIR    | 123      | test@wevioo.com | 400       | BAD_LAST_NAME  |
      | ZOUHIR    |          | test@wevioo.com | 400       | BAD_LAST_NAME  |
      | ZOUHIR123 | HCINE    | test@wevioo.com | 400       | BAD_FIRST_NAME |
      | 123       | HCINE    | test@wevioo.com | 400       | BAD_FIRST_NAME |
      |           | HCINE    | test@wevioo.com | 400       | BAD_FIRST_NAME |
      | ZOUHIR    | HCINE    | XXXXXXX         | 400       | BAD_EMAIL      |
      | ZOUHIR    | HCINE    |                 | 400       | BAD_EMAIL      |
      | ZOUHIR    | HCINE    | test@gmail.com  | 412       | INVALID_PROFESSIONAL_EMAIL |