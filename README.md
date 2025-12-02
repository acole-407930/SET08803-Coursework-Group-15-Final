# DevOps Coursework - Group Number 15

## Overview & Purpose

The purpose of this project is to collaborate as a Scrum Team to complete the DevOps coursework.

The task is to design and implement a system that allows for reporting on various specified criteria country, city, capitals, and population information, using the provided `world.sql` database.

Scrum methodology will be used to guide collaboration and teamwork, along with integration, version control, and project tracking tools.
 
---

## System Requirements

The following tools were used to make the project possible:

- **IntelliJ (Community Edition is acceptable)**

- **JDK 17** – Software Development Kit for Java

- **Maven** – Automation tool used for Java projects

- **MySQL** – To interact with and integrate the `world.sql` database

- **Git/GitHub** – For Scrum team collaboration and version control

---

## Deliverables

The project deliverables are as follows:

1. Code of Conduct

2. Product Backlog

3. Kanban Board/ Sprint Board  - https://zube.io/napier-513/devops-coursework-group-15/w/workspace-1/kanban

4. Use Cases / Diagram

---

## Team Members

| Name | Student ID | Role | Code Review 1 | Code Review 2 |
|------|-------------|------| ---------- | --------- |
| Sergio Pech | 40735258 | Scrum Master | 20 | 25 |
| Aiden Coleman | 40733930 | Product Owner | 20 | 25 |
| Rowan Bishop | 40740506 | Team Member | 20 | 12.5 |
| Stephanie Kothdiwala | 40679664 | Team Member | 20 | 18.75 |
| Zoe Villanueva | 40733245 | Team Member | 20 | 18.75 |
 
---

## Code Review 1 
### Contribution	Detail

40733930 - Aiden Coleman	Created and managed the project repository, ensuring proper version control and smooth integration of all team deliverables. Followed lab guidelines, troubleshot IntelliJ issues, and supported teammates throughout the workflow to ensure timely and accurate submissions.

40679664 - Stephanie Kothdiwala	Developed use cases, user stories, and the project’s code of conduct. Maintained consistent attendance and clear communication. Completed assigned labs on time and contributed effectively to the group’s progress and coordination.

40735258 - Sergio Pech        	Served as Scrum Master, keeping the team on schedule and accountable. Created a backup repository, coordinated closely with the Product Owner, and maintained regular communication through meetings and check-ins. Ensured smooth collaboration and steady project progress.

40740506 - Rowan Bishop	Created and refined the Use Case Diagram, aligning it with project requirements. Organized GitHub issues to track tasks and bugs, ensuring structure and visibility. Attended all meetings and supported workflow consistency through timely and accurate delivery.

40733245 - Zoe Villanueva        	Set up and maintained the Project Board, Kanban, ReadMe, and Sprint Board based on finalized use cases and user stories. Delivered all components on time and kept communication open for revisions and updates. Demonstrated strong organization and reliability.


## Code Review 2
### Contribution	Detail

40733930 - Aiden Coleman	Created and managed the project repository, ensuring proper version control and smooth integration of team deliverables. Coordinated with the Scrum Master and team, scheduled brief training sessions to resolve issues, and supported successful integration testing and deployment.				

40679664 - Stephanie Kothdiwala	Updated project use cases and user stories to ensure clarity and alignment with requirements. Developed a team Code of Conduct to promote collaboration and accountability, and generated assigned reports.				

40735258 - Sergio Pech        	Collaborated with the Product Owner, assisted in training team members, completed all assigned issues, and worked closely on resolving repository errors and implementing code fixes.				

40740506 - Rowan Bishop	create a use case diagram and generate assigned issues				

40733245 - Zoe Villanueva        	Collaborated on refining the repository’s .md files, supported lab faithfulness by aligning work with the labs and rubric, scheduled meetings accordingly, created issues and managed the Zube.io Kanban board, and completed all assigned tasks.

---
# Implementation Status Report

## Summary
**20 requirements of 32 have been implemented, which is 62.5%**

## Complete Requirements Table

| ID | Requirement Name | Status | Screenshot |
|----|------------------|--------|------------|
| **1. Country Reports** | | | |
| 1 | All the countries in the world organised by largest population to smallest. | Yes |<img width="1162" height="778" alt="image" src="https://github.com/user-attachments/assets/4b62d160-2707-42d3-a5a2-246443656705" />|
| 2 | All the countries in a continent organised by largest population to smallest. | Yes |<img width="1014" height="644" alt="image" src="https://github.com/user-attachments/assets/3eaf2387-07b6-46f2-a788-b49c0ca03bd5" />|
| 3 | All the countries in a region organised by largest population to smallest. | Yes |<img width="849" height="405" alt="image" src="https://github.com/user-attachments/assets/ac7af51f-8906-4c38-bdd4-54638f487fc3" /> |
| 4 | The top N populated countries in the world where N is provided by the user. | Yes |<img width="930" height="488" alt="image" src="https://github.com/user-attachments/assets/69a0ca2f-f291-4c99-a0de-4131cf7bbe60" />|
| 5 | The top N populated countries in a continent where N is provided by the user. | Yes |<img width="825" height="270" alt="image" src="https://github.com/user-attachments/assets/dc4669ae-7256-4416-9abd-79460b87ceab" />|
| 6 | The top N populated countries in a region where N is provided by the user. | Yes |<img width="685" height="472" alt="image" src="https://github.com/user-attachments/assets/763c44a1-8c68-4cd4-af62-5601caf527b3" />|
| **2. City Reports** | | | |
| 7 | All the cities in the world organised by largest population to smallest. | No | |
| 8 | All the cities in a continent organised by largest population to smallest. | Yes |<img width="1497" height="844" alt="image" src="https://github.com/user-attachments/assets/923a2284-a60d-421c-9ab8-56c94c2d3362" />|
| 9 | All the cities in a region organised by largest population to smallest. | No | |
| 10 | All the cities in a country organised by largest population to smallest. | Yes |<img width="1004" height="665" alt="image" src="https://github.com/user-attachments/assets/3a416346-2dfe-43dd-93a0-5e12ad160cde" /> |
| 11 | All the cities in a district organised by largest population to smallest. | Yes | <img width="672" height="547" alt="image" src="https://github.com/user-attachments/assets/ec5bf9fd-d9c1-4004-a9c7-dbee9ad14f17" />|
| 12 | The top N populated cities in the world where N is provided by the user. | Yes | |
| 13 | The top N populated cities in a continent where N is provided by the user. | Yes | |
| 14 | The top N populated cities in a region where N is provided by the user. | Yes |<img width="696" height="124" alt="image" src="https://github.com/user-attachments/assets/8b916071-1795-4eb8-9066-ea49b1b255da" />|
| 15 | The top N populated cities in a country where N is provided by the user. | Yes | |
| 16 | The top N populated cities in a district where N is provided by the user. | Yes |<img width="505" height="174" alt="image" src="https://github.com/user-attachments/assets/9e41818e-91a8-429b-9299-b322f0626849" /> |
| **3. Capital City Reports** | | | |
| 17 | All the capital cities in the world organised by largest population to smallest. | No | |
| 18 | All the capital cities in a continent organised by largest population to smallest. | No | |
| 19 | All the capital cities in a region organised by largest to smallest. | No | |
| 20 | The top N populated capital cities in the world where N is provided by the user. | No | |
| 21 | The top N populated capital cities in a continent where N is provided by the user. | No | |
| 22 | The top N populated capital cities in a region where N is provided by the user. | No | |
| **4. Population Reports** | | | |
| 23 | The population of people, people living in cities, and people not living in cities in each continent. | Yes | |
| 24 | The population of people, people living in cities, and people not living in cities in each region. | Yes | |
| 25 | The population of people, people living in cities, and people not living in cities in each country. | No | |
| **5. Specific Population Reports** | | | |
| 26 | The population of the world. | No | |
| 27 | The population of a continent. | No | |
| 28 | The population of a region. | No | |
| 29 | The population of a country. | No | |
| 30 | The population of a district. | No | |
| 31 | The population of a city. | No | |
| **6. Language Reports** | | | |
| 32 | The number of people who speak Chinese, English, Hindi, Spanish, Arabic from greatest to smallest, including percentage of world population. | No | |

--- 

* Master Build ![Master Build](https://img.shields.io/github/actions/workflow/status/acole-407930/SET08803-Coursework-Group-15-Final/main.yml?branch=master&label=Master%20Build)

* Develop Branch Status ![GitHub Workflow Status (branch)](https://img.shields.io/github/actions/workflow/status/acole-407930/SET08803-Coursework-Group-15-Final/main.yml?branch=master)

* License [![LICENSE](https://img.shields.io/github/license/acole-407930/SET08803-Coursework-Group-15.svg?style=flat-square)](https://github.com/acole-407930/SET08803-Coursework-Group-15/blob/master/LICENSE)

* Release [![Release](https://img.shields.io/github/release/acole-407930/SET08803-Coursework-Group-15-Final/all.svg?style=flat-square&label=Release)](https://github.com/acole-407930/SET08803-Coursework-Group-15-Final/releases)

* [![codecov](https://codecov.io/gh/acole-407930/SET08803-Coursework-Group-15/graph/badge.svg?token=OAULO1R7Y3)](https://codecov.io/gh/acole-407930/SET08803-Coursework-Group-15)

 Zube | Agile project management with a seamless GitHub integration
 Zube lets the product team work alongside the developers. The GitHub integration always keeps developer issues up to date.
 
