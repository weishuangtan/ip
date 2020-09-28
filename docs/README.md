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
___
## Features Overview
**Notes about the command format**
* Words in `UPPER_CASE` are the parameters to be supplied by user.
e.g. in `deadline TASK_NAME /by DEADLINE`, `TASK_NAME` and `DEADLINE` are parameters which can be used as `deadline Tutorial \by
tomorrow`.
* Commands are all case-sensitive and have to be in lower case.
* There are 3 different categories of commands for Julia the chat bot as follows:

Basic Commands | Adding Tasks | List Navigation 
------------ | ------------- | -------------
`help` | `todo` | `list`
`bye` | `event` | `dates` 
- | `deadline` | `find`
- | - | `delete`
___
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
[help]        to list commands available for use
[list]        to view the list of tasks
[todo]        to add a todo type task
[event]       to add an event type task
[deadline]    to add a deadline type task
[delete]      to delete a task from the list
[find]        to find tasks with matching keyword in the list
[dates]       to view tasks with dates attached to it
[bye]         to exit the chat bot
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
___
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






