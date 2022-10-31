
As a user uses your app, as he/she navigates through, out of and back to your app, the Activity instances in your app transitions through different states in their lifecycle. The Activity class provides a number of callbacks to allow the activity to know that a state has changed. These might be that the system is creating, stopping or resuming an activity , or destroying the process in which the activity resides in due various reasons.
Within the lifecycle callback methods, you can declare how your activity behaves when the user leaves and re-enters the activity. The callbacks provided by the Activity class are onCreate(), onStart(), onResume(), onPause(), onStop(), and onDestroy(). The systems invokes each of these callbacks as an activity enters a new state.
   onCreate():
        This is the callback that gets called when the system firsts creates an activity.
    
   onStart():
        The onStart() call makes the activity visible to the user, as the app prepares for the activity to enter the foreground and become interactive. 
   
   onResume():
      When the activity enters the Resumed state, it comes to the foreground, and then the system invokes the onResume() callback. This is the state in which the app interacts with the user.
      The app stays in this state until something happens to take focus away from the app. Such an event might be, for instance, receiving a phone call, the user’s navigating to another activity, or the device screen’s turning off.
      
   onPause():
      The system calls this method as the first indication that the user is leaving your activity (though it does not always mean the activity is being destroyed); it indicates that the activity is no longer in the foreground (though it may still be visible if the user is in multi-window mode).
      Use the onPause() method to pause or adjust operations that should not continue (or should continue in moderation) while the Activity is in the Paused state, and that you expect to resume shortly. 

   onStop():
      When your activity is no longer visible to the user, it has entered the Stopped state, and the system invokes the onStop() callback. 
      This may occur, for example, when a newly launched activity covers the entire screen. The system may also call onStop() when the activity has finished running, and is about to be terminated.

   onDestroy():
       onDestroy() is called before the activity is destroyed. The system invokes this callback either because:
          1)the activity is finishing (due to the user completely dismissing the activity or due to finish() being called on the activity), or
          2)the system is temporarily destroying the activity due to a configuration change (such as device rotation or multi-window mode)
          3)When the activity moves to the destroyed state, any lifecycle-aware component tied to the activity's lifecycle will receive the ON_DESTROY event. This is where the lifecycle components can clean up anything it needs to before the Activity is destroyed.
