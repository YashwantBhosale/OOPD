# Bug Management System

## Overview

The **Bug Management System** is a software solution designed to fascilitate the process of reporting, tracking, assigning, and resolving bugs in software projects. It provides a collaborative platform for **Testers**, **Developers**, and **Managers** to manage software quality efficiently.

This system supports functionalities like:
- Bug reporting and status tracking
- Developer assignments
- Attachments and comments for bug tracking
- Notifications
- Project-wise bug segregation
- Reports generation

---

## Main Components

### 1. `User` (Abstract Base Class)
All system users inherit from this class. It contains:
- Basic attributes: `userID`, `name`, `email`, `role`
- Common methods: `login()`, `logout()`, `updateProfile()`

**Subclasses:**
- `Tester`
- `Developer`
- `Manager`

---

### 2. `Tester` (User → Tester)
Testers are responsible for:
- **Reporting bugs** via the `reportBug()` method
- **Verifying bug fixes** using `verifyBugFix()`

---

### 3. `Developer` (User → Developer)
Developers are responsible for:
- Fixing assigned bugs
- Updating bug progress with logs
- Requesting assistance if stuck

Attributes:
- `expertise`: list of programming languages or technologies
- `currentBugs`: bugs currently assigned

Methods:
- `updateBugProgress()`
- `resolveBug()`
- `requestAssistance()`

---

### 4. `Manager` (User → Manager)
Managers oversee the development process. Responsibilities include:
- Assigning bugs to developers
- Reviewing reported bugs
- Generating team reports

Attributes:
- `managedProjects`

Methods:
- `assignBug()`
- `reviewBug()`
- `generateTeamReport()`

---

### 5. `Bug`
Central class of the system, representing a bug or issue.

Attributes:
- `bugID`, `title`, `description`
- `severity`, `priority`, `status` *(Enums)*
- `creationDate`, `resolutionDate`
- `attachments`, `comments`

Relationships:
- Reported by a **User (Tester)**
- Assigned to a **Developer**
- Belongs to a **Project**
- Contains **Comments** and **Attachments**

Methods:
- `updateStatus()`
- `assignDeveloper()`
- `addComment()`
- `attachFile()`

---

### 6. `Project`
Represents a software project.

Attributes:
- `projectID`, `name`, `description`
- `startDate`, `endDate`
- `bugs`: list of associated bugs
- `teamMembers`: developers/testers/managers working on it

Methods:
- `addBug()`
- `removeBug()`
- `assignUser()`
- `generateReport()`

Relationships:
- Contains **Bugs**
- Has multiple **Users**

---

### 7. `Comment`
Facilitates discussions and logs within a bug.

Attributes:
- `commentID`, `timestamp`, `content`

Relationships:
- Authored by a **User**
- Belongs to a **Bug**

Methods:
- `editContent()`
- `deleteComment()`

---

### 8. `Attachment`
Files attached to bugs for further context like logs, screenshots, etc.

Attributes:
- `attachmentID`, `fileName`, `fileType`, `data`

Relationships:
- Belongs to a **Bug**

Methods:
- `getFileSize()`
- `download()`

---

### 9. `Notification`
Notifies users of important actions or updates.

Attributes:
- `notificationID`, `message`, `timestamp`, `read`

Relationships:
- Sent to a **User**

Methods:
- `markAsRead()`
- `send()`

---

### 10. `BugTracker`
Main controller or interface of the system.

Attributes:
- `bugs`, `projects`, `users`, `notifications`

Methods:
- `createBug()`
- `updateBug()`
- `searchBugs()`
- `sendNotification()`
- `generateSystemReport()`

Relationships:
- Manages all other entities.

---

### 11. `Report`
Used for exporting summary data.

Attributes:
- `reportID`, `title`, `generatedOn`, `content`

Methods:
- `exportAsPDF()`
- `exportAsCSV()`

---

## Class Relationships Summary

| From Class       | Relation Type | To Class         | Description                                  |
|------------------|----------------|------------------|----------------------------------------------|
| `User`           | Inheritance    | `Tester` / `Developer` / `Manager` | Role-based specialization |
| `Bug`            | Association    | `User`           | Reported by (Tester)                         |
| `Bug`            | Association    | `Developer`      | Assigned to                                  |
| `Bug`            | Aggregation    | `Attachment`     | Attached files                               |
| `Bug`            | Aggregation    | `Comment`        | Comments posted                              |
| `Bug`            | Association    | `Project`        | Bug belongs to project                       |
| `Project`        | Aggregation    | `User`           | Project team                                 |
| `Project`        | Aggregation    | `Bug`            | Bugs in the project                          |
| `User`           | Aggregation    | `Notification`   | Notifications sent to                        |
| `BugTracker`     | Aggregation    | `Bug` / `Project` / `User` / `Notification` | System-wide control                         |

---

## overview

1. **Testers** log in and report bugs with necessary details and attachments.
2. The **Manager** reviews the bug and assigns it to a suitable **Developer**.
3. The **Developer** works on resolving the bug, updating progress and finally marking it resolved.
4. The **Tester** verifies the fix and closes the bug.
5. All these activities are tracked per **Project**, and can be exported as **Reports**.
6. Users get **Notifications** for relevant events (assignment, comments, status changes).
7. All components are orchestrated by the **BugTracker** system controller.
