Evaluation Project: Servlet/JSP-based Web Application (Using Memory-based Repository)
===

## Requirements
- maven project
- packaging: war
- Apply MVC Pattern + FrontController Pattern
  - Model: includes domain logic. Can be a database connection (can be a repository).
  - View pages use JSP.
  - Minimize use of scriptlets in JSP.
- All messages are supported in two languages: English and Korean.
  - Language can be changed.
- Login/Logout
  - Cannot use other features without logging in.
- User registration/modification/deletion/retrieval
- Posting registration/modification/deletion/retrieval
- If a post is successfully retrieved, the view count is updated.
  - Handled by filter.
- If a post/user is retrieved, the visitor count is updated.
  - Handled by filter.
  - Visitor count should be recorded in a file so that it can be maintained even after the server is stopped and restarted.

## Users
User attributes
- ID
- Password
- Name
- Profile image

Special user - administrator
- ID: admin
- Password: 12345
- Name: Administrator
- Profile image: X
- The administrator is registered at ServletContext initialization time.
- User ID and password are used only when logging in.
  - When viewing other users, their ID and password are not displayed.
- Only name and profile image are displayed on the user retrieval page.
  - ID can be used for functional distinction of users.
- UserRepository is used for user registration/modification/deletion/retrieval.
  - UserRepository implementation uses memory-based data structures (List, Map, etc.).
- UserRepository implementation is registered at ServletContext initialization time for use.

## Posts
Post attributes
- Post ID (long type numeric value)
- Title
- Body (plain text)
- Writer ID
- Time of writing (default is current time)
- Views
- PostRepository is used for post registration/modification/deletion/retrieval.
- PostRepository implementation is registered at ServletContext initialization time for use.
  - PostRepository implementation uses memory-based data structures (List, Map, etc.).

## Screen Configuration

- If not logged in, go to the login screen.
- If a user is logged in,
  - If the user is an administrator, and the ID retrieved from the session matches "admin",
  - User list
  - User retrieval
    - User information modification
    - User deletion
  - User addition
  - Profile upload POST/profile
    - Implemented according to Servlet API 3.0 spec.
    - Do not use the commons-fileupload library.
- If the user is not an administrator,
  - Posting list
    - Posting retrieval
    - If the post was written by the user,
      - Post modification
      - Post deletion
    - If you click on the writer's name, go to the user retrieval screen.
      - The user retrieval screen displays the writer's name and profile.
  - Post registration
- Logout
- Display the current number of visitors, the number of logged-in users, and the current language.
  - Language can be changed.
