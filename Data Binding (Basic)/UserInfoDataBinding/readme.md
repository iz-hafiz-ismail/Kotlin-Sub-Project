### Requirement
- enable data binding in build features block in gradle file
(Android Gradle Plugin 4.0.0-alpha05 and above)

```
android {
    buildFeatures{
      dataBinding = true
    }
}
```

- data binding name format 
> activity_main   -> ActivityMainBinding (class) <br>
> textview_name   -> textviewName (component) 
