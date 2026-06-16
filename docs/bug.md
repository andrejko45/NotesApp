# CHYBY

1. Prvá väčšia chyba je, že aj napriek použitiu depends_on v compose súbore, tak sa spúšťa prvý kontajner so Spring Boot. To znamená, že ešte      nebeží **MySQL** databáza preto nedokáže JDBC nadviazať spojenie s DB. Chyba **Communications link failure**. V budúcnosti bude aplikovaný tzv. Healtcheck v compose súbore.