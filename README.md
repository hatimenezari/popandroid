# Pop

pop for people ops: app for CTOs/VPs of Engineering to manage people ops matters (leaves, timesheet, billing, 1-on-1s, team trips etc...)

![login screen](https://github.com/hatimenezari/popandroid/blob/master/screenshots/login.png)

## Managing the team

After authentication, the user lands on the team management page :

![login screen](https://github.com/hatimenezari/popandroid/blob/master/screenshots/rclv.png)

Here they can see the availability of each member and some other basic informations. Additionaly selecting one member takes you to a personal information page with more details and a personal timesheet:

![login screen](https://github.com/hatimenezari/popandroid/blob/master/screenshots/personalInfo.png) ![login screen](https://github.com/hatimenezari/popandroid/blob/master/screenshots/calendar.png)

## Leaves

This application also allows the user to see the pending leave requests, as well as the ones that were accepted or denied.
They can decide whether to accept or deny the upcoming requests:

![login screen](https://github.com/hatimenezari/popandroid/blob/master/screenshots/all_leaves.png) ![login screen](https://github.com/hatimenezari/popandroid/blob/master/screenshots/pending_leaves.png)


## Overview screen

in progress


### Techs and architecture

The developement of this app was done following an MVVM architecture using the following stack:
* [Kotlin](https://kotlinlang.org/)
* Android architecture components: ViewModel, LiveData, SharedPreferences
* [Glide](https://github.com/bumptech/glide)
* [Retrofit](http://square.github.io/retrofit/)
* [Gson](https://github.com/google/gson)
* [material-calendarview](https://github.com/prolificinteractive/material-calendarview)
