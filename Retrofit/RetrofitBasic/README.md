### Requirement
- Enable data binding
```
    buildFeatures{
        dataBinding = true
    }
```

- install retrofit dependecies (https://github.com/square/retrofit , https://search.maven.org/artifact/com.squareup.okhttp3/okhttp-urlconnection/4.0.1/jar , https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor)
```
dependencies {
    def retrofit = "2.9.0"
    
    //retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.2")
    implementation("com.squareup.okhttp3:okhttp-urlconnection:4.0.1")
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

- add coroutines dependecies (https://github.com/Kotlin/kotlinx.coroutines)
```
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
}
```

- add glide dependecies (https://github.com/bumptech/glide)
```
dependencies {
  implementation 'com.github.bumptech.glide:glide:4.12.0'
  annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
}
```

- add some permission in manifest file
```
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
```

- add shimmer dependecies (https://facebook.github.io/shimmer-android/)
```
dependencies {
  implementation 'com.facebook.shimmer:shimmer:0.5.0'
}
```



<br>

### Explanation
- Album is and apps to view photo that has been categorize based on user. As the name of the apps suggest, it only just to view image. I am using Retrofit to retrieve data from API call and Glide for displaying image from URL. The sorce of data is from https://jsonplaceholder.typicode.com/ where they provide user,album and photo but for some reason photo URL doesnt provide meaningful data when been called so i replaced  the source of image with random image from https://picsum.photos/. Shimmer effect also been used as placeholder when image is loading. This project don't follow real MVVM architecture as it only for basic retrofit.


- This project use:
  - Data Binding
  - Live Data
  - Recycler View
  - Coroutine
  - GLide
  - Shimmer effect
  
- everything else explain in this project
- bear in mind this project only for my future refrence. Nothing fancy, only barebone explanation
- If something wrong with my code or explanation, feel free to tell me. i am just a noob guys

<br>

### Extra
- I have issue with displaying with a lot of data at same time so, I limit the album viewing only 2 albums for each user. The best way for handling this using pagination, but the API i'm using not support pagination. For next time i suppose to include how to use Jetpack Pagination

- I also not caching the data as the photo is randomized so it change everytime it evrytime details activity is started


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
