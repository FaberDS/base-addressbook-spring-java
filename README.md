# Addressbook Spring Java

This project is the first in a serie of small projects to develope a deeper understanding of different technologies, which are currently requested from the software market. 

## The goal 

is to:
- [ ] develope
- [ ] test
- [ ] refactor
- [ ] host
- [ ] use build automation

The applications mentioned in the Milestones

### Milestones

within this series the first milestones are:
- [ ] Addressbook Spring Java Backend
- [ ] Addressbook Spring Kotlin Backend
- [ ] Addressbook iOS SwiftUI Application
- [ ] Addressbook Android Java Application
- [ ] Addressbook HTML, Vanilla JavaScript, CSS Frontend


### Additional milestones
- [ ] Addressbook Node JS Backend
- [ ] Addressbook iOS Swift UIKit Application
- [ ] Addressbook Android Kotlin Application
- [ ] Addressbook Android/ iOS Flutter Application
- [ ] Addressbook VUE.js Frontend
- [ ] Addressbook React Frontend
- [ ] Addressbook Angular Frontend

## Project details

Simple addressbook to help users to handle contacts to people.

### User Stories

1. As a user I want to register myself with email and password for accessing my private addressbook.
2. As a user I want to handle CRUD operations on contact entries within my private addressbook. With the details:
    - Firstname* (String)
    - Lastname* (String)
    - Phone (String)
    - Email (String)
    - Birthday (Date)
    - Business (Bool)
    - Street (String)
    - City (String)
    - Zipcode (Number)
    - Country (ENUM)
3. As maintainer of the application I want to have ensured that the entries are validated as expected. 
    - Firstname, lastname, street, zipcode, phone, email a minimum length
    - email correct syntax



---
#### further options to extend the project

- Add additional login possibilities like
    - apple id
    - google
    - facebook
- Extend the address entry attributes for:
    - category (ENUM)
    - latest contacted (Date)
    - company
    - related to (Contact)
- The address could be added via geolocation.

---
# How to

## Setup Postgres DB with Docker
```
docker pull postgres
docker images
docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres

```
