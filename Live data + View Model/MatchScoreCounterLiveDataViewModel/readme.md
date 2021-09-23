### Requirement
- all method in data binding(Yes, this project use data binding)
- add dependecies in gradle

```
val lifecycle_version = "2.4.0-beta01"

// ViewModel
implementation("androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version")
// LiveData
mplementation("androidx.lifecycle:lifecycle-livedata:$lifecycle_version")
```

<br>

### Explanation
- Match Score Counter was an app where it help user to count score mark. It is a very simple app which use View Model and Live Data with binding method. The reason we using View Model is to avoid data lost during configuration change. There are many way for configuration change to occur which when screen oriented, language change, keyboard chang and etc. I also make sure that the screen show better placement of object when screen change orientation to landscape mode, that why I have 2 layout for one activity.
- This project use:
  - Data Binding
  - Live Data
  - View Model
  
- View Model Factory is optional same goes to two ways data binding (Use when it appropriate)
- everything else explain in this project
- bear in mind this project only for my future refrence. I just put explanation which might future me needed
- If something wrong with my code or explanation, feel free to tell me. i just a noob guys

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

@IZMARY2021
