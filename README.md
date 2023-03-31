# Text Yoda App
## How to use my app
- This app has not been uplaoded to the Google Play Store
- Instead you can download my project and run it through Android Studio
## 

<img width="200" alt="Screenshot 2023-03-16 at 7 42 03 PM" src="https://user-images.githubusercontent.com/75393933/228706192-119793b0-4555-4f5d-a5bc-637efd089a81.png">

##
## Assignment guidlines
Create an application similar to the Yoda translator illustrated in class and outlined in slides
“15 – Networking”. The application should accept information from the user, use that information as part of an internet query, retrieve information in JSON format, parse the information, and display the results to the user. There should be one activity/screen described as follows:
1. Display a prompt and an EditText field for entering information from the user. The EditText should have input type "textMultiLine".
2. To improve usability, when the app starts, focus should be set to the EditText for the user information, and the keyboard should display automatically. (Don’t make the user have to click in the EditText field to initiate these behaviors. See slides “10 – Widgets” for details on setting focus and automatically displaying the keyboard.)
3. Provide a button to initiate transfer of the information.
4. Display the retrieved information (i.e., the parsed JSON information) to the user in a TextView.
Use an attribute similar to android:lines="20" for the TextView.
5. Use a coroutine or a network support library (e.g., Volley, Retrofit, or OkHttp) to retrieve the information. You can also use a separate thread and View.post(Runnable), but you can get an A+ on the assignment only if you use coroutines or a network support library.
6. You are not required to save/restore the state of the application.
7. You should have at least minimal error handing if an error is encountered during the retrieval of the information.

## Above and Beyond
All changes made were approved by the professor beofre submission
### Improved UI
- Implamented a CardView and placed an image of yoda inside
- Used personalized color scheme 
- Created a view with dirt-like design to match theme

### Improved Functionality
- Limited the text size to 28 characters to fit text bubble
- When app is opened, keyboard and cursor are automatically displayed and placed
