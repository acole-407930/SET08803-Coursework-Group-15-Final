# **Contributing Guide – Group 15 DevOps Coursework**

Thank you for contributing to the Group 15 DevOps Coursework project.
Our goal is to develop a clean, maintainable World Population Analytics using DevOps practices.
This guide outlines how to contribute effectively while maintaining consistency, code quality, and team alignment.

Please review this document before submitting any changes.

---

# 1. Introduction

We welcome contributions from all team members.
This guide explains:

* How to set up your environment
* How to create branches
* How to submit work through pull requests
* How to follow our merge flow
* What standards to maintain when writing code

All contributors are expected to follow the project’s **Code of Conduct** (see `CODE_OF_CONDUCT.md`).

---

# 2. Getting Started

Before contributing, ensure you have the correct environment and tools.

### **Prerequisites**

* **Java 17+**
* **Maven**
* **Docker** (if running MySQL in a container)
* **Git + GitHub account**
* MySQL server or Docker MySQL instance

### **Clone the Repository**

```bash
git clone https://github.com/<your-org-or-user>/SET08803-Coursework-Group-15-Final.git
```

### **Project Structure Overview**

```
src/main/java/com/napier/sem/   → application logic
src/main/resources/             → configuration files
src/test/java/                  → tests (if applicable)
.github/workflows/              → CI/CD pipeline
```

### **Build & Run**

```bash
mvn clean package
java -jar target/sem-1.0-SNAPSHOT.jar
```

### **Running Tests**

```bash
mvn test
```

---

# 3. Branching & Workflow

To keep our history clean and avoid conflicts, follow the branching system below.

### 🔹 **Branch Creation**

All new work must begin from the **`develop`** branch:

```
develop → feature/<your-branch-name>
```

### 🔹 **Naming Convention**

Use descriptive, camelCase names. Examples (from current team branches):

* `feature/totalPopulationOfDistrict`
* `feature/topNMostPopulatedCitiesInRegion`
* `feature/topNMostPopulatedCountries`
* `feature/topNMostPopulatedCitiesInWorld`
* `feature/totalPopulationOfCountry`

### 🔹 **Merge Flow**

All merges must follow this sequence:

```
feature/<your-branch> → develop → release/1.0 → master
```

* **Never push directly to `master`**
* **Always open a PR and ensure CI/CD passes**

### 🔹 **Reminder to Team**

After submitting changes, **check the GitHub Actions tab**:

* If it is green → ready for review
* If it fails → fix compile errors, missing files, or test failures

---

# 4. Making Changes

To maintain project quality:

### **Follow the Existing Code Style**

* Keep logic out of `App.java`
* Use proper packages: `repository`, `service`, `model`, `usecase`
* Use meaningful class and method names

### **Commit Message Style**

Use short, clear messages:

* `Add: implemented city population report`
* `Fix: SQL join error in CountryRepository`
* `Refactor: moved DB logic to service layer`

### **General Guidelines**

* Keep commits small and focused
* Avoid pushing commented-out code
* Document new methods when needed
* Include JavaDoc for complex logic
* Ensure code compiles before pushing

---

# 5. Submitting a Pull Request

### **Steps**

1. Push your branch:

   ```bash
   git push origin feature/<branch-name>
   ```

2. Open a **Pull Request** on GitHub:

    * **Base branch:** `develop`
    * **Compare branch:** your feature branch

3. Provide a meaningful PR description.

### **PR Description Template**

```
## Summary
Short description of what was added or changed.

## Details
- Implemented SQL query for region-level report
- Added repository + service methods
- Updated App.java switch menu

## Issues Addressed
Closes #<issue-number>
```

### **Before Requesting Review**

* Confirm CI/CD checks pass
* Resolve conflicts if GitHub indicates them
* Re-test code locally

---

# 6. Issue Reporting

If you find a bug or want to suggest a feature:

### **Include:**

* Steps to reproduce
* Expected vs actual behavior
* Screenshot of error (if applicable)
* Logs or console output
* Branch where the issue occurred

Use GitHub issue templates if available.

---

# 7. Code of Conduct

All contributors must follow our team’s **Code of Conduct**.

Topics include:

* Respectful communication
* Collaboration and support
* Honesty and transparency
* Accountability and professionalism

Violations may be reported to the project maintainers.

See: `CODE_OF_CONDUCT.md`

---

# 8. License

This repository is provided under the **Apache License 2.0**.
By contributing, you agree that your contributions fall under the same license.

---

# 9. Contact & Support

For assistance:

* Reach out via the group’s communication channel
* Tag reviewers in your PR
* Document blockers early so the team can support

---
