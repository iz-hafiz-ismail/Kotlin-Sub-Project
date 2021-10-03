### Requirement
- all method in data binding(Yes, this project use data binding)
- add dependencies in gradle

```
def nav_version = "2.3.5"

// Kotlin
implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
```

-add dependencies in build scriptpt inside gradle

```
buildscript {
    dependencies {
        def nav_version = "2.3.5"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}
```

- add plugins 

```
plugins {
    id("androidx.navigation.safeargs.kotlin")
}
```


Extra (Optional, only use if you want shared element transition)
Shared element transition (nav component ver)

-add dependency

```
implementation 'androidx.navigation:navigation-fragment-ktx:2.2.0'
```

- open both layout xml(A and B) and set transition name for target image view

```
android:transitionName="sharedElementTransitionStart"
```

- code for A class
add animation stuff when navigate

```
	binding.imageView.setOnClickListener{
            val extras = FragmentNavigatorExtras(
                binding.imageView to "sharedElementTransition"
            )
            it.findNavController().navigate(R.id.action_settingFragment_to_imageViewFragment, null, null, extras)
        }
```

- code for B class
add shared element enter transition in oncreate method

```
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }
```

<br>

### Explanation
- Setting Navigation is simple app to view profile in setting. Actually, it was my mistake for putting wrong name ;). So, this app was to help me learning how to use Navigation Architecture Component where as using single activity with multiple fragment. Nav host handle some stuff which make it easier to navigate between component and manage the fragment. For this project, I just use simple method but remember to use view model for real project as it was the best practice set by google.

- This project use:
  - Data Binding
  - Navigation Component Architecture
  - Shared Element Transition
  
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
