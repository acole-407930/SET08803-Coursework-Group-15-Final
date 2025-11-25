# Branch Protection Rules
This document outlines the branch protection rules enforced in this repository to ensure code quality, maintain stability, and support collaborative development.

### Protected Branches
- master
- develop
- All release branches (release/*)

### Rules Applied

1. __Require Pull Requests__
   - Direct commits to protected branches are not allowed.
   - All changes must be submitted via a Pull Request (PR).

2. __Required Reviews__
   - At least 1–2 code reviews are required before merging.
   - Reviewers must be different from the author of the PR.

3. __Status Checks__
   - All required CI/CD checks must pass before merging:

   *Build pipeline*
   - Unit tests
   - Linting/formatting checks
   - Security scans (if applicable)

4. Commit Standards
   - Commits must follow the repository’s conventional commit guidelines.
   - No merge commits; use squash or rebase strategies.

5. Branch Naming Convention
   - Feature branches: feature/<short-description>
   - Bugfix branches: bugfix/<short-description>
   - Hotfix branches: hotfix/<short-description>
   - Release branches: release/<version>

6. Additional Protections
   - Require up-to-date branches: PRs must be rebased or merged with the latest target branch before approval.
   - Prevent force pushes: Force pushes are disabled on protected branches.
   - Prevent branch deletions: Protected branches cannot be deleted.

### Workflow Summary
1. Create a new branch from develop. (feature branch)
2. Implement changes and push commits.
3. Open a Pull Request targeting the appropriate protected branch.
4. Ensure all checks pass and request reviews.
5. Once approved, merge using squash or rebase.