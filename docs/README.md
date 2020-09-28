# User Guide
Julia is an **interactive chat bot** that is able to help you manage and store your daily tasks, **optimised for
use via a Command Line Interface** (CLI)
___
## Quick Start
1. Ensure that you have Java `11` or above installed in your Computer.
2. Download the latest `julia.jar` here.
3. Save the file to your desired folder.
4. Open the Command Prompt in that folder.
5. Run `chcp 65001` to change the active code page.
6. Right click the top bar in your Command Prompt and click `properties`
7. Click the `Fonts` tab and change the font to `NSimSun`.
8. Run `java -Dfile.encoding=UTF-8 -jar julia.jar` to start Julia the chat bot.
9. Type the command in the command line and press Enter to execute it. e.g. typing `help` and pressing Enter will 
display a list of commands that you can use.
10. Refer to the Features below for details of each command.


## Features Overview
**Notes about the command format**
* Words in `UPPER_CASE` are the parameters to be supplied by user.
e.g. in `deadline TASK_NAME /by DEADLINE`, `TASK_NAME` and `DEADLINE` are parameters which can be used as `deadline 
Tutorial /by tomorrow`.
* Commands are all case-sensitive and have to be in lower case.
* There are 3 different categories of commands for Julia the chat bot as follows:

Basic Commands | Adding Tasks | List Navigation 
------------ | ------------- | -------------
`help` | `todo` | `list`
`bye` | `event` | `dates` 
- | `deadline` | `find`
- | - | `done`
- | - | `delete`

## Basic Commands

### Viewing help - `help`

Displays a list of commands that user can use for Julia the chat bot.

Format: `help`

Example of usage: 

`help`

Expected outcome:

```
____________________________________________________________
Here is the list of commands that you can use: 
[bye]         to exit the chat bot
[dates]       to view tasks with dates attached to it
[deadline]    to add a deadline type task
[delete]      to delete a task from the list
[done]        to mark off a task as done from the list
[event]       to add an event type task
[find]        to find tasks with matching keyword in the list
[help]        to list commands available for use
[list]        to view the list of tasks
[todo]        to add a todo type task
____________________________________________________________
```

### Exiting the programme - `bye`

Exits Julia the chat bot program.

Format: `bye`

Example of usage: 

`bye`

Expected outcome:
```
____________________________________________________________
Goodbye! I look forward to seeing you the next time!
____________________________________________________________
```

## Adding tasks

### Adding todo task - `todo`

Adds a new todo type task to the list.

Format: `todo TASK_NAME`

Example of usage: 

`todo Tutorials for this week`

Expected outcome:

```
____________________________________________________________
Okay, I have added the following into the list for you!
-> Ⓣ ✘ Tutorials for this week
Now you have 1 task in the list.
____________________________________________________________
```
### Adding event task - `event`

Adds a new event type task to the list.

Format: `event TASK_NAME /at EVENT_DATE `

Example of usage: 

`event CG2271 finals /at 2020-11-26`


Expected outcome:

```
____________________________________________________________
Okay, I have added the following into the list for you!
-> Ⓔ ✘ CG2271 finals (at: Nov 26 2020)
Now you have 2 tasks in the list.
____________________________________________________________
```

### Adding deadline task - `deadline`

Adds a new deadline type task to the list.

Format: `deadline TASK_NAME /by DUE_DATE `

Example of usage: 

`deadline Math homework /by Monday`

Expected outcome:

```
____________________________________________________________
Okay, I have added the following into the list for you!
-> Ⓓ ✘ Math homework (by: Monday)
Now you have 3 tasks in the list.
____________________________________________________________
```

## List Navigation

### Displaying task list - `list`

Displays all the tasks in the list currently.

Format: `list`

Example of usage: 

`list`

Expected outcome(s):
* When the list is empty:
```
____________________________________________________________
Looks like you have no task yet!
Feel free to continue adding to the list! :)
____________________________________________________________
```
* When the list contains task(s):
```
____________________________________________________________
Here is the collated list of your tasks:
(1) Ⓣ ✘ Tutorials for this week
(2) Ⓔ ✘ CG2271 finals (at: Nov 26 2020)
(3) Ⓓ ✘ Math homework (by: Monday)
Feel free to continue adding to the list! :)
____________________________________________________________
```

### Displaying tasks with dates attached - `dates`

Displays all the tasks that have dates attached to it in the list currently.

Format: `dates`

Example of usage: 

`dates`

Expected outcome(s):
* When the list is empty:
```
____________________________________________________________
Looks like you have no task with dates yet!
Feel free to continue adding to the list! :)
____________________________________________________________
```
* When the list contains task(s) with date:
```
____________________________________________________________
Here is the collated list of your tasks with dates:
(2) Ⓔ ✘ CG2271 finals (at: Nov 26 2020)
Feel free to continue adding to the list! :)
____________________________________________________________
```

### Finding tasks using keyword - `find`

Finds a task by searching for a keyword

Format: `find KEYWORD`

Example of usage: 

`find homework`

Expected outcome(s):
* When there is no result:
```
____________________________________________________________
Unable to find a task with the keyword given
Feel free to continue adding to the list! :)
____________________________________________________________
```
* When the list contains the given keyword:
```
____________________________________________________________
(1) Ⓓ ✘ Math homework (by: Monday)
Feel free to continue adding to the list! :)
____________________________________________________________
```
### Marking task as done - `done`

Marks a task in the list as done.

Format: `done TASK_INDEX`

Example of usage: 

`done 2`

Expected outcome(s):
* When there is no such index in the list:
```
____________________________________________________________
No such task found, try again?
____________________________________________________________
```
* When task index is found in the list:
```
____________________________________________________________
Good job! I checked this off the list for you:
Ⓔ ✓ CG2271 finals (at: Nov 26 2020)
____________________________________________________________
```
### Deleting a task from the list - `delete`

Deletes a task from the list of tasks.

Format: `delete TASK_INDEX`

Example of usage: 

`delete 2`

Expected outcome(s):
* When there is no such index in the list:
```
____________________________________________________________
No such task found, try again?
____________________________________________________________
```
* When task index is found in the list:
```
____________________________________________________________
Okay, I've removed this task: 
Ⓔ ✓ CG2271 finals (at: Nov 26 2020)
Now you have 2 tasks in the list.
____________________________________________________________
```
## FAQ
**Q:** Can I transfer my data to another Computer?
**A:** Yes. Simply set up `julia.jar` on your other device and copy over the
`duke.txt` file in the same home folder.

## Command Summary
Command | Format, Examples
------------ | -------------
`bye` | `bye`
`dates` | `dates`
`deadline` | `deadline TASK_NAME /by DUE_DATE` e.g. `deadline Math homework /by Monday`
`delete` | `delete TASK_INDEX` e.g. `delete 2`
`done` | `done TASK_INDEX` e.g. `done 2`
`event` | `event TASK_NAME /at EVENT_DATE` e.g. `event CG2271 finals /at 2020-11-26`
`find` | `find KEYWORD` e.g. `find homework`
`help` | `help`
`list` | `list`
`todo` | `todo TASK_NAME` e.g. `todo Tutorials for this week`






