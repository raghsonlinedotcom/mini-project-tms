# Problem Statement - Agile Teamwork

Feature - Profile Re/Inactivation

Situation - portion of the feature (Backend, Database) was completed and
checked into the feature branch, whereas the other aspect of the
feature (UI) is not yet ready.

## Challenge

When we try to update the employee details, it broke/failed with a NPE as follows.

```java
java.lang.NullPointerException
	com.raghsonline.miniprojects.tms.web.ManagerUpdateMemberServlet.validateReasonField(ManagerUpdateMemberServlet.java:351)
	com.raghsonline.miniprojects.tms.web.ManagerUpdateMemberServlet.doPost(ManagerUpdateMemberServlet.java:160)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:681)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)
	com.raghsonline.tutorials.filter.DemoFilter1.doFilter(DemoFilter1.java:46)
	com.raghsonline.miniprojects.tms.web.LoginFilter.doFilter(LoginFilter.java:117)
```

## Root Cause

The UI page does not have a placeholder to capture the Reason for the Reactivation or Inactivation,
and it was a mandatory field, and the Manager did not have an opportunity to supply the required input.
Hence it broke the flow in the backend.

## Solution

How do we solve this issue or handle this situation better?


* Talk to the team members and get a commitment by when everyone will be pushing
	their respective code, and push it together
* In case there is a challenge for someone, the rest of the others should hold on
	to their check in until everyone is ready.
* Offer a helping hand to the person facing challenges, so that the things can be
	completed soon
* All these okay, and manageable.. still there is a problem!!
	How long one should keep the code in local machine? What is someone's PC gets crashed?
	POTENTIAL LOSS OF THE SOURCE CODE!
* Best Solution
	- Create a temp feature branch for this Jira Story (both local and remote). Ex, we can name the
		branch as "feature/Profile-Reactivation" OR  "temp/feature/Profile-Reactivation"
	- Whoever has completed their code, can push into the remote repository of the temp feature branch
	- Once everyone has completed their changes, the remote feature branch is in good standing to merge
	- Merge the code from the remote temp feature to the remote feature branch of the Sprint.
		 - The main branch can also be called as *Mainstream* branch, *Release* branch etc., - the branch
		 	from which the source code will be released / deployed to the Servers. (QA, UAT, PROD etc., )
		 - Source Branch for Merging : Temp feature branch "temp/feature/Profile-Reactivation"
		 - Target Branch for Merging : Main Feature branch ("feature/leave-request")
