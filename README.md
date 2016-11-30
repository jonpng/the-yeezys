# the-yeezys
INSTALL USING final.dmg  
Sorry no EXE Windows Users, you can run final.jar though.  
The jar is located in:
```
/final/build/libs/final.jar
```
Download the repo and run it. (Yeah, it works better on a mac. Oh well.)

---

Hi. final is the folder structure for the application, M4 is the folder structure for our coding.
To build the app, navigate to /final in the terminal and run:
```
gradle assemble
```

The final app is going to be located in:
```
/final/build/distributions/bundles/final.app
```

---
We already have a dmg for installation in the top level of this repo.

This doesn't work in windows btw, as of now. Probably never after this semester.

username: testuser  
password: password


---



Do not import the files. You can get access to them just by opening the file location.

Then build and run using:
```
Build -> Make Project
Run -> Run 'fxapp.MainFXApplication'
```

To run tasks in the gradle files, you gotta do:
```
gradle -b <file.gradle> <task>
```

All files relating to M2 are in the M2 folder and zip folder.