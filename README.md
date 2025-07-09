# TheBelievers

This app is designed to support your spiritual journey by providing key Islamic tools in one place.
  - 📿 Prayer Times: View accurate prayer times for previous, current, and future dates.
  - 📖 Quran Reader: Browse the Quran by chapter and read individual verses with ease.
  - 🌙 Daily Reminders: Post and view daily Islamic reminders shared by other users.
  - 💬 Feedback System: Report issues or suggest improvements directly to the app creator.
  - 🌓 Custom Themes: Toggle between beautifully designed light and dark modes that align with the app’s aesthetic.

>[!NOTE]
>This is the first version of the application. It is currently under active development and will be deployed soon. In the meantime, I will continue updating and releasing new versions as improvements are made.

## Tech Stack:
- Java
- Spring Boot
- Android Studio
- IntelliJ
- PostgreSQL


### Requirements
- Java 17 or later (Java 21 recommended)
- Maven
- Android Studio (latest)
- Internet connection (to access the hosted backend and database)

### How to run the android app:
1. Install android studio on your device - this can be done by using the following link: https://developer.android.com/studio?gad_source=1&gad_campaignid=21831783762&gbraid=0AAAAAC-IOZlXwfJpb3OsE4V21tqBCG_vj&gclid=CjwKCAjwmenCBhA4EiwAtVjzmkLLQruHMeePapfPYUhKSR7C5E1GwK4oDFOyJ1IfOvmxYIbsjKZjfBoCsgwQAvD_BwE&gclsrc=aw.ds
2. Download the frontend branch from GitHub. Once downloaded, unzip the files and open the project in Android Studio
3. Run the application from Android Studio. It should launch an emulator and display a login screen.

### How to run backend application on IDE:
1. Download the backend branch from GitHub and unzip the download
2. Ensure Java 17 or later is installed (Java 21 is recommended), and all Maven dependencies are downloaded using mvn clean install.
3. Run the backend using an IDE (e.g., IntelliJ, Eclipse) or preferably a VM — make sure it works by running this link on your browser or Postman http://localhost:8080/api/v1/TheBeliever/prayer_times
4. If the link displays JSON and some key-value pairs fajr,zuhr etc., this means the API is working.

### How to run backend application on Maven:
1. Download the backend branch from GitHub and unzip the download
2. Download Maven on your device using this link: https://maven.apache.org/download.cgi
3. Open command prompt and change the file location to the backend branch using this command “cd file-location”
4. Once that’s done run this command  mvn clean install -X .
5. If the install is successful, run this command “mvn spring-boot:run”
6. The spring boot server should be up and running, check by running this link on your browser or Postman: http://localhost:8080/api/v1/TheBeliever/prayer_times
7. If the link displays JSON and some key-value pairs Fajr,Zuhr etc., this means the API is working.

### Backend API hosted here
https://thebelievers.onrender.com/api/v1/TheBeliever/
