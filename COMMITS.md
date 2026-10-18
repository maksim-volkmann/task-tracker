# Git rules

## Commit message format

Conventional Commits (https://www.conventionalcommits.org) - the format most teams use.

```
type: short description
```

- `type` is lowercase, followed by a colon and a space
- description in imperative mood: `add`, `fix`, `remove` (not `added`, `fixes`)
- lowercase start, no full stop, under ~50 characters

| Type | When | Example |
|---|---|---|
| `feat` | new behaviour the user can see | `feat: add list command filtered by status` |
| `fix` | bug fix | `fix: crash when tasks.json is empty` |
| `test` | tests only | `test: cover delete with unknown id` |
| `refactor` | code change, same behaviour | `refactor: extract JSON parsing into TaskStore` |
| `docs` | README, comments | `docs: add usage examples to README` |
| `chore` | setup, build, dependencies, .gitignore | `chore: initial project setup` |
| `style` | formatting only | `style: reformat TaskService` |

## Basic rules

- One change per commit. Message needs "and"? Make it two commits.
- Commit every time something small works.
- Only commit code that compiles and passes its tests.
- Never commit passwords, tokens or `.env`.

## Useful commands

### See what's going on

| Command | Does |
|---|---|
| `git status` | what's changed, what's staged |
| `git diff` | changes NOT staged yet |
| `git diff --staged` | changes staged for the next commit |
| `git log --oneline` | commit history, one line each (`-10` for the last 10) |
| `git show <hash>` | what one commit changed |

### Stage and commit

| Command | Does |
|---|---|
| `git add <file>` | stage one file |
| `git add .` | stage everything (check `git status` first) |
| `git add -p` | stage piece by piece, choosing each change |
| `git commit -m "feat: ..."` | commit what's staged |
| `git push` | send commits to GitHub |
| `git pull` | get the latest from GitHub |

### Undo

| Command | Does |
|---|---|
| `git restore --staged <file>` | unstage a file, keeps your changes |
| `git restore --staged .` | unstage everything, keeps your changes |
| `git restore <file>` | throw away unsaved changes in a file - can't be undone |
| `git commit --amend -m "..."` | fix the last commit message (only before pushing) |
| `git reset --soft HEAD~1` | undo the last commit, keep the changes staged (only before pushing) |
| `git revert <hash>` | undo a pushed commit safely by adding a new opposite commit |
| `git stash` / `git stash pop` | park unfinished changes / bring them back |

Rule: before pushing you can rewrite history; after pushing, use `revert`.

### Branches

| Command | Does |
|---|---|
| `git branch` | list branches, `*` is the current one |
| `git switch -c feature/list-command` | create a new branch and move to it |
| `git switch main` | go back to main |
| `git merge feature/list-command` | bring a branch into the current one |
| `git branch -d feature/list-command` | delete a merged branch |
| `git push -u origin feature/list-command` | push a new branch to GitHub the first time |

## .gitignore for Java projects

```
# Build output
target/
build/
out/
*.class

# IDE
.idea/
*.iml
.vscode/

# Gradle
.gradle/

# Logs
*.log

# Secrets
.env

# OS
.DS_Store
Thumbs.db
```

Commit a `.env.example` with the variable names and fake values, so others know what to set.
