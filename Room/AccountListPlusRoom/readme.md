### Requirement
- Enable data binding
```
    buildFeatures{
        dataBinding = true
    }
```

- add lifecycle dependencies and apply kapt plugin (https://developer.android.com/jetpack/androidx/releases/lifecycle),(https://kotlinlang.org/docs/kapt.html#using-in-gradle)
```
plugin{
   id 'kotlin-kapt'
}

dependencies {
    def lifecycle_version = "2.4.0-rc01"

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    // Annotation processor
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")

}
```

- add room dependecies (https://developer.android.com/jetpack/androidx/releases/room)
```
dependencies {
    def room_version = "2.3.0"

    //Room
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor "androidx.room:room-compiler:$room_version"
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")

}
```

- add coroutines dependecies (https://github.com/Kotlin/kotlinx.coroutines)
```
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
}
```

- add windowSoftInputMode in manifest (my edit text is at bottom. so, the screen will be push upward when typing)
```
<application ... >
    <activity
        android:windowSoftInputMode="adjustPan" ... >
        ...
    </activity>
    ...
</application>
```
<br>

### Explanation
- Account List plus is an app where it list out all account with some improvement. Now we can create account and save on local. 
Account data can be retrieved even apps is killed and will be shown in recycler view. We will be using Room and Flow to save and emit data. 
room make our job easier, meanwhile flow is built on top of coroutine which can be used to replace live data. We doesn't replace it completely as at the end of the day, 
we still need convert it to Live data again to display. Throught this project we also learn interaction of data from database with view from start to end. It is better you follow
first account list project to understand how recycler view work 

- This project use:
  - Data Binding
  - Recycler View
  - Flow 
  - Coroutine
  - Room
  
- everything else explain in this project
- bear in mind this project only for my future refrence. Nothing fancy, only barebone explanation
- If something wrong with my code or explanation, feel free to tell me. i am just a noob guys


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
