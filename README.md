# Disaster Response And Coordination (DiRAC) - codefundo++
### Team Members
1. Suhas Prasanna
2. Ajay Subramanian
-------------------------
### Idea:
**DiRAC** is an app that can facilitate collaboration between authorities and various Non-Govermental organizations that provide relief and emergency aid when a region is affected by a natural disaster. It is also a forum for those in the affected areas to air their thoughts and grievances to the concerned authorities.

### Background:
There is a distinct lack of coordination between authorities and other organizations that provide aid during a natural disaster. What this leads to many a time, is the duplication of efforts in certain areas and the neglection of other affected areas [[Tchouakeu et al](https://pdfs.semanticscholar.org/8d87/dff98427936db92f61d941eed1608f348dcf.pdf)]. In most cases, there does not exist a centralized framework of communication between NGO's and the government authorities. We therefore think that there is the need for an effective tool that bridges this gap.

### Our Plan:
We plan to design an Android mobile app through which we aim to solve the issues discussed above. The following forms the core of our app.
* A **regional group-based discussion forum** where people in the affected areas can post threads pertaining to specific problems or needs, to which the authorities and other aid-providing agencies from that region, can respond. Prioritization of these threads will be based on an upvote system.
* A common database of the amount of resources provided to each area, which is fed to the app by the authorities or NGO's responsible. For example, If an NGO provides 100 kgs of food aid to a particular area, it will be logged into the database and visible to all concerned authorities even in other areas. The app will also build a **visualization of the resource allocation** so that further efforts can be coordinated efficiently.
* Important information such as location of shelters in an area, emergency contacts, etc. will stay at the top of the feed(for observability) as **announcements** and stored locally to be accessible online and offline (using Firebase and Realm database services).
