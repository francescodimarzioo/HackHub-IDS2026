# HackHub

HackHub è una piattaforma backend sviluppata in Java con Spring Boot per la gestione completa di Hackathon. Questo progetto è stato sviluppato per il corso di Ingegneria del Software (IdS) presso l'Università di Camerino (Unicam).

## Descrizione

HackHub permette di gestire l'intero ciclo di vita di un hackathon, dalla creazione fino alla premiazione, includendo la gestione di team, partecipanti, giudici e mentori. Il sistema supporta varie fasi (iscrizione, svolgimento, valutazione) e fornisce funzionalità per la sottomissione e la valutazione dei progetti.

## Tecnologie Utilizzate

- **Java 17**: Linguaggio di programmazione principale.
- **Spring Boot 3.2.0**: Framework per lo sviluppo dell'applicazione backend.
- **Spring Data JPA**: Per la persistenza dei dati.
- **Hibernate**: ORM per la gestione delle entità.
- **H2 Database**: Database in-memory per sviluppo e testing.
- **Maven**: Strumento di build e gestione delle dipendenze.
- **Visual Paradigm**: Per la modellazione UML (Use Case, Sequence, Class Diagram).

## Funzionalità Principali

- **Gestione Utenti**: Ruoli differenziati (Organizzatore, MembroTeam, LeaderTeam, Giudice, Mentore, MembroStaff).
- **Gestione Hackathon**: Creazione e gestione degli stati dell'evento (IN_ATTESA, IN_ISCRIZIONE, IN_CORSO, IN_VALUTAZIONE, CONCLUSO).
- **Gestione Team**: Creazione team, inviti, iscrizione e abbandono.
- **Sottomissioni**: Invio e aggiornamento dei progetti da parte dei team.
- **Valutazioni**: Sistema di valutazione delle sottomissioni da parte dei Giudici.
- **Richieste di Supporto**: I team possono richiedere aiuto ai mentori con integrazione di link per call (Zoom/Google Meet).
- **Segnalazioni**: I membri del team possono inviare segnalazioni al personale dello staff.
- **Classifica Finale**: Visualizzazione della classifica finale dell'hackathon.

## Architettura e Pattern

Il progetto segue un'architettura a strati con una chiara separazione tra:

- **Controller**: Gestione delle richieste HTTP REST.
- **Validator**: Validazione degli input prima della logica di business.
- **Service**: Logica di business.
- **Repository**: Persistenza dei dati tramite Spring Data JPA.
- **Model**: Entità del dominio.

Design pattern utilizzati:

- **State**: Per la gestione del ciclo di vita dell'hackathon (StatoHackathon).
- **Strategy**: Per la generazione dei link delle call (ZoomStrategy, GoogleMeetStrategy).
- **Facade**: Per l'integrazione con sistemi esterni (CalendarFacade, PagamentoFacade).

## Struttura del Progetto

```
HackHub/
├── src/
│   └── main/
│       └── java/
│           └── com/hackhub/
│               ├── HackHubApplication.java
│               ├── model/
│               ├── controller/
│               ├── service/
│               ├── validator/
│               ├── repository/
│               ├── dto/
│               └── pattern/
│       └── resources/
│           └── application.properties
└── pom.xml
```

## Installazione e Avvio

### Prerequisiti

- JDK 17 installato.
- Maven installato.

### Passi

1. Clona la repository:
    ```bash
    git clone <url-repository>
    ```

2. Naviga nella cartella del progetto:
    ```bash
    cd HackHub
    ```

3. Avvia l'applicazione con Maven:
    ```bash
    mvn spring-boot:run
    ```

L'applicazione si avvierà sulla porta `8080`.

## Console Database

Per ispezionare il database H2 in-memory:

- URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:hackhubdb`
- Username: `sa`
- Password: *(lasciare vuoto)*

## Sequenza di Test con Postman

### 1. Registrazione Utente

**Registra un utente**
`POST http://localhost:8080/auth/registrati`
```
Params:
  nome = Mario
  cognome = Rossi
  email = mario@test.com
  password = 123456
```

**Login**
`POST http://localhost:8080/auth/login`
```
Params:
  email = mario@test.com
  password = 123456
```

### 2. Gestione Hackathon

> Prima di creare un hackathon via API, inserire un organizzatore tramite H2 Console:
> ```sql
> INSERT INTO UTENTI (nome, cognome, email, password, data_registrazione) VALUES ('Admin', 'Org', 'org@test.com', '123456', CURRENT_TIMESTAMP);
> INSERT INTO MEMBRI_STAFF (id, bio, link_profilo) SELECT MAX(id), null, null FROM UTENTI;
> INSERT INTO ORGANIZZATORI (id) SELECT MAX(id) FROM UTENTI;
> SELECT * FROM UTENTI; -- annotarsi l'id dell'organizzatore
> ```

**Crea Hackathon**
`POST http://localhost:8080/hackathon/crea`
```
Params:
  nome = Hackathon Test
  regolamento = Regolamento di prova
  luogo = Napoli
  premioInDenaro = 1000
  dimensioneMaxTeam = 5
  idOrganizzatore = <id_organizzatore>
```

**Avvia Fase Iscrizione**
`PUT http://localhost:8080/hackathon/{idHackathon}/avvia-iscrizione`
```
Params:
  idOrganizzatore = <id_organizzatore>
```

**Avvia Fase Svolgimento**
`PUT http://localhost:8080/hackathon/{idHackathon}/avvia-svolgimento`
```
Params:
  idOrganizzatore = <id_organizzatore>
```

**Avvia Fase Valutazione**
`PUT http://localhost:8080/hackathon/{idHackathon}/concludi-svolgimento`
```
Params:
  idOrganizzatore = <id_organizzatore>
```

**Visualizza Elenco Hackathon**
`GET http://localhost:8080/hackathon`

**Visualizza Dettaglio Hackathon**
`GET http://localhost:8080/hackathon/{idHackathon}`

**Visualizza Regolamento**
`GET http://localhost:8080/hackathon/{idHackathon}/regolamento`

**Visualizza Classifica Finale**
`GET http://localhost:8080/hackathon/{idHackathon}/classifica`

### 3. Gestione Team

**Crea Team**
`POST http://localhost:8080/team/crea`
```
Params:
  idHackathon = <id_hackathon>
  nomeTeam = Team Test
  idLeader = <id_leader>
```

**Abbandona Team**
`DELETE http://localhost:8080/team/{idTeam}/abbandona`
```
Params:
  idMembroTeam = <id_membro>
```

### 4. Gestione Inviti

**Invita Utente**
`POST http://localhost:8080/invito/invita`
```
Params:
  idTeam = <id_team>
  idDestinatario = <id_destinatario>
  idLeader = <id_leader>
```

**Rispondi Invito**
`PUT http://localhost:8080/invito/{idInvito}/rispondi`
```
Params:
  risposta = ACCETTATO
  idUtente = <id_utente>
```

### 5. Supporto e Segnalazioni

**Richiedi Supporto**
`POST http://localhost:8080/supporto/richiedi`
```
Params:
  idMembroTeam = <id_membro>
  descrizione = Ho bisogno di aiuto
```

**Gestisci Richiesta (Mentore)**
`PUT http://localhost:8080/supporto/{idRichiesta}/gestisci`
```
Params:
  azione = ACCETTA
  idMentore = <id_mentore>
```

**Proporre Call (Mentore)**
`PUT http://localhost:8080/supporto/{idRichiesta}/proporre-call`
```
Params:
  tipoCall = ZOOM
  idMentore = <id_mentore>
```

**Invia Segnalazione**
`POST http://localhost:8080/segnalazione/invia`
```
Params:
  idHackathon = <id_hackathon>
  descrizione = Descrizione segnalazione
  idMembroTeam = <id_membro>
```

**Gestisci Segnalazione (Staff)**
`PUT http://localhost:8080/segnalazione/{idSegnalazione}/gestisci`
```
Params:
  azione = ACCETTA
  idMembroStaff = <id_staff>
```
## Iterazioni del Progetto

Il progetto è stato sviluppato seguendo il **Processo Unificato** in 4 iterazioni per un totale di 30 casi d'uso.

### Iterazione 1 — Autenticazione e Ciclo di Vita Hackathon (7 UC)

| # | Caso d'Uso | Attore |
|---|---|---|
| 1 | Registrazione | Visitatore |
| 2 | Login | Visitatore |
| 3 | Creare Hackathon | Organizzatore |
| 4 | Avvio Fase Iscrizione | Organizzatore |
| 5 | Conclusione Fase Iscrizione | Organizzatore |
| 6 | Avvio Fase Svolgimento | Organizzatore |
| 7 | Conclusione Fase Svolgimento | Organizzatore |

### Iterazione 2 — Gestione Team e Inviti (4 UC)

| # | Caso d'Uso | Attore |
|---|---|---|
| 8 | Creare Team | LeaderTeam |
| 9 | Invitare Utenti al Team | LeaderTeam |
| 10 | Gestire Inviti Ricevuti | Utente |
| 11 | Iscrivere il Team a un Hackathon | LeaderTeam |

### Iterazione 3 — Sottomissioni e Valutazioni (9 UC)

| # | Caso d'Uso | Attore |
|---|---|---|
| 12 | Inviare Sottomissione | LeaderTeam |
| 13 | Aggiornare Sottomissione | LeaderTeam |
| 14 | Valutare Sottomissione | Giudice |
| 15 | Visualizzare Sottomissioni | Giudice |
| 16 | Proclamare Vincitore | Organizzatore |
| 17 | Erogare Premio | Sistema Pagamento |
| 18 | Modificare Hackathon | Organizzatore |
| 19 | Aggiungere Mentore a Hackathon | Organizzatore |
| 20 | Chiusura Automatica Iscrizioni | Tempo |

### Iterazione 4 — Supporto, Segnalazioni e Visualizzazioni (10 UC)

| # | Caso d'Uso | Attore |
|---|---|---|
| 21 | Richiedere Supporto | MembroTeam |
| 22 | Gestire Richiesta Supporto | Mentore |
| 23 | Proporre Call | Mentore |
| 24 | Inviare Segnalazione | MembroTeam |
| 25 | Gestire Segnalazione | MembroStaff |
| 26 | Visualizzare Elenco Hackathon | Visitatore |
| 27 | Visualizzare Dettaglio Hackathon | Visitatore |
| 28 | Visualizzare Regolamento Hackathon | Visitatore |
| 29 | Abbandonare Team | MembroTeam |
| 30 | Visualizzare Classifica Finale | Visitatore |

## Autori

- Francesco Di Marzio
- Mariadele Di Biase
- Fabiana Felicioni

**Università di Camerino — Corso di Ingegneria del Software**
