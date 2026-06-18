# CHYBY

1. Prvá väčšia chyba je, že aj napriek použitiu depends_on v compose súbore, tak sa prvý spúšťa Spring Boot. To znamená, že ešte      nebeží **MySQL** databáza preto nedokáže JDBC nadviazať spojenie s DB. Chyba **Communications link failure**. V budúcnosti bude aplikovaný tzv. healtcheck v compose súbore.
2. Oddelenie **User DTO** od **Authentification DTO**. 
3. Chyby validácie sa riešia priamo v **DTO**. Chyba používateľ existuje sa bude riešiť v Service vrstve s business logikou.