# Progetto MyLibrary - Introduzione all'architettura a Microservizi con Spring Boot

Questo repository, "spring-boot-mylibrary-introduction-microservices", è un'estensione del progetto "MyLibrary" implementando un'architettura a microservizi con Spring Cloud.

## Scopo del Progetto

L'obiettivo principale è studiare le basi di Spring Cloud e delle sue funzionalità attraverso l'implementazione di una struttura a microservizi. In particolare, sono stati sviluppati i seguenti componenti:

### Componenti Implementate:

1. **LibraryService:**
   - Basato sul progetto MyLibrary, gestisce il catalogo principale della libreria.

2. **LibraryStatisticsService:**
   - Genera statistiche basate sui dati del catalogo.
   - Endpoint: `/api/book-statistics`
   - Operazioni Possibili:
     - `GET /api/book-statistics/genre/{genre}`: Restituisce il numero e la percentuale dei libri del genere specificato.
     - `GET /api/book-statistics/date/{date}`: Restituisce il numero e la percentuale dei libri pubblicati dopo una determinata data.
     - `GET /api/book-statistics/name/{firstName}/{lastName}`: Restituisce il numero dei libri scritti da un determinato autore.
   - Implementazione:
     - Utilizza i dati forniti dal servizio LibraryService tramite chiamate REST.
     - Esegue elaborazioni aggiuntive su questi dati per generare le statistiche richieste.
     - Restituisce le statistiche tramite una stringa.

3. **APIGateway:**
   - Aggiunge un gateway API (Spring Cloud Gateway) per semplificare l'accesso ai microservizi.
   - Configura il gateway per reindirizzare le richieste ai microservizi appropriati in base al percorso.

## Configurazione e Utilizzo

Per eseguire il progetto, seguire i seguenti passaggi:

1. Configurare EurekaServer per la registrazione dei microservizi.
2. Eseguire i microservizi LibraryService, LibraryStatisticsService e APIGateway.
3. Accedere a Eureka Dashboard per verificare la registrazione dei microservizi.

## Docker-Compose per il Database

È incluso un docker-compose per il database, popolato con informazioni sui libri e sugli autori. È possibile utilizzare lo stesso contenitore per eventuali altri database implementati (i servizi si collegheranno allo stesso contenitore, ma non allo stesso DB).
