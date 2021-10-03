### Requirement
- all method in data binding(Yes, this project use data binding)


<br>

### Explanation
- Account List is an app where it list out all acoount. We can add account by clicking add button(account randomly generated with unique id). Account data will be shown in recycler view. If user click on account data list, the data will be delete based on account that has been click. From this project we can learn how to pass arraylist and listener object from main activity to recycler view adapter. The click listner was pass using lamda expression. We also learn how to make custom adapter for recycler view and how to use recycler view with data binding method.

- This project use:
  - Data Binding
  - Recycler View
  
- everything else explain in this project
- bear in mind this project only for my future refrence. Nothing fancy, only barebone explanation
- If something wrong with my code or explanation, feel free to tell me. i am just a noob guys


<br>

### Issue
- I have issue with deleting data as it showing unexisting data sometime when i'm notifyItemRemoved or notifyDataSetChanged 
- When i'm using notifyItemRemoved(Int Index), if all data has been delete, the recycler view stop working properly and caused app to crash when certain behaviour was done
- My current fix was recreate recycler view adapter everytime data has been deleted, maybe i will try to find true way to handle this issue  


<br>

### Extra
- I'm overide getItemViewType sub class in recycle view to avoiditem in recycler view switching when scrolling. 
- From my reading in stack overflow it will effect performance as it kind of defeat the purpose of having recyccler view  
```
override fun getItemViewType(position: Int): Int {
    return position
}
```



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
