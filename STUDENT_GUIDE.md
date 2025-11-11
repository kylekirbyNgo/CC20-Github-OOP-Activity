# 🧭 Student Guide — Program Collection
This guide will help you submit your own program while learning how to use Git and GitHub properly.

---
# 🧰 Prerequisites: Git and SSH Setup
Before you clone the repository, make sure your Git and SSH are correctly configured.
1. Verify Git Installation
    Check if Git is installed:
    ```bash
    git --version
    ```
    If not installed, download from: [git downloads](https://git-scm.com/downloads).

2. Configure Your Git Identity
    Set your Git username and email — this will appear on your commits.
    ```bash
    git config --global user.name "Your Full Name"
    git config --global user.email "your_email@example.com"
    ```
    Confirm your settings:
    ```bash
    git config --global --list
    ```
3. Set Up SSH Key for GitHub
    1. Generate a new SSH key:
        ```bash
        ssh-keygen -t ed25519 -C "your_email@example.com"ssh-keygen -t ed25519 -C "your_email@example.com"
        ```
        (If asked for a file location, just press Enter.)
    2. Start the SSH agent:
        ```bash
        eval "$(ssh-agent -s)"
        ```
    3. Add your new SSH key:
        ```bash
        ssh-add ~/.ssh/id_ed25519
        ```
    4. Display your public key:
        ```bash
        cat ~/.ssh/id_ed25519.pub
        ```
    5. Copy the entire key and add it to your GitHub account:
        - Go to GitHub → Settings → SSH and GPG Keys → New SSH KeyGo to GitHub → Settings → SSH and GPG Keys → New SSH Key
        - Paste your key and save
    6. Test the connection:
        ```bash
        ssh -T git@github.com
        ```
        You should see: 
        `"Hi <username>! You've successfully authenticated."`
4. Clone Using SSH (Recommended)
    Once SSH is set up, clone the repository using your SSH link:
    ```bash
    git clone git@github.com:<teacher-username>/program-collection.git
    cd program-collection
    ```
    ⚠️ If SSH doesn’t work, you can fall back to HTTPS:
    ```bash
    git clone https://github.com/<teacher-username>/program-collection.git
    ```
---

## 🧱 1. Setup

### Fork the Repository
⚠️ CRITICAL: Do this FIRST before cloning!
1. Go to the instructor's repository:
```text
https://github.com/MichaelPagaran/CC20-Github-OOP-Activity
```
2. Click the "Fork" button (top right corner, next to "Star")
3. GitHub will ask "Where should we fork this repository?"
    - Select YOUR account
4. Wait for GitHub to create your fork (takes a few seconds)
5. You'll be redirected to YOUR fork:
    ```
    https://github.com/YOUR-USERNAME/CC20-Github-OOP-Activity
    ```
    ✅ Success indicator: You should see "forked from MichaelPagaran/CC20-Github-OOP-Activity" under the repository name
6. Clone YOUR Fork (Not the Instructor's!)
    - Using SSH (Recommended):
    ```bash
        # Clone YOUR fork (replace YOUR-USERNAME!)
        git clone git@github.com:YOUR-USERNAME/CC20-Github-OOP-Activity.git

        # Enter the directory
        cd CC20-Github-OOP-Activity
    ```
    - Using HTTPS (If SSH doesn't work):
    ``` bash
    # Clone YOUR fork
    git clone https://github.com/YOUR-USERNAME/CC20-Github-OOP-Activity.git

    # Enter the directory
    cd CC20-Github-OOP-Activity
    ```
    - Verify You Cloned YOUR Fork:
    ```bash
    # Check the remote URL
    git remote -v
    ```
        - Expected output (SSH):
        ```bash
        origin  git@github.com:YOUR-USERNAME/CC20-Github-OOP-Activity.git (fetch)
        origin  git@github.com:YOUR-USERNAME/CC20-Github-OOP-Activity.git (push)
        ```
        - Expected output (HTTPS):
        ```bash
        origin  https://github.com/YOUR-USERNAME/CC20-Github-OOP-Activity.git (fetch)
        origin  https://github.com/YOUR-USERNAME/CC20-Github-OOP-Activity.git (push)
        ```
        ✅ CORRECT: You see YOUR username
        ❌ WRONG: You see "MichaelPagaran" → You cloned the wrong repo!

## 🪪 2. Create an Issue on GitHub
Open the repository in GitHub.

Go to the Issues tab → click New Issue.

Title example:
Add <YourName> Program (e.g., Add Martin Program)

Briefly describe what your program will do.

Submit the issue.

## 🌿 3. Create a Branch from the Issue
After creating the issue, make a new branch linked to it:
```bash
git fetch origin
git checkout develop
git pull

git checkout -b feature/<issue-number>-<short-title>

# Example:
# git checkout -b feature/12-fibonacci-upgrade
```

## 💾 4. Create Your Program
1. Copy this file:
```
TEMPLATE_YourProgram.java
```
2. Paste it inside a new folder in programs/, example:
```
programs/martin/MyCoolProgram.java
```
3. Edit your file:
- Change the class name
- Update `getName()`, `getDescription()`, `getAuthor()`
- Add your logic in the `run()` method

## 🧩 5. Register Your Program
```java
programs.add(new programs.martin.MyCoolProgram());
```
Do not remove or edit existing entries.

## 🧪 6. Test Your Program
```bash
javac Main.java
java Main
```
You should see your program in the list.
Try selecting it to confirm it works.

## 🚀 7. Commit and Push
``` bash
git add .
git commit -m "Add <YourName> program"
git push origin feature/<issue-number>-<short-title>
```

## 🔁 8. Create a Pull Request (PR)
1. Go to GitHub → You’ll see a banner for your new branch.
2. Click Compare & pull request.
3. Set base branch: develop.
4. Write a short description and link your issue.
5. Click Create pull request.

## 🔄 9. Sync with Latest Code
It is CRITICAL to regularly update your feature branch with the latest changes from develop to prevent complex merge conflicts later. Always follow these steps before you start a new work session or before creating your Pull Request.
1. Switch to the `develop` branch: This is your clean sync point.
    ``` bash
    git checkout develop
    ```
2. Fetch the latest changes from your remote fork: (This ensures origin/develop is current).
    ```bash
    git fetch origin
    ```
3. Update your local develop: Merge the remote origin/develop into your local develop.
    ```bash
    git merge origin/develop
    ```
4. Switch back to your feature branch:
    ```bash
    git checkout feature/<your-branch-name>
    ```
5. Merge the updated develop into your feature branch: This brings the latest code into your work.
    ```bash
    git merge develop
    ```
    If there are conflicts, you must resolve them now before proceeding.

## ✅ 10. After Approval
Once your PR is merged — congratulations! 🎉
Your work becomes part of the official collection.

